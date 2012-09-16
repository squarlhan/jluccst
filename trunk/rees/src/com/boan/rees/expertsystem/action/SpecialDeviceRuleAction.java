/*
 * @(#)SpecialDeviceRuleAction.java 1.1 2012-9-13
 */

package com.boan.rees.expertsystem.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.model.PointInfo;
import com.boan.rees.device.model.PointParamInfo;
import com.boan.rees.device.service.IDeviceInfoService;
import com.boan.rees.device.service.IPointInfoService;
import com.boan.rees.device.service.IPointParamInfoService;
import com.boan.rees.device.type.model.DeviceType;
import com.boan.rees.device.type.service.IDeviceTypeService;
import com.boan.rees.expertsystem.model.RuleAdviceInfo;
import com.boan.rees.expertsystem.model.RuleReasonInfo;
import com.boan.rees.expertsystem.model.RuleResultInfo;
import com.boan.rees.expertsystem.model.RuleView;
import com.boan.rees.expertsystem.model.SpecialDeviceRuleInfo;
import com.boan.rees.expertsystem.service.IRuleAdviceInfoService;
import com.boan.rees.expertsystem.service.IRuleReasonInfoService;
import com.boan.rees.expertsystem.service.IRuleResultInfoService;
import com.boan.rees.expertsystem.service.IRuleViewService;
import com.boan.rees.expertsystem.service.ISpecialDeviceRuleService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;

