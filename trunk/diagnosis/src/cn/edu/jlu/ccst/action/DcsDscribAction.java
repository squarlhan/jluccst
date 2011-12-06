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

	public String addDescrib() {
		dcsDscribService.save(dcsDscrib);
		return SUCCESS;
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
