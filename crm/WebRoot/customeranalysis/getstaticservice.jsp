<%@ page language="java" contentType="text/html; charset=UTF-8" %><%@page import="com.boan.crm.utils.calendar.CalendarUtils,java.util.List,com.boan.crm.utils.page.Pagination,com.boan.crm.customerassessment.model.AutoCustomerAssessment"%><%
	response.addHeader( "Cache-Control", "no-store,no-cache,must-revalidate" );
	response.addHeader( "Cache-Control", "post-check=0,pre-check=0" );
	response.addHeader( "Expires", "0" );
	response.addHeader( "Pragma", "no-cache" );
	request.setCharacterEncoding( "utf-8" );
	response.setCharacterEncoding( "utf-8" );
	Pagination<AutoCustomerAssessment> pagination = ( Pagination<AutoCustomerAssessment> )request.getAttribute("pagination");
   	AutoCustomerAssessment obj = null; 
	StringBuffer sb = new StringBuffer();
   	if( pagination.getData() != null&&pagination.getData().size()>0 )
   	{
		sb.append( "{" );
		sb.append( "root:[" );
		for( int i = pagination.getData().size() - 1;i>0;i-- )
		{
			obj = ( AutoCustomerAssessment )pagination.getData().get( i );
			if( i < pagination.getData().size() - 1 )
				sb.append( "," );
			sb.append( "{id:'" );
			sb.append(  obj.getId() );
			sb.append( "',name:'" );
			sb.append( obj.getCustomerName());
			sb.append( "',date:'" );
			sb.append( CalendarUtils.toString(obj.getAssessmentTime()));
			sb.append( "',resultValue:'" );
			sb.append( obj.getResultValue());
			sb.append( "',result:'" );
			sb.append( obj.getResult());
			sb.append( "'}" );
		}
		sb.append( "]}" );
   	}
   	else
	{
		sb.append( "{root:[]}" );
	}
   	//System.out.println(sb.toString());
	response.getWriter().write( sb.toString() );
%>
