package com.boan.crm.sms.action.emay;

import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import cn.emay.sdk.client.api.Client;
import cn.emay.sdk.client.api.MO;

/**
 * 亿美短信平台客户端接口
 * @author Administrator
 *
 */
public class EmaySDKClient {

	public String serialNo;//软件序列号,请通过亿美销售人员获取
	
	private String password;       //密码
	
	public String key ;            //序列号首次激活时自己设定
	
	private Client client=null;    //客户端实例
	
	/**
	 * 获取客户端实例
	 * @param softwareSerialNo
	 * @param key
	 * @return
	 */
	public  Client getClient(String softwareSerialNo,String key){
//		if(client==null){
			try {
				client=new Client(softwareSerialNo,key);
			} catch (Exception e) {
				e.printStackTrace();
			}
//		}
		return client;
	}
	
	/**
	 * 初始化短信客户端实体
	 * @param serialNo 序列号
	 * @param password 密码
	 * @param key 激活码
	 * @throws Exception
	 */
	public EmaySDKClient( String serialNo ,String password ,String key ){
		this.serialNo = serialNo;
		this.password = password;
		this.key= key;
		getClient(serialNo,key);
	}

	/**
	 * 软件注销
	 * 1、软件注销后像发送短信、接受上行短信接口都无法使用
	 * 2、软件可以重新注册、注册完成后软件序列号的金额保持注销前的状态
	 */
	public int logout() {
		int a =0;
		try {
			a = client.logout();
			System.out.println("testLogout:" + a);
			return a;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	/**
	 * 软件序列号注册、或则说是激活、软件序列号首次使用必须激活
	 * registEx(String serialpass)
	 * 1、serialpass 软件序列号密码、密码长度为6位的数字字符串、软件序列号和密码请通过亿美销售人员获取
	 */
	public int registEx(String password ) {
		int i =client.registEx(password);
		System.out.println("testTegistEx:" + i);
		return i;
	}
	
	/**
	 * 发送短信、可以发送定时和即时短信
	 * sendSMS(String[] mobiles,String smsContent, String addSerial, int smsPriority)
	 * 1、mobiles 手机数组长度不能超过1000
	 * 2、smsContent 最多500个汉字或1000个纯英文、请客户不要自行拆分短信内容以免造成混乱、亿美短信平台会根据实际通道自动拆分、计费以实际拆分条数为准、亿美推荐短信长度70字以内 
	 * 3、addSerial 附加码(长度小于15的字符串) 用户可通过附加码自定义短信类别,或添加自定义主叫号码( 联系亿美索取主叫号码列表)
	 * 4、优先级范围1~5，数值越高优先级越高(相对于同一序列号)
	 * 5、其它短信发送请参考使用手册自己尝试使用
	 */
	public int sendSMS(String smsContent , String... mobiles) {
		int i= 0;
		try {
			i= client.sendSMS(mobiles,smsContent,"",5);//带扩展码
			System.out.println("testSendSMS====="+i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 发送定时短信
	 * sendScheduledSMSEx(String[] mobiles, String smsContent,String sendTime,String srcCharset)
	 * 1、mobiles 手机数组长度不能超过1000
	 * 2、smsContent 最多500个汉字或1000个纯英文、请客户不要自行拆分短信内容以免造成混乱、亿美短信平台会根据实际通道自动拆分、计费以实际拆分条数为准、亿美推荐短信长度70字以内
	 * 3、sendTime 定时短信发送时间 定时时间格式为：年年年年月月日日时时分分秒秒，例如2009 08 01 12 30 30 表示2009年8月1日12点30分30秒该条短信会发送到用户手机 
	 * 4、srcCharset 字符编码，默认为"GBK"
	 * 5、其它定时短信发送请参考使用手册自己尝试使用
	 */
	public int sendScheduledSMS(String smsContent ,String sendTime, String... mobiles) {
		int i= 0;
		try {
			i= client.sendScheduledSMSEx(mobiles, smsContent,sendTime,"GBK");
			System.out.println("testsSendScheduledSMS====="+i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
	/**
	 * 软件序列号充值、如果软件序列号金额不足、那么可以调用该方法给序列号充值
	 * chargeUp(String cardNo, String cardPass)
	 * 1、cardNo 充值卡卡号
	 * 2、cardPass 充值卡密码
	 * 3、充值卡卡号和密码请联系亿美销售人员获得
	 */
	public void chargeUp(String cardNo,String cardPass) {
		try {
			int a = client.chargeUp( cardNo , cardPass);
			System.out.println("testChargeUp:" + a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 企业详细信息注册
	 * registDetailInfo(String eName, String linkMan, String phoneNum,String mobile, String email, String fax, String address,String postcode)
	 * 1、eName 企业名称(最多60字节)
	 * 2、linkMan 联系人姓名(最多20字节)
	 * 3、phoneNum 联系电话(最多20字节)
	 * 4、mobile 联系手机(最多15字节)
	 * 5、email 电子邮件(最多60字节)
	 * 6、fax 联系传真(最多20字节)
	 * 7、address 公司地址(最多60字节)
	 * 8、postcode 邮政编码(最多6字节)
	 * 9、以上参数信息都必须填写、每个参数都不能为空
	 */
	public void registDetailInfo(String eName,String linkMan,String phoneNum,String mobile,String email,String fax,String address , String postcode ) {
		try {
			int a = client.registDetailInfo(eName, linkMan, phoneNum,mobile,email,fax, address, postcode);
			System.out.println("testRegistDetailInfo:" + a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改软件序列号密码、注意修改软件序列号密码以后不需要重新注册(激活)
	 * serialPwdUpd(String serialPwd, String serialPwdNew)
	 * 1、serialPwd 旧密码
	 * 2、serialPwdNew 新密码、长度为6位的数字字符串
	 */
	public void serialPwdUpd(String serialPwd, String serialPwdNew) {
		try {
			int a = client.serialPwdUpd(serialPwd, serialPwdNew);
			System.out.println("testSerialPwdUpd:" + a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 序列号的余额
	 * 0.1代表一条
	 */
	public String getBalance() {
		String a =null;
		try {
			a = client.getBalance();
			System.out.println("testGetBalance:" + a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	/**
	 * 发送一条短信所需的费用
	 */
	public void getEachFee() {
		try {
			double a = client.getEachFee();
			System.out.println("testGetEachFee:" + a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 1、从EUCP平台接收手机用户上行的短信
	 * 2、返回值list中的每个元素为一个Mo对象
	 * 3、Mo具体数据结构参考使用手册
	 */
	public void getMO() {
		try {
			List<MO> list = client.getMO();
			if (list != null) {
				System.out.println("testGetMO1size:" + list.size());

				for(MO mo : list) {
					System.out.println("短信内容:" + mo.getSmsContent());
					System.out.println("通道号:" + mo.getChannelnumber());
					System.out.println("手机号:" + mo.getMobileNumber());
					System.out.println("附加码:" + mo.getAddSerialRev());
					System.out.println("附加码:" + mo.getAddSerial());
					// 上行短信务必要保存,加入业务逻辑代码,如：保存数据库，写文件等等
				}
			} else {
				System.out.println("NO HAVE MO");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		EmaySDKClient client = new EmaySDKClient("3SDK-ECQ-0130-LGWLM","17725","key-177259");
		//注销序列号
		client.logout();
		//获取指定序列号的实例并设置key为key-177259
		client.client = client.getClient("3SDK-ECQ-0130-LGWLM","key-177259");
		//激活实例
		client.registEx("177259");
		//查询余额
		client.getBalance();
		//发送信息
		client.sendSMS("测试ss", "13514318022");
	}
}
