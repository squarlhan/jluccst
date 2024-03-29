package com.boan.crm.finance.action;

import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Column;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.backstagemanage.common.LogType;
import com.boan.crm.backstagemanage.model.Log;
import com.boan.crm.common.Message;
import com.boan.crm.finance.common.FinanceListType;
import com.boan.crm.finance.model.Finance;
import com.boan.crm.finance.service.IFinanceService;
import com.boan.crm.purchase.model.PurchaseBatch;
import com.boan.crm.purchase.service.IPurchaseRecordService;
import com.boan.crm.sellrecord.service.ISellRecordService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * 财务清单
 * 
 * @author Administrator
 * 
 */
@Controller("financeAction")
@Scope("prototype")
public class FinanceAction extends BaseActionSupport {
	@Resource
	private IFinanceService financeService = null;

	@Resource
	private IPurchaseRecordService purchaseRecordService = null;
	@Resource
	private ISellRecordService sellRecordService = null;

	private Pagination<Finance> pagination = new Pagination<Finance>();

	private String beginDate;

	private String endDate;

	private Message message = new Message();

	private String[] financeIds = null;

	/**
	 * 显示供应商列表
	 * 
	 * @return
	 */
	public String showFinanceList() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", sessionCompanyId);
		pagination = financeService.findForPage(map, pagination);
		return SUCCESS;
	}

	/**
	 * 保存
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveFinance() throws Exception {
		if (StringUtils.isNotBlank(beginDate) && StringUtils.isNotBlank(endDate)) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");// format格式："yyyy-MM-dd"
			ParsePosition pos = new ParsePosition(0);
			ParsePosition pos2= new ParsePosition(0);
			Date myBeginDate = formatter.parse(beginDate, pos);
			Date myEndDate = formatter.parse(endDate, pos2);
			Date date = new Date();
			Finance finance = new Finance();
			finance.setCompanyId(sessionCompanyId);
			finance.setBeginDate(beginDate);
			finance.setEndDate(endDate);
			// 销售总额,根据销售记录中，到查询日期止，所有用户产生的所有销售单中的交易总额和?？
			// totalSellAmount
			BigDecimal bTotalSellAmount = sellRecordService.getTotalMoneyByType("RECEIVABLE", sessionCompanyId, beginDate, endDate);
			float totalSellAmount =  bTotalSellAmount.floatValue();
			finance.setTotalSellAmount(totalSellAmount);
			// 应收款总额：根据销售记录中，到查询日期止，所有用户产生的所有销售单中的交易总额和
			// totalAccountDue;
			BigDecimal bTotalAccountDue = sellRecordService.getTotalMoneyByType("RECEIVABLE", sessionCompanyId, beginDate, endDate);
			float totalAccountDue =  bTotalAccountDue.floatValue();
			finance.setTotalAccountDue(totalAccountDue);
			// 实际收入：根据销售记录中，到查询日期止，所有用户产生的所有销售单中的实收和
			// totalActualReceipt
			BigDecimal bTotalActualReceipt = sellRecordService.getTotalMoneyByType("REAL_COLLECTION", sessionCompanyId, beginDate, endDate);
			float totalActualReceipt =  bTotalActualReceipt.floatValue();
			finance.setTotalActualReceipt(totalActualReceipt);
			// 欠款：根据销售记录中，到查询日期止，所有用户产生的所有销售单中的欠款和
			// totalAmountInArrear
			BigDecimal bTotalAmountInArrear = sellRecordService.getTotalMoneyByType("DEBT", sessionCompanyId, beginDate, endDate);
			float totalAmountInArrear =  bTotalAmountInArrear.floatValue();
			finance.setTotalAmountInArrear(totalAmountInArrear);
			// 进货总额：根据采购记录中，到查询日期止，所有用户产生的所有采购单中的（数量X单价）和
			// totalAmountPurchase
			float totalAmountPurchase = purchaseRecordService.queryFinanceList(sessionCompanyId, beginDate, endDate,FinanceListType.JIN_HUO_ZONG_E);
			finance.setTotalAmountPurchase(totalAmountPurchase);

			// 应付款总额
			// totalAmountDue
			float totalAmountDue = purchaseRecordService.queryFinanceList(sessionCompanyId, beginDate, endDate,FinanceListType.YING_FU_KUAN_ZONG_E );
			finance.setTotalAmountDue(totalAmountDue);
			
			// 实际支出：根据采购记录中，到查询日期止，所有用户产生的所有采购单中的实际支出和
			// totalActualOutlay
			float totalActualOutlay = purchaseRecordService.queryFinanceList(sessionCompanyId, beginDate, endDate,FinanceListType.SHI_JI_ZHI_CHU );
			finance.setTotalActualOutlay(totalActualOutlay);

			// 库存总额： 根据库存记录中，到查询日期止，所有库存 总和 等于进货总－销售总
			// totalInventory
			float totalInventory = totalAmountPurchase-totalSellAmount;//purchaseRecordService.queryFinanceList(sessionCompanyId, beginDate, endDate,FinanceListType.KU_CUN_ZONG_E );
			finance.setTotalInventory(totalInventory);
			// 总利润：销售总额－ 进货总额
			// totalProfit
			finance.setTotalProfit(totalSellAmount-totalAmountPurchase);
			finance.setCreateTime(date);
			financeService.saveOrUpdate(finance);
			message.setContent("财务清单保存成功！");
			// 保存日志开始
			Log log = new Log();
			log.setLogType(LogType.INFO);
			log.setLogContent("[" + finance.getBeginDate() + "-" + finance.getEndDate() + "]" + "财务清单保存成功");
			super.saveLog(log);
		}
		return this.showFinanceList();
	}

	/**
	 * 删除记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteFinance() throws Exception {
		if (financeIds != null && financeIds.length > 0) {
			Finance finance = null;
			Log log = null;
			for (int i = 0; i < financeIds.length; i++) {
				finance = financeService.get(financeIds[i]);
				if (finance != null) {
					log = new Log();
					log.setLogType(LogType.INFO);
					log.setLogContent("[" + finance.getBeginDate() + "-" + finance.getEndDate() + "]" + "财务清单删除成功");
					super.saveLog(log);
				}
			}
		}
		financeService.delete(financeIds);
		return this.showFinanceList();
	}

	public Pagination<Finance> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Finance> pagination) {
		this.pagination = pagination;
	}

	public IFinanceService getFinanceService() {
		return financeService;
	}

	public void setFinanceService(IFinanceService financeService) {
		this.financeService = financeService;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String[] getFinanceIds() {
		return financeIds;
	}

	public void setFinanceIds(String[] financeIds) {
		this.financeIds = financeIds;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public IPurchaseRecordService getPurchaseRecordService() {
		return purchaseRecordService;
	}

	public void setPurchaseRecordService(IPurchaseRecordService purchaseRecordService) {
		this.purchaseRecordService = purchaseRecordService;
	}

	public ISellRecordService getSellRecordService() {
		return sellRecordService;
	}

	public void setSellRecordService(ISellRecordService sellRecordService) {
		this.sellRecordService = sellRecordService;
	}
}
