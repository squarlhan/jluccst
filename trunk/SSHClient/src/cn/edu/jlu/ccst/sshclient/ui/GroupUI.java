package cn.edu.jlu.ccst.sshclient.ui;



import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import cn.edu.jlu.ccst.sshclient.model.*;


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class GroupUI extends javax.swing.JDialog  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel gLabel1 , dirLabel, memoLabel, Ltest;
	private JTextField gTextField1, dirTextField;
	private JTextArea memoJArea;
	private JScrollPane memoAreaPane; 
	private JButton resetButton , submitButton;
	private boolean flag = false;
	private String older;
	private SSHGroup sgodler;
	public GroupUI(){
		this.setTitle("新建工作组");
		initComponent();	   
		submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				SubmitButtonMousePressed(evt);
			}
		});
	}
	//----------------------------------------------------------//
	public GroupUI(String name,String dirname, String memo){
		this.setTitle("修改工作组");
		initComponent();	  
		submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				SubmitMousePressedE(evt);
			}
		});
		gTextField1.setText(name);
		dirTextField.setText(dirname);
		memoJArea.setText(memo);
		older = dirname;

		sgodler = new SSHGroup();
		sgodler.setName(name);
		sgodler.setDirname(dirname);
		sgodler.setMemo(memo);
	}

	/**
	 * 初始画图函数
	 */
	private void initComponent(){
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/g.png"));
		setIconImage(img);
		this.setLayout(null);
		this.setSize(350, 350);

		gLabel1= new JLabel("工作组名字:");
		gLabel1.setBounds(50, 50, 80, 30);
		this.add(gLabel1);
		gTextField1 = new JTextField();
		gTextField1.setBounds(150,50, 150, 30);
		this.add(gTextField1);
		if(this.getTitle().startsWith("新建"))
			gTextField1.getDocument().addDocumentListener(new Swing_OnValueChanged());

		dirLabel= new JLabel("工作目录:");
		dirLabel.setBounds(50, 100, 80, 30);
		this.add(dirLabel);
		dirTextField = new JTextField();
		dirTextField.setBounds(150,100, 150, 30);
		dirTextField.setText(gTextField1.getText());
		this.add(dirTextField);

		memoLabel = new JLabel("备注:");
		memoLabel.setBounds(50, 150, 80, 30);
		this.add(memoLabel);
		memoJArea = new javax.swing.JTextArea("");
		memoJArea.setLineWrap(true);
		memoJArea.setBorder(BorderFactory.createLineBorder(Color.black));
		memoAreaPane = new JScrollPane(memoJArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		memoAreaPane.setBounds(150, 150, 150, 80);
		this.add(memoAreaPane);

		resetButton = new JButton("重置:");
		resetButton.setBounds(50,250, 80, 30);
		resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				ResetButtonMousePressed(evt);
			}
		});
		this.add(resetButton);

		submitButton = new JButton("提交:");
		submitButton.setBounds(180, 250, 80, 30);

		this.add(submitButton);
		Dimension   screenSize   =   Toolkit.getDefaultToolkit().getScreenSize();   
		Dimension   frameSize   =   this.getSize();   

		this.setLocation((screenSize.width   -   frameSize.width)   /   2,   (screenSize.height   -   frameSize.height)   /   2);
	}
	//内部类，用来处理两个文本框文字同步
	private class Swing_OnValueChanged implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			dirTextField.setText("/"+gTextField1.getText());

		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			dirTextField.setText("/"+gTextField1.getText());
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			dirTextField.setText("/"+gTextField1.getText());
		}

	}

	//-----------------------------------------------------------------//
	/**
	 * 处理重置按钮
	 */
	private  void ResetButtonMousePressed(java.awt.event.MouseEvent evt){
		if (this.getTitle().startsWith("新建")) {
			gTextField1.setText(null);
			dirTextField.setText(null);
			memoJArea.setText(null);
		}else{
			gTextField1.setText(sgodler.getName());
			dirTextField.setText(sgodler.getDirname());
			memoJArea.setText(sgodler.getMemo());
		}
	}

	/**
	 * 处理提交按钮
	 */
	private void SubmitButtonMousePressed(java.awt.event.MouseEvent evt)
	{
		if(gTextField1.getText().equals("")){
			JOptionPane.showMessageDialog(null,"请输入工作组的名字");
			return;
		}
		if(dirTextField.getText().equals("")){
			JOptionPane.showMessageDialog(null,"请输入工作组目录");
			return;
		}
		if(!dirTextField.getText().startsWith("/")){
			JOptionPane.showMessageDialog(null,"目录格式不对，请以“/”开头");
			return;
		}
		LinuxClient temp = LinuxClient.GetObj();
		BaseClass curType = new BaseClass();
		curType = temp.cur;   
		String computerId = curType.getId();


		SSHGroup newGroup1 = new SSHGroup();
		/************************未考虑改group所属的computer的 问题*****/
		Date SeverTime = new Date();
		SimpleDateFormat Severtimeformat = new SimpleDateFormat("yyyyMMddHHmmss");
		newGroup1.setCreatdate(SeverTime);//获得创建成功时的时间
		newGroup1.setId("G"+Severtimeformat.format(SeverTime));
		newGroup1.setName(gTextField1.getText());
		newGroup1.setDirname(dirTextField.getText());
		newGroup1.setType((byte)1);

		//在服务器上创建工作目录
		Ltest= new JLabel();
		SSHComputer selectComputer = new SSHComputer();
		//SSHComputer TC=LinuxClient.GetObj().GfindselectComputer(newGroup1.getId());
		Iterator <SSHComputer> it;
		for(it = LinuxClient.GetObj().cps.iterator(); it.hasNext();){
			selectComputer = (SSHComputer) it.next();
			if(selectComputer.getId().equals(selectComputer)) {
				break;
			}
		}
		newGroup1.setCp(selectComputer);
		try {
			this.createdirs(this.getOpenedConnection(selectComputer), dirTextField.getText(),"c");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		add(Ltest);
		Ltest.setBounds(120, 270, 90, 30);

		SAXReader reader = new SAXReader();
		try{
			//String filePath = this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/util/Config.xml";
			//System.out.println(filePath);

			Document doc = reader.read("Config.xml");
			OutputFormat format = OutputFormat.createPrettyPrint();
			Element root = doc.getRootElement();
			XMLWriter writer = null;// 声明写XML的对象

			List<Element> celements = root.elements();
			for(Element c : celements) {       	
				if( c.valueOf("@id").equals(computerId)) {
					SSHComputer cp = new SSHComputer();
					cp.setId(c.valueOf("@id"));        
					cp.setName(c.valueOf("@name"));
					cp.setType((byte) 0);
					cp.setMemo(c.valueOf("@memo"));

					SimpleDateFormat timeFormat;
					timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					cp.setCreatdate(timeFormat.parse(c.valueOf("@creatdate")));
					cp.setHost(c.valueOf("@host"));
					cp.setUsername(c.valueOf("@user"));
					cp.setPassword(c.valueOf("@pswd"));
					cp.setGps(new ArrayList<SSHGroup>());
					newGroup1.setCp(cp);//指示出该组的父节点
					/****************************************************/
					Element g = c.addElement("group");
					g.addAttribute("id", newGroup1.getId());
					g.addAttribute("name", newGroup1.getName());   		
					g.addAttribute("dirname", newGroup1.getDirname()); 
					g.addAttribute("creatdate",timeFormat.format(newGroup1.getCreatdate())); 
					g.addAttribute("memo", newGroup1.getMemo()); 
					break;
				}
			}
			writer = new XMLWriter(new FileWriter("Config.xml"), format);
			writer.write(doc);
			writer.close();
			if (flag) {
				this.setVisible(false);
				this.dispose();
				JOptionPane.showMessageDialog(null, "创建组成功！");
			}//else JOptionPane.showMessageDialog(null, "创建组失败！");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//-----------------------------------------------------//

	private void SubmitMousePressedE(java.awt.event.MouseEvent evt)
	{
		if(gTextField1.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null,"请输入工作组的名字");
			return;
		}
		if(dirTextField.getText().equals("")){
			JOptionPane.showMessageDialog(null,"请输入工作组目录");
			return;	  
		}
		if(!dirTextField.getText().startsWith("/")){
			JOptionPane.showMessageDialog(null,"目录格式不对，请以“/”开头");
			return;
		}

		//在服务器上创建工作目录
		if(!older.equals(dirTextField.getText())){
			Ltest= new JLabel();
			SSHComputer selectComputer = LinuxClient.GetObj().GfindselectComputer(LinuxClient.GetObj().getCur().getId());
			try {
				this.createdirs(this.getOpenedConnection(selectComputer), dirTextField.getText(),"m");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			add(Ltest);
			Ltest.setBounds(120, 270, 90, 30);}
		//LinuxClient temp = new LinuxClient();
		//SSHGroup t=(SSHGroup)temp.cur;
		this.EditGroupFromXML(LinuxClient.getCur().getId(), gTextField1.getText(), dirTextField.getText(), memoJArea.getText());
		if (flag) {
			this.setVisible(false);
			this.dispose();
			JOptionPane.showMessageDialog(null, "修改组成功！");
		}else flag = true;
	}

	//-----------------------------------------------//
	//根据id修改某个任务组
	public void EditGroupFromXML(String id,String n,String d,String memo)
	{		
		SAXReader reader = new SAXReader();
		try{
			//String filePath = this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/util/Config.xml";
			Document doc = reader.read("Config.xml");
			OutputFormat format = OutputFormat.createPrettyPrint();
			Element root = doc.getRootElement();
			XMLWriter writer = null;// 声明写XML的对象
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
					if(s.equals(id))
					{
						et.addAttribute("name",n);
						et.addAttribute("dirname",d);
						et.addAttribute("memo",memo);

					}
				}
			}
			writer = new XMLWriter(new FileWriter("Config.xml"), format);
			writer.write(doc);
			writer.close();   
		}
		catch(Exception e ){
			e.printStackTrace();
		}
	}

	//---------------------------------------------//创建目录
	private  void createdirs(Connection conn,String dirs,String type) throws IOException {


		//Connection conn = getOpenedConnection(TC);
		Ltest.setText("正在设置目录...");
		Session sess = conn.openSession();
		String finalcmd = dirs.substring(1);
		//		    while(finalcmd.endsWith("/")){
		//		    	finalcmd = finalcmd.substring(0, finalcmd.length()-2);
		//		    }
		//		    if(type.equals("m")){
		//		    	String orin = this.older.substring(1);
		//		    	int i = finalcmd.lastIndexOf("/");
		//		    	String newdir = "";
		//		    	if(i>0)newdir = " mkdir -p "+finalcmd.substring(0, i)+" ;";		    	
		//		    	sess.execCommand("./squarlhan/CShell "+ newdir + " mv " + orin + " " + finalcmd.trim());
		//		    }else 
		sess.execCommand("./squarlhan/CShell mkdir -p " + finalcmd.trim());

		String out;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sess.getStdout()));    
		while((out=bufferedReader.readLine())!=null) {
			if(out.equals("EOP")){
				Ltest.setText("设置目录成功！");
				this.flag = true;

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

	/**
	 * 
	 * 主函数
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GroupUI().setVisible(true);
			}
		});
	}

}
