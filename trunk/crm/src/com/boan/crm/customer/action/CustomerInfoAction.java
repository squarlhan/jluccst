/**
 * 
 */
package com.boan.crm.customer.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.backstagemanage.common.ProductType;
import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.model.CustomerStaticInfo;
import com.boan.crm.customer.model.CustomerTraceInfo;
import com.boan.crm.customer.model.CustomerVisitInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.customer.service.ICustomerStaticInfoService;
import com.boan.crm.customer.service.ICustomerTraceInfoService;
import com.boan.crm.customer.service.ICustomerVisitInfoService;
import com.boan.crm.datadictionary.model.AreaInfo;
import com.boan.crm.datadictionary.model.CityInfo;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.model.ProvinceInfo;
import com.boan.crm.datadictionary.service.IAreaService;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.groupmanage.common.RoleFlag;
import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.groupmanage.service.IPopedomService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.io.impl.FileCopyAndDeleteUtilsAdaptor;
import com.boan.crm.utils.page.Pagination;
import com.boan.crm.utils.path.PathUtil;
import com.boan.crm.utils.uuid.MyUUIDGenerator;

/**
 * @author luojx
 * 客户信息action
 */
@Controller("customerInfoAction")
@Scope("prototype")
public class CustomerInfoAction extends BaseActionSupport{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4140371188076904836L;
	
	@Autowired
	@Qualifier("customerInfoService")
	//客户状态接口类
	private ICustomerInfoService customerInfoService;
	
	@Autowired
	@Qualifier("dataDictionaryService")
	private IDataDictionaryService dataDictionaryService = null;
	
	@Autowired
	@Qualifier("areaService")
	private IAreaService areaService = null;
	
	// 客户状态接口类
	@Autowired
	@Qualifier("contractPersonService")
	private IContractPersonService contractpersonInfoService;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	@Autowired
	@Qualifier("deptService")
	private IDeptmentService deptService = null;
	@Autowired
	@Qualifier("popedomService")
	private IPopedomService popedomService = null;
	
	@Autowired
	@Qualifier("customerStaticInfoService")
	private ICustomerStaticInfoService customerStaticInfoService = null;
	@Autowired
	@Qualifier("customerTraceInfoService")
	private ICustomerTraceInfoService customerTraceInfoService = null;
	@Autowired
	@Qualifier("customerVisitInfoService")
	private ICustomerVisitInfoService customerVisitInfoService = null;
	
	
	//客户信息类
	private CustomerInfo customerInfo ;
	private String id = "";
	private String deptId = "";
	private String[] ids = null;
	private Pagination<CustomerInfo> pagination = new Pagination<CustomerInfo>();
	private List<DataDictionary> listCategory = null;
	private List<DataDictionary> listSource = null;
	private List<DataDictionary> listProgress = null;
	private List<DataDictionary> listMaturity = null;
	private List<DataDictionary> listLevel = null;
	private List<ContractPersonInfo> listPerson = null;
	private List<ProvinceInfo> listProvince = null;
	private List<CityInfo> listCity = null;
	private List<AreaInfo> listArea = null;
	private String customerName = "";
	private String contractorName = "";
	private String customerCategory = "";
	private String salesmanId = "";
	private List<User> userList = null;
	private int iSearchMaxRecord = 10;
	private File uploadFile;
	private String uploadFileContentType = null;
	private String message = "";
	private List<CustomerInfo> listCustomer = null;
	private String provinceId = "";
	private String cityId = "";
	private String tel = "";
	private String flag = "";
	private boolean crmFlag = false;
	private boolean erpFlag = false;
	private boolean teamFlag = false;
	private String searchFlag = "";
	
	public String getSearchFlag() {
		return searchFlag;
	}

	public void setSearchFlag(String searchFlag) {
		this.searchFlag = searchFlag;
	}
	/**
	 * 上传导入文件的名称
	 */
	private String uploadFileFileName = null;
	private String companyId = "";
	private String companyName = "";
	private List<Deptment> deptList = null;
	private int totalCustomerCount = 0;
	
	private List<CustomerStaticInfo> listCategoryStatic = null;
	private List<CustomerStaticInfo> listSourceStatic =  null;
	private List<CustomerStaticInfo> listMaturityStatic =  null;
	private List<CustomerStaticInfo> listProgressStatic =  null;
	private List<CustomerStaticInfo> listLevelStatic =  null;
	
	public CustomerInfoAction()
	{
		int productType = this.getSession().getProductType();
		if(productType == ProductType.CRM)
		{
			crmFlag = true;
		}
		if(productType == ProductType.ERP)
		{
			erpFlag = true;
		}
		if(productType == ProductType.TEAM_MANAGE)
		{
			teamFlag = true;
		}
		
	}
	
