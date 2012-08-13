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
	 * 获得根据会员ID，获得会员对象
	 * @param id 会员ID
	 * @return 会员对象
	 */
	public MemberInfo get(String id);

	/**
	 * 删除会员
	 * @param ids 会员ID
	 */
	public void deleteMemberInfo(String... ids);

	/**
	 * 保存会员信息
	 * @param obj 会员对象
	 */
	public void saveOrUpdate(MemberInfo obj);

	/**
	 * 分页显示会员
	 * @param values 参数
	 * @param pagination 分页对象
	 * @return 会员对象集合
	 */
	public Pagination<MemberInfo> findForPage(Map<String, ?> values, Pagination<MemberInfo> pagination);
}
