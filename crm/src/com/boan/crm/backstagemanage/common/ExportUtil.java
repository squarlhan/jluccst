/**
 * Copyright (c) 2011 Changchun BOAN Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)ExportUtil.java 1.1 2011-8-30
 */
package com.boan.crm.backstagemanage.common;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import com.boan.crm.groupmanage.model.User;

/**
 * 导出数据类
 * @author XXX
 * @version 1.0.0
 */
public class ExportUtil {
	/**
	 * 根据查询结果生成待写锁用户文件
	 * @param ekeyUserList
	 * @return 导出文件流
	 * @throws Exception
	 */
	public static InputStream exportEkeyUser(List<User> ekeyUserList) throws Exception{
		StringBuffer sb = new StringBuffer("[ePass1000]\r\n");
		if(ekeyUserList != null && ekeyUserList.size() > 0){
			for(User ekeyUser : ekeyUserList){
				String deptName = "";
				if(ekeyUser.getDept() != null){
						deptName = ekeyUser.getDept().getDeptName();
				}else{
					deptName = "公司";
				}
				sb.append(deptName);
				sb.append("|" + (ekeyUser.getUserCName()==null?"":ekeyUser.getUserCName()));
				sb.append("|" + (ekeyUser.getId()==null?"":ekeyUser.getId()));
				sb.append("\r\n");
			}
		}
		return new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));
	}
}
