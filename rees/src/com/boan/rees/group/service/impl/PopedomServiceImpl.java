/*
 * @(#)GroupPopedomRoleServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import com.boan.rees.group.dao.IPopedomDao;
import com.boan.rees.group.dao.IRoleDao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.model.Factory;
import com.boan.rees.group.model.Popedom;
import com.boan.rees.group.model.Role;
import com.boan.rees.group.service.IPopedomService;
import com.boan.rees.utils.page.Pagination;
/**
 * 权限服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("popedomService")
public class PopedomServiceImpl implements IPopedomService{

	@Autowired
	@Qualifier("popedomDao")
	private IPopedomDao popedomDao = null;

	public void deletePopedomByIds( String keyword, String[] roleIds ) throws Exception
	{
		popedomDao.deletePopedomByIds( keyword, roleIds );
	}

	public List<Role> queryPopedomRoleList( String keyword ) throws Exception
	{
		return popedomDao.queryPopedomRoleList( keyword );
	}

	public void saveOrUpdatePopedom( String keyword, String[] roleIds ) throws Exception
	{
		popedomDao.saveOrUpdatePopedom( keyword, roleIds );
	}

	public String[] queryPopedomsByRoleId( String roleId ) throws Exception
	{
		return popedomDao.queryPopedomsByRoleId( roleId );
	}

	public boolean isHasPopedom( String userId, String userType, String keyword, String[] popedomKeys ) throws Exception
	{
		boolean b = false;
		// userId=1,userType=9,表示超级管理员,啥权限都有
		if( "1".equals( userId )||"9".equals( userType ) )
		{
			b = true;
		}
		else
		{
			if( popedomKeys != null && popedomKeys.length > 0 && StringUtils.isNotBlank( keyword ) )
			{
				for( String s : popedomKeys )
				{
					if( keyword.equalsIgnoreCase( s ) )
					{
						b = true;
						break;
					}
				}
			}
		}
		return b;
	}

	public void deletePopedomByRoleIds( String[] roleIds ) throws Exception
	{
		popedomDao.deletePopedomByRoleIds( roleIds );
	}

	public IPopedomDao getPopedomDao()
	{
		return popedomDao;
	}

	public void setPopedomDao( IPopedomDao popedomDao )
	{
		this.popedomDao = popedomDao;
	}
	@Override
	public boolean isSuperAdministrator(String userId, String userType) throws Exception {
		boolean b = false;
		// userId=1,userType=9,表示超级管理员
		if( "1".equals( userId )||"9".equals( userType ) )
		{
			b = true;
		}
		else
		{
			b = false;
		}
		return b;
	}
}

