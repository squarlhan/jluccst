package com.boan.crm.sms.action.task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.boan.crm.backstagemanage.model.Company;
import com.boan.crm.backstagemanage.service.ICompanyService;
import com.boan.crm.customerassessment.service.IAutoAssessmentSettingService;
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
	
	@Autowired
	@Qualifier("companyService")
	private ICompanyService companyService;
	
	@Autowired
	@Qualifier("autoAssessmentSettingService")
	private IAutoAssessmentSettingService autoAssessmentSettingService;
	
	
	
	/**
	 * 发送短信
	 */
	public void sendMessage() {
		
		Calendar endTime = Calendar.getInstance();
		endTime.add(Calendar.HOUR_OF_DAY, 1);//查询从现在到一小时以后的记录
		
		
		 List<Company> companyList = companyService.queryAllCompanys();
		
		for(Company obj : companyList ){
			String serialNo =obj.getSmsSN();
			String password = obj.getSmsPassword();
			String key = obj.getSmsKey();
			String companyId =obj.getId();
			if(serialNo!=null && password!=null && key!=null && !serialNo.trim().equals("") && !password.trim().equals("") && !key.trim().equals("")){
				
				
				List<SMSInfo> infoList = smsInfoService.findSMSInfoByTime(Calendar.getInstance(), endTime , companyId );
				if(infoList != null && infoList.size() > 0)
				{
					//初始化短信发送接口
					smsManageService.initClient( serialNo,password,key);
					
					for(SMSInfo info : infoList){
						//格式为：年年年年月月日日时时分分秒秒，例如2009 08 01 12 30 30 表示2009年8月1日12点30分30秒
						StringBuffer time  = new StringBuffer();
						time.append(info.getSendTime().get(Calendar.YEAR));
						time.append(info.getSendTime().get(Calendar.MONTH)<10 ? "0"+(info.getSendTime().get(Calendar.MONTH)+1) : info.getSendTime().get(Calendar.MONTH));
						time.append(info.getSendTime().get(Calendar.DATE )<10 ? "0"+info.getSendTime().get(Calendar.DATE ) : info.getSendTime().get(Calendar.DATE ));
						time.append(info.getSendTime().get(Calendar.HOUR_OF_DAY)<10 ? "0"+info.getSendTime().get(Calendar.HOUR_OF_DAY ) : info.getSendTime().get(Calendar.HOUR_OF_DAY ));
						time.append(info.getSendTime().get(Calendar.MINUTE)<10 ? "0"+info.getSendTime().get(Calendar.MINUTE ) : info.getSendTime().get(Calendar.MINUTE ));
						time.append(info.getSendTime().get(Calendar.SECOND)<10 ? "0"+info.getSendTime().get(Calendar.SECOND ) : info.getSendTime().get(Calendar.SECOND ));
						int flag = smsManageService.sendScheduledSMS(info.getInfo(), time.toString() , info.getPhone());
						//关闭当前短信客户端连接
						smsManageService.closeClientSocket();
						if(flag==0){
							smsInfoService.updateSMSInfoState(info.getId(), 2);
						}
						System.out.println("预期发送时间[" + time.toString() +"]");
					}
				}
				infoList = null;
			}
			
			//调用自动评估接口
			autoAssessmentSettingService.saveAutoAssessment(companyId, Calendar.getInstance());
			
		}
		companyList = null;
		System.out.println(" 执行定时短信服务间隔[" + (new Date()).toLocaleString() +"]ms");
	}
}
class SMS{
	protected String serialNo;
	protected String password;
	protected String key;
	protected String organId;
}
