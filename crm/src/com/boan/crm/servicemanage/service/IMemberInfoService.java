package com.boan.crm.servicemanage.service;

import java.util.Map;

import com.boan.crm.servicemanage.model.MemberInfo;
import com.boan.crm.utils.page.Pagination;

/**
 * 会员管理接口类
 * @author XXX
 * @version 1.0.0
 */
public interface IMemberInfoService {
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
	
	/**
	 * 成为会员
	 * @param obj 会员对象
	 */
	public void toMemberInfo(MemberInfo obj);
	
	/**
	 * 获得根据会员ID，获得会员对象
	 * @param id 会员ID
	 * @return 会员对象
	 */
	public MemberInfo getById(String id);

	/**
	 * 取消会员状态
	 * @param ids 会员ID
	 */
	public void deleteInfo(String... ids);

	/**
	 * 保存会员信息
	 * @param obj 会员对象
	 */
	public void updateInfo(MemberInfo obj);

	/**
	 * 分页显示会员
	 * @param values 参数
	 * @param pagination 分页对象
	 * @return 会员对象集合
	 */
	public Pagination<MemberInfo> findForPage(Map<String, ?> values, Pagination<MemberInfo> pagination);
}
