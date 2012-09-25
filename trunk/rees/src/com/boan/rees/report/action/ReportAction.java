package com.boan.rees.report.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.report.model.PersonReport;
import com.boan.rees.report.model.TemplateReport;
import com.boan.rees.report.service.IPersonReportService;
import com.boan.rees.report.service.ITemplateReportService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;
import com.boan.rees.utils.poi.PoiUtil;

/**
 * 报表Action
 * @author zhaomengxue
 * @version 1.0.0
 */

@Controller("reportAction")
@Scope("prototype")
public class ReportAction extends BaseActionSupport{

	private static final long serialVersionUID = 1L;

	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("personReportService")
	private IPersonReportService service;
	
	/**
	 * 用于调用数据库跟人报表相关操作
	 */
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
	
	/**
	 * 个人报表模板对象
	 */
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
	/**
	 * 公司Id
	 */
	private String companyId;
	/**
	 * 工厂Id
	 */
	private String factoryId;
	/**
	 * 车间Id
	 */
	private String workshopId;
	
	/**
	 * 操作提示
	 */
	private String message;
	
	/**
	 * 上传的文件
	 */
	private File[] files;

	/**
	 * 上传的文件名称
	 */
	private String[] filesFileName;

	/**
	 * 上传的文件类型
	 */
	private String[] filesContentType;

	/**
	 * 上传文件保存路径
	 */
	private String savePath;
	
	/**
	 * 下载文件时的文件流
	 */
	private InputStream inputStream;
	
	/**
	 * 下载时用的文件名
	 */
	private String downloadFileName;

	public TemplateReport getTemplate() {
		return template;
	}

