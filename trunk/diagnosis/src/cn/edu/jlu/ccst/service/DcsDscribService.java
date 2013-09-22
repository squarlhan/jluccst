package cn.edu.jlu.ccst.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import cn.edu.jlu.ccst.dao.TreeunitServiceInter;
import cn.edu.jlu.ccst.model.*;
import cn.edu.jlu.ccst.dao.MotoDcsdataServiceInter;
/**
 * dcs描述服务类
 */
@Component("dcsDscribService")
public class DcsDscribService {
	/**
	 * dcs描述实例
	 */
	private DcsDscrib dDcsDscrib;
	/**
	 * dcs描述服务类
	 */
	private DcsDscribServiceInter dcsDscribServiceImpl;
	/**
	 * dcs数据服务类
	 */
	private DcsdataService dcsdataService;
	/**
	 * 工艺预处理服务类
	 */
	private Pre_dssService pre_dssService;
	/**
	 * 工艺预处理对照服务类
	 */
	private Init_PredictServiceInter init_predictServiceImpl;
	/**
	 * 实时监控dcs数据服务类
	 */
	private MotoDcsdataServiceInter motoDcsdataServiceImpl;
	/**
	 * 实时监控工艺数据实例
	 */
	private MotoDcsdata motoDcsdata;
	/**
	 * 实时监控数据服务类
	 */
	private MotoDcsdataService motoDcsdataService;
	/**
	 * 树形菜单服务类
	 */
	private TreeunitServiceInter treeunitServiceImpl;
	private RuleService ruleService;
	private MotoErrorlogService motoerrorlogService;

	
	public RuleService getRuleService() {
		return ruleService;
	}
	@Resource
	public void setRuleService(RuleService ruleService) {
		this.ruleService = ruleService;
	}
	public MotoErrorlogService getMotoerrorlogService() {
		return motoerrorlogService;
	}
	@Resource
	public void setMotoerrorlogService(MotoErrorlogService motoerrorlogService) {
		this.motoerrorlogService = motoerrorlogService;
	}
	public TreeunitServiceInter getTreeunitServiceImpl() {
		return treeunitServiceImpl;
	}
	@Resource
	public void setTreeunitServiceImpl(TreeunitServiceInter treeunitServiceImpl) {
		this.treeunitServiceImpl = treeunitServiceImpl;
	}
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
	
