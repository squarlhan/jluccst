package com.boan.crm.sms.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.sms.model.SMSCustomerInfo;

/**
 * 短信通讯录管理Service接口
 * @author Administrator
 *
 */
public interface ISMSCustomerInfoService {
	
	/**
	 * 保存短信通讯录信息
	 * @param info
	 */
	public void saveSMSCustomerInfo(SMSCustomerInfo info);
	
	/**
	 * 修改短信通讯录信息
	 * @param info
	 */
	public void updateSMSCustomerInfo(SMSCustomerInfo info);
	
	/**
	 * 修改短信通讯录信息状态
	 * @param id
	 * @param state
	 */
	public void updateSMSCustomerInfoState(String id,int state);
	
	/**
	 * 删除短信通讯录信息
	 * @param ids
	 */
	public void deleteSMSCustomerInfo(String... ids);
	
	/**
	 * 查询所有短信通讯录信息
	 * @return
	 */
	public List<SMSCustomerInfo> findAllSMSCustomerInfo();
	/**
	 * 查询所有短信通讯录信息
	 * @return
	 */
	public int findSMSCustomerInfoCountForPage( Map<String, ?> values);

	/**
	 * 分页查询短信通讯录信息
	 * @param values 参数
	 * @param currentlyPage 当前页码
	 * @param pageSize 每页条数
	 * @return 对象数组
	 */
	public List<SMSCustomerInfo> findSMSCustomerInfoForPage( Map<String, ?> values, int currentlyPage,int pageSize);
	
	/**
	 * 通过人员Id查询对应人员信息
	 * @param ids ids数组
	 * @return 人员数组
	 */
	public List<SMSCustomerInfo> findSMSCustomerInfoByIds(String... ids);
}
