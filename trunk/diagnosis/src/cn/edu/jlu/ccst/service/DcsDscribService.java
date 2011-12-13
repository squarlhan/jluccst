package cn.edu.jlu.ccst.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.dao.DcsDscribServiceImpl;
import cn.edu.jlu.ccst.dao.DcsDscribServiceInter;
import cn.edu.jlu.ccst.dao.Init_PredictServiceInter;
import cn.edu.jlu.ccst.model.*;

@Component("dcsDscribService")
public class DcsDscribService {

	private DcsDscrib dDcsDscrib;
	private DcsDscribServiceInter dcsDscribServiceImpl;
	private DcsdataService dcsdataService;
	private Pre_dssService pre_dssService;
	private Init_PredictServiceInter init_predictServiceImpl;
	/*
	 * public Backward getBackward() { return backward; }
	 * 
	 * @Resource public void setBackward(Backward backward) { this.backward =
	 * backward; }
	 * 
	 * public RuleServiceInter getRuleServiceInter() { return ruleServiceImpl; }
	 * 
	 * @Resource public void setRuleServiceInter(RuleServiceInter
	 * ruleServiceImpl) { this.ruleServiceImpl = ruleServiceImpl; }
	 */

	/*
	 * public void save(BackwardandResult backward) {
	 * System.out.println("Rule:"+backward.getName()+" ; "+backward.getMemo());
	 * ruleServiceImpl.save(backward); }
	 */

	public DcsDscrib getdDcsDscrib() {
		return dDcsDscrib;
	}

	public Init_PredictServiceInter getInit_predictServiceImpl() {
		return init_predictServiceImpl;
	}
	@Resource
	public void setInit_predictServiceImpl(
			Init_PredictServiceInter init_predictServiceImpl) {
		this.init_predictServiceImpl = init_predictServiceImpl;
	}

	@Resource
	public void setdDcsDscrib(DcsDscrib dDcsDscrib) {
		this.dDcsDscrib = dDcsDscrib;
	}

	public Pre_dssService getPre_dssService() {
		return pre_dssService;
	}

	@Resource
	public void setPre_dssService(Pre_dssService pre_dssService) {
		this.pre_dssService = pre_dssService;
	}

	public DcsdataService getDcsdataService() {
		return dcsdataService;
	}

	@Resource
	public void setDcsdataService(DcsdataService dcsdataService) {
		this.dcsdataService = dcsdataService;
	}

	public DcsDscribServiceInter getDcsDscribServiceImpl() {
		return dcsDscribServiceImpl;
	}

	@Resource
	public void setDcsDscribServiceImpl(
			DcsDscribServiceInter dcsDscribServiceImpl) {
		this.dcsDscribServiceImpl = dcsDscribServiceImpl;
	}

	public List<String> findallname() {
		List<String> name = dcsDscribServiceImpl.findAllname();
		List<String> result = new ArrayList();
		for (String na : name) {
			if (na != null && na.trim().length() > 0)
				result.add(na);
		}
		return result;
	}

	public List<DcsDscrib> findbyname(String name) {
		List<DcsDscrib> dds = new ArrayList();
		dds = dcsDscribServiceImpl.findbyname(name);
		if(dds.size()<1)dds = findall();
		return dds;
	}
	
	public List<DcsDscrib> findlikename(String name) {
		List<DcsDscrib> dds = new ArrayList();
		dds = dcsDscribServiceImpl.findlikename(name);
		if(dds.size()<1)dds = findall();
		return dds;
	}
	
	public List<DcsDscrib> findbyeque(String eque) {
		List<DcsDscrib> dds = new ArrayList();
		dds = dcsDscribServiceImpl.findbyeque(eque);
		if(dds.size()<1)dds = findall();
		return dds;
	}
	public List<DcsDscrib> findall() {
		List<DcsDscrib> dcsDscriblist = dcsDscribServiceImpl.findAll();

		return dcsDscriblist;
	}
	
	public DcsDscrib findbyid(int id){
		 return dcsDscribServiceImpl.find(id);
    } 

	public void removebyid(int id){
		dcsDscribServiceImpl.remove(id);
	 }

	public void save(DcsDscrib dcsDscrib) {
		dcsDscribServiceImpl.save(dcsDscrib);
	}
	
