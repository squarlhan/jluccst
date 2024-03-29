package com.boan.crm.purchase.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.purchase.dao.IRepertoryDao;
import com.boan.crm.purchase.model.Repertory;
import com.boan.crm.purchase.service.IRepertoryService;
import com.boan.crm.sellrecord.service.ISellRecordService;
import com.boan.crm.utils.page.Pagination;

@Service("repertoryService")
public class RepertoryServiceImpl implements IRepertoryService {

	@Autowired
	@Qualifier("repertoryDao")
	private IRepertoryDao dao = null;
	@Resource
	private ISellRecordService sellRecordService = null;

	@Override
	public Pagination<Repertory> findForPage(Map<String, ?> values, Pagination<Repertory> pagination) {
		String companyId = (String)values.get("companyId");
		StringBuffer sb = new StringBuffer();
		sb.append("  select a.companyId, a.productId, a.productName, sum(a.amount), sum(a.freight), ");
		sb.append(" sum(a.accountPayable), sum(a.actualPayment), sum(a.amountInArrear), sum(a.amount * a.unitPrice ) from PurchaseRecord a where a.companyId = :companyId ");
		sb.append(" group by a.productId");
		List<Object> list = dao.findForPage(sb.toString(), values, pagination.getStartIndex(), pagination.getPageSize());
		List<Repertory> data = new ArrayList<Repertory>();
		if (list != null && list.size() > 0) {
			Repertory repertory = null;
			int purchaseAmount = 0;
			int sellAmount = 0;
			for (int i = 0; i < list.size(); i++) {
				repertory = new Repertory();
				Object[] objs = (Object[]) list.get(i);
				// 重新构造数据
				repertory.setCompanyId(objs[0].toString());
				repertory.setProductId(objs[1].toString());
				repertory.setProductName(objs[2].toString());
				// 库存量＝采购数－销售量
				purchaseAmount = Integer.parseInt(objs[3].toString()); // 采购数
				sellAmount = sellRecordService.getSellTotalAmount(companyId,repertory.getProductId() );   // 销售量
				repertory.setAmount(purchaseAmount - sellAmount);
				repertory.setFreight(Float.parseFloat(objs[4].toString()));
				repertory.setAccountPayable(Float.parseFloat(objs[5].toString()));
				repertory.setActualPayment(Float.parseFloat(objs[6].toString()));
				repertory.setAmountInArrear(Float.parseFloat(objs[7].toString()));
				repertory.setTotalValue(Float.parseFloat(objs[8].toString()));
				data.add(repertory);
			}
		}
		String hql = "select  count(*) from PurchaseRecord a  where a.companyId = :companyId group by a.productId ";
		List<Object> countList = dao.find(hql, values);
		int totalRows = countList.size();
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	public ISellRecordService getSellRecordService() {
		return sellRecordService;
	}

	public void setSellRecordService(ISellRecordService sellRecordService) {
		this.sellRecordService = sellRecordService;
	}

}
