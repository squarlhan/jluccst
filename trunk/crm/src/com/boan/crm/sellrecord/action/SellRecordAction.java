package com.boan.crm.sellrecord.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.model.BusinessProgressKey;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.goods.model.GoodsInfoBase;
import com.boan.crm.goods.model.GoodsType;
import com.boan.crm.goods.service.IGoodsInfoBaseService;
import com.boan.crm.goods.service.IGoodsTypeService;
import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.groupmanage.service.IPopedomService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.sellrecord.model.GoodsInfo;
import com.boan.crm.sellrecord.model.SellRecord;
import com.boan.crm.sellrecord.model.SellRecordForPhone;
import com.boan.crm.sellrecord.service.IGoodsInfoService;
import com.boan.crm.sellrecord.service.ISellRecordService;
import com.boan.crm.servicemanage.model.MemberInfo;
import com.boan.crm.servicemanage.model.MemberType;
import com.boan.crm.servicemanage.model.PointInfo;
import com.boan.crm.servicemanage.service.IMemberInfoService;
import com.boan.crm.servicemanage.service.IMemberTypeService;
import com.boan.crm.servicemanage.service.IPointInfoService;
import com.boan.crm.sms.model.SMSInfo;
import com.boan.crm.sms.service.ISMSInfoService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.calendar.CurrentDateTime;
import com.boan.crm.utils.page.Pagination;

@Controller("sellRecordAction")
@Scope("prototype")
public class SellRecordAction extends BaseActionSupport {

	private static final long serialVersionUID = -1200734348985284253L;

	/**
	 * 客户信息
	 */
	private CustomerInfo customer;

	@Autowired
	@Qualifier("customerInfoService")
	// 客户状态接口类
	private ICustomerInfoService customerInfoService;
	@Resource
	// 积分接口类
	private IPointInfoService pointInfoService;
	@Resource
	// 会员接口类
	private IMemberInfoService memberInfoService;
	@Resource
	// 会员类别接口类
	private IMemberTypeService memberTypeService;
	
	
	@Autowired
	@Qualifier("deptService")
	private IDeptmentService deptService = null;
	
	@Autowired
	@Qualifier("popedomService")
	private IPopedomService popedomService = null;
	
	
	@Resource
	// 商品类别接口类
	private IGoodsTypeService goodsTypeService;
	
	// 商品类别对象
	private GoodsType goodsType = null;
	
	private List<GoodsType> goodsTypes = null;
	
	@Resource
	// 商品类别接口类
	private IGoodsInfoBaseService goodsInfoBaseService;
	
	private GoodsInfoBase goodsInfoBase = null;
	
	private List<GoodsInfoBase> goodsInfoBaseList=null;

	private List<Deptment> deptList = null;

	private String companyId = null;

	private String companyName = null;
	
	private String deptId=null;

	private String who=null;
	
	private String userId=null;
	/**
	 * 商品明细
	 */
	private List<String> detials = new ArrayList<String>();
	/**
	 * 商品名称
	 */
	private List<DataDictionary> dataDictionarys =  null;

	/**
	 * 销售记录信息
	 */
	private SellRecord sellRecord;
	
	/**
	 * 销售记录短信通知对象
	 */
	private SMSInfo smsInfo = new SMSInfo();
	private String smsSendDay;
	private String smsSendTime;
	
	private String queryAmountBegin="";
	
	private String queryAmountEnd="";
	
	private String queryIsArrearage="";
	
	@Autowired
	@Qualifier("SMSInfoService")
	private ISMSInfoService smsInfoService;
	
	@Autowired
	@Qualifier("sellRecordService")
	private ISellRecordService sellRecordService;

	@Autowired
	@Qualifier("goodsInfoService")
	private IGoodsInfoService goodsInfoService;

	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;

	/**
	 * 销售员所有的客户
	 */
	private List<CustomerInfo> customerInfos = new ArrayList<CustomerInfo>();

	/**
	 * 员工数组
	 */
	private List<User> userList = null;

	/**
	 * 提示信息
	 */
	private String message;

	/**
	 * 显示分页
	 */
	private Pagination<SellRecord> pagination = new Pagination<SellRecord>();

	private String[] ids;
	private String customerId;
	// --------------查询条件-------------------------//
	private String queryCustomerName;

	private String queryLinkman;

	private String querySalesman;

	private String queryReturnedMoney;

	private String queryBargainTimeBegin;

	private String queryBargainTimeEnd;

	private String goodsTypeId;

	private String goodsInfoBaseId;

	//销售员Id
	private String  salesmanId;

	// --------------查询条件-------------------------//

	
	/**
	 * 给领导使用
	 * @return
	 * @throws Exception
	 */
	public String toTabPage() throws Exception {
		return SUCCESS;
	}
	/**
	 * 给领导使用
	 * @return
	 * @throws Exception
	 */
	public String openSellRecordList() throws Exception {
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		userList = userService.queryUserList(sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		Map<String, String> params = new HashMap<String, String>();

		params.put("companyId", sessionCompanyId);
		if (queryCustomerName != null && !queryCustomerName.trim().equals("")) {
			params.put("queryCustomerName", queryCustomerName);
		}
		if (querySalesman != null && !querySalesman.trim().equals("")) {
			params.put("querySalesman", querySalesman);
		}
		if (queryBargainTimeBegin != null && !queryBargainTimeBegin.trim().equals("")) {
			params.put("queryBargainTimeBegin", queryBargainTimeBegin);
		}
		if (queryBargainTimeBegin != null && !queryBargainTimeBegin.trim().equals("")) {
			params.put("queryBargainTimeEnd", queryBargainTimeEnd);
		}
		if (deptId != null && !deptId.trim().equals("")) {
			params.put("deptId", deptId);
		}
		if (userId != null && !userId.trim().equals("")) {
			params.put("salesmanId", userId);
		}
		//销售总额相关条件
		if (queryIsArrearage != null && !queryIsArrearage.equals("")) {
			params.put("queryIsArrearage", queryIsArrearage);
		}
		if (queryAmountBegin != null && queryAmountBegin.length() > 0) {
			params.put("queryAmountBegin", queryAmountBegin);
		}
		if (queryAmountEnd != null && queryAmountEnd.length() > 0) {
			params.put("queryAmountEnd", queryAmountEnd);
		}
		pagination = sellRecordService.findSellRecordForPage(params, pagination);
		return SUCCESS;
	}
	
	/**
	 * 给销售员使用
	 * @return
	 * @throws Exception
	 */
	public String openSellRecordListForSeller() throws Exception {
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		userList = userService.queryUserList(sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		Map<String, String> params = new HashMap<String, String>();
		params.put("companyId", sessionCompanyId);
		if (queryCustomerName != null && !queryCustomerName.trim().equals("")) {
			params.put("queryCustomerName", queryCustomerName);
		}
		if (querySalesman != null && !querySalesman.trim().equals("")) {
			params.put("querySalesman", querySalesman);
		}
		if (queryBargainTimeBegin != null && !queryBargainTimeBegin.trim().equals("")) {
			params.put("queryBargainTimeBegin", queryBargainTimeBegin);
		}
		if (queryBargainTimeBegin != null && !queryBargainTimeBegin.trim().equals("")) {
			params.put("queryBargainTimeEnd", queryBargainTimeEnd);
		}
		//销售总额相关条件
		if (queryIsArrearage != null && !queryIsArrearage.equals("")) {
			params.put("queryIsArrearage", queryIsArrearage);
		}
		if (queryAmountBegin != null && queryAmountBegin.length() > 0) {
			params.put("queryAmountBegin", queryAmountBegin);
		}
		if (queryAmountEnd != null && queryAmountEnd.length() > 0) {
			params.put("queryAmountEnd", queryAmountEnd);
		}
		UserSession userSession = this.getSession();
		params.put("salesmanId", userSession.getUserId());
		pagination = sellRecordService.findSellRecordForPage(params, pagination);
		return SUCCESS;
	}
	/**
	 * 给客户信息用
	 * @return
	 * @throws Exception
	 */
	public String openSellRecordListForOneCustomer() throws Exception {
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		userList = userService.queryUserList(sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		Map<String, String> params = new HashMap<String, String>();
		params.put("companyId", sessionCompanyId);
		
		if (customerId != null && !customerId.trim().equals("")) {
			String[] array = customerId.split(",");
			params.put("customerId", array[0]);
		}
		if (queryCustomerName != null && !queryCustomerName.trim().equals("")) {
			params.put("queryCustomerName", queryCustomerName);
		}
		if (querySalesman != null && !querySalesman.trim().equals("")) {
			params.put("querySalesman", querySalesman);
		}
		if (queryBargainTimeBegin != null && !queryBargainTimeBegin.trim().equals("")) {
			params.put("queryBargainTimeBegin", queryBargainTimeBegin);
		}
		if (queryBargainTimeBegin != null && !queryBargainTimeBegin.trim().equals("")) {
			params.put("queryBargainTimeEnd", queryBargainTimeEnd);
		}
		UserSession userSession = this.getSession();
		params.put("salesmanId", userSession.getUserId());
		pagination = sellRecordService.findSellRecordForPage(params, pagination);
		return SUCCESS;
	}

	public String openSellRecordListForCustomer() throws Exception {
//		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
//		//userList = userService.queryUserList(sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
//		Map<String, String> params = new HashMap<String, String>();
//		if (customerId != null) {
//			customerId = customerId.split(",")[0];
//			if (customerId != null && !customerId.trim().equals("")) {
//				params.put("customerId", customerId);
//			}
//			if (queryBargainTimeBegin != null && !queryBargainTimeBegin.trim().equals("")) {
//				params.put("queryBargainTimeBegin", queryBargainTimeBegin);
//			}
//			if (queryBargainTimeBegin != null && !queryBargainTimeBegin.trim().equals("")) {
//				params.put("queryBargainTimeEnd", queryBargainTimeEnd);
//			}
//		}
//		pagination = sellRecordService.findSellRecordForPage(params, pagination);
		return SUCCESS;
	}
	
	public String openSellRecordTabForMyCustomer() throws Exception {
		return SUCCESS;
	}

	public String openSellRecordListForMyCustomer() throws Exception {
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		userList = userService.queryUserList(sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		Map<String, String> params = new HashMap<String, String>();
		params.put("companyId", sessionCompanyId);
		
		
		if (customerId != null && !customerId.trim().equals("")) {
			String[] strArry = customerId.split(",");
			customerId= strArry[0];
			params.put("customerId", customerId);
		}
		if (queryCustomerName != null && !queryCustomerName.trim().equals("")) {
			params.put("queryCustomerName", queryCustomerName);
		}
		if (querySalesman != null && !querySalesman.trim().equals("")) {
			params.put("querySalesman", querySalesman);
		}
		if (queryBargainTimeBegin != null && !queryBargainTimeBegin.trim().equals("")) {
			params.put("queryBargainTimeBegin", queryBargainTimeBegin);
		}
		if (queryBargainTimeBegin != null && !queryBargainTimeBegin.trim().equals("")) {
			params.put("queryBargainTimeEnd", queryBargainTimeEnd);
		}
		UserSession userSession = this.getSession();
		params.put("salesmanId", userSession.getUserId());
		pagination = sellRecordService.findSellRecordForPage(params, pagination);
		return SUCCESS;
	}
	
	public String openAddSellRecordForMyCustomer() {
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); // 日期格式化格式
		String date = format.format(rightNow.getTime()); // 取得当前时间，并格式化成相应格式

		UserSession userSession = this.getSession();
		String orderID = sellRecordService.getSellRecordorderID(date, userSession.getCompanyId());
		int number = 1;
		if (orderID != null && orderID.length() == 13) {
			number = Integer.parseInt(orderID.substring(8));
			number = number + 1;
		}
		customerInfos = customerInfoService.findAllCustomerInfoBySalesmanId(sessionUserId); //查本公司业务员所管辖的客户
		if(customerInfos==null || customerInfos.size()==0){
			customerInfos = customerInfoService.findAllCustomerInfoByCompanyId(sessionCompanyId);//本公司的所有客户
		}
		sellRecord = new SellRecord();
		sellRecord.setCustomerId(customerId);
		sellRecord.setCompanyId(userSession.getCompanyId());
		// String.format("%05d", number) 将流水号格式化为 5位长度返回
		String serialNo = date + String.format("%05d", number);
		sellRecord.setOrderID(serialNo);
		sellRecord.setDeptId(userSession.getDeptId());
		
		//短信通知号码
		smsInfo.setPhone(this.sessionUserPhone);
		smsSendDay=CurrentDateTime.getCurrentDate();
		smsSendTime="09:00";
		return SUCCESS;
	}
	
	public String openModifySellRecordForMyCustomer() {
		customerInfos = customerInfoService.findAllCustomerInfoBySalesmanId(sessionUserId); //查本公司业务员所管辖的客户
		if(customerInfos==null || customerInfos.size()==0){
			customerInfos = customerInfoService.findAllCustomerInfoByCompanyId(sessionCompanyId);//本公司的所有客户
		}
		sellRecord = sellRecordService.getSellRecordById(sellRecord.getId());
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		//获取短信通知对象
		smsInfo= smsInfoService.getSMSInfoBySellRecordId(sellRecord.getId());
		if(smsInfo!=null){
			smsSendDay=CurrentDateTime.getCurrentDate(smsInfo.getSendTime());
			smsSendTime=CurrentDateTime.getCurrentTime(smsInfo.getSendTime());
		}
		return SUCCESS;
	}
	
	public String addSellRecordForMyCustomer() {
		return addSellRecordForForOneCustomer();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String openSellRecordListForCustomerView() throws Exception {
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		//userList = userService.queryUserList(sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		Map<String, String> params = new HashMap<String, String>();
		if (customerId != null) {
			customerId = customerId.split(",")[0];
			if (customerId != null && !customerId.trim().equals("")) {
				params.put("customerId", customerId);
			}
			if (queryBargainTimeBegin != null && !queryBargainTimeBegin.trim().equals("")) {
				params.put("queryBargainTimeBegin", queryBargainTimeBegin);
			}
			if (queryBargainTimeBegin != null && !queryBargainTimeBegin.trim().equals("")) {
				params.put("queryBargainTimeEnd", queryBargainTimeEnd);
			}
		}
		pagination = sellRecordService.findSellRecordForPage(params, pagination);
		return SUCCESS;
	}
	
	public String openSellRecordListForOneCustomerView() throws Exception {
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		//userList = userService.queryUserList(sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		Map<String, String> params = new HashMap<String, String>();
		if (customerId != null) {
			customerId = customerId.split(",")[0];
			if (customerId != null && !customerId.trim().equals("")) {
				params.put("customerId", customerId);
			}
			if (queryBargainTimeBegin != null && !queryBargainTimeBegin.trim().equals("")) {
				params.put("queryBargainTimeBegin", queryBargainTimeBegin);
			}
			if (queryBargainTimeBegin != null && !queryBargainTimeBegin.trim().equals("")) {
				params.put("queryBargainTimeEnd", queryBargainTimeEnd);
			}
		}
		pagination = sellRecordService.findSellRecordForPage(params, pagination);
		return SUCCESS;
	}

	public String openViewSellRecord() throws Exception {
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		customerInfos = customerInfoService.findAllCustomerInfoBySalesmanId(sessionUserId); //查本公司业务员所管辖的客户
		if(customerInfos==null || customerInfos.size()==0){
			customerInfos = customerInfoService.findAllCustomerInfoByCompanyId(sessionCompanyId);//本公司的所有客户
		}
		sellRecord = sellRecordService.getSellRecordById(sellRecord.getId());
		return SUCCESS;
	}
	
	public String openAddSellRecordForSeller() {

		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); // 日期格式化格式
		String date = format.format(rightNow.getTime()); // 取得当前时间，并格式化成相应格式

		UserSession userSession = this.getSession();
		String orderID = sellRecordService.getSellRecordorderID(date, userSession.getCompanyId());
		int number = 1;
		if (orderID != null && orderID.length() == 13) {
			number = Integer.parseInt(orderID.substring(8));
			number = number + 1;
		}
		customerInfos = customerInfoService.findAllCustomerInfoBySalesmanId(sessionUserId); //查本公司业务员所管辖的客户
		if(customerInfos==null || customerInfos.size()==0){
			customerInfos = customerInfoService.findAllCustomerInfoByCompanyId(sessionCompanyId);//本公司的所有客户
		}
		sellRecord = new SellRecord();
		sellRecord.setCompanyId(userSession.getCompanyId());
		// String.format("%05d", number) 将流水号格式化为 5位长度返回
		String serialNo = date + String.format("%05d", number);
		sellRecord.setOrderID(serialNo);
		sellRecord.setDeptId(userSession.getDeptId());
		
		//短信通知号码
		smsInfo.setPhone(this.sessionUserPhone);
		smsSendDay=CurrentDateTime.getCurrentDate();
		smsSendTime="09:00";
		return SUCCESS;
	}

	public String openModifySellRecordForSeller() {
		customerInfos = customerInfoService.findAllCustomerInfoBySalesmanId(sessionUserId); //查本公司业务员所管辖的客户
		if(customerInfos==null || customerInfos.size()==0){
			customerInfos = customerInfoService.findAllCustomerInfoByCompanyId(sessionCompanyId);//本公司的所有客户
		}
		sellRecord = sellRecordService.getSellRecordById(sellRecord.getId());
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		
		//获取短信通知对象
		smsInfo= smsInfoService.getSMSInfoBySellRecordId(sellRecord.getId());
		if(smsInfo!=null){
			smsSendDay=CurrentDateTime.getCurrentDate(smsInfo.getSendTime());
			smsSendTime=CurrentDateTime.getCurrentTime(smsInfo.getSendTime());
		}
		return SUCCESS;
	}

	public String addSellRecordForSeller() {
		customerInfos = customerInfoService.findAllCustomerInfoBySalesmanId(sessionUserId); //查本公司业务员所管辖的客户
		if(customerInfos==null || customerInfos.size()==0){
			customerInfos = customerInfoService.findAllCustomerInfoByCompanyId(sessionCompanyId);//本公司的所有客户
		}
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		// 查找客户信息
		customer = customerInfoService.get(sellRecord.getCustomerId());
		sellRecord.setCustomer(customer);
		sellRecord.setCustomerId(customer.getId());// 设置客户Id
		sellRecord.setCustomerName(customer.getCustomerName());
		UserSession userSession = this.getSession();
		sellRecord.setSalesmanId(userSession.getUserId());// 设置销售员Id
		sellRecord.setSalesmanName(userSession.getUserCName());
		Set<GoodsInfo> goodsDetials = new HashSet<GoodsInfo>();
		BigDecimal thisPrice = new BigDecimal(0);
		for (String str : detials) {
			String[] array = str.split("☆");
			GoodsInfo goods = new GoodsInfo();
			goods.setCompanyId(sessionCompanyId);
			goods.setGoodsProductId(array[0]);
			goods.setGoodsName(array[1]);
			goods.setStandard(array[2]);
			goods.setFactory(array[3]);
			if(array[4].equals("")){
				goods.setPrice(new BigDecimal(0));
			}else{
				goods.setPrice(new BigDecimal(array[4]));
			}
			if(array[5].equals("")){
				goods.setNumber(0);
			}else{
				goods.setNumber(Integer.parseInt(array[5]));
			}
			
			if(array[6].equals("")){
				goods.setAllPrice(new BigDecimal(0));
			}else{
				goods.setAllPrice(new BigDecimal(array[6]));
			}
			
			goods.setMemo(array[7].trim());
			goodsDetials.add(goods);
			thisPrice = thisPrice.add(goods.getAllPrice());
		}
		sellRecord.setGoodsDetials(goodsDetials);

		try {
			// 保存或更新销售记录
			if (sellRecord.getId().equals("")) {
				sellRecord.setId(null);
			}
			sellRecordService.saveOrUpdate(sellRecord);

			SMSInfo tempSmsInfo= smsInfoService.getSMSInfoBySellRecordId(sellRecord.getId());
			if(tempSmsInfo!=null){
				tempSmsInfo.setPhone(smsInfo.getPhone());
				tempSmsInfo.setInfo(smsInfo.getInfo());
				Calendar time = Calendar.getInstance();
				if(smsSendDay!=null && smsSendTime!=null && !smsSendDay.equals("") && !smsSendTime.equals("")){
					String[] dayArray = smsSendDay.split("-");
					String[] timeArray = smsSendTime.split(":");
					if(dayArray.length>0 && timeArray.length>0){
						time.set(Calendar.YEAR, Integer.parseInt(dayArray[0]));
						time.set(Calendar.MONTH, Integer.parseInt(dayArray[1])-1);
						time.set(Calendar.DATE, Integer.parseInt(dayArray[2]));
						time.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
						time.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
					}
				}
				smsInfo.setSendTime(time);
				smsInfo = tempSmsInfo;
				smsInfoService.saveSMSInfo(smsInfo);
			}else{
				//保存短信通知对象
				if(smsInfo.getPhone()!=null && !smsInfo.getPhone().equals("") && smsInfo.getInfo()!=null && !smsInfo.getInfo().equals("")){
					smsInfo.setIsImmediately(1);
					smsInfo.setSellRecordId(sellRecord.getId());
					smsInfo.setOrganId(this.sessionCompanyId);
					smsInfo.setPersonName(this.sessionUserCName);
					smsInfo.setPersonCompany(this.sessionCompanyName);
					Calendar time = Calendar.getInstance();
					if(smsSendDay!=null && smsSendTime!=null && !smsSendDay.equals("") && !smsSendTime.equals("")){
						String[] dayArray = smsSendDay.split("-");
						String[] timeArray = smsSendTime.split(":");
						if(dayArray.length>0 && timeArray.length>0){
							time.set(Calendar.YEAR, Integer.parseInt(dayArray[0]));
							time.set(Calendar.MONTH, Integer.parseInt(dayArray[1])-1);
							time.set(Calendar.DATE, Integer.parseInt(dayArray[2]));
							time.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
							time.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
						}
					}
					smsInfo.setSendTime(time);
					smsInfoService.saveSMSInfo(smsInfo);
				}
			}
			
			serviceData(sellRecord.getCustomerId(), sellRecord.getCustomerName(), sellRecord.getBargainTime(), sellRecord.getId(), sellRecord.getRealCollection().floatValue());
			message = "保存成功！";
		} catch (Exception e) {
			message = "保存失败！";
			e.printStackTrace();
		}
		sellRecord = sellRecordService.getSellRecordById(sellRecord.getId());
		// return "message";
		return SUCCESS;
	}
	
	
	//////////////////////////////////////////////
	
	
	public String openAddSellRecordForOneCustomer() {
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); // 日期格式化格式
		String date = format.format(rightNow.getTime()); // 取得当前时间，并格式化成相应格式

		UserSession userSession = this.getSession();
		String orderID = sellRecordService.getSellRecordorderID(date, userSession.getCompanyId());
		int number = 1;
		if (orderID != null && orderID.length() == 13) {
			number = Integer.parseInt(orderID.substring(8));
			number = number + 1;
		}
		customerInfos = customerInfoService.findAllCustomerInfoBySalesmanId(sessionUserId); //查本公司业务员所管辖的客户
		if(customerInfos==null || customerInfos.size()==0){
			customerInfos = customerInfoService.findAllCustomerInfoByCompanyId(sessionCompanyId);//本公司的所有客户
		}
		sellRecord = new SellRecord();
		sellRecord.setCustomerId(customerId);
		sellRecord.setCompanyId(userSession.getCompanyId());
		// String.format("%05d", number) 将流水号格式化为 5位长度返回
		String serialNo = date + String.format("%05d", number);
		sellRecord.setOrderID(serialNo);
		sellRecord.setDeptId(userSession.getDeptId());
		
		//短信通知号码
		smsInfo.setPhone(this.sessionUserPhone);
		smsSendDay=CurrentDateTime.getCurrentDate();
		smsSendTime="09:00";
		return SUCCESS;
	}

	public String openModifySellRecordForOneCustomer() {
		customerInfos = customerInfoService.findAllCustomerInfoBySalesmanId(sessionUserId); //查本公司业务员所管辖的客户
		if(customerInfos==null || customerInfos.size()==0){
			customerInfos = customerInfoService.findAllCustomerInfoByCompanyId(sessionCompanyId);//本公司的所有客户
		}
		sellRecord = sellRecordService.getSellRecordById(sellRecord.getId());
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		//获取短信通知对象
		smsInfo= smsInfoService.getSMSInfoBySellRecordId(sellRecord.getId());
		if(smsInfo!=null){
			smsSendDay=CurrentDateTime.getCurrentDate(smsInfo.getSendTime());
			smsSendTime=CurrentDateTime.getCurrentTime(smsInfo.getSendTime());
		}
		return SUCCESS;
	}
	
	public String openModifySellRecordForOneCustomerView() {
		customerInfos = customerInfoService.findAllCustomerInfoBySalesmanId(sessionUserId); //查本公司业务员所管辖的客户
		if(customerInfos==null || customerInfos.size()==0){
			customerInfos = customerInfoService.findAllCustomerInfoByCompanyId(sessionCompanyId);//本公司的所有客户
		}
		sellRecord = sellRecordService.getSellRecordById(sellRecord.getId());
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		return SUCCESS;
	}

	public String addSellRecordForForOneCustomer() {
		customerInfos = customerInfoService.findAllCustomerInfoBySalesmanId(sessionUserId); //查本公司业务员所管辖的客户
		if(customerInfos==null || customerInfos.size()==0){
			customerInfos = customerInfoService.findAllCustomerInfoByCompanyId(sessionCompanyId);//本公司的所有客户
		}
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		// 查找客户信息
		customer = customerInfoService.get(sellRecord.getCustomerId());
		sellRecord.setCustomer(customer);
		sellRecord.setCustomerId(customer.getId());// 设置客户Id
		sellRecord.setCustomerName(customer.getCustomerName());
		UserSession userSession = this.getSession();
		sellRecord.setSalesmanId(userSession.getUserId());// 设置销售员Id
		sellRecord.setSalesmanName(userSession.getUserCName());
		Set<GoodsInfo> goodsDetials = new HashSet<GoodsInfo>();
		BigDecimal thisPrice = new BigDecimal(0);
		for (String str : detials) {
			String[] array = str.split("☆");
			System.out.println(array[0]);
			GoodsInfo goods = new GoodsInfo();
			goods.setCompanyId(sessionCompanyId);
			goods.setGoodsProductId(array[0]);
			goods.setGoodsName(array[1]);
			goods.setStandard(array[2]);
			goods.setFactory(array[3]);
			if(array[4].equals("")){
				goods.setPrice(new BigDecimal(0));
			}else{
				goods.setPrice(new BigDecimal(array[4]));
			}
			if(array[5].equals("")){
				goods.setNumber(0);
			}else{
				goods.setNumber(Integer.parseInt(array[5]));
			}
			
			if(array[6].equals("")){
				goods.setAllPrice(new BigDecimal(0));
			}else{
				goods.setAllPrice(new BigDecimal(array[6]));
			}
			
			goods.setMemo(array[7].trim());
			goodsDetials.add(goods);
			thisPrice = thisPrice.add(goods.getAllPrice());
		}
		sellRecord.setGoodsDetials(goodsDetials);

		try {
			// 保存或更新销售记录
			if (sellRecord.getId().equals("")) {
				sellRecord.setId(null);
			}
			sellRecordService.saveOrUpdate(sellRecord);
			
			//更新客户业务进展状态为：已成交
			customer.setProgressId(BusinessProgressKey.DEALED);
			customerInfoService.save(customer);
			
			SMSInfo tempSmsInfo= smsInfoService.getSMSInfoBySellRecordId(sellRecord.getId());
			if(tempSmsInfo!=null){
				tempSmsInfo.setPhone(smsInfo.getPhone());
				tempSmsInfo.setInfo(smsInfo.getInfo());
				Calendar time = Calendar.getInstance();
				if(smsSendDay!=null && smsSendTime!=null && !smsSendDay.equals("") && !smsSendTime.equals("")){
					String[] dayArray = smsSendDay.split("-");
					String[] timeArray = smsSendTime.split(":");
					if(dayArray.length>0 && timeArray.length>0){
						time.set(Calendar.YEAR, Integer.parseInt(dayArray[0]));
						time.set(Calendar.MONTH, Integer.parseInt(dayArray[1])-1);
						time.set(Calendar.DATE, Integer.parseInt(dayArray[2]));
						time.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
						time.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
					}
				}
				smsInfo.setSendTime(time);
				smsInfo = tempSmsInfo;
				smsInfoService.saveSMSInfo(smsInfo);
			}else{
				//保存短信通知对象
				if(smsInfo.getPhone()!=null && !smsInfo.getPhone().equals("") && smsInfo.getInfo()!=null && !smsInfo.getInfo().equals("")){
					smsInfo.setIsImmediately(1);
					smsInfo.setSellRecordId(sellRecord.getId());
					smsInfo.setOrganId(this.sessionCompanyId);
					smsInfo.setPersonName(this.sessionUserCName);
					smsInfo.setPersonCompany(this.sessionCompanyName);
					Calendar time = Calendar.getInstance();
					if(smsSendDay!=null && smsSendTime!=null && !smsSendDay.equals("") && !smsSendTime.equals("")){
						String[] dayArray = smsSendDay.split("-");
						String[] timeArray = smsSendTime.split(":");
						if(dayArray.length>0 && timeArray.length>0){
							time.set(Calendar.YEAR, Integer.parseInt(dayArray[0]));
							time.set(Calendar.MONTH, Integer.parseInt(dayArray[1])-1);
							time.set(Calendar.DATE, Integer.parseInt(dayArray[2]));
							time.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
							time.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
						}
					}
					smsInfo.setSendTime(time);
					smsInfoService.saveSMSInfo(smsInfo);
				}
			}
			
			serviceData(sellRecord.getCustomerId(), sellRecord.getCustomerName(), sellRecord.getBargainTime(), sellRecord.getId(), sellRecord.getRealCollection().floatValue());
			message = "保存成功！";
		} catch (Exception e) {
			message = "保存失败！";
			e.printStackTrace();
		}
		sellRecord = sellRecordService.getSellRecordById(sellRecord.getId());
		// return "message";
		return SUCCESS;
	}
	////////////////////////////////

	public String modifySellRecord() {
		return SUCCESS;
	}

	public String deleteSellRecord() {
		sellRecordService.deleteSellRecordByIds(ids);
		smsInfoService.deleteSMSInfoBySellRecordId(ids);
		return NONE;
	}

	public String openAddSellRecordDetial() {
		//dataDictionarys =  dataDictionaryService.findDataDictionaryByType(sessionCompanyId, 8);
		goodsInfoBaseList = goodsInfoBaseService.findGoodsInfoBaseByGoodsTypeId(goodsTypeId);
		return SUCCESS;
	}

	public String openModifySellRecordDetial() {
		return SUCCESS;
	}

	public String addSellRecordDetial() {
		return SUCCESS;
	}

	public String modifySellRecordDetial() {
		return SUCCESS;
	}

	public String deleteSellRecordDetials() {
		goodsInfoService.deleteGoodsInfoByIds(ids);
		return NONE;
	}

	/**
	 * 为服务模块生成数据
	 * 
	 * @param companyId
	 *            单位ID
	 * @param companyName
	 *            单位名称
	 * @param consumptionId
	 *            销售ID
	 * @param money
	 *            销售金额
	 */
	private void serviceData(String companyId, String companyName, Calendar createTime, String consumptionId, float money) {
		PointInfo pi = pointInfoService.getByConsumptionId(consumptionId);
		if (pi == null) {
			pi = new PointInfo();
			pi.setConsumptionId(consumptionId);
		}
		pi.setMyCompanyId(sessionCompanyId);
		pi.setCompanyId(companyId);
		pi.setCompanyName(companyName);
		pi.setConsumptionTime(createTime);// 消费时间
		pi.setConsumptionMoney(money);// 消费金额
		pi.setPoint((int) pi.getConsumptionMoney());// 消费积分
		pointInfoService.saveOrUpdate(pi);
		// 更新会员积分信息
		MemberInfo mi = memberInfoService.getByCompanyId(companyId);// 客户ID
		if (mi == null) {
			mi = new MemberInfo();
			mi.setCreateTime(createTime);
		}
		mi.setMyCompanyId(sessionCompanyId);
		mi.setCompanyId(companyId);
		mi.setCompanyName(companyName);
		mi.setConsumptionAmount(pointInfoService.getConsumptionAmount(companyId));// 消费总额
		mi.setTotalPoint(pointInfoService.getTotalPoint(companyId));// 总积分

		// 设置会员类别
		List<MemberType> memberTypes = memberTypeService.memberTypeList(sessionCompanyId);
		if (memberTypes != null && memberTypes.size() > 0) {
			for (MemberType memberType : memberTypes) {
				if (mi.getTotalPoint() >= memberType.getMinStandard() && mi.getTotalPoint() <= memberType.getMaxStandard()) {
					mi.setMemberType(memberType.getTypeName());
					break;
				}
			}
		} else {
			mi.setMemberType("普通会员");
		}
		memberInfoService.updateInfo(mi);
	}

	/**
	 * 显示组织机构树,带公司、工厂、车间
	 * 
	 * @return
	 */
	public String showGroupTreeForSellRecord() throws Exception {
		companyId = sessionCompanyId;
		companyName = sessionCompanyName;
		userList = new ArrayList<User>();
		deptList = new ArrayList<Deptment>();
//		boolean flag=true;
//		if(sessionDeptId.equals("")){ //总经理
//			flag=false;
//		}
		UserSession us = this.getSession();
		//判断是否是公司管理员或公司级用户
		boolean popodomFlag = popedomService.isCompanyAdministrator(us.getUserId(), String.valueOf(us.getUserType()) ) 
				||popedomService.isHasCompanyPopedom(us.getRoleKey());
		/**
		 * JHY注 
		if(flag){ //部门经理
			deptList.add(deptService.get(sessionDeptId));
		}else{    //总经理
			deptList = deptService.queryAllDeptmentsByCompanyId(sessionCompanyId);
		}
		*/
		if( popodomFlag ){
			deptList = deptService.queryAllDeptmentsByCompanyId(sessionCompanyId);
		}else{
			deptList.add(deptService.get(sessionDeptId));
		}
		// 获取用户列表
		if (deptList != null && deptList.size() > 0) {
			List<User> tempUserList = new ArrayList<User>();
			for (int i = 0; i < deptList.size(); i++) {
				if(deptList.get(i)!=null){
					List<User> tempList = userService.queryUserList(sessionCompanyId, deptList.get(i).getId());
					if (tempList != null && tempList.size() > 0) {
						tempUserList.addAll(tempList);
					}
				}
			}
			if (tempUserList != null && tempUserList.size() > 0) {
				userList.addAll(tempUserList);
			}
		}
		return "group-tree-for-sell-record";
	}

	/**
	 * 手机给销售员使用
	 * @return
	 * @throws Exception
	 */
	public String getSellerSellRecordListForPhone() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String,Object> map = new HashMap<String,Object>();
//		if(userId!=null && !userId.equals("") && salesmanId!=null && !salesmanId.equals("")){
		if( salesmanId!=null && !salesmanId.equals("")){
//			String companyId = userService.getUserById(userId).getCompanyId();
			Map<String, String> params = new HashMap<String, String>();
//			params.put("companyId", companyId);
			params.put("salesmanId", salesmanId);
			List<SellRecord> tempList = sellRecordService.findAllSellRecord(params);
			List<SellRecordForPhone> list = new ArrayList<SellRecordForPhone>();
			for(SellRecord obj : tempList){
				SellRecordForPhone temp = new SellRecordForPhone();
				temp.setId(obj.getId());
				temp.setCompany(obj.getCustomerName());
				temp.setOrder(obj.getOrderID());
				
				Set goodsDetialSet = obj.getGoodsDetials();
				StringBuffer goodsStr = new StringBuffer("");
				List<String> ss = new ArrayList<String>();
				for(Object detial : goodsDetialSet) {
					GoodsInfo tempGoods =  (GoodsInfo)detial;
					if(!ss.contains(tempGoods.getGoodsName())){
						ss.add(tempGoods.getGoodsName());
					}
				}
				
				for(int i=0,j=ss.size();i<j;i++){
					goodsStr.append(ss.get(i));
					if(i+1<j){
						goodsStr.append(",");
					}
				}
				
				temp.setGoods(goodsStr.toString());
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String dateString = formatter.format(obj.getBargainTime().getTime());
				temp.setDate(dateString);
				temp.setMoney(""+obj.getRealCollection());
				list.add(temp);
			}
			map.put("sell", list);
			request.setAttribute("map", map);
		}
		return COMMON_MAP;
	}
	
	public List<String> getDetials() {
		return detials;
	}

	public void setDetials(List<String> detials) {
		this.detials = detials;
	}

	public List<CustomerInfo> getCustomerInfos() {
		return customerInfos;
	}

	public void setCustomerInfos(List<CustomerInfo> customerInfos) {
		this.customerInfos = customerInfos;
	}

	public CustomerInfo getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerInfo customer) {
		this.customer = customer;
	}

