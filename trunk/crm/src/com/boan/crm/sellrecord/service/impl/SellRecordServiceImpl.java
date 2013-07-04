package com.boan.crm.sellrecord.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
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
		
		if(values.containsKey("customerId")){
			param = param.append("  and customer.id ='"+values.get("customerId")+"'  ");
		}
		if(values.containsKey("customerId")){
			param = param.append("  and customer.id ='"+values.get("customerId")+"'  ");
		}
		if(values.containsKey("queryCustomerName")){
			param = param.append("  and customer.customerName like '%"+values.get("queryCustomerName")+"%'  ");
		}
		if(values.containsKey("querySalesman")){
			param = param.append("  and  record. salesmanId='"+values.get("querySalesman")+"'" );
		}
		if(values.containsKey("queryBargainTimeBegin")){
			param.append(" and record. bargainTime >='"+values.get("queryBargainTimeBegin")+"'" );
		}
		if(values.containsKey("queryBargainTimeEnd")){
			param.append(" and record. bargainTime <='"+values.get("queryBargainTimeEnd")+"'" );
		}
		if(values.containsKey("deptId")){
			param = param.append("  and record. deptId ='"+values.get("deptId")+"'  ");
		}
		if(values.containsKey("salesmanId")){
			param = param.append("  and record. salesmanId ='"+values.get("salesmanId")+"'  ");
		}
		if(values.containsKey("companyId")){
			param = param.append("  and record. companyId ='"+values.get("companyId")+"'  ");
		}
		/////////////////
		if(values.get("queryAmountBegin")!=null && !values.get("queryAmountBegin").equals("")){
			param = param.append("   and record.receivable >= "+values.get("queryAmountBegin") );
		}
		if(values.get("queryAmountEnd")!=null && !values.get("queryAmountEnd").equals("")){
			param = param.append("  and  record.receivable <= "+values.get("queryAmountEnd"));
		}
		if(values.get("queryIsArrearage")!=null && values.get("queryIsArrearage").equals("0")){
			param = param.append("  and  record.debt  = 0 ");
		}
		if(values.get("queryIsArrearage")!=null && values.get("queryIsArrearage").equals("1")){
			param = param.append(" and  record.debt > 0");
		}
		/////////////////
		String hql = "select new SellRecord" +
				"(record.id,record. goodsType,record. customerId,record. customerName," +
				"record. salesmanId,record. salesmanName,record. orderID,record. rate," +
				"record. receivable,record. realCollection,record. debt,record. advance," +
				"record. invoice,record. bargainTime) " +
				"from SellRecord as record,CustomerInfo as customer where 1=1 " +
				"and record.customerId=customer.id "+param.toString()+"" +
				" order by receivable desc,record.bargainTime desc";
		List<SellRecord> data =sellRecordDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		for(int i=0;i<data.size();i++){
			SellRecord temp  = data.get(i);
			String id = temp.getCustomerId();
			if(id!=null){
				CustomerInfo customer = customerInfoService.get(id);
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
	
	/**
	 * 根据销售记录Id删除销售记录
	 * @param ids
	 */
	public void deleteSellRecordByIds(String... ids){
		sellRecordDao.delete(ids);
	}
	
	/**
	 * 根据客户Id获取消费次数
	 * @param customerId
	 * @return
	 */
	public  int getConsumptionCount(String customerId){
		String hql ="select count(record.id) from SellRecord as record where record. customerId=:customerId ";
		Map<String, String> param = new HashMap<String,String>();
		param.put("customerId",customerId);
		List list = sellRecordDao.find(hql, param);
		return  (list!=null &&  list.size()>0 && list.get(0)!=null )?Integer.parseInt( list.get(0).toString()) : 0;
	}
	
	/**
	 * 根据客户Id获取消费金额
	 * @param customerId
	 * @return
	 */
	public  BigDecimal getConsumptionMoney(String customerId){
		String hql ="select sum(record.receivable)  from SellRecord as record where record. customerId=:customerId";
		Map<String, String> param = new HashMap<String,String>();
		param.put("customerId",customerId);
		List list = sellRecordDao.find(hql, param);
		return (list!=null &&  list.size()>0 && list.get(0)!=null )? new BigDecimal( list.get(0).toString()) : new BigDecimal(0);
	}
	
	/**
	 * 根据客户Id,成交时间段查询总欠款数
	 * @param customerId 客户Id
	 * @param bargainTimeBegin 成交开始时间
	 * @param bargainTimeEnd   成交结束时间
	 * @return 欠款数
	 */
	public  BigDecimal getTotalDebt(String customerId,String bargainTimeBegin,String bargainTimeEnd){
		String hql ="select sum(record.debt)  from SellRecord as record where record. customerId=:customerId ";
		if(bargainTimeBegin!=null && !bargainTimeBegin.equals("")){
			hql = hql + "  and  record. bargainTime >='"+bargainTimeBegin+"' ";
		}
		if(bargainTimeEnd!=null && !bargainTimeEnd.equals("")){
			hql = hql + "  and record. bargainTime <='"+bargainTimeEnd+"'";
		}
		Map<String, String> param = new HashMap<String,String>();
		param.put("customerId",customerId);
		List list = sellRecordDao.find(hql, param);
		return (list!=null &&  list.size()>0 && list.get(0)!=null )? new BigDecimal( list.get(0).toString()) : new BigDecimal(0);
	}

	/**
	 * 根据客户Id,成交时间段查询回款情况  （总款－欠款）/总款
	 * @param customerId 客户Id
	 * @param bargainTimeBegin 成交开始时间
	 * @param bargainTimeEnd   成交结束时间
	 * @return 回款情况
	 */
	public  BigDecimal getConsumptionDebt(String customerId,String bargainTimeBegin,String bargainTimeEnd){
		String hql ="select (sum(record.receivable)-sum(record.debt))/sum(record.receivable)  from SellRecord as record where record. customerId=:customerId  and  record. bargainTime >='"+bargainTimeBegin+"' and record. bargainTime <='"+bargainTimeEnd+"'";
		Map<String, String> param = new HashMap<String,String>();
		param.put("customerId",customerId);
		List list = sellRecordDao.find(hql, param);
		return (list!=null &&  list.size()>0 && list.get(0)!=null )? new BigDecimal( list.get(0).toString()) : new BigDecimal(0);
	}
	/**
	 * 获取订单当前最大流水号
	 * @param dataStr 日期串 yyyyMMdd
	 * @param companyId 公司Id
	 * @return 流水号
	 */
	public String getSellRecordorderID(String dataStr,String companyId){
		String hql ="select max(record.orderID) from SellRecord as record where record. companyId=:companyId and record.orderID like '"+dataStr+"%'";
//		String hql ="select max(record.orderID) from SellRecord as record where record. customerId=:customerId and record.orderID like '"+dataStr+"%'";
		Map<String, String> param = new HashMap<String,String>();
		param.put("companyId",companyId);
		List list = sellRecordDao.find(hql, param);
		return (list!=null &&  list.size()>0 && list.get(0)!=null)?   list.get(0).toString() : "";
	}
	
	/**
	 * 获指定公司指定时间段内不同数额
	 * @param queryType  RECEIVABLE：应收总金额  REAL_COLLECTION ：实收总金额   DEBT:总欠款金额
	 * @param companyId 公司id
	 * @param beginDate 查询开始时间
	 * @param endDate  查询结束时间
	 * @return 相应数额
	 */
	public  BigDecimal getTotalMoneyByType(String queryType,String companyId,String beginDate,String endDate){
		
		String column ="*";
		//应收总金额
		if(queryType!=null && queryType.equals("RECEIVABLE")){
			column= " sum(record.receivable) ";
		}
		//实收总金额
		if(queryType!=null && queryType.equals("REAL_COLLECTION")){
			column= " sum(record.realCollection) ";
		}
		//总欠款金额
		if(queryType!=null && queryType.equals("DEBT")){
			column= " sum(record.debt) ";
		}
		String hql ="select  " +column+ "  from SellRecord as record where record.companyId=:companyId ";
		
		if(beginDate!=null && !beginDate.equals("")){
			hql = hql + " and record.bargainTime >='"+beginDate+"' ";
		}
		if(endDate!=null && !endDate.equals("")){
			hql = hql + " and record.bargainTime <='"+endDate+"' ";
		}
		Map<String, String> param = new HashMap<String,String>();
		param.put("companyId",companyId);
		
		List list = sellRecordDao.find(hql, param);
		return (list!=null &&  list.size()>0 && list.get(0)!=null )? new BigDecimal( list.get(0).toString()) : new BigDecimal(0);
	}
	
	/**
	 * 获指定公司指定时间段查询销售记录，可以指定某个客户
	 * @param companyId 公司id
	 * @param customerId  客户Id
	 * @param beginDate 查询开始时间
	 * @param endDate  查询结束时间
	 * @return 销售记录
	 */
	public  List<SellRecord> getSellRecordorderByBargainTime(String companyId,String customerId,String beginDate,String endDate){
		String hql =" from SellRecord as record where record.companyId=:companyId ";
		if(beginDate!=null && !beginDate.equals("")){
			hql = hql + " and record.bargainTime >='"+beginDate+"' ";
		}
		if(endDate!=null && !endDate.equals("")){
			hql = hql + " and record.bargainTime <='"+endDate+"' ";
		}
		if(customerId!=null &&customerId.equals("")){
			hql = hql + " and record.customerId =:customerId";
		}
		Map<String, String> param = new HashMap<String,String>();
		if(customerId!=null &&customerId.equals("")){
			param.put("customerId",customerId);
		}
		param.put("companyId",companyId);
		List list = sellRecordDao.find(hql, param);
		return list;
	}
	
	/**
	 * 获指定公司指定时间段查询销售记录，可以指定某个客户
	 * @param companyId 公司id
	 * @param customerId  客户Id
	 * @param beginDate 查询开始时间
	 * @param endDate  查询结束时间
	 * @return 实收总金额
	 */
	public  BigDecimal getRealCollectionByBargainTime(String companyId,String customerId,Calendar beginDate,Calendar endDate){
		String hql =" select sum(record.realCollection) from SellRecord as record where record.companyId=:companyId ";
		if(beginDate!=null && !beginDate.equals("")){
//			hql = hql + " and record.bargainTime >='"+beginDate+"' ";
			hql = hql + " and record.bargainTime >=:beginDate";
		}
		if(endDate!=null && !endDate.equals("")){
//			hql = hql + " and record.bargainTime <='"+endDate+"' ";
			hql = hql + " and record.bargainTime <=:endDate ";
		}
		if(customerId!=null && !customerId.equals("")){
			hql = hql + " and record.customerId =:customerId";
		}
		Map param = new HashMap();
		if(customerId!=null && !customerId.equals("")){
			param.put("customerId",customerId);
		}
		param.put("beginDate",beginDate);
		param.put("endDate",endDate);
		param.put("companyId",companyId);
		List list = sellRecordDao.find(hql, param);
		return (list!=null &&  list.size()>0 && list.get(0)!=null )? new BigDecimal( list.get(0).toString()) : new BigDecimal(0);
	}
	
	/**
	 * 查询产品销售量
	 * @param companyId 公司Id
	 * @param productId 产品Id
	 * @return
	 */
	public int getSellTotalAmount( String companyId, String productId ){
		return goodsInfoService.getGoodsNumberByProductIdAndCompanyId(companyId,productId);
	}

	/**
	 *  获指定公司指定时间段查询某部门某人的实收销售总额
	 * @param companyId 公司id
	 * @param deptId 销售人员部门id
	 * @param salesmanId  销售人员id
	 * @param beginDate  查询开始时间
	 * @param endDate 查询结束时间
	 * @return 实收总金额
	 */
	public  BigDecimal getSalesmanRealCollectionByBargainTime(String companyId,String deptId ,String salesmanId , Calendar beginDate,Calendar endDate){
		try {
			String hql = " select sum(record.realCollection) from SellRecord as record where record.companyId=:companyId ";
			if (deptId != null && !deptId.equals("")) {
				hql = hql + " and record.deptId =:deptId";
			}
			if (beginDate != null && !beginDate.equals("")) {
				hql = hql + " and record.bargainTime >=:beginDate";
			}
			if (endDate != null && !endDate.equals("")) {
				hql = hql + " and record.bargainTime <=:endDate ";
			}
			if (salesmanId != null && !salesmanId.equals("")) {
				hql = hql + " and record.salesmanId =:salesmanId";
			}
			if(salesmanId==null || salesmanId.equals("")){
				hql = hql + " group by record.deptId";
			}else{
				hql = hql + " group by record.salesmanId";
			}
			
			Map param = new HashMap();
			param.put("companyId", companyId);
			if (deptId != null && !deptId.equals("")) {
				param.put("deptId", deptId);
			}
			if (salesmanId != null && !salesmanId.equals("")) {
				param.put("salesmanId", salesmanId);
			}
			param.put("beginDate", beginDate);
			param.put("endDate", endDate);
			List list = sellRecordDao.find(hql, param);
			return (list != null && list.size() > 0 && list.get(0) != null) ? new BigDecimal( list.get(0).toString()) : new BigDecimal(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 *  获指定公司指定时间段查询某部门某人的实收销售总额和时间
	 * @param companyId 公司id
	 * @param deptId 销售人员部门id
	 * @param salesmanId  销售人员id
	 * @param beginDate  查询开始时间
	 * @param endDate 查询结束时间
	 * @return 实收总金额
	 */
	public  List getSalesmanRealCollectionAndTimeByBargainTime(String companyId,String deptId ,String salesmanId , Calendar beginDate,Calendar endDate){
		try {
			String hql = " select record.bargainTime , sum(record.realCollection) from SellRecord as record where record.companyId=:companyId ";
			if (deptId != null && !deptId.equals("")) {
				hql = hql + " and record.deptId =:deptId";
			}
			if (beginDate != null && !beginDate.equals("")) {
				hql = hql + " and record.bargainTime >=:beginDate";
			}
			if (endDate != null && !endDate.equals("")) {
				hql = hql + " and record.bargainTime <=:endDate ";
			}
			if (salesmanId != null && !salesmanId.equals("")) {
				hql = hql + " and record.salesmanId =:salesmanId";
			}
			if(salesmanId==null || salesmanId.equals("")){
				hql = hql + " group by record.bargainTime";
			}else{
				hql = hql + " group by record.bargainTime";
			}
			hql = hql + " order by record.bargainTime";
			
			Map param = new HashMap();
			param.put("companyId", companyId);
			if (deptId != null && !deptId.equals("")) {
				param.put("deptId", deptId);
			}
			if (salesmanId != null && !salesmanId.equals("")) {
				param.put("salesmanId", salesmanId);
			}
			param.put("beginDate", beginDate);
			param.put("endDate", endDate);
			List list = sellRecordDao.find(hql, param);
			
			List tempList = new ArrayList();
			if(list!=null && list.size()>0){
				for(int i=0;i<list.size();i++){
					Map map = new HashMap();
					Object[] columns = (Object[])list.get(i);
					if(columns[1]==null){
						map.put(columns[0], new BigDecimal(0));
					}else{
						map.put(columns[0], columns[1]);
					}
					tempList.add(map);
				}
			}
			
			return tempList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
     * 查询指定销售员的所有销售记录
     * @return 记录数组
     */
	public List<SellRecord> findAllSellRecord(Map<String, ?> values){
		StringBuffer param = new StringBuffer();
		
		if(values.containsKey("customerId")){
			param = param.append("  and customer.id ='"+values.get("customerId")+"'  ");
		}
		if(values.containsKey("customerId")){
			param = param.append("  and customer.id ='"+values.get("customerId")+"'  ");
		}
		if(values.containsKey("queryCustomerName")){
			param = param.append("  and customer.customerName like '%"+values.get("queryCustomerName")+"%'  ");
		}
		if(values.containsKey("querySalesman")){
			param = param.append("  and  record. salesmanId='"+values.get("querySalesman")+"'" );
		}
		if(values.containsKey("queryBargainTimeBegin")){
			param.append(" and record. bargainTime >='"+values.get("queryBargainTimeBegin")+"'" );
		}
		if(values.containsKey("queryBargainTimeEnd")){
			param.append(" and record. bargainTime <='"+values.get("queryBargainTimeEnd")+"'" );
		}
		if(values.containsKey("deptId")){
			param = param.append("  and record. deptId ='"+values.get("deptId")+"'  ");
		}
		if(values.containsKey("salesmanId")){
			param = param.append("  and record. salesmanId ='"+values.get("salesmanId")+"'  ");
		}
		if(values.containsKey("companyId")){
			param = param.append("  and record. companyId ='"+values.get("companyId")+"'  ");
		}
		/////////////////
		if(values.get("queryAmountBegin")!=null && !values.get("queryAmountBegin").equals("")){
			param = param.append("   and record.receivable >= "+values.get("queryAmountBegin") );
		}
		if(values.get("queryAmountEnd")!=null && !values.get("queryAmountEnd").equals("")){
			param = param.append("  and  record.receivable <= "+values.get("queryAmountEnd"));
		}
		if(values.get("queryIsArrearage")!=null && values.get("queryIsArrearage").equals("0")){
			param = param.append("  and  record.debt  = 0 ");
		}
		if(values.get("queryIsArrearage")!=null && values.get("queryIsArrearage").equals("1")){
			param = param.append(" and  record.debt > 0");
		}
		/////////////////
		String hql = "select new SellRecord" +
				"(record.id,record. goodsType,record. customerId,record. customerName," +
				"record. salesmanId,record. salesmanName,record. orderID,record. rate," +
				"record. receivable,record. realCollection,record. debt,record. advance," +
				"record. invoice,record. bargainTime) " +
				"from SellRecord as record,CustomerInfo as customer where 1=1 " +
				"and record.customerId=customer.id "+param.toString()+"" +
				" order by receivable desc,record.bargainTime desc";
		List<SellRecord> data =sellRecordDao.find(hql, values);
		for(int i=0;i<data.size();i++){
			SellRecord temp  = data.get(i);
			String id = temp.getCustomerId();
			if(id!=null){
				CustomerInfo customer = customerInfoService.get(id);
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
		return data;
	}
}
