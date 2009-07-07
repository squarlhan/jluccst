/**
 * 
 */
package cn.edu.jlu.ccst.sshclient.model;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

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
	private SSHGroup gp;
	private int taskstatus;
    private boolean taskfinish;
    private JTextArea jTextArea1;
	
	public SSHTask(String id, String name, byte type, String memo,Date creatdate) {
		super(id, name, type, memo, creatdate);
		taskstatus = 0;
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
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public SSHTask() {
		// TODO Auto-generated constructor stub
		taskstatus = 0;
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
	//����ķ�����Ҫʵ��
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
	int taskInfo = 0;//开启任务信息：0	
	SSHOpCommand ry = new SSHOpCommand(computerHost, userName, userPsw, cmd,jTextArea1,taskInfo);
	Thread ty = new Thread(ry);
	ty.start();
	}

	/* (non-Javadoc)
	 * @see cn.edu.jlu.ccst.sshclient.inter.BaseAction#stop()
	 */
	@Override
	public void stop() {
		SSHComputer selectComputer = new SSHComputer();
		selectComputer = gp.getCp();
		int stopType = 1;
		SSHOpCommand ry = new SSHOpCommand(selectComputer.getHost(), selectComputer.getUsername(),selectComputer.getPassword(),cmd,stopType);
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
		// TODO Auto-generated method stub
		SAXReader reader = new SAXReader();
		try
		{
		  Document doc = reader.read(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/util/Config.xml");
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
    	  XMLWriter writer = new XMLWriter(new FileWriter(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/util/Config.xml"));	   	 
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
		 TaskUI newTask = new TaskUI(t.getName(),t.getCmd(),t.getFin(),t.getFout(),t.getMemo());
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
		public boolean isdone() {
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

}
