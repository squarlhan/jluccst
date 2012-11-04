package com.boan.crm.sms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.sms.dao.ISMSCustomerInfoDao;
import com.boan.crm.sms.model.SMSCustomerInfo;
import com.boan.crm.sms.service.ISMSCustomerInfoService;
import com.boan.crm.utils.pinyin.PinYin4J;

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
		info.setNameSpell( PinYin4J.makeStringByStringSet(PinYin4J.getPinyin(info.getName())));
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
	 * 修改客户联系人时调用
	 * @param customerId
	 * @param info
	 */
	public void updateSMSCustomerInfoForCustomer(String customerId , SMSCustomerInfo info){
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("customerId", customerId);
		String hql ="from SMSCustomerInfo where customerId=:customerId ";
		List<SMSCustomerInfo> temp = dao.find(hql, values);
		String id=null;
		if(temp!=null && temp.size()>0 ){
			if(temp.get(0)!=null){
				id = temp.get(0).getId();
			}
		}
		info.setId(id);
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
	 * 删除短信通讯录信息（此方法用于客户删除是，删除短信客户表里面相应信息的）
	 * @param customerIds 客户表Id
	 */
	public void deleteSMSCustomerInfoFoCustomer(String... customerIds){
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("customerIds", customerIds);
		String hql="delete from SMSCustomerInfo where customerId in (:customerIds)";
		dao.executeHql(hql, values);
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