/**
 * XXX 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Controller( "specialDeviceRuleAction" )
@Scope("prototype")
public class SpecialDeviceRuleAction extends BaseActionSupport{

	/**
	 * 树传过来的公司id
	 */
	private String companyId;
	
	/**
	 * 树传过来的工厂Id
	 */
	private String factoryId;
	
	/**
	 * 树传过来的车间Id
	 */
	private String workshopId;
	
	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("deviceInfoService")
	private IDeviceInfoService deviceInfoService;
	
	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("specialDeviceRuleService")
	private ISpecialDeviceRuleService service;
	@Autowired
	@Qualifier("ruleViewService")
	private IRuleViewService viewservice;
	@Autowired
	@Qualifier("deviceTypeService")
	private IDeviceTypeService deviceTypeService;
	@Autowired
	@Qualifier("ruleAdviceInfoService")
	private IRuleAdviceInfoService ruleAdviceInfoService;
	@Autowired
	@Qualifier("ruleReasonInfoService")
	private IRuleReasonInfoService ruleReasonInfoService;
	@Autowired
	@Qualifier("ruleResultInfoService")
	private IRuleResultInfoService ruleResultInfoService;
	@Autowired
	@Qualifier("pointInfoService")
	private IPointInfoService pointInfoService;
	
	@Autowired
	@Qualifier("pointParamInfoService")
	private IPointParamInfoService pointParamInfoService;
	/**
	 * 分页列表
	 */
	private Pagination<SpecialDeviceRuleInfo> pagination = new Pagination<SpecialDeviceRuleInfo>();
	/**
	 * 页面对象
	 */
	private SpecialDeviceRuleInfo ruleInfo;
	
	/**
	 * 设备信息
	 */
	private DeviceInfo device;
	
	private RuleView ruleView;
	private List<DeviceType> deviceTypeList;
	private List<RuleAdviceInfo> adviceList;
	private List<RuleReasonInfo> reasonList;
	private List<RuleResultInfo> resultList;
	
	private Map<String,String> resultMap;
	
	private Map<String,List<String>> pointInfoMap = new HashMap<String,List<String>>();
	
	
	Map<String,String> newResultMap = new HashMap<String,String>();
	
	/**
	 * ajax 前台传过来的设备类型Id
	 */
	private String deviceTypeId;
	/**
	 * ajax设备类型关联出来的信息
	 */
	private Map deviceTypeCascadeInfo;
	
	/**
	 * 下拉设备列表事件传递过来的设备类型Id
	 */
	//private String deviceTypeId;
	
	/**
	 * 页面所选行的id
	 */
	private String[] ids;
	
	/**
	 * 操作提示
	 */
	private String message;
	
	/**
	 * ajax传过来要删除的故障Id
	 */
	private String resultId;
	
	
	public List<RuleAdviceInfo> getAdviceList() {
		return adviceList;
	}

	public void setAdviceList(List<RuleAdviceInfo> adviceList) {
		this.adviceList = adviceList;
	}

	public List<RuleReasonInfo> getReasonList() {
		return reasonList;
	}

	public void setReasonList(List<RuleReasonInfo> reasonList) {
		this.reasonList = reasonList;
	}

	public List<RuleResultInfo> getResultList() {
		return resultList;
	}

	public void setResultList(List<RuleResultInfo> resultList) {
		this.resultList = resultList;
	}

	public List<DeviceType> getDeviceTypeList() {
		return deviceTypeList;
	}

	public void setDeviceTypeList(List<DeviceType> deviceTypeList) {
		this.deviceTypeList = deviceTypeList;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}

	public String getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(String workshopId) {
		this.workshopId = workshopId;
	}

	public Pagination<SpecialDeviceRuleInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<SpecialDeviceRuleInfo> pagination) {
		this.pagination = pagination;
	}

	public SpecialDeviceRuleInfo getRuleInfo() {
		return ruleInfo;
	}

	public void setRuleInfo(SpecialDeviceRuleInfo ruleInfo) {
		this.ruleInfo = ruleInfo;
	}

	public RuleView getRuleView() {
		return ruleView;
	}

	public void setRuleView(RuleView ruleView) {
		this.ruleView = ruleView;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResultId() {
		return resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId;
	}

	public Map<String, String> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, String> resultMap) {
		this.resultMap = resultMap;
	}

	public Map<String, String> getNewResultMap() {
		return newResultMap;
	}

	public void setNewResultMap(Map<String, String> newResultMap) {
		this.newResultMap = newResultMap;
	}

	public void setDeviceTypeCascadeInfo(Map deviceTypeCascadeInfo) {
		this.deviceTypeCascadeInfo = deviceTypeCascadeInfo;
	}

	public String getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	/**
	 * 分页显示建议列表
	 * @return
	 */
	public String openDeviceRuleList(){
		Map<String,String> param = new HashMap<String,String>();
		param.put("companyId", companyId);
		param.put("factoryId", factoryId);
		param.put("workshopId", workshopId);
		pagination =service. findRuleInfoForPage(param, pagination);
		return this.SUCCESS;
	}

    

	/**
	 * 打开添加新建议页
	 * @return
	 */
	
	public String openAddDeviceRuleInfo(){
		device = deviceInfoService.get(ruleInfo.getDeviceId());
		ruleInfo = new SpecialDeviceRuleInfo();
		ruleInfo.setDeviceId(device.getId());
		ruleInfo.setDeviceName(device.getDeviceName());
		
		List<PointInfo> pointInfoList = pointInfoService.findPointInfosByDeviceId(ruleInfo.getDeviceId());
		
		for(PointInfo pointInfo : pointInfoList){
			List<PointParamInfo> pointParamInfoList  = pointParamInfoService.findPointParamInfoByPointId(pointInfo.getId());
			List<String> paramNameList = new ArrayList<String>();
			for(PointParamInfo pointParamInfo : pointParamInfoList){
				paramNameList.add(pointParamInfo.getName());
			}
			pointInfoMap .put(pointInfo.getControlPointName(), paramNameList);
			Collections.sort(new ArrayList<Map.Entry<String, List<String>>>(
					pointInfoMap.entrySet()),
					new Comparator<Map.Entry<String, List<String>>>() {
						public int compare(
								Map.Entry<String, List<String>> mapping1,
								Map.Entry<String, List<String>> mapping2) {
							return mapping1.getKey().compareTo(
									mapping2.getKey());
						}
					});
		}
		
		
		deviceTypeList=deviceTypeService.findAllDeviceType();
		adviceList=new ArrayList<RuleAdviceInfo>();
		reasonList=new ArrayList<RuleReasonInfo>();
		resultList=new ArrayList<RuleResultInfo>();
		resultList=new ArrayList<RuleResultInfo>();
		resultList.add(new RuleResultInfo());
		return SUCCESS;
	}
	/**
	 * 添加新建议
	 * @return
	 */
	public String toAddDeviceRuleInfo(){
		try {
			//保存设备对象
			String resultIdStr = ruleInfo.getResultId();
			if(resultIdStr!=null && !resultIdStr.equals("")){
				resultIdStr=resultIdStr.replaceAll(" ", "").replaceAll(",", "_");
				ruleInfo.setResultId(resultIdStr);
			}
			service.save(ruleInfo);
			message="保存成功！";
			
			//用于回显数据
			deviceTypeList=deviceTypeService.findAllDeviceType();
			adviceList=ruleAdviceInfoService.findRuleAdviceInfoByDeviceTypeId(ruleInfo.getDeviceTypeId());
			reasonList=ruleReasonInfoService.findRuleReasonInfoByDeviceTypeId(ruleInfo.getDeviceTypeId());
			resultList=ruleResultInfoService.findRuleResultInfoByDeviceTypeId(ruleInfo.getDeviceTypeId());
			
			for(RuleResultInfo obj :resultList){
				newResultMap.put("B"+obj.getId(), obj.getResult());
			}
			for(RuleReasonInfo obj :reasonList){
				newResultMap.put("A"+obj.getId(), obj.getReason());
			}
			
			resultMap = new HashMap<String,String>();
			String resultStr = ruleInfo.getResultId();
			String[] temp = resultStr.split("_");
			for(String str : temp){
				resultMap.put(str, str);
			}
			
			List<PointInfo> pointInfoList = pointInfoService.findPointInfosByDeviceId(ruleInfo.getDeviceId());
			
			for(PointInfo pointInfo : pointInfoList){
				List<PointParamInfo> pointParamInfoList  = pointParamInfoService.findPointParamInfoByPointId(pointInfo.getId());
				List<String> paramNameList = new ArrayList<String>();
				for(PointParamInfo pointParamInfo : pointParamInfoList){
					paramNameList.add(pointParamInfo.getName());
				}
				pointInfoMap .put(pointInfo.getControlPointName(), paramNameList);
				Collections.sort(new ArrayList<Map.Entry<String, List<String>>>(
						pointInfoMap.entrySet()),
						new Comparator<Map.Entry<String, List<String>>>() {
							public int compare(
									Map.Entry<String, List<String>> mapping1,
									Map.Entry<String, List<String>> mapping2) {
								return mapping1.getKey().compareTo(
										mapping2.getKey());
							}
						});
			}
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}

	/**
	 * 删除建议
	 * @return
	 */
	public String deleteDeviceRuleInfo(){
		service.deleteRuleInfo(ids);
		return NONE;
	}
	
	/**
	 * 为修改建议做准备
	 * @return
	 */
	public String openModifyDeviceRuleInfo(){
		
		ruleInfo = service.get(""+ruleInfo.getId());
		
		deviceTypeList=deviceTypeService.findAllDeviceType();
		adviceList=ruleAdviceInfoService.findRuleAdviceInfoByDeviceTypeId(ruleInfo.getDeviceTypeId());
		reasonList=ruleReasonInfoService.findRuleReasonInfoByDeviceTypeId(ruleInfo.getDeviceTypeId());
		resultList=ruleResultInfoService.findRuleResultInfoByDeviceTypeId(ruleInfo.getDeviceTypeId());
		
		for(RuleResultInfo obj :resultList){
			newResultMap.put("B"+obj.getId(), obj.getResult());
		}
		for(RuleReasonInfo obj :reasonList){
			newResultMap.put("A"+obj.getId(), obj.getReason());
		}
		
		resultMap = new HashMap<String,String>();
		String resultStr = ruleInfo.getResultId();
		String[] temp = resultStr.split("_");
		for(String str : temp){
			resultMap.put(str, str);
		}
		
		List<PointInfo> pointInfoList = pointInfoService.findPointInfosByDeviceId(ruleInfo.getDeviceId());
		
		for(PointInfo pointInfo : pointInfoList){
			List<PointParamInfo> pointParamInfoList  = pointParamInfoService.findPointParamInfoByPointId(pointInfo.getId());
			List<String> paramNameList = new ArrayList<String>();
			for(PointParamInfo pointParamInfo : pointParamInfoList){
				paramNameList.add(pointParamInfo.getName());
			}
			pointInfoMap .put(pointInfo.getControlPointName(), paramNameList);
			Collections.sort(new ArrayList<Map.Entry<String, List<String>>>(
					pointInfoMap.entrySet()),
					new Comparator<Map.Entry<String, List<String>>>() {
						public int compare(
								Map.Entry<String, List<String>> mapping1,
								Map.Entry<String, List<String>> mapping2) {
							return mapping1.getKey().compareTo(
									mapping2.getKey());
						}
					});
		}
		return SUCCESS;
	}
	
	/**
	 * 修改建议信息
	 * @return 
	 */
	public String toModifyDeviceRuleInfo(){
		try {
			String results=ruleInfo.getResultId();
			results=results.replaceAll(" ","");
			results=results.replaceAll(",","_");
			ruleInfo.setResultId(results);
			
			String reason=ruleInfo.getReasonId();
			reason = "A"+reason;
			ruleInfo.setReasonId(reason);
			
			service.update(ruleInfo);
			message="保存成功！";
			
			//用于回显数据
			deviceTypeList=deviceTypeService.findAllDeviceType();
			adviceList=ruleAdviceInfoService.findRuleAdviceInfoByDeviceTypeId(ruleInfo.getDeviceTypeId());
			reasonList=ruleReasonInfoService.findRuleReasonInfoByDeviceTypeId(ruleInfo.getDeviceTypeId());
			resultList=ruleResultInfoService.findRuleResultInfoByDeviceTypeId(ruleInfo.getDeviceTypeId());
			
			for(RuleResultInfo obj :resultList){
				newResultMap.put("B"+obj.getId(), obj.getResult());
			}
			for(RuleReasonInfo obj :reasonList){
				newResultMap.put("A"+obj.getId(), obj.getReason());
			}
			
			resultMap = new HashMap<String,String>();
			String resultStr = ruleInfo.getResultId();
			String[] temp = resultStr.split("_");
			for(String str : temp){
				resultMap.put(str, str);
			}

			List<PointInfo> pointInfoList = pointInfoService.findPointInfosByDeviceId(ruleInfo.getDeviceId());
			
			for(PointInfo pointInfo : pointInfoList){
				List<PointParamInfo> pointParamInfoList  = pointParamInfoService.findPointParamInfoByPointId(pointInfo.getId());
				List<String> paramNameList = new ArrayList<String>();
				for(PointParamInfo pointParamInfo : pointParamInfoList){
					paramNameList.add(pointParamInfo.getName());
				}
				pointInfoMap .put(pointInfo.getControlPointName(), paramNameList);
				Collections.sort(new ArrayList<Map.Entry<String, List<String>>>(
						pointInfoMap.entrySet()),
						new Comparator<Map.Entry<String, List<String>>>() {
							public int compare(
									Map.Entry<String, List<String>> mapping1,
									Map.Entry<String, List<String>> mapping2) {
								return mapping1.getKey().compareTo(
										mapping2.getKey());
							}
						});
			}
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}
	
	/**
	 * 删除规则现象
	 * @return
	 */
	public String toDeleteResult4SpecialDeviceRule(){
		ruleInfo = service.get(ruleInfo.getId());
		String resultStr = ruleInfo.getResultId();
		String[] temp = resultStr.split("_");
		//去掉要删除现象
		List<String> results =null ;
		if(temp.length>0){
			results = new ArrayList<String>();
		}
		for(String str : temp){
			if(!str.equals(resultId)){
				results.add(str);
			}
		}
		StringBuffer sbr =new StringBuffer();
		for(String res : results){
			sbr.append(res).append("_");
		}
		String newStr =sbr.length()>0 ? sbr.substring(0, sbr.lastIndexOf("_")) : "";
		ruleInfo.setResultId(newStr);
		service.update(ruleInfo);
		return NONE;
	}
	
	/**
	 * ajax异步获取设备规则关联的信息
	 * @return
	 */
	public String getDeviceTypeCascadeInfo(){
		if(deviceTypeId!=null && !deviceTypeId.equals("")){
			adviceList=ruleAdviceInfoService.findRuleAdviceInfoByDeviceTypeId(deviceTypeId);
			reasonList=ruleReasonInfoService.findRuleReasonInfoByDeviceTypeId(deviceTypeId);
			resultList=ruleResultInfoService.findRuleResultInfoByDeviceTypeId(deviceTypeId);
			deviceTypeCascadeInfo = new HashMap();
			deviceTypeCascadeInfo.put("adviceList", adviceList);
			deviceTypeCascadeInfo.put("reasonList", reasonList);
			deviceTypeCascadeInfo.put("resultList", resultList);
		}
		return "deviceTypeCascadeInfo";
	}

	public DeviceInfo getDevice() {
		return device;
	}

	public void setDevice(DeviceInfo device) {
		this.device = device;
	}

	public Map<String, List<String>> getPointInfoMap() {
		return pointInfoMap;
	}

	public void setPointInfoMap(Map<String, List<String>> pointInfoMap) {
		this.pointInfoMap = pointInfoMap;
	}
}

