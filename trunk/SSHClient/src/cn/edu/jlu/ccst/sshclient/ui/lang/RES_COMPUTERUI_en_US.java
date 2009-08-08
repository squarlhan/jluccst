package cn.edu.jlu.ccst.sshclient.ui.lang;

import java.util.ListResourceBundle;

public class RES_COMPUTERUI_en_US extends ListResourceBundle{
	static final Object[][] contents = {
        {"CREATECOMPUTER","Create A Computer"}, 
        {"MODIFYCOMUTER","Modify The Computer"}, 
        {"COMPUTERNAME","Computer Name:"},
        {"USERNAME","UserName:"}, 
        {"SETPASSWORD","Password："}, 
        {"HOSTIPADDRESS","IPAddress:"}, 
        {"TESTCONNECTION","TestConn"}, 
        {"TESTINGCONN","TestingConn...."}, 
        {"MEMO","Memo:"}, 
        {"RESET","Reset"}, 
        {"SUBMIT","Submit"}, 
        {"ENTERCOMPUTERNAME","Please Enter Computer Name"}, 
        {"ENTERUSERNAME","Please Enter UserName"},
        {"ENTERUSERPASSWORD","Please Enter Password"},
        {"ENTERUSERHOSTNAME","Please Enter HostName"},
        {"CREATESUCC","Create Success!"},
        {"MODIFYSUCC","Modify Success!"}
	};

	public Object[][] getContents()
	{
	    return contents;
	}
}
