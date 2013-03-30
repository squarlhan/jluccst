package com.boan.crm.sms.service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.boan.crm.backstagemanage.model.Company;
import com.boan.crm.sms.model.SMSInfo;
import com.boan.crm.utils.page.Pagination;

/**
 * 短信管理Service接口
 * @author Administrator
 *
 */
public interface ISMSInfoService {
	
	/**
	 * 保存短信信息
	 * @param info
	 */
	public void saveSMSInfo(SMSInfo info);
	
	/**
	 *  获取单个短信信息
	 * @param id
	 */
	public SMSInfo getSMSInfo(String id);
	
	/**
	 *  通过销售记录Id获取短信信息
	 * @param id
	 */
	public SMSInfo getSMSInfoBySellRecordId(String sellRecordId);
	
	/**
	 * 通过销售记录Id删除短信信息
	 * @param ids
	 */
	public void deleteSMSInfoBySellRecordId(String... sellRecordId);
	
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
	
	/**
	 * 查询指定时间段内没有发送的短信
	 * @param beginTime 开始时间
	 * @param endTime 结束时间
	 * @param organId 短信所属公司
	 * @return
	 */
	public List<SMSInfo> findSMSInfoByTime(Calendar beginTime,Calendar endTime,String organId);
	
	/**
     * 分页查询短信记录
     * @return 短信记录数组
     */
	public Pagination<SMSInfo> findSMSInfoForPage(Map<String, ?> values, Pagination<SMSInfo> pagination);
}
