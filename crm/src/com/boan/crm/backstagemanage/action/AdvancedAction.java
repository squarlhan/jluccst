/**
 * Copyright (c) 2011 Changchun BOAN Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)AdvancedAction.java 1.1 2011-8-30
 */
package com.boan.crm.backstagemanage.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.backstagemanage.common.ExportUtil;
import com.boan.crm.backstagemanage.model.Company;
import com.boan.crm.backstagemanage.service.ICompanyService;
import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.model.EkeyQueryCondition;
import com.boan.crm.groupmanage.model.EkeyUser;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.groupmanage.service.IEkeyUserService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * 高级用户使用Action
 * 
 * @author XXX
 * @version 1.0.0
 */
@Controller("advancedAction")
@Scope("prototype")
public class AdvancedAction extends BaseActionSupport {

	private static final long serialVersionUID = -1593536024863886109L;
	@Autowired
	@Qualifier("ekeyUserService")
	private IEkeyUserService ekeyService = null;
	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;
	@Autowired
	@Qualifier("companyService")
	private ICompanyService companyService = null;
	@Autowired
	@Qualifier("deptService")
	private IDeptmentService deptService = null;
	private Pagination<User> pagination = new Pagination<User>();
	private String userId;
	private String deptId = null;
	private String companyId = null;
	private List<EkeyUser> ekeyUserList = null;
	private List<User> userList = null;
	private InputStream archiveStream = null;
	private String exportFileName = null;
	private EkeyQueryCondition ekeyCondition = new EkeyQueryCondition();
	private File uploadFile = null;
	private String uploadFileFileName = null;
	private String uploadFileContentType = null;
	private String message;

	/**
	 * 查询用户锁列表
	 * 
	 * @return 用户锁列表
	 * @throws Exception
	 */
	public String showEkeyUser() throws Exception {
		ekeyCondition = new EkeyQueryCondition();
		ekeyCondition.setCompanyId(companyId);
		ekeyCondition.setDeptId(deptId);
		pagination.setPageSize(30);
		pagination = ekeyService.queryEkeyUserListByCondition(ekeyCondition, pagination);
		return "success-ekey-show";
	}

