package cn.edu.jlu.ccst.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.model.Dss_history;
import cn.edu.jlu.ccst.service.Dss_historyService;

import com.opensymphony.xwork2.ActionSupport;
/**
 * DCS历史错误数据相关操作
 * @author Woden
 *
 */
@Component("dsshistoryAction")
@Scope("prototype")
public class DssHistoryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 与用户交互用的错误历史数据列表
	 */
	private List<Dss_history> errorlist;
	/**
	 * 历史错误数据相关操作服务类
	 */
	private Dss_historyService dss_historyService;
	/**
	 * 页面得到的设备名
	 */
    private String name;
    /**
     * 页面得到的设备参数名
     */
    private String parameter;
    /**
     * 页面得到的分组名
     */
    private String unit;
    
    
    
	

	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public String getParameter() {
		return parameter;
	}


	public void setParameter(String parameter) {
		this.parameter = parameter;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Dss_history> getErrorlist() {
		return errorlist;
	}


	@Resource
	public void setErrorlist(List<Dss_history> errorlist) {
		this.errorlist = errorlist;
	}

	public Dss_historyService getDss_historyService() {
		return dss_historyService;
	}


  @Resource
	public void setDss_historyService(Dss_historyService dss_historyService) {
		this.dss_historyService = dss_historyService;
	}


/**
 * 得到所有错误日志
 */
	public String execute() {
		errorlist = dss_historyService.findAll();
		
		return "OK";
		

	}

	/**
	 * 通过设备名得到相关错误日志
	 * @return 错误日志列表
	 */
	public String findbyname(){
		try {
			String keyword= new String(name.getBytes("ISO-8859-1"),"UTF-8");
			errorlist = dss_historyService.findbyname(keyword);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "OK";
	}
	/**
	 * 通过设备参数名得到相关错误日志
	 * @return 错误日志列表
	 */
	public String findbypara(){
//		try {
//			String keyword= new String(parameter.getBytes("ISO-8859-1"),"UTF-8");
//			errorlist = errorlogService.findbypara(keyword);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		return "OK";
		errorlist = dss_historyService.findbypara(parameter);
	    return "OK";
}
	/**
	 * 通过设备分组名得到相关错误日志
	 * @return 错误日志列表
	 */
	public String findbyunit(){
		try {
			String keyword= new String(unit.getBytes("ISO-8859-1"),"UTF-8");
			errorlist = dss_historyService.findbyunit(keyword);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "OK";
	}
}
