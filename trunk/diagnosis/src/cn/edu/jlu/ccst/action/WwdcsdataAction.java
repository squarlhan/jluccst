package cn.edu.jlu.ccst.action;



import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import cn.edu.jlu.ccst.model.Wwdcsdata;
import cn.edu.jlu.ccst.service.WwdcsdataService;







@Component("wwdcsdataAction")
@Scope("prototype")
public class WwdcsdataAction extends ActionSupport {

	private WwdcsdataService wwdcsdataService; 
	private Wwdcsdata wwdcsdata; 



	
	public WwdcsdataService getWwdcsdataService() {
		return wwdcsdataService;
	}
	@Resource
	public void setWwdcsdataService(WwdcsdataService wwdcsdataService) {
		this.wwdcsdataService = wwdcsdataService;
	}

	public Wwdcsdata getWwdcsdata() {
		return wwdcsdata;
	}

	public void setWwdcsdata(Wwdcsdata wwdcsdata) {
		this.wwdcsdata = wwdcsdata;
	}


	

	public String execute() {
		
		
		wwdcsdataService.save(wwdcsdata ) ;
		   
		  return "datasuccess";}
	
		}




		
		
		

	
