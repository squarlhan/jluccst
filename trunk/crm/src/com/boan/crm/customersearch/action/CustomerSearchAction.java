package com.boan.crm.customersearch.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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

import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.customersearch.model.ContractPersonLibInfo;
import com.boan.crm.customersearch.model.CustomerLibInfo;
import com.boan.crm.customersearch.service.IContractPersonLibService;
import com.boan.crm.customersearch.service.ICustomerLibInfoService;
import com.boan.crm.datadictionary.model.AreaInfo;
import com.boan.crm.datadictionary.model.CityInfo;
import com.boan.crm.datadictionary.model.ProvinceInfo;
import com.boan.crm.datadictionary.service.IAreaService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.converter.ParseBeanUtil;
import com.boan.crm.utils.io.impl.FileCopyAndDeleteUtilsAdaptor;
import com.boan.crm.utils.myenum.ProvinceEnum;
import com.boan.crm.utils.page.Pagination;
import com.boan.crm.utils.path.PathUtil;
import com.boan.crm.utils.uuid.MyUUIDGenerator;

@Controller("customerSearchAction")
@Scope("prototype")
public class CustomerSearchAction  extends BaseActionSupport{

	@Autowired
	@Qualifier("customerLibInfoService")
	//客户状态接口类
	private ICustomerLibInfoService customerInfoService;
	
	@Autowired
	@Qualifier("customerInfoService")
	//客户状态接口类
	private ICustomerInfoService customerService;
	
	// 客户状态接口类
	@Autowired
	@Qualifier("contractPersonService")
	private IContractPersonService contractpersonInfoService;
	
	// 客户状态接口类
	@Autowired
	@Qualifier("contractPersonLibService")
	private IContractPersonLibService contractpersonService;
		
	@Resource
	// 客户状态接口类
	private IAreaService areaService;
	
	private CustomerLibInfo customerLibInfo;
	
	private Pagination<CustomerLibInfo> pagination = new Pagination<CustomerLibInfo>();
	
	private String message;
	private String mainIndustry;
	List<ProvinceInfo> provinceList   = new ArrayList();
	List<CityInfo> cityList  = new ArrayList();
	List<AreaInfo> areaList   = new ArrayList();
	private String provinceId;
	private String cityId;
	private String areaId;
	
	private File uploadFile;
	private String uploadFileContentType = null;
	/**
	 * 上传导入文件的名称
	 */
	private String uploadFileFileName = null;
	
