package com.boan.crm.sms.service.impl;

import org.springframework.stereotype.Service;

import com.boan.crm.sms.action.emay.EmaySDKClient;
import com.boan.crm.sms.service.ISMSManageService;
/**
 * 短信管理服务接口实现
 * @author Administrator
 *
 */
@Service("SMSManageService")
public class SMSManageServiceImpl implements ISMSManageService {
	
	/**
	 * 亿美短信客户端
	 */
	private EmaySDKClient client;
	
	/**
	 * 初始化短信客户端信息
	 * @param serialNo 序列号
	 * @param password 密码
	 * @param key key值
	 */
	public void initClient(String serialNo,String password,String key){
		client = new EmaySDKClient(serialNo,password,key);
	}

	/**
	 * 激活账号
	 * @param password 密码
	 * @return 返回值代码
	 */
	public int activateAccount(String password){
		return client.registEx(password);
	}
	
	/**
	 * 注销账号
	 * @param serialNo 序列号
	 * @param key      激活key
	 * @return 返回值代码
	 */
	public int logoutAccount(String serialNo ,String key ){
		return client.logout();
	}
	
	/**
	 * 发送短信
	 * @param smsContent 短信内容
	 * @param mobiles 电话号码数组
	 * @return 返回值代码
	 */
	public int sendSMS(String smsContent , String... mobiles){
		return client.sendSMS(smsContent,mobiles);
	}
	
	/**
	 * 发送定时短信
	 * @param smsContent 短信内容
	 * @param sendTime 定时短信发送时间，格式为：年年年年月月日日时时分分秒秒，例如2009 08 01 12 30 30 表示2009年8月1日12点30分30秒该条短信会发送到用户手机
	 * @param mobiles 电话号码数组
	 * @return 返回值代码
	 */
	public int sendScheduledSMS(String smsContent ,String sendTime, String... mobiles){
		return client.sendScheduledSMS(smsContent, sendTime, mobiles);
	}
	
	/**
	 * 查询余额
	 * @return 剩余金额
	 */
	public String getBalance(){
		return client.getBalance();
	}
	
	/**
	 * 获取当前短信客户端
	 * @param serialNo 序列号
	 * @param password 密码
	 * @param key key值
	 * @return 客户端对象，需要强转
	 */
	public EmaySDKClient getCurrentClient(){
		return client;
	}
	
	/**
	 * 获取短信客户端
	 * @param serialNo 序列号
	 * @param password 密码
	 * @param key key值
	 * @return 客户端对象，需要强转
	 */
	public EmaySDKClient getClient(String serialNo,String password,String key){
		EmaySDKClient client = new EmaySDKClient(serialNo,password,key);
		return client;
	}
	
	/**
	 * 关闭当前短信客户端连接
	 */
	public void closeClientSocket(){
		try {
			client.getClient().closeRemoteSocket();
			client.getClient().closeSocketConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
