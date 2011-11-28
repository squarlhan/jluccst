package cn.edu.jlu.ccst.action;

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

	

	public List<Dss_history> getErrorlist() {
		return errorlist;
	}



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

}