	/**
	 * @return 导出待写入Key的用户
	 * @throws Exception
	 */
	public String exportEkeyUser() throws Exception {
		userList = userService.queryAllUserListByCompanyId(companyId);
		// 取部门信息
		if (userList != null && userList.size() > 0) {
			for (int i = 0; i < userList.size(); i++) {
				Deptment dept = deptService.get(userList.get(i).getDeptId());
				userList.get(i).setDept(dept);
			}
		}
		archiveStream = ExportUtil.exportEkeyUser(userList);
		String companyName = null;
		Company com = companyService.get(companyId);
		if (com != null) {
			companyName = com.getCompanyName();
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		exportFileName = "待写锁用户-" + companyName + "-" + format.format(Calendar.getInstance().getTime()) + ".dat";
		exportFileName = new String(exportFileName.getBytes(), "ISO8859-1");
		return "export-success";
	}

	/**
	 * 清除锁数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public String clearEkeyData() throws Exception {
		try {
			ekeyService.deleteUserEkeyData(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.showEkeyUser();

	}

	/**
	 * @return 导入待写锁用户
	 * @throws Exception
	 */
	public String importEkeyUser() throws Exception {
		List<EkeyUser> ekeyUserList = new ArrayList<EkeyUser>();
		boolean realEkeyFileFlag = false;
		if (uploadFile != null && uploadFileFileName != null && uploadFileFileName.indexOf(".") != -1) {
			String fileName = uploadFileFileName.substring(0, uploadFileFileName.lastIndexOf("."));
			String fileType = uploadFileFileName.substring(uploadFileFileName.lastIndexOf("."));
			if (!"".equals(fileName) && ".dat".equals(fileType.toLowerCase())) {
				realEkeyFileFlag = true;
			}
		}
		int line = 0;
		if (realEkeyFileFlag) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(uploadFile), "UTF-8"));
			String lineString = null;
			while ((lineString = reader.readLine()) != null) {
				if (line == 0) {
					byte[] lineOneFlag = lineString.getBytes();
					if (lineOneFlag != null && lineOneFlag.length == 1 && lineOneFlag[0] == 63) {
						realEkeyFileFlag = false;
						line++;
						continue;
					} else {
						realEkeyFileFlag = false;
						break;
					}
				}

				if (lineString == null || "".equals(lineString)) {
					realEkeyFileFlag = false;
					break;
				}
				String[] snAndKeyAndId = lineString.split("\\|");
				if (snAndKeyAndId.length != 3) {
					realEkeyFileFlag = false;
					break;
				}
				String sn = snAndKeyAndId[0];
				String key = snAndKeyAndId[1];
				String userId = snAndKeyAndId[2];

				if (userService.getUserById(userId) != null) {
					EkeyUser ekeyUser = new EkeyUser();
					ekeyUser.setSn(sn);
					ekeyUser.setKey(key);
					ekeyUser.setUserId(userId);
					ekeyUserList.add(ekeyUser);
				} else {
					realEkeyFileFlag = false;
					continue;
				}
				realEkeyFileFlag = true;
				line++;
			}
			reader.close();
		}
		realEkeyFileFlag = (line > 1);
		if (realEkeyFileFlag && ekeyUserList != null && ekeyUserList.size() > 0) {
			for (EkeyUser ekeyUser : ekeyUserList) {
				ekeyService.saveOrUpdateEkeyUser(ekeyUser);
			}
			message = "导入成功，共导入[" + ekeyUserList.size() + "]条记录。";
		} else {
			message = "导入失败，不是有效的用户锁文件。";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", message);
		return "success-ekey-import";
	}

	/**
	 * @return 返回 archiveStream
	 */
	public InputStream getArchiveStream() {
		return archiveStream;
	}

	/**
	 * 设置 archiveStream
	 * 
	 * @param archiveStream
	 */
	public void setArchiveStream(InputStream archiveStream) {
		this.archiveStream = archiveStream;
	}

	/**
	 * @return 返回 exportFileName
	 */
	public String getExportFileName() {
		return exportFileName;
	}

	/**
	 * 设置 exportFileName
	 * 
	 * @param exportFileName
	 */
	public void setExportFileName(String exportFileName) {
		this.exportFileName = exportFileName;
	}

	/**
	 * @return 返回 uploadFile
	 */
	public File getUploadFile() {
		return uploadFile;
	}

	/**
	 * 设置 uploadFile
	 * 
	 * @param uploadFile
	 */
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	/**
	 * @return 返回 uploadFileFileName
	 */
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	/**
	 * 设置 uploadFileFileName
	 * 
	 * @param uploadFileFileName
	 */
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	/**
	 * @return 返回 uploadFileContentType
	 */
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	/**
	 * 设置 uploadFileContentType
	 * 
	 * @param uploadFileContentType
	 */
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	/**
	 * @return 返回 message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 设置 message
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return 返回 ekeyService
	 */
	public IEkeyUserService getEkeyService() {
		return ekeyService;
	}

	/**
	 * 设置 ekeyService
	 * 
	 * @param ekeyService
	 */
	public void setEkeyService(IEkeyUserService ekeyService) {
		this.ekeyService = ekeyService;
	}

	/**
	 * @return 返回 ekeyCondition
	 */
	public EkeyQueryCondition getEkeyCondition() {
		return ekeyCondition;
	}

	/**
	 * 设置 ekeyCondition
	 * 
	 * @param ekeyCondition
	 */
	public void setEkeyCondition(EkeyQueryCondition ekeyCondition) {
		this.ekeyCondition = ekeyCondition;
	}

	/**
	 * @return 返回 ekeyUserList
	 */
	public List<EkeyUser> getEkeyUserList() {
		return ekeyUserList;
	}

	/**
	 * 设置 ekeyUserList
	 * 
	 * @param ekeyUserList
	 */
	public void setEkeyUserList(List<EkeyUser> ekeyUserList) {
		this.ekeyUserList = ekeyUserList;
	}

	/**
	 * @return 返回 userService
	 */
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * 设置 userService
	 * 
	 * @param userService
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public Pagination<User> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<User> pagination) {
		this.pagination = pagination;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
