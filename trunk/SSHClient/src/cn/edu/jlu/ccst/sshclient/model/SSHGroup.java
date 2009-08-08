/**
 * 
 */
package cn.edu.jlu.ccst.sshclient.model;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import cn.edu.jlu.ccst.sshclient.inter.BaseAction;
import cn.edu.jlu.ccst.sshclient.inter.BaseOperation;
import cn.edu.jlu.ccst.sshclient.ui.GroupUI;
import cn.edu.jlu.ccst.sshclient.ui.LinuxClient;

/**�������ʵ����
 * @author Woden
 *
 */
public class SSHGroup extends BaseClass implements BaseAction, BaseOperation {

	/**
	 * @param id
	 * @param name
	 * @param type
	 * @param memo
	 * @param creatdate
	 */

	private String dirname;

	private List<SSHTask> sts;
	private SSHComputer cp;
	private boolean gprunstatus = false;
	private boolean gprunsucc = false;
	private String runpid;

	public SSHGroup(String id, String name, byte type, String memo,
			Date creatdate) {
		super(id, name, type, memo, creatdate);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param type
	 * @param creatdate
	 */
	public SSHGroup(String name, byte type, Date creatdate) {
		super(name, type, creatdate);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public SSHGroup() {
		// TODO Auto-generated constructor stub
	}


	public SSHGroup(String id, String name, byte type, String memo,
			Date creatdate, String dirname, List<SSHTask> sts, SSHComputer cp,
			boolean gprunstatus, boolean gprunsucc, String runpid) {
		super(id, name, type, memo, creatdate);
		this.dirname = dirname;
		this.sts = sts;
		this.cp = cp;
		this.gprunstatus = gprunstatus;
		this.gprunsucc = gprunsucc;
		this.runpid = runpid;
	}

	/**
	 * 生成函数	
	 * @param id
	 * @param name
	 * @param type
	 * @param memo
	 * @param creatdate
	 * @param sts
	 * @param cp
	 */
	public SSHGroup(String id, String name, byte type, String memo,
			Date creatdate, List<SSHTask> sts, SSHComputer cp) {
		super(id, name, type, memo, creatdate);
		this.sts = sts;
		this.cp = cp;
	}

	/**
	 * 获得group中的任务列表
	 * @return
	 */
	public List<SSHTask> getSts() {
		return sts;
	}

	public void setSts(List<SSHTask> sts) {
		this.sts = sts;
	}

	public SSHComputer getCp() {
		return cp;
	}

	public void setCp(SSHComputer cp) {
		this.cp = cp;
	}


	public String getRunpid() {
		return runpid;
	}

	public void setRunpid(String runpid) {
		this.runpid = runpid;
	}

	/* (non-Javadoc)
	 * @see cn.edu.jlu.ccst.sshclient.inter.BaseAction#start()
	 */
	@Override
	public String start() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.edu.jlu.ccst.sshclient.inter.BaseAction#stop()
	 */
	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see cn.edu.jlu.ccst.sshclient.inter.BaseOperation#creat()
	 */
	@Override
	public boolean creat() {
		// TODO Auto-generated method stub
		GroupUI newGroup = new GroupUI();
		newGroup.setModal(true);
		newGroup.setVisible(true); 
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

	public String getDirname() {
		return dirname;
	}

	public void setDirname(String dirname) {
		this.dirname = dirname;
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
		// TODO Auto-generated method stub
		int tt = JOptionPane.showConfirmDialog(null, "删除任务组", "确认删除", JOptionPane.YES_NO_OPTION);
		if(JOptionPane.NO_OPTION == tt)
		{
			return false;
		}
		int rr = JOptionPane.showConfirmDialog(null, "删除任务组工作目录", "删除目录", JOptionPane.YES_NO_OPTION);
		if(JOptionPane.YES_OPTION == rr)
		{
			try {
				removedirs(this.getOpenedConnection(this.getCp()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
					Element et=(Element)it.next();
					String s=et.attributeValue("id");
					if(s.equals(LinuxClient.getCur().getId()))
					{
						el.remove(et);
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

		SSHGroup t=(SSHGroup)LinuxClient.getCur();
		GroupUI newGroup = new GroupUI(t.getName(),t.getDirname(),t.getMemo());
		newGroup.setModal(true);
		newGroup.setVisible(true);

		return false;
	}

	//---------------------------------------------//创建目录
	private  void removedirs(Connection conn) throws IOException {

		//Connection conn = getOpenedConnection(TC);

		Session sess = conn.openSession();
		String finalcmd = this.dirname.substring(1);
		sess.execCommand("./squarlhan/CShell rm -rf " + finalcmd.trim());

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
	@Override
	public String toString(){
		return name;
		// return "group--id:"+id+";name:"+name+";memo:"+memo+";date:"+creatdate;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return false;
	}
	public void setGroupStatus(boolean st) {
		gprunstatus = st;
	}
	public boolean getGroupStatus() {
		return gprunstatus;
	}
	public void setGroupRunSucc(boolean gr) {
		gprunsucc = gr;
	}
	public boolean getGroupRunSucc() {
		return gprunsucc;
	}

}
