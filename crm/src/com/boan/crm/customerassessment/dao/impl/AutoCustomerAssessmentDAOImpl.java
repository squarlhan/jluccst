/**
 * 
 */
package com.boan.crm.customerassessment.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.customerassessment.dao.IAutoCustomerAssessmentDAO;
import com.boan.crm.customerassessment.model.AutoCustomerAssessment;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author luojx
 * 客户分析设置DAO实现类
 */
@Repository("autoCustomerAssessmentDao")
public class AutoCustomerAssessmentDAOImpl extends BaseDao<AutoCustomerAssessment, String> implements IAutoCustomerAssessmentDAO {

}
