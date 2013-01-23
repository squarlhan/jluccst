package com.boan.crm.groupmanage.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.groupmanage.service.IPopedomService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.utils.action.BaseActionSupport;

@Controller("userSearchAction")
@Scope("prototype")
public class UserSearchAction extends BaseActionSupport {

	private String userName;
	
	private List<User> userList = new ArrayList<User>();
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;
	
	@Autowired
	@Qualifier("deptService")
	private IDeptmentService deptService = null;
	
	@Autowired
	@Qualifier("popedomService")
	private IPopedomService popedomService = null;
	
	
	/**
	 * 查询本公司下的用户
	 * @return
	 * @throws Exception 
	 */
	public String getUserNameByCompany() throws Exception{
//		try {
//			userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
//			userList = userService.queryUserListByUserName(sessionCompanyId, null ,userName);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
		userList = new ArrayList<User>();
		List<Deptment> deptList = new ArrayList<Deptment>();
		deptList = deptService.queryAllDeptmentsByCompanyId(sessionCompanyId);
		// 获取用户列表
		if (deptList != null && deptList.size() > 0) {
			List<User> tempUserList = new ArrayList<User>();
			for (int i = 0; i < deptList.size(); i++) {
				if(deptList.get(i)!=null){
					List<User> tempList = userService.queryUserListByUserName(sessionCompanyId, deptList.get(i).getId(),userName);
					if (tempList != null && tempList.size() > 0) {
						tempUserList.addAll(tempList);
					}
				}
			}
			if (tempUserList != null && tempUserList.size() > 0) {
				userList.addAll(tempUserList);
			}
		}
		return this.SUCCESS;
	}
	/**
	 * 查询本公司本部门下的用户
	 * @return
	 * @throws Exception 
	 */
	public String getUserNameByDept() throws Exception{
//		try {
//			userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
//			userList = userService.queryUserListByUserName(sessionCompanyId, sessionDeptId ,userName);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		
		userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
		userList = new ArrayList<User>();
		List<Deptment> deptList = new ArrayList<Deptment>();
		deptList.add(deptService.get(sessionDeptId));
		// 获取用户列表
		if (deptList != null && deptList.size() > 0) {
			List<User> tempUserList = new ArrayList<User>();
			for (int i = 0; i < deptList.size(); i++) {
				if(deptList.get(i)!=null){
					List<User> tempList = userService.queryUserListByUserName(sessionCompanyId, deptList.get(i).getId(),userName);
					if (tempList != null && tempList.size() > 0) {
						tempUserList.addAll(tempList);
					}
				}
			}
			if (tempUserList != null && tempUserList.size() > 0) {
				userList.addAll(tempUserList);
			}
		}
		return this.SUCCESS;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
