package com.boan.crm.sellrecord.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.sellrecord.dao.ISellRecordDao;
import com.boan.crm.sellrecord.model.GoodsInfo;
import com.boan.crm.sellrecord.model.SellRecord;
import com.boan.crm.sellrecord.service.IGoodsInfoService;
import com.boan.crm.sellrecord.service.ISellRecordService;
import com.boan.crm.utils.page.Pagination;

@Service("sellRecordService")
public class SellRecordServiceImpl implements ISellRecordService {

	@Autowired
	@Qualifier("sellRecordDao")
	private ISellRecordDao sellRecordDao;
	
	@Autowired
	@Qualifier("goodsInfoService")
	private IGoodsInfoService goodsInfoService;
	
	@Autowired
	@Qualifier("customerInfoService")
	//客户状态接口类
	private ICustomerInfoService customerInfoService;
	
	/**
	 * 保存或就改销售记录相关信息
	 * @param record
	 */
	public void saveOrUpdate(SellRecord record){
		//保存或就改销售记录主信息
		sellRecordDao.saveOrUpdate(record);
		Set<GoodsInfo> detials = record.getGoodsDetials();
		for(GoodsInfo goodsInfo : detials){
			goodsInfo.setSellRecordId(record.getId());
			//保存或修改商品明细
			goodsInfoService.saveOrUpdate(goodsInfo);
		}
	}
	
	/**
	 * 根据销售记录Id查询销售记录信息
	 * @param id
	 * @return
	 */
	public SellRecord getSellRecordById(String id){
		SellRecord record = new SellRecord();
		record = sellRecordDao.get(id);
		if(record!=null){
			//查询销售商品明细
			List<GoodsInfo> detials= goodsInfoService.queryGoodsInfoByRecordId(record.getId());
			Set temp = new HashSet();
			for(GoodsInfo obj : detials){
				temp.add(obj);
			}
			record.setGoodsDetials(temp);
			//查询销售记录客户信息
			CustomerInfo customer = customerInfoService.get(record.getCustomerId());
			record.setCustomer(customer);
		}
		return record;
	}
	
	/**
     * 分页查询销售记录
     * @return 记录数组
     */
	public Pagination<SellRecord> findSellRecordForPage(Map<String, ?> values, Pagination<SellRecord> pagination){
		StringBuffer param = new StringBuffer();
		
		String hql = "select new SellRecord" +
				"(record.id,record. goodsType,record. customerId,record. customerName," +
				"record. salesmanId,record. salesmanName,record. orderID,record. rate," +
				"record. receivable,record. realCollection,record. debt,record. advance," +
				"record. invoice,record. bargainTime) " +
				"from SellRecord as record,CustomerInfo as customer where 1=1 " +
				"and record.customerId=customer.id "+param.toString()+"order by record.bargainTime desc";
		List<SellRecord> data =sellRecordDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		for(int i=0;i<data.size();i++){
			SellRecord temp  = data.get(i);
			String id = temp.getCustomerId();
			if(id!=null){
				CustomerInfo customer = customerInfoService.get(id);
				customer.setSalesman("222222");
				temp.setCustomer(customer);
			}
			List<GoodsInfo> detials= goodsInfoService.queryGoodsInfoByRecordId(temp.getId());
			
			if(detials!=null){
				Set<GoodsInfo> setTemp = new HashSet<GoodsInfo>();
				for(GoodsInfo goods : detials){
					setTemp.add(goods);
				}
				temp.setGoodsDetials(setTemp);
			}
			data.set(i, temp);
		}
		hql = "select count(*)from SellRecord as record,CustomerInfo as customer where 1=1 " +
				"and record.customerId=customer.id "+param.toString()+"order by record.bargainTime desc";
		int totalRows = sellRecordDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
}
