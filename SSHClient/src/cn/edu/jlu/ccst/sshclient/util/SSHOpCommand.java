package cn.edu.jlu.ccst.sshclient.util;

import cn.edu.jlu.ccst.sshclient.model.SSHTask;
import cn.edu.jlu.ccst.sshclient.ui.*;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.SFTPv3Client;
import ch.ethz.ssh2.SFTPv3FileAttributes;
import ch.ethz.ssh2.Session;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public String gid;
	public String gPid;
	

	//	private  String rs;	
	private List<SSHTask> runtasklist;
	private String mkdirCmd;



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
	public SSHOpCommand(String host, String name, String psw, String cmd, String mkdirCmd, String id,JTextArea  jText,String finout,String fin,int taskInfo) {
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
		this.mkdirCmd = mkdirCmd;
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
	 * 检测任务运行状态用这个构造方法
	 */
	public SSHOpCommand(String host, String name, String psw,
			JTextArea jTextArea1, int opType) {
		super();
		Host = host;
		Name = name;
		Psw = psw;
		this.opType = opType;
		this.jTextArea1 = jTextArea1;
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
	/**
	 * 下载输出文件用的构造方法
	 * @param host
	 * @param name
	 * @param psw
	 */
	public SSHOpCommand(String host, String name, String psw){
		super();
		Host = host;
		Name = name;
		Psw = psw;
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
//			stopSSH();
			stopOwn();
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
		case 6: //检测任务是否完成
			checkT();
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
//		System.out.println("***********  PID "+ownPid);
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
			Session sessMdir;
			conn = getOpenedConnection();
			sessMdir = conn.openSession();
			sessMdir.execCommand(mkdirCmd);
			System.out.println("mkdirCmd:"+mkdirCmd);
//			Thread.sleep(50*1000);
//			LinuxClient.GetObj().GenerateTree()
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
					//File f=new File(".\\"+Id+"_"+out+".txt");
					//f.createNewFile();
					continue;
				}
				if(ft == 0) {
					disTh.stop();
					jTextArea1.setText(Id+"\n");
					ft = 1;
				}
				
				//判断EOP
				if(out.startsWith("EOP")){
					if(flag == true) {
						flag = false;
						LinuxClient.GetObj().setTaskRunSucc(Id,flag);      
						temp.EditTaskRunSuccXML(Id,flag);//向config.xml中写入任务运行状态
					}
				}
				out += "\r\n";
				jTextArea1.append(out);   
				
			}
			
			

//			if(Cmd.startsWith("./"))
//			{
//
//				//File f=new File("./"+Id+"_"+pidout+".txt");
//				//f.delete();   	 
//				String rem=Cmd.substring(Cmd.indexOf(" "), Cmd.length());
//				//System.out.println("1"+rem);
//				rem=rem.trim();
//				rem=rem.substring(rem.indexOf(" "),rem.length());
//				//System.out.println("2"+rem);
//				rem=rem.trim();
//				//System.out.println("3"+rem);
//				rem=rem.substring(0,rem.indexOf(" "));
//				//System.out.println("4"+rem);
//				
//				
//				OutputStream fout=new FileOutputStream(filename);
//				scpGet(conn,rem,fout);
//				System.out.println(rem+"...."+filename);
//				fout.close();
//				conn.close();
//				System.out.println("文件路径:"+filename);
//
//
//				//GenerateGraphy.GetObj(LinuxClient.GetObj().findSelectTask(Id).getName()+"_"+Id,filename,4);
//
//			}

//			if(Cmd.startsWith("./"))
//			{
//
//				//File f=new File("./"+Id+"_"+pidout+".txt");
//				//f.delete();   	 
//				String rem=Cmd.substring(Cmd.indexOf(" "), Cmd.length());
//				//System.out.println("1"+rem);
//				rem=rem.trim();
//				rem=rem.substring(rem.indexOf(" "),rem.length());
//				//System.out.println("2"+rem);
//				rem=rem.trim();
//				//System.out.println("3"+rem);
//				rem=rem.substring(0,rem.indexOf(" "));
//				//System.out.println("4"+rem);
//				OutputStream fout=new FileOutputStream(filename);
//				scpGet(conn,rem,fout);
//				System.out.println(rem+"...."+filename);
//				fout.close();
//				conn.close();
//				System.out.println("文件路径:"+filename);
//
//
//				//GenerateGraphy.GetObj(LinuxClient.GetObj().findSelectTask(Id).getName()+"_"+Id,filename,4);
//
//			}

			sess.close();
			sessMdir.close();
			conn.close();
		}
		catch(Exception ie) {
			ie.printStackTrace();
		}
		LinuxClient tmpLinx = LinuxClient.GetObj();
		tmpLinx.setSelTaskStatus(Id,0);         	
