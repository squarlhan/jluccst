package com.boan.crm.sms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.sms.dao.ISMSCustomerInfoDao;
import com.boan.crm.sms.model.SMSCustomerInfo;
import com.boan.crm.sms.service.ISMSCustomerInfoService;

@Service("SMSCustomerInfoService")
public class SMSCustomerInfoServiceImpl implements ISMSCustomerInfoService {

	@Autowired
	@Qualifier("SMSCustomerInfoDao")
	private ISMSCustomerInfoDao dao;
	
	/**
	 * 保存短信通讯录信息
	 * @param info
	 */
	public void saveSMSCustomerInfo(SMSCustomerInfo info){
		dao.save(info);
	}
	
	/**
	 * 修改短信通讯录信息
	 * @param info
	 */
	public void updateSMSCustomerInfo(SMSCustomerInfo info){
		dao.update(info);
	}
	
	/**
	 * 修改短信通讯录信息状态
	 * @param id
	 * @param state
	 */
	public void updateSMSCustomerInfoState(String id,int state){
		
	}
	
	/**
	 * 删除短信通讯录信息
	 * @param ids
	 */
	public void deleteSMSCustomerInfo(String... ids){
		dao.delete(ids);
	}
	
	/**
	 * 查询所有短信通讯录信息
	 * @return
	 */
	public List<SMSCustomerInfo> findAllSMSCustomerInfo() {
		return dao.find("from SMSCustomerInfo order by registerTime asc", new Object[0]);
	}
	
	/**
	 * 查询所有短信通讯录信息
	 * @return
	 */
	public int findSMSCustomerInfoCountForPage( Map<String, ?> values){
		String nameSpell="";
		if(values.containsKey("nameSpell")){
			nameSpell=" and nameSpell like '%"+values.get("nameSpell")+"%'";
		}
		String categoryId="";
		if(values.containsKey("categoryId")){
			categoryId=" and categoryId=:categoryId ";
		}
		String hql = "select count(*)  from SMSCustomerInfo where 1=1 "+nameSpell+categoryId+" and salesmanId=:salesmanId order by createTime desc";
		int totalRows = dao.findCountForPage(hql, values);
		return totalRows;
	}

	/**
	 * 分页查询短信通讯录信息
	 * @param values 参数
	 * @param currentlyPage 当前页码
	 * @param pageSize 每页条数
	 * @return 对象数组
	 */
	public List<SMSCustomerInfo> findSMSCustomerInfoForPage( Map<String, ?> values, int currentlyPage,int pageSize){
		String nameSpell="";
		if(values.containsKey("nameSpell")){
			nameSpell=" and nameSpell like '%"+values.get("nameSpell")+"%'";
		}
		String categoryId="";
		if(values.containsKey("categoryId")){
			categoryId=" and categoryId=:categoryId ";
		}
		String hql = "from SMSCustomerInfo where 1=1 "+nameSpell+categoryId+" and salesmanId=:salesmanId order by createTime desc";
		List<SMSCustomerInfo> data = dao.findForPage(hql, values, currentlyPage, pageSize);
		return data;
	}
	
	/**
	 * 通过人员Id查询对应人员信息
	 * @param ids ids数组
	 * @return 人员数组
	 */
	public List<SMSCustomerInfo> findSMSCustomerInfoByIds(String... ids){
		List<String> idLis = new ArrayList<String>();
		for(String id : ids){
			idLis.add(id);
		}
		return dao.get(idLis);
	}

}
