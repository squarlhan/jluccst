package cn.edu.jlu.ccst.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import cn.edu.jlu.ccst.dao.DcshistoryImpl;
import cn.edu.jlu.ccst.dao.DcshistoryInter;
import cn.edu.jlu.ccst.model.Dcshistory;
/**
 * dcs历史数据服务类
 */
@Component("dcshistoryService")
public class DcshistoryService {
	/**
	 * dcs历史实例
	 */
	private Dcshistory dcshistory;
	/**
	 * dcs历史实例
	 */
	private DcshistoryInter dcshistoryImpl;

	

	
	public Dcshistory getDcshistory() {
		return dcshistory;
	}
	public void setDcshistory(Dcshistory dcshistory) {
		this.dcshistory = dcshistory;
	}
	public DcshistoryInter getDcshistoryImpl() {
		return dcshistoryImpl;
	}
    @Resource
	public void setDcshistoryImpl(DcshistoryInter dcshistoryImpl) {
		this.dcshistoryImpl = dcshistoryImpl;
	}
    /**
     * 保存dcs历史数据 
     */
	public void save(Dcshistory dcshistory) {
	
		if(dcshistory.getItem().matches("班次")){
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = formatter.format(currentTime);
			dcshistory.setSeqno(dateString);
		}
		dcshistoryImpl.save(dcshistory);
	}
	
	
	
}