//		if(flag == true) {
//			flag = false;
//			LinuxClient.GetObj().setTaskRunSucc(Id,flag);      
//			temp.EditTaskRunSuccXML(Id,flag);//向config.xml中写入任务运行状态
//		}

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
					System.out.println("pidlist.get(i)"+pidlist.get(i));
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
//		for(int i=0;i<LinuxClient.GetObj().tks.size();i++){
//			if(LinuxClient.GetObj().tks.get(i).getId()==Id){
//				ownPid=LinuxClient.GetObj().tks.get(i).getPid();
//			}
//		}
		outlist = "";
		String groupid="";
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read("Config.xml");
//			OutputFormat format = OutputFormat.createPrettyPrint();
			List list = doc.selectNodes("/config/computer");
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				boolean flg1 = true;
				Element el = (Element) iter.next();
				Iterator it = el.elementIterator("group");
				while (it.hasNext()) {
					boolean flag1 = true;
					Element elta = (Element) it.next();
					Iterator itta = elta.elementIterator("task");
					while (itta.hasNext()) {
						Element et = (Element) itta.next();
						String s = et.attributeValue("id");
						if (s.equals(Id)) {
							ownPid=et.attributeValue("runpid");
							System.out.println("group id "+elta.attributeValue("id"));
							groupid=elta.attributeValue("id");
							flag1 = false;
							break;
						}
					}
					if (flag1 == false) {
						flg1 = false;
						break;
					}
				}
				if (flg1 == false)
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			runSSH(Host, Name, Psw, "pstree -p "+ownPid);
			System.out.println("ownPid "+ownPid);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		String cmdline = "";
        for(int a = spids.size()-1;a>=0;a--){
        	String mypid = spids.get(a).substring(1, spids.get(a).length()-1);
        	System.out.println("2:"+mypid);
        	cmdline+="kill pid "+mypid+";";
        }
        cmdline+="rmdir "+groupid+"/"+Id+";";
        try {
			runSSH(Host, Name, Psw, cmdline);
			LinuxClient.GetObj().setTaskRunSucc(Id,false);
			TaskUI temp = new TaskUI();
			temp.EditTaskRunSuccXML(Id,flag);//向config.xml中写入任务运行状态
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String outlist = "";
	public static void runSSH(String host, String username, String password, String cmd) throws IOException {
		Connection conn = getOpenedConnection(host, username, password);
		Session sess = conn.openSession();
		System.out.println("runSSH cmd "+cmd);
		sess.execCommand(cmd);		
        String out;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));    
		
		while((out=bufferedReader.readLine())!=null) {
			System.out.println(out);
			outlist=outlist + out;   
		}