	public void setTemplate(TemplateReport template) {
		this.template = template;
	}

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
	
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}

	public String getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(String workshopId) {
		this.workshopId = workshopId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public String[] getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

	public String[] getFilesContentType() {
		return filesContentType;
	}

	public void setFilesContentType(String[] filesContentType) {
		this.filesContentType = filesContentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getDownloadFileName() {
		return downloadFileName;
	}

	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}

	/**
	 * 分页显示报表列表
	 * @return
	 */
	public String openReport(){
		Map<String,String> param = new HashMap<String, String>();
		param.put("deptId", sessionWorkshopId);
		pagination = service.findPersonReportForPage(param, pagination);
		return this.SUCCESS;
	}

	/**
	 * 打开添加新报表页
	 * @return
	 */	
	public String openAddReport (){
		template = templateReportService.findLastTemplateReport();
		if(template!=null){
			if(report==null){
				report = new PersonReport();
			}
			//获取管理员初始化的汇报题目信息
			String templateId = template.getId();
			report.setTemplateId(templateId);
			String subject = template.getReportSubject();
			report.setReportSubject(subject);
			String type = template.getReportType();
			report.setReportType(type);
			String person = template.getReportPerson();
			report.setReportPerson(person);
			Calendar date = template.getReportDate();
			report.setReportDate(date);
			String content = template.getReportContent();
			report.setReportContent(content);

			//保存为当前登录人所在的车间Id
			report.setDeptId(sessionWorkshopId);
		}
		return SUCCESS;
	}
	
	 /**
	 * 添加新报表
	 * @return
	 */
	public String toAddReport(){
		try {
			saveAttachmentToDevice(report);
			service.save(report);
			message="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}

	/**
	 * 重写字段错误信息添加方法，对错误信息进行从新构造
	 * @param fieldName
	 * @param errorMessage
	 */
	@Override
	public void addFieldError(String fieldName, String errorMessage) {
		if(errorMessage.startsWith("File too large: files")){
			//档文件过大时提示
			errorMessage= this.getText("struts.messages.error.file.too.large");
		}else if(errorMessage.startsWith("Content-Type not allowed: files")){
			//当文件类型不允许时提示
			errorMessage=  this.getText("struts.messages.error.content.type.not.allowed");
		}
		super.addFieldError(fieldName, errorMessage);
	}
	
	/**
	 * 为设备添加图片信息
	 * @param device
	 */
	private void saveAttachmentToDevice(PersonReport report) {
		try {
			ServletContext servletContext = ServletActionContext.getServletContext();
			//根据配置在服务器上查找指定目录，如果不存在则创建
			String dataDir = servletContext.getRealPath(savePath);
			File dir = new File(dataDir);
			if(!dir.exists()){
				dir.mkdirs();
			}
			if(files!=null){
				for (int i = 0; i < files.length; i++) {
					//生成随机文件名
					String fileName = UUID.randomUUID().toString();
					//获取文件名后缀
					String suffix = filesFileName[i].substring(filesFileName[i].lastIndexOf('.'));
					FileOutputStream fos = new FileOutputStream(dataDir + File.separator + fileName + suffix);
					//构建保存到数据库中的图片针对服务器的相对路径
					String filePath = savePath + File.separator + fileName+ suffix;
					report.setFilePath(filePath.replace("/", File.separator));
					report.setFileName( filesFileName[i]);
					FileInputStream fis = new FileInputStream(files[i]);
					//上传
					IOUtils.copy(fis, fos);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		try {
			saveAttachmentToDevice(report);
			service.update(report);
			message="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}
	
	
	/**
	 * 删除附件
	 * @return
	 */
	public String toDeleteReportAttachment(){
		String reportId = report.getId();
		service.deleteReportAttachment(reportId);
		return NONE;
	}
	
	/**
	 * 下载设备图片
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public String toDownloadReportAttachment() throws UnsupportedEncodingException, FileNotFoundException{
		ServletContext servletContext = ServletActionContext.getServletContext();
		String id = report.getId();
		if(id!=null && !id.equals("")){
			report = service.get(id);
		}
		//获取服务器上图片的保存路径
		String fileAllName = servletContext.getRealPath(report.getFilePath());
		File file = new File(fileAllName);
		if(file.exists()){
			inputStream = new FileInputStream(file);
			//获取图片后缀名
			String suffix    = fileAllName.substring(fileAllName.lastIndexOf('.'));
			downloadFileName =report.getFileName();
			//处理中文乱码
			downloadFileName = new String(downloadFileName.getBytes(), "ISO8859-1");   
		}
		return SUCCESS;
	}
	
	/**
	 * 下载前服务器端验证
	 */
	public void validateToDownloadReportAttachment(){
		ServletContext servletContext = ServletActionContext.getServletContext();
		//获取服务器上图片的保存路径
		String fileAllName = servletContext.getRealPath(report.getFilePath());
		File file = new File(fileAllName);
		if(!file.exists()){
			addFieldError("","设备图片不存在，请联系管理员！");
		}
	}
	
	
	/**
	 * 导出个人报表模板文件
	 * @return
	 * @throws IOException 
	 */
	public String toExportReport() throws IOException{
		String templateId = null;
		if(report!=null){
			templateId = report.getTemplateId();
		}
		if(templateId!=null && !templateId.equals("")){
			TemplateReport template = templateReportService.get(templateId);
			ServletContext servletContext = ServletActionContext.getServletContext();
			//获取服务器上模板文件的保存路径
			String fileAllName = servletContext.getRealPath(template.getTemplatePath());
			File file = new File(fileAllName);
			if(file.exists()){
				Map<String, String> map = new HashMap<String, String>();
				try{
					InputStream inStream = this.getClass().getResourceAsStream("/person_template_bookmark_config.properties"); 
					if(inStream!=null){
						Properties props = new Properties();
						props.load(inStream);
						if(props!=null){
							for ( Enumeration e = props.propertyNames(); e.hasMoreElements(); ){
								 String key = (String)e.nextElement();
								 //获取配置文件中属性对应的书签 
								 String bookMark = props.getProperty(key);
								 //使用反射获取属性的get方法 ,用于得到对象中的值
								 Method getMethod = report.getClass().getMethod("get"+key);
								 String bookMarkValue = "";
								 if(getMethod.invoke(report)!=null  &&  getMethod.invoke(report) instanceof Calendar ) {
									 bookMarkValue= (new SimpleDateFormat( "yyyy-MM-dd")).format(((Calendar)getMethod.invoke(report)).getTime()) ;
								} else if ( getMethod.invoke(report)!=null ){
									bookMarkValue=getMethod.invoke(report).toString();
								}else{
									bookMarkValue="";
								}
								 System.out.println(key + " : "+ props.getProperty(key) );
								 map.put(bookMark,bookMarkValue);
							}
						}
					}
				}catch(Exception e){
					e.printStackTrace();
					System.out.print("没有使用配置文件配置模板键值！");
				}
				
				//如果没有使用配置文件配置模板键值 ，则提供默认对应值 
				if(map.size()==0){
					map.put("汇报类别", report.getReportType());
					map.put("汇报题目", report.getReportSubject());
					map.put("汇报人", report.getReportPerson());
					map.put("汇报时间",(new SimpleDateFormat( "yyyy-MM-dd")).format(report.getReportDate().getTime()));
					map.put("汇报内容", report.getReportContent());
				}

				ByteArrayOutputStream outputStream = PoiUtil.wordProcessor(fileAllName,map);
				inputStream = new ByteArrayInputStream(outputStream.toByteArray());
				String suffix = fileAllName.substring(fileAllName.lastIndexOf('.'));
				//downloadFileName =template.getTemplateName();
				downloadFileName = "【"+report.getReportPerson()+"】"+"个人报表"+suffix;
				//处理中文乱码
				downloadFileName = new String(downloadFileName.getBytes(), "ISO8859-1");   
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 模板导出前验证 
	 */
	public void validateToExportReport(){
		String templateId = null;
		if(report!=null){
			report = service.get(report.getId());
			templateId = report.getTemplateId();
			TemplateReport template = templateReportService.get(templateId);
			if(template!=null){
				ServletContext servletContext = ServletActionContext.getServletContext();
				//获取服务器上模板文件的保存路径
				String fileAllName = servletContext.getRealPath(template.getTemplatePath());
				if(fileAllName==null || fileAllName.equals("")){
					addFieldError("", "系统没有找到模板文件，请联系管理员！");
				}else{
					File file = new File(fileAllName);
					if(!file.exists() || file.isDirectory()){
						addFieldError("", "系统没有找到模板文件，请联系管理员！");
					}
				}
			}else{
				addFieldError("", "系统没有设置报表模板信息，请联系管理员！");
			}
		}else{
			addFieldError("", "没有指定个人报表！");
		}
		if(templateId!=null && !templateId.equals("")){
			TemplateReport template = templateReportService.get(templateId);
			if(template==null){
				addFieldError("", "系统没有设置报表模板信息，请联系管理员！");
			}
		}else{
//			addFieldError("", "个人报表没有对应的模板！");
			addFieldError("", "系统没有设置报表模板信息，请联系管理员！");
		}
	}
	
	//*****************************************************************************************************************//
	/**
	 * 打开报表模板维护页
	 * @return
	 */
	public String openAddTemplate(){
		template = templateReportService.findLastTemplateReport();
		return SUCCESS;
	}
	
	/**
	 * 保存报表模板
	 * @return
	 */
	public String toAddTemplate(){
		try {
			saveTempleFileToTemplateReport(template);
			template.setId(StringUtils.trimToNull(template.getId()));
			templateReportService.saveOrUpdate(template);
			message="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}
	
	/**
	 * 为设备添加图片信息
	 * @param device
	 */
	private void saveTempleFileToTemplateReport(TemplateReport templateReport) {
		try {
			ServletContext servletContext = ServletActionContext.getServletContext();
			//根据配置在服务器上查找指定目录，如果不存在则创建
			String dataDir = servletContext.getRealPath(savePath);
			File dir = new File(dataDir);
			if(!dir.exists()){
				dir.mkdirs();
			}
			if(files!=null){
				for (int i = 0; i < files.length; i++) {
					//生成随机文件名
					String fileName = UUID.randomUUID().toString();
					
					templateReport.setTemplateName(filesFileName[i]);
					//获取文件名后缀
					String suffix = filesFileName[i].substring(filesFileName[i].lastIndexOf('.'));
					FileOutputStream fos = new FileOutputStream(dataDir + File.separator + fileName + suffix);
					//构建保存到数据库中的图片针对服务器的相对路径
					String filePath = savePath + File.separator + fileName+ suffix;
					templateReport.setTemplatePath(filePath.replace("/", File.separator));
					FileInputStream fis = new FileInputStream(files[i]);
					//上传
					IOUtils.copy(fis, fos);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 请求执行方法前验证
	 */
	public void validateToAddTemplate() {
		if(files == null){
        }
	}

	/**
	 * 下载个人报表模板文件
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public String toDownloadTempleFile() throws UnsupportedEncodingException, FileNotFoundException{
		ServletContext servletContext = ServletActionContext.getServletContext();
		//获取服务器上模板文件的保存路径
		String fileAllName = servletContext.getRealPath(template.getTemplatePath());
		File file = new File(fileAllName);
		if(file.exists()){
			inputStream = new FileInputStream(file);
//			//获取文件后缀名
//			String suffix    = fileAllName.substring(fileAllName.lastIndexOf('.'));
			downloadFileName =template.getTemplateName();
			//处理中文乱码
			downloadFileName = new String(downloadFileName.getBytes(), "ISO8859-1");   
		}
		return SUCCESS;
	}
	
	/**
	 * 下载前服务器端验证
	 */
	public void validateToDownloadTempleFile(){
		ServletContext servletContext = ServletActionContext.getServletContext();
		//获取服务器上模板文件的保存路径
		String fileAllName = servletContext.getRealPath(template.getTemplatePath());
		File file = new File(fileAllName);
		if(!file.exists()){
			addFieldError("","模板文件不存在，请联系管理员！");
		}
	}
	
	/**
	 * 删除个人报表模板文件
	 * @return
	 */
	public String toDeleteTemplateReportTempleFile(){
		String templateReportId = template.getId();
		templateReportService.deleteTemplateReportTempleFile(templateReportId);
		return NONE;
	}
	
	//*****************************************************************************************************************//
	
	/**
	 * 报表查询
	 * @return
	 * @throws ParseException 
	 */
	public String openReportSearch() throws ParseException{
		selectWayList.put("1", "年查询");
		selectWayList.put("2", "月查询");
		selectWayList.put("3", "自定义");
		Map<String,Object> param = new HashMap<String, Object>();
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
	private void dateOperator(Map<String,Object> param) throws ParseException {
		
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
		companyId = companyId!=null ?companyId:""; 
		if(companyId!=null){
			param.put("deptId", companyId);
		}
		factoryId = factoryId!=null ?factoryId:""; 
		if(factoryId!=null){
			param.put("deptId", factoryId);
		}
		workshopId = workshopId!=null ?workshopId:""; 
		if(workshopId!=null){
			param.put("deptId", workshopId);
		}
	}
}



