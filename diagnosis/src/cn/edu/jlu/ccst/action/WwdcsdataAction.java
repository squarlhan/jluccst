package cn.edu.jlu.ccst.action;





import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import cn.edu.jlu.ccst.model.BackwardandReason;
import cn.edu.jlu.ccst.model.BackwardandResult;
import cn.edu.jlu.ccst.model.Wwdcsdata;
import cn.edu.jlu.ccst.service.DcsDscribService;
import cn.edu.jlu.ccst.service.RuleService;
import cn.edu.jlu.ccst.service.WwdcsdataService;







@Component("wwdcsdataAction")
@Scope("prototype")
public class WwdcsdataAction extends ActionSupport {

	private WwdcsdataService wwdcsdataService; 
	private Wwdcsdata wwdcsdata; 
    private List<BackwardandResult>  backwardandResult;
     private DcsDscribService  dcsDscribService;
	private List<BackwardandReason> reasonlist;
	private RuleService ruleService; 
	
	public RuleService getRuleService() {
		return ruleService;
	}
	@Resource
	public void setRuleService(RuleService ruleService) {
		this.ruleService = ruleService;
	}
	public List<BackwardandReason> getReasonlist() {
		return reasonlist;
	}
	public void setReasonlist(List<BackwardandReason> reasonlist) {
		this.reasonlist = reasonlist;
	}
	
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


	

	public List<BackwardandResult> getBackwardandResult() {
		return backwardandResult;
	}
	public void setBackwardandResult(List<BackwardandResult> backwardandResult) {
		this.backwardandResult = backwardandResult;
	}
	public DcsDscribService getDcsDscribService() {
		return dcsDscribService;
	}
	@Resource
	public void setDcsDscribService(DcsDscribService dcsDscribService) {
		this.dcsDscribService = dcsDscribService;
	}
	public String execute() {
		
		
		wwdcsdataService.save(wwdcsdata ) ;
		
	   Map map = wwdcsdata.validataitem();
	   backwardandResult= dcsDscribService.validateinput(map);
	   if(backwardandResult.size()>0){
		   
		   reasonlist=ruleService.findreasons(backwardandResult);  
	     return "go";}
	   
		  return "input";}
	
		}




		
		
		

	
