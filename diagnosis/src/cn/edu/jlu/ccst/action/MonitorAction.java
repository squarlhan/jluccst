package cn.edu.jlu.ccst.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.model.BackwardandReason;
import cn.edu.jlu.ccst.model.BackwardandResult;
import cn.edu.jlu.ccst.service.DcsDscribService;
import cn.edu.jlu.ccst.service.RuleService;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 实时监控DCS数据相关
 * @author Woden
 *
 */
@Component("monitorAction")
@Scope("prototype")
public class MonitorAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 与用户交互用的规则和结果对应表
	 */
	private List<BackwardandResult> backwardandResult;
	/**
	 * 规则描述相关服务
	 */
	private DcsDscribService dcsDscribService;
	/**
	 * 与用户交互用的规则和原因对应表
	 */
	private List<BackwardandReason> reasonlist;
	/**
	 * 规则相关服务
	 */
	private RuleService ruleService;
	
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

	/**
	 * 根据目前DCS数据状态得到推理结果
	 */
	public String execute() {
		backwardandResult = dcsDscribService.validateinput3();
		if (backwardandResult.size() > 0) {
			reasonlist = ruleService.findreasons(backwardandResult);
			
			return "go";
		}else{
			return "OK";
		}

	}

}
