package cn.edu.jlu.ccst.action;



import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import cn.edu.jlu.ccst.model.BackwardandUpper;
import cn.edu.jlu.ccst.service.BackUpperService;







@Component("backUpperAction")
@Scope("prototype")
public class BackUpperAction extends ActionSupport {

	private BackUpperService backUpperService; 
	private BackwardandUpper backwardandUpper; 



	
	

	

	







	public BackUpperService getBackUpperService() {
		return backUpperService;
	}

	@Resource
public void setBackUpperService(BackUpperService backUpperService) {
		this.backUpperService = backUpperService;
	}


public BackwardandUpper getBackwardandUpper() {
		return backwardandUpper;
	}


public void setBackwardandUpper(BackwardandUpper backwardandUpper) {
		this.backwardandUpper = backwardandUpper;
	}
















	public String execute() {
		
		
		backUpperService.save(backwardandUpper ) ;
		   
		  return "backuppersuccess";}
	
		}




		
		
		

	
