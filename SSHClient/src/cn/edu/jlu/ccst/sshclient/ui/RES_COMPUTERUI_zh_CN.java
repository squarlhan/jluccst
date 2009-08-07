package cn.edu.jlu.ccst.sshclient.ui;

import java.util.ListResourceBundle;

public class RES_COMPUTERUI_zh_CN extends ListResourceBundle
{
	static final Object[][] contents = {
        {"CREATECOMPUTER","新建计算机"}, 
        {"MODIFYCOMUTER","修改计算机"}, 
        {"COMPUTERNAME","计算机名字:"},
        {"USERNAME","用户名:"}, 
        {"SETPASSWORD","设置密码："}, 
        {"HOSTIPADDRESS","主机IP地址:"}, 
        {"TESTCONNECTION","测试连接"}, 
        {"TESTINGCONN","测试连接中...."}, 
        {"MEMO","备注:"}, 
        {"RESET","重置"}, 
        {"SUBMIT","提交"}, 
        {"ENTERCOMPUTERNAME","请输入电脑名"}, 
        {"ENTERUSERNAME","请输入用户名"},
        {"ENTERUSERPASSWORD","请输入用户密码"},
        {"ENTERUSERHOSTNAME","请输入用户主机名"},
        {"CREATESUCC","创建用户成功！"},
        {"MODIFYSUCC","修改用户成功！"}
	};

	public Object[][] getContents()
	{
	    return contents;
	}
}
