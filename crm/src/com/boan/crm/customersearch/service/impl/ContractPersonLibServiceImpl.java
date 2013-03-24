/**
 * 
 */
package com.boan.crm.customersearch.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customersearch.dao.IContractPersonLibDAO;
import com.boan.crm.customersearch.model.ContractPersonLibInfo;
import com.boan.crm.customersearch.model.ContractPersonLib_AnHui;
import com.boan.crm.customersearch.model.ContractPersonLib_AoMen;
import com.boan.crm.customersearch.model.ContractPersonLib_BeiJing;
import com.boan.crm.customersearch.model.ContractPersonLib_ChongQing;
import com.boan.crm.customersearch.model.ContractPersonLib_FuJian;
import com.boan.crm.customersearch.model.ContractPersonLib_GanSu;
import com.boan.crm.customersearch.model.ContractPersonLib_GuangDong;
import com.boan.crm.customersearch.model.ContractPersonLib_GuangXi;
import com.boan.crm.customersearch.model.ContractPersonLib_GuiZhou;
import com.boan.crm.customersearch.model.ContractPersonLib_HaiNan;
import com.boan.crm.customersearch.model.ContractPersonLib_HeBei;
import com.boan.crm.customersearch.model.ContractPersonLib_HeNan;
import com.boan.crm.customersearch.model.ContractPersonLib_HeiLongJiang;
import com.boan.crm.customersearch.model.ContractPersonLib_HuBei;
import com.boan.crm.customersearch.model.ContractPersonLib_HuNan;
import com.boan.crm.customersearch.model.ContractPersonLib_JiLin;
import com.boan.crm.customersearch.model.ContractPersonLib_JiangSu;
import com.boan.crm.customersearch.model.ContractPersonLib_JiangXi;
import com.boan.crm.customersearch.model.ContractPersonLib_LiaoNing;
import com.boan.crm.customersearch.model.ContractPersonLib_NeiMeng;
import com.boan.crm.customersearch.model.ContractPersonLib_NingXia;
import com.boan.crm.customersearch.model.ContractPersonLib_QingHai;
import com.boan.crm.customersearch.model.ContractPersonLib_ShanDong;
import com.boan.crm.customersearch.model.ContractPersonLib_ShanXi;
import com.boan.crm.customersearch.model.ContractPersonLib_ShanXi2;
import com.boan.crm.customersearch.model.ContractPersonLib_ShangHai;
import com.boan.crm.customersearch.model.ContractPersonLib_SiChuan;
import com.boan.crm.customersearch.model.ContractPersonLib_TaiWan;
import com.boan.crm.customersearch.model.ContractPersonLib_TianJin;
import com.boan.crm.customersearch.model.ContractPersonLib_XiZang;
import com.boan.crm.customersearch.model.ContractPersonLib_XiangGang;
import com.boan.crm.customersearch.model.ContractPersonLib_XinJiang;
import com.boan.crm.customersearch.model.ContractPersonLib_YunNan;
import com.boan.crm.customersearch.model.ContractPersonLib_ZheJiang;
import com.boan.crm.customersearch.service.IContractPersonLibService;
import com.boan.crm.utils.converter.ParseBeanUtil;
import com.boan.crm.utils.myenum.ProvinceEnum;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 *　联系人服务接口实现类
 */
@Service("contractPersonLibService")
public class ContractPersonLibServiceImpl implements IContractPersonLibService {
	@Autowired
	@Qualifier("contractPersonLibDao")
	private IContractPersonLibDAO contractPersonDao;
	@Override
	public void deleteContractPersonLibInfo(String... ids) {
		contractPersonDao.delete(ids);
	}
	/**
	 * 根据客户id删除联系人
	 * @param ids
	 */
	@Override
	public void deleteContractPersonLibInfoByCustomerIds(String... ids)
	{	
		for(int i=0;i<ids.length;i++)
		{
			Map<String,String> idMap = new HashMap<String,String>();
			idMap.put("customerId", ids[i]);
			contractPersonDao.executeHql("delete from ContractPersonLibInfo where customerId = :customerId",idMap);
		}
	}
	@Override
	public List<ContractPersonLibInfo> findAllContractPersonLibInfoByCustomerId(String customerId) {
		Map<String,String> idMap = new HashMap<String,String>();
		idMap.put("customerId", customerId);
		return contractPersonDao.find("from ContractPersonLibInfoView where customerId = :customerId order by sort_index asc", idMap);
	}

