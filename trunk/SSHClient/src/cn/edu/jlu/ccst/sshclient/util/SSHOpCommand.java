package cn.edu.jlu.ccst.sshclient.util;

import cn.edu.jlu.ccst.sshclient.model.SSHTask;
import cn.edu.jlu.ccst.sshclient.ui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.management.timer.Timer;
import java.awt.*;
import java.awt.event.*;

public class SSHOpCommand implements Runnable {
	private String Host;
	private String Name;
	private String Psw;
	private String Cmd;
	private String Id;
	private int opType;
	private JTextArea  jTextArea1;
	private static long endtime;
	private  boolean flag = false; 
	private  boolean groupflag = false;
	private JLabel  conl;
	private  String rs;	
	private List<SSHTask> runtasklist;
	
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
	public SSHOpCommand(String host, String name, String psw, int conInfo,JLabel l) {
		super();
		Host = host;
		Name = name;
		Psw = psw;
		opType = conInfo;
		conl=l;
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
    public SSHOpCommand(String host, String name, String psw, String cmd, String id,
			int stopType) {
		super();
		Host = host;
		Name = name;
		Psw = psw;
		Cmd = cmd;
		Id = id;
		this.opType = stopType;
	}
	/**
     * 运行单个任务命令用这个构造方法
     * @param host
     * @param name
     * @param psw
     * @param cmd
     * @param jText
     * @param taskInfo 0
     */
	public SSHOpCommand(String host, String name, String psw, String cmd,String id,JTextArea  jText,int taskInfo) {
		super();
		Host = host;
		Name = name;
		Psw = psw;
		Cmd = cmd;
		Id = id;
		jTextArea1 = jText;
		opType = taskInfo;
	}
   /**
    * 串行运行组内的所有任务用这个构造方法
    */
    public SSHOpCommand(String host, String name, String psw,  List<SSHTask> runtasklist,
    		JTextArea jTextArea1, int opType) {
    	super();
    	Host = host;
    	Name = name;
    	Psw = psw;
    	this.opType = opType;
    	this.jTextArea1 = jTextArea1;
    	this.runtasklist = runtasklist;
    }
    
   /**
    * 停止组内串行运行的所有任务用这个构造方法 
    */
    public SSHOpCommand(String host, String name, String psw,  List<SSHTask> runtasklist,
    		 int opType) {
    	super();
    	Host = host;
    	Name = name;
    	Psw = psw;
    	this.opType = opType;
    	this.runtasklist = runtasklist;
    }
    
    public void init() {
    }
	public void start() {
    }
    public void run(){
    	/**
    	 * 开启任务0     同时开启组内所有任务0
    	 * 停止任务1    停止组内所有任务1
    	 * 测试连接2
    	 * 开启 组内任务3
    	 * 停止组内任务4
    	 * 
    	 */
    	switch(opType){
    	case 0: //执行task命令 5
    		runSSH();break;
    	case 1: //停止task命令
    		stopSSH();
    		break;
    	case 2://测试计算机连接
		    getOpenedConnectionT();
			break;
    	case 3 ://串行执行组内的所有任务
    		runGroupSSH();
    		break;
    	case 4 ://停止组内串行执行的所有任务
    		stopGroupSSH();
    		break;
    	default: break;
    	}
    	
    }
    
    /**
     * 运行ssh远程命令
     */
    private void runSSH() {
   	String filename=((SSHTask)(LinuxClient.getCur())).getFout()+"/"+LinuxClient.getCur().getId()+".txt";
    	FileWriter write = null;
    	try
    	{
    	write=new FileWriter(filename,true);    
    	}catch(IOException e)
    	{}
    	
    	
    	flag = true;
    	LinuxClient.GetObj().setTaskRunSucc(Id,flag);
    	try{
        	Connection conn = getOpenedConnection();
    		Session sess = conn.openSession();
    		sess.execCommand(Cmd);		
            String out;

    		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));        
    		while((out=bufferedReader.readLine())!=null) {
    			   out += "\n";
    			   write.append(out);
    			   jTextArea1.append(out);   
    		}
    		sess.close();
    		conn.close();
    		
    		write.flush();
    		write.close();
        	}
        	catch(Exception ie) {
        		ie.printStackTrace();
        	}
        	LinuxClient tmpLinx = LinuxClient.GetObj();
        	tmpLinx.setSelTaskStatus(Id,0);         	
        	if(flag == true) {
        		flag = false;
        		LinuxClient.GetObj().setTaskRunSucc(Id,flag);      
        	}
        	
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
        
