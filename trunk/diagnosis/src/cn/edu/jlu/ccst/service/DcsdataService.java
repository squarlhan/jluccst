package cn.edu.jlu.ccst.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.dao.DcsDscribServiceInter;
import cn.edu.jlu.ccst.dao.DcsdataServiceImpl;
import cn.edu.jlu.ccst.dao.DcsdataServiceInter;
import cn.edu.jlu.ccst.dao.ErrorlogInter;
import cn.edu.jlu.ccst.model.BackwardandReason;
import cn.edu.jlu.ccst.model.BackwardandResult;
import cn.edu.jlu.ccst.model.DcsDscrib;
import cn.edu.jlu.ccst.model.Dcsdata;
import cn.edu.jlu.ccst.model.Errorlog;
import cn.edu.jlu.ccst.model.Pre_dss;

@Component("dcsdataService")
public class DcsdataService {
	private Dcsdata dcsdata;
	private DcsdataServiceInter dcsdataServiceImpl;
	private ErrorlogInter errorlogImpl;
	private DcsDscribServiceInter dcsDscribServiceImpl;
	private RuleService ruleService;
	private Pre_dssService pre_dssService;

	public Pre_dssService getPre_dssService() {
		return pre_dssService;
	}

	@Resource
	public void setPre_dssService(Pre_dssService pre_dssService) {
		this.pre_dssService = pre_dssService;
	}

	public RuleService getRuleService() {
		return ruleService;
	}

	@Resource
	public void setRuleService(RuleService ruleService) {
		this.ruleService = ruleService;
	}

	public Dcsdata getDcsdata() {
		return dcsdata;
	}

	@Resource
	public void setDcsdata(Dcsdata dcsdata) {
		this.dcsdata = dcsdata;
	}

	public DcsDscribServiceInter getDcsDscribServiceImpl() {
		return dcsDscribServiceImpl;
	}

	@Resource
	public void setDcsDscribServiceImpl(
			DcsDscribServiceInter dcsDscribServiceImpl) {
		this.dcsDscribServiceImpl = dcsDscribServiceImpl;
	}

	public DcsdataServiceInter getDcsdataServiceImpl() {
		return dcsdataServiceImpl;
	}

	@Resource
	public void setDcsdataServiceImpl(DcsdataServiceInter dcsdataServiceImpl) {
		this.dcsdataServiceImpl = dcsdataServiceImpl;
	}

	public ErrorlogInter getErrorlogImpl() {
		return errorlogImpl;
	}

	@Resource
	public void setErrorlogImpl(ErrorlogInter errorlogImpl) {
		this.errorlogImpl = errorlogImpl;
	}

	public void save(Dcsdata dcsdata) {
		
		dcsdataServiceImpl.save(dcsdata);
	}

	public void delete(Dcsdata dcsdata) {

		dcsdataServiceImpl.delete(dcsdata);
	}

	public List<Dcsdata> findbyequipment(String equipment) {
		List<Dcsdata> resultlist = new ArrayList();
		resultlist = dcsdataServiceImpl.findByequipment(equipment);
		return resultlist;
	}

	public List<Dcsdata> findAll() {
		List<Dcsdata> resultlist = new ArrayList();
		resultlist = dcsdataServiceImpl.findAll();
		return resultlist;
	}

