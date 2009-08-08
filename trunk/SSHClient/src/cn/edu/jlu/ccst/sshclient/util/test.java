package cn.edu.jlu.ccst.sshclient.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

public class test {
	
	public static String outlist = "";
	
	public static void runSSH(String host, String username, String password, String cmd) throws IOException {

		Connection conn = getOpenedConnection(host, username, password);
		Session sess = conn.openSession();
		sess.execCommand(cmd);		
        String out;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));    
		
		 
		    
		
		while((out=bufferedReader.readLine())!=null) {
			System.out.println(out);
			outlist=outlist + out;   
		}
		System.out.println(outlist);
		sess.close();
		conn.close();
		//return sess.getExitStatus().intValue();

	}
	
	public static Connection getOpenedConnection(String host, String username, String password) throws IOException {

		Connection conn = new Connection(host);
		conn.connect();
		boolean isAuthenticated = conn.authenticateWithPassword(username, password);
		if (isAuthenticated == false)
			throw new IOException("Authentication failed.");
		return conn;

	}
	
	public static void main(String[] args) throws IOException{
		//String outlist = "";
//		String str2 = "";
		test.runSSH("10.60.58.194", "wuchunguo", "wucg", "pstree -p 30242");
		System.out.println("str:"+outlist);
		String regEx="\\(\\d+\\)"; 
		//outlist="CShell(29779)---ping(29780)"; 
		List<String> spids = new ArrayList<String>();
		Pattern p=Pattern.compile(regEx); 
		Matcher m=p.matcher(outlist); 
		while ( m.find()) {
			spids.add(m.group());
	        System.out.println("1:"+m.group());
	    }
        for(int a = spids.size()-1;a>=0;a--){
        	String mypid = spids.get(a).substring(1, spids.get(a).length()-1);
        	System.out.println("2:"+mypid);
        	test.runSSH("10.60.58.194", "wuchunguo", "wucg", "kill pid "+mypid);
        }
	}

}
