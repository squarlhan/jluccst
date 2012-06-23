/**
 * 
 */
package com.boan.crm.customer.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.customer.dao.IContractPersonDAO;
import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author luojx
 * 联系人DAO实现类
 */
@Repository("contractPersonDao")
public class ContractPersonDAOImpl extends BaseDao<ContractPersonInfo, String> implements IContractPersonDAO {

}
