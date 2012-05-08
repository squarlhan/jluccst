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
/**
 * 古老的DCS数据处理操作
 * @author Woden
 *
 */
@Component("wwdcsdataAction")
@Scope("prototype")
public class WwdcsdataAction extends ActionSupport {

	/**
	 * DCS数据处理相关服务
	 */
	private WwdcsdataService wwdcsdataService; 
	/**
	 * 与用户交互用的DCS数据实例
	 */
	private Wwdcsdata wwdcsdata; 
	/**
	 * 与用户交互用的规则和结果对应表
	 */
    private List<BackwardandResult>  backwardandResult;
    /**
     * 规则描述相关服务
     */
    private DcsDscribService  dcsDscribService;
    /**
	 * 与用户交互用的规则和原因对应表
	 */
	private List<BackwardandReason> reasonlist;
	/**
	 * 规则相关服务
	 */
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
	
	
	/**
	 * 将用户数据的DCS数据存在session中,返回询问页面
	 */
	public String execute() {
		
		
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("wc", wwdcsdata);
		
	 /*  Map map = wwdcsdata.validataitem();
	   backwardandResult= dcsDscribService.validateinput(map);
	   if(backwardandResult.size()>0){
		   
		   reasonlist=ruleService.findreasons(backwardandResult);  
	     return "go";}
	   
		  return "input";      */
		 return "input";}
	/**
	 * 存储DCS数据
	 * @return 成功页面
	 */
	public String save() {
		ActionContext actionContext = ActionContext.getContext();
        Map session1 = actionContext.getSession();
        Wwdcsdata wc = (Wwdcsdata) session1.get("wc");
        wwdcsdataService.save(wc);
        return "savesuccess";
	}
	
		}




		
		
		

	
