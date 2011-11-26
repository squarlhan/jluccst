package cn.edu.jlu.ccst.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.model.Errorlog;
import cn.edu.jlu.ccst.service.ErrorlogService;

import com.opensymphony.xwork2.ActionSupport;

@Component("errorlogAction")
@Scope("prototype")
public class ErrorlogAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Errorlog> errorlist;
	private ErrorlogService errorlogService;

	

	public List<Errorlog> getErrorlist() {
		return errorlist;
	}



	public void setErrorlist(List<Errorlog> errorlist) {
		this.errorlist = errorlist;
	}



	public ErrorlogService getErrorlogService() {
		return errorlogService;
	}


	@Resource
	public void setErrorlogService(ErrorlogService errorlogService) {
		this.errorlogService = errorlogService;
	}



	
	

	public String execute() {
		errorlist = errorlogService.findAll();
		
		return "OK";
		

	}

}
