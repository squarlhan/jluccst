/**
 * 
 */
package cn.edu.jlu.ccst.sshclient.util;

import cn.edu.jlu.ccst.sshclient.ui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.io.OutputStream;


import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.SFTPv3Client;
import ch.ethz.ssh2.Session;
import java.lang.Thread;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.management.timer.Timer;

/**
 * @author Woden
>>>>>>> .r75
 */
public class SSHCommand extends JFrame {
	

	 public SSHCommand() {
			
	}
	/**
	 * @param host ip
	 * @param username
	 * @param password
	 * @param remoteFile
	 * @param localDir
	 */

	public static void scpGet(String host, String username, String password, String remoteFile, String localDir) throws IOException {

		Connection conn = getOpenedConnection(host, username, password);
		SCPClient client = new SCPClient(conn);
		client.get(remoteFile, localDir);
		
		conn.close();

	}
/*
 
 * */
	public static void scpGet(String host, String username, String password, String remoteFile, OutputStream target) throws IOException {

		Connection conn = getOpenedConnection(host, username, password);
		SCPClient client = new SCPClient(conn);
		client.get(remoteFile, target);
		conn.close();

	}
	/**
	 * @param host ip
	 * @param username
	 * @param password
	 * @param localFile
	 * @param remoteDir
	 */

	public static void scpPut(String host, String username, String password, String localFile, String remoteFileName,String remoteDir) throws IOException {

		Connection conn = getOpenedConnection(host, username, password);
		SCPClient client = new SCPClient(conn);
		client.put(localFile, remoteFileName, remoteDir, "0600");
		conn.close();

	}

	/**
	 * �ڷ���������������
	 * @param host
	 * @param username
	 * @param password
	 * @param cmd
	 * @return exit status
	 */

	public static int runSSH(String host, String username, String password, String cmd) throws IOException {

		Connection conn = getOpenedConnection(host, username, password);
		Session sess = conn.openSession();
		sess.execCommand(cmd);		
        String out;
		Thread thr1 = new Thread();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));    
				
		while((out=bufferedReader.readLine())!=null) {
			System.out.println(out); 
			//out += "\n";
			   //jTextArea1.append(out);   
			/* ActionListener   action=new   ActionListener()   
			  {   
			  public   void   actionPerformed(ActionEvent   e)   
			  {   
				 
			  }   
			  };   
			  Timer time=new  Timer(); 
			  time.*/
		}
		//System.out.println(sess.getExitStatus().toString());
		sess.close();
		
		conn.close();	
		return sess.getExitStatus().intValue();

	}
	/**
	 * 执行命令组
	 * @param host
	 * @param username
	 * @param password
	 * @param cmd[]
	 * @return
	 * @throws IOException
	 */
	public static int runSSHs(String host, String username, String password, List<String> cmds) throws IOException {

		Connection conn = getOpenedConnection(host, username, password);
		Session sess = conn.openSession();
		for(String cmd : cmds){
			sess = conn.openSession();
			sess.execCommand(cmd);		
		}		
		String out;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));     
		while((out=bufferedReader.readLine())!=null)     
		System.out.println(out);
		sess.close();
		conn.close();
		return sess.getExitStatus().intValue();

	}

	/**
	 * @param host
	 * @param username
	 * @param password
	 * @return
	 */

	public static Connection getOpenedConnection(String host, String username, String password) throws IOException {

		Connection conn = new Connection(host);
		conn.connect();
		boolean isAuthenticated = conn.authenticateWithPassword(username, password);
		if (isAuthenticated == false)
			throw new IOException("Authentication failed.");
		return conn;

	}

	/**
	 * �ڱ��ػ�������������
	 * @param cmd
	 * @return exit status 
	 */


	public static int runLocal(String cmd) throws IOException {

		Runtime rt = Runtime.getRuntime();
		Process p = rt.exec(cmd);	
	
		String out;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream())); 
		//int tt = 0;
		while((out=bufferedReader.readLine())!=null){
		//System.out.println(out);
	//	System.out.println("tt"+tt);
		//++tt;
		}
	//	rt.exit(1);
		return p.exitValue();

	}

	
	public static void main(String[] args){
		try {
//			SSHCommand
//					.scpPut("10.60.58.194", "wuchunguo", "wucg",
//							"E:/SSH/cpp/CShell.cpp", "CShell.cpp",
//							"squarlhan/");
//			SSHCommand
//			.scpGet("10.60.58.194", "wuchunguo", "wucg",
//					"squarlhan/irsvm", "c:/");
			// SSHCommand.runSSH("10.60.58.194", "wuchunguo", "wucg",
			// "./squarlhan/pid squarlhan/test.txt squarlhan/test2.txt 10");
//			OutputStream out = new FileOutputStream("D:\\project\\3.txt");
//			SSHCommand
//					.scpGet("10.60.58.194", "wuchunguo", "wucg", "2.txt", out);
//			out.close();
//			System.out.println("succeed");
			String dirs = "/a/f/g";
			String finalcmd = dirs.substring(1);
			while (finalcmd.endsWith("/")) {
				finalcmd = finalcmd.substring(0, finalcmd.length() - 2);
			}
			int i = finalcmd.lastIndexOf("/");
	    	String newdir = "";
	    	if(i>0)newdir = " mkdir -p "+finalcmd.substring(0, i)+" ;";	
	    	SFTPv3Client  sc = new  SFTPv3Client(SSHCommand.getOpenedConnection("10.60.58.194", "wuchunguo", "wucg"));
	    	sc.mkdir("g2/g3", 0);
	    	sc.close();
	    	//System.out.println("./squarlhan/CShell "+ newdir + " mv " + "orin" + " " + finalcmd.trim());
			int a = SSHCommand.runSSH("10.60.58.194", "wuchunguo", "wucg", "./squarlhan/CShell ls -l; ");
			System.out.println(a);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
