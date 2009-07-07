package cn.edu.jlu.ccst.sshclient.util;

import cn.edu.jlu.ccst.sshclient.ui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.management.timer.Timer;
import java.awt.*;
import java.awt.event.*;

public class SSHOpCommand implements Runnable {
	private String Host;
	private String Name;
	private String Psw;
	private String Cmd;
	private int opType;
	private JTextArea  jTextArea1;
	//默认构造方法
	public SSHOpCommand() {
		
	}
	/**
	 * 测试连接用这个构造方法
	 * @param host
	 * @param name
	 * @param psw
	 * @param conInfo 2
	 */
	public SSHOpCommand(String host, String name, String psw, int conInfo) {
		super();
		Host = host;
		Name = name;
		Psw = psw;
		opType = conInfo;
	}
    /**
     * 停止命令用这个构造方法
     * @param host
     * @param name
     * @param psw
     * @param cmd
     * @param stopType 1
     * @param pidlist
     */
    public SSHOpCommand(String host, String name, String psw, String cmd,
			int stopType) {
		super();
		Host = host;
		Name = name;
		Psw = psw;
		Cmd = cmd;
		this.opType = stopType;
	}
	/**
     * 运行命令用这个构造方法
     * @param host
     * @param name
     * @param psw
     * @param cmd
     * @param jText
     * @param taskInfo 0
     */
	public SSHOpCommand(String host, String name, String psw, String cmd,JTextArea  jText,int taskInfo) {
		super();
		Host = host;
		Name = name;
		Psw = psw;
		Cmd = cmd;
		jTextArea1 = jText;
		opType = taskInfo;
	}
   
	
    public void init() {
    }
    public void start() {
    }
    public void run(){
    	/**
    	 * 开启任务0
    	 * 停止任务1
    	 * 测试连接2
    	 * 传文件3
    	 * 接受文件4
    	 * 
    	 */
    	switch(opType){
    	case 0: //执行命令
    		runSSH();break;
    	case 1:
    		stopSSH();
    		break;
    	case 2://测试连接
		    getOpenedConnection();
			break;
    	default: break;
    	}
    	
    }
    
    /**
     * 运行ssh远程命令
     */
    private void runSSH() {
    	try{
        	Connection conn = getOpenedConnection();
    		Session sess = conn.openSession();
    		sess.execCommand(Cmd);		
            String out;
    		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));        
    		while((out=bufferedReader.readLine())!=null) {
    			   out += "\n";
    			   jTextArea1.append(out);   
    		}
    		sess.close();
    		conn.close();
        	}
        	catch(Exception ie) {
        		ie.printStackTrace();
        	}
        	LinuxClient tmpLinx = new LinuxClient();
        	tmpLinx.setSelTaskStatus(0);    
        	
    }
    
    /**
     * 重载执行函数，停止启动任务
     * 停止正在运行的任务
     */
    public void stopSSH() {
    	List<String> pidlist;
    	pidlist = new ArrayList();
    	String stopTaskcmd = Cmd;
    	stopTaskcmd = stopTaskcmd.substring(0,stopTaskcmd.indexOf(" "));
    	System.out.println("stop:"+stopTaskcmd);
    	
    	String sscmd = "ps U "+ Name +" | grep "+
        stopTaskcmd+" | awk '{print $1}'";
    	
    	Connection conn;
    	Session sess;
    	String out;
    	BufferedReader bufferedReader;
    	try{
	    conn = getOpenedConnection();
	    sess = conn.openSession();
		sess.execCommand(sscmd);		
        bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));    		
		while((out=bufferedReader.readLine())!=null) {
			pidlist.add(out);  
			System.out.println("pid"+out);
		}
		sess.close();
		conn.close();
    	}
    	catch(Exception et) {
    		et.printStackTrace();
    	}    	
        
    	killPidProcess(pidlist);
    /*    if(pidlist.size() > 0) {
        		try {
        			conn = getOpenedConnection();
     			    sess = conn.openSession();
        			for(int i = 0; i < pidlist.size() - 1; i++){
        			sess.execCommand("kill pid "+ pidlist.get(i));
        		    }
        			sess.close();
        	     	conn.close();
        		}
        		catch(Exception et) {
        			et.printStackTrace();
        		}
        	}*/
	   	
	}
    private void killPidProcess(List<String> pidlist) {
        if(pidlist.size() > 0) {
    		try {
    			Connection conn = getOpenedConnection();
    			Session sess = conn.openSession();
    			for(int i = 0; i < pidlist.size() - 1; i++){
    			sess.execCommand("kill pid "+ pidlist.get(i));
    		    }
    			sess.close();
    	     	conn.close();
    		}
    		catch(Exception et) {
    			et.printStackTrace();
    		}
    	}
	
    	
    }
    /**
     * 连接函数
     */
     public  Connection getOpenedConnection()  {
    	 Connection conn = new Connection(Host);
		try{	
		conn.connect();
		boolean isAuthenticated = conn.authenticateWithPassword(Name, Psw);
		if (isAuthenticated == false)
			throw new IOException("Authentication failed.");
		}
		catch(Exception ev){
			ev.printStackTrace();
		}
		return conn;
	}

}
