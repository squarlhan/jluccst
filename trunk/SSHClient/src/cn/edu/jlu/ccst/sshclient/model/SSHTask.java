/**
 * 
 */
package cn.edu.jlu.ccst.sshclient.model;

//import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.*;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import cn.edu.jlu.ccst.sshclient.inter.BaseAction;
import cn.edu.jlu.ccst.sshclient.inter.BaseOperation;
import cn.edu.jlu.ccst.sshclient.ui.LinuxClient;
import cn.edu.jlu.ccst.sshclient.ui.TaskUI;
import cn.edu.jlu.ccst.sshclient.util.SSHOpCommand;

/**
 * @author Woden
 *
 */
public class SSHTask extends BaseClass implements BaseAction, BaseOperation {

	/**
	 * @param id
	 * @param name
	 * @param type
	 * @param memo
	 * @param creatdate
	 */

	private String cmd;
	private List<String> params;
	private String fin;
	private String fout;
	private String fouts;
	private String opts;
	private SSHGroup gp;
	private int taskstatus;
	private boolean taskfinish;
	private Date taskstartTime;
	private long taskrunTime;
	private String dirname;
	private String runpid;
	private JTextArea jTextArea1;
	private String infiles;

	public SSHTask(String id, String name, byte type, String memo,Date creatdate) {
		super(id, name, type, memo, creatdate);
		taskstatus = 0;
		taskfinish = false;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param type
	 * @param creatdate
	 */
	public SSHTask(String name, byte type, Date creatdate) {
		super(name, type, creatdate);
		taskstatus = 0;
		taskfinish = false;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public SSHTask() {
		// TODO Auto-generated constructor stub
		taskstatus = 0;
		taskfinish = false;
		taskstartTime = null;
	}	

	public SSHTask(String id, String name, byte type, String memo,
			Date creatdate, String cmd, List<String> params, String fin, String fout,
			SSHGroup gp) {
		super(id, name, type, memo, creatdate);
		this.cmd = cmd;
		this.params = params;
		this.fin = fin;
		this.fout = fout;
		this.gp = gp;
		taskstatus = 0;
	}

	public String getFouts() {
		return fouts;
	}

	public void setFouts(String fouts) {
		this.fouts = fouts;
	}

	public String getOpts() {
		return opts;
	}

	public void setOpts(String opts) {
		this.opts = opts;
	}

	public String getDirname() {
		return dirname;
	}

	public void setDirname(String dirname) {
		this.dirname = dirname;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getFout() {
		return fout;
	}

	public void setFout(String fout) {
		this.fout = fout;
	}

	public SSHGroup getGp() {
		return gp;
	}

	public void setGp(SSHGroup gp) {
		this.gp = gp;
	}
	public void setStatus(int t) {
		taskstatus = t;
	}
	public int getStatus() {
		return taskstatus;
	}

	public void setRunSucc(boolean t) {
		taskfinish = t;
	}
	public boolean getRunSucc() {
		return taskfinish;
	}
	public void setStartTime(Date t){
		taskstartTime = t;
	}
	public Date getStartTime() {
		return taskstartTime;
	}
	public void setRunTime(long t) {
		taskrunTime = t;
	}
	public long getRunTime() {
		return taskrunTime;
	}
	public void setPid(String pid) {
		runpid = pid;
	}
	public String getPid() {
		return runpid;
	}
	public String getInfiles() {
		return infiles;
	}

	public void setInfiles(String infiles) {
		this.infiles = infiles;
	}

	//-----------------------------------------------------------------------//
	/* (non-Javadoc)
	 * @see cn.edu.jlu.ccst.sshclient.inter.BaseAction#start()
	 */
	@Override
	public void start(JTextArea jtext) {
		jTextArea1 = jtext;
		SSHComputer selectComputer = new SSHComputer();
		selectComputer = gp.getCp();
		//获得执行命令的相关信息
		String computerHost = selectComputer.getHost();
		String userName = selectComputer.getUsername();
		String userPsw = selectComputer.getPassword();
		String cmdLine  = cmd;
		String separate = ";";
		
		String dir = this.getDirname();
		dir = "."+dir+"/";
		String infiles = this.getInfiles();
		System.out.println("infiles:"+infiles);
		int beginIndex = 0;
		int endIndex = 0;
		
		if(!infiles.endsWith(separate))
			infiles = infiles + separate;
		System.out.println("infiles:"+infiles);
		endIndex = infiles.indexOf(separate);
		System.out.println("endIndex"+endIndex);
		while (endIndex != -1){
			String infile = infiles.substring(beginIndex, endIndex);
			if(!infile.trim().isEmpty())
			cmdLine=cmdLine+" "+dir+infile;
			beginIndex = endIndex + 1;
			infiles = infiles.substring(beginIndex).trim();
			beginIndex = 0;
			endIndex = infiles.indexOf(separate);
		}
		String outfiles = this.getFouts();
		beginIndex = 0;
		endIndex = 0;
		if(!outfiles.endsWith(separate))
			outfiles = outfiles + separate;
		endIndex = outfiles.indexOf(separate);
		System.out.println("endIndex"+endIndex);
		System.out.println("outfiles:"+outfiles);
		while (endIndex != -1){
			String outfile = outfiles.substring(beginIndex, endIndex);
			if(!outfile.trim().isEmpty())
			cmdLine=cmdLine+" "+dir+outfile;
			beginIndex = endIndex + 1;
			outfiles = outfiles.substring(beginIndex).trim();
			beginIndex = 0;
			endIndex = outfiles.indexOf(separate);
		}
		
		String opts = this.getOpts();
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
		System.out.println("Dir:"+this.getDirname());
		System.out.println("cmdLine:"+cmdLine);	
		//System.exit(0);
		int taskInfo = 0;//开启任务信息：0	
		try{
			SSHOpCommand ry = new SSHOpCommand(computerHost, userName, userPsw, "./CShell "+cmdLine,id,jTextArea1,fout,fin,taskInfo);
			Thread ty = new Thread(ry);
			ty.start();

			//ty.join();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see cn.edu.jlu.ccst.sshclient.inter.BaseAction#stop()
	 */
	@Override
	public void stop() {
		SSHComputer selectComputer = new SSHComputer();
		selectComputer = gp.getCp();
		int stopType = 1;
		SSHOpCommand ry ;
		if(cmd.startsWith("./")) {
			stopType = 5;
			ry = new SSHOpCommand(selectComputer.getHost(), selectComputer.getUsername(),selectComputer.getPassword(),cmd,id,runpid,stopType);	
		}
		else {
			ry = new SSHOpCommand(selectComputer.getHost(), selectComputer.getUsername(),selectComputer.getPassword(),cmd,id,stopType);
		}
		Thread ty = new Thread(ry);
		ty.start();

	}

	/* (non-Javadoc)
	 * @see cn.edu.jlu.ccst.sshclient.inter.BaseOperation#creat()
	 */
	@Override
	public boolean creat() {
		// TODO Auto-generated method stub
		TaskUI newTask = new TaskUI();
		newTask.setModal(true);
		newTask.setVisible(true);
		return false;
	}

	/* (non-Javadoc)
	 * @see cn.edu.jlu.ccst.sshclient.inter.BaseOperation#find(java.lang.String)
	 */
	@Override
	public List<BaseClass> find(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.edu.jlu.ccst.sshclient.inter.BaseOperation#load(java.lang.String)
	 */
	@Override
	public BaseClass load(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.edu.jlu.ccst.sshclient.inter.BaseOperation#remove()
	 */
	@Override
	public boolean remove() {
		ResourceBundle res;		
		res = ResourceBundle.getBundle( "cn.edu.jlu.ccst.sshclient.ui.lang.RES_OTHER");
		int tt = JOptionPane.showConfirmDialog(null, res.getString("DEL_TASK"), res.getString("DEL_CONFIRM"), JOptionPane.YES_NO_OPTION);
		if(JOptionPane.NO_OPTION == tt)
		{
			return false;
		}
		int rr = JOptionPane.showConfirmDialog(null, res.getString("DEL_DIR"), res.getString("DEL_DIR_CONFIRM"), JOptionPane.YES_NO_OPTION);
		if(JOptionPane.YES_OPTION == rr)
		{
			try {
				removedirs(this.getOpenedConnection(this.getGp().getCp()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		SAXReader reader = new SAXReader();
		try
		{
			Document doc = reader.read("Config.xml");
			List   list=doc.selectNodes("/config/computer");
			Iterator iter = list.iterator();
			while(iter.hasNext())
			{
				Element el=(Element)iter.next();
				Iterator it=el.elementIterator("group");
				while(it.hasNext())
				{
					Element elta=(Element)it.next();
					Iterator itta=elta.elementIterator("task");
					while(itta.hasNext())
					{
						Element et=(Element)itta.next();
						String s=et.attributeValue("id");
						if(s.equals(LinuxClient.getCur().getId()))
						{
							elta.remove(et);
						}
					}

				}
			}
			XMLWriter writer = new XMLWriter(new FileWriter("Config.xml"));	   	 
			writer.write(doc);
			writer.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see cn.edu.jlu.ccst.sshclient.inter.BaseOperation#update()
	 */
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		SSHTask t=(SSHTask)LinuxClient.getCur();
		TaskUI newTask = new TaskUI(t.getName(),t.getDirname(),t.getCmd(),t.getFin(),t.getFout(),t.getMemo(), t.getFouts(), t.opts, t.infiles);
		newTask.setModal(true);
		newTask.setVisible(true);
		return false;
	}

	@Override
	public String toString(){
		return name;
		// return "task--id:"+id+";name:"+name+";memo:"+memo+";cmd:"+cmd+";date:"+creatdate;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setTextArea(JTextArea jTextArea2) {
		// TODO Auto-generated method stub
		jTextArea1 = jTextArea2;
	}

	@Override
	public String start() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//---------------------------------------------//创建目录
	private  void removedirs(Connection conn) throws IOException {

		//Connection conn = getOpenedConnection(TC);

		Session sess = conn.openSession();
		String finalcmd = this.dirname.substring(1);
		sess.execCommand("./CShell rm -rf " + finalcmd.trim());

		String out;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));    
		while((out=bufferedReader.readLine())!=null) {
			if(out.equals("EOP")){


			}
		}
		sess.close();
		conn.close();

	} 
	//--------------------------------------------------------//
	public  Connection getOpenedConnection(SSHComputer c)  {
		Connection conn = new Connection(c.getHost());
		try{	
			try
			{
				conn.connect();
			}
			catch (IOException e)
			{
				return conn;
			}
			boolean isAuthenticated = conn.authenticateWithPassword(c.getUsername(), c.getPassword());
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

}
