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

	public static int runSSH(String host, String username, String password, String cmd,List<String> pidlist) throws IOException {

		Connection conn = getOpenedConnection(host, username, password);
		Session sess = conn.openSession();
		sess.execCommand(cmd);		
        String out;
		Thread thr1 = new Thread();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));    
		
		 
		    
		
		while((out=bufferedReader.readLine())!=null) {
			pidlist.add(out);   
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
			SSHCommand
					.scpPut("10.60.58.194", "wuchunguo", "wucg",
							"E:/SSH/cpp/LineEquation.cpp", "LineEquation.cpp",
							"squarlhan/");
			// SSHCommand.runSSH("10.60.58.194", "wuchunguo", "wucg",
			// "./squarlhan/pid squarlhan/test.txt squarlhan/test2.txt 10");
//			OutputStream out = new FileOutputStream("D:\\project\\3.txt");
//			SSHCommand
//					.scpGet("10.60.58.194", "wuchunguo", "wucg", "2.txt", out);
//			out.close();
//			System.out.println("succeed");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
