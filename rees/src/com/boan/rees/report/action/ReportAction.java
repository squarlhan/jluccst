package com.boan.rees.report.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.report.model.PersonReport;
import com.boan.rees.report.model.TemplateReport;
import com.boan.rees.report.service.IPersonReportService;
import com.boan.rees.report.service.ITemplateReportService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;

/**
 * 报表Action
 * @author zhaomengxue
 * @version 1.0.0
 */

@Controller("reportAction")
@Scope("prototype")
public class ReportAction extends BaseActionSupport{
	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("personReportService")
	private IPersonReportService service;
	
	@Autowired
	@Qualifier("templateReportService")
	ITemplateReportService templateReportService ;
	
	/**
	 * 分页列表
	 */
	Pagination<PersonReport> pagination = new Pagination<PersonReport>();
	/**
	 * 页面对象
	 */
	private PersonReport report;
	
	private TemplateReport template;
	/**
	 * 页面所选行的id
	 */
	private String[] ids;
	
	/**
	 * 查询开始时间
	 */
	private String beginTime;
	
	/**
	 * 查询结束时间
	 */
	private String endTime;
	
	/**
	 * 查询方式列表初始化数据
	 */
	private Map<String,String> selectWayList = new HashMap<String, String>();
	
	/**
	 * 已选的查询方式
	 */
	private String selectWay;

	public PersonReport getReport() {
		return report;
	}

	public void setReport(PersonReport report) {
		this.report = report;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}
	
	public Pagination<PersonReport> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<PersonReport> pagination) {
		this.pagination = pagination;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Map<String, String> getSelectWayList() {
		return selectWayList;
	}

	public void setSelectWayList(Map<String, String> selectWayList) {
		this.selectWayList = selectWayList;
	}

	public String getSelectWay() {
		return selectWay;
	}

	public void setSelectWay(String selectWay) {
		this.selectWay = selectWay;
	}
	/**
	 * 分页显示报表列表
	 * @return
	 */
	public String openReport(){
		pagination = service.findPersonReportForPage(new HashMap(), pagination);
		return this.SUCCESS;
	}

    /**
	 * 添加新报表
	 * @return
	 */
	public String toAddReport(){
		service.save(report);
		return SUCCESS;
	}
	
	/**
	 * 打开报表模板维护页
	 * @return
	 */
	public String openAddTemplate(){
		return SUCCESS;
	}
	
	/**
	 * 保存报表模板
	 * @return
	 */
	public String toAddTemplate(){
		templateReportService.save(template);
		return SUCCESS;
	}

	/**
	 * 打开添加新报表页
	 * @return
	 */	
	public String openAddReport (){
		List<TemplateReport>  templateList= templateReportService.findAllTemplateReport();
		if(templateList.size()>0){
			template = templateList.get(0);
			if(template!=null){
				//获取管理员初始化的汇报题目信息
				String subject = template.getReportSubject();
				report.setReportSubject(subject);
				String type = template.getReportType();
				report.setReportType(subject);
				String person = template.getReportPerson();
				report.setReportPerson(person);
				Calendar date = template.getReportDate();
				report.setReportDate(date);
				String content = template.getReportContent();
				report.setReportContent(content);
			}
		}
		return SUCCESS;
	}

	/**
	 * 删除报表数据
	 * @return
	 */
	public String deleteReport(){
		service.deletePersonReport(ids);
		return NONE;
	}
	
	/**
	 * 为修改报表页面做准备
	 * @return
	 */
	public String openModifyReport(){
		String id = report.getId();
		report = service.get(id);
		return SUCCESS;
	}
	
	/**
	 * 修改报表信息
	 * @return 
	 */
	public String toModifyReport(){
		service.update(report);
		return SUCCESS;
	}
	
	/**
	 * 报表查询
	 * @return
	 * @throws ParseException 
	 */
	public String openReportSearch() throws ParseException{
		selectWayList.put("1", "年查询");
		selectWayList.put("2", "月查询");
		selectWayList.put("3", "自定义");
		Map<String,Calendar> param = new HashMap<String, Calendar>();
		//处理日期查询条件
		dateOperator(param);
		pagination = service.findPersonReportForPage(param, pagination);
		return this.SUCCESS;
	}

	/**
	 * 日期查询条件处理
	 * @param param
	 * @throws ParseException
	 */
	private void dateOperator(Map<String, Calendar> param) throws ParseException {
		
		if(beginTime!=null && endTime!=null && !beginTime.equals("") && !endTime.equals("")){
			String strBeginTime = beginTime;
			String strEndTime = endTime;
			strBeginTime = strBeginTime.replace("年", "-");
			strBeginTime = strBeginTime.replace("月", "-");
			strBeginTime = strBeginTime.replace("日", "");
			if(strBeginTime.length()==5){
				strBeginTime = strBeginTime + "01-01";
			}
			if(strBeginTime.length()==8){
				strBeginTime = strBeginTime + "-01";
			}
			
			Calendar time = Calendar.getInstance();
			strEndTime = strEndTime.replace("年", "-");
			strEndTime = strEndTime.replace("月", "-");
			strEndTime = strEndTime.replace("日", "");
			if(strEndTime.length()==5){
				strEndTime = strEndTime + "12-31";
			}
			
			if(strEndTime.length()==8){
				String[] temp = strEndTime.split("-");
				int year=Integer.parseInt(temp[0]);
				int month=Integer.parseInt(temp[1]);
				time.set(year,month-1,1);
				int day=time.getActualMaximum(Calendar.DAY_OF_MONTH);
				strEndTime = strEndTime + day;
			}
			Calendar begin = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			
			SimpleDateFormat sf=new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ); 
			Date date1=sf.parse( strBeginTime+" 00:00:00" );
			begin.setTime( date1 );
			
			Date date2=sf.parse( strEndTime+" 23:59:59" );
			end.setTime( date2 );
			param.put("beginTime", begin);
			param.put("endTime", end);
		}
	}
}



