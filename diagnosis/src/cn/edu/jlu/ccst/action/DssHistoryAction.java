package cn.edu.jlu.ccst.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.model.Dss_history;
import cn.edu.jlu.ccst.service.Dss_historyService;

import com.opensymphony.xwork2.ActionSupport;

@Component("dsshistoryAction")
@Scope("prototype")
public class DssHistoryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Dss_history> errorlist;
	private Dss_historyService dss_historyService;
    private String name;
    
    
    
    
    
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Dss_history> getErrorlist() {
		return errorlist;
	}


	@Resource
	public void setErrorlist(List<Dss_history> errorlist) {
		this.errorlist = errorlist;
	}

	public Dss_historyService getDss_historyService() {
		return dss_historyService;
	}


  @Resource
	public void setDss_historyService(Dss_historyService dss_historyService) {
		this.dss_historyService = dss_historyService;
	}



	public String execute() {
		errorlist = dss_historyService.findAll();
		
		return "OK";
		

	}

	
	public String findbyname(){
		try {
			String keyword= new String(name.getBytes("ISO-8859-1"),"UTF-8");
			errorlist = dss_historyService.findbyname(keyword);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "OK";
	}
}
