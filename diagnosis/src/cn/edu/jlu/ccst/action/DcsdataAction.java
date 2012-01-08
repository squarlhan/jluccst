package cn.edu.jlu.ccst.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.jlu.ccst.model.BackwardandReason;
import cn.edu.jlu.ccst.model.BackwardandResult;
import cn.edu.jlu.ccst.model.DcsDscrib;
import cn.edu.jlu.ccst.model.Dcsdata;
import cn.edu.jlu.ccst.model.MotoDcsdata;
import cn.edu.jlu.ccst.model.Dcshistory;
import cn.edu.jlu.ccst.model.Errorlog;
import cn.edu.jlu.ccst.model.Pre_dss;
import cn.edu.jlu.ccst.model.Wwdcsdata;

import cn.edu.jlu.ccst.model.User;
import cn.edu.jlu.ccst.service.DcsdataService;
import cn.edu.jlu.ccst.service.MotoDcsdataService;
import cn.edu.jlu.ccst.service.DcshistoryService;
import cn.edu.jlu.ccst.service.ErrorlogService;
import cn.edu.jlu.ccst.service.Pre_dssService;
import cn.edu.jlu.ccst.service.RuleService;

@Component("dcsdataAction")
@Scope("prototype")
public class DcsdataAction extends ActionSupport {

	private List<Dcsdata> equipmentlist;
	private List<Dcsdata> dcsdatalist;
	private List<MotoDcsdata> motodcsdatalist;
	private DcsdataService dcsdataService;
	private MotoDcsdataService motodcsdataService;
	private Dcsdata dcsdata;
	private MotoDcsdata motodcsdata;
	private Dcshistory dcshistory;
	private DcshistoryService dcshistoryService;
	private List<BackwardandResult> backwardandResult;
	private List<BackwardandReason> reasonlist;
	private RuleService ruleService;
	private String keyword;
	private String papkey;
	
	

	public String getPapkey() {
		return papkey;
	}

	public void setPapkey(String papkey) {
		this.papkey = papkey;
	}

	public List<MotoDcsdata> getMotodcsdatalist() {
		return motodcsdatalist;
	}

	public void setMotodcsdatalist(List<MotoDcsdata> motodcsdatalist) {
		this.motodcsdatalist = motodcsdatalist;
	}

	public MotoDcsdataService getMotodcsdataService() {
		return motodcsdataService;
	}
	@Resource
	public void setMotodcsdataService(MotoDcsdataService motodcsdataService) {
		this.motodcsdataService = motodcsdataService;
	}

	public MotoDcsdata getMotodcsdata() {
		return motodcsdata;
	}

