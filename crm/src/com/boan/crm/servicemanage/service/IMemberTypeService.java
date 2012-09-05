package com.boan.crm.servicemanage.service;

import java.util.List;

import com.boan.crm.servicemanage.model.MemberType;

/**
 * 会员类别接口类
 * @author XXX
 * @version 1.0.0
 */
public interface IMemberTypeService {
	/**
	 * 获得根据会员类别ID，获得会员类别对象
	 * @param id 类别记录ID
	 * @return 会员类别对象
	 */
	public MemberType get(String id);

	/**
	 * 删除会员类别
	 * @param ids 会员类别ID
	 */
	public void deleteMemberType(String... ids);

	/**
	 * 保存会员类别信息
	 * @param obj 会员类别对象
	 */
	public void saveOrUpdate(MemberType obj);

	/**
	 * 显示会员类别对象集合
	 * @param myCompanyId 所属单位ID
	 * @return 会员类别对象集合
	 */
	public List<MemberType> memberTypeList(String myCompanyId);
}
