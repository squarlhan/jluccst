/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.rees.device.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.model.PointInfo;
import com.boan.rees.device.service.IDeviceInfoService;
import com.boan.rees.device.service.IPointInfoService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;
/**
 * 设备管理Action
 * @author JiangMD
 * @version 1.0.0
 */
@Controller("deviceInfoAction")
@Scope("prototype")
public class DeviceInfoAction extends BaseActionSupport{

	private static final long serialVersionUID = 1L;

	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("deviceInfoService")
	private IDeviceInfoService service;
	
	/**
	 * 分页列表
	 */
	private Pagination<DeviceInfo> pagination = new Pagination<DeviceInfo>();
	
	/**
	 * 定义一个设备数组，用于排序功能使用
	 */
	private List<DeviceInfo> deviceInfoList = new ArrayList<DeviceInfo>();
	
	/**
	 * 页面对象
	 */
	private DeviceInfo device;
	
	/**
	 * 页面所选行的id
	 */
	private String[] ids;
	
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
	
	/**
	 * 设备检测点数组
	 */
	private List<PointInfo> pointInfoList;
	
	/**
	 * 设备检测点Id
	 */
	private String id;
	
	/**
	 * 设备检测点X坐标
	 */
	private String positionX;
	
	/**
	 * 设备检测点Y坐标
	 */
	private String positionY;
	
	/**
	 * 设备检测点
	 */
	private String controlPointName;
	
	/**
	 * 操作提示
	 */
	private String message;
	/**
	 * 监测点接口类
	 */
	@Autowired
	@Qualifier("pointInfoService")
	private IPointInfoService pointInfoService;
	
	//***************************属性get set 方法**********************************************	
	
	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public DeviceInfo getDevice() {
		return device;
	}

	public void setDevice(DeviceInfo device) {
		this.device = device;
	}
	public Pagination<DeviceInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<DeviceInfo> pagination) {
		this.pagination = pagination;
	}
	
	public List<DeviceInfo> getDeviceInfoList() {
		return deviceInfoList;
	}

	public void setDeviceInfoList(List<DeviceInfo> deviceInfoList) {
		this.deviceInfoList = deviceInfoList;
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

	public String getDownloadFileName() {
		return downloadFileName;
	}
	
	public List<PointInfo> getPointInfoList() {
		return pointInfoList;
	}

	public void setPointInfoList(List<PointInfo> pointInfoList) {
		this.pointInfoList = pointInfoList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getControlPointName() {
		return controlPointName;
	}

	public void setControlPointName(String controlPointName) {
		this.controlPointName = controlPointName;
	}

	public String getPositionX() {
		return positionX;
	}

	public void setPositionX(String positionX) {
		this.positionX = positionX;
	}

	public String getPositionY() {
		return positionY;
	}

	public void setPositionY(String positionY) {
		this.positionY = positionY;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//*************************************************************************************
	/**
	 * 初始化设备类别下拉框数据
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public Properties getDeviceTypeMap() throws FileNotFoundException, IOException {
		Properties property = new Properties();
		//读取配置文件
		InputStream in = getClass().getResourceAsStream("/divece_type_config.properties");
		property.load(in);
		return property;
	}
	
	/**
	 * 分页显示设备列表
	 * @return
	 */
	public String openDevice(){
		pagination = service.findDeviceInfoForPage(new HashMap(), pagination);
		return this.SUCCESS;
	}

    /**
	 * 添加新设备
	 * @return
	 */
	public String toAddDevice(){
		try {
			saveImageToDevice(device);
			device.setDeptId(sessionFactoryId);
			device.setGroupId(sessionWorkshopId);
			//保存设备对象
			service.save(device);
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
	private void saveImageToDevice(DeviceInfo device) {
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
					device.setFilePath(filePath.replace("/", File.separator));
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
	public void validateToAddDevice() {
		if(files == null){
            addFieldError("files", "请选择上传的文件");
        }
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
	 * 下载设备图片
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public String downloadDeviceImage() throws UnsupportedEncodingException, FileNotFoundException{
		ServletContext servletContext = ServletActionContext.getServletContext();
		//获取服务器上图片的保存路径
		String fileAllName = servletContext.getRealPath(device.getFilePath());
		File file = new File(fileAllName);
		if(file.exists()){
			inputStream = new FileInputStream(file);
			//获取图片后缀名
			String suffix    = fileAllName.substring(fileAllName.lastIndexOf('.'));
			//已设备名称加编号的形式构建下载时的文件名
			downloadFileName =device.getDeviceName()+"_"+device.getDeviceNum() + suffix;
			//处理中文乱码
			downloadFileName = new String(downloadFileName.getBytes(), "ISO8859-1");   
		}
		return SUCCESS;
	}
	
	/**
	 * 删除设备图片
	 * @return
	 */
	public String toDeleteDeviceImage(){
		String deviceId = device.getId();
		service.deleteDeviceImage(deviceId);
		return NONE;
	}
	
	/**
	 * 打开添加新设备页
	 * @return
	 */
	
	public String openAddDevice (){
		return SUCCESS;
	}

	/**
	 * 删除数据
	 * @return
	 */
	public String deleteDevice(){
		service.deleteDeviceInfo(ids);
		return NONE;
	}
	
	/**
	 * 为修改页面做准备
	 * @return
	 */
	public String openModifyDevice(){
		String id = device.getId();
		device = service.get(id);
		return SUCCESS;
	}
	
	/**
	 * 修改设备信息
	 * @return
	 */
	public String toModifyDevice(){
		try {
			saveImageToDevice(device);
			device.setDeptId(sessionFactoryId);
			device.setGroupId(sessionWorkshopId);
			service.update(device);
			message="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}

	/**
	 * 打开排序页面
	 * @return
	 */
	public String openSortDevice(){
		deviceInfoList = service.findAllDeviceInfo();
		return SUCCESS;
	}
	
	/**
	 * 执行排序
	 * @return
	 */
	public String toSortDevice(){
		service.sortDeviceInfo(ids);
		return SUCCESS;
	}
	
	/**
	 * 打开设备添加监测点页面
	 * @return
	 */
	public String openAddPoint(){
		String deviceId = device.getId();
		pointInfoList =  pointInfoService.findPointInfosByDeviceId(deviceId);
		if(pointInfoList.size()==0){
			pointInfoList.add(new PointInfo());
		}
		System.out.println(message);
		return SUCCESS;
	}
	
	/**
	 * 添加设备监测点
	 * @return
	 */
	public String toAddPoint(){
		try {
			String deviceId = device.getId();
			String[] pointIds = id.split(",");
			String[] pointNames = controlPointName.split(",");
			String[] positionXs = positionX.split(",");
			String[] positionYs = positionY.split(",");
			for(int i=0;i<pointNames.length;i++){
				PointInfo point = new PointInfo();
				String pointId = pointIds[i].trim();
				if(!pointId.equals("")){
					point.setId(pointId);
				}
				String x = positionXs[i].trim();
				String y = positionYs[i].trim();
				if(!x.equals("")){
					point.setPositionX(Integer.parseInt(x));
				}
				if(!y.equals("")){
					point.setPositionY(Integer.parseInt(y));
				}
				point.setDeviceId(deviceId);
				point.setControlPointName(pointNames[i].trim());
				pointInfoService.save(point);
			}
			message = "保存成功！";
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "保存失败！";
			return INPUT;
		}
		return SUCCESS;
		
	}
	
	/**
	 * 删除设备监控点
	 * @return
	 */
	public String toDeletePoint(){
		pointInfoService.deletePointInfo(id);
		return NONE;
	}
}