	@Override
	public Pagination<ContractPersonLibInfo> findContractPersonLibInfoForPage(
			Map<String, ?> values, Pagination<ContractPersonLibInfo> pagination) {
		String hql = "from ContractPersonLibInfo order by sortIndex asc";
		List<ContractPersonLibInfo> data = contractPersonDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from ContractPersonLibInfo order by sortIndex asc";
		int totalRows = contractPersonDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	@Override
	public ContractPersonLibInfo get(String id) {
		return contractPersonDao.get(id);
	}

	@Override
	public void save(ContractPersonLibInfo table1) {
		contractPersonDao.saveOrUpdate(table1);
	}
	
	
	
	
	
	
	@Override
	public void deleteContractPersonLibInfo(String province ,String... ids) {
		String provincKey = "ContractPersonLib_" +ProvinceEnum.getKeyByName(province);
		for(int i=0;i<ids.length;i++)
		{
			Map<String,String> idMap = new HashMap<String,String>();
			idMap.put("id", ids[i]);
			contractPersonDao.executeHql("delete from "+provincKey+" where id = :id",idMap);
		}
	}
	/**
	 * 根据客户id删除联系人
	 * @param ids
	 */
	@Override
	public void deleteContractPersonLibInfoByCustomerIds(String province ,String... ids)
	{	
		String provincKey = "ContractPersonLib_" +ProvinceEnum.getKeyByName(province);
		for(int i=0;i<ids.length;i++)
		{
			Map<String,String> idMap = new HashMap<String,String>();
			idMap.put("customerId", ids[i]);
			contractPersonDao.executeHql("delete from "+provincKey+" where customerId = :customerId",idMap);
		}
	}
	@Override
	public List<ContractPersonLibInfo> findAllContractPersonLibInfoByCustomerId(String province ,String customerId) {
		String provincKey = "ContractPersonLib_" +ProvinceEnum.getKeyByName(province);
		Map<String,String> idMap = new HashMap<String,String>();
		idMap.put("customerId", customerId);
		return contractPersonDao.find("from "+provincKey+" where customerId = :customerId order by sort_index asc", idMap);
	}

	@Override
	public Pagination<ContractPersonLibInfo> findContractPersonLibInfoForPage(String province ,
			Map<String, ?> values, Pagination<ContractPersonLibInfo> pagination) {
		String provincKey = "ContractPersonLib_" +ProvinceEnum.getKeyByName(province);
		String hql = "from "+provincKey+" order by sortIndex asc";
		List<ContractPersonLibInfo> data = contractPersonDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from "+provincKey+" order by sortIndex asc";
		int totalRows = contractPersonDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	@Override
	public ContractPersonLibInfo get(String province ,String id) {
		String provincKey = "ContractPersonLib_" +ProvinceEnum.getKeyByName(province);
		List list = contractPersonDao.find("from " + provincKey +" where id=:id", id);
		return list!=null && list.get(0)!=null ? (ContractPersonLibInfo)list.get(0) : null;
	}

	@Override
	public void save(String province ,ContractPersonLibInfo info) {

		String provincKey = ProvinceEnum.getKeyByName(province);
		if(provincKey!=null && !provincKey.equals("")){
			if(provincKey.equals("AnHui")){
				ContractPersonLib_AnHui contractPerson =(ContractPersonLib_AnHui)ParseBeanUtil.parseBean(info, ContractPersonLib_AnHui.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("AoMen")){
				ContractPersonLib_AoMen contractPerson =(ContractPersonLib_AoMen)ParseBeanUtil.parseBean(info, ContractPersonLib_AoMen.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("BeiJing")){
				ContractPersonLib_BeiJing contractPerson =(ContractPersonLib_BeiJing)ParseBeanUtil.parseBean(info, ContractPersonLib_BeiJing.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("ChongQing")){
				ContractPersonLib_ChongQing contractPerson =(ContractPersonLib_ChongQing)ParseBeanUtil.parseBean(info, ContractPersonLib_ChongQing.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("FuJian")){
				ContractPersonLib_FuJian contractPerson =(ContractPersonLib_FuJian)ParseBeanUtil.parseBean(info, ContractPersonLib_FuJian.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("GanSu")){
				ContractPersonLib_GanSu contractPerson =(ContractPersonLib_GanSu)ParseBeanUtil.parseBean(info, ContractPersonLib_GanSu.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("GuangDong")){
				ContractPersonLib_GuangDong contractPerson =(ContractPersonLib_GuangDong)ParseBeanUtil.parseBean(info, ContractPersonLib_GuangDong.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("GuangXi")){
				ContractPersonLib_GuangXi contractPerson =(ContractPersonLib_GuangXi)ParseBeanUtil.parseBean(info, ContractPersonLib_GuangXi.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("GuiZhou")){
				ContractPersonLib_GuiZhou contractPerson =(ContractPersonLib_GuiZhou)ParseBeanUtil.parseBean(info, ContractPersonLib_GuiZhou.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("HaiNan")){
				ContractPersonLib_HaiNan contractPerson =(ContractPersonLib_HaiNan)ParseBeanUtil.parseBean(info, ContractPersonLib_HaiNan.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("HeBei")){
				ContractPersonLib_HeBei contractPerson =(ContractPersonLib_HeBei)ParseBeanUtil.parseBean(info,ContractPersonLib_HeBei.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("HeiLongJiang")){
				ContractPersonLib_HeiLongJiang contractPerson =(ContractPersonLib_HeiLongJiang)ParseBeanUtil.parseBean(info, ContractPersonLib_HeiLongJiang.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("HeNan")){
				ContractPersonLib_HeNan contractPerson =(ContractPersonLib_HeNan)ParseBeanUtil.parseBean(info, ContractPersonLib_HeNan.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("HuBei")){
				ContractPersonLib_HuBei contractPerson =(ContractPersonLib_HuBei)ParseBeanUtil.parseBean(info, ContractPersonLib_HuBei.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("HuNan")){
				ContractPersonLib_HuNan contractPerson =(ContractPersonLib_HuNan)ParseBeanUtil.parseBean(info, ContractPersonLib_HuNan.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("JiangSu")){
				ContractPersonLib_JiangSu contractPerson =(ContractPersonLib_JiangSu)ParseBeanUtil.parseBean(info, ContractPersonLib_JiangSu.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("JiangXi")){
				ContractPersonLib_JiangXi contractPerson =(ContractPersonLib_JiangXi)ParseBeanUtil.parseBean(info, ContractPersonLib_JiangXi.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("JiLin")){
				ContractPersonLib_JiLin contractPerson =(ContractPersonLib_JiLin)ParseBeanUtil.parseBean(info, ContractPersonLib_JiLin.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("LiaoNing")){
				ContractPersonLib_LiaoNing contractPerson =(ContractPersonLib_LiaoNing)ParseBeanUtil.parseBean(info, ContractPersonLib_LiaoNing.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("NeiMeng")){
				ContractPersonLib_NeiMeng contractPerson =(ContractPersonLib_NeiMeng)ParseBeanUtil.parseBean(info, ContractPersonLib_NeiMeng.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("NingXia")){
				ContractPersonLib_NingXia contractPerson =(ContractPersonLib_NingXia)ParseBeanUtil.parseBean(info, ContractPersonLib_NingXia.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("QingHai")){
				ContractPersonLib_QingHai contractPerson =(ContractPersonLib_QingHai)ParseBeanUtil.parseBean(info, ContractPersonLib_QingHai.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("ShanDong")){
				ContractPersonLib_ShanDong contractPerson =(ContractPersonLib_ShanDong)ParseBeanUtil.parseBean(info, ContractPersonLib_ShanDong.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("ShangHai")){
				ContractPersonLib_ShangHai contractPerson =(ContractPersonLib_ShangHai)ParseBeanUtil.parseBean(info, ContractPersonLib_ShangHai.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("ShanXi")){
				ContractPersonLib_ShanXi contractPerson =(ContractPersonLib_ShanXi)ParseBeanUtil.parseBean(info, ContractPersonLib_ShanXi.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("ShanXi2")){
				ContractPersonLib_ShanXi2 contractPerson =(ContractPersonLib_ShanXi2)ParseBeanUtil.parseBean(info, ContractPersonLib_ShanXi2.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("SiChuan")){
				ContractPersonLib_SiChuan contractPerson =(ContractPersonLib_SiChuan)ParseBeanUtil.parseBean(info, ContractPersonLib_SiChuan.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("TaiWan")){
				ContractPersonLib_TaiWan contractPerson =(ContractPersonLib_TaiWan)ParseBeanUtil.parseBean(info, ContractPersonLib_TaiWan.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("TianJin")){
				ContractPersonLib_TianJin contractPerson =(ContractPersonLib_TianJin)ParseBeanUtil.parseBean(info, ContractPersonLib_TianJin.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("XiangGang")){
				ContractPersonLib_XiangGang contractPerson =(ContractPersonLib_XiangGang)ParseBeanUtil.parseBean(info, ContractPersonLib_XiangGang.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("XinJiang")){
				ContractPersonLib_XinJiang contractPerson =(ContractPersonLib_XinJiang)ParseBeanUtil.parseBean(info, ContractPersonLib_XinJiang.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("XiZang")){
				ContractPersonLib_XiZang contractPerson =(ContractPersonLib_XiZang)ParseBeanUtil.parseBean(info,ContractPersonLib_XiZang.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("YunNan")){
				ContractPersonLib_YunNan contractPerson =(ContractPersonLib_YunNan)ParseBeanUtil.parseBean(info, ContractPersonLib_YunNan.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
			if(provincKey.equals("ZheJiang")){
				ContractPersonLib_ZheJiang contractPerson =(ContractPersonLib_ZheJiang)ParseBeanUtil.parseBean(info, ContractPersonLib_ZheJiang.class);
				contractPersonDao.saveOrUpdate(contractPerson);
			}
		}
	}
}
