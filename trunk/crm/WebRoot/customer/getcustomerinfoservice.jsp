<%@ page language="java" contentType="text/html; charset=UTF-8" %><%@page import="com.boan.crm.utils.page.Pagination,java.util.List,com.boan.crm.customer.model.CustomerInfo"%><%
	response.addHeader( "Cache-Control", "no-store,no-cache,must-revalidate" );
	response.addHeader( "Cache-Control", "post-check=0,pre-check=0" );
	response.addHeader( "Expires", "0" );
	response.addHeader( "Pragma", "no-cache" );
	request.setCharacterEncoding( "utf-8" );
	response.setCharacterEncoding( "utf-8" );
	Pagination<CustomerInfo> pagination = (Pagination<CustomerInfo>)request.getAttribute("pagination");
	List<CustomerInfo> list = pagination.getData();
	CustomerInfo obj = null;
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
			sb.append( obj.getId() );
			sb.append( "',name:'" );
			sb.append( obj.getCustomerName());
			
			String contractPersonName = "";
			String phone = "";
			if(obj.getContractPersonList() != null && obj.getContractPersonList().size() > 0)
			{
				for(int j=0;j<obj.getContractPersonList().size();j++)
				{
					if(contractPersonName.equals(""))
					{
						contractPersonName = obj.getContractPersonList().get(j).getPersonName();
					}else
					{
						contractPersonName = contractPersonName + "," + obj.getContractPersonList().get(j).getPersonName();
					}
					if(phone.equals(""))
					{
						if(obj.getContractPersonList().get(j).getTel().length() > 0)
							phone = obj.getContractPersonList().get(j).getTel() + " " + obj.getContractPersonList().get(j).getPhone();
					}else
					{
						if(obj.getContractPersonList().get(j).getTel().length() > 0)
						{
							phone = phone + "," + obj.getContractPersonList().get(j).getTel() + " " + obj.getContractPersonList().get(j).getPhone();
						}
					}
				}
			}
			sb.append( "',contractPerson:'" );
			sb.append( contractPersonName );
			sb.append( "',phone:'" );
			sb.append( phone );
			sb.append( "',salesman:'" );
			sb.append( obj.getSalesman());
			sb.append( "',progressId:'" );
			sb.append( obj.getProgress());
			sb.append( "',category:'" );
			sb.append( obj.getCategory());
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
