package com.boan.crm.sellreport.monthly.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.sellreport.monthly.dao.IMonthlyItemInfoDao;
import com.boan.crm.sellreport.monthly.model.MonthlyItemInfo;
import com.boan.crm.sellreport.monthly.service.IMonthlyItemInfoService;
import com.boan.crm.utils.page.Pagination;
@Service("monthlyItemInfoService")
public class MonthlyItemInfoServiceImpl implements IMonthlyItemInfoService{

	@Autowired
	@Qualifier("monthlyItemInfoDao")
	private IMonthlyItemInfoDao monthlyItemInfoDao;
	
	/**
	 * 保存或修改月计划项信息
	 * @param obj
	 */
	public void saveOrUpdateMonthlyItemInfo(MonthlyItemInfo obj){
		monthlyItemInfoDao.saveOrUpdate(obj);
	}
	
	/**
	 * 根据月计划项Id查询月计划项信息
	 * @param id
	 * @return
	 */
	public MonthlyItemInfo getMonthlyItemInfoById(String id){
		return monthlyItemInfoDao.get(id);
	}
	
	 /**
	  * 通过Id删除月计划项信息
	  * @param id
	  */
	public void deleteMonthlyItemInfoByIds(String... ids){
		monthlyItemInfoDao.delete(ids);
	}
	
	/**
	 * 根据计划人Id查询月计划项信息
	 * @param mainInfoId
	 * @return
	 */
	public List<MonthlyItemInfo>  getMonthlyItemInfoListByMainInfoId(String mainInfoId){
		String hql = "from MonthlyItemInfo where mainInfoId=:mainInfoId order by sequence asc";
		Map param = new HashMap();
		param.put("mainInfoId",mainInfoId);
		return monthlyItemInfoDao.find(hql, param);
	}
	
	/**
	 * 按分页查询月计划项信息
	 */
	public Pagination<MonthlyItemInfo> findMonthlyItemInfoForPage( Map<String, ?> values, Pagination<MonthlyItemInfo> pagination){
		
		StringBuffer strb = new StringBuffer( " where 1=1 ");
		if(values!=null){
			if(values.containsKey("mainInfoId")){
				strb.append(" and  mainInfoId=:mainInfoId  ");
			}
		}
		String hql = "from MonthlyItemInfo "+strb.toString()+" order by sequence asc";
		List<MonthlyItemInfo> data = monthlyItemInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from MonthlyItemInfo" +strb.toString();
		int totalRows = monthlyItemInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	
	/**
	 * 根据月计划Id查询月计划项中销售额的信息
	 * @param mainInfoId
	 * @return
	 */
	public List<MonthlyItemInfo>  getMonthlyItemInfoListOfSellTargetByMainInfoId(String mainInfoId){
		String hql = "from MonthlyItemInfo where mainInfoId=:mainInfoId and sellTarget<>'' and sellTarget is not null order by sequence asc";
		Map param = new HashMap();
		param.put("mainInfoId",mainInfoId);
		return monthlyItemInfoDao.find(hql, param);
	}
	
	/**
	 *查询最近月计划项信息
	 * @param 
	 * @return
	 */
	public MonthlyItemInfo getLastMonthlyItemInfo( Map<String, ?> params){
		StringBuffer strb = new StringBuffer( " where 1=1 ");
		if(params!=null){
			if(params.containsKey("mainInfoId")){
				strb.append(" and  mainInfoId=:mainInfoId  ");
			}
		}
		String hql = "from MonthlyItemInfo "+strb.toString()+" order by createTime desc , sequence asc";
		List<MonthlyItemInfo> data = monthlyItemInfoDao.find(hql, params);
		if(data!=null && data.size()>0){
			return data.get(0);
		}
		return null;
	}
}
