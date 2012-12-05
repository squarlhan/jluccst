package com.boan.crm.sms.thread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.boan.crm.sms.model.SMSInfo;


public class Controler {
	
	public String name="";
	
	//用Set保证信息部重复
	public Set<SMSInfo> infoSet = new HashSet();
	
	public SmsProducer smsProducer = new SmsProducer(this);
	
	public SmsSender smsSender = new SmsSender(this);
	
	ExecutorService exec = Executors.newCachedThreadPool();

	public Controler(String name) {
		this.name=name;
		exec.execute(smsProducer);
		exec.execute(smsSender);
	}

	public static void main(String[] args) {
		new Controler("A");
		new Controler("B");
	}
}