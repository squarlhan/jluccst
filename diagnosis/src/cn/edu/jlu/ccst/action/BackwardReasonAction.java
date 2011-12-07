package cn.edu.jlu.ccst.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.model.BackwardandReason;
import cn.edu.jlu.ccst.model.User;

import cn.edu.jlu.ccst.service.BackwardandReasonService;
import cn.edu.jlu.ccst.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;




@Component("backwardResonAction")
@Scope("prototype")
public class BackwardReasonAction extends ActionSupport {
 private  BackwardandReasonService backwardandReasonService;
 private  BackwardandReason backwardandReason;
 
 
public BackwardandReasonService getBackwardandReasonService() {
	return backwardandReasonService;
}
 @Resource
public void setBackwardandReasonService(
		BackwardandReasonService backwardandReasonService) {
	this.backwardandReasonService = backwardandReasonService;
}

 public String update(){
	 backwardandReasonService.update(backwardandReason);
	 return "success";
 }
 public String delete() {
	 backwardandReason = backwardandReasonService.findbyid(backwardandReason.getId());
	 backwardandReasonService.removebyid(backwardandReason.getId());
	
		return "success";

	}
	
	
	
}