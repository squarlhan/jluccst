package cn.edu.jlu.ccst.action;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import cn.edu.jlu.ccst.model.DcsDscrib;
import cn.edu.jlu.ccst.model.User;
import cn.edu.jlu.ccst.service.DcsDscribService;







@Component("dcsDscribAction")
@Scope("prototype")
public class DcsDscribAction extends ActionSupport {

	private DcsDscribService dcsDscribService; 
	private DcsDscrib dcsDscrib; 

	private List<String> namelist;

	
	

	

	public List<String> getNamelist() {
		return namelist;
	}

	public void setNamelist(List<String> namelist) {
		this.namelist = namelist;
	}

	
   public DcsDscribService getDcsDscribService() {
		return dcsDscribService;
	}
    @Resource
	public void setDcsDscribService(DcsDscribService dcsDscribService) {
		this.dcsDscribService = dcsDscribService;
	}

public DcsDscrib getDcsDscrib() {
		return dcsDscrib;
	}

   public void setDcsDscrib(DcsDscrib dcsDscrib) {
		this.dcsDscrib = dcsDscrib;
	}








	public String execute() {
		
		
		namelist = dcsDscribService.findallname();
		System.out.println(namelist+"你好");
	    return SUCCESS;
		}
}




		
		
		

	