	public Map getallnvs() {
		Map result = new HashMap();

		List<Init_Predict> ips = init_predictServiceImpl.findAll();

		for (Init_Predict ip : ips) {
			String temp = ip.getName().replace('.', ',');
			String[] strArray = temp.trim().split(",");
			if(strArray.length>=2){
				List<String> pps = init_predictServiceImpl.findbyjiedian(strArray[0]);
				List<String> canshus = new ArrayList();
				if(pps!=null&&pps.size()>0){
					for(String pp:pps){
					    String temp2 = pp.replace('.', ',');
					    String[] strArray2 = temp2.trim().split(",");
					    if(strArray2.length>=2){
					    	canshus.add(strArray2[1].trim());
					    }
					}
				}
				result.put(strArray[0].trim(), canshus);
			}
			
		}

		return result;
	}

	public List<BackwardandResult> validateinput(Map map) {
		Iterator iter = map.entrySet().iterator();
		List<BackwardandResult> results = new ArrayList();
		while (iter.hasNext()) {

			Map.Entry entry = (Map.Entry) iter.next();
			int key = (Integer) entry.getKey();
			float val = (Float) entry.getValue();

			List<DcsDscrib> dcsDscribs = dcsDscribServiceImpl.findbyitem(key);
			if (dcsDscribs != null && dcsDscribs.size() > 0) {
				DcsDscrib db = dcsDscribs.get(0);
				if (val > db.getUpper()) {
					BackwardandResult br = new BackwardandResult();
					br.setNouns(db.getName());
					br.setVerb("过高");
					br.setMemo(db.getEque());
					results.add(br);
				}
				if (val < db.getLower()) {
					BackwardandResult br = new BackwardandResult();
					br.setNouns(db.getName());
					br.setMemo(db.getEque());
					br.setVerb("过低");
					results.add(br);
				}
			}

		}
		return results;
	}

	public List<BackwardandResult> validateinput() {
		List<Dcsdata> alldata = dcsdataService.findAll();
		List<BackwardandResult> results = new ArrayList();
		for (Dcsdata dd : alldata) {

			List<DcsDscrib> dcsDscribs = dcsDscribServiceImpl.findbyname(
					dd.getEquipment(), dd.getItem());
			if (dcsDscribs != null && dcsDscribs.size() > 0) {
				DcsDscrib db = dcsDscribs.get(0);
				if (dd.getValue() > db.getUpper()) {
					BackwardandResult br = new BackwardandResult();
					br.setNouns(db.getName());
					br.setVerb("过高");
					br.setMemo(db.getEque());
					results.add(br);
				}
				if (dd.getValue() < db.getLower()) {
					BackwardandResult br = new BackwardandResult();
					br.setNouns(db.getName());
					br.setMemo(db.getEque());
					br.setVerb("过低");
					results.add(br);
				}
			}

		}

		return results;
	}

	public List<BackwardandResult> validateinput1() {
		List<Pre_dss> alldata = pre_dssService.findBysimu_time();
		List<BackwardandResult> results = new ArrayList();
		for (Pre_dss dd : alldata) {
			if (dd.getName() != null) {
				String temp = dd.getName().getName().replace('.', ',');
				String[] strArray = temp.split(",");

				// String[] strArray=dd.getName().split(",");
				System.out.println(strArray[1]);
				List<DcsDscrib> dcsDscribs = dcsDscribServiceImpl.findbyname(
						strArray[0], strArray[1]);
				if (dcsDscribs != null && dcsDscribs.size() > 0) {
					DcsDscrib db = dcsDscribs.get(0);
					if (Double.parseDouble(dd.getValue().trim()) > db.getUpper()) {
						BackwardandResult br = new BackwardandResult();
						br.setNouns(db.getName());
						br.setVerb("过高");
						br.setMemo(db.getEque());
						results.add(br);
					}
					if (Double.parseDouble(dd.getValue().trim()) < db.getLower()) {
						BackwardandResult br = new BackwardandResult();
						br.setNouns(db.getName());
						br.setMemo(db.getEque());
						br.setVerb("过低");
						results.add(br);
					}
				}

			}
		}
		return results;
	}

}