    	//kill正在执行的命令
    /* if(pidlist.size() > 0) {
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
        	}
      */
    	killPidProcess(pidlist);
     flag = false;
     LinuxClient.GetObj().setTaskRunSucc(Id,flag); 
     endtime = System.currentTimeMillis();
     System.out.println("ttime:"+endtime);
	   	
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
   
   
 //-------------------------------------------------------------//
    /**
     * 串行开始组内的所有任务
     */
    public void runGroupSSH() {
    	
    	
    	for(int i = 0; i < runtasklist.size(); ++i) {
		    runtasklist.get(i).setStatus(1);   
    	}
    	try{
        	Connection conn ;
    		Session sess ;
    		for(int i = 0; i < runtasklist.size(); ++i){ 
    			String filename=runtasklist.get(i).getFout()+"/"+runtasklist.get(i).getId()+".txt";
    	    	FileWriter write = null;
    	    	try
    	    	{
    	    	write=new FileWriter(filename,true);
    	    	}catch(IOException e)
    	    	{}
    			conn = getOpenedConnection();
    			sess = conn.openSession();
    			sess.execCommand(runtasklist.get(i).getCmd());
    		    String out; 		    
    		    flag = true;
    		    runtasklist.get(i).setRunSucc(true);
    		    LinuxClient.GetObj().setTaskRunSucc(runtasklist.get(i).getId(),flag);   		    
    		    long stime = System.currentTimeMillis();
    		    runtasklist.get(i).setRunTime(stime);
    		    Date curtime = new Date();
    		    //将任务开始时间写config.xml文件中
    		    TaskUI tempUI = new TaskUI();
    		    tempUI.EditTaskFromXML(runtasklist.get(i).getId(), runtasklist.get(i).getName(), runtasklist.get(i).getMemo(),
    		    		runtasklist.get(i).getCmd(), runtasklist.get(i).getFin(),runtasklist.get(i).getFout(), curtime);

    		    
    	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));        
    	    	while((out=bufferedReader.readLine())!=null) {
    	    			   out += "\n";
    	    			   write.append(out);
    	    			   jTextArea1.append(out);   
    	    		}
    	    	runtasklist.get(i).setStatus(0);
    	      	if(flag == true) { 
    	    		LinuxClient.GetObj().setTaskRunSucc(runtasklist.get(i).getId(),false);
    	    		}    	      	
    	      	boolean temp = LinuxClient.GetObj().getGpsrunSucc(runtasklist.get(i).getGp().getId());
    	      	if(temp == true) {
    	      		LinuxClient.GetObj().setGpsrunSucc(runtasklist.get(i).getGp().getId(),false);
    	      		break;
    	      	}
    	    	sess.close();
        		conn.close();
        		write.flush();
            	write.close();
    		}
        	
        	}
        	catch(Exception ie) {
        		ie.printStackTrace();
        	}
        //	LinuxClient.GetObj().setGpsStatus(runtasklist.get(0).getGp().getId(),false);
    }
//-----------------------------------------------------------------//
    /**
     * 
     */
    public void stopGroupSSH() {
    	for(int i = 0; i < runtasklist.size(); ++i) {
		    runtasklist.get(i).setStatus(0);   
    	}
    	for(int i = 0; i < runtasklist.size(); ++i) {   		
    		if(runtasklist.get(i).getRunSucc() == true) { //如果组中的任务正在执行中
    		String stopcmd = runtasklist.get(i).getCmd().substring(0,runtasklist.get(i).getCmd().indexOf(" "));
    		System.out.println("stopcmd:"+ stopcmd);
    		String sscmd = "ps U "+ Name +" | grep "+
            stopcmd+" | awk '{print $1}'";
    		
        	List<String> pidlist;
        	pidlist = new ArrayList();
        	Connection conn ;
    		Session sess ;
    		String out;
        	BufferedReader bufferedReader;
        	
        	//连接server获得执行命令的pid;
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
        	killPidProcess(pidlist);//结束pid等于pidlist内容的进程
        	flag = false;
        	LinuxClient.GetObj().setGpsrunSucc(runtasklist.get(i).getGp().getId(), true);
        	LinuxClient.GetObj().setTaskRunSucc( runtasklist.get(i).getId(),false);
    		}
    	}
    	
    }
    /**
     * 连接函数1
     */
     public  Connection getOpenedConnection()  {
    	 Connection conn = new Connection(Host);
		try{	
		try
		{
		conn.connect();
		}
		catch (IOException e)
		{
			return conn;
		}
		boolean isAuthenticated = conn.authenticateWithPassword(Name, Psw);
		if (isAuthenticated == false)
		{
			throw new IOException("Authentication failed.");			
			
		}
		}
		catch(Exception ev){
			ev.printStackTrace();
		}
		
		return conn;

}

/**
 * 连接函数2
 */
 public  Connection getOpenedConnectionT()  {
	 Connection conn = new Connection(Host);
	try{	
	try
	{
	conn.connect();
	}
	catch (IOException e)
	{
		JOptionPane.showMessageDialog(null, "连接失败！");
		conl.setText("测试结束");
		return conn;
	}
	boolean isAuthenticated = conn.authenticateWithPassword(Name, Psw);
	if (isAuthenticated == false)
	{
		JOptionPane.showMessageDialog(null, "连接失败！");
		conl.setText("测试结束");
		throw new IOException("Authentication failed.");			
		
	}
	else
	{
		JOptionPane.showMessageDialog(null, "连接成功！");
		 conl.setText("测试结束");
	}
	}
	catch(Exception ev){
		JOptionPane.showMessageDialog(null, "连接失败！");
		conl.setText("测试结束");
		ev.printStackTrace();
	}
	
	return conn;
}
     //----------------------------------------------//
    /**
     * 程序结束时间
     */
     public long getRunEndTime() {
    	 return endtime;
     }
     //----------------------------------------------//
     /**
      * 程序执行状态
      */
     public boolean getRunStatus() {
    	 return flag;
     }
     public void setRunStatus(boolean f){
    	 flag = f;
     }
}
