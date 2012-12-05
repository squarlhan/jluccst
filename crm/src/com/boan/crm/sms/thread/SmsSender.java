package com.boan.crm.sms.thread;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import com.boan.crm.sms.model.SMSInfo;


public class SmsSender implements Runnable {
	
	private Controler controler;
	
	SMSInfo sms_info;
	
	String mobile = null;
	
	String text = null;

	public SmsSender(Controler c) {
		controler = c;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// 锁住发送机自己，如果没有消息，则一直等待。直到被唤醒
				synchronized (this) {
					while (controler.infoSet.size() < 1) {
						wait();
					}
				}
				// 锁住生产者，开始发送信息
				synchronized (controler.smsProducer) {
					String info = controler.name+ "有" + controler.infoSet.size() + "条消息等待发送";
					System.out.println(info);

					Iterator<SMSInfo> iter = controler.infoSet.iterator();
					int n=0;
					while(iter.hasNext()){
						sms_info = iter.next();
						System.out.println(sms_info.getPhone()+"发送短信:"+sms_info.getInfo());
						if (controler.infoSet.size() > 0) {
							controler.infoSet.remove(sms_info);
						}
						//发送20条休息3秒钟
						if(n%20==0){
							System.out.println("===================");
							TimeUnit.MILLISECONDS.sleep(3000);
						}
						n=n++;
					}
					controler.smsProducer.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}