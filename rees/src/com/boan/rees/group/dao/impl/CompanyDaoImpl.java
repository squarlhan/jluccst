package com.boan.rees.group.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.boan.rees.utils.dao.impl.BaseDao;
import com.boan.rees.group.dao.ICompanyDao;
import com.boan.rees.group.model.Company;
/**
* 公司Dao接口实现
* @author Guiyun Yang
* @version 1.0.0
*/

@Repository("groupCompanyDao")
public class CompanyDaoImpl extends BaseDao<Company,String> implements ICompanyDao{

	

}
