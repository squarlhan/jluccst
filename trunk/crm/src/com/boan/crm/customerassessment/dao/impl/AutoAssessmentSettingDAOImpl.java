/**
 * 
 */
package com.boan.crm.customerassessment.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.customerassessment.dao.IAutoAssessmentSettingDAO;
import com.boan.crm.customerassessment.model.AutoAssessmentSetting;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author luojx
 * 客户分析设置DAO实现类
 */
@Repository("autoAssessmentSettingDao")
public class AutoAssessmentSettingDAOImpl extends BaseDao<AutoAssessmentSetting, String> implements IAutoAssessmentSettingDAO {

}
