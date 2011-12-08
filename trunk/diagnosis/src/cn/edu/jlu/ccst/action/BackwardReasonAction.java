package cn.edu.jlu.ccst.action;

import java.io.UnsupportedEncodingException;
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
 
 
public BackwardandReason getBackwardandReason() {
	return backwardandReason;
}
public void setBackwardandReason(BackwardandReason backwardandReason) {
	this.backwardandReason = backwardandReason;
}
public BackwardandReasonService getBackwardandReasonService() {
	return backwardandReasonService;
}
 @Resource
public void setBackwardandReasonService(
		BackwardandReasonService backwardandReasonService) {
	this.backwardandReasonService = backwardandReasonService;
}

 public String update(){
	 BackwardandReason temp = backwardandReasonService.findbyid(backwardandReason.getId());
	 try {
		String nouns= new String(backwardandReason.getNouns().getBytes("ISO-8859-1"),"UTF-8");
		String verb= new String(backwardandReason.getVerb().getBytes("ISO-8859-1"),"UTF-8"); 
		 String sugg= new String(backwardandReason.getSugg().getBytes("ISO-8859-1"),"UTF-8"); 
		 backwardandReason.setNouns(nouns);
		 backwardandReason.setSugg(sugg);
		 backwardandReason.setVerb(verb);
		 if(temp.getId()>0){
			 backwardandReason.setBid(temp.getBid());
			 backwardandReasonService.update(backwardandReason);
			 return "success";
		 }
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 
	
	 return "error";
	 
 }
 public String delete() {
	 backwardandReason = backwardandReasonService.findbyid(backwardandReason.getId());
	 backwardandReasonService.removebyid(backwardandReason.getId());
	
		return "success";

	}
	
	
	
}