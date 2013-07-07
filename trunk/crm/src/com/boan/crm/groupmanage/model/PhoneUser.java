package com.boan.crm.groupmanage.model;

import java.util.ArrayList;
import java.util.List;


/**
 * 电话用户实体类
 * 
 * @author XXX
 * @version 1.0.0
 */

public class PhoneUser {

	/**
	 * 用户实体主键
	 */
	private String id;
	
	/**
	 * 用户姓名
	 */
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static List<PhoneUser> convertUserListToPhoneUserList(List<User> list)
	{
		List<PhoneUser> phoneUserList = null;
		if( list != null && list.size() > 0 )
		{
			phoneUserList = new ArrayList<PhoneUser>();
			PhoneUser  phoneUser = null;
			for( int i = 0 ; i < list.size(); i ++ )
			{
				phoneUser = new PhoneUser();
				phoneUser.setId(list.get(i).getId());
				phoneUser.setName(list.get(i).getUserCName());
				phoneUserList.add(phoneUser);
			}
		}
		return phoneUserList;
	}
}
