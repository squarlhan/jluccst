package com.boan.crm.sms.action;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.backstagemanage.model.Company;
import com.boan.crm.backstagemanage.service.ICompanyService;
import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.model.ProvinceInfo;
import com.boan.crm.datadictionary.service.IAreaService;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.sms.model.SMSCustomerInfo;
import com.boan.crm.sms.model.SMSInfo;
import com.boan.crm.sms.service.ISMSCustomerInfoService;
import com.boan.crm.sms.service.ISMSInfoService;
import com.boan.crm.sms.service.ISMSManageService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.calendar.LunarCalendarUtils;
import com.boan.crm.utils.page.Pagination;
import com.boan.crm.utils.pinyin.PinYin4J;

/**
 * 短信管理
 * @author Administrator
 *
 */
@Controller("SMSAtion")
@Scope("prototype")
public class SMSAtion extends BaseActionSupport{

	private static final long serialVersionUID = -1280440304213417041L;

	@Autowired
	@Qualifier("SMSCustomerInfoService")
	private ISMSCustomerInfoService bookerService;
	
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
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("dataDictionaryService")
	private IDataDictionaryService dataDictionaryService = null;
	@Autowired
	@Qualifier("areaService")
	private IAreaService areaService = null;
	
	/**
	 * 返回给页面的可供选择的短信接受者json字符串
	 */
	private String customersJsonStr;
	/**
	 * 返回给页面的可供选择的短信接受者类型json字符串
	 */
	private String customersTypeJsonStr;
	/**
	 * 返回给页面的可供选择的短信接受者数量json字符串
	 */
	private String customersCountJsonStr;
	
	/**
	 * 短信余额
	 */
	private String SMSBalance="0.0";
	
	/**
	 * 前台选择的人员类型ID
	 */
	private String typeId;
	/**
	 * ajax选择人员控件分页基数
	 */
	private String pageSize;
	/**
	 * ajax选择人员控件分页当前页
	 */
	private String p;
	/**
	 * 人员选择中模糊查询条件
	 */
	private String name;
	
	/**
	 * 接收页面ajax提供的人员Id
	 */
	private String personIds;
	
	/**
	 * 人员数组
	 */
	private List<SMSCustomerInfo> customerInfoList;
	
	/**
	 * 信息头类型
	 */
	private String headType;
	
	/**
	 * 信息头缀
	 */
	private String headSuffix;
	
	/**
	 * 信息头问候
	 */
	private String headHello;
	
	/**
	 * 信息内容
	 */
	private String infoContent;
	
	/**
	 * 信息尾
	 */
	private String footContent;
	
	/**
	 * 发送类型（IMMEDIATELY：立即发送；SCHEDULED：定时发送；BIRTHDAY：按生日发送）
	 */
	private String sendType;
	
	/**
	 * 短信接收者id
	 */
	private String[] selectedIds;
	
	/**
	 * 发送日期
	 */
	private String sendDay;
	
	/**
	 * 发送时间
	 */
	private String sendTime;
	
	/**
	 * 显示分页
	 */
	private Pagination<SMSInfo> pagination = new Pagination<SMSInfo>();
	
	/**
	 * 添加人员时，是否只添加客户（no：不是  yes：是）
	 */
	private String onlycustomer = "no";
	
	/**
	 * 提前发送时间
	 */
	private String beforeTime;
	
	/**
	 * 短信信息Id
	 */
	private String SMSInfoId;
	
	
	/**
	 * 查询条件-接收人
	 */
	private String queryPersonName;
	
	/**
	 * 查询条件-公司名
	 */
	private String queryCompany;
	/**
	 * 查询条件-手机号
	 */
	private String queryPhone;
	/**
	 * 查询条件-开始时间
	 */
	private String queryBegin;
	/**
	 * 查询条件-结束时间
	 */
	private String queryEnd;
	/**
	 * 查询条件-类型
	 */
	private String queryType;
	/**
	 * 查询条件-状态
	 */
	private String queryState;
	
	/**
	 * 查询条件-省
	 */
	private String queryProvince;
	/**
	 * 查询条件-市
	 */
	private String querycCity;
	/**
	 * 查询条件-区
	 */
	private String queryArea;
	/**
	 * 查询条件-业务进展
	 */
	private String queryCategoryId;
	/**
	 * 查询条件-客户分类
	 */
	private String queryProgress;
	
