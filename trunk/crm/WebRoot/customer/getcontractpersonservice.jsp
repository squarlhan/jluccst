<%@ page language="java" contentType="text/html; charset=UTF-8" %><%@page import="java.util.List,com.boan.crm.customer.model.ContractPersonInfo"%><%
	response.addHeader( "Cache-Control", "no-store,no-cache,must-revalidate" );
	response.addHeader( "Cache-Control", "post-check=0,pre-check=0" );
	response.addHeader( "Expires", "0" );
	response.addHeader( "Pragma", "no-cache" );
	request.setCharacterEncoding( "utf-8" );
	response.setCharacterEncoding( "utf-8" );
	ContractPersonInfo obj = ( ContractPersonInfo )request.getAttribute("contractPersonInfo");
	StringBuffer sb = new StringBuffer();
   	if( obj != null )
   	{
		sb.append( "{" );
		sb.append( "root:[" );
		sb.append( "{id:'" );
		sb.append( obj.getId() );
		sb.append( "',name:'" );
		sb.append( obj.getPersonName());
		sb.append( "',phone:'" );
		sb.append( obj.getPhone());
		sb.append( "',tel:'" );
		sb.append( obj.getTel());
		sb.append( "',qq:'" );
		sb.append( obj.getQq());
		sb.append( "',email:'" );
		sb.append( obj.getEmail());
		sb.append( "'}" );
		sb.append( "]}" );
   	}
   	else
	{
		sb.append( "{root:[]}" );
	}
   	//System.out.println(sb.toString());
	response.getWriter().write( sb.toString() );
%>
