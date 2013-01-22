package com.boan.crm.groupmanage.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.utils.action.BaseActionSupport;

@Controller("userSearchAction")
@Scope("prototype")
public class UserSearchAction extends BaseActionSupport {

	private String userName;
	
	private List<User> userList = new ArrayList<User>();
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;
	
	/**
	 * 查询本公司下的用户
	 * @return
	 */
	public String getUserNameByCompany(){
		try {
			userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
			userList = userService.queryUserListByUserName(sessionCompanyId, null ,userName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return this.SUCCESS;
	}
	/**
	 * 查询本公司本部门下的用户
	 * @return
	 */
	public String getUserNameByDept(){
		try {
			userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
			userList = userService.queryUserListByUserName(sessionCompanyId, sessionDeptId ,userName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return this.SUCCESS;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
