package com.boan.rees.device.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.model.PointInfo;
import com.boan.rees.device.service.IDeviceInfoService;
import com.boan.rees.device.service.IPointInfoService;
import com.boan.rees.utils.action.BaseActionSupport;

/**
 * 设备监测点控制类
 * 
 * @author leon
 * @version 1.0.0
 */
@Controller("pointInfoAction")
@Scope("prototype")
public class PointInfoAction extends BaseActionSupport {
	private static final long serialVersionUID = -6672679240989229829L;

	@Autowired
	@Qualifier("pointInfoService")
	// 监测点接口类
	private IPointInfoService pointInfoService;
	
	@Resource
	//用于调用数据库相关操作
	private IDeviceInfoService deviceInfoService;

	// 监测点对象列表
	private List<PointInfo> pointInfoList;

	private String deviceId;

	// 监测点ID
	private String pointId;

	// 监测点X轴坐标
	private String strPositionX;

	// 监测点Y轴坐标
	private String strPositionY;

	// json字符串
	private String datas;

	private String result;
	
	//设备对象
	private DeviceInfo deviceInfo = null;

	/**
	 * 根据设备ID，获得设备监测点数据
	 * 
	 * @return
	 */
	public String pointInfoListByDeviceId() {
		//获得设备信息
		if(StringUtils.trimToNull(deviceId)!=null)
			deviceInfo = deviceInfoService.get(deviceId);
		else
			deviceInfo = new DeviceInfo();
		if(StringUtils.trimToNull(deviceId)!=null)
			pointInfoList = pointInfoService.findPointInfosByDeviceId(deviceId);
		else
			pointInfoList = new ArrayList<PointInfo>();
		return SUCCESS;
	}

	/**
	 * 添加新数据
	 * 
	 * @return
	 */
	public String positionSet() {
		if (datas != null && datas != "") {
			String[] tempDatas = datas.split(",");
			if (tempDatas.length > 0) {
				String[] tempDatas1 = null;
				PointInfo pi = null;
				for (int i = 0; i < tempDatas.length; i++) {
					tempDatas1 = tempDatas[i].split("\\|");
					if (tempDatas1.length > 0) {
						if (StringUtils.trimToNull(tempDatas1[1]) != null)
							pi = pointInfoService.get(tempDatas1[1]);
						else {
							pi = new PointInfo();
							pi.setDeviceId(tempDatas1[0]);
						}
						if (StringUtils.trimToNull(tempDatas1[2]) != null)
							pi.setPositionX(Integer.parseInt(tempDatas1[2]));
						else
							pi.setPositionX(0);
						if (StringUtils.trimToNull(tempDatas1[3]) != null)
							pi.setPositionY(Integer.parseInt(tempDatas1[3]));
						else
							pi.setPositionY(0);
						pointInfoService.save(pi);
					}
				}
			}
		}
		result = "OK";
		return SUCCESS;
	}
	
	/**
	 * 删除监测点信息
	 * @return
	 */
	public String deletePoint(){
		if(StringUtils.trimToNull(pointId)!=null){
			pointInfoService.deletePointInfo(pointId);
		}
		return SUCCESS;
	}

	// ************************************************************************************
	public List<PointInfo> getPointInfoList() {
		return pointInfoList;
	}

	public void setPointInfoList(List<PointInfo> pointInfoList) {
		this.pointInfoList = pointInfoList;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getPointId() {
		return pointId;
	}

	public void setPointId(String pointId) {
		this.pointId = pointId;
	}

	public String getStrPositionX() {
		return strPositionX;
	}

	public void setStrPositionX(String strPositionX) {
		this.strPositionX = strPositionX;
	}

	public String getStrPositionY() {
		return strPositionY;
	}

	public void setStrPositionY(String strPositionY) {
		this.strPositionY = strPositionY;
	}

	public String getDatas() {
		return datas;
	}

	public void setDatas(String datas) {
		this.datas = datas;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	// ************************************************************************************
}
