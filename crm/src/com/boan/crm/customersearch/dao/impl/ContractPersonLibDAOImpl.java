/**
 * 
 */
package com.boan.crm.customersearch.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.customersearch.dao.IContractPersonLibDAO;
import com.boan.crm.customersearch.model.ContractPersonLibInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author luojx
 * 联系人DAO实现类
 */
@Repository("contractPersonLibDao")
public class ContractPersonLibDAOImpl extends BaseDao<ContractPersonLibInfo, String> implements IContractPersonLibDAO {

}
