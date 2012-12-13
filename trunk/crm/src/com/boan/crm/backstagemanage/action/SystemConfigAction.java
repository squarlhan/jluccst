package com.boan.crm.backstagemanage.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.backstagemanage.service.ISystemConfigService;
import com.boan.crm.utils.action.BaseActionSupport;

@Controller("systemConfigAction")
@Scope("prototype")
public class SystemConfigAction extends BaseActionSupport {
	@Autowired
	@Qualifier("systemConfigService")
	private ISystemConfigService service = null;

	private String sqls[] = null;

	private String message = "";

	/**
	 * 构造器
	 */
	public SystemConfigAction() {
		List<String> list = new ArrayList<String>();
		list.add("INSERT INTO `group_user` (`id`, `CREATE_TIME`, `PASSWORD`, `SORT_INDEX`, `USERCNAME`, `USER_TYPE`, `USERNAME`) VALUES ('1', '2012-6-1 00:00:00', 'b59c67bf196a4758191e42f76670ceba', 0, '超级管理员', 9, 'admin');");
		sqls = new String[list.size()];
		list.toArray(sqls);
	}

	/**
	 * 初始化数据
	 * 
	 * @return
	 */
	public String initSystemData() throws Exception {
		try {
			// 删除所有表数据
			service.deleteAllTableData();
			// 录数初始化数据
			service.saveInitTableData(sqls);
			// 消息
			message = "数据库初始化成功，请退出重新登录，登录账号：admin，默认密码：4个1 。";
		} catch (Exception e) {
			message = e.getMessage();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 初始化数据
	 * 
	 * @return
	 */
	public String clearPartData() throws Exception {
		try {
			// 保留数据的表
			List<String> list = new ArrayList<String>();
			list.add("area_info");
			list.add("city_info");
			list.add("province_info");
			//保留数据的表含前缀
			List<String> preList = new ArrayList<String>();
			preList.add("contract_person_");
			preList.add("customer_lib_info_for_");
			service.deleteTableDataExceptTables(list,preList);
			// 录数初始化数据
			service.saveInitTableData(sqls);
			// 消息
			message = "数据库清理成功，保留数据的表有:" +list.toString()+" 和以"+ preList.toString() +"开头的表。";
		} catch (Exception e) {
			message = e.getMessage();
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 显示页面
	 * 
	 * @return
	 */
	public String showInitPage() {
		return INPUT;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
