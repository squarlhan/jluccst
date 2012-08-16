/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.crm.servicemanage.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.servicemanage.model.MemberInfo;
import com.boan.crm.servicemanage.model.MemberType;
import com.boan.crm.servicemanage.model.PointInfo;
import com.boan.crm.servicemanage.model.ServiceLog;
import com.boan.crm.servicemanage.service.IMemberInfoService;
import com.boan.crm.servicemanage.service.IMemberTypeService;
import com.boan.crm.servicemanage.service.IPointInfoService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;


/**
 * 会员Action类
 * 
 * @author leon
 * @version 1.0.0
 */
@Controller("pointInfoAction")
@Scope("prototype")
public class PointInfoAction extends BaseActionSupport {

	private static final long serialVersionUID = -8392821825214962629L;

	@Resource
	//积分接口类
	private IPointInfoService pointInfoService;
	@Resource
	//会员接口类
	private IMemberInfoService memberInfoService;
	@Resource
	//会员类别接口类
	private IMemberTypeService memberTypeService;
	
	//会员对象
	private MemberInfo memberInfo = null;
	
	//积分对象
	private PointInfo pointInfo = null;
	
	//会员对象集合
	private List<PointInfo> pointInfos = null;
	
	//显示分页
	private Pagination<PointInfo> pagination = new Pagination<PointInfo>();
	
	//显示分页
	private Pagination<MemberInfo> memberPagination = new Pagination<MemberInfo>();
	
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
			memberPagination = memberInfoService.findForPage(map, memberPagination );
		else
			memberPagination = memberInfoService.findForPage(null, memberPagination );
		return SUCCESS;
	}
	
	
	/**
	 * 会员对象集合
	 * @return 结果
	 */
	public String pointInfoList(){
		//		//测试增加记录
		//		String tempCompanyId = "cbit1";//客户ID
		//		String tempCompanyName = "易得信息科技";//客户名称
		//		String consumptionId = "111111";//销售记录ID
		//		PointInfo pi = pointInfoService.getByConsumptionId(consumptionId);
		//		if(pi==null){
		//			pi = new PointInfo();
		//			pi.setConsumptionId(consumptionId);
		//		}
		//		pi.setCompanyId(tempCompanyId);
		//		pi.setCompanyName(tempCompanyName);
		//		pi.setConsumptionTime(Calendar.getInstance());//消费时间
		//		pi.setConsumptionMoney(Float.parseFloat("55.88"));//消费金额
		//		pi.setPoint((int)pi.getConsumptionMoney());//消费积分
		//		pointInfoService.saveOrUpdate(pi);
		//		//更新会员积分信息
		//		MemberInfo mi = memberInfoService.getByCompanyId(tempCompanyId);//客户ID
		//		if(mi==null){
		//			mi = new MemberInfo();
		//			mi.setCreateTime(Calendar.getInstance());
		//		}
		//		mi.setCompanyId(tempCompanyId);
		//		mi.setCompanyName(tempCompanyName);
		//		mi.setConsumptionAmount(pointInfoService.getConsumptionAmount(tempCompanyId));//消费总额
		//		mi.setTotalPoint(pointInfoService.getTotalPoint(tempCompanyId));//总积分
		//		
		//		//设置会员类别
		//		List<MemberType> memberTypes = memberTypeService.memberTypeList();
		//		if(memberTypes!=null&&memberTypes.size()>0){
		//			for (MemberType memberType : memberTypes) {
		//				if(mi.getTotalPoint()>=memberType.getMinStandard() && mi.getTotalPoint()<=memberType.getMaxStandard()){
		//					mi.setMemberType(memberType.getTypeName());
		//					break;
		//				}
		//			}
		//		}else{
		//			mi.setMemberType("普通会员");
		//		}
		//		memberInfoService.updateInfo(mi);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyId", companyId );
		if(companyId!=null)
			pagination = pointInfoService.findForPage(map, pagination );
		return SUCCESS;
	}

	/**
	 * @return the pointInfo
	 */
	public PointInfo getPointInfo() {
		return pointInfo;
	}

	/**
	 * @param pointInfo the pointInfo to set
	 */
	public void setPointInfo(PointInfo pointInfo) {
		this.pointInfo = pointInfo;
	}

	/**
	 * @return the pointInfos
	 */
	public List<PointInfo> getPointInfos() {
		return pointInfos;
	}

	/**
	 * @param pointInfos the pointInfos to set
	 */
	public void setPointInfos(List<PointInfo> pointInfos) {
		this.pointInfos = pointInfos;
	}

	/**
	 * @return the pagination
	 */
	public Pagination<PointInfo> getPagination() {
		return pagination;
	}

	/**
	 * @param pagination the pagination to set
	 */
	public void setPagination(Pagination<PointInfo> pagination) {
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
	 * @return the memberPagination
	 */
	public Pagination<MemberInfo> getMemberPagination() {
		return memberPagination;
	}


	/**
	 * @param memberPagination the memberPagination to set
	 */
	public void setMemberPagination(Pagination<MemberInfo> memberPagination) {
		this.memberPagination = memberPagination;
	}
	
}
