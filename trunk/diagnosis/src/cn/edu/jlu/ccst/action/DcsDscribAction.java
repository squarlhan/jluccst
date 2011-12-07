package cn.edu.jlu.ccst.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.jlu.ccst.model.Backward;
import cn.edu.jlu.ccst.model.DcsDscrib;
import cn.edu.jlu.ccst.model.User;
import cn.edu.jlu.ccst.service.DcsDscribService;
import cn.edu.jlu.ccst.service.RuleService;

@Component("dcsDscribAction")
@Scope("prototype")
public class DcsDscribAction extends ActionSupport {

	private DcsDscribService dcsDscribService;
	private DcsDscrib dcsDscrib;
	private RuleService ruleService;
	private List<DcsDscrib> dcsdscriblist;
	private Map nvs;
	private String dcsDscribname1;
	private String dcsDscribname2;
	
	

	public Map getNvs() {
		return nvs;
	}

	public String getDcsDscribname1() {
		return dcsDscribname1;
	}

	public void setDcsDscribname1(String dcsDscribname1) {
		this.dcsDscribname1 = dcsDscribname1;
	}

	public String getDcsDscribname2() {
		return dcsDscribname2;
	}

	public void setDcsDscribname2(String dcsDscribname2) {
		this.dcsDscribname2 = dcsDscribname2;
	}

	public void setNvs(Map nvs) {
		this.nvs = nvs;
	}

	public List<DcsDscrib> getDcsdscriblist() {
		return dcsdscriblist;
	}

	public void setDcsdscriblist(List<DcsDscrib> dcsdscriblist) {
		this.dcsdscriblist = dcsdscriblist;
	}

	public RuleService getRuleService() {
		return ruleService;
	}

	@Resource
	public void setRuleService(RuleService ruleService) {
		this.ruleService = ruleService;
	}

	public DcsDscribService getDcsDscribService() {
		return dcsDscribService;
	}

	@Resource
	public void setDcsDscribService(DcsDscribService dcsDscribService) {
		this.dcsDscribService = dcsDscribService;
	}

	public DcsDscrib getDcsDscrib() {
		return dcsDscrib;
	}

	public void setDcsDscrib(DcsDscrib dcsDscrib) {
		this.dcsDscrib = dcsDscrib;
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

	public String goadd(){
		if (checkuser()) {
			nvs = dcsDscribService.getallnvs();
			ActionContext actionContext = ActionContext.getContext();
			Map session = actionContext.getSession();
			session.put("map2", nvs);
			return "success";
		}
		return "unuserlogin";
	}
	
	public String addDescrib() {
		dcsDscrib.setName(dcsDscribname1+dcsDscribname2);
		dcsDscribService.save(dcsDscrib);
		dcsdscriblist = dcsDscribService.findall();
		return "bdsuccess";
	}

	public String deleteDscrib() {
		dcsDscrib = dcsDscribService.findbyid(dcsDscrib.getDid());
		dcsDscribService.removebyid(dcsDscrib.getDid());
		dcsdscriblist = dcsDscribService.findall();
		return "bdsuccess";

	}

	public String chDscrib() {
		DcsDscrib temp = dcsDscribService.findbyid(dcsDscrib.getDid());
		temp.setLower(dcsDscrib.getLower());
		temp.setUpper(dcsDscrib.getUpper());
		dcsDscribService.save(temp);
		dcsdscriblist = dcsDscribService.findall();
		return "bdsuccess";

	}

	public String execute() {

		if (checkuser()) {
			dcsdscriblist = dcsDscribService.findall();

			return "bdsuccess";
		} else
			return "unuserlogin";
	}

}
