package com.boan.crm.sellreport.sellduty.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.sellreport.sellduty.dao.ISellDutyDao;
import com.boan.crm.sellreport.sellduty.model.SellDuty;
import com.boan.crm.sellreport.sellduty.service.ISellDutyService;
import com.boan.crm.utils.page.Pagination;

/**
 * @author YF
 *
 */
@Service("sellDutyService")
public class SellDutyServiceImpl implements ISellDutyService {

	@Autowired
	@Qualifier("sellDutyDao")
	private ISellDutyDao sellDutyDao;
	
	/**
	 * 保存或修改销售职责
	 * @param SellDuty
	 */
	public void saveOrUpdateSellDuty(SellDuty SellDuty){
		sellDutyDao.saveOrUpdate(SellDuty);
	}
	
	 /**
	  * 通过Id删除销售职责
	  * @param id
	  */
	public void deleteSellDuty(String... id){
		sellDutyDao.delete(id);
	}
	
	/**
	 * 通过id查询销售职责
	 * @param id
	 */
	public SellDuty getSellDutyById(String id){
		return sellDutyDao.get(id);
	}
	
	/**
	 * 按分页查询销售职责
	 */
	public Pagination<SellDuty> findSellDutyForPage( Map<String, ?> values, Pagination<SellDuty> pagination){
		
		StringBuffer strb = new StringBuffer( " where 1=1 ");
		if(values!=null){
			if(values.containsKey("companyId")){
				strb.append(" and companyId=:companyId  ");
			}
		}
		String hql = "from SellDuty "+strb.toString()+" order by dutyType asc,createTime desc ";
		List<SellDuty> data = sellDutyDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from SellDuty" +strb.toString();
		int totalRows = sellDutyDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	
	/**
	 * 查询本公司的所有销售职责
	 */
	public List<SellDuty> findAllSellDutyByCompanyId(String companyId){
		
		StringBuffer strb = new StringBuffer( " where companyId=:companyId");
		Map<String, String> param = new HashMap<String, String>();
		param.put("companyId", companyId);
		String hql = "from SellDuty "+strb.toString()+" order by dutyType asc,createTime desc ";
		List<SellDuty> data = sellDutyDao.find(hql, param);
		return data;
	}
	/**
	 * 查询本公司下指定职责类型的所有销售职责
	 */
	public List<SellDuty> findAllSellDutyByCompanyIdAndDutyType(String companyId ,int dutyType){
		
		StringBuffer strb = new StringBuffer( " where companyId=:companyId");
		Map<String, String> param = new HashMap<String, String>();
		param.put("companyId", companyId);
		String hql = "from SellDuty "+strb.toString()+" and dutyType="+dutyType+" order by numberType desc,createTime desc ";
		List<SellDuty> data = sellDutyDao.find(hql, param);
		return data;
	}
	
	/**
	 * 判断同一公司是否已经有同名的销售职责了
	 */
	public boolean isExistSameName(String sellDutyName,String id , String companyId ,int dutyType){
		
		StringBuffer strb = new StringBuffer( " where 1=1 ");
		Map<String, String> param = new HashMap<String, String>();
		param.put("name", sellDutyName);
		strb.append(" and name=:name");
		if(companyId!=null){
			param.put("companyId", companyId);
			strb.append(" and companyId=:companyId");
		}
		
		strb.append(" and dutyType="+dutyType );

		String hql = "select id from SellDuty "+strb.toString()+"";
		List data = sellDutyDao.find(hql, param);
		if(data!=null && data.size()>0){
			String temp = data.get(0).toString();
			if(temp==null){
				return false;//不存在
			}else{
				if(id==null || id.equals("")){
					return true;
				}
				if(temp.equals(id)){
					return false;
				}
			}
			temp=null;
		}
		return false;
	}
	
	/**
	 * 判断是否已经有销售额类型的职责名称了
	 */
	public boolean hasSellTargetName(String companyId ,String dutyType){
		
		StringBuffer strb = new StringBuffer( " where 1=1 ");
		Map<String, String> param = new HashMap<String, String>();
		if(companyId!=null){
			param.put("companyId", companyId);
			strb.append(" and companyId=:companyId");
		}
		strb.append(" and dutyType="+dutyType);
		param.put("numberType", "1");
		strb.append(" and numberType=:numberType");
		
		String hql = "from SellDuty "+strb.toString()+" order by dutyType asc,createTime desc ";
		List<SellDuty> data = sellDutyDao.find(hql, param);
		if(data!=null && data.size()>0){
			SellDuty temp = data.get(0);
			if(temp==null){
				return false;//不存在
			}
		}else{
			return false;//不存在
		}
		return true;
	}
}