	public void setMotodcsdata(MotoDcsdata motodcsdata) {
		this.motodcsdata = motodcsdata;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public RuleService getRuleService() {
		return ruleService;
	}

	@Resource
	public void setRuleService(RuleService ruleService) {
		this.ruleService = ruleService;
	}

	public List<BackwardandResult> getBackwardandResult() {
		return backwardandResult;
	}

	public void setBackwardandResult(List<BackwardandResult> backwardandResult) {
		this.backwardandResult = backwardandResult;
	}

	public List<BackwardandReason> getReasonlist() {
		return reasonlist;
	}

	public void setReasonlist(List<BackwardandReason> reasonlist) {
		this.reasonlist = reasonlist;
	}

	public Dcshistory getDcshistory() {
		return dcshistory;
	}

	public void setDcshistory(Dcshistory dcshistory) {
		this.dcshistory = dcshistory;
	}

	public DcshistoryService getDcshistoryService() {
		return dcshistoryService;
	}

	@Resource
	public void setDcshistoryService(DcshistoryService dcshistoryService) {
		this.dcshistoryService = dcshistoryService;
	}

	public List<Dcsdata> getDcsdatalist() {
		return dcsdatalist;
	}

	public void setDcsdatalist(List<Dcsdata> dcsdatalist) {
		this.dcsdatalist = dcsdatalist;
	}

	public Dcsdata getDcsdata() {
		return dcsdata;
	}

	public void setDcsdata(Dcsdata dcsdata) {
		this.dcsdata = dcsdata;
	}

	public List<Dcsdata> getEquipmentlist() {
		return equipmentlist;
	}

	public void setEquipmentlist(List<Dcsdata> equipmentlist) {
		this.equipmentlist = equipmentlist;
	}

	public DcsdataService getDcsdataService() {
		return dcsdataService;
	}

	@Resource
	public void setDcsdataService(DcsdataService dcsdataService) {
		this.dcsdataService = dcsdataService;
	}

	public boolean checkuser() {
		ActionContext actionContext = ActionContext.getContext();
		Map user = actionContext.getSession();
		User us = (User) user.get("us");
		if (us != null) {
			return true;
		} else
			return false;
	}

	public String equipmentList(String str) {
		if (checkuser()) {
			equipmentlist = dcsdataService.findbyequipment(str);
			return SUCCESS;
		} else
			return "unuserlogin";
	}
	
	public String showdcsdatas(){
		String key = null;
		dcsdatalist = dcsdataService.getalldcsddata(key);
		return "dcs";
	}
	
	
	public String showmotodcsdatas(){
		String key = null;
			motodcsdatalist = motodcsdataService.getalldcsddata(key);

		return "motodcs";
	}

	public String showgongyidatas() {
		String key = null;
			dcsdatalist = dcsdataService.getallgongyidata(key);

		return "gongyi";
	}
	
	public String showdcsdata(){
		String key = null;
		try {
			if (keyword != null) {
				key = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
				// key="3系列生化池";
			}
			dcsdatalist = dcsdataService.getalldcsddatan(key);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "dcs";
	}
	
	
	public String showmotodcsdata(){
		String key = null;
		try {
			if (keyword != null) {
				key = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
				// key="3系列生化池";
			}
			motodcsdatalist = motodcsdataService.getalldcsddatan(key);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "motodcs";
	}

	public String showgongyidata() {
		String key = null;
		try {
			if (keyword != null) {
				key = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
				// key="3系列生化池";
			}
			dcsdatalist = dcsdataService.getallgongyidatan(key);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "gongyi";
	}
	
	public String showdcsdatap(){
		String key = null;
		try {
			if (papkey != null) {
				key = new String(papkey.getBytes("ISO-8859-1"), "UTF-8");
				// key="3系列生化池";
			}
			dcsdatalist = dcsdataService.getalldcsddatap(key);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "dcs";
	}
	
	
	public String showmotodcsdatap(){
		String key = null;
		try {
			if (keyword != null) {
				key = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
				// key="3系列生化池";
			}
			motodcsdatalist = motodcsdataService.getalldcsddatap(key);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "motodcs";
	}

	public String showgongyidatap() {
		String key = null;
		try {
			if (keyword != null) {
				key = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
				// key="3系列生化池";
			}
			dcsdatalist = dcsdataService.getallgongyidatap(key);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "gongyi";
	}

	/*
	 * public String alterDcsdata () { User olduser = (User)
	 * ActionContext.getContext().getSession() .get("us");
	 * 
	 * 
	 * if (olduser.getPassword().equals(currentpassword)) {
	 * 
	 * if(newpassword.isEmpty()) { return "nullpass";}
	 * user.setPassword(newpassword); user.setId(olduser.getId());
	 * user.setUsername(olduser.getUsername()); userService.save(user);
	 * 
	 * 
	 * ActionContext actionContext = ActionContext.getContext(); Map session =
	 * actionContext.getSession(); session.put("us", user); return
	 * "altersuccess"; } else {
	 * 
	 * return "altererror"; }
	 * 
	 * }
	 */
	public String save() {
		/*
		 * ActionContext actionContext = ActionContext.getContext(); Map
		 * session1 = actionContext.getSession(); Wwdcsdata wc = (Wwdcsdata)
		 * session1.get("wc");
		 */
		dcsdataService.save(dcsdata);
		return "savesuccess";
	}

	public String listsave() {
		List<Dcsdata> list = new ArrayList<Dcsdata>();
		List<Dcshistory> list2 = new ArrayList<Dcshistory>();
		List<Dcsdata> list1 = new ArrayList<Dcsdata>();
		List<Errorlog> list3 = new ArrayList<Errorlog>();
		backwardandResult = new ArrayList();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String mytime = formatter.format(new Date());
	
		

		for (int i = 0; i < dcsdatalist.size(); i++) {

			if (dcsdatalist.get(i) != null) {

				Dcsdata dat = new Dcsdata();
				dat.setItem(dcsdatalist.get(i).getItem());
				dat.setValue(dcsdatalist.get(i).getValue());
				dat.setEquipment(dcsdatalist.get(i).getEquipment());
				if (dat.getValue() != null) {
					list1 = dcsdataService.findbyitem(dat.getEquipment(), dat.getItem());
					for (Dcsdata dc : list1) {
						dcsdataService.delete(dc);
					}
					list.add(dat);
					dcsdataService.save(dat);
				}
				Dcshistory his = new Dcshistory();
				his.setItem(dcsdatalist.get(i).getItem());
				his.setValue(dcsdatalist.get(i).getValue());
				his.setEquipment(dcsdatalist.get(i).getEquipment());
				his.setSeqno(mytime);
				if (his.getValue() != null) {
					list2.add(his);
					dcshistoryService.save(his);
					BackwardandResult tempbr = dcsdataService
							.validateinput(dcsdatalist.get(i));
					if (tempbr != null) {
						backwardandResult.add(tempbr);
					}

				}

			}
		}

		if (backwardandResult != null && backwardandResult.size() > 0) {
			reasonlist = ruleService.findreasons(backwardandResult);
			return "saveerror";
		}
		return "savelistsuccess";
	}

}
