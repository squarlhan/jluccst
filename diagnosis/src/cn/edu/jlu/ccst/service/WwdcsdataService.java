package cn.edu.jlu.ccst.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.dao.WwdcsdataServiceInter;
import cn.edu.jlu.ccst.dao.WwdcsdataServiceImpl;
import cn.edu.jlu.ccst.model.Wwdcsdata;

@Component("wwdcsService")
public class WwdcsdataService {
	private Wwdcsdata wwdcsdata;
	private WwdcsdataServiceInter wwdcsServiceImpl;

	public Wwdcsdata getWwdcsdata() {
		return wwdcsdata;
	}

	@Resource
	public void setWwdcsdata(Wwdcsdata wwdcsdata) {
		this.wwdcsdata = wwdcsdata;
	}

	public WwdcsdataServiceInter getWwdcsServiceImpl() {
		return wwdcsServiceImpl;
	}

	@Resource
	public void setWwdcsServiceImpl(WwdcsdataServiceInter wwdcsServiceImpl) {
		this.wwdcsServiceImpl = wwdcsServiceImpl;
	}

	/*
	 * public UserServiceInter getUserServiceImpl() { return userServiceImpl; }
	 * 
	 * @Resource public void setUserServiceImpl(UserServiceInter
	 * userServiceImpl) { this.userServiceImpl = userServiceImpl; } public User
	 * getUser() { return user; }
	 * 
	 * @Resource public void setUser(User user) { this.user = user; }
	 */
	public Wwdcsdata findbytime(Wwdcsdata wwdcsdata) {
		return wwdcsServiceImpl.findbytime(wwdcsdata);
	}

	public void save(Wwdcsdata wwdcsdata) {
		// System.out.println("USER:"+user.getUsername()+" ; "+user.getPassword());
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(currentTime);
		wwdcsdata.setORGTIME(dateString+wwdcsdata.getORGTIME());
		Wwdcsdata temp = findbytime(wwdcsdata);
		if (temp == null)
			temp = wwdcsdata;
		else
			temp.initbydcs(wwdcsdata);
		
		wwdcsServiceImpl.save(temp);
	}
}