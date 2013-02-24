/*
 * @(#)GroupPopedomRoleServiceImpl.java 1.1 2012-3-9
 */

package com.boan.crm.groupmanage.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.groupmanage.common.MenuKey;
import com.boan.crm.groupmanage.common.RoleFlag;
import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.groupmanage.dao.IPopedomDao;
import com.boan.crm.groupmanage.model.Role;
import com.boan.crm.groupmanage.service.IPopedomService;

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

	public List<Role> queryPopedomRoleList( String keyword, String companyId ) throws Exception
	{
		return popedomDao.queryPopedomRoleList( keyword, companyId );
	}

	public void saveOrUpdatePopedom( String keyword, String[] roleIds, String companyId ) throws Exception
	{
		popedomDao.saveOrUpdatePopedom( keyword, roleIds, companyId );
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
			b = false;
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
	public boolean isCompanyAdministrator(String userId, String userType) throws Exception {
		boolean b = false;
		// userType=8,表示公司管理员
		if( "8".equals( userType ) )
		{
			b = true;
		}
		else
		{
			b = false;
		}
		return b;
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

	@Override
	public boolean isHasCompanyPopedom(String  roleKey) throws Exception {
		/*
		boolean b = false;
		if( popedomKeys != null && popedomKeys.length > 0 )
		{
			for( String s : popedomKeys )
			{
				if( RoleFlag.GONG_SI_GUAN_LI_YUAN.equalsIgnoreCase( s ) )
				{
					b = true;
					break;
				}
			}
		}
		*/
		if( RoleFlag.GONG_SI_GUAN_LI_YUAN.equalsIgnoreCase( roleKey ) )
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isHasDeptPopedom(String roleKey) throws Exception {
		/*
		boolean b = false;
		if( popedomKeys != null && popedomKeys.length > 0 )
		{
			for( String s : popedomKeys )
			{
				if( RoleFlag.BU_MEN_GUAN_LI_YUAN.equalsIgnoreCase( s ) )
				{
					b = true;
					break;
				}
			}
		}
		*/
		if( RoleFlag.BU_MEN_GUAN_LI_YUAN.equalsIgnoreCase( roleKey ) )
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isHasPopedomByRoleKey(UserSession userSession, String roleKey) throws Exception {
		if( userSession != null ){
			if( userSession.getRoleKey().equalsIgnoreCase(roleKey)){
				return true;
			}
		}
		return false;
	}
}

