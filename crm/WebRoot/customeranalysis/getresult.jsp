<%@ page language="java" contentType="text/html; charset=UTF-8" %><%@page import="java.util.List,com.boan.crm.customerassessment.model.CustomerAssessment"%><%
	response.addHeader( "Cache-Control", "no-store,no-cache,must-revalidate" );
	response.addHeader( "Cache-Control", "post-check=0,pre-check=0" );
	response.addHeader( "Expires", "0" );
	response.addHeader( "Pragma", "no-cache" );
	request.setCharacterEncoding( "utf-8" );
	response.setCharacterEncoding( "utf-8" );
	List<CustomerAssessment> list = (List<CustomerAssessment>)request.getAttribute("listResult");
	CustomerAssessment obj = null;
	StringBuffer sb = new StringBuffer();
   	if( list != null && list.size()> 0 )
   	{
   		sb.append( "{" );
		sb.append( "root:[" );
   		for(int i=0;i<list.size();i++)
   		{
   			if( i > 0 )
				sb.append( "," );

			obj = list.get( i );
			
			sb.append( "{id:'" );
			sb.append( obj.getCustomerId() );
			sb.append( "',name:'" );
			sb.append( obj.getCustomerName());
			sb.append( "',resultValue:'" );
			sb.append( obj.getResultValue() );
			sb.append( "',result:'" );
			sb.append( obj.getResult() );
			sb.append( "'}" );
   		}
   		sb.append( "]}" );
   	}
   	else
	{
		sb.append( "{root:[]}" );
	}
   	//System.out.println(sb.toString());
	response.getWriter().write( sb.toString());
%>
