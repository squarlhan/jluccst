/**
 * 
 */
package com.boan.crm.customersearch.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customersearch.dao.ICustomerLibInfoDAO;
import com.boan.crm.customersearch.model.ContractPersonLibInfo;
import com.boan.crm.customersearch.model.CustomerLibInfo;
import com.boan.crm.customersearch.model.CustomerLibInfoViewAndSellerRelation;
import com.boan.crm.customersearch.model.CustomerLib_AnHui;
import com.boan.crm.customersearch.model.CustomerLib_AoMen;
import com.boan.crm.customersearch.model.CustomerLib_BeiJing;
import com.boan.crm.customersearch.model.CustomerLib_ChongQing;
import com.boan.crm.customersearch.model.CustomerLib_FuJian;
import com.boan.crm.customersearch.model.CustomerLib_GanSu;
import com.boan.crm.customersearch.model.CustomerLib_GuangDong;
import com.boan.crm.customersearch.model.CustomerLib_GuangXi;
import com.boan.crm.customersearch.model.CustomerLib_GuiZhou;
import com.boan.crm.customersearch.model.CustomerLib_HaiNan;
import com.boan.crm.customersearch.model.CustomerLib_HeBei;
import com.boan.crm.customersearch.model.CustomerLib_HeNan;
import com.boan.crm.customersearch.model.CustomerLib_HeiLongJiang;
import com.boan.crm.customersearch.model.CustomerLib_HuBei;
import com.boan.crm.customersearch.model.CustomerLib_HuNan;
import com.boan.crm.customersearch.model.CustomerLib_JiLin;
import com.boan.crm.customersearch.model.CustomerLib_JiangSu;
import com.boan.crm.customersearch.model.CustomerLib_JiangXi;
import com.boan.crm.customersearch.model.CustomerLib_LiaoNing;
import com.boan.crm.customersearch.model.CustomerLib_NeiMeng;
import com.boan.crm.customersearch.model.CustomerLib_NingXia;
import com.boan.crm.customersearch.model.CustomerLib_QingHai;
import com.boan.crm.customersearch.model.CustomerLib_ShanDong;
import com.boan.crm.customersearch.model.CustomerLib_ShanXi;
import com.boan.crm.customersearch.model.CustomerLib_ShanXi2;
import com.boan.crm.customersearch.model.CustomerLib_ShangHai;
import com.boan.crm.customersearch.model.CustomerLib_SiChuan;
import com.boan.crm.customersearch.model.CustomerLib_TaiWan;
import com.boan.crm.customersearch.model.CustomerLib_TianJin;
import com.boan.crm.customersearch.model.CustomerLib_XiZang;
import com.boan.crm.customersearch.model.CustomerLib_XiangGang;
import com.boan.crm.customersearch.model.CustomerLib_XinJiang;
import com.boan.crm.customersearch.model.CustomerLib_YunNan;
import com.boan.crm.customersearch.model.CustomerLib_ZheJiang;
import com.boan.crm.customersearch.service.IContractPersonLibService;
import com.boan.crm.customersearch.service.ICustomerLibInfoService;
import com.boan.crm.customersearch.service.INoSearchCustomersService;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.utils.converter.ParseBeanUtil;
import com.boan.crm.utils.myenum.ProvinceEnum;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 * 客户信息服务接口实现类
 */
@Service("customerLibInfoService")
public class CustomerLibInfoServiceImpl implements ICustomerLibInfoService{
	@Autowired
	@Qualifier("customerLibInfoDao")
	private ICustomerLibInfoDAO customerLibInfoDao; 
	/**
	 * 权限接口
	 */
	@Autowired
	@Qualifier("dataDictionaryService")
	private IDataDictionaryService dataDictionaryService = null;
	
	/**
	 * 权限接口
	 */
	@Autowired
	@Qualifier("contractPersonLibService")
	private IContractPersonLibService contractPersonService = null;
	
	// 处理不再查询客户的接口类
	@Autowired
	@Qualifier("noSearchCustomersService")
	private INoSearchCustomersService noSearchCustomersService;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Override
	public void deleteCustomerLibInfo(String... ids) {
		customerLibInfoDao.delete(ids);
	}

	@Override
	public List<CustomerLibInfo> findAllCustomerLibInfo() {
		return customerLibInfoDao.find("from CustomerLibInfo where noSearch=0 order by registerTime asc", new Object[0]);
	}

