/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.crm.datadictionary.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.utils.action.BaseActionSupport;


/**
 * 数据字典Action类
 * 
 * @author leon
 * @version 1.0.0
 */
@Controller("dataDictionaryAction")
@Scope("prototype")
public class DataDictionaryAction extends BaseActionSupport {
	private static final long serialVersionUID = -8330905492715338520L;

	@Resource
	// 客户状态接口类
	private IDataDictionaryService dataDictionaryService;
	
	//客户状态对象
	private DataDictionary dataDictionary = null;
	
	List<DataDictionary> dataDictionarys = null;
	
	List<DictionaryType> dictionaryTypes = null;
	
	private String dictId;
	private Integer typeFlag;
	private String name;
	private String remark;
	
	private String[] dictIds;
	private String message;
	private int userType;
	
	private List<DictionaryType> loadDictionaryTypes(){
		List<DictionaryType> list = new ArrayList<DictionaryType>();
		DictionaryType dictionaryType = new DictionaryType(0,"客户分类");
		list.add(dictionaryType);
		dictionaryType = new DictionaryType(1,"客户状态");
		list.add(dictionaryType);
		dictionaryType = new DictionaryType(2,"客户来源");
		list.add(dictionaryType);
		dictionaryType = new DictionaryType(3,"主营行业");
		list.add(dictionaryType);
		dictionaryType = new DictionaryType(4,"客户成熟度");
		list.add(dictionaryType);
		return list;
	}
	
	/**
	 * 客户类别集合
	 * @return
	 */
	public String dataDictionaryList(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		userType = userSession.getUserType();
		dataDictionarys = dataDictionaryService.findDataDictionaryByType(sessionCompanyId, typeFlag);
		return SUCCESS;
	}
	
	/**
	 * 获得数据字典信息
	 * @return
	 */
	public String dataDictionaryInfo(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		userType = userSession.getUserType();
		if(StringUtils.trimToNull(dictId)!=null)
			dataDictionary = dataDictionaryService.get(dictId);
		else
			dataDictionary = new DataDictionary();
		return SUCCESS;
	}
	
	/**
	 * 保存信息
	 * @return
	 */
	public String saveDataDictionary(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		userType = userSession.getUserType();
		if(StringUtils.trimToNull(dictId)!=null){
			dataDictionary = dataDictionaryService.get(dictId);
			this.message = "保存成功！";
		}else{
			dataDictionary = new DataDictionary();
			this.message = "添加成功！";
		}
		dataDictionary.setCompanyId(sessionCompanyId);
		dataDictionary.setTypeFlag(typeFlag);
		dataDictionary.setName(name);
		dataDictionary.setRemark(remark);
		dataDictionaryService.save(dataDictionary);
		dictId = dataDictionary.getId();
		return SUCCESS;
	}
	
	/**
	 * 删除数据字典信息
	 * @return
	 */
	public String deleteDataDictionary(){
		if(dictIds!=null){
			dataDictionaryService.deleteDataDictionary(dictIds);
		}
		return SUCCESS;
	}
	
	/**
	 * 排序
	 * @return
	 */
	public String dataDictionarySort(){
		dataDictionarys = dataDictionaryService.findDataDictionaryByType(sessionCompanyId, typeFlag);
		return SUCCESS;
	}
	
	/**
	 * 保存排序
	 * @return
	 */
	public String saveDataDictionarySort(){
		if(dictIds!=null&&dictIds.length>0){
			DataDictionary ct = null;
			for(int i=0; i<dictIds.length; i++){
				dataDictionary = dataDictionaryService.get(dictIds[i]);
				dataDictionary.setSortIndex(i);
				dataDictionaryService.save(dataDictionary);
			}
			this.message = "排序成功！";
		}
		return SUCCESS;
	}
	
	public class DictionaryType{
		private Integer flag = 0;
		private String name;
		
		public DictionaryType(){};
		public DictionaryType(Integer flag, String name){
			this.flag = flag;
			this.name = name;
		}
		
		public Integer getFlag() {
			return flag;
		}
		public void setFlag(Integer flag) {
			this.flag = flag;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}

	public DataDictionary getDataDictionary() {
		return dataDictionary;
	}

	public void setDataDictionary(DataDictionary dataDictionary) {
		this.dataDictionary = dataDictionary;
	}

	public List<DataDictionary> getDataDictionarys() {
		return dataDictionarys;
	}

	public void setDataDictionarys(List<DataDictionary> dataDictionarys) {
		this.dataDictionarys = dataDictionarys;
	}

	public String getDictId() {
		return dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public Integer getTypeFlag() {
		return typeFlag;
	}

	public void setTypeFlag(Integer typeFlag) {
		this.typeFlag = typeFlag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String[] getDictIds() {
		return dictIds;
	}

	public void setDictIds(String[] dictIds) {
		this.dictIds = dictIds;
	}

	public List<DictionaryType> getDictionaryTypes() {
		return dictionaryTypes;
	}

	public void setDictionaryTypes(List<DictionaryType> dictionaryTypes) {
		this.dictionaryTypes = dictionaryTypes;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
	
}
