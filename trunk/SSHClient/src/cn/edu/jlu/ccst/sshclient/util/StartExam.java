package cn.edu.jlu.ccst.sshclient.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.List;

import cn.edu.jlu.ccst.sshclient.ui.LinuxClient;
import cn.edu.jlu.ccst.sshclient.ui.TaskUI;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;


public class StartExam implements Runnable {
	private String id;
	private String pid;

	private String Host;
	private String Name;
	private String Psw;
	private String Finout;
	private String remoteFile;
	//默认构造方法
	public StartExam(String id,String pid, String Host,String Name,String Psw,String Finout,String remoteFile) 
	{
		this.id=id;
		this.pid=pid;
		this.Host=Host;
		this.Name=Name;
		this.Psw=Psw;
		this.Finout=Finout;
		this.remoteFile=remoteFile;
	}
	//-----------------------------------------------------------------//	
	public void init() {
	}
	//----------------------------------------------------------------//
	public void start() {
	}
	//-----------------------------------------------------------------//
	public void run(){

		String rs = null;
		String sscmd = "ps -p "+pid+" | wc -l ";

		Connection conn;
		Session sess;
		String out;
		BufferedReader bufferedReader;
		conn = getOpenedConnection();
		System.out.println("开始");
		while(rs==null||rs.equals("2"))
		{
			//System.out.println(rs);
			try
			{
				sess = conn.openSession();
				sess.execCommand(sscmd);
				bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));    		
				while((out=bufferedReader.readLine())!=null) 
				{
					rs=out;
				}
				sess.close();
				//conn.close();
			}
			catch(Exception et) {
				et.printStackTrace();
			} 
		}
		try
		{
			OutputStream fout=new FileOutputStream(Finout+"\\"+id+".txt");
			scpGet(conn,remoteFile,fout);
			//System.out.println(remoteFile+"...."+Finout+"\\"+id+".txt");
			fout.close();
			conn.close();
		}catch(Exception e){e.printStackTrace();}
		TaskUI temp = new TaskUI();
		temp.EditTaskRunSuccXML(id,false);
		LinuxClient.GetObj().setTaskRunSucc(id,false); 
		File f=new File(".\\"+id+"_"+pid+".txt");
		f.delete();
	}
	//-----------------------------------------------------------------// 
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
	//-----------------------------------------------------------------------------------//    
	public  void scpGet(Connection conn, String remoteFile, OutputStream target) throws IOException 
	{
		SCPClient client = new SCPClient(conn);
		client.get(remoteFile, target);
	}
	//---------------------------------------------------------------------------------//
}
