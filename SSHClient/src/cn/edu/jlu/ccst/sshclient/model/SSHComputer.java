/**
 * 
 */
package cn.edu.jlu.ccst.sshclient.model;

import java.io.FileWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


import cn.edu.jlu.ccst.sshclient.ui.LinuxClient;
import cn.edu.jlu.ccst.sshclient.inter.BaseOperation;
import cn.edu.jlu.ccst.sshclient.ui.ComputerUI;

/** 
 * @author Woden
 *
 */
public class SSHComputer extends BaseClass implements BaseOperation{

	private String username;
	private String password;
	private String host;
	private List<SSHGroup> gps;
	private boolean runstatus = false;
		
	public SSHComputer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SSHComputer(String name, byte type, Date creatdate) {
		super(name, type, creatdate);
		// TODO Auto-generated constructor stub
	}
	public SSHComputer(String id, String name, byte type, String memo,
			Date creatdate) {
		super(id, name, type, memo, creatdate);
		// TODO Auto-generated constructor stub
	}	
	
	public SSHComputer(String id, String name, byte type, String memo,
			Date creatdate, String username, String password, String host,
			List<SSHGroup> gps) {
		super(id, name, type, memo, creatdate);
		this.username = username;
		this.password = password;
		this.host = host;
		this.gps = gps;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	public List<SSHGroup> getGps() {
		return gps;
	}
	public void setGps(List<SSHGroup> gps) {
		this.gps = gps;
	}
	//
	
 public  boolean creat() {
		// TODO Auto-generated method stub
		ComputerUI newComputerUi = new ComputerUI();
		newComputerUi.setModal(true);
		newComputerUi.setVisible(true);
		return false;
	}
	@Override
	public List<BaseClass> find(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BaseClass load(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean remove() {
		int tt = JOptionPane.showConfirmDialog(null, "删除电脑", "确认删除", JOptionPane.YES_NO_OPTION);
        System.out.print("yesoption:"+JOptionPane.YES_NO_OPTION);
		if(JOptionPane.NO_OPTION == tt)
			{
			return false;
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
            String it=el.attributeValue("id");
            if(it.equals(LinuxClient.getCur().getId()))
            	{
            		el.getParent().remove(el);
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
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		
		SSHComputer t=(SSHComputer)(LinuxClient.getCur());
		ComputerUI newComputerUi = new ComputerUI(t.getName(),t.getUsername(),t.getPassword(),t.getHost(),t.getMemo());
		newComputerUi.setModal(true);
		newComputerUi.setVisible(true);
		return false;
	}

        @Override
        public String toString(){
            return name;
            /*
             return "computer--id:"+id+";name:"+name+";memo:"+memo
                     +";host:"+host+";user:"+username
                     +";pswd:"+password
                     +";date:"+creatdate;
             */
        }
	public boolean getRunStatusC() {
		return runstatus;
	}
	public void setRunStatusC(boolean t) {
		runstatus = t;
	}
	
}
