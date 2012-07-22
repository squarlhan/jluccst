package com.boan.crm.sms.action.task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.boan.crm.sms.model.SMSInfo;
import com.boan.crm.sms.service.ISMSInfoService;
import com.boan.crm.sms.service.ISMSManageService;

public class SchedulerTask {
	
	@Autowired
	@Qualifier("SMSInfoService")
	private ISMSInfoService smsInfoService;
	
	@Autowired
	@Qualifier("SMSManageService")
	private ISMSManageService smsManageService;
	/**
	 * 发送短信
	 */
	public void sendMessage() {
		
		Calendar endTime = Calendar.getInstance();
		endTime.add(Calendar.HOUR_OF_DAY, 1);//查询从现在到一小时以后的记录
		List<SMS> list = new ArrayList<SMS>();
		SMS obj = new SMS();
		obj.serialNo="3SDK-ECQ-0130-LGWLM";
		obj.password = "17725";
		obj.key = "key-177259";
		obj.organId = "00001";
		list.add(obj );
		for(SMS sms : list ){
			//初始化短信发送接口
			smsManageService.initClient(obj.serialNo,obj.password,obj.key);
			
			List<SMSInfo> infoList = smsInfoService.findSMSInfoByTime(Calendar.getInstance(), endTime ,obj.organId);
			for(SMSInfo info : infoList){
				//格式为：年年年年月月日日时时分分秒秒，例如2009 08 01 12 30 30 表示2009年8月1日12点30分30秒
				StringBuffer time  = new StringBuffer();
				time.append(info.getSendTime().get(Calendar.YEAR));
				time.append(info.getSendTime().get(Calendar.MONTH)<10 ? "0"+(info.getSendTime().get(Calendar.MONTH)+1) : info.getSendTime().get(Calendar.MONTH)+1);
				time.append(info.getSendTime().get(Calendar.DATE )<10 ? "0"+info.getSendTime().get(Calendar.DATE ) : info.getSendTime().get(Calendar.DATE ));
				time.append(info.getSendTime().get(Calendar.HOUR_OF_DAY)<10 ? "0"+info.getSendTime().get(Calendar.HOUR_OF_DAY ) : info.getSendTime().get(Calendar.HOUR_OF_DAY ));
				time.append(info.getSendTime().get(Calendar.MINUTE)<10 ? "0"+info.getSendTime().get(Calendar.MINUTE ) : info.getSendTime().get(Calendar.MINUTE ));
				time.append(info.getSendTime().get(Calendar.SECOND)<10 ? "0"+info.getSendTime().get(Calendar.SECOND ) : info.getSendTime().get(Calendar.SECOND ));
				int flag = smsManageService.sendScheduledSMS(info.getInfo(), time.toString() , info.getPhone());
				if(flag==0){
					smsInfoService.updateSMSInfoState(info.getId(), 2);
				}
				System.out.println("预期发送时间[" + time.toString() +"]");
			}
		}
		
		System.out.println(" 执行定时短信服务间隔[" + (new Date()).toLocaleString() +"]ms");
	}
}
class SMS{
	protected String serialNo;
	protected String password;
	protected String key;
	protected String organId;
}
