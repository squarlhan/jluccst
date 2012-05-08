package cn.edu.jlu.ccst.action;

import java.io.UnsupportedEncodingException;
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

/**
 * 规则描述相关操作,用来和用户交互
 * @author Woden
 *
 */

@Component("dcsDscribAction")
@Scope("prototype")
public class DcsDscribAction extends ActionSupport {
/**
 * 描述相关服务类
 */
	private DcsDscribService dcsDscribService;
	/**
	 * 与用户交互的一个描述实例
	 */
	private DcsDscrib dcsDscrib;
	/**
	 * 规则相关服务类
	 */
	private RuleService ruleService;
	/**
	 * 与用户交互的描述列表
	 */
	private List<DcsDscrib> dcsdscriblist;
	/**
	 * 联动下俩框需要的数据
	 */
	private Map nvs;
	private String dcsDscribname1;
	private String dcsDscribname2;
	/**
	 * 从界面得到的设备
	 */
	private String eque;
	/**
	 * 从界面得到的分组
	 */
	private String unit; 
   
	

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getEque() {
		return eque;
	}

	public void setEque(String eque) {
		this.eque = eque;
	}

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
/**
 * 检查用户是否合法
 * @return 合法返回true 否则返回false
 */
	public boolean checkprof() {
		ActionContext actionContext = ActionContext.getContext();
		Map user = actionContext.getSession();
		User us = (User) user.get("pr");
		if (us != null) {
			return true;
		} else
			return false;
	}
/**
 * 页面跳转到描述添加页面
 * @return 描述添加页面
 */
	public String goadd(){
		if (checkprof()) {
//			nvs = dcsDscribService.getallnvs();
//			ActionContext actionContext = ActionContext.getContext();
//			Map session = actionContext.getSession();
//			session.put("map2", nvs);
			return "success";
		}
		return "unproflogin";
	}
	/**
	 * 添加描述操作
	 * @return 添加成功页面
	 */
	public String addDescrib() {
		 
		dcsDscrib.setEque(dcsDscribname1);
		dcsDscrib.setItem(dcsDscribname2);
		dcsDscrib.setName(dcsDscribname1+dcsDscribname2);
		dcsDscribService.save(dcsDscrib);
		dcsdscriblist = dcsDscribService.findall();
		return "bdsuccess";
	}
/**
 * 删除描述操作
 * @return 描述列表页面
 */
	public String deleteDscrib() {
		dcsDscrib = dcsDscribService.findbyid(dcsDscrib.getDid());
		dcsDscribService.removebyid(dcsDscrib.getDid());
		dcsdscriblist = dcsDscribService.findall();
		return "bdsuccess";

	}
/**
 * 更改描述操作
 * @return 描述列表页面
 */
	public String chDscrib() {
		DcsDscrib temp = dcsDscribService.findbyid(dcsDscrib.getDid());
		temp.setLower(dcsDscrib.getLower());
		temp.setUpper(dcsDscrib.getUpper());
		temp.setLower1(dcsDscrib.getLower1());
		temp.setUpper1(dcsDscrib.getUpper1());
		temp.setLower2(dcsDscrib.getLower2());
		temp.setUpper2(dcsDscrib.getUpper2());
		dcsDscribService.save(temp);
		dcsdscriblist = dcsDscribService.findall();
		return "bdsuccess";

	}
/**
 * 页面跳转到描述列表页面
 */
	public String execute() {

		if (checkprof()) {
			dcsdscriblist = dcsDscribService.findall();

			return "bdsuccess";
		} else
			return "unproflogin";
	}
/**
 * 通过设备分组得到相关描述
 * @return 描述列表页面
 */
	public String findbyequep(){
		try {
			String keyword= new String(unit.getBytes("ISO-8859-1"),"UTF-8");
			dcsdscriblist = dcsDscribService.findlikenamep(keyword);
			
	} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		return "bdsuccess";
	}
	/**
	 * 通过设备得到相关描述
	 * @return 描述列表页面
	 */
	public String findbyeque(){
		try {
			String keyword= new String(eque.getBytes("ISO-8859-1"),"UTF-8");
			dcsdscriblist = dcsDscribService.findlikename(keyword);
			
	} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		return "bdsuccess";
	}
}
