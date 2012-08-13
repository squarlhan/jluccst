package com.boan.crm.marketinquiry.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.marketinquiry.dao.IMarketInquiryDao;
import com.boan.crm.marketinquiry.model.MarketInquiry;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * 市场调查数据库操作接口
 * @author YF
 *
 */
@Repository("marketInquiryDao")
public class MarketInquiryDaoImpl  extends BaseDao<MarketInquiry, String> implements IMarketInquiryDao {

}
