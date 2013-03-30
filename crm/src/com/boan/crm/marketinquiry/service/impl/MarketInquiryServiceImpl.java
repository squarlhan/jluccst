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

		if(values.containsKey("personId")){
			if(values.get("personId")!=null ){
				strb.append(" And  personId=:personId");
			}
		}
		if(values.containsKey("goodsTypeId")){
			if(values.get("goodsTypeId")!=null ){
				strb.append(" And  goodsTypeId in (:goodsTypeId)");
			}
		}
		if(values.containsKey("goodsId")){
			if(values.get("goodsId")!=null ){
				strb.append(" And  goodsId=:goodsId");
			}
		}
		if(values.containsKey("organId")){
			if(values.get("organId")!=null ){
				strb.append(" And organId=:organId");
			}
		}
	
		if(values.containsKey("goodsName")){
			if(values.get("goodsName")!=null ){
				strb.append(" And goodsName like '%"+values.get("goodsName")+"%'");
			}
		}
		if(values.containsKey("inquiryPersonName")){
			if(values.get("inquiryPersonName")!=null ){
				strb.append(" And inquiryPersonName like '%"+values.get("inquiryPersonName")+"%'");
			}
		}
		if(values.containsKey("goodsStandard")){
			if(values.get("goodsStandard")!=null ){
				strb.append(" And goodsStandard like '%"+values.get("goodsStandard")+"%'");
			}
		}

		if(values.containsKey("beginTime") && values.containsKey("endTime")){
			strb.append(" And  inquiryTime>=:beginTime And inquiryTime<=:endTime");
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
