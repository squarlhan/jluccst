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
		
		String hql = " from SMSInfo order by sendTime desc";
		List<SMSInfo> data = dao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from SMSInfo";
		int totalRows = dao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	
	/**
	 * 查询指定时间段内没有发送的短信
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public List<SMSInfo> findSMSInfoByTime(Calendar beginTime,Calendar endTime){
		String hql = " from SMSInfo where sendTime  :beginTime <=sendTime<= :endTime and state =1 order by sendTime asc";
		Map<String, Calendar> values = new HashMap();
		values.put("beginTime",beginTime);
		values.put("endTime",endTime);
		List<SMSInfo> list = dao.find(hql, values);
		return list;
	}
}
