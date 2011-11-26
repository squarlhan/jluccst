package cn.edu.jlu.ccst.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.model.BackwardandReason;
import cn.edu.jlu.ccst.model.BackwardandResult;
import cn.edu.jlu.ccst.model.Dss_advice;
import cn.edu.jlu.ccst.model.Pre_dss;
import cn.edu.jlu.ccst.service.DcsDscribService;
import cn.edu.jlu.ccst.service.Dss_adviceService;
import cn.edu.jlu.ccst.service.Pre_dssService;
import cn.edu.jlu.ccst.service.RuleService;

import com.opensymphony.xwork2.ActionSupport;

@Component("interfaceAction")
@Scope("prototype")
public class InterfaceAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<BackwardandResult> backwardandResult;
	
	private DcsDscribService dcsDscribService;
	private List<BackwardandReason> reasonlist;
	private RuleService ruleService;
	private Pre_dssService pre_dssService;
	private Dss_adviceService dss_adviceService;
	private List<Dss_advice> dss_advice;
	private List<BackwardandReason> reasonlist1;
	
	
	
	


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

	public String execute() {
		List<Pre_dss> alldata = pre_dssService.findBysimu_time();
	    List<BackwardandResult>  backwardandResult1=new ArrayList();
		backwardandResult = dcsDscribService.validateinput1();
		
		if (backwardandResult.size() > 0) {
			int a =backwardandResult.size();
			reasonlist = ruleService.findreasons(backwardandResult);
			System.out.println("seqno"+pre_dssService.findsimu_time());
		    
			if(!pre_dssService.findsimu_time().equals(dss_adviceService.findsimu_time())){
		    	   
				for(Pre_dss pre:alldata){
		           
					for(int i=0;i<a;i++){
		              BackwardandResult   back=new BackwardandResult();
		              backwardandResult1.clear();
		              back=backwardandResult.get(i);
		              backwardandResult1.add(back);
		              System.out.println("hello"+ruleService.findreasons(backwardandResult1));
		              reasonlist1 = ruleService.findreasons(backwardandResult1);
		        	  // reasonlist1=ruleService.findreasons((List<BackwardandReason>)backwardandResult.get(i));//有原因推出的reasonlist
		              dss_advice = new ArrayList();
		              for(BackwardandReason reason:reasonlist1){
		    			System.out.println(pre.getName()+"nihao");
		    			Dss_advice da = new Dss_advice();
		    			da.setName(pre.getName());
		    			da.setValue(pre.getValue());
		    			da.setSimu_time(pre.getSimu_time());
		    			da.setSeqno(pre.getSeqno());
		    			da.setError(reason.getNouns()+reason.getVerb());
		    			da.setSugg(reason.getSugg());
		    			dss_advice.add(da);
		    			dss_adviceService.save(da);
		    		  }
		            }
		    	}
		    }
		    
			return "go";
		}else{
			return "OK";
		}
		

	}

}