	private List<DataDictionary> listCategory = null;
	private List<DataDictionary> listProgress = null;
	private List<ProvinceInfo> listProvince = null;
	
	/**
	 * 查询供选择接收短信的人员信息
	 * @return
	 */
	public String loadCustomers(){
		try {
			pageSize=(pageSize==null || pageSize.trim().equals("")) ? "0" : pageSize;
			p=(p==null || p.trim().equals("")) ? "1" : p;
			name=name==null ? "" : name;
			//name = new String(name.getBytes("iso8859-1"));
			//name = java.net.URLDecoder.decode(name,"UTF-8");
			Map<String,Object> params = new HashMap<String,Object>();
			//销售员id
			UserSession userSession = this.getSession();
			params.put("salesmanId", userSession.getUserId());
			if(!name.equals("")){
				params.put("nameSpell", PinYin4J.makeStringByStringSet(PinYin4J.getPinyin(name)));
			}
			if(typeId!=null && !typeId.equals("") && !typeId.equals("-1")){
				params.put("categoryId", typeId);
			}
			if(this.sessionCompanyId!=null && !this.sessionCompanyId.equals("")){
				params.put("organId", this.sessionCompanyId);
			}
			customersTypeJsonStr="[{name:'客户',id:'1'},{name:'工作人员',id:'2'}]";
			if(onlycustomer.equals("yes")){
				params.put("categoryId", "1");
				customersTypeJsonStr="[{name:'客户',id:'1'}]";
			}
			List<SMSCustomerInfo> list = bookerService.findSMSCustomerInfoForPage(params,(Integer.parseInt(p)-1 )*Integer.parseInt(pageSize),Integer.parseInt(pageSize));
			customersJsonStr= "[";
			for(SMSCustomerInfo person : list){
				//1为客户 2为销售人员
				if(person.getCategoryId().equals("1")){
					customersJsonStr=customersJsonStr+"{fUid:'"+person.getId()+"',friendUserName:'"+person.getName()+"',friendHeadPic:'../js/friendsuggest/images/man.png'},";
				}else{
					customersJsonStr=customersJsonStr+"{fUid:'"+person.getId()+"',friendUserName:'"+person.getName()+"',friendHeadPic:'../js/friendsuggest/images/woman.png'},";
				}
			}
			if(customersJsonStr.length()>1){
				customersJsonStr = customersJsonStr.substring(0, customersJsonStr.lastIndexOf(","));
			}
			customersJsonStr=customersJsonStr+ "]";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 查询供选择接收短信的人员数量
	 * @return
	 */
	public String loadCustomersCount(){
		try {
			pageSize=(pageSize==null || pageSize.trim().equals("")) ? "0" : pageSize;
			p=(p==null || p.trim().equals("")) ? "1" : p;
			name=name==null ? "" : name;
			name = new String(name.getBytes("iso8859-1"));
			
			Map<String,Object> params = new HashMap<String,Object>();
			//销售员id
			UserSession userSession = this.getSession();
			params.put("salesmanId", userSession.getUserId());
			if(!name.equals("")){
				params.put("nameSpell", PinYin4J.makeStringByStringSet(PinYin4J.getPinyin(name)));
			}
			if(typeId!=null && !typeId.equals("") && !typeId.equals("-1")){
				params.put("categoryId", typeId);
			}
			if(onlycustomer.equals("yes")){
				params.put("categoryId", "1");
			}
			if(this.sessionCompanyId!=null && !this.sessionCompanyId.equals("")){
				params.put("organId", this.sessionCompanyId);
			}
			customersCountJsonStr=""+bookerService.findSMSCustomerInfoCountForPage(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 打开选择窗口
	 * @return
	 */
	public String openSelectWindow(){
		//客户分类： 传0
		listCategory = dataDictionaryService.findDataDictionaryByType(sessionCompanyId, 0);
		//业务进展：传1
		listProgress = dataDictionaryService.findDataDictionaryByType(sessionCompanyId, 7);
		//省份信息
		listProvince = areaService.findAllProvinceInfo();
		return this.SUCCESS;
	}
	/**
	 * 查询客户信息，返回信息数组给ajax请求页面
	 * @return
	 */
	public String loadCustomerInfoForAjax(){
		//String str = queryType+"="+queryProvince+"="+querycCity+"="+queryArea+"="+queryCategoryId+"="+queryProgress;
		if(personIds!=null){
			if(personIds.equals("all")){
				customerInfoList = bookerService.findAllSMSCustomerInfo(this.sessionCompanyId,this.sessionUserId,queryProvince,querycCity,queryArea,queryCategoryId,queryProgress);
			}else if (personIds.equals("customer")){
				customerInfoList = bookerService.findAllSMSCustomerInfoByType(this.sessionCompanyId,this.sessionUserId,1,queryProvince,querycCity,queryArea,queryCategoryId,queryProgress);
			}else if (personIds.equals("seller")){
				customerInfoList = bookerService.findAllSMSCustomerInfoByType(this.sessionCompanyId,this.sessionUserId,2,"","","","","");
			}
			else{
				String[] ids = personIds.split(",");
				customerInfoList = bookerService.findSMSCustomerInfoByIds(ids);
			}
		}
		return "customerInfoList";
	}
	/**
	 * 打开发送短信页面
	 * @return
	 */
	public String openSendInfo(){
//		SMSCustomerInfo info = new SMSCustomerInfo();
//		info.setName("AA");
//		info.setCategoryId("1");//1:客户 2 :销售员
//		info.setOrganId(sessionDeptId);
//		info.setPhone("13514318022");
//		info.setOrganId(sessionDeptId);
//		info.setCategoryId("0");
//		info.setSalesmanId(sessionUserId);
//		bookerService.saveSMSCustomerInfo(info );
		
		//需要保证表没有外键，删除外键才能执行deleteSMSCustomerInfoFoCustomer方法
		//ALTER TABLE sms_info DROP FOREIGN KEY FK2A40AFF46D4294D0;  
		//bookerService.deleteSMSCustomerInfoFoCustomer("1111111");
		UserSession userSession = this.getSession();
		String organId = userSession.getCompanyId();
		footContent="["+userSession.getCompanyName()+"]";
		//初始化短信发送接口
		if(organId!=null){
			Company  company = companyService.get(organId);
			String serialNo =company.getSmsSN();
			String password = company.getSmsPassword();
			String key = company.getSmsKey();
			if(serialNo!=null && password!=null && key!=null && !serialNo.trim().equals("") && !password.trim().equals("") && !key.trim().equals("")){
				//初始化短信发送接口
//				smsManageService.initClient( serialNo,password,key);
//				SMSBalance = smsManageService.getBalance();
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 发送信息
	 * @return
	 */
	public String sendInfo(){
		UserSession userSession = this.getSession();
		String organId = userSession.getCompanyId();
		//初始化短信发送接口
		Company  company = companyService.get(organId);
		String serialNo =company.getSmsSN();
		String password = company.getSmsPassword();
		String key = company.getSmsKey();
		if(serialNo!=null && password!=null && key!=null && !serialNo.trim().equals("") && !password.trim().equals("") && !key.trim().equals("")){
			//初始化短信发送接口
			smsManageService.initClient( serialNo,password,key);
			//存放短信的完整信息
			StringBuffer allContent = null;
			if(selectedIds.length>0){
				List<SMSCustomerInfo> personList = bookerService.findSMSCustomerInfoByIds(selectedIds);
				for(SMSCustomerInfo obj : personList){
					//根据id查询人，根据人名截取姓氏
					String lastName = obj.getName().substring(0,1);
					//根据id查询人，根据获取昵称
					String nickname = obj.getNickname();
					allContent = new StringBuffer();
					if(headType!=null && !headType.equals("")){
						if(headType.equals("姓氏")){
							allContent.append(" "+lastName);
						}
						if(headType.equals("姓名")){
							allContent.append(" "+obj.getName());
						}
						if(headType.equals("昵称")){
							allContent.append(" "+nickname);
						}
					}
					//拼接发送内容体
					if(headSuffix!=null && !headSuffix.equals("")){
						allContent.append(headSuffix);
					}
					if(headHello!=null && !headHello.equals("")){
						allContent.append(headHello+" ");
					}
					if(infoContent!=null && !infoContent.equals("")){
						allContent.append(infoContent+"   ");
					}
					if(footContent!=null && !footContent.equals("")){
						allContent.append(footContent);
					}
					
					//创建短信实体对象并赋值
					SMSInfo info = new SMSInfo();
					info.setCustomerInfo(obj);
					info.setOrganId(obj.getOrganId());
					info.setPersonName(obj.getName());
					info.setPersonCompany(obj.getUnit());
					info.setPhone(obj.getPhone());
					info.setInfo(allContent.toString());
					Calendar time = Calendar.getInstance();
					if(sendType.equals("SCHEDULED")){
						if(sendDay!=null && sendTime!=null && !sendDay.equals("") && !sendTime.equals("")){
							String[] dayArray = sendDay.split("-");
							String[] timeArray = sendTime.split(":");
							if(dayArray.length>0 && timeArray.length>0){
								time.set(Calendar.YEAR, Integer.parseInt(dayArray[0]));
								time.set(Calendar.MONTH, Integer.parseInt(dayArray[1])-1);
								time.set(Calendar.DATE, Integer.parseInt(dayArray[2]));
								time.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
								time.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
							}
							//定时发送
							info.setIsImmediately(1);
							info.setState(1);
							info.setSendTime(time);
							info.setOrganId(organId);
							
							smsInfoService.saveSMSInfo(info);
						}
					}else if(sendType.equals("BIRTHDAY")){
						//如果发送日期和发送时间不为空，表示是定时发送
						if(sendTime!=null && !sendTime.equals("")){
							Calendar birthday = Calendar.getInstance();
							String[] timeArray = sendTime.split(":");
							if(obj.getBirthday()!=null){
								if(obj.getIsLunarCalender()==0){//阴历
									Date temp = LunarCalendarUtils.getGregorianCalendar(birthday.get(Calendar.YEAR)+"-"+(obj.getBirthday().get(Calendar.MONTH)+1)+"-"+ obj.getBirthday().get(Calendar.DATE));
									time.setTime(temp);
									System.out.println(LunarCalendarUtils.toLongString(time));
								}else{ //阳历
									birthday = obj.getBirthday();
									time.set(Calendar.YEAR, birthday.get(Calendar.YEAR));
									time.set(Calendar.MONTH,  birthday.get(Calendar.MONTH));
									time.set(Calendar.DATE, birthday.get(Calendar.DATE));
								}
								if( timeArray.length>0){
									time.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
									time.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
								}
								//定时发送
								info.setIsImmediately(1);
								info.setState(1);
								info.setSendTime(time);
								info.setOrganId(organId);
								smsInfoService.saveSMSInfo(info);
							}
						}
					}else{
						//立即发送
						info.setIsImmediately(0);
						info.setSendTime(time);
						//调用短信发送接口
						int flag = smsManageService.sendSMS(info.getInfo(), info.getPhone());
//						int flag = 0;//smsManageService.sendSMS(info.getInfo(), info.getPhone());
						//保存记录到数据库
						if(flag==0){
							info.setOrganId(organId);
							info.setState(2);
							smsInfoService.saveSMSInfo(info);
						}else{
							info.setOrganId(organId);
							info.setState(3);
							smsInfoService.saveSMSInfo(info);
						}
					}
				}
			}
			SMSBalance = smsManageService.getBalance();
		}
		return SUCCESS;
	}
	
	/**
	 * 查询余额
	 * @return
	 */
	public String queryBalance(){
		UserSession userSession = this.getSession();
		String organId = userSession.getCompanyId();
		//初始化短信发送接口
		Company  company = companyService.get(organId);
		String serialNo =company.getSmsSN();
		String password = company.getSmsPassword();
		String key = company.getSmsKey();
		if(serialNo!=null && password!=null && key!=null && !serialNo.trim().equals("") && !password.trim().equals("") && !key.trim().equals("")){
			//初始化短信发送接口
			smsManageService.initClient( serialNo,password,key);
			SMSBalance = smsManageService.getBalance();
		}
		return SUCCESS;
	}

	/**
	 * 打开发送短信页面
	 * @return
	 */
	public String openSendInfoBeforeTime(){
		UserSession userSession = this.getSession();
		String organId = userSession.getCompanyId();
		//初始化短信发送接口
		if(organId!=null){
			Company  company = companyService.get(organId);
			String serialNo =company.getSmsSN();
			String password = company.getSmsPassword();
			String key = company.getSmsKey();
			if(serialNo!=null && password!=null && key!=null && !serialNo.trim().equals("") && !password.trim().equals("") && !key.trim().equals("")){
				//初始化短信发送接口
//				smsManageService.initClient( serialNo,password,key);
//				SMSBalance = smsManageService.getBalance();
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 提前发送天数发送
	 * @return
	 */
	public String sendInfoBeforeTime(){
		UserSession userSession = this.getSession();
		String organId = userSession.getCompanyId();

		//初始化短信发送接口
		Company  company = companyService.get(organId);
		String serialNo =company.getSmsSN();
		String password = company.getSmsPassword();
		String key = company.getSmsKey();
		if(serialNo!=null && password!=null && key!=null && !serialNo.trim().equals("") && !password.trim().equals("") && !key.trim().equals("")){
			//初始化短信发送接口
			smsManageService.initClient( serialNo,password,key);
			if(selectedIds.length>0){
				StringBuffer allContent = null;
				List<SMSCustomerInfo> personList = bookerService.findSMSCustomerInfoByIds(selectedIds);
				for(SMSCustomerInfo obj : personList){
					
					SMSInfo info = new SMSInfo();
					
					String currentUserName =userSession.getUserCName();      //当前用户的名字
					String currentUserPhone = userSession.getUserPhone();      //当前用户的手机号
					String currentUserCompany =userSession.getCompanyName();      //当前用户的单位
					
					info.setOrganId(organId);
					info.setPersonName(currentUserName);
					info.setPersonCompany(currentUserCompany);
					
					Calendar time = Calendar.getInstance();
					Calendar birthday = Calendar.getInstance();
					
					String[] timeArray = sendTime.split(":");
					if(obj.getBirthday()!=null){
						if(obj.getIsLunarCalender()==0){//阴历
							Date temp = LunarCalendarUtils.getGregorianCalendar(birthday.get(Calendar.YEAR)+"-"+(obj.getBirthday().get(Calendar.MONTH)+1)+"-"+ obj.getBirthday().get(Calendar.DATE));
							time.setTime(temp);
							System.out.println(LunarCalendarUtils.toLongString(time));
						}else{ //阳历
							birthday = obj.getBirthday();
							time.set(Calendar.YEAR, birthday.get(Calendar.YEAR));
							time.set(Calendar.MONTH,  birthday.get(Calendar.MONTH));
							time.set(Calendar.DATE, birthday.get(Calendar.DATE));
						}
						if( timeArray.length>0){
							time.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
							time.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
						}
					
						info.setPhone(currentUserPhone);
						allContent= new StringBuffer();
						allContent.append(currentUserName + ", 您的客户"+obj.getName());
						if(obj.getNickname()!=null && !obj.getNickname().trim().equals("")){
							allContent.append("("+obj.getNickname()+")");
						}
						
						allContent.append("将于"+time.get(Calendar.YEAR)+"-"+(time.get(Calendar.MONTH)+1)+"-"+time.get(Calendar.DATE));
						allContent.append("过生日，记得送去祝福！");
						info.setInfo(allContent.toString());
						
						if(beforeTime.equals("ONE_DAY")){
							time.add(Calendar.DATE, -1);
						}
						if(beforeTime.equals("TWO_DAY")){
							time.add(Calendar.DATE, -2);
						}
						if(beforeTime.equals("ONT_WEEK")){
							time.add(Calendar.DATE,-7);
						}
						if(beforeTime.equals("FIFTEEN_DAY")){
							time.add(Calendar.DATE, -15);
						}
						
						//定时发送
						info.setIsImmediately(1);
						info.setState(1);
						info.setSendTime(time);
						smsInfoService.saveSMSInfo(info);
					}
				}
				SMSBalance = smsManageService.getBalance();
			}
			
		}
		return SUCCESS;
	}

	/**
	 * 重发短信
	 * @return
	 */
	public String reSendSMSInfo(){
		UserSession userSession = this.getSession();
		String organId = userSession.getCompanyId();
		//初始化短信发送接口
		Company  company = companyService.get(organId);
		String serialNo =company.getSmsSN();
		String password = company.getSmsPassword();
		String key = company.getSmsKey();
		if(serialNo!=null && password!=null && key!=null && !serialNo.trim().equals("") && !password.trim().equals("") && !key.trim().equals("")){
			//初始化短信发送接口
			smsManageService.initClient( serialNo,password,key);
		}
		if(SMSInfoId!=null && !SMSInfoId.equals("")){
			SMSInfo info = smsInfoService.getSMSInfo(SMSInfoId);
			//调用短信发送接口
//			int flag =0;// smsManageService.sendSMS(info.getInfo(), info.getPhone());
			int flag = smsManageService.sendSMS(info.getInfo(), info.getPhone());
			//保存记录到数据库
			if(flag==0){
				info.setId(null);
				info.setState(2);
				info.setSendTime(Calendar.getInstance());
				smsInfoService.saveSMSInfo(info);
				//发送成功
			}else{
				//发送失败
				info.setId(null);
				info.setState(3);
				info.setSendTime(Calendar.getInstance());
				smsInfoService.saveSMSInfo(info);
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 删除短信
	 * @return
	 */
	public String deleteSMSInfo(){
		if(SMSInfoId!=null && !SMSInfoId.equals("")){
			smsInfoService.deleteSMSInfo(SMSInfoId);
		}
		return SUCCESS;
	}
	/**
	 * 查询发送记录
	 * @return
	 */
	public String loadSendedRecord(){
		UserSession userSession = this.getSession();
		String organId = userSession.getCompanyId();
		Map<String,String> params = new HashMap<String,String>();
		params.put("organId", organId);
		
		if(queryPersonName!=null && !queryPersonName.trim().equals("")){
			params.put("queryPersonName", queryPersonName);
		}
		
		if(queryCompany!=null && !queryCompany.trim().equals("")){
			params.put("personCompany", queryCompany);
		}
		if(queryPhone!=null && !queryPhone.trim().equals("")){
			params.put("phone", queryPhone);
		}
		if(queryBegin!=null && !queryBegin.trim().equals("")){
			params.put("sendBeginTime", queryBegin);
		}
		if(queryEnd!=null && !queryEnd.trim().equals("")){
			params.put("sendEndTime", queryEnd);
		}
		if(queryType!=null && !queryType.trim().equals("-1")){
			params.put("queryType", queryType);
		}
		if(queryState!=null && !queryState.trim().equals("-1")){
			params.put("queryState", queryState);
		}
		pagination =  smsInfoService.findSMSInfoForPage(params,pagination);
		return SUCCESS;
	}
	
	public String getCustomersJsonStr() {
		return customersJsonStr;
	}

	public void setCustomersJsonStr(String customersJsonStr) {
		this.customersJsonStr = customersJsonStr;
	}

	public String getCustomersTypeJsonStr() {
		return customersTypeJsonStr;
	}

	public void setCustomersTypeJsonStr(String customersTypeJsonStr) {
		this.customersTypeJsonStr = customersTypeJsonStr;
	}

	public String getCustomersCountJsonStr() {
		return customersCountJsonStr;
	}

	public void setCustomersCountJsonStr(String customersCountJsonStr) {
		this.customersCountJsonStr = customersCountJsonStr;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonIds() {
		return personIds;
	}
	public void setPersonIds(String personIds) {
		this.personIds = personIds;
	}
	public List<SMSCustomerInfo> getCustomerInfoList() {
		return customerInfoList;
	}
	public void setCustomerInfoList(List<SMSCustomerInfo> customerInfoList) {
		this.customerInfoList = customerInfoList;
	}

	public String getFootContent() {
		return footContent;
	}

	public void setFootContent(String footContent) {
		this.footContent = footContent;
	}

	public String getHeadHello() {
		return headHello;
	}

	public void setHeadHello(String headHello) {
		this.headHello = headHello;
	}

	public String getSendDay() {
		return sendDay;
	}

	public void setSendDay(String sendDay) {
		this.sendDay = sendDay;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getHeadType() {
		return headType;
	}

	public void setHeadType(String headType) {
		this.headType = headType;
	}

	public String getHeadSuffix() {
		return headSuffix;
	}

	public void setHeadSuffix(String headSuffix) {
		this.headSuffix = headSuffix;
	}

	public String[] getSelectedIds() {
		return selectedIds;
	}

	public void setSelectedIds(String[] selectedIds) {
		this.selectedIds = selectedIds;
	}

	public String getInfoContent() {
		return infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	
	public Pagination<SMSInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<SMSInfo> pagination) {
		this.pagination = pagination;
	}

	public String getOnlycustomer() {
		return onlycustomer;
	}

	public String getBeforeTime() {
		return beforeTime;
	}

	public void setBeforeTime(String beforeTime) {
		this.beforeTime = beforeTime;
	}

	public void setOnlycustomer(String onlycustomer) {
		this.onlycustomer = onlycustomer;
	}

	public String getSMSInfoId() {
		return SMSInfoId;
	}

	public void setSMSInfoId(String sMSInfoId) {
		SMSInfoId = sMSInfoId;
	}

	public String getQueryCompany() {
		return queryCompany;
	}

	public void setQueryCompany(String queryCompany) {
		this.queryCompany = queryCompany;
	}

	public String getQueryPhone() {
		return queryPhone;
	}

	public void setQueryPhone(String queryPhone) {
		this.queryPhone = queryPhone;
	}

	public String getQueryBegin() {
		return queryBegin;
	}

	public void setQueryBegin(String queryBegin) {
		this.queryBegin = queryBegin;
	}

	public String getQueryEnd() {
		return queryEnd;
	}

	public void setQueryEnd(String queryEnd) {
		this.queryEnd = queryEnd;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getQueryState() {
		return queryState;
	}

	public String getQueryPersonName() {
		return queryPersonName;
	}

	public void setQueryPersonName(String queryPersonName) {
		this.queryPersonName = queryPersonName;
	}

	public void setQueryState(String queryState) {
		this.queryState = queryState;
	}

	public String getSMSBalance() {
		return SMSBalance;
	}

	public void setSMSBalance(String sMSBalance) {
		SMSBalance = sMSBalance;
	}

	/**
	 * @return the listCategory
	 */
	public List<DataDictionary> getListCategory() {
		return listCategory;
	}

	/**
	 * @param listCategory the listCategory to set
	 */
	public void setListCategory(List<DataDictionary> listCategory) {
		this.listCategory = listCategory;
	}

	/**
	 * @return the listProgress
	 */
	public List<DataDictionary> getListProgress() {
		return listProgress;
	}

	/**
	 * @param listProgress the listProgress to set
	 */
	public void setListProgress(List<DataDictionary> listProgress) {
		this.listProgress = listProgress;
	}

	/**
	 * @return the listProvince
	 */
	public List<ProvinceInfo> getListProvince() {
		return listProvince;
	}

	/**
	 * @param listProvince the listProvince to set
	 */
	public void setListProvince(List<ProvinceInfo> listProvince) {
		this.listProvince = listProvince;
	}

	/**
	 * @return the queryProvince
	 */
	public String getQueryProvince() {
		return queryProvince;
	}

	/**
	 * @param queryProvince the queryProvince to set
	 */
	public void setQueryProvince(String queryProvince) {
		this.queryProvince = queryProvince;
	}

	/**
	 * @return the querycCity
	 */
	public String getQuerycCity() {
		return querycCity;
	}

	/**
	 * @param querycCity the querycCity to set
	 */
	public void setQuerycCity(String querycCity) {
		this.querycCity = querycCity;
	}

	/**
	 * @return the queryArea
	 */
	public String getQueryArea() {
		return queryArea;
	}

	/**
	 * @param queryArea the queryArea to set
	 */
	public void setQueryArea(String queryArea) {
		this.queryArea = queryArea;
	}

	/**
	 * @return the queryCategoryId
	 */
	public String getQueryCategoryId() {
		return queryCategoryId;
	}

	/**
	 * @param queryCategoryId the queryCategoryId to set
	 */
	public void setQueryCategoryId(String queryCategoryId) {
		this.queryCategoryId = queryCategoryId;
	}

	/**
	 * @return the queryProgress
	 */
	public String getQueryProgress() {
		return queryProgress;
	}

	/**
	 * @param queryProgress the queryProgress to set
	 */
	public void setQueryProgress(String queryProgress) {
		this.queryProgress = queryProgress;
	}
}
