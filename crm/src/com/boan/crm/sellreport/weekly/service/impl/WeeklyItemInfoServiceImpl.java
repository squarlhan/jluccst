package com.boan.crm.sellreport.weekly.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.sellreport.weekly.dao.IWeeklyItemInfoDao;
import com.boan.crm.sellreport.weekly.model.WeeklyItemInfo;
import com.boan.crm.sellreport.weekly.service.IWeeklyItemInfoService;
import com.boan.crm.utils.page.Pagination;
@Service("weeklyItemInfoService")
public class WeeklyItemInfoServiceImpl implements IWeeklyItemInfoService{

	@Autowired
	@Qualifier("weeklyItemInfoDao")
	private IWeeklyItemInfoDao weeklyItemInfoDao;
	
	/**
	 * 保存或修改周计划项信息
	 * @param obj
	 */
	public void saveOrUpdateWeeklyItemInfo(WeeklyItemInfo obj){
		weeklyItemInfoDao.saveOrUpdate(obj);
	}
	
	/**
	 * 根据周计划项Id查询周计划项信息
	 * @param id
	 * @return
	 */
	public WeeklyItemInfo getWeeklyItemInfoById(String id){
		return weeklyItemInfoDao.get(id);
	}
	
	 /**
	  * 通过Id删除周计划项信息
	  * @param id
	  */
	public void deleteWeeklyItemInfoByIds(String... ids){
		weeklyItemInfoDao.delete(ids);
	}
	
	/**
	 * 根据周计划Id查询周计划项信息
	 * @param mainInfoId
	 * @return
	 */
	public List<WeeklyItemInfo>  getWeeklyItemInfoListByMainInfoId(String mainInfoId){
		String hql = "from WeeklyItemInfo where mainInfoId=:mainInfoId order by sequence asc";
		Map param = new HashMap();
		param.put("mainInfoId",mainInfoId);
		return weeklyItemInfoDao.find(hql, param);
	}
	/**
	 * 根据周计划Id查询周计划项中销售额的信息
	 * @param mainInfoId
	 * @return
	 */
	public List<WeeklyItemInfo>  getWeeklyItemInfoListOfSellTargetByMainInfoId(String mainInfoId){
		String hql = "from WeeklyItemInfo where mainInfoId=:mainInfoId and sellTarget<>'' and sellTarget is not null order by sequence asc";
		Map param = new HashMap();
		param.put("mainInfoId",mainInfoId);
		return weeklyItemInfoDao.find(hql, param);
	}
	
	/**
	 * 按分页查询周计划项信息
	 */
	public Pagination<WeeklyItemInfo> findWeeklyItemInfoForPage( Map<String, ?> values, Pagination<WeeklyItemInfo> pagination){
		
		StringBuffer strb = new StringBuffer( " where 1=1 ");
		if(values!=null){
			if(values.containsKey("mainInfoId")){
				strb.append(" and  mainInfoId=:mainInfoId  ");
			}
		}
		String hql = "from WeeklyItemInfo "+strb.toString()+" order by sequence asc";
		List<WeeklyItemInfo> data = weeklyItemInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from WeeklyItemInfo" +strb.toString();
		int totalRows = weeklyItemInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
}
