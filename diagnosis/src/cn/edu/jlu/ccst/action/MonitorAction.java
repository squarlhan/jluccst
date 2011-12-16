package cn.edu.jlu.ccst.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.model.BackwardandReason;
import cn.edu.jlu.ccst.model.BackwardandResult;
import cn.edu.jlu.ccst.service.AutoJob;
import cn.edu.jlu.ccst.service.DcsDscribService;
import cn.edu.jlu.ccst.service.RuleService;

import com.opensymphony.xwork2.ActionSupport;

@Component("monitorAction")
@Scope("prototype")
public class MonitorAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<BackwardandResult> backwardandResult;
	private DcsDscribService dcsDscribService;
	private List<BackwardandReason> reasonlist;
	private RuleService ruleService;
	private AutoJob autoJob;

	
	
	public AutoJob getAutoJob() {
		return autoJob;
	}
	@Resource
	public void setAutoJob(AutoJob autoJob) {
		this.autoJob = autoJob;
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

	public List<BackwardandReason> getReasonlist() {
		return reasonlist;
	}

	public void setReasonlist(List<BackwardandReason> reasonlist) {
		this.reasonlist = reasonlist;
	}

	public RuleService getRuleService() {
		return ruleService;
	}

	@Resource
	public void setRuleService(RuleService ruleService) {
		this.ruleService = ruleService;
	}

	public String execute() {
		backwardandResult = dcsDscribService.validateinput();
		if (backwardandResult.size() > 0) {
			reasonlist = ruleService.findreasons(backwardandResult);
			
			return "go";
		}else{
			return "OK";
		}

	}
	
	public String waitingforU(){
		autoJob.porcessdss();
		return null;
	}

}
