/*
 * @(#)Diagnosis.java 1.1 2012-4-24
 */

package com.boan.rees.timer.task;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.service.IDeviceInfoService;


/**
 * 故障诊断服务类
 * @author Luojx
 * @version 1.0.0
 */
public class Diagnosis extends QuartzJobBean
{
	@Autowired
	@Qualifier("deviceInfoService")
	private IDeviceInfoService deviceInfoService;
	protected void executeInternal( JobExecutionContext context ) throws JobExecutionException
	{
		
	    System.out.println("执行一次！");
	    //1.取出所有设备
	    //执行具体操作
	    List<DeviceInfo> listDeviceInfo = deviceInfoService.findAllDeviceInfo();
	    for(int i=0;i<listDeviceInfo.size();i++)
	    {
	    	System.out.println("======"+listDeviceInfo.get( i ).getDeviceName());
	    	//2.根据设备取录入的最后一条监测点数据
	    	
	    	//3.根据监测点数判断是否超标，如果超标返回故障现象list
	    	//3.1如果没超标，存日志
	    	
	    	//3.2回写监测数据

	    	//4.如果超标，送推理机进行推理，返回原因和建议list,存入故障日志表
	    	//
	    }
	}
	public void work()
	{
		System.out.println("执行一次！");
		//执行具体操作
	    List<DeviceInfo> listDeviceInfo = deviceInfoService.findAllDeviceInfo();
	    for(int i=0;i<listDeviceInfo.size();i++)
	    {
	    	System.out.println("======"+listDeviceInfo.get( i ).getDeviceName());
	    }
	    
	}

}