	public List<ProvinceInfo> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<ProvinceInfo> provinceList) {
		this.provinceList = provinceList;
	}

	public List<CityInfo> getCityList() {
		return cityList;
	}

	public void setCityList(List<CityInfo> cityList) {
		this.cityList = cityList;
	}

	public List<AreaInfo> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<AreaInfo> areaList) {
		this.areaList = areaList;
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

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	/**
	 * 查询客户
	 * @return
	 */
	public String openCustomerSearch(){
		provinceList = areaService.findAllProvinceInfo();
		return SUCCESS;
	}
	/**
	 * 查询客户
	 * @return
	 */
	public String customerSearch(){
		
		provinceList = areaService.findAllProvinceInfo();
		Map<String,String> values = new HashMap<String,String>();
	
		if(mainIndustry!=null && !mainIndustry.trim().equals("")){
			values.put("mainIndustry", mainIndustry);
		}
		if(provinceId!=null && !provinceId.trim().equals("")){
			values.put("provinceId", provinceId);
		}
		if(cityId!=null && !cityId.trim().equals("")){
			values.put("cityId", cityId);
		}
		ProvinceInfo province = areaService.getProvince(provinceId);
		String provincName = province.getProvinceName();
		pagination = customerInfoService.findCustomerLibInfoForPage(provincName , values, pagination);
		if(provinceId!=null){
			cityList = areaService.findCityInfoByProvinceId(provinceId);
		}
		if(cityId!=null){
			areaList = areaService.findAreaInfoByCityId(cityId);
		}
		return SUCCESS;
	}
	
	public void validateCustomerSearch(){
		provinceList = areaService.findAllProvinceInfo();
		ProvinceInfo province = areaService.getProvince(provinceId);
		if(province==null){
			message="没有对应省份数据，请联系管理员！";
			this.addFieldError("", "");
		}else{
			String provincName = province.getProvinceName();
			System.out.println(ProvinceEnum.getKeyByName(provincName));
			if(ProvinceEnum.getKeyByName(provincName)==null){
				message="没有对应省份数据，请联系管理员！";
				this.addFieldError("", "");
			}
		}
	}
	/**
	 * 转为客户
	 * @return
	 */
	public String toCustomer(){
		customerLibInfo = customerInfoService.get(customerLibInfo.getId());
		
		List<ContractPersonLibInfo> contractPersonInfoList = contractpersonService.findAllContractPersonLibInfoByCustomerId(customerLibInfo.getId());
		if(customerLibInfo!=null){
			CustomerInfo customerInfo =(CustomerInfo)ParseBeanUtil.parseBean(customerLibInfo, CustomerInfo.class);
			customerInfo.setId(null);
			customerInfo.setCompanyId(sessionCompanyId);
			customerInfo.setCompanyFullName(sessionCompanyName);
			customerInfo.setSalesman(sessionUserCName);
			customerInfo.setSalesmanId(sessionUserId);
			customerService.save(customerInfo);
			
			for(ContractPersonLibInfo temp : contractPersonInfoList){
				ContractPersonInfo contractPersonInfo = (ContractPersonInfo)ParseBeanUtil.parseBean(temp, ContractPersonInfo.class);
				contractPersonInfo.setId(null);
				contractPersonInfo.setCustomerId(customerInfo.getId());
				contractpersonInfoService.save(contractPersonInfo);
			}
		}
		message = "转入成功!";
		return SUCCESS;
	}
	
	public String toImportCustomerLib()
	{
		provinceList = areaService.findAllProvinceInfo();
		return SUCCESS;
	}
	
	public String importCustomerLib()
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
									
									
									CustomerLibInfo customer = new CustomerLibInfo();
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
									
									customer.setCompanyFullName(customerName);

									String customerAddressTemp = customerAddress.replaceAll("-", " ");
									customerAddressTemp = customerAddressTemp.replaceAll("市", "市 ");
									customerAddressTemp = customerAddressTemp.replaceAll("区", "区 ");
									customerAddressTemp = customerAddressTemp.replaceAll("县", "县 ");
									customerAddressTemp = customerAddressTemp.replaceAll("  ", " ");
									String[] customerAddressArray = customerAddressTemp.split(" ");
									boolean bProvinceFlag = false;
									boolean bCityFlag = false;
									for(int kk=0;kk<customerAddressArray.length - 1;kk++)
									{
										if(!customerAddressArray[kk].equals("中国"))
										{
											if(!bProvinceFlag)
											{
												ProvinceInfo province = areaService.getProvinceByName(customerAddressArray[kk]);
												if(province != null)
												{
													customer.setProvince(province.getId());
													bProvinceFlag = true;
													continue;
												}
											}
											if(!bCityFlag)
											{
												CityInfo city = areaService.getCityByName(customerAddressArray[kk]);
												if(city != null)
												{
													customer.setCity(city.getId());
													customer.setProvince(city.getProvinceId());
													bCityFlag = true;
													continue;
												}
											}
											AreaInfo area = areaService.getAreaByName(customerAddressArray[kk]);
											if(area != null)
											{
												customer.setDistrict(area.getId());
												customer.setCity(area.getCityId());
												continue;
											}
										}
									}
									ProvinceInfo province = areaService.getProvince(provinceId);
									if(province!=null){
										String provincName = province.getProvinceName();
										customerInfoService.save ( provincName , customer);
	//									customerInfoService.save(customer);
										
										ContractPersonLibInfo contractPerson = new ContractPersonLibInfo();
										contractPerson.setCustomerId(customer.getId());
										contractPerson.setPersonName(customerContractPersonName);
										contractPerson.setTel(customerTel);
										contractPerson.setPhone(customerPhone);
										contractPerson.setDeptOrDuty(customerContractDept);
										contractPerson.setEmail(customerEmail);
	
										contractpersonService.save(provincName,contractPerson);
									}
									
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
		return SUCCESS;
	}
	
	
	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
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

	public String getCity(){
		cityList = areaService.findCityInfoByProvinceId(provinceId);
		return SUCCESS;
	}
	public String getArea(){
		areaList = areaService.findAreaInfoByCityId(cityId);
		return SUCCESS;
	}

	public Pagination<CustomerLibInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<CustomerLibInfo> pagination) {
		this.pagination = pagination;
	}

	public String getMainIndustry() {
		return mainIndustry;
	}

	public void setMainIndustry(String mainIndustry) {
		this.mainIndustry = mainIndustry;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomerLibInfo getCustomerLibInfo() {
		return customerLibInfo;
	}

	public void setCustomerLibInfo(CustomerLibInfo customerLibInfo) {
		this.customerLibInfo = customerLibInfo;
	}
}
