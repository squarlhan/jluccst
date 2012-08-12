<%@ page language="java" contentType="text/html; charset=UTF-8" %><%@page import="java.util.List,com.boan.crm.datadictionary.model.AreaInfo"%><%
	response.addHeader( "Cache-Control", "no-store,no-cache,must-revalidate" );
	response.addHeader( "Cache-Control", "post-check=0,pre-check=0" );
	response.addHeader( "Expires", "0" );
	response.addHeader( "Pragma", "no-cache" );
	request.setCharacterEncoding( "utf-8" );
	response.setCharacterEncoding( "utf-8" );
   	List list = ( List )request.getAttribute("areaList");
   	AreaInfo obj = null; 
	StringBuffer sb = new StringBuffer();
   	if( list != null&&list.size()>0 )
   	{
		sb.append( "{" );
		sb.append( " root:[" );
		for( int i = 0;i<list.size();i++ )
		{
			obj = ( AreaInfo )list.get( i );
			if( i > 0 )
				sb.append( "," );
			sb.append( "{id:'" );
			sb.append(  obj.getId() );
			sb.append( "',name:'" );
			sb.append( obj.getAreaName());
			sb.append( "'}" );
		}
		sb.append( "]}" );
   	}
   	else
	{
		sb.append( "{root:[]}" );
	}
   	System.out.println(sb.toString());
	response.getWriter().write( sb.toString() );
%>