//		System.out.println("outlist         "+outlist);
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

	//-------------------------------------------------------------//
	/**
	 * 检测任务运行状态
	 */
	@SuppressWarnings("unchecked")
	public void checkT(){
		
		Connection conn ;
		conn = getOpenedConnection();
		while(true){
			List <SSHTask> runtasklist = new ArrayList();
			for(int i=0; i<LinuxClient.tks.size(); i++){
				if(LinuxClient.tks.get(i).getRunSucc())
					runtasklist.add(LinuxClient.tks.get(i));
			}
//			System.out.println("checkTStart");
//			System.out.println("runtasklist.size()"+runtasklist.size());
			System.out.println("checking...");
			SFTPv3FileAttributes sfa = null;
			try {
				Thread.sleep(5*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			for(int i = 0; i < runtasklist.size(); ++i) {
				String dir = "";
				String GID = runtasklist.get(i).getGp().getId();
				dir += "./"+GID;
				SSHTask selectedTask = runtasklist.get(i);
				dir += "/"+selectedTask.getId();
				//判断源文件和目标文件是否存在
				boolean dirExist = true;
				SFTPv3Client s3c = null;
				try{
//					System.out.println("dir:"+dir);
					s3c = new SFTPv3Client(conn);
					sfa = s3c.stat(dir);	
				}catch(IOException ee){
					dirExist = false;
				}
				s3c.close();
				if(dirExist)
					System.out.println("dirExist");
				else{
					System.out.println("dirNotExist");
					TaskUI tui = new TaskUI();
					System.out.println("selectedTask.getId():"+selectedTask.getId());
					LinuxClient.GetObj().setTaskRunSucc(runtasklist.get(i).getId(),false);
					tui.EditTaskRunSuccXML(selectedTask.getId(), false);
				}
				LinuxClient.GetObj().GenerateTree();
//				System.exit(1);
			}
		}
	}
	//----------------------------------------------------------------//
	/**
	 * 串行开始组内的所有任务
	 */
	public void runGroupSSH() {    	
		for(int i = 0; i < runtasklist.size(); ++i) {
			runtasklist.get(i).setStatus(1);   
		}
		String GID = runtasklist.get(0).getGp().getId();
		try{
			Connection conn ;
			Session sess,sessMdir ;
			DynDispThread disTh = new DynDispThread(jTextArea1,runtasklist.get(0).getGp().getId(),System.currentTimeMillis());
			disTh.start();	
			int ft = 0;
			String cmdLine = "./CShell ";
			conn = getOpenedConnection();
			sess = conn.openSession();
			sessMdir = conn.openSession();
			

			
			
			for(int i = 0; i < runtasklist.size(); ++i){ 
				SSHTask selectedTask = runtasklist.get(i);
				TaskUI tui = new TaskUI();
				System.out.println("selectedTask.getId():"+selectedTask.getId());
				tui.EditTaskRunSuccXML(selectedTask.getId(), true);
				
				cmdLine  = cmdLine+selectedTask.getCmd();
				String separate = ";";
				
				String dir = selectedTask.getDirname();
				dir = "."+dir+"/";
				String infiles = selectedTask.getInfiles();
				System.out.println("infiles:"+infiles);
				int beginIndex = 0;
				int endIndex = 0;
				if(!infiles.endsWith(separate))
					infiles = infiles + separate;
				endIndex = infiles.indexOf(separate);
				while (endIndex != -1){
					String infile = infiles.substring(beginIndex, endIndex);
					if(!infile.trim().isEmpty())
						cmdLine=cmdLine+" "+dir+infile;
					beginIndex = endIndex + 1;
					infiles = infiles.substring(beginIndex).trim();
					beginIndex = 0;
					endIndex = infiles.indexOf(separate);
				}
				String outfiles = selectedTask.getFouts();
				beginIndex = 0;
				endIndex = 0;
				if(!outfiles.endsWith(separate))
					outfiles = outfiles + separate;
				endIndex = outfiles.indexOf(separate);
				
				while (endIndex != -1){
					String outfile = outfiles.substring(beginIndex, endIndex);
					if(!outfile.trim().isEmpty())
					cmdLine=cmdLine+" "+dir+outfile;
					beginIndex = endIndex + 1;
					outfiles = outfiles.substring(beginIndex).trim();
					beginIndex = 0;
					endIndex = outfiles.indexOf(separate);
				}
				
				
				String opts = selectedTask.getOpts();
				if(!opts.endsWith(separate))
					opts = opts + separate;
				endIndex = opts.indexOf(separate);
				while (endIndex != -1){
					String opt = opts.substring(beginIndex, endIndex);
					if(!opt.trim().isEmpty())
					cmdLine=cmdLine+" "+opt;
					beginIndex = endIndex + 1;
					opts = opts.substring(beginIndex).trim();
					beginIndex = 0;
					endIndex = opts.indexOf(separate);
				}
				
				System.out.println("Dir:"+selectedTask.getDirname());
				System.out.println("cmdLine:"+cmdLine);	
				
				
				
				    
//				flag = true;
//				runtasklist.get(i).setRunSucc(true);
//				LinuxClient.GetObj().setTaskRunSucc(runtasklist.get(i).getId(),flag);
				TaskUI tempUI = new TaskUI();
				//向config.xml中写入任务运行信息
//				tempUI.EditTaskRunSuccXML(runtasklist.get(i).getId(), flag);
				long stime = System.currentTimeMillis();
				runtasklist.get(i).setRunTime(stime);
				Date curtime = new Date();
				//将任务开始时间写config.xml文件中
				tempUI.EditTaskFromXML(runtasklist.get(i).getId(), runtasklist.get(i).getName(), runtasklist.get(i).getDirname(),runtasklist.get(i).getMemo(),
						runtasklist.get(i).getCmd(), runtasklist.get(i).getFin(),runtasklist.get(i).getFout(), curtime,stime, runtasklist.get(i).getFouts(), runtasklist.get(i).getOpts(), runtasklist.get(i).getInfiles());
				
				LinuxClient.GetObj().setTaskRunSucc(runtasklist.get(i).getId(),true);
				runtasklist.get(i).setStatus(1);
				if(flag == true) { 
//					LinuxClient.GetObj().setTaskRunSucc(runtasklist.get(i).getId(),false);
//					tempUI.EditTaskRunSuccXML(runtasklist.get(i).getId(), false);
				}    	      	
				boolean temp = LinuxClient.GetObj().getGpsrunSucc(runtasklist.get(i).getGp().getId());
				if(temp == true) {
					LinuxClient.GetObj().setGpsrunSucc(runtasklist.get(i).getGp().getId(),false);
					break;
				}
				String tid;
				tid=runtasklist.get(i).getId();
//				System.out.println("tid="+tid);
				
				cmdLine = cmdLine+"@";
//				rm –tf ggg/t1
				cmdLine += "rmdir "+GID+"/"+tid+"@";
//				System.out.println("cmdLine:"+i+cmdLine);	
			}
			cmdLine += "rmdir "+GID+"@";
			//FileWriter write = null;
			//String filename=selectedTask.getFout()+"/"+selectedTask.getId()+".txt";
//			try
//			{
//				write=new FileWriter(filename,true);
//			}catch(IOException e)
//			{}
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));
			String out; 	
			boolean first = true;
			GroupUI gp = new GroupUI();
			String mkdirCmd = "./CShell ";
			mkdirCmd += "mkdir "+GID+"@";
			for(int i = 0; i < runtasklist.size(); ++i) {
				mkdirCmd += "mkdir -p "+GID+"/"+runtasklist.get(i).getId()+"@";   
			}
			System.out.println("mkdirCmd:"+mkdirCmd);
			LinuxClient.GetObj().updata();
//			Thread.sleep(50*1000);
//			LinuxClient.GetObj().GenerateTree();
			
			sessMdir.execCommand(mkdirCmd);
			sess.execCommand(cmdLine);
//			LinuxClient.GetObj().GenerateTree();
//			TaskUI temp = new TaskUI();
			while((out=bufferedReader.readLine())!=null) { 
					if(ft == 0) {
						disTh.stop();
						ft = 1;
					}
					if(first) {
						first = false;
						gp.EditGroupRunPid(runtasklist.get(0).getGp().getId(),out.trim());
						continue;
					}
					
					out += "\r\n";
//					write.append(out);
					jTextArea1.append(out);  
			}
		
//			write.flush();
//			write.close();
			System.out.println("cmdLine:"+cmdLine);	
//			System.exit(1);
			sessMdir.close();
			sess.close();
			conn.close();
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
		List<String> idlist=new ArrayList<String>();
		
		System.out.println("停止串行执行的组内的任务");
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read("Config.xml");
			List list = doc.selectNodes("/config/computer");
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				boolean flg1 = true;
				Element el = (Element) iter.next();
				Iterator it = el.elementIterator("group");
				while (it.hasNext()) {
					boolean flag1 = true;
					Element elta = (Element) it.next();
					String tgid = elta.attributeValue("id");
					if(tgid.equals(gid)){
						gPid=elta.attributeValue("pid");
//						System.out.println("gPid *** "+gPid);
						flag1=false;
						break;
					}
				}
				if (flg1 == false)
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		outlist="";
		try {
			runSSH(Host, Name, Psw, "pstree -p "+gPid);
			System.out.println("gPid "+gPid);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("gPid str:"+outlist);
		String regEx="\\(\\d+\\)"; 
		//outlist="CShell(29779)---ping(29780)"; 
		List<String> spids = new ArrayList<String>();
		Pattern p=Pattern.compile(regEx); 
		Matcher m=p.matcher(outlist); 
		while ( m.find()) {
			spids.add(m.group());
//	        System.out.println("G1:"+m.group());
	    }
		String cmdline = "";
        for(int a = spids.size()-1;a>=0;a--){
        	String mypid = spids.get(a).substring(1, spids.get(a).length()-1);
        	System.out.println("G2:"+mypid);
        	cmdline+="kill pid "+mypid+";";
        }
        cmdline+="rm -rf "+gid+";";
        try {
			runSSH(Host, Name, Psw, cmdline);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < runtasklist.size(); ++i) {
			runtasklist.get(i).setStatus(0);   
		}
		for(int i = 0; i < runtasklist.size(); ++i) {   	
				LinuxClient.GetObj().setGpsrunSucc(runtasklist.get(i).getGp().getId(), true);
				LinuxClient.GetObj().setTaskRunSucc( runtasklist.get(i).getId(),false);
				//将任务运行信息写入config.xml文件中
				TaskUI tempT = new TaskUI();
				tempT.EditTaskRunSuccXML(runtasklist.get(i).getId(), false);
		}
		
//		System.out.println("a00000000000");
//		for(int i = 0; i < runtasklist.size(); ++i) {
//			runtasklist.get(i).setStatus(0);   
//		}
//		for(int i = 0; i < runtasklist.size(); ++i) {   		
//			if(runtasklist.get(i).getRunSucc() == true) { //如果组中的任务正在执行中
//				if(runtasklist.get(i).getCmd().startsWith("./")) {
//					try {
//						Connection conn = getOpenedConnection();
//						Session sess = conn.openSession();
//						SSHTask st = LinuxClient.GetObj().findSelectTask(runtasklist.get(i).getId());
//						sess.execCommand("kill pid "+ st.getPid());
//						sess.close();
//						conn.close();
//					}
//					catch(Exception et) {
//						et.printStackTrace();
//					}
//				}
//				else {
//					String stopcmd = runtasklist.get(i).getCmd().substring(0,runtasklist.get(i).getCmd().indexOf(" "));
//					//System.out.println("stopcmd:"+ stopcmd);
//					String sscmd = "ps U "+ Name +" | grep "+
//					stopcmd+" | awk '{print $1}'";
//
//					List<String> pidlist;
//					pidlist = new ArrayList<String>();
//					Connection conn ;
//					Session sess ;
//					String out;
//					BufferedReader bufferedReader;
//
//					//连接server获得执行命令的pid;
//					try{
//						conn = getOpenedConnection();
//						sess = conn.openSession();
//						sess.execCommand(sscmd);		
//						bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));    		
//						while((out=bufferedReader.readLine())!=null) {
//							pidlist.add(out);  
//							//System.out.println("pid"+out);
//						}
//						sess.close();
//						conn.close();
//					}
//					catch(Exception et) {
//						et.printStackTrace();
//					}    	
//					killPidProcess(pidlist);//结束pid等于pidlist内容的进程
//				}
//				flag = false;
//				LinuxClient.GetObj().setGpsrunSucc(runtasklist.get(i).getGp().getId(), true);
//				LinuxClient.GetObj().setTaskRunSucc( runtasklist.get(i).getId(),false);
//				//将任务运行信息写入config.xml文件中
//				TaskUI tempT = new TaskUI();
//				tempT.EditTaskRunSuccXML(runtasklist.get(i).getId(), false);
//			}
//		}

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
				System.out.println("conn failed");
				return null;	
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
		ResourceBundle res;		
		res = ResourceBundle.getBundle( "cn.edu.jlu.ccst.sshclient.ui.lang.RES_OTHER");
		try{	
			try
			{
				conn.connect();
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null, res.getString("TEST_FAILD"),null,JOptionPane.ERROR_MESSAGE);
				conl.setText(res.getString("TEST_CONC"));
				return conn;
			}
			boolean isAuthenticated = conn.authenticateWithPassword(Name, Psw);
			if (isAuthenticated == false)
			{
				JOptionPane.showMessageDialog(null, res.getString("TEST_FAILD"),null,JOptionPane.ERROR_MESSAGE);
				conl.setText(res.getString("TEST_CONC"));
				throw new IOException("Authentication failed.");			

			}
			else
			{
				JOptionPane.showMessageDialog(null, res.getString("TEST_SUCCESS"),null,JOptionPane.INFORMATION_MESSAGE);
				conl.setText(res.getString("TEST_CONC"));
			}
		}
		catch(Exception ev){
			JOptionPane.showMessageDialog(null, res.getString("TEST_FAILD"),null,JOptionPane.ERROR_MESSAGE);
			conl.setText(res.getString("TEST_CONC"));
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
	public String getOwnPid() {
		return ownPid;
	}
	public void setOwnPid(String ownPid) {
		this.ownPid = ownPid;
	}
}
