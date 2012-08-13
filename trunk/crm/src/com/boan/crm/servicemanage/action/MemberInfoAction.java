/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.crm.servicemanage.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.servicemanage.model.MemberInfo;
import com.boan.crm.servicemanage.service.IMemberInfoService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;


/**
 * 会员Action类
 * 
 * @author leon
 * @version 1.0.0
 */
@Controller("memberInfoAction")
@Scope("prototype")
public class MemberInfoAction extends BaseActionSupport {

	private static final long serialVersionUID = -8392821825214962629L;

	@Resource
	//会员接口类
	private IMemberInfoService memberInfoService;
	
	//会员对象
	private MemberInfo memberInfo = null;
	
	//会员对象集合
	private List<MemberInfo> memberInfos = null;
	
	//显示分页
	private Pagination<MemberInfo> pagination = new Pagination<MemberInfo>();
	
	//会员ID
	private String infoId;
	
	private String[] infoIds;
	
	private String companyId;
	private String companyName;
	
	private String searchCompanyName;
	
	/**
	 * 会员对象集合
	 * @return 结果
	 */
	public String memberInfoList(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyName", "%" + searchCompanyName + "%" );
		if(searchCompanyName!=null)
			pagination = memberInfoService.findForPage(map, pagination );
		else
			pagination = memberInfoService.findForPage(null, pagination );
		return SUCCESS;
	}
	
	/**
	 * 获得会员对象信息
	 * @return
	 */
	public String memberInfoInfo(){
		if(StringUtils.trimToNull(infoId)!=null)
			memberInfo = memberInfoService.getById(infoId);
		else
			memberInfo = new MemberInfo();
		return SUCCESS;
	}

	/**
	 * 删除会员信息
	 * @return
	 */
	public String cancelInfo(){
		if(infoIds!=null){
			memberInfoService.cancelInfo(infoIds);
		}
		return SUCCESS;
	}

	/**
	 * @return the memberInfo
	 */
	public MemberInfo getMemberInfo() {
		return memberInfo;
	}

	/**
	 * @param memberInfo the memberInfo to set
	 */
	public void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}

	/**
	 * @return the memberInfos
	 */
	public List<MemberInfo> getMemberInfos() {
		return memberInfos;
	}

	/**
	 * @param memberInfos the memberInfos to set
	 */
	public void setMemberInfos(List<MemberInfo> memberInfos) {
		this.memberInfos = memberInfos;
	}

	/**
	 * @return the pagination
	 */
	public Pagination<MemberInfo> getPagination() {
		return pagination;
	}

	/**
	 * @param pagination the pagination to set
	 */
	public void setPagination(Pagination<MemberInfo> pagination) {
		this.pagination = pagination;
	}

	/**
	 * @return the infoId
	 */
	public String getInfoId() {
		return infoId;
	}

	/**
	 * @param infoId the infoId to set
	 */
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	/**
	 * @return the infoIds
	 */
	public String[] getInfoIds() {
		return infoIds;
	}

	/**
	 * @param infoIds the infoIds to set
	 */
	public void setInfoIds(String[] infoIds) {
		this.infoIds = infoIds;
	}

	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * @return the searchCompanyName
	 */
	public String getSearchCompanyName() {
		return searchCompanyName;
	}

	/**
	 * @param searchCompanyName the searchCompanyName to set
	 */
	public void setSearchCompanyName(String searchCompanyName) {
		this.searchCompanyName = searchCompanyName;
	}
}
