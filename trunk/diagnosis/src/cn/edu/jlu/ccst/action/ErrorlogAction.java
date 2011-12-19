package cn.edu.jlu.ccst.action;

import java.io.UnsupportedEncodingException;
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
   private String equip;
   
   private String parameter;
   
	

	public String getParameter() {
	return parameter;
}



public void setParameter(String parameter) {
	this.parameter = parameter;
}



	public String getEquip() {
	return equip;
}



public void setEquip(String equip) {
	this.equip = equip;
}



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
	
	public String findbyequipment(){
		try {
			String keyword= new String(equip.getBytes("ISO-8859-1"),"UTF-8");
			errorlist = errorlogService.findbyequipment(keyword);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "OK";
	}
	
	public String findbypara(){
		
			errorlist = errorlogService.findbypara(parameter);
		
		return "OK";
	}

}
