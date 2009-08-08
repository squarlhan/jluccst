package cn.edu.jlu.ccst.sshclient.ui.lang;

import java.util.ListResourceBundle;

public class RES_COMPUTERUI_en_US extends ListResourceBundle{
	static final Object[][] contents = {
        {"CREATECOMPUTER","CreateAComputer"}, 
        {"MODIFYCOMUTER","ModifyTheComputer"}, 
        {"COMPUTERNAME","CompName:"},
        {"USERNAME","UserName:"}, 
        {"SETPASSWORD","Password："}, 
        {"HOSTIPADDRESS","IPAddress:"}, 
        {"TESTCONNECTION","TestConn"}, 
        {"TESTINGCONN","TestingConn...."}, 
        {"MEMO","Memo:"}, 
        {"RESET","Reset"}, 
        {"SUBMIT","Submit"}, 
        {"ENTERCOMPUTERNAME","EnterCompName"}, 
        {"ENTERUSERNAME","EnterUserName"},
        {"ENTERUSERPASSWORD","EnterUserPassword"},
        {"ENTERUSERHOSTNAME","EnterHostName"},
        {"CREATESUCC","CreateSucc！"},
        {"MODIFYSUCC","ModifySucc！"}
	};

	public Object[][] getContents()
	{
	    return contents;
	}
}
