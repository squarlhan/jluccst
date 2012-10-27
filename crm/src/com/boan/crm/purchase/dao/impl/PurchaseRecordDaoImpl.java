package com.boan.crm.purchase.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.boan.crm.purchase.dao.IPurchaseRecordDao;
import com.boan.crm.purchase.model.PurchaseRecord;
import com.boan.crm.utils.dao.impl.BaseDao;

@Repository("purchaseRecordDao")
public class PurchaseRecordDaoImpl extends BaseDao<PurchaseRecord, String> implements IPurchaseRecordDao {

	@Override
	public void deleteByBatchIds(String... batchIds) throws Exception {
		String hql = "delete PurchaseRecord where batchId in ( :batchIds ) order by createTime";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("batchIds", batchIds);
		super.executeHql(hql, map);
	}
	
	public Object[] queryRecordSum(String batchId) {
		
		String hql = "select sum(a.freight), sum(a.accountPayable), sum(a.actualPayment), sum(a.amountInArrear), sum(amount) from PurchaseRecord a where a.batchId =  :batchId ";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("batchId", batchId);
		List list = super.find(hql.toString(), map);
		Object[] objects = (Object[] )list.get(0);
		return objects;
	}

	@Override
	public float queryTotalAmountPurchase(String companyId, String beginDate, String endDate) {
		float result = 0.0f;
		StringBuffer sb = new StringBuffer();
		sb.append( "select sum(a.unitPrice * a.amount) from PurchaseRecord a,PurchaseBatch b where a.companyId =  :companyId ");
		sb.append( " and a.batchId = b.id  and ( b.transactionDate between :beginDate and :endDate  ) " );
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", companyId);
		map.put("beginDate", beginDate);
		map.put("endDate", endDate);
		List list = super.find(sb.toString(), map);
		if( list != null && list.size() > 0 )
		{
			try
			{
				Double val = (Double)list.get(0);
				result =val.floatValue();
			}
			catch( Exception e )
			{
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
