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
import cn.edu.jlu.ccst.model.*;

@Component("dcsDscribService")
public class DcsDscribService {

	private DcsDscrib dDcsDscrib;
	private DcsDscribServiceInter dcsDscribServiceImpl;
	private DcsdataService dcsdataService;
	private Pre_dssService pre_dssService;
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
		List<DcsDscrib> dds = dcsDscribServiceImpl.findbyname(name);

		return dds;
	}
	public List<DcsDscrib> findall() {
		List<DcsDscrib> dcsDscriblist = dcsDscribServiceImpl.findAll();

		return dcsDscriblist;
	}


	public void save(DcsDscrib dcsDscrib) {
		dcsDscribServiceImpl.save(dcsDscrib);
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
