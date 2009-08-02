package cn.edu.jlu.ccst.sshclient.util;

import cn.edu.jlu.ccst.sshclient.model.SSHTask;
import cn.edu.jlu.ccst.sshclient.ui.*;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
//import java.lang.Thread;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
//import javax.management.timer.Timer;
//import java.awt.*;
//import java.awt.event.*;

public class SSHOpCommand implements Runnable {
	private String Host;
	private String Name;
	private String Psw;
	private String Cmd;
	private String Id;
	private String Finout;
//	private String Fin;
	private int opType;
	private JTextArea  jTextArea1;
	private static long endtime;
	private  boolean flag = false; 
//	private  boolean groupflag = false;
	private JLabel  conl;
	private String ownPid;
//	private  String rs;	
	private List<SSHTask> runtasklist;


	/**
	 * 测试连接用这个构造方法
	 */
	public SSHOpCommand(String host, String name, String psw, int conInfo,JLabel l) {
		super();
		Host = host;
		Name = name;
		Psw = psw;
		opType = conInfo;
		conl=l;
		runtasklist = null;
	}
	/**
	 * 停止命令用这个构造方法
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
		runtasklist = null ;
	}
	/**
	 * 停止自定义的命令用这个构造方法
	 */
	public SSHOpCommand(String host, String name, String psw, String cmd, String id,
			String pid,int stopType) {
		super();
		Host = host;
		Name = name;
		Psw = psw;
		Cmd = cmd;
		Id = id;
		this.opType = stopType;
		ownPid = pid;
		runtasklist = null ;
	}
	/**
	 * 运行单个任务命令用这个构造方法
	 */
	public SSHOpCommand(String host, String name, String psw, String cmd,String id,JTextArea  jText,String finout,String fin,int taskInfo) {
		super();
		Host = host;
		Name = name;
		Psw = psw;
		Cmd = cmd;
		Id = id;
		Finout = finout;
//		Fin=fin;
		jTextArea1 = jText;
		opType = taskInfo;
		runtasklist = null;
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
		 * 开启某个任务6
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
		case 5 : //停止自定义的任务
			stopOwn();
			break;
		default: break;
		}

	}
	/**
	 * 向linux端传送文件
	 */
	public  void scpPut(Connection conn,String localFile, String remoteFileName,String remoteDir) throws IOException {

		SCPClient client = new SCPClient(conn);
		client.put(localFile, remoteFileName, remoteDir, "0600");

	} 

	/**
	 * 运行ssh远程命令
	 */
	private void runSSH() {

		String filename=Finout+"\\"+Id+".txt";
		String pidout = null;
		flag = true;
		LinuxClient.GetObj().setTaskRunSucc(Id,flag);
		TaskUI temp = new TaskUI();
		temp.EditTaskRunSuccXML(Id,flag);//向config.xml中写入任务运行状态
		try{

			DynDispThread disTh = new DynDispThread(jTextArea1,Id,System.currentTimeMillis());
			disTh.start();
			Connection conn = getOpenedConnection();
			Session sess = conn.openSession();
			sess.execCommand(Cmd);
			String out;
			int ft = 0;
			boolean first=true;
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));        
			while((out=bufferedReader.readLine())!=null) {
				if(first&&Cmd.startsWith("./"))
				{
					pidout=out;
					//向正在运行的自定义任务写入pid
					temp.EditTaskRunPid(Id,out.trim());
					System.out.println("out:"+".\\"+Id+"_"+out+".txt");
					first=false;
					File f=new File(".\\"+Id+"_"+out+".txt");
					f.createNewFile();
					continue;
				}
				if(ft == 0) {
					disTh.stop();
					jTextArea1.setText(Id+"\n");
					ft = 1;
				}
				out += "\r\n";
				jTextArea1.append(out);   
			}

			if(Cmd.startsWith("./"))
			{

				File f=new File("./"+Id+"_"+pidout+".txt");
				f.delete();   	 
				String rem=Cmd.substring(Cmd.indexOf(" "), Cmd.length());
				//System.out.println("1"+rem);
				rem=rem.trim();
				rem=rem.substring(rem.indexOf(" "),rem.length());
				//System.out.println("2"+rem);
				rem=rem.trim();
				//System.out.println("3"+rem);
				rem=rem.substring(0,rem.indexOf(" "));
				//System.out.println("4"+rem);
				OutputStream fout=new FileOutputStream(filename);
				scpGet(conn,rem,fout);
				System.out.println(rem+"...."+filename);
				fout.close();
				conn.close();
				System.out.println("文件路径:"+filename);


				GenerateGraphy.GetObj(LinuxClient.GetObj().findSelectTask(Id).getName()+"_"+Id,filename,4);

			}
			sess.close();
			conn.close();
		}
		catch(Exception ie) {
			ie.printStackTrace();
		}
		LinuxClient tmpLinx = LinuxClient.GetObj();
		tmpLinx.setSelTaskStatus(Id,0);         	
		if(flag == true) {
			flag = false;
			LinuxClient.GetObj().setTaskRunSucc(Id,flag);      
			temp.EditTaskRunSuccXML(Id,flag);//向config.xml中写入任务运行状态
		}

		//判断并行结束
		if(runtasklist == null){
			//System.out.println("并行jieshu");
			if(LinuxClient.GetObj().getAllRunSucc(Id) == false) {
				LinuxClient.GetObj().setSinglerun(1);
			}
		}

	}

	/**
	 * 重载执行函数，停止启动任务
	 * 停止正在运行的任务
	 */
	public void stopSSH() {

		List<String> pidlist;
		pidlist = new ArrayList<String>();
		String stopTaskcmd = Cmd;
		stopTaskcmd = stopTaskcmd.substring(0,stopTaskcmd.indexOf(" "));
		//System.out.println("stop:"+stopTaskcmd);

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
		flag = false;
		LinuxClient.GetObj().setTaskRunSucc(Id,flag); 
		TaskUI temp = new TaskUI();
		temp.EditTaskRunSuccXML(Id,flag);//向config.xml中写入任务运行状态
		endtime = System.currentTimeMillis();

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
	 * 停止自己定义的任务
	 * 
	 */
	public void stopOwn() {
		try {
			Connection conn = getOpenedConnection();
			Session sess = conn.openSession();
			sess.execCommand("kill pid "+ ownPid);
			sess.close();
			conn.close();
		}
		catch(Exception et) {
			et.printStackTrace();
		}
		flag = false;
		LinuxClient.GetObj().setTaskRunSucc(Id,flag); 
		TaskUI temp = new TaskUI();
		temp.EditTaskRunSuccXML(Id,flag);//向config.xml中写入任务运行状态
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
			DynDispThread disTh = new DynDispThread(jTextArea1,runtasklist.get(0).getGp().getId(),System.currentTimeMillis());
			disTh.start();	
			int ft = 0;
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
				TaskUI tempUI = new TaskUI();
				//向config.xml中写入任务运行信息
				tempUI.EditTaskRunSuccXML(runtasklist.get(i).getId(), flag);
				long stime = System.currentTimeMillis();
				runtasklist.get(i).setRunTime(stime);
				Date curtime = new Date();
				//将任务开始时间写config.xml文件中
				tempUI.EditTaskFromXML(runtasklist.get(i).getId(), runtasklist.get(i).getName(), runtasklist.get(i).getDirname(),runtasklist.get(i).getMemo(),
						runtasklist.get(i).getCmd(), runtasklist.get(i).getFin(),runtasklist.get(i).getFout(), curtime,stime, runtasklist.get(i).getFouts(), runtasklist.get(i).getOpts(), runtasklist.get(i).getInfiles());

				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));     
				if(runtasklist.get(i).getCmd().startsWith("./")) { //处理自定义任务
					int first1 = 0;
					while((out=bufferedReader.readLine())!=null) { 
						if(ft == 0) {
							disTh.stop();
							jTextArea1.setText(runtasklist.get(i).getGp().getId()+"\n");
							ft = 1;
						}
						if(first1 == 0) {
							first1 = 1;
							tempUI.EditTaskRunPid(runtasklist.get(i).getId(),out.trim());
							continue;
						}
						out += "\r\n";
						write.append(out);
						jTextArea1.append(out);  
					}
					first1 = 0;
				}
				else {
					while((out=bufferedReader.readLine())!=null) { //处理费自定义任务
						if(ft == 0) {
							disTh.stop();
							jTextArea1.setText(runtasklist.get(i).getGp().getId()+"\n");
							ft = 1;
						}
						out += "\r\n";
						write.append(out);
						jTextArea1.append(out);   
					}
				}

				runtasklist.get(i).setStatus(0);
				if(flag == true) { 
					LinuxClient.GetObj().setTaskRunSucc(runtasklist.get(i).getId(),false);
					tempUI.EditTaskRunSuccXML(runtasklist.get(i).getId(), false);
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
		LinuxClient.GetObj().setGpsStatus(runtasklist.get(0).getGp().getId(),false);
		LinuxClient.GetObj().setRunStatusC(runtasklist.get(0).getGp().getCp().getId(), false);
		LinuxClient.GetObj().setSinglerun(1);
	}
	//-----------------------------------------------------------------//
	/**
	 * 停止串行执行的组内的任务
	 */
	public void stopGroupSSH() {
		for(int i = 0; i < runtasklist.size(); ++i) {
			runtasklist.get(i).setStatus(0);   
		}
		for(int i = 0; i < runtasklist.size(); ++i) {   		
			if(runtasklist.get(i).getRunSucc() == true) { //如果组中的任务正在执行中
				if(runtasklist.get(i).getCmd().startsWith("./")) {
					try {
						Connection conn = getOpenedConnection();
						Session sess = conn.openSession();
						SSHTask st = LinuxClient.GetObj().findSelectTask(runtasklist.get(i).getId());
						sess.execCommand("kill pid "+ st.getPid());
						sess.close();
						conn.close();
					}
					catch(Exception et) {
						et.printStackTrace();
					}
				}
				else {
					String stopcmd = runtasklist.get(i).getCmd().substring(0,runtasklist.get(i).getCmd().indexOf(" "));
					//System.out.println("stopcmd:"+ stopcmd);
					String sscmd = "ps U "+ Name +" | grep "+
					stopcmd+" | awk '{print $1}'";

					List<String> pidlist;
					pidlist = new ArrayList<String>();
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
							//System.out.println("pid"+out);
						}
						sess.close();
						conn.close();
					}
					catch(Exception et) {
						et.printStackTrace();
					}    	
					killPidProcess(pidlist);//结束pid等于pidlist内容的进程
				}
				flag = false;
				LinuxClient.GetObj().setGpsrunSucc(runtasklist.get(i).getGp().getId(), true);
				LinuxClient.GetObj().setTaskRunSucc( runtasklist.get(i).getId(),false);
				//将任务运行信息写入config.xml文件中
				TaskUI tempT = new TaskUI();
				tempT.EditTaskRunSuccXML(runtasklist.get(i).getId(), false);
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
	//-----------------------------------------------------------------------------------//    
	public  void scpGet(Connection conn, String remoteFile, OutputStream target) throws IOException 
	{
		SCPClient client = new SCPClient(conn);
		client.get(remoteFile, target);
	}
	//---------------------------------------------------------------------------------//
}
