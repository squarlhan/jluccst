package com.boan.crm.sms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.sms.dao.ISMSCustomerInfoDao;
import com.boan.crm.sms.model.SMSCustomerInfo;
import com.boan.crm.sms.service.ISMSCustomerInfoService;
import com.boan.crm.utils.pinyin.PinYin4J;

@Service("SMSCustomerInfoService")
public class SMSCustomerInfoServiceImpl implements ISMSCustomerInfoService {

	@Autowired
	@Qualifier("SMSCustomerInfoDao")
	private ISMSCustomerInfoDao dao;
	
	/**
	 * 保存短信通讯录信息
	 * @param info
	 */
	public void saveSMSCustomerInfo(SMSCustomerInfo info){
		if(info!=null && info.getName()!=null &&  !info.getName().trim().equals("")){
			info.setNameSpell( PinYin4J.makeStringByStringSet(PinYin4J.getPinyin(info.getName())));
			dao.save(info);
		}
	}
	
	/**
	 * 修改短信通讯录信息
	 * @param info
	 */
	public void updateSMSCustomerInfo(SMSCustomerInfo info){
		dao.update(info);
	}
	
	/**
	 * 通过客户Id查询相应通讯录信息
	 * @param customerId 客户Id
	 * @param info
	 */
	public SMSCustomerInfo getSMSCustomerInfoByCustomerId(String customerId){
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("customerId", customerId);
		String hql ="from SMSCustomerInfo where customerId=:customerId ";
		List<SMSCustomerInfo> temp = dao.find(hql, values);
		SMSCustomerInfo obj =  null;
		if(temp!=null && temp.size()>0 ){
			if(temp.get(0)!=null){
				obj = temp.get(0);
			}
		}
		return obj;
	}
	
	/**
	 * 修改客户联系人时调用
	 * @param customerId
	 * @param info
	 */
	public void updateSMSCustomerInfoForCustomer(String customerId , SMSCustomerInfo info){
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("customerId", customerId);
		String hql ="from SMSCustomerInfo where customerId=:customerId ";
		List<SMSCustomerInfo> temp = dao.find(hql, values);
		String id=null;
		SMSCustomerInfo obj =  null;
		if(temp!=null && temp.size()>0 ){
			if(temp.get(0)!=null){
				obj = temp.get(0);
				id = obj.getId();
				
			}
		}
		obj.setAppellation(info.getAppellation());
		obj.setBirthday(info.getBirthday());
		obj.setCategoryId(info.getCategoryId());
		obj.setCreateTime(info.getCreateTime());
		obj.setCustomerId((info.getCustomerId()));
		obj.setEmail(info.getEmail());
		obj.setFaxes(info.getFaxes());
		obj.setIsLunarCalender(info.getIsLunarCalender());
		obj.setName(info.getName());
		obj.setNameSpell(info.getNameSpell());
		obj.setNameSpell( PinYin4J.makeStringByStringSet(PinYin4J.getPinyin(info.getName())));
		obj.setNickname(info.getNickname());
		obj.setOrganId(info.getOrganId());
		obj.setOrganId(info.getOrganId());
		obj.setPhone(info.getPhone());
		obj.setPost(info.getPost());
		obj.setPostalcode(info.getPostalcode());
		obj.setQq(info.getQq());
		obj.setSalesmanId(info.getSalesmanId());
		obj.setSex(info.getSex());
		obj.setUnit(info.getUnit());
		obj.setUnitAddress(info.getUnitAddress());
		dao.update(obj);
	}
	
	/**
	 * 修改短信通讯录信息状态
	 * @param id
	 * @param state
	 */
	public void updateSMSCustomerInfoState(String id,int state){
	}
	
	/**
	 * 删除短信通讯录信息
	 * @param ids
	 */
	public void deleteSMSCustomerInfo(String... ids){
		dao.delete(ids);
	}
	
