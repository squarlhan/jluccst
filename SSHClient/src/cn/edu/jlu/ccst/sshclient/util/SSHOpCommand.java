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
	public  Thread task;
	
	public SSHOpCommand() {
		
	}
	public SSHOpCommand(String host, String name, String psw, int conInfo) {
		super();
		Host = host;
		Name = name;
		Psw = psw;
		opType = conInfo;
	}


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
    	task = new Thread(this);
    }
    public void start() {
    	task.start();
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
    		runSSH();
    	case 1:
    		
    	case 2://测试连接
    		try{
    		getOpenedConnection();
    		}catch(Exception e) {
    			
    		}
    		
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
    		Thread thr1 = new Thread();
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
    public  void stopSSH(String host, String username, String password, String cmd,List<String> pidlist) throws IOException {

		Connection conn = getOpenedConnection();
		Session sess = conn.openSession();
		sess.execCommand(cmd);		
        String out;
		Thread thr1 = new Thread();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));    		
 
		while((out=bufferedReader.readLine())!=null) {
			pidlist.add(out);   
		}
		sess.close();
		conn.close();

	}
    
    /**
     * 连接函数
     */
     public  Connection getOpenedConnection() throws IOException {
		Connection conn = new Connection(Host);
		conn.connect();
		boolean isAuthenticated = conn.authenticateWithPassword(Name, Psw);
		if (isAuthenticated == false)
			throw new IOException("Authentication failed.");
		return conn;

	}
}