	@Override
	public Pagination<CustomerLibInfo> findCustomerLibInfoForPage( Map<String, ?> values, Pagination<CustomerLibInfo> pagination) {
		StringBuilder hql = new StringBuilder();
		hql.append( "from CustomerLibInfoView where 1=1 and noSearch=0 ");
		
		if(values.get("companyId") != null)
		{
			hql.append(" and companyId =:companyId");
		}
		if(values.get("mainIndustry") != null)
		{
			hql.append(" and mainIndustry like '%"+values.get("mainIndustry") +"%' ");
		}
		if(values.get("provinceId") != null)
		{
			hql.append(" and province = :provinceId ");
		}
		if(values.get("cityId") != null)
		{
			hql.append(" and city = :cityId ");
		}
		if(values.get("areaId") != null)
		{
			hql.append(" and district = :areaId ");
		}
		
		hql.append(" order by registerTime asc");
		List tempList = customerLibInfoDao.findForPage(hql.toString(), values, pagination.getStartIndex(), pagination.getPageSize());
		hql.delete(0, hql.length());
		hql.append(" select count(*) from CustomerLibInfoView where 1=1 and noSearch=0 " );
		if(values.get("mainIndustry") != null)
		{
			hql.append(" and mainIndustry like '%"+values.get("mainIndustry") +"%' ");
		}
		if(values.get("provinceId") != null)
		{
			hql.append(" and province = :provinceId ");
		}
		if(values.get("cityId") != null)
		{
			hql.append(" and city = :cityId ");
		}
		if(values.get("areaId") != null)
		{
			hql.append(" and district = :areaId ");
		}
		List<CustomerLibInfo> data = new ArrayList<CustomerLibInfo>();
		for(int i=0;i<tempList.size();i++){
			CustomerLibInfo customerInfo =(CustomerLibInfo)ParseBeanUtil.parseBean(tempList.get(i), CustomerLibInfo.class);
			data.add(customerInfo);
		}
		
		int totalRows = customerLibInfoDao.findCountForPage(hql.toString(), values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		
		List<CustomerLibInfo> list = pagination.getData();
		if(list != null && list.size() > 0)
		{
			for(int i=0;i< list.size();i++)
			{
				CustomerLibInfo customerLibInfo = list.get(i);
				DataDictionary d1 = dataDictionaryService.get(customerLibInfo.getCategoryId());
				if(d1 != null)
				{
					customerLibInfo.setCategory(d1.getName());
				}
				
				d1 = dataDictionaryService.get(customerLibInfo.getMaturityId()); 
				if(d1 != null)
				{
					customerLibInfo.setMaturity(d1.getName());
				}
				d1 = dataDictionaryService.get(customerLibInfo.getSourceId());
				if(d1 != null)
				{
					customerLibInfo.setSource(d1.getName());
				}
				
				try
				{
					User salesman = userService.getUserById(customerLibInfo.getSalesmanId());
					if(salesman != null)
					{
						customerLibInfo.setSalesman(salesman.getUserCName());
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				List temp  = contractPersonService.findAllContractPersonLibInfoByCustomerId(customerLibInfo.getId());
				List<ContractPersonLibInfo> aa = new ArrayList<ContractPersonLibInfo>();
				for(int n =0;n<temp.size();n++){
					ContractPersonLibInfo customerInfo =(ContractPersonLibInfo)ParseBeanUtil.parseBean(temp.get(n), ContractPersonLibInfo.class);
					aa.add(customerInfo);
				}
				customerLibInfo.setContractPersonList(aa);
				
			}
		}
		return pagination;
	}
	
	//@Override
	public Pagination<CustomerLibInfo> findCustomerLibInfoForPage( Map<String, ?> values, Pagination<CustomerLibInfo> pagination,String sellerId) {
		StringBuilder hql = new StringBuilder();
		hql.append( "from CustomerLibInfoView where 1=1 and noSearch=0 ");
		
		if(values.get("mainIndustry") != null)
		{
			hql.append(" and mainIndustry like '%"+values.get("mainIndustry") +"%' ");
		}
		if(values.get("provinceId") != null)
		{
			hql.append(" and province = :provinceId ");
		}
		if(values.get("cityId") != null)
		{
			hql.append(" and city = :cityId ");
		}
		if(values.get("areaId") != null)
		{
			hql.append(" and district = :areaId ");
		}
		hql.append(" and id in ( select temp.customerLibInfoViewId from CustomerLibInfoViewAndSellerRelation temp  where temp.noSearch=0 and temp.sellerId='"+sellerId+"') ");
		
		hql.append(" order by registerTime asc");
		List tempList = customerLibInfoDao.findForPage(hql.toString(), values, pagination.getStartIndex(), pagination.getPageSize());
		hql.delete(0, hql.length());
		hql.append(" select count(*) from CustomerLibInfoView where 1=1 and noSearch=0 " );
		if(values.get("mainIndustry") != null)
		{
			hql.append(" and mainIndustry like '%"+values.get("mainIndustry") +"%' ");
		}
		if(values.get("provinceId") != null)
		{
			hql.append(" and province = :provinceId ");
		}
		if(values.get("cityId") != null)
		{
			hql.append(" and city = :cityId ");
		}
		if(values.get("areaId") != null)
		{
			hql.append(" and district = :areaId ");
		}
		hql.append(" and id in ( select temp.customerLibInfoViewId from CustomerLibInfoViewAndSellerRelation temp  where temp.noSearch=0 and temp.sellerId='"+sellerId+"') ");
		List<CustomerLibInfo> data = new ArrayList<CustomerLibInfo>();
		for(int i=0;i<tempList.size();i++){
			CustomerLibInfo customerInfo =(CustomerLibInfo)ParseBeanUtil.parseBean(tempList.get(i), CustomerLibInfo.class);
			data.add(customerInfo);
		}
		
		int totalRows = customerLibInfoDao.findCountForPage(hql.toString(), values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		
		List<CustomerLibInfo> list = pagination.getData();
		if(list != null && list.size() > 0)
		{
			for(int i=0;i< list.size();i++)
			{
				CustomerLibInfo customerLibInfo = list.get(i);
				DataDictionary d1 = dataDictionaryService.get(customerLibInfo.getCategoryId());
				if(d1 != null)
				{
					customerLibInfo.setCategory(d1.getName());
				}
				
				d1 = dataDictionaryService.get(customerLibInfo.getMaturityId()); 
				if(d1 != null)
				{
					customerLibInfo.setMaturity(d1.getName());
				}
				d1 = dataDictionaryService.get(customerLibInfo.getSourceId());
				if(d1 != null)
				{
					customerLibInfo.setSource(d1.getName());
				}
				
				try
				{
					User salesman = userService.getUserById(customerLibInfo.getSalesmanId());
					if(salesman != null)
					{
						customerLibInfo.setSalesman(salesman.getUserCName());
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				List temp  = contractPersonService.findAllContractPersonLibInfoByCustomerId(customerLibInfo.getId());
				List<ContractPersonLibInfo> aa = new ArrayList<ContractPersonLibInfo>();
				for(int n =0;n<temp.size();n++){
					ContractPersonLibInfo customerInfo =(ContractPersonLibInfo)ParseBeanUtil.parseBean(temp.get(n), ContractPersonLibInfo.class);
					aa.add(customerInfo);
				}
				customerLibInfo.setContractPersonList(aa);
				
			}
		}
		return pagination;
	}

	@Override
	public CustomerLibInfo get(String id) {
		return customerLibInfoDao.get(id);
	}
	
	/**
	 * 根据id获取客户
	 */
	@Override
	public CustomerLibInfo getCustomerLibInfoView(String id){
		String hql = "from CustomerLibInfoView where id=:id";
		Map param = new HashMap();
		param.put("id", id);
		CustomerLibInfo customerInfo =null;
		List data = customerLibInfoDao.find(hql, param);
		for(int i=0;i<data.size();i++){
			customerInfo =(CustomerLibInfo)ParseBeanUtil.parseBean(data.get(i), CustomerLibInfo.class);
		}
		return customerInfo;
	}


	@Override
	public void save(CustomerLibInfo CustomerLibInfo) {
		customerLibInfoDao.saveOrUpdate(CustomerLibInfo);
	}
	
	
	/**
	 * 查找全部客户
	 * @param province 省份中文名
	 * @return
	 */
	public List<CustomerLibInfo> findAllCustomerLibInfo(String province ){
		String provincKey = "CustomerLib_"+ ProvinceEnum.getKeyByName(province);
		return customerLibInfoDao.find("from " + provincKey +" where noSearch=0  order by registerTime asc", new Object[0]);
	}

	/**
	 * 查找指定省份中有无客户
	 * @param province 省份中文名
	  @param province 客户名称（公司名称）
	 * @return true：指定省份中已经存在该公司
	 */
	public boolean existCustomerInLib(String province,String customerName ){
		String provincKey = "CustomerLib_"+ ProvinceEnum.getKeyByName(province);
		List list = customerLibInfoDao.find("from " + provincKey +" where customerName='"+customerName+"'  and noSearch=0 order by registerTime asc", new Object[0]);
		return list!=null && list.size()>0 &&  list.get(0)!=null ? true : false;
	}
	
	/**
	 * 根据id获取客户
	 * @param province 省份
	 */
	public CustomerLibInfo get(String province , String id){
		String provincKey = "CustomerLib_"+ ProvinceEnum.getKeyByName(province);
		Map param = new HashMap();
		param.put("id", id);
		List list = customerLibInfoDao.find("from " + provincKey +" where  noSearch=0  and id=:id", param);
		return list!=null && list.get(0)!=null ? (CustomerLibInfo)list.get(0) : null;
	}


	/**
	 * 根据id删除客户
	 * @param province 省份
	 */
	public void deleteCustomerLibInfo(String province ,String... ids){
		String provincKey = "CustomerLib_"+ ProvinceEnum.getKeyByName(province);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("ids", ids);
		customerLibInfoDao.executeHql("delete from "+provincKey+"  where id in (:ids)", param);
	}


	/**
	 * 保存客户
	 * @param provinc 省份中文名
	 */
	public void save(String province ,CustomerLibInfo info){
		String provincKey = ProvinceEnum.getKeyByName(province);
		if(provincKey!=null && !provincKey.equals("")){
			if(provincKey.equals("AnHui")){
				CustomerLib_AnHui customerInfo =(CustomerLib_AnHui)ParseBeanUtil.parseBean(info, CustomerLib_AnHui.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("AoMen")){
				CustomerLib_AoMen customerInfo =(CustomerLib_AoMen)ParseBeanUtil.parseBean(info, CustomerLib_AoMen.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("BeiJing")){
				CustomerLib_BeiJing customerInfo =(CustomerLib_BeiJing)ParseBeanUtil.parseBean(info, CustomerLib_BeiJing.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("ChongQing")){
				CustomerLib_ChongQing customerInfo =(CustomerLib_ChongQing)ParseBeanUtil.parseBean(info, CustomerLib_ChongQing.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("FuJian")){
				CustomerLib_FuJian customerInfo =(CustomerLib_FuJian)ParseBeanUtil.parseBean(info, CustomerLib_FuJian.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("GanSu")){
				CustomerLib_GanSu customerInfo =(CustomerLib_GanSu)ParseBeanUtil.parseBean(info, CustomerLib_GanSu.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("GuangDong")){
				CustomerLib_GuangDong customerInfo =(CustomerLib_GuangDong)ParseBeanUtil.parseBean(info, CustomerLib_GuangDong.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("GuangXi")){
				CustomerLib_GuangXi customerInfo =(CustomerLib_GuangXi)ParseBeanUtil.parseBean(info, CustomerLib_GuangXi.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("GuiZhou")){
				CustomerLib_GuiZhou customerInfo =(CustomerLib_GuiZhou)ParseBeanUtil.parseBean(info, CustomerLib_GuiZhou.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("HaiNan")){
				CustomerLib_HaiNan customerInfo =(CustomerLib_HaiNan)ParseBeanUtil.parseBean(info, CustomerLib_HaiNan.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("HeBei")){
				CustomerLib_HeBei customerInfo =(CustomerLib_HeBei)ParseBeanUtil.parseBean(info, CustomerLib_HeBei.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("HeiLongJiang")){
				CustomerLib_HeiLongJiang customerInfo =(CustomerLib_HeiLongJiang)ParseBeanUtil.parseBean(info, CustomerLib_HeiLongJiang.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("HeNan")){
				CustomerLib_HeNan customerInfo =(CustomerLib_HeNan)ParseBeanUtil.parseBean(info, CustomerLib_HeNan.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("HuBei")){
				CustomerLib_HuBei customerInfo =(CustomerLib_HuBei)ParseBeanUtil.parseBean(info, CustomerLib_HuBei.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("HuNan")){
				CustomerLib_HuNan customerInfo =(CustomerLib_HuNan)ParseBeanUtil.parseBean(info, CustomerLib_HuNan.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("JiangSu")){
				CustomerLib_JiangSu customerInfo =(CustomerLib_JiangSu)ParseBeanUtil.parseBean(info, CustomerLib_JiangSu.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("JiangXi")){
				CustomerLib_JiangXi customerInfo =(CustomerLib_JiangXi)ParseBeanUtil.parseBean(info, CustomerLib_JiangXi.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("JiLin")){
				CustomerLib_JiLin customerInfo =(CustomerLib_JiLin)ParseBeanUtil.parseBean(info, CustomerLib_JiLin.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("LiaoNing")){
				CustomerLib_LiaoNing customerInfo =(CustomerLib_LiaoNing)ParseBeanUtil.parseBean(info, CustomerLib_LiaoNing.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("NeiMeng")){
				CustomerLib_NeiMeng customerInfo =(CustomerLib_NeiMeng)ParseBeanUtil.parseBean(info, CustomerLib_NeiMeng.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("NingXia")){
				CustomerLib_NingXia customerInfo =(CustomerLib_NingXia)ParseBeanUtil.parseBean(info, CustomerLib_NingXia.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("QingHai")){
				CustomerLib_QingHai customerInfo =(CustomerLib_QingHai)ParseBeanUtil.parseBean(info, CustomerLib_QingHai.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("ShanDong")){
				CustomerLib_ShanDong customerInfo =(CustomerLib_ShanDong)ParseBeanUtil.parseBean(info, CustomerLib_ShanDong.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("ShangHai")){
				CustomerLib_ShangHai customerInfo =(CustomerLib_ShangHai)ParseBeanUtil.parseBean(info, CustomerLib_ShangHai.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("ShanXi")){
				CustomerLib_ShanXi customerInfo =(CustomerLib_ShanXi)ParseBeanUtil.parseBean(info, CustomerLib_ShanXi.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("ShanXi2")){
				CustomerLib_ShanXi2 customerInfo =(CustomerLib_ShanXi2)ParseBeanUtil.parseBean(info, CustomerLib_ShanXi2.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("SiChuan")){
				CustomerLib_SiChuan customerInfo =(CustomerLib_SiChuan)ParseBeanUtil.parseBean(info, CustomerLib_SiChuan.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("TaiWan")){
				CustomerLib_TaiWan customerInfo =(CustomerLib_TaiWan)ParseBeanUtil.parseBean(info, CustomerLib_TaiWan.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("TianJin")){
				CustomerLib_TianJin customerInfo =(CustomerLib_TianJin)ParseBeanUtil.parseBean(info, CustomerLib_TianJin.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("XiangGang")){
				CustomerLib_XiangGang customerInfo =(CustomerLib_XiangGang)ParseBeanUtil.parseBean(info, CustomerLib_XiangGang.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("XinJiang")){
				CustomerLib_XinJiang customerInfo =(CustomerLib_XinJiang)ParseBeanUtil.parseBean(info, CustomerLib_XinJiang.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("XiZang")){
				CustomerLib_XiZang customerInfo =(CustomerLib_XiZang)ParseBeanUtil.parseBean(info, CustomerLib_XiZang.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("YunNan")){
				CustomerLib_YunNan customerInfo =(CustomerLib_YunNan)ParseBeanUtil.parseBean(info, CustomerLib_YunNan.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
			if(provincKey.equals("ZheJiang")){
				CustomerLib_ZheJiang customerInfo =(CustomerLib_ZheJiang)ParseBeanUtil.parseBean(info, CustomerLib_ZheJiang.class);
				customerLibInfoDao.save(customerInfo);
				info.setId(customerInfo.getId());
			}
		}
	}


	/**
	 * 按分页查询客户
	 * @param province 省份
	 */
	public Pagination<CustomerLibInfo> findCustomerLibInfoForPage(String province , Map<String, ?> values, Pagination<CustomerLibInfo> pagination,String company_Id ,String salesmanId){
		
//		List<String> noSearchCustomerLibIds=  noSearchCustomersService.findCustomerLibIds(salesmanId);
		
		String provincKey = "CustomerLib_"+ ProvinceEnum.getKeyByName(province);
		StringBuilder hql = new StringBuilder();
		hql.append( "from " + provincKey +" where 1=1 and  noSearch=0 ");
		
		if(values.get("mainIndustry") != null)
		{
			hql.append(" and (mainIndustry like '%"+values.get("mainIndustry") +"%' ");
			hql.append(" or customerName like '%"+values.get("mainIndustry") +"%' ");
			hql.append(" or companyFullName like '%"+values.get("mainIndustry") +"%' )");
		}
		if(values.get("provinceId") != null)
		{
//			hql.append(" and province = :provinceId ");
		}
		if(values.get("cityId") != null)
		{
			hql.append(" and city = :cityId ");
		}
		if(values.get("areaId") != null)
		{
			hql.append(" and district = :areaId ");
		}
		if(salesmanId!=null){
			//hql.append(" and id not in (Select customerLibId from NoSearchCustomers where company_Id = '"+company_Id+"' and salesmanId='"+salesmanId+"') ");
			hql.append(" and id not in (Select customerLibId from NoSearchCustomers where company_Id = '"+company_Id+"' ) ");
		}
		
		hql.append(" order by registerTime asc");
		List<CustomerLibInfo> data = customerLibInfoDao.findForPage(hql.toString(), values, pagination.getStartIndex(), pagination.getPageSize());
		hql.delete(0, hql.length());
		hql.append(" select count(*) from " + provincKey +" where 1=1 and  noSearch=0 " );
		if(values.get("mainIndustry") != null)
		{
			hql.append(" and (mainIndustry like '%"+values.get("mainIndustry") +"%' ");
			hql.append(" or customerName like '%"+values.get("mainIndustry") +"%' ");
			hql.append(" or companyFullName like '%"+values.get("mainIndustry") +"%' )");
		}
		if(values.get("provinceId") != null)
		{
//			hql.append(" and province = :provinceId ");
		}
		if(values.get("cityId") != null)
		{
			hql.append(" and city = :cityId ");
		}
		if(values.get("areaId") != null)
		{
			hql.append(" and district = :areaId ");
		}
		if(salesmanId!=null){
			//hql.append(" and id not in (Select customerLibId from NoSearchCustomers where company_Id = '"+company_Id+"' and  salesmanId='"+salesmanId+"') ");
			hql.append(" and id not in (Select customerLibId from NoSearchCustomers where company_Id = '"+company_Id+"' ) ");
		}
		
		int totalRows = customerLibInfoDao.findCountForPage(hql.toString(), values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		
		List<CustomerLibInfo> list = pagination.getData();
		if(list != null && list.size() > 0)
		{
			for(int i=0;i< list.size();i++)
			{
				CustomerLibInfo customerLibInfo = list.get(i);
				DataDictionary d1 = dataDictionaryService.get(customerLibInfo.getCategoryId());
				if(d1 != null)
				{
					customerLibInfo.setCategory(d1.getName());
				}
				
				d1 = dataDictionaryService.get(customerLibInfo.getMaturityId()); 
				if(d1 != null)
				{
					customerLibInfo.setMaturity(d1.getName());
				}
				d1 = dataDictionaryService.get(customerLibInfo.getSourceId());
				if(d1 != null)
				{
					customerLibInfo.setSource(d1.getName());
				}
				
				try
				{
					User salesman = userService.getUserById(customerLibInfo.getSalesmanId());
					if(salesman != null)
					{
						customerLibInfo.setSalesman(salesman.getUserCName());
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				customerLibInfo.setContractPersonList(contractPersonService.findAllContractPersonLibInfoByCustomerId(province,customerLibInfo.getId()));
				
			}
		}
		return pagination;
	}
	
	/**
	 * 修改不查询列
	 * @param province 省份
	 * @param customerId 客户Id
	 * @param flag 0：查询 1：不查询
	 */
	public void updateNoSearchColumn(String province,String customerId,int flag){
		String provincKey = "CustomerLib_"+ ProvinceEnum.getKeyByName(province);
		StringBuilder hql = new StringBuilder();
		hql.append( "update " + provincKey +" set noSearch=:flag where id=:id");
		Map param = new HashMap();
		param.put("id", customerId);
		param.put("flag", flag);
		customerLibInfoDao.executeHql(hql.toString(), param);
	}
	
	/**
	 * 修改重要客户标识
	 * @param customerId 客户Id
	 * @param flag 0：一般客户 1：重要客户
	 */
	public void updateImportantFlag(String customerId,int flag){
		StringBuilder hql = new StringBuilder();
		hql.append( "update CustomerLibInfoView set importantFlag=:flag where id=:id");
		Map param = new HashMap();
		param.put("id", customerId);
		param.put("flag", flag);
		customerLibInfoDao.executeHql(hql.toString(), param);
	}
}