	/**
	 * 删除短信通讯录信息（此方法用于客户删除是，删除短信客户表里面相应信息的）
	 * @param customerIds 客户表Id
	 */
	public void deleteSMSCustomerInfoFoCustomer(String... customerIds){
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("customerIds", customerIds);
		String hql="delete from SMSCustomerInfo where customerId in (:customerIds)";
		dao.executeHql(hql, values);
	}
	/**
	 * 查询所有短信通讯录信息
	 * @return
	 */
	public List<SMSCustomerInfo> findAllSMSCustomerInfo(String companyId , String salesmanId,String provinceId,String cityId,String areaId,String categoryId,String progressId){
		String hql ="";
//		if(companyId!=null && !companyId.equals("")){
//			hql = "from SMSCustomerInfo where organId='"+companyId+"' order by createTime asc";
//		}else{
//			hql = "from SMSCustomerInfo order by createTime asc";
//		}
		
		hql = "   from SMSCustomerInfo where " + 
				"   ( categoryId='2'  and organId='"+companyId+"'  and phone is not null and phone <>'' ) " +
				"   or " + 
				"   customerId in ( " +
				"		select A.id from ContractPersonInfo A, CustomerInfo B  where B.id=A.customerId "+
				"   	and B.deleteFlag=0 and B.salesmanId='"+salesmanId+"' and B.companyId='"+companyId+"'";
				if(!provinceId.equals("")){
					hql = hql + " and B.province='"+provinceId+"'";
				}
				if(!cityId.equals("")){
					hql = hql + " and B.city='"+cityId+"'";
				}
				if(!areaId.equals("")){
					hql = hql + " and B.district='"+areaId+"'";
				}
				if(!categoryId.equals("")){
					hql = hql + " and B.categoryId='"+categoryId+"'";
				}
				if(!progressId.equals("")){
					hql = hql + " and B.progressId='"+progressId+"'";
				}
				hql = hql + "   	and A.phone is not null and A.phone <>''"+
				"	) order by categoryId, nameSpell asc" ;
		
		return dao.find(hql , new Object[0]);
	}
	
	/**
	 *  查询指定类型的短信通讯录信息
	 * @param type 1：客户 2：销售员
	 * @return
	 */
	public List<SMSCustomerInfo> findAllSMSCustomerInfoByType(String companyId , String salesmanId, int type,String provinceId,String cityId,String areaId,String categoryId,String progressId){
		String hql ="";
//		if(companyId!=null && !companyId.equals("")){
//			hql = "from SMSCustomerInfo where  categoryId='"+type+"'  and  organId='"+companyId+"' order by createTime asc";
//		}else{
//			hql ="from SMSCustomerInfo where  categoryId='"+type+"' order by createTime asc";
//		}
		
		
		if(type==1){ //是客户
		hql = "from SMSCustomerInfo where " + 
			"   ( categoryId='1'  and organId='"+companyId+"' and phone is not null and phone <>'' ) " +
			"   and " + 
			"   customerId in ( " +
			"		select A.id from ContractPersonInfo A, CustomerInfo B  where B.id=A.customerId "+
			"   	and B.deleteFlag=0 and B.salesmanId='"+salesmanId+"' and B.companyId='"+companyId+"' ";
			
			if(!provinceId.equals("")){
				hql = hql + " and B.province='"+provinceId+"'";
			}
			if(!cityId.equals("")){
				hql = hql + " and B.city='"+cityId+"'";
			}
			if(!areaId.equals("")){
				hql = hql + " and B.district='"+areaId+"'";
			}
			if(!categoryId.equals("")){
				hql = hql + " and B.categoryId='"+categoryId+"'";
			}
			if(!progressId.equals("")){
				hql = hql + " and B.progressId='"+progressId+"'";
			}
			
			hql = hql +"   	and A.phone is not null and A.phone <>''"+
			"	) order by categoryId, nameSpell asc" ;
		}else if(type==2){ //工作人员
			hql = "from SMSCustomerInfo where " + 
					"   ( categoryId='2'  and organId='"+companyId+"' and phone is not null and phone <>'' ) order by categoryId, nameSpell asc" ;
		}
		return dao.find(hql, new Object[0]);
	}
	
