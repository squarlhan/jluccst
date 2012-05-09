package cn.edu.jlu.ccst.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.edu.jlu.ccst.model.BackwardandReason;
import cn.edu.jlu.ccst.model.BackwardandResult;
import cn.edu.jlu.ccst.model.Dss_advice;
import cn.edu.jlu.ccst.model.Dss_history;
import cn.edu.jlu.ccst.model.Init_Predict;
import cn.edu.jlu.ccst.model.Pre_dss;
import cn.edu.jlu.ccst.service.AutoJob;
import cn.edu.jlu.ccst.service.DcsDscribService;
import cn.edu.jlu.ccst.service.Dss_adviceService;
import cn.edu.jlu.ccst.service.Dss_historyService;
import cn.edu.jlu.ccst.service.Pre_dssService;
import cn.edu.jlu.ccst.service.RuleService;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 工艺对接相关操作
 * @author Woden
 *
 */
//@Service 
@Component("interfaceAction")
@Scope("prototype")
public class InterfaceAction extends ActionSupport {

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
	/**
	 * 工艺数据预处理相关服务
	 */
	private Pre_dssService pre_dssService;
	/**
	 * 规则建议相关服务
	 */
	private Dss_adviceService dss_adviceService;
	/**
	 * 与用户交互用的规则建议表
	 */
	private List<Dss_advice> dss_advice;
	/**
	 * 与用户交互用的错误日志表
	 */
	private List<Dss_history> dss_history;
	/**
	 * 与用户交互用的规则和原因对应表
	 */
	private List<BackwardandReason> reasonlist1;
	/**
	 * 错误日志相关服务
	 */
	private Dss_historyService dss_historyService;
	/**
	 * 自动执行任务
	 */
    private AutoJob autoJob;

	
	
	public AutoJob getAutoJob() {
		return autoJob;
	}
	@Resource
	public void setAutoJob(AutoJob autoJob) {
		this.autoJob = autoJob;
	}

	public List<Dss_history> getDss_history() {
		return dss_history;
	}

	public void setDss_history(List<Dss_history> dss_history) {
		this.dss_history = dss_history;
	}

	public Dss_historyService getDss_historyService() {
		return dss_historyService;
	}

	@Resource
	public void setDss_historyService(Dss_historyService dss_historyService) {
		this.dss_historyService = dss_historyService;
	}

	public List<Dss_advice> getDss_advice() {
		return dss_advice;
	}

	public void setDss_advice(List<Dss_advice> dss_advice) {
		this.dss_advice = dss_advice;
	}

	public List<BackwardandReason> getReasonlist1() {
		return reasonlist1;
	}

	public void setReasonlist1(List<BackwardandReason> reasonlist1) {
		this.reasonlist1 = reasonlist1;
	}

	public Pre_dssService getPre_dssService() {
		return pre_dssService;
	}

	@Resource
	public void setPre_dssService(Pre_dssService pre_dssService) {
		this.pre_dssService = pre_dssService;
	}

	public Dss_adviceService getDss_adviceService() {
		return dss_adviceService;
	}

	@Resource
	public void setDss_adviceService(Dss_adviceService dss_adviceService) {
		this.dss_adviceService = dss_adviceService;
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

	
	/**
	 * 验证工艺数据, 有问题则返回意见
	 */
	public String execute() {
		List<Pre_dss> alldata = pre_dssService.findBysimu_time();
		List<BackwardandResult> backwardandResult1 = new ArrayList();
		backwardandResult = dcsDscribService.validateinput1();

		if (backwardandResult.size() > 0) {
			int a = backwardandResult.size();
			reasonlist = ruleService.findreasons(backwardandResult);
//			System.out.println("seqno" + pre_dssService.findsimu_time());

//			if (!pre_dssService.findsimu_time().equals(
//					dss_adviceService.findsimu_time())) {
//				dss_adviceService.deleteall();
//				for (Pre_dss pre : alldata) {
//
//					if (pre.getName().getName() != null) {
//
//						for (int i = 0; i < a; i++) {
//							BackwardandResult back = new BackwardandResult();
//							backwardandResult1.clear();
//							back = backwardandResult.get(i);
//							backwardandResult1.add(back);
//							
//							// reasonlist1=ruleService.findreasons((List<BackwardandReason>)backwardandResult.get(i));//有原因推出的reasonlist
//							dss_advice = new ArrayList();
//							for (BackwardandReason reason : reasonlist1) {
//								
//								Dss_advice da = new Dss_advice();
//								da.setName(pre.getName());
//								da.setValue(Double.parseDouble(pre.getValue()));
//								da.setSimu_time(pre.getSimu_time());
//								da.setSeqno(pre.getSeqno());
//								da.setError(reason.getNouns()
//										+ reason.getVerb());
//								da.setSugg("现象：" + back.getNouns()
//										+ back.getVerb() + "   原因："
//										+ reason.getNouns() + reason.getVerb()
//										+ "  建议：" + reason.getSugg());
//								dss_advice.add(da);
//								// dss_adviceService.save(da);
//							}
//						}
//						/*
//						 * for(Pre_dss are:alldata){
//						 * 
//						 * for(int i=0;i<a;i++){ BackwardandResult back=new
//						 * BackwardandResult(); backwardandResult1.clear();
//						 * back=backwardandResult.get(i);
//						 * backwardandResult1.add(back);
//						 * System.out.println("hello"+ruleService
//						 * .findreasons(backwardandResult1)); reasonlist1 =
//						 * ruleService.findreasons(backwardandResult1); //
//						 * reasonlist1
//						 * =ruleService.findreasons((List<BackwardandReason
//						 * >)backwardandResult.get(i));//有原因推出的reasonlist
//						 * dss_history = new ArrayList(); for(BackwardandReason
//						 * reason:reasonlist1){
//						 * System.out.println(pre.getName()+"nihao");
//						 * Dss_history da = new Dss_history();
//						 * da.setName(pre.getName());
//						 * da.setValue(pre.getValue());
//						 * da.setSimu_time(pre.getSimu_time());
//						 * da.setSeqno(pre.getSeqno());
//						 * da.setError(reason.getNouns()+reason.getVerb());
//						 * da.setSugg(reason.getSugg()); dss_history.add(da);
//						 * dss_historyService.save(da); } } }
//						 */
//					}
//
//				}
//			}

			return "go";
		} else {
//			if (!pre_dssService.findsimu_time().equals(
//					dss_adviceService.findsimu_time())) {
//				Dss_advice zc = new Dss_advice();
//				zc.setSugg("一切正常");
//				// dss_adviceService.save(zc);
//			}
			return "OK";
		}
	}

	/**
	 * 等待工艺请求, 之后验证数据并返回相关建议
	 * @return 建议和错误页面
	 */
	// @Scheduled(fixedDelay = 1000)
	public String waitingforU(){
		autoJob.porcessdss();
		return "done";
	}
}