	 * ruleServiceImpl.save(backward); }
	 */
	
	public DcsDscrib getdDcsDscrib() {
		return dDcsDscrib;
	}

	public MotoDcsdataService getMotoDcsdataService() {
		return motoDcsdataService;
	}
	@Resource
	public void setMotoDcsdataService(MotoDcsdataService motoDcsdataService) {
		this.motoDcsdataService = motoDcsdataService;
	}

	public MotoDcsdataServiceInter getMotoDcsdataServiceImpl() {
		return motoDcsdataServiceImpl;
	}
	@Resource
	public void setMotoDcsdataServiceImpl(
			MotoDcsdataServiceInter motoDcsdataServiceImpl) {
		this.motoDcsdataServiceImpl = motoDcsdataServiceImpl;
	}

	public MotoDcsdata getMotoDcsdata() {
		return motoDcsdata;
	}

	public void setMotoDcsdata(MotoDcsdata motoDcsdata) {
		this.motoDcsdata = motoDcsdata;
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
	/**
	 * 找到所有现象名称
	 * @return 名称列表
	 */
	public List<String> findallname() {
		List<String> name = dcsDscribServiceImpl.findAllname();
		List<String> result = new ArrayList();
		for (String na : name) {
			if (na != null && na.trim().length() > 0)
				result.add(na);
		}
		return result;
	}
	/**
	 * 根据名称查找dcs描述数据
	 *  @param name 设备参数名称
	 * @return 数据列表
	 */
	public List<DcsDscrib> findbyname(String name) {
		List<DcsDscrib> dds = new ArrayList();
		dds = dcsDscribServiceImpl.findbyname(name);
		//if(dds.size()<1)dds = findall();
		return dds;
	}
	/**
	 * 根据名称相似查找dcs描述数据
	 * @param name 设备参数名称
	 * @return 数据列表
	 */
	public List<DcsDscrib> findlikename(String name) {
		List<DcsDscrib> dds = new ArrayList();
		dds = dcsDscribServiceImpl.findlikename(name);
		//if(dds.size()<1)dds = findall();
		return dds;
	}
	/**
	 * 根据名称详细查找dcs描述数据预处理
	 * @param name 设备参数名称
	 * @return 数据列表
	 */
	public List<DcsDscrib> findlikenamep(String name) {
		List<DcsDscrib> results = new ArrayList();
		List<String> jiedians = treeunitServiceImpl.findallchild(name);
		for(String jiedian:jiedians){
			List<DcsDscrib> temp =  findbyeque(jiedian);
			results.addAll(temp);
		}
		return results;
	}
	/**
	 * 根据设备查找dcs描述数据
	 * @param eque 设备参数名称
	 * @return 数据列表
	 */
	public List<DcsDscrib> findbyeque(String eque) {
		List<DcsDscrib> dds = new ArrayList();
		dds = dcsDscribServiceImpl.findbyeque(eque);
		//if(dds.size()<1)dds = findall();
		return dds;
	}
	/**
	 * 查找所有dcs描述数据
	 * @return  数据列表
	 */
	public List<DcsDscrib> findall() {
		List<DcsDscrib> dcsDscriblist = dcsDscribServiceImpl.findAll();

		return dcsDscriblist;
	}
	/**
	 * 根据id查找dcs描述数据
	 * @param id id号
	 * @return dcs数据
	 */
	public DcsDscrib findbyid(int id){
		 return dcsDscribServiceImpl.find(id);
    } 
	/**
	 * 根据id删除dcs数据
	 *  @param id id号
	 */
	public void removebyid(int id){
		dcsDscribServiceImpl.remove(id);
	 }
	/**
	 * 保存dcs数据
	 *  @param dcsDscrib id号
	 */
	public void save(DcsDscrib dcsDscrib) {
		dcsDscribServiceImpl.save(dcsDscrib);
	}
	/**
	 * 获得所有树形菜单节点
	 */
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
	/**
	 * 根据dcs描述将输入数据转化成规则现象
	 * @param map 映射实体
	 * @return 现象列表
	 */
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
	/**
	 * 将输入数据转化成规则现象
	 * @return 现象列表
	 */

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
	/**
	 * 将输入固定批次数据转化成规则现象1
	 * @return 现象列表
	 */
	public List<BackwardandResult> validateinput1() {
		List<Pre_dss> alldata = pre_dssService.findBysimu_time();
		List<BackwardandResult> results = new ArrayList();
		for (Pre_dss dd : alldata) {
			if (dd.getName() != null) {
				String temp = dd.getName().getName().replace('.', ',');
				String[] strArray = temp.split(",");

				// String[] strArray=dd.getName().split(",");
				
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
	/**
	 * 将输入固定批次数据转化成规则现象2
	 * @return 现象列表
	 */
	
	public List<BackwardandResult> validateinput2() {
		List<MotoDcsdata> alldata = motoDcsdataService.findAll();
		List<BackwardandResult> results = new ArrayList();
		for (MotoDcsdata dd : alldata) {

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
	
	public List<BackwardandResult> validateinput3() {
		List<MotoDcsdata> alldata = motoDcsdataService.findAll();
		List<BackwardandResult> results = new ArrayList();
		MotoErrorlog err = null;
		BackwardandResult br = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mytime = formatter.format(new Date());
		for (MotoDcsdata dd : alldata) {
			List<DcsDscrib> dcsDscribs = dcsDscribServiceImpl.findbyname(
					dd.getEquipment(), dd.getItem());
			int level = 0;
			if (dd.getItem().contains("COD")) {
				level = 9;
			} else if (dd.getItem().contains("NH3-N")
					|| dd.getItem().contains("NH3N")) {
				level = 8;
			} else if (dd.getItem().contains("SS")) {
				level = 7;
			} else if (dd.getItem().contains("PH")) {
				level = 6;
			} else if (dd.getItem().contains("BOD")) {
				level = 5;
			} else {
				level = 2;
			}
			if (dcsDscribs != null && dcsDscribs.size() > 0) {
				DcsDscrib db = dcsDscribs.get(0);
				if (dd.getValue() > db.getUpper()) {
					if (dd.getValue() > db.getUpper2()) {
						level += 3;
					} else if (dd.getValue() > db.getUpper1()) {
						level += 2;
					} else {
						level++;
					}
					br = new BackwardandResult();
					br.setNouns(db.getName());
					br.setVerb("过高");
					br.setMemo(db.getEque());
					err = new MotoErrorlog();
					err.setWrong("过高");
					results.add(br);
					// errorlogImpl.save(err);
				}
				if (dd.getValue() < db.getLower()) {
					if (dd.getValue() < db.getLower2()) {
						level += 3;
					} else if (dd.getValue() < db.getLower1()) {
						level += 2;
					} else {
						level++;
					}
					br = new BackwardandResult();
					br.setNouns(db.getName());
					br.setMemo(db.getEque());
					br.setVerb("过低");
					err = new MotoErrorlog();
					err.setWrong("过低");
					results.add(br);
					// errorlogImpl.save(err);
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
					err.setError(reasons);
					err.setSugg(suggs);
				}
				err.setItem(dd.getItem());
				err.setValue(dd.getValue());
				err.setEquipment(dd.getEquipment());
				err.setTime(mytime);
				err.setLevel(String.valueOf(level));
				if (err.getEquipment() != null) {
					motoerrorlogService.save(err);
				}

			}
		}
		return results;
	}
}
