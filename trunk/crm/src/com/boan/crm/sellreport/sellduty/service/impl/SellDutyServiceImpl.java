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
		String hql = "from SellDuty "+strb.toString()+" order by createTime desc , dutyType asc";
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
		String hql = "from SellDuty "+strb.toString()+" order by createTime desc , dutyType asc";
		List<SellDuty> data = sellDutyDao.find(hql, param);
		return data;
	}
}