	/**
	 * 查询所有短信通讯录信息
	 * @return
	 */
	public int findSMSCustomerInfoCountForPage( Map<String, ?> values){
		String nameSpell="";
		if(values.containsKey("nameSpell")){
			nameSpell=" and nameSpell like '%"+values.get("nameSpell")+"%'";
		}
//		String categoryId="";
//		if(values.containsKey("categoryId")){
//			categoryId=" and categoryId=:categoryId ";
//		}
		String organId="";
		if(values.containsKey("organId")){
			organId=" and organId=:organId ";
		}
		//String hql = "select count(*)  from SMSCustomerInfo where 1=1 "+nameSpell+categoryId+organId+" and ( salesmanId=:salesmanId or salesmanId is null ) order by createTime desc";
		String hql ="";
		int category=Integer.parseInt(values.get("categoryId")==null ? "0" : values.get("categoryId").toString());
		if(category==1){ //是客户
		hql = "   select count (*) from SMSCustomerInfo where " + 
			"   ( categoryId='1' " +organId + " and phone is not null and phone <>'' ) " +
			"   and " + 
			"   customerId in ( " +
			"		select A.id from ContractPersonInfo A, CustomerInfo B  where B.id=A.customerId "+
			"   	and B.deleteFlag=0 and B.salesmanId=:salesmanId and B.companyId=:organId"+
			"   	and A.phone is not null and A.phone <>''"+
			"	)" +
			" " + nameSpell ;
		}else if(category==2){ //工作人员
			hql = "   select count (*) from SMSCustomerInfo where " + 
					"   ( categoryId='2'  " +organId + " and phone is not null and phone <>'' ) " +
			        "	 " + nameSpell ;
		}else {//全部
			hql = "  select count (*) from SMSCustomerInfo where (" + 
					"   ( categoryId='2' " +organId + " and phone is not null and phone <>'' ) " +
					"   or " + 
					"   customerId in ( " +
					"		select A.id from ContractPersonInfo A, CustomerInfo B  where B.id=A.customerId "+
					"   	and B.deleteFlag=0 and B.salesmanId=:salesmanId and B.companyId=:organId"+
					"   	and A.phone is not null and A.phone <>''"+
					"	) " +
					"	) " + nameSpell ;
		}

		int totalRows = dao.findCountForPage(hql, values);
		System.out.println(totalRows);
		return totalRows;
	}

	/**
	 * 分页查询短信通讯录信息
	 * @param values 参数
	 * @param currentlyPage 当前页码
	 * @param pageSize 每页条数
	 * @return 对象数组
	 */
	public List<SMSCustomerInfo> findSMSCustomerInfoForPage( Map<String, ?> values, int currentlyPage,int pageSize){
		String nameSpell="";
		if(values.containsKey("nameSpell")){
			nameSpell=" and nameSpell like '%"+values.get("nameSpell")+"%'";
		}
		String categoryId="";
		if(values.containsKey("categoryId")){
			categoryId=" and categoryId=:categoryId ";
		}
		String organId="";
		if(values.containsKey("organId")){
			organId=" and organId=:organId ";
		}
//		String hql = "from SMSCustomerInfo where 1=1 "+nameSpell+categoryId+organId+" and (salesmanId=:salesmanId or salesmanId is null ) order by createTime desc";
		
		String hql ="";
		int category=Integer.parseInt(values.get("categoryId")==null ? "0" : values.get("categoryId").toString());
		if(category==1){ //是客户
		hql = " from SMSCustomerInfo where " + 
			"   ( categoryId='1' " +organId + " and phone is not null and phone <>'' ) " +
			"   and " + 
			"   customerId in ( " +
			"		select A.id from ContractPersonInfo A, CustomerInfo B  where B.id=A.customerId "+
			"   	and B.deleteFlag=0 and B.salesmanId=:salesmanId and B.companyId=:organId"+
			"   	and A.phone is not null and A.phone <>''"+
			"	)" +
			" " + nameSpell  + " order by categoryId, nameSpell asc" ;
		}else if(category==2){ //工作人员
			hql = "  from SMSCustomerInfo where " + 
					"   ( categoryId='2'  " +organId + " and phone is not null and phone <>'' ) " +
			        "	 " + nameSpell  + " order by categoryId, nameSpell asc" ;
		}else {//全部
			hql = "from SMSCustomerInfo where (" + 
				"   ( categoryId='2' " +organId + " and phone is not null and phone <>'' ) " +
				"   or " + 
				"   customerId in ( " +
				"		select A.id from ContractPersonInfo A, CustomerInfo B  where B.id=A.customerId "+
				"   	and B.deleteFlag=0 and B.salesmanId=:salesmanId and B.companyId=:organId"+
				"   	and A.phone is not null and A.phone <>''"+
				"	) " +
				"	) " + nameSpell  + " order by categoryId, nameSpell asc" ;
		}
		List<SMSCustomerInfo> data = dao.findForPage(hql, values, currentlyPage, pageSize);
		return data;
	}
	
	/**
	 * 通过人员Id查询对应人员信息
	 * @param ids ids数组
	 * @return 人员数组
	 */
	public List<SMSCustomerInfo> findSMSCustomerInfoByIds(String... ids){
		List<String> idLis = new ArrayList<String>();
		for(String id : ids){
			idLis.add(id);
		}
		return dao.get(idLis);
	}

}
