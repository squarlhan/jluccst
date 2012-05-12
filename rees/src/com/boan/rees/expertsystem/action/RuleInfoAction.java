/*
 * @(#)RuleAdviceInfoAction.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.type.model.DeviceType;
import com.boan.rees.device.type.service.IDeviceTypeService;
import com.boan.rees.expertsystem.model.RuleAdviceInfo;
import com.boan.rees.expertsystem.model.RuleInfo;
import com.boan.rees.expertsystem.model.RuleReasonInfo;
import com.boan.rees.expertsystem.model.RuleResultInfo;
import com.boan.rees.expertsystem.model.RuleView;
import com.boan.rees.expertsystem.service.IRuleAdviceInfoService;
import com.boan.rees.expertsystem.service.IRuleInfoService;
import com.boan.rees.expertsystem.service.IRuleReasonInfoService;
import com.boan.rees.expertsystem.service.IRuleResultInfoService;
import com.boan.rees.expertsystem.service.IRuleViewService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;

/**
 * 建议Action类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Controller("ruleInfoAction")
@Scope("prototype")
public class RuleInfoAction extends BaseActionSupport{
	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("ruleInfoService")
	private IRuleInfoService service;
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
	/**
	 * 分页列表
	 */
	Pagination<RuleInfo> pagination = new Pagination<RuleInfo>();
	/**
	 * 页面对象
	 */
	private RuleInfo ruleInfo;
	
	private RuleView ruleView;
	private List<DeviceType> deviceTypeList;
	private List<RuleAdviceInfo> adviceList;
	private List<RuleReasonInfo> reasonList;
	private List<RuleResultInfo> resultList;
	
	private Map<String,String> resultMap;
	
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
	private Integer[] ids;
	
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

	public Pagination<RuleInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<RuleInfo> pagination) {
		this.pagination = pagination;
	}

	public RuleInfo getRuleInfo() {
		return ruleInfo;
	}

	public void setRuleInfo(RuleInfo ruleInfo) {
		this.ruleInfo = ruleInfo;
	}

	public RuleView getRuleView() {
		return ruleView;
	}

	public void setRuleView(RuleView ruleView) {
		this.ruleView = ruleView;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
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
	public String openRuleInfo(){
		pagination = service.findRuleInfoForPage( new HashMap(), pagination);
		
		List<RuleInfo> temp = pagination.getData();
		for(int i=0;i<temp.size();i++){
			RuleInfo obj = temp.get(i);
			int adviceId = obj.getAdviceId();
			String deviceTypeId = obj.getDeviceTypeId();
			String reasonIdStr = obj.getReasonId();
			String resultIdStr = obj.getResultId();
			
			String deviceTypeName = deviceTypeService.get(deviceTypeId).getTypeName();
			String adviceName =  ruleAdviceInfoService.get(adviceId).getAdvice();
			int reasonId =Integer.parseInt( reasonIdStr.substring(1));
			String reasonName = ruleReasonInfoService.get(reasonId).getReason();
			String[] resultIds = resultIdStr.split("_");
			StringBuffer strb= new StringBuffer();
			for(String str : resultIds){
				resultId = str.substring(1);
				String name ="";
				if(str.substring(0, 1).equals("A")){
					name = ruleReasonInfoService.get(Integer.parseInt(resultId)).getReason();
				}else if(str.substring(0, 1).equals("B")){
					name = ruleResultInfoService.get(Integer.parseInt(resultId)).getResult();
				}
				strb.append(name);
				strb.append(",");
			}
			String resultName = strb.substring(0, strb.length()-1);
			
			obj.setTypeName(deviceTypeName);
			obj.setAdvice(adviceName);
			obj.setReason(reasonName);
			obj.setResult(resultName);
			temp.set(i, obj);
		}
		pagination.setData(temp);
		return this.SUCCESS;
	}

    

	/**
	 * 打开添加新建议页
	 * @return
	 */
	
	public String openAddRuleInfo(){
		deviceTypeList=deviceTypeService.findAllDeviceType();
		adviceList=new ArrayList<RuleAdviceInfo>();
		reasonList=new ArrayList<RuleReasonInfo>();
		resultList=new ArrayList<RuleResultInfo>();
		resultList=new ArrayList<RuleResultInfo>();
		resultList.add(new RuleResultInfo());
		ruleInfo = new RuleInfo();
		return SUCCESS;
	}
	/**
	 * 添加新建议
	 * @return
	 */
	public String toAddRuleInfo(){
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
	public String deleteRuleInfo(){
		service.deleteRuleInfo(ids);
		return NONE;
	}
	
	/**
	 * 为修改建议做准备
	 * @return
	 */
	public String openModifyRuleInfo(){
		
		ruleInfo = service.get(ruleInfo.getId());
		
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
		
		int id = ruleInfo.getId();
		ruleInfo = service.get(id);
		return SUCCESS;
	}
	
	/**
	 * 修改建议信息
	 * @return 
	 */
	public String toModifyRuleInfo(){
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
	public String toDeleteResult(){
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
		String newStr = sbr.substring(0, sbr.lastIndexOf("_"));
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
	
}

