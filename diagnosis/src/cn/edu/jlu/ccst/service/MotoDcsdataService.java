package cn.edu.jlu.ccst.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.dao.MotoDcsdataServiceInter;

import cn.edu.jlu.ccst.model.MotoDcsdata;


@Component("motodcsdataService")
public class MotoDcsdataService {
	private MotoDcsdata motodcsdata;
	private MotoDcsdataServiceInter motodcsdataServiceImpl;
	


	

	public MotoDcsdata getMotodcsdata() {
		return motodcsdata;
	}




@Resource
	public void setMotodcsdata(MotoDcsdata motodcsdata) {
		this.motodcsdata = motodcsdata;
	}





	public MotoDcsdataServiceInter getMotodcsdataServiceImpl() {
		return motodcsdataServiceImpl;
	}




	@Resource
	public void setMotodcsdataServiceImpl(
			MotoDcsdataServiceInter motodcsdataServiceImpl) {
		this.motodcsdataServiceImpl = motodcsdataServiceImpl;
	}





	public List<MotoDcsdata> findAll() {
		List<MotoDcsdata> resultlist = new ArrayList();
		resultlist = motodcsdataServiceImpl.findAll();
		return resultlist;
	}

	

}