	public BackwardandResult validateinput(Dcsdata dd) {
		BackwardandResult br = null;
		Errorlog err = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mytime = formatter.format(new Date());
		List<DcsDscrib> dcsDscribs = dcsDscribServiceImpl.findbyname(
				dd.getEquipment(), dd.getItem());
		int level = 0;
		if (dd.getItem().contains("COD")) {
			level = 9;
		}else if (dd.getItem().contains("NH3-N")||dd.getItem().contains("NH3N")) {
			level = 8;
		}else if (dd.getItem().contains("SS")) {
			level = 7;
		}else if (dd.getItem().contains("PH")) {
			level = 6;
		}else if (dd.getItem().contains("BOD")) {
			level = 5;
		}else{
			level = 2;
		}
		if (dcsDscribs != null && dcsDscribs.size() > 0) {
			DcsDscrib db = dcsDscribs.get(0);
			if (dd.getValue() > db.getUpper()) {
				if(dd.getValue() > db.getUpper2()){
					level+=3;
				}else if(dd.getValue() > db.getUpper1()){
					level+=2;
				}else{
					level++;
				}
				br = new BackwardandResult();
				br.setNouns(db.getName());
				br.setVerb("过高");
				br.setMemo(db.getEque());
				err = new Errorlog();
				err.setWrong("过高");
//				errorlogImpl.save(err);
			}
			if (dd.getValue() < db.getLower()) {
				if(dd.getValue() < db.getLower2()){
					level+=3;
				}else if(dd.getValue() < db.getLower1()){
					level+=2;
				}else{
					level++;
				}
				br = new BackwardandResult();
				br.setNouns(db.getName());
				br.setMemo(db.getEque());
				br.setVerb("过低");
				err = new Errorlog();
				err.setWrong("过低");
//				errorlogImpl.save(err);
			}
		}
		if (br != null) {
			List<BackwardandResult> brs = new ArrayList();
			brs.add(br);
			List<BackwardandReason> bss = ruleService.findreasons(brs);
			if (bss != null && bss.size() > 0) {
				String reasons = "";
				String suggs = "";
				for (BackwardandReason bs : bss) {
					reasons = reasons + bs.getNouns() + bs.getVerb() + ";";
					suggs = suggs + bs.getSugg() + ";";
				}
				err.setItem(dd.getItem());
				err.setValue(dd.getValue());
				err.setEquipment(dd.getEquipment());
				err.setError(reasons);
				err.setSugg(suggs);
				err.setTime(mytime);
				err.setLevel(String.valueOf(level));
			}
			if (err.getEquipment() != null) {
				errorlogImpl.save(err);
			}

		}

		return br;
	}

	public List<Dcsdata> getallgongyidata(String keyword) {
		List<Dcsdata> results = new ArrayList();
		List<Dcsdata> fliterresults = new ArrayList();
		List<Pre_dss> pds = new ArrayList();
		pds = pre_dssService.findBysimu_time();
		for (Pre_dss pd : pds) {
			String temp = pd.getName().getName().replace('.', ',');
			String[] strArray = temp.split(",");
			String mykey1 = "";
			String mykey2 = "";
			if (strArray.length > 1) {
				mykey1 = strArray[0].trim();
				mykey2 = strArray[1].trim();
				List<DcsDscrib> dcsDscribs = dcsDscribServiceImpl.findbyname(
						strArray[0], strArray[1]);
				
				Dcsdata dd = new Dcsdata();
				dd.setEquipment(mykey1);
				dd.setItem(mykey2);
				dd.setValue(Double.parseDouble(pd.getValue()));
				dd.setIsok("0");
				if (dcsDscribs != null && dcsDscribs.size() > 0) {
					DcsDscrib db = dcsDscribs.get(0);
					// do sth...
					if(dd.getValue()>db.getUpper2()||dd.getValue()<db.getLower2()){
						dd.setIsok("3");
					}else if(dd.getValue()>db.getUpper1()||dd.getValue()<db.getLower1()){
						dd.setIsok("2");
					}else if(dd.getValue()>db.getUpper()||dd.getValue()<db.getLower()){
						dd.setIsok("1");
					}else{
						dd.setIsok("0");
					}
					if (keyword != null) {
						if(db.getName().contains(keyword)){
							fliterresults.add(dd);
						}
					}
					
				}
				results.add(dd);
			}

		}
	
		if (fliterresults.size()>0) {
			return fliterresults;
			}else{
				return results;
			}
		
	}
	
	public List<Dcsdata> getalldcsddata(String keyword) {
		List<Dcsdata> allresults = new ArrayList();
		List<Dcsdata> results = new ArrayList();
		List<Dcsdata> fliterresults = new ArrayList();
		allresults =  this.findAll();
		for(Dcsdata dd:allresults){
			if(!dd.getItem().trim().equals("班次")){
				dd.setIsok("0");
				List<DcsDscrib> dcsDscribs = dcsDscribServiceImpl.findbyname(dd.getEquipment().trim(), dd.getItem().trim());
				if (dcsDscribs != null && dcsDscribs.size() > 0) {
					DcsDscrib db = dcsDscribs.get(0);
					// do sth...
					if(dd.getValue()>db.getUpper2()||dd.getValue()<db.getLower2()){
						dd.setIsok("3");
					}else if(dd.getValue()>db.getUpper1()||dd.getValue()<db.getLower1()){
						dd.setIsok("2");
					}else if(dd.getValue()>db.getUpper()||dd.getValue()<db.getLower()){
						dd.setIsok("1");
					}else{
						dd.setIsok("0");
					}
					if (keyword != null) {
						if(db.getName().contains(keyword)){
							fliterresults.add(dd);
						}
					}
					
				}
				results.add(dd);			
			}
		}
	
		if (fliterresults.size()>0) {
			return fliterresults;
			}else{
				return results;
			}
		
	}

}