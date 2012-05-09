package cn.edu.jlu.ccst.service;


import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.Dss_adviceServiceImpl;
import cn.edu.jlu.ccst.dao.Dss_adviceServiceInter;
import cn.edu.jlu.ccst.model.Dss_advice;
/**
 * 工艺对接建议服务类
 * @author catherine
 *
 */
@Component("dss_adviceService")
public class Dss_adviceService {
	/**
	 *  工艺对接建议实例
	 */
	private Dss_advice dss_advice;
	/**
	 *  工艺对接服务类
	 */
	private Dss_adviceServiceInter dss_adviceServiceImpl;

	

	

	

	public Dss_advice getDss_advice() {
		return dss_advice;
	}
    @Resource
	public void setDss_advice(Dss_advice dss_advice) {
		this.dss_advice = dss_advice;
	}

	public Dss_adviceServiceInter getDss_adviceServiceImpl() {
		return dss_adviceServiceImpl;
	}
	 @Resource
	public void setDss_adviceServiceImpl(
			Dss_adviceServiceInter dss_adviceServiceImpl) {
		this.dss_adviceServiceImpl = dss_adviceServiceImpl;
	}
	 /**
	 *  保存工艺对接建议
	 *  @param dss_advice 工艺对接建议实体
		 */
	public void save(Dss_advice dss_advice) {
		List<Dss_advice> all = dss_adviceServiceImpl.findAll();
		if(all!=null&&all.size()>0){
			if(all.get(0).getLevel()!=null&&all.get(0).getLevel().trim().length()>0){
			if(Integer.parseInt(all.get(0).getLevel())<Integer.parseInt(dss_advice.getLevel())){
				deleteall();
				dss_adviceServiceImpl.save(dss_advice);
			}
			}
		}else{
			dss_adviceServiceImpl.save(dss_advice);
		}
//		dss_adviceServiceImpl.save(dss_advice);
	}
	
	
	/**
	 *  删除所有工艺对接建议
	 */
	public void deleteall(){
		dss_adviceServiceImpl.deleteall();
	}
	
	/**
	 *  根据批次查找工艺对接建议
	 *  @return 返回工艺对接建议列表
	 */
	public List<String> findsimu_time() {
		List<String> resultlist = new ArrayList();
		resultlist = dss_adviceServiceImpl.findsimu_time();
		return resultlist;
	}
	
	
}