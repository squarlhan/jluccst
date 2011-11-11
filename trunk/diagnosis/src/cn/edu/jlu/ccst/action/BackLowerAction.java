package cn.edu.jlu.ccst.action;



import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import cn.edu.jlu.ccst.model.BackwardandLower;
import cn.edu.jlu.ccst.service.BackLowerService;







@Component("backLowerAction")
@Scope("prototype")
public class BackLowerAction extends ActionSupport {

	private BackLowerService backLowerService; 
	private BackwardandLower backwardandLower; 


	public BackLowerService getBackLowerService() {
		return backLowerService;
	}

      @Resource

	public void setBackLowerService(BackLowerService backLowerService) {
		this.backLowerService = backLowerService;
	}

     public BackwardandLower getBackwardandLower() {
		return backwardandLower;
	}

     public void setBackwardandLower(BackwardandLower backwardandLower) {
		this.backwardandLower = backwardandLower;
	}

	public String execute() {
		
		
		backLowerService.save(backwardandLower ) ;
		   
		  return "backlowercsuccess";}
	
		}




		
		
		

	
