/*
 * @(#)GroupWorkshopServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.dao.IGroupPopedomRoleDao;
import com.boan.rees.group.model.GroupWorkshop;
import com.boan.rees.group.service.IGroupWorkshopService;
import com.boan.rees.group.dao.IGroupWorkShopDao;
/**
 * 车间服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("groupWorkshopService")
public class GroupWorkshopServiceImpl implements IGroupWorkshopService {

	@Autowired
	@Qualifier("IGroupWorkshopDao")
	private IGroupWorkShopDao groupworkshopdao;
	@Override
	public List<GroupWorkshop> findAllGroupCompany() {
		// TODO Auto-generated method stub
		return groupworkshopdao.findAll();
	}

	@Override
	public GroupWorkshop get(String id) {
		// TODO Auto-generated method stub
		return groupworkshopdao.get(id);
	}

	@Override
	public void deleteGroupCompany(String... ids) {
		// TODO Auto-generated method stub
        groupworkshopdao.delete(ids);
	}

	@Override
	public void save(GroupWorkshop table1) {
		// TODO Auto-generated method stub
        groupworkshopdao.save(table1);
	}

}

