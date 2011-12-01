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

@Component("dcsdataService")
public class DcsdataService {
	private Dcsdata dcsdata;
	private DcsdataServiceInter dcsdataServiceImpl;
	private ErrorlogInter errorlogImpl;
	private DcsDscribServiceInter dcsDscribServiceImpl;
	private RuleService ruleService;

	
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
	public void setDcsDscribServiceImpl(DcsDscribServiceInter dcsDscribServiceImpl) {
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
		System.out.println("equipment:"+dcsdata.getEquipment());
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
		if (dcsDscribs != null && dcsDscribs.size() > 0) {
			DcsDscrib db = dcsDscribs.get(0);
			if (dd.getValue() > db.getUpper()) {
				br = new BackwardandResult();
				br.setNouns(db.getName());
				br.setVerb("过高");
				br.setMemo(db.getEque());
				err = new Errorlog();	
				err.setLevel("过高");
				errorlogImpl.save(err);
			}
			if (dd.getValue() < db.getLower()) {
				br = new BackwardandResult();
				br.setNouns(db.getName());
				br.setMemo(db.getEque());
				br.setVerb("过低");
				err = new Errorlog();				
				err.setLevel("过低");
				errorlogImpl.save(err);
			}
		}
		if(br!=null){
			List<BackwardandResult> brs = new ArrayList();
			brs.add(br);
			List<BackwardandReason> bss = ruleService.findreasons(brs);
			if(bss!=null&&bss.size()>0){
				String reasons = "";
				String suggs = "";
				for(BackwardandReason bs : bss){
					reasons = reasons + bs.getNouns() + bs.getVerb() + ";";
					suggs = suggs + bs.getSugg() + ";";
				}
				err.setItem(dd.getItem());
				err.setValue(dd.getValue());
				err.setEquipment(dd.getEquipment());
				err.setError(reasons);
				err.setSugg(suggs);
				err.setTime(mytime);
			}
			if(err.getEquipment()!=null){
				errorlogImpl.save(err);
			}
				
			
		}

		return br;
	}

}