package com.boan.crm.groupmanage.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话端部门实体类
 * 
 * @author Administrator
 * 
 */
public class PhoneDeptment implements java.io.Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8604186190902667022L;

	/**
	 * 部门实体主键
	 */
	private String id;

	/**
	 * 部门名称
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

	public static List<PhoneDeptment> convertDeptListToPhoneDeptList(List<Deptment> list) {
		List<PhoneDeptment> phoneDeptList = null;
		if (list != null && list.size() > 0) {
			phoneDeptList = new ArrayList<PhoneDeptment>();
			PhoneDeptment phoneDeptment = null;
			for (int i = 0; i < list.size(); i++) {
				phoneDeptment = new PhoneDeptment();
				phoneDeptment.setId(list.get(i).getId());
				phoneDeptment.setName(list.get(i).getDeptName());
				phoneDeptList.add(phoneDeptment);
			}
		}
		return phoneDeptList;
	}
}