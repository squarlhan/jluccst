package com.boan.crm.sms.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.sms.dao.ISMSInfoDao;
import com.boan.crm.sms.model.SMSInfo;
import com.boan.crm.sms.service.ISMSInfoService;
import com.boan.crm.utils.page.Pagination;

/**
 * 短信管理Service接口实现
 * @author Administrator
 *
 */
@Service("SMSInfoService")
public class SMSInfoServiceImpl implements ISMSInfoService{

	@Autowired
	@Qualifier("SMSInfoDao")
	private ISMSInfoDao dao;
	
	/**
	 * 保存短信信息
	 * @param info
	 */
	public void saveSMSInfo(SMSInfo info){
		dao.save(info);
	}
	
	/**
	 *  获取单个短信信息
	 * @param id
	 */
	public SMSInfo getSMSInfo(String id){
		SMSInfo info = dao.get(id);
		dao.clearSession();
		return info;
	}
	/**
	 *  通过销售记录Id获取短信信息
	 * @param id
	 */
	public SMSInfo getSMSInfoBySellRecordId(String sellRecordId){
		String hql = " from SMSInfo where (state=0 or state=1) and sellRecordId='"+sellRecordId+"'";
		List<SMSInfo> data = dao.find(hql);
		if(data!=null && data.size()>0){
			return data.get(0);
		}else{
			return null;
		}
	}
	/**
	 * 通过销售记录Id删除短信信息
	 * @param ids
	 */
	public void deleteSMSInfoBySellRecordId(String... sellRecordId){
		String hql = " delete from SMSInfo where (state=0 or state=1) and sellRecordId in (:sellRecordId)";
		Map<String, Object> values = new HashMap();
		values.put("sellRecordId", sellRecordId);
		dao.executeHql(hql , values);
	}
	
	
	/**
	 * 修改短信信息
	 * @param info
	 */
	public void updateSMSInfo(SMSInfo info){
		dao.update(info);
	}
	
	/**
	 * 修改短信息状态
	 * @param id
	 * @param state
	 */
	public void updateSMSInfoState(String id,int state){
		Map<String, Object> values = new HashMap();
		values.put("state", state);
		values.put("id", id);
		String hql = " update SMSInfo set state=:state where id=:id";
		dao.executeHql(hql , values);
	}
	
	/**
	 * 删除短信信息
	 * @param ids
	 */
	public void deleteSMSInfo(String... ids){
		dao.delete(ids);
	}
	
	/**
	 * 分页查询短信信息
	 */
	public Pagination<SMSInfo> findSMSInfoForPage(Map<String, ?> values,Pagination<SMSInfo> pagination){
		
		StringBuffer param = new StringBuffer();
		if(values.containsKey("organId")){
			param.append(" and organId='"+values.get("organId")+"'");
		}
		if(values.containsKey("queryPersonName")){
			param.append(" and personName like '%"+values.get("queryPersonName")+"%'");
		}
		if(values.containsKey("personCompany")){
			param.append(" and personCompany like '%"+values.get("personCompany")+"%'");
		}
		if(values.containsKey("phone")){
			param.append(" and phone like '%"+values.get("phone")+"%'");
		}
		if(values.containsKey("sendBeginTime")){
			param.append(" and sendTime >='"+values.get("sendBeginTime")+"'");
		}
		if(values.containsKey("sendEndTime")){
			param.append(" and sendTime <='"+values.get("sendEndTime")+"'");
		}
		
		if(values.containsKey("queryType")){
			param.append(" and isImmediately ='"+values.get("queryType")+"'");
		}
		if(values.containsKey("queryState")){
			param.append(" and state ='"+values.get("queryState")+"'");
		}
		
		
		String hql = " from SMSInfo where 1=1 "+param.toString()+" order by sendTime desc";
		List<SMSInfo> data = dao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from SMSInfo where 1=1 "+param.toString();
		int totalRows = dao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	
	/**
	 * 查询指定时间段内没有发送的短信
	 * @param beginTime 开始时间
	 * @param endTime 结束时间
	 * @param organId 短信所属公司
	 * @return
	 */
	public List<SMSInfo> findSMSInfoByTime(Calendar beginTime,Calendar endTime,String organId){
//		String hql = " from SMSInfo where :beginTime <=sendTime and sendTime<= :endTime and state =1 and organId='"+organId+"' order by sendTime asc";
		String hql = " from SMSInfo where :beginTime <=sendTime and (state =1 or state =0) and organId='"+organId+"' order by sendTime asc";
		Map<String, Calendar> values = new HashMap();
		values.put("beginTime",beginTime);
		values.put("endTime",endTime);
		List<SMSInfo> list = dao.find(hql, values);
		return list;
	}
}
