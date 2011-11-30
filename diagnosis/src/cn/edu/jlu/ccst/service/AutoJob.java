package cn.edu.jlu.ccst.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.edu.jlu.ccst.dao.DcsDscribServiceInter;
import cn.edu.jlu.ccst.model.BackwardandReason;
import cn.edu.jlu.ccst.model.BackwardandResult;
import cn.edu.jlu.ccst.model.DcsDscrib;
import cn.edu.jlu.ccst.model.Dss_advice;
import cn.edu.jlu.ccst.model.Dss_history;
import cn.edu.jlu.ccst.model.Pre_dss;

@Service
@Component("autoJob")
public class AutoJob {

	private Pre_dssService pre_dssService;
	private DcsDscribService dcsDscribService;
	private RuleService ruleService;
	private Dss_adviceService dss_adviceService;
	private Dss_historyService dss_historyService;
	private DcsDscribServiceInter dcsDscribServiceImpl;
	private BackwardandResultService backwardandResultService;

	public BackwardandResultService getBackwardandResultService() {
		return backwardandResultService;
	}
	@Resource
	public void setBackwardandResultService(
			BackwardandResultService backwardandResultService) {
		this.backwardandResultService = backwardandResultService;
	}
	public Dss_historyService getDss_historyService() {
		return dss_historyService;
	}
	@Resource
	public void setDss_historyService(Dss_historyService dss_historyService) {
		this.dss_historyService = dss_historyService;
	}
	public DcsDscribServiceInter getDcsDscribServiceImpl() {
		return dcsDscribServiceImpl;
	}
	@Resource
	public void setDcsDscribServiceImpl(DcsDscribServiceInter dcsDscribServiceImpl) {
		this.dcsDscribServiceImpl = dcsDscribServiceImpl;
	}

	public Pre_dssService getPre_dssService() {
		return pre_dssService;
	}

	@Resource
	public void setPre_dssService(Pre_dssService pre_dssService) {
		this.pre_dssService = pre_dssService;
	}

	public DcsDscribService getDcsDscribService() {
		return dcsDscribService;
	}

	@Resource
	public void setDcsDscribService(DcsDscribService dcsDscribService) {
		this.dcsDscribService = dcsDscribService;
	}

	public RuleService getRuleService() {
		return ruleService;
	}

	@Resource
	public void setRuleService(RuleService ruleService) {
		this.ruleService = ruleService;
	}

	public Dss_adviceService getDss_adviceService() {
		return dss_adviceService;
	}

	@Resource
	public void setDss_adviceService(Dss_adviceService dss_adviceService) {
		this.dss_adviceService = dss_adviceService;
	}

	@Scheduled(fixedDelay = 10000)
	public void porcessdss() {
		List<Pre_dss> alldata = pre_dssService.findBysimu_time();		
//		List<Pre_dss> alldata = pre_dssService.findAll();
		dss_adviceService.deleteall();
		boolean flag = true;
		for(Pre_dss predss:alldata){
			String temp = predss.getName().getName().replace('.',',');
			String[] strArray = temp.split(",");

			List<DcsDscrib> dcsDscribs = dcsDscribServiceImpl.findbyname(strArray[0],strArray[1]);
			if (dcsDscribs != null && dcsDscribs.size() > 0) {
				flag = false;
				DcsDscrib db = dcsDscribs.get(0);
				BackwardandResult br = new BackwardandResult();
				br.setNouns(db.getName());
				br.setMemo(db.getEque());
				if (predss.getValue() > db.getUpper()) {
					br.setVerb("过高");
				}
				if (predss.getValue() < db.getLower()) {
					br.setVerb("过低");
				}
				
//				List<BackwardandResult> qianjian = new ArrayList();
//				qianjian.add(br);
//				List<BackwardandReason> houjian = ruleService.findreasons(qianjian);
				List<BackwardandReason> houjian = backwardandResultService.findbyresult(br);
				Dss_advice da = new Dss_advice();
				Dss_history dh = new Dss_history();
				da.setLevel(br.getVerb());
				da.setName(predss.getName());
				da.setSeqno(predss.getSeqno());
				da.setSimu_time(predss.getSimu_time());
				da.setValue(predss.getValue());
				dh.setLevel(br.getVerb());
				dh.setName(predss.getName());
				dh.setSeqno(predss.getSeqno());
				dh.setSimu_time(predss.getSimu_time());
				dh.setValue(predss.getValue());
				String error = "";
				String sugg = "";
				for(BackwardandReason hj : houjian){
					error = error + hj.getNouns() + hj.getVerb() + ";";
					sugg = sugg + hj.getSugg() + ";";
				}
				da.setError(error);
				da.setSugg(sugg);
				dh.setError(error);
				dh.setSugg(sugg);
				dss_adviceService.save(da);
				dss_historyService.save(dh);
			}

		
		}
		
		if(flag){
			Dss_advice da = new Dss_advice();
			Dss_history dh = new Dss_history();
			da.setSugg("一切正常");
			dh.setSugg("一切正常");
			dss_adviceService.save(da);
			dss_historyService.save(dh);
		}
	}

}
