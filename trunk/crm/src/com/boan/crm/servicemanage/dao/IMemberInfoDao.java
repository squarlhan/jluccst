package com.boan.crm.servicemanage.dao;

import com.boan.crm.servicemanage.model.MemberInfo;
import com.boan.crm.utils.dao.IBaseDao;

/**
 * 会员管理DAO接口
 * @author XXX
 * @version 1.0.0
 */
public interface IMemberInfoDao extends IBaseDao<MemberInfo,String> {
	/**
	 * 根据单位ID判断是否为会员
	 * @param companyId 单位ID
	 * @return true：是会员，false：不是会员
	 */
	public boolean isMember(String companyId);
	
	/**
	 * 根据单位ID获得会员实现信息
	 * @param companyId 单位ID
	 * @return 会员信息对象
	 */
	public MemberInfo getByCompanyId(String companyId);
}
