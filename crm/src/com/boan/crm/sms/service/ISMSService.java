package com.boan.crm.sms.service;

import com.boan.crm.sms.model.SMSInfo;

/**
 * 短信管理Service接口
 * @author Administrator
 *
 */
public interface ISMSService {
	
	/**
	 * 保存短信信息
	 * @param info
	 */
	public void saveSMSInfo(SMSInfo info);
	
	/**
	 * 修改短信信息
	 * @param info
	 */
	public void updateSMSInfo(SMSInfo info);
	
	/**
	 * 修改短信息状态
	 * @param id
	 * @param state
	 */
	public void updateSMSInfoState(String id,int state);
	
	/**
	 * 删除短信信息
	 * @param ids
	 */
	public void deleteSMSInfo(String... ids);
}
