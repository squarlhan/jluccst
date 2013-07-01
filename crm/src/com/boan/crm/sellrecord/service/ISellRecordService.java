package com.boan.crm.sellrecord.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.boan.crm.sellrecord.model.SellRecord;
import com.boan.crm.utils.page.Pagination;

public interface ISellRecordService {

	/**
	 * 保存或就改销售记录相关信息
	 * @param record
	 */
	public void saveOrUpdate(SellRecord record);
	
	/**
	 * 根据销售记录Id查询销售记录信息
	 * @param id
	 * @return
	 */
	public SellRecord getSellRecordById(String id);
	
	/**
     * 分页查询销售记录
     * @return 记录数组
     */
	public Pagination<SellRecord> findSellRecordForPage(Map<String, ?> values, Pagination<SellRecord> pagination);
	
	/**
	 * 根据销售记录Id删除销售记录
	 * @param ids
	 */
	public void deleteSellRecordByIds(String... ids);
	
	/**
	 * 根据客户Id获取消费次数
	 * @param customerId
	 * @return
	 */
	public  int getConsumptionCount(String customerId);
	
	/**
	 * 根据客户Id获取消费金额
	 * @param customerId
	 * @return
	 */
	public  BigDecimal getConsumptionMoney(String customerId);
	
	/**
	 * 根据客户Id,成交时间段查询总欠款数
	 * @param customerId 客户Id
	 * @param bargainTimeBegin 成交开始时间
	 * @param bargainTimeEnd   成交结束时间
	 * @return 欠款数
	 */
	public  BigDecimal getTotalDebt(String customerId,String bargainTimeBegin,String bargainTimeEnd);
	
	/**
	 * 根据客户Id,成交时间段查询回款情况  （总款－欠款）/总款
	 * @param customerId 客户Id
	 * @param bargainTimeBegin 成交开始时间
	 * @param bargainTimeEnd   成交结束时间
	 * @return 回款情况
	 */
	public  BigDecimal getConsumptionDebt(String customerId,String bargainTimeBegin,String bargainTimeEnd);
	
	/**
	 * 获取订单当前最大流水号
	 * @param dataStr 日期串 yyyyMMdd
	 * @param customerId 公司Id
	 * @return 流水号
	 */
	public String getSellRecordorderID(String dataStr,String customerId);
	
	/**
	 * 获指定公司指定时间段内不同数额
	 * @param queryType  RECEIVABLE：应收总金额  REAL_COLLECTION ：实收总金额   DEBT:总欠款金额
	 * @param companyId 公司id
	 * @param beginDate 查询开始时间
	 * @param endDate  查询结束时间
	 * @return 相应数额
	 */
	public  BigDecimal getTotalMoneyByType(String queryType,String companyId,String beginDate,String endDate);
	
	/**
	 * 获指定公司指定时间段查询销售记录，可以指定某个客户
	 * @param companyId 公司id
	 * @param customerId  客户Id
	 * @param beginDate 查询开始时间
	 * @param endDate  查询结束时间
	 * @return 销售记录
	 */
	public  List<SellRecord> getSellRecordorderByBargainTime(String companyId,String customerId,String beginDate,String endDate);
	
	/**
	 * 获指定公司指定时间段查询销售记录，可以指定某个客户
	 * @param companyId 公司id
	 * @param customerId  客户Id
	 * @param beginDate 查询开始时间
	 * @param endDate  查询结束时间
	 * @return 实收总金额
	 */
	public  BigDecimal getRealCollectionByBargainTime(String companyId,String customerId,Calendar beginDate,Calendar endDate);
	
	/**
	 * 查询产品销售量
	 * @param companyId 公司Id
	 * @param productId 产品Id
	 * @return
	 */
	public int getSellTotalAmount( String companyId, String productId );
	
	/**
	 *  获指定公司指定时间段查询某部门某人的实收销售总额
	 * @param companyId 公司id
	 * @param deptId 销售人员部门id
	 * @param salesmanId  销售人员id
	 * @param beginDate  查询开始时间
	 * @param endDate 查询结束时间
	 * @return 实收总金额
	 */
	public  BigDecimal getSalesmanRealCollectionByBargainTime(String companyId,String deptId ,String salesmanId , Calendar beginDate,Calendar endDate);
	
	/**
	 *  获指定公司指定时间段查询某部门某人的实收销售总额和时间
	 * @param companyId 公司id
	 * @param deptId 销售人员部门id
	 * @param salesmanId  销售人员id
	 * @param beginDate  查询开始时间
	 * @param endDate 查询结束时间
	 * @return 实收总金额
	 */
	public  List getSalesmanRealCollectionAndTimeByBargainTime(String companyId,String deptId ,String salesmanId , Calendar beginDate,Calendar endDate);
	
	/**
     * 查询指定销售员的所有销售记录
     * @return 记录数组
     */
	public List<SellRecord> findAllSellRecord(Map<String, ?> values);

}
