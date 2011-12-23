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
	private Pre_historyService pre_historyService;
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

	public Pre_historyService getPre_historyService() {
		return pre_historyService;
	}
	@Resource
	public void setPre_historyService(Pre_historyService pre_historyService) {
		this.pre_historyService = pre_historyService;
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
	public void setDcsDscribServiceImpl(
			DcsDscribServiceInter dcsDscribServiceImpl) {
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

//	@Scheduled(fixedDelay = 10000)
	public void porcessdss() {
		List<String> datatimes = pre_dssService.findsimu_time();
		List<String> advicetimes = dss_adviceService.findsimu_time();
		String datatime = "";
		String advicetime = "";
		if(datatimes!=null&&datatimes.size()>0){
			datatime = datatimes.get(0).trim();
		}
		if(advicetimes!=null&&advicetimes.size()>0){
			if(advicetimes.get(0)!=null){
				advicetime = advicetimes.get(0).trim();
			}
			
		}
		if(datatime==""||datatime.equals(advicetime)){
			return;
		}
		// List<Pre_dss> alldata = pre_dssService.findAll();
		List<Pre_dss> alldata = pre_dssService.findBysimu_time();
		pre_historyService.saveall(alldata);
		dss_adviceService.deleteall();
		boolean flag = true;
		for (Pre_dss predss : alldata) {
			if (predss.getName().getName() != null) {
				String temp = predss.getName().getName().replace('.', ',');
				String[] strArray = temp.split(",");
				int level = 0;
				if (predss.getName().getName().contains("COD")) {
					level = 9;
				}else if (predss.getName().getName().contains("NH3-N")||predss.getName().getName().contains("NH3N")) {
					level = 8;
				}else if (predss.getName().getName().contains("SS")) {
					level = 7;
				}else if (predss.getName().getName().contains("PH")) {
					level = 6;
				}else if (predss.getName().getName().contains("BOD")) {
					level = 5;
				}else{
					level = 2;
				}

				List<DcsDscrib> dcsDscribs = dcsDscribServiceImpl.findbyname(
						strArray[0], strArray[1]);
				if (dcsDscribs != null && dcsDscribs.size() > 0) {
//					flag = false;
					DcsDscrib db = dcsDscribs.get(0);
					BackwardandResult br = new BackwardandResult();
					br.setNouns(db.getName());
					br.setMemo(db.getEque());
					if (Double.parseDouble(predss.getValue().trim()) > db.getUpper()) {
						if(Double.parseDouble(predss.getValue().trim()) > db.getUpper2()){
							level+=3;
						}else if(Double.parseDouble(predss.getValue().trim()) > db.getUpper1()){
							level+=2;
						}else{
							level++;
						}
						flag = false;
						br.setVerb("过高");
					}
					if (Double.parseDouble(predss.getValue().trim()) < db.getLower()) {
						if(Double.parseDouble(predss.getValue().trim()) < db.getLower2()){
							level+=3;
						}else if(Double.parseDouble(predss.getValue().trim()) < db.getLower1()){
							level+=2;
						}else{
							level++;
						}
						flag = false;
						br.setVerb("过低");
					}

					if (br.getVerb() != null) {
						 List<BackwardandResult> qianjian = new ArrayList();
						 qianjian.add(br);
						 List<BackwardandReason> houjian = ruleService.findreasons(qianjian);
//						List<BackwardandReason> houjian = backwardandResultService.findbyresult(br);
						Dss_advice da = new Dss_advice();
						Dss_history dh = new Dss_history();
						da.setLevel(String.valueOf(level));
						da.setName(predss.getName());
						da.setSeqno(predss.getSeqno());
						da.setSimu_time(predss.getSimu_time());
						da.setValue(Double.parseDouble(predss.getValue().trim()));
						dh.setLevel(String.valueOf(level));
						dh.setName(predss.getName());
						dh.setSeqno(predss.getSeqno());
						dh.setSimu_time(predss.getSimu_time());
						dh.setValue(Double.parseDouble(predss.getValue().trim()));
						String error = "";
						String sugg = "";
						if (houjian != null && houjian.size() > 0) {
							for (BackwardandReason hj : houjian) {
								if(hj.getNouns().trim().length()>0 && hj.getVerb().trim().length()>0){
									error = error + hj.getNouns() + hj.getVerb()	+ ";";
								}
								
								sugg = sugg + hj.getSugg() + ";";
							}
						}
						String all = "报警现象： "+br.getNouns()+br.getVerb();
						if(error.trim().length()>0){
							all = all + "\r\n报警原因： "+error;
						}
						if(sugg.trim().length()>0){
							all = all + "\r\n建议： "+sugg;
						}
						da.setError(error);
						da.setSugg(all);
						dh.setError(error);
						dh.setSugg(sugg);
						dss_adviceService.save(da);
						dss_historyService.save(dh);
					}

				}
			}

			
		}
		if (flag) {
			Dss_advice da = new Dss_advice();
//			Dss_history dh = new Dss_history();
			da.setSugg("一切正常");
			da.setSimu_time(datatime);
//			dh.setSugg("一切正常");
			dss_adviceService.save(da);
//			dss_historyService.save(dh);
		}
	}

}
