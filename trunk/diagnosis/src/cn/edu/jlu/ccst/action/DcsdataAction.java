package cn.edu.jlu.ccst.action;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import cn.edu.jlu.ccst.model.Dcsdata;

import cn.edu.jlu.ccst.model.User;
import cn.edu.jlu.ccst.service.DcsdataService;



@Component("dcsdataAction")
@Scope("prototype")
public class DcsdataAction extends ActionSupport {

	
	private List<Dcsdata> equipmentlist;

	private DcsdataService dcsdataService;
	

	public List<Dcsdata> getEquipmentlist() {
		return equipmentlist;
	}

	public void setEquipmentlist(List<Dcsdata> equipmentlist) {
		this.equipmentlist = equipmentlist;
	}

	public DcsdataService getDcsdataService() {
		return dcsdataService;
	}
    @Resource
	public void setDcsdataService(DcsdataService dcsdataService) {
		this.dcsdataService = dcsdataService;
	}

	public boolean checkuser(){
		ActionContext actionContext = ActionContext.getContext();
        Map user = actionContext.getSession();
        User us = (User) user.get("us");
		if(us!=null){
			return true;
		}
		else return false;
	}
	
	public String  equipmentList(String str) {
			if(checkuser()){
		 equipmentlist = dcsdataService.findbyequipment(str);
			return SUCCESS;}
			else return "unuserlogin";
		}
		
   /* public String alterDcsdata () {
		User olduser = (User) ActionContext.getContext().getSession()
					.get("us");
			
			
      if (olduser.getPassword().equals(currentpassword)) {
				
				if(newpassword.isEmpty())
				{ return "nullpass";}
				user.setPassword(newpassword);
				user.setId(olduser.getId());
				user.setUsername(olduser.getUsername());
				userService.save(user);
				
				
				ActionContext actionContext = ActionContext.getContext();
		        Map session = actionContext.getSession();
		        session.put("us", user);
				return "altersuccess";
			} else {
				
				return 	"altererror";
			}
			
			}*/
		

	
}