	public String showGroupTree() throws Exception
	{
		companyId = sessionCompanyId;
		companyName = sessionCompanyName;
		
		UserSession us = this.getSession();
		//判断是否是公司管理员或公司级用户
		boolean administratorFlag = popedomService.isHasPopedomByRoleKey(us,RoleFlag.GONG_SI_GUAN_LI_YUAN);
		boolean leaderFlag = popedomService.isHasPopedomByRoleKey(us,RoleFlag.GONG_SI_LING_DAO);
		//SELF_COMPANY
		if(leaderFlag || administratorFlag)
		{
			deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		}else
		{
			deptList = new ArrayList<Deptment>();
			Deptment dept = new Deptment();
			dept.setCompanyId(companyId);
			dept.setDeptName(us.getDeptName());
			dept.setId(us.getDeptId());
			deptList.add(dept);
		}

		return "success";
	}
	
	/**
	 * 客户列表
	 * @return String
	 */
	public String myCustomerList()
	{
		//客户分类： 传0
		listCategory = dataDictionaryService.findDataDictionaryByType(sessionCompanyId, 0);
		try
		{
			//userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,RoleFlag.YE_WU_YUAN);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		Map<String,String> values = new HashMap<String,String>();
		
		if(customerName != null && customerName.length() > 0)
		{
			values.put("customerName", "%"+customerName+"%");
		}
		if(contractorName != null && contractorName.length() > 0)
		{
			values.put("contractorName", "%"+contractorName+"%");
		}
		if(customerCategory != null && customerCategory.length() > 0)
		{
			values.put("customerCategory", customerCategory);
		}
		if(salesmanId != null && salesmanId.length() > 0)
		{
			values.put("salesmanId", salesmanId);
		}
		
		values.put("companyId", sessionCompanyId);
		values.put("salesmanId", sessionUserId);
		
		pagination = customerInfoService.findCustomerInfoForPage(values, pagination);
		return SUCCESS;
	}
	/**
	 * 客户列表
	 * @return String
	 */
	public String customerList()
	{
		//客户分类： 传0
		listCategory = dataDictionaryService.findDataDictionaryByType(sessionCompanyId, 0);
		
		UserSession us = this.getSession();
		//判断是否是公司管理员或公司级用户
		boolean ywyFlag = false;
		try
		{
			ywyFlag = popedomService.isHasPopedomByRoleKey(us,RoleFlag.YE_WU_YUAN);
			if(ywyFlag)
			{
				User user = userService.getUserById(sessionUserId);
				userList = new ArrayList<User>();
				userList.add(user);
			}else
			{
				if(deptId != null && deptId.length() > 0)
				{
					userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,deptId,RoleFlag.YE_WU_YUAN);
				}else
				{
					userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,RoleFlag.YE_WU_YUAN);
				}
			}
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		Map<String,String> values = new HashMap<String,String>();
		
		if(customerName != null && customerName.length() > 0)
		{
			values.put("customerName", "%"+customerName+"%");
		}
		if(contractorName != null && contractorName.length() > 0)
		{
			values.put("contractorName", "%"+contractorName+"%");
		}
		if(customerCategory != null && customerCategory.length() > 0)
		{
			values.put("customerCategory", customerCategory);
		}
		if(salesmanId != null && salesmanId.length() > 0)
		{
			values.put("salesmanId", salesmanId);
		}
		if(ywyFlag)
		{
			values.put("salesmanId", sessionUserId);
		}
		if(deptId != null && deptId.length() > 0)
		{
			values.put("deptId", deptId);
		}
		values.put("companyId", sessionCompanyId);
		values.put("showAllFlag", "1");
		pagination = customerInfoService.findCustomerInfoForPage(values, pagination);
		return SUCCESS;
	}
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public String getCustomerByName()
	{
		Map<String,String> values = new HashMap<String,String>();
		try
		{
			customerName = new String(customerName.getBytes("ISO-8859-1"), "UTF-8");
		}catch(Exception ex){}
		if(customerName != null && customerName.length() > 0)
		{
			values.put("customerName", "%"+customerName+"%");
		}
		
		values.put("companyId", sessionCompanyId);
		
		pagination.setPageSize(5);
		pagination = customerInfoService.findCustomerInfoForPage(values, pagination);
		listCustomer = pagination.getData();
		return SUCCESS;
	}
	public String getMyCustomerByName()
	{
		Map<String,String> values = new HashMap<String,String>();
		try
		{
			customerName = new String(customerName.getBytes("ISO-8859-1"), "UTF-8");
		}catch(Exception ex){}
		if(customerName != null && customerName.length() > 0)
		{
			values.put("customerName", "%"+customerName+"%");
		}
		
		values.put("companyId", sessionCompanyId);
		values.put("salesmanId", sessionUserId);
		
		pagination.setPageSize(5);
		pagination = customerInfoService.findCustomerInfoForPage(values, pagination);
		listCustomer = pagination.getData();
		return SUCCESS;
	}
	public String importCustomer()
	{
		listProvince = areaService.findAllProvinceInfo();
		return SUCCESS;
	}
	
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String importCustomerSave()
	{
		if(uploadFile != null)
		{
			try
			{
				String baseDirectory = PathUtil.getInstance().getWebRoot()+"uploadfiles/importcustomer/";
				String extendName = null;
				if( StringUtils.isNotBlank( uploadFileFileName ) && uploadFileFileName.lastIndexOf( "." ) != -1 )
					extendName = uploadFileFileName.substring( uploadFileFileName.lastIndexOf("."), uploadFileFileName.length() );
				File newFile = new File(baseDirectory);
				if( !newFile.exists() )
					newFile.mkdirs();
				
				String fileStorePath = MyUUIDGenerator.getInstance().generate().toString() + extendName;
				FileCopyAndDeleteUtilsAdaptor fileUtils = new FileCopyAndDeleteUtilsAdaptor();
				fileUtils.copySimpleFile( uploadFile, new File( baseDirectory, fileStorePath ), 1024 );
				
				Workbook wb = null;
				InputStream is = null;
				Sheet sheet = null;
				try
				{
					is = new FileInputStream( new File( baseDirectory + fileStorePath ) );
//					is = new FileInputStream( new File( grantsRecordMeta.getImportFileStorePath() ) );
					wb = WorkbookFactory.create( is );
					is.close();
					
					sheet = wb.getSheetAt( 0 );
					int totalRecord = ( sheet.getLastRowNum() + 1 ) - 1;
					if( totalRecord == 0 )
					{
						
					}else
					{
						for( int i = 1; i < totalRecord + 1; i++ )
						{
							Row row = sheet.getRow( i );
							try
							{
								if( row != null )
								{
									Cell customerNameCell = row.getCell( 0 );
									Cell customerTelCell = row.getCell( 1 );
									Cell customerFaxCell = row.getCell( 2 );
									Cell customerPhoneCell = row.getCell( 3 );
									Cell customerContractPersonNameCell = row.getCell( 4 );
									Cell customerContractDeptCell = row.getCell( 5 );
									Cell customerAddressCell = row.getCell( 6 );
									Cell customerPostCodeCell = row.getCell( 7 );
									Cell customerEmailCell = row.getCell( 8 );
									Cell customerMainIndustryCell = row.getCell( 9 );
									String customerName = "";
									String customerTel = "";
									String customerFax = "";
									String customerPhone = "";
									String customerContractPersonName = "";
									String customerContractDept = "";
									String customerAddress = "";
									String customerPostCode = "";
									String customerEmail = "";
									String customerMainIndustry = "";
									if( customerNameCell != null )
									{
										customerName = customerNameCell.getStringCellValue() ;
									}
									if( customerTelCell != null )
									{
										customerTel = customerTelCell.getStringCellValue() ;
									}
									if( customerFaxCell != null )
									{
										customerFax = customerFaxCell.getStringCellValue() ;
									}
									if( customerPhoneCell != null )
									{
										customerPhone = customerPhoneCell.getStringCellValue() ;
									}
									if( customerContractPersonNameCell != null )
									{
										customerContractPersonName = customerContractPersonNameCell.getStringCellValue() ;
									}
									if( customerContractDeptCell != null )
									{
										customerContractDept = customerContractDeptCell.getStringCellValue() ;
									}
									if( customerAddressCell != null )
									{
										customerAddress = customerAddressCell.getStringCellValue() ;
									}
									if( customerPostCodeCell != null )
									{
										customerPostCode = customerPostCodeCell.getStringCellValue() ;
									}
									if( customerEmailCell != null )
									{
										customerEmail = customerEmailCell.getStringCellValue() ;
									}
									if( customerMainIndustryCell != null )
									{
										customerMainIndustry = customerMainIndustryCell.getStringCellValue() ;
									}
									
									
									CustomerInfo customer = new CustomerInfo();
									if(customerName.length() > 255)
									{
										customerName = customerName.substring(0,254);
									}
									customer.setCustomerName(customerName);
									customer.setAddress(customerAddress);
									customer.setMainIndustry(customerMainIndustry);
									customer.setFax(customerFax);
									customer.setPostCode(customerPostCode);
									customer.setCreateTime(Calendar.getInstance());
									customer.setCompanyId( sessionCompanyId );
									customer.setCreatorId(sessionUserId);
									customer.setProvince(provinceId);
									if(cityId != null && cityId.length() > 0)
									{
										customer.setCity(cityId);
									}
									customer.setCompanyFullName(customerName);

									String customerAddressTemp = customerAddress.replaceAll("-", " ");
									customerAddressTemp = customerAddressTemp.replaceAll("省", "省 ");
									customerAddressTemp = customerAddressTemp.replaceAll("市", "市 ");
									customerAddressTemp = customerAddressTemp.replaceAll("区", "区 ");
									customerAddressTemp = customerAddressTemp.replaceAll("县", "县 ");
									customerAddressTemp = customerAddressTemp.replaceAll("  ", " ");
									String[] customerAddressArray = customerAddressTemp.split(" ");
									boolean bCityFlag = false;
									boolean bAreaFlag = false;
									String tempCityId = cityId;
									for(int kk=0;kk<customerAddressArray.length - 1;kk++)
									{
										if(!customerAddressArray[kk].equals("中国"))
										{
//											if(!bProvinceFlag)
//											{
//												ProvinceInfo province = areaService.getProvinceByName(customerAddressArray[kk]);
//												if(province != null)
//												{
//													customer.setProvince(province.getId());
//													bProvinceFlag = true;
//													continue;
//												}
//											}
											if(cityId == null || cityId.length() == 0)
											{
												if(!bCityFlag)
												{
													CityInfo city = areaService.getCityByNameAndProvinceId(customerAddressArray[kk],provinceId);
													if(city != null)
													{
														customer.setCity(city.getId());
														//customer.setProvince(city.getProvinceId());
														bCityFlag = true;
														tempCityId = city.getId();
														continue;
													}
												}
											}
											if(!bAreaFlag)
											{
												AreaInfo area = null;
												if(tempCityId != null && tempCityId.length() > 0)
												{
													area = areaService.getAreaByNameAndCityId(customerAddressArray[kk],tempCityId);
												}else
												{
													area = areaService.getAreaByName(customerAddressArray[kk]);
												}
												if(area != null)
												{
													customer.setDistrict(area.getId());
													customer.setCity(area.getCityId());
													bAreaFlag = true;
													continue;
												}	
											}
										}
									}
									
									customerInfoService.save(customer);
									
									ContractPersonInfo contractPerson = new ContractPersonInfo();
									contractPerson.setCustomerId(customer.getId());
									contractPerson.setPersonName(customerContractPersonName);
									contractPerson.setTel(customerTel);
									contractPerson.setPhone(customerPhone);
									contractPerson.setDeptOrDuty(customerContractDept);
									contractPerson.setEmail(customerEmail);

									contractpersonInfoService.save(contractPerson);
									
									
								}
							}catch(Exception ex)
							{}
						}
					}
				}
				catch( Exception ex )
				{
					
				}
				
			}catch(Exception ex)
			{
				
			}
		}
		message = "保存成功！";
		listProvince = areaService.findAllProvinceInfo();
		return SUCCESS;
	}
	
	/**
	 * 客户信息
	 * @return String
	 */
	public String customerInfo()
	{
		String companyId = sessionCompanyId;
		if(StringUtils.trimToNull(id)!=null)
		{
			customerInfo = customerInfoService.get(id);
			if(companyId == null || companyId.length() == 0)
			{
				companyId = customerInfo.getCompanyId();
			}
		}
		else
			customerInfo = new CustomerInfo();
		
		
		//客户来源：传2
		listSource = dataDictionaryService.findDataDictionaryByType(companyId, 2);
		//客户分类： 传0
		listCategory = dataDictionaryService.findDataDictionaryByType(companyId, 0);
		//业务进展：传1
		listProgress = dataDictionaryService.findDataDictionaryByType(companyId, 7);
		//成熟度：传4
		listMaturity = dataDictionaryService.findDataDictionaryByType(companyId, 4);
		//开发程度--->客户状态
		listLevel = dataDictionaryService.findDataDictionaryByType(companyId, 1);
//		listLevel = new ArrayList<DataDictionary>();
//		DataDictionary level = new DataDictionary();
//		level.setId("10%");
//		level.setName("10%");
//		listLevel.add(level);
//		DataDictionary level1 = new DataDictionary();
//		level1.setId("20%");
//		level1.setName("20%");
//		listLevel.add(level1);
//		DataDictionary level2 = new DataDictionary();
//		level2.setId("30%");
//		level2.setName("30%");
//		listLevel.add(level2);
//		DataDictionary level3 = new DataDictionary();
//		level3.setId("40%");
//		level3.setName("40%");
//		listLevel.add(level3);
//		DataDictionary level4 = new DataDictionary();
//		level4.setId("50%");
//		level4.setName("50%");
//		listLevel.add(level4);
//		DataDictionary level5 = new DataDictionary();
//		level5.setId("60%");
//		level5.setName("60%");
//		listLevel.add(level5);
//		DataDictionary level6 = new DataDictionary();
//		level6.setId("70%");
//		level6.setName("70%");
//		listLevel.add(level6);
//		DataDictionary level7 = new DataDictionary();
//		level7.setId("80%");
//		level7.setName("80%");
//		listLevel.add(level7);
//		DataDictionary level8 = new DataDictionary();
//		level8.setId("90%");
//		level8.setName("90%");
//		listLevel.add(level8);
//		DataDictionary level9 = new DataDictionary();
//		level9.setId("100%");
//		level9.setName("100%");
//		listLevel.add(level9);
		
		listProvince = areaService.findAllProvinceInfo();
		
		try
		{
			if(deptId != null && deptId.length() > 0)
			{
				userList = userService.queryUserListByCompanyIdRoleKey(companyId,deptId,RoleFlag.YE_WU_YUAN);
			}else
			{
				userList = userService.queryUserListByCompanyIdRoleKey(companyId,RoleFlag.YE_WU_YUAN);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		if(id != null && id.length() > 0)
			listPerson = contractpersonInfoService.findAllContractPersonInfoByCustomerId(id);
		
		return SUCCESS;
	}
	
	public String customerTabInfo()
	{
		
		return SUCCESS;
	}
	public String myCustomerTabInfo()
	{
		return SUCCESS;
	}
	public String myTelCustomerTabInfo()
	{
		//根据电话号、手机号取客户Id
		id = contractpersonInfoService.getCustomerIdByPhone(tel);
		if(id == null || id.length() == 0)
		{
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 保存客户信息
	 * @return String
	 */
	public String saveCustomer()
	{
		
		customerInfo.setCompanyId(sessionCompanyId);
		customerInfo.setCreatorId(sessionUserId);
		if(customerInfo.getSalesmanId() != null && customerInfo.getSalesmanId().length() > 0)
		{
			
		}else
		{
			customerInfo.setSalesmanId(sessionUserId);
			customerInfo.setSalesman(sessionUserCName);
		}
		customerInfo.setCreateTime(Calendar.getInstance());
		CustomerInfo obj = null;
		if(customerInfo.getId() != null && customerInfo.getId().length() > 0)
		{
			obj =  customerInfoService.get(customerInfo.getId());
		}else
		{
			obj = new CustomerInfo();
		}
		
		obj.setAddress(customerInfo.getAddress());
		obj.setCategoryId(customerInfo.getCategoryId());
		obj.setCity(customerInfo.getCity());
		obj.setCompanyFullName(customerInfo.getCompanyFullName());
		obj.setCompanyId(customerInfo.getCompanyId());
		obj.setCreateTime(customerInfo.getCreateTime());
		obj.setCreatorId(customerInfo.getCreatorId());
		obj.setCustomerName(customerInfo.getCustomerName());
		obj.setDistrict(customerInfo.getDistrict());
		obj.setFax(customerInfo.getFax());
		obj.setLevelId(customerInfo.getLevelId());
		obj.setMaturityId(customerInfo.getMaturityId());
		obj.setOtherSalesmanId(customerInfo.getOtherSalesmanId());
		obj.setProgressId(customerInfo.getProgressId());
		obj.setProvince(customerInfo.getProvince());
		obj.setRegisterTime(customerInfo.getRegisterTime());
		obj.setSalesmanId(customerInfo.getSalesmanId());
		obj.setSalesman(customerInfo.getSalesman());
		obj.setSourceId(customerInfo.getSourceId());
		obj.setMainIndustry(customerInfo.getMainIndustry());
		obj.setPostCode(customerInfo.getPostCode());
		obj.setIntroduceTimes(customerInfo.getIntroduceTimes());
		customerInfoService.save(obj);
		id = obj.getId();
		return SUCCESS;
	}
	/**
	 * 删除客户信息
	 * @return String
	 */
	public String deleteCustomer()
	{
		customerInfoService.deleteCustomerInfo(ids);
		contractpersonInfoService.deleteContractPersonInfoByCustomerIds(ids);
		for(int i=0;i<ids.length;i++)
		{
			List<CustomerTraceInfo> listTrace = customerTraceInfoService.findAllCustomerTraceInfoByCustomerId(ids[i]);
			if(listTrace != null && listTrace.size() > 0)
			{
				for(int j=0;j<listTrace.size() ;j++)
				{
					CustomerTraceInfo obj = listTrace.get(j);
					if(obj != null)
					{
						obj.setDeleteFlag(1);
						customerTraceInfoService.save(obj);
					}
				}
			}
			List<CustomerVisitInfo> listVisit = customerVisitInfoService.findAllCustomerVisitInfoByCustomerId(ids[i]);
			if(listVisit != null && listVisit.size() > 0)
			{
				for(int j=0;j<listVisit.size() ;j++)
				{
					CustomerVisitInfo obj = listVisit.get(j);
					if(obj != null)
					{
						obj.setDeleteFlag(1);
						customerVisitInfoService.save(obj);
					}
				}
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 统计客户信息
	 * @return String
	 */
	public String staticCustomer()
	{
		companyId = sessionCompanyId;
		UserSession us = this.getSession();
		try
		{
			//判断是否是公司管理员或公司级用户
			boolean administratorFlag = popedomService.isHasPopedomByRoleKey(us,RoleFlag.GONG_SI_GUAN_LI_YUAN);
			boolean companyLeaderFlag = popedomService.isHasPopedomByRoleKey(us,RoleFlag.GONG_SI_LING_DAO);
			boolean deptLeaderFlag = popedomService.isHasPopedomByRoleKey(us,RoleFlag.BU_MEN_LING_DAO);
			boolean ywyFlag = popedomService.isHasPopedomByRoleKey(us,RoleFlag.YE_WU_YUAN);
			if(administratorFlag || companyLeaderFlag)
			{
				totalCustomerCount = customerInfoService.findAllCustomerInfoCount(companyId);
			}
			if(deptLeaderFlag)
			{
				totalCustomerCount = customerInfoService.findAllCustomerInfoCount(companyId , sessionDeptId,null);
			}
			if(ywyFlag)
			{
				totalCustomerCount = customerInfoService.findAllCustomerInfoCount(companyId , null , sessionUserId);
			}
			int sumCount = 0;
			
			if(flag.equals("category"))
			{
				if(administratorFlag || companyLeaderFlag)
				{
					listCategoryStatic = customerStaticInfoService.findAllCustomerStaticInfo(companyId,CustomerStaticInfo.CUSTOMER_CATEGORY);
				}
				if(deptLeaderFlag)
				{
					listCategoryStatic = customerStaticInfoService.findAllCustomerStaticInfo(companyId, sessionDeptId,null,CustomerStaticInfo.CUSTOMER_CATEGORY);
				}
				if(ywyFlag)
				{
					listCategoryStatic = customerStaticInfoService.findAllCustomerStaticInfo(companyId, null , sessionUserId,CustomerStaticInfo.CUSTOMER_CATEGORY);
				}
				
				
				for(int i=0;i<listCategoryStatic.size();i++)
				{
					sumCount = sumCount + listCategoryStatic.get(i).getCount();
				}
				if(sumCount < totalCustomerCount)
				{
					CustomerStaticInfo obj = new CustomerStaticInfo();
					obj.setCategory("其他");
					obj.setCount(totalCustomerCount - sumCount) ;
					obj.setKey(999);
					listCategoryStatic.add(obj);
				}
			}
			if(flag.equals("source"))
			{
				if(administratorFlag || companyLeaderFlag)
				{
					listSourceStatic = customerStaticInfoService.findAllCustomerStaticInfo(companyId,CustomerStaticInfo.CUSTOMER_SOURCE);
				}
				if(deptLeaderFlag)
				{
					listSourceStatic = customerStaticInfoService.findAllCustomerStaticInfo(companyId, sessionDeptId,null,CustomerStaticInfo.CUSTOMER_SOURCE);
				}
				if(ywyFlag)
				{
					listSourceStatic = customerStaticInfoService.findAllCustomerStaticInfo(companyId, null , sessionUserId,CustomerStaticInfo.CUSTOMER_SOURCE);
				}
				for(int i=0;i<listSourceStatic.size();i++)
				{
					sumCount = sumCount + listSourceStatic.get(i).getCount();
				}
				if(sumCount < totalCustomerCount)
				{
					CustomerStaticInfo obj = new CustomerStaticInfo();
					obj.setCategory("其他");
					obj.setCount(totalCustomerCount - sumCount) ;
					obj.setKey(999);
					listSourceStatic.add(obj);
				}
			}
			if(flag.equals("maturity"))
			{
				if(administratorFlag || companyLeaderFlag)
				{
					listMaturityStatic = customerStaticInfoService.findAllCustomerStaticInfo(companyId,CustomerStaticInfo.CUSTOMER_MATURITY);
				}
				if(deptLeaderFlag)
				{
					listMaturityStatic = customerStaticInfoService.findAllCustomerStaticInfo(companyId, sessionDeptId,null,CustomerStaticInfo.CUSTOMER_MATURITY);
				}
				if(ywyFlag)
				{
					listMaturityStatic = customerStaticInfoService.findAllCustomerStaticInfo(companyId, null , sessionUserId,CustomerStaticInfo.CUSTOMER_MATURITY);
				}
				for(int i=0;i<listMaturityStatic.size();i++)
				{
					sumCount = sumCount + listMaturityStatic.get(i).getCount();
				}
				if(sumCount < totalCustomerCount)
				{
					CustomerStaticInfo obj = new CustomerStaticInfo();
					obj.setCategory("其他");
					obj.setCount(totalCustomerCount - sumCount) ;
					obj.setKey(999);
					listMaturityStatic.add(obj);
				}
			}
			if(flag.equals("progress"))
			{
				if(administratorFlag || companyLeaderFlag)
				{
					listProgressStatic = customerStaticInfoService.findAllCustomerStaticInfo(companyId,CustomerStaticInfo.CUSTOMER_PROGRESS);
				}
				if(deptLeaderFlag)
				{
					listProgressStatic = customerStaticInfoService.findAllCustomerStaticInfo(companyId, sessionDeptId,null,CustomerStaticInfo.CUSTOMER_PROGRESS);
				}
				if(ywyFlag)
				{
					listProgressStatic = customerStaticInfoService.findAllCustomerStaticInfo(companyId, null , sessionUserId,CustomerStaticInfo.CUSTOMER_PROGRESS);
				}
				for(int i=0;i<listProgressStatic.size();i++)
				{
					sumCount = sumCount + listProgressStatic.get(i).getCount();
				}
				if(sumCount < totalCustomerCount)
				{
					CustomerStaticInfo obj = new CustomerStaticInfo();
					obj.setCategory("其他");
					obj.setCount(totalCustomerCount - sumCount) ;
					obj.setKey(999);
					listProgressStatic.add(obj);
				}
			}
			if(flag.equals("level"))
			{
				if(administratorFlag || companyLeaderFlag)
				{
					listLevelStatic = customerStaticInfoService.findAllCustomerStaticInfo(companyId,CustomerStaticInfo.CUSTOMER_LEVEL);
				}
				if(deptLeaderFlag)
				{
					listLevelStatic = customerStaticInfoService.findAllCustomerStaticInfo(companyId, sessionDeptId,null,CustomerStaticInfo.CUSTOMER_LEVEL);
				}
				if(ywyFlag)
				{
					listLevelStatic = customerStaticInfoService.findAllCustomerStaticInfo(companyId, null , sessionUserId,CustomerStaticInfo.CUSTOMER_LEVEL);
				}
				for(int i=0;i<listLevelStatic.size();i++)
				{
					sumCount = sumCount + listLevelStatic.get(i).getCount();
				}
				if(sumCount < totalCustomerCount)
				{
					CustomerStaticInfo obj = new CustomerStaticInfo();
					obj.setCategory("others");
					obj.setCount(totalCustomerCount - sumCount) ;
					obj.setKey(999);
					listLevelStatic.add(obj);
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		return SUCCESS;
	}
	
	public String getNewTraceAndVisitCount()
	{
		Map<String,Object> values = new HashMap<String,Object>();
		values.put("salesmanId", sessionUserId );
		UserSession us = this.getSession();
		try
		{
			//判断是否是公司管理员或公司级用户
			boolean deptLeaderFlag = popedomService.isHasPopedomByRoleKey(us,RoleFlag.BU_MEN_LING_DAO);
			boolean ywyFlag = popedomService.isHasPopedomByRoleKey(us,RoleFlag.YE_WU_YUAN);
			
			if( ywyFlag || deptLeaderFlag )
			{
				Calendar t1 = Calendar.getInstance();
				Calendar t2 = Calendar.getInstance();
				t2.add(Calendar.MINUTE, 10);
				
				values.put("beginDate",t1);
				values.put("endDate",t2);
				values.put("traceFlag", "0");
				values.put("visitFlag", "0");
				int traceCount = customerTraceInfoService.findCustomerTraceInfoCount(values);
				int visitCount = customerVisitInfoService.findCustomerVisitInfoCount(values);
				message = traceCount + "|" + visitCount;
			}else
			{
				message = "";
			}
		}catch(Exception ex)
		{
			
		}
		return SUCCESS;
	}
	
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public Pagination<CustomerInfo> getPagination() {
		return pagination;
	}
	public void setPagination(Pagination<CustomerInfo> pagination) {
		this.pagination = pagination;
	}
	public List<DataDictionary> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<DataDictionary> listCategory) {
		this.listCategory = listCategory;
	}
	public List<DataDictionary> getListSource() {
		return listSource;
	}
	public void setListSource(List<DataDictionary> listSource) {
		this.listSource = listSource;
	}
	public List<DataDictionary> getListProgress() {
		return listProgress;
	}
	public void setListProgress(List<DataDictionary> listProgress) {
		this.listProgress = listProgress;
	}
	public List<DataDictionary> getListMaturity() {
		return listMaturity;
	}
	public void setListMaturity(List<DataDictionary> listMaturity) {
		this.listMaturity = listMaturity;
	}
	public List<DataDictionary> getListLevel() {
		return listLevel;
	}
	public void setListLevel(List<DataDictionary> listLevel) {
		this.listLevel = listLevel;
	}
	public List<CityInfo> getListCity() {
		return listCity;
	}
	public void setListCity(List<CityInfo> listCity) {
		this.listCity = listCity;
	}
	public List<AreaInfo> getListArea() {
		return listArea;
	}
	public void setListArea(List<AreaInfo> listArea) {
		this.listArea = listArea;
	}
	public List<ContractPersonInfo> getListPerson() {
		return listPerson;
	}
	public void setListPerson(List<ContractPersonInfo> listPerson) {
		this.listPerson = listPerson;
	}
	public List<ProvinceInfo> getListProvince() {
		return listProvince;
	}
	public void setListProvince(List<ProvinceInfo> listProvince) {
		this.listProvince = listProvince;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContractorName() {
		return contractorName;
	}
	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}
	public String getCustomerCategory() {
		return customerCategory;
	}
	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}
	public String getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(String salesmanId) {
		this.salesmanId = salesmanId;
	}
	public int getiSearchMaxRecord() {
		return iSearchMaxRecord;
	}
	public void setiSearchMaxRecord(int iSearchMaxRecord) {
		this.iSearchMaxRecord = iSearchMaxRecord;
	}
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Deptment> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<Deptment> deptList) {
		this.deptList = deptList;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
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
	public boolean isCrmFlag() {
		return crmFlag;
	}
	public void setCrmFlag(boolean crmFlag) {
		this.crmFlag = crmFlag;
	}
	public boolean isErpFlag() {
		return erpFlag;
	}
	public void setErpFlag(boolean erpFlag) {
		this.erpFlag = erpFlag;
	}
	public boolean isTeamFlag() {
		return teamFlag;
	}
	public void setTeamFlag(boolean teamFlag) {
		this.teamFlag = teamFlag;
	}
	public String getTel() {
		return tel;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<CustomerInfo> getListCustomer() {
		return listCustomer;
	}
	public void setListCustomer(List<CustomerInfo> listCustomer) {
		this.listCustomer = listCustomer;
	}
	public int getTotalCustomerCount() {
		return totalCustomerCount;
	}
	public void setTotalCustomerCount(int totalCustomerCount) {
		this.totalCustomerCount = totalCustomerCount;
	}
	public List<CustomerStaticInfo> getListCategoryStatic() {
		return listCategoryStatic;
	}
	public void setListCategoryStatic(List<CustomerStaticInfo> listCategoryStatic) {
		this.listCategoryStatic = listCategoryStatic;
	}
	public List<CustomerStaticInfo> getListSourceStatic() {
		return listSourceStatic;
	}
	public void setListSourceStatic(List<CustomerStaticInfo> listSourceStatic) {
		this.listSourceStatic = listSourceStatic;
	}
	public List<CustomerStaticInfo> getListMaturityStatic() {
		return listMaturityStatic;
	}
	public void setListMaturityStatic(List<CustomerStaticInfo> listMaturityStatic) {
		this.listMaturityStatic = listMaturityStatic;
	}
	public List<CustomerStaticInfo> getListProgressStatic() {
		return listProgressStatic;
	}
	public void setListProgressStatic(List<CustomerStaticInfo> listProgressStatic) {
		this.listProgressStatic = listProgressStatic;
	}
	public List<CustomerStaticInfo> getListLevelStatic() {
		return listLevelStatic;
	}
	public void setListLevelStatic(List<CustomerStaticInfo> listLevelStatic) {
		this.listLevelStatic = listLevelStatic;
	}
}
