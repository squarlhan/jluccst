package com.boan.crm.sms.thread;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.boan.crm.sms.model.SMSInfo;
import com.boan.crm.sms.service.ISMSInfoService;


public class SmsProducer implements Runnable {
	
	//短信数据库服务接口
	@Autowired
	@Qualifier("SMSService")
	private ISMSInfoService manager;
	
	private Controler controler;
	
	List<String[]> listArray = new ArrayList(); // 存储数据库查询得到的结果集
	
	// List<BoxsendingModel> listModel = new ArrayList(); //存储model

	public SmsProducer(Controler c) {
		// 注册到控制器controler
		controler = c;
	} 

	int num = 23; // 需要查询的表结构的列数目

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// 锁住短信生产者本身，如果还有没有处理好的信息，则一直等待，直到唤醒
				synchronized (this) {
					if (controler.infoSet.size() > 0)
						wait();
				}

				// 锁住发送机，生产者生产完毕后将其唤醒
				synchronized (controler.smsSender) {
					
					//调用数据库接口查询待发短信
					Calendar beginTime = Calendar.getInstance();
					beginTime.add(Calendar.MINUTE, -5);//往前五分钟
					Calendar endTime = Calendar.getInstance();
					List<SMSInfo> list = manager.findSMSInfoByTime(beginTime,endTime,"");
					for(SMSInfo obj : list){
						controler.infoSet.add(obj);
					}
					
					// 如果生产了短消息，唤醒发送机进行发送
					if (controler.infoSet.size() > 0) {
						controler.smsSender.notifyAll();
					}
				}

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}