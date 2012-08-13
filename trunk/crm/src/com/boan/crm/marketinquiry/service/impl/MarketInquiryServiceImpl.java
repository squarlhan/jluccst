package com.boan.crm.marketinquiry.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.marketinquiry.dao.IMarketInquiryDao;
import com.boan.crm.marketinquiry.model.MarketInquiry;
import com.boan.crm.marketinquiry.service.IMarketInquiryService;
import com.boan.crm.utils.page.Pagination;
/**
 * 市场调查数据库服务接口实现
 * @author YF
 *
 */
@Service("marketInquiryService")
public class MarketInquiryServiceImpl implements IMarketInquiryService {
	@Autowired
	@Qualifier("marketInquiryDao")
	private IMarketInquiryDao marketInquiryDao;
	
	/**
	 * 保存或修改市场调查
	 * @param MarketInquiry
	 */
	public void saveOrUpdateMarketInquiry(MarketInquiry MarketInquiry){
		marketInquiryDao.saveOrUpdate(MarketInquiry);
	}
	
	 /**
	  * 通过Id删除市场调查
	  * @param id
	  */
	public void deleteMarketInquiry(String... id){
		marketInquiryDao.delete(id);
	}
	
	/**
	 * 通过id查询市场调查
	 * @param id
	 */
	public MarketInquiry getMarketInquiryById(String id){
		return marketInquiryDao.get(id);
	}
	
	/**
	 * 按分页查询市场调查
	 */
	public Pagination<MarketInquiry> findMarketInquiryForPage( Map<String, ?> values, Pagination<MarketInquiry> pagination){
		StringBuffer strb = new StringBuffer( " where 1=1 ");
		if(values.containsKey("employeeName")){
			if(values.get("employeeName")!=null ){
				strb.append(" And employeeName like '%"+values.get("employeeName")+"%'");
			}
		}
		if(values.containsKey("planType")){
			if(values.get("planType")!=null && !values.get("planType").equals("-1")){
				strb.append(" And  planType=:planType");
			}
		}
		if(values.containsKey("beginTime") && values.containsKey("endTime")){
			strb.append(" And  submitTime>=:beginTime And submitTime<=:endTime");
		}

		String hql = "from MarketInquiry "+strb.toString()+" order by createTime desc";
		List<MarketInquiry> data = marketInquiryDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from MarketInquiry" +strb.toString();
		int totalRows = marketInquiryDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
}
