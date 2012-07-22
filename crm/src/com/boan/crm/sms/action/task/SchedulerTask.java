package com.boan.crm.sms.action.task;

import java.util.Date;

public class SchedulerTask {
	
	/**
	 * 发送短信
	 */
	public void sendMessage() {
		System.out.println(" 执行定时短信服务间隔[" + (new Date()).toLocaleString() +"]ms");
	}
}