	public SellRecord getSellRecord() {
		return sellRecord;
	}

	public void setSellRecord(SellRecord sellRecord) {
		this.sellRecord = sellRecord;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Pagination<SellRecord> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<SellRecord> pagination) {
		this.pagination = pagination;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getQueryCustomerName() {
		return queryCustomerName;
	}

	public void setQueryCustomerName(String queryCustomerName) {
		this.queryCustomerName = queryCustomerName;
	}

	public String getQueryLinkman() {
		return queryLinkman;
	}

	public void setQueryLinkman(String queryLinkman) {
		this.queryLinkman = queryLinkman;
	}

	public String getQuerySalesman() {
		return querySalesman;
	}

	public void setQuerySalesman(String querySalesman) {
		this.querySalesman = querySalesman;
	}

	public String getQueryReturnedMoney() {
		return queryReturnedMoney;
	}

	public void setQueryReturnedMoney(String queryReturnedMoney) {
		this.queryReturnedMoney = queryReturnedMoney;
	}

	public String getQueryBargainTimeBegin() {
		return queryBargainTimeBegin;
	}

	public void setQueryBargainTimeBegin(String queryBargainTimeBegin) {
		this.queryBargainTimeBegin = queryBargainTimeBegin;
	}

	public String getQueryBargainTimeEnd() {
		return queryBargainTimeEnd;
	}

	public void setQueryBargainTimeEnd(String queryBargainTimeEnd) {
		this.queryBargainTimeEnd = queryBargainTimeEnd;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * 生成流水号
	 * 
	 * @return
	 */

	public String generateSerialNumber() {
		// 当天的初始化流水号为1
		Integer serialNo = 1;
		// 查询当天的下一个流水号
//		String hql = "SELECT max(t.serialNo+1) FROM SerialNumber t WHERE t.generateDate=?";
		// String generateDate = DateUtils.formatDate(new Date(),"yyyyMMdd");
		// Object obj = session.createQuery(hql).setParameter(0,
		// generateDate).uniqueResult();
		// if(obj != null) {
		// serialNo = (Integer) obj;
		// }
		// 将当前序列号保存到数据库
		// SerialNumber sn = new SerialNumber();
		// sn.setSerialNo(serialNo);
		// sn.setGenerateDate(generateDate);
		// session.save(sn);
		// 将流水号格式化为 "00001" 5位长度返回
		return String.format("%05d", serialNo);
	}
	
	public String getGoodsInfoForAjax(){
		goodsInfoBase = goodsInfoBaseService.get(goodsInfoBaseId);
		return SUCCESS;
	}

	public List<Deptment> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Deptment> deptList) {
		this.deptList = deptList;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getWho() {
		return who;
	}
	public void setWho(String who) {
		this.who = who;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<DataDictionary> getDataDictionarys() {
		return dataDictionarys;
	}
	public void setDataDictionarys(List<DataDictionary> dataDictionarys) {
		this.dataDictionarys = dataDictionarys;
	}
	public GoodsType getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}
	public List<GoodsType> getGoodsTypes() {
		return goodsTypes;
	}
	public void setGoodsTypes(List<GoodsType> goodsTypes) {
		this.goodsTypes = goodsTypes;
	}
	public List<GoodsInfoBase> getGoodsInfoBaseList() {
		return goodsInfoBaseList;
	}
	public void setGoodsInfoBaseList(List<GoodsInfoBase> goodsInfoBaseList) {
		this.goodsInfoBaseList = goodsInfoBaseList;
	}
	public String getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public GoodsInfoBase getGoodsInfoBase() {
		return goodsInfoBase;
	}
	public void setGoodsInfoBase(GoodsInfoBase goodsInfoBase) {
		this.goodsInfoBase = goodsInfoBase;
	}
	public String getGoodsInfoBaseId() {
		return goodsInfoBaseId;
	}
	public void setGoodsInfoBaseId(String goodsInfoBaseId) {
		this.goodsInfoBaseId = goodsInfoBaseId;
	}
	public SMSInfo getSmsInfo() {
		return smsInfo;
	}
	public void setSmsInfo(SMSInfo smsInfo) {
		this.smsInfo = smsInfo;
	}
	public String getSmsSendDay() {
		return smsSendDay;
	}
	public void setSmsSendDay(String smsSendDay) {
		this.smsSendDay = smsSendDay;
	}
	public String getSmsSendTime() {
		return smsSendTime;
	}
	public void setSmsSendTime(String smsSendTime) {
		this.smsSendTime = smsSendTime;
	}
	public String getQueryAmountBegin() {
		return queryAmountBegin;
	}
	public void setQueryAmountBegin(String queryAmountBegin) {
		this.queryAmountBegin = queryAmountBegin;
	}
	public String getQueryAmountEnd() {
		return queryAmountEnd;
	}
	public void setQueryAmountEnd(String queryAmountEnd) {
		this.queryAmountEnd = queryAmountEnd;
	}
	public String getQueryIsArrearage() {
		return queryIsArrearage;
	}
	public void setQueryIsArrearage(String queryIsArrearage) {
		this.queryIsArrearage = queryIsArrearage;
	}
	/**
	 * @return the salesmanId
	 */
	public String getSalesmanId() {
		return salesmanId;
	}
	/**
	 * @param salesmanId the salesmanId to set
	 */
	public void setSalesmanId(String salesmanId) {
		this.salesmanId = salesmanId;
	}
}
