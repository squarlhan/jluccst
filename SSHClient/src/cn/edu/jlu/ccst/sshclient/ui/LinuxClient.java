package cn.edu.jlu.ccst.sshclient.ui;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LinuxClient.java
 *
 * Created on 2009-6-30, 14:09:55
 */

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SFTPv3Client;
import ch.ethz.ssh2.SFTPv3FileAttributes;
import ch.ethz.ssh2.Session;
import cn.edu.jlu.ccst.sshclient.model.BaseClass;
import cn.edu.jlu.ccst.sshclient.model.SSHComputer;
import cn.edu.jlu.ccst.sshclient.model.SSHGroup;
import cn.edu.jlu.ccst.sshclient.model.SSHTask;
import cn.edu.jlu.ccst.sshclient.ui.ComputerUI;
import cn.edu.jlu.ccst.sshclient.ui.MyTreeCellRender;
import cn.edu.jlu.ccst.sshclient.ui.TaskUI;
import cn.edu.jlu.ccst.sshclient.util.MidScr;
import cn.edu.jlu.ccst.sshclient.util.SSHOpCommand;
import cn.edu.jlu.ccst.sshclient.util.StartExam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.*;
/**
 *
 * @author Woden
 */
public class LinuxClient extends javax.swing.JFrame {

	/** Creates new form LinuxClient */
	private  LinuxClient() {
		res = ResourceBundle.getBundle( "cn.edu.jlu.ccst.sshclient.ui.lang.RES");
		flag=1;
		this.setLocationRelativeTo(null);
		this.setBackground(Color.WHITE);
		
		initComponents();
		updata();		
		
		for(int i=0; i<cps.size(); i++){
			String host = cps.get(i).getHost();
			String userName = cps.get(i).getUsername();
			String psw = cps.get(i).getPassword();
//			System.out.println("host:"+host);
//			System.out.println("userName:"+userName);
//			System.out.println("psw:"+psw);
//			System.exit(1);
			SSHOpCommand ss = new SSHOpCommand(host,userName,psw,
					jTextArea1, 6);
			Thread tt = new Thread(ss);
			tt.start();
		}
		
		SimpleDateFormat timeFormat;
		timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Object[][] rowData = new Object[cps.size()][4];
		
		for(int a = 0; a<= cps.size()-1;a++){
			rowData[a][0] = "  "+cps.get(a).getName();
			rowData[a][1] = timeFormat.format(cps.get(a).getCreatdate());
			rowData[a][2] = cps.get(a).getId();
			rowData[a][3] = cps.get(a).getMemo();
		}
        Object[] columnNames = {res.getString("PROPERTY_NAME"),
        		res.getString("PROPERTY_CREATE_TIME"),
        		res.getString("PROPERTY_ID"),
        		res.getString("PROPERTY_MEMO")};
		jtable = new JTable(rowData,columnNames);
		jtable.getTableHeader().setReorderingAllowed(false);
		jtable.setShowGrid(false);
		MyTableModel model =new MyTableModel(rowData, columnNames); 
		jtable.setModel(model); 
		jtable.setBackground(Color.WHITE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		jtable.getColumn(res.getString("PROPERTY_NAME")).setPreferredWidth(150);
		jtable.getColumn(res.getString("PROPERTY_CREATE_TIME")).setPreferredWidth(200);
		jtable.getColumn(res.getString("PROPERTY_ID")).setPreferredWidth(150);
		jtable.getColumn(res.getString("PROPERTY_MEMO")).setPreferredWidth((int) (screenSize.width*0.75-500));
		jtable.setAutoResizeMode(jtable.AUTO_RESIZE_OFF);
		jScrollPane2.setViewportView(jtable);
		jtable.addMouseListener(new mymouse());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	static public LinuxClient GetObj()
	{
		if(flag==0)
		{
			Obj=new LinuxClient();
			return Obj;
		}
		else
		{
			return Obj;
		}

	}

	//updata the jtree
	@SuppressWarnings("static-access")
	public void  updata() {

		this.cps = new ArrayList();
		this.gps = new ArrayList();
		this.tks = new ArrayList();

		//下面根据xml文件生成所需要的类
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read("Config.xml");
			Element root = doc.getRootElement();
			List<Element> celements = root.elements();
			for (Element c : celements) {
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
				cp.setGps(new ArrayList());
				this.cps.add(cp);
				List<Element> gelements = c.elements();
				for (Element g : gelements) {
					SSHGroup gp = new SSHGroup();
					gp.setId(g.valueOf("@id"));
					gp.setName(g.valueOf("@name"));
					gp.setDirname(g.valueOf("@dirname"));
					gp.setType((byte) 1);
					gp.setMemo(g.valueOf("@memo"));
					gp.setCreatdate(timeFormat.parse(g.valueOf("@creatdate")));
					gp.setCp(cp);
					gp.setRunpid(g.valueOf("@pid"));
					gp.setSts(new ArrayList());
					cp.getGps().add(gp);
					this.gps.add(gp);                
					List<Element> telements = g.elements();
					for (Element t : telements) {
						SSHTask tk = new SSHTask();
						tk.setId(t.valueOf("@id"));
						tk.setName(t.valueOf("@name"));
						tk.setDirname(t.valueOf("@dirname"));
						tk.setPid(t.valueOf("@runpid"));
//						System.out.println("tk.getPid()"+tk.getPid());
						tk.setType((byte) 2);
						tk.setMemo(t.valueOf("@memo"));
						tk.setCreatdate(timeFormat.parse(t.valueOf("@creatdate")));
						tk.setCmd(t.valueOf("@cmd"));
						tk.setInfiles("");
						tk.setFin("");
						tk.setFout(t.valueOf("@out"));
						tk.setFouts(t.valueOf("@outfiles"));
						tk.setOpts(t.valueOf("@opts"));
						List<Element> felements = t.elements();
						for(Element f : felements){
							if(f.getTextTrim().length()>0){
								tk.setInfiles(tk.getInfiles()+f.getTextTrim()+"; ");
								tk.setFin(tk.getFin()+f.valueOf("@url")+"; ");
							}
						}
						if(t.valueOf("@starttime").equals("")){
							tk.setStartTime(null);
							tk.setRunTime(0);
						}
						else {
							tk.setStartTime(timeFormat.parse(t.valueOf("@starttime")));                  
							String str = t.valueOf("@runsc");
							tk.setRunTime(Long.parseLong(t.valueOf("@stimelong")));
							boolean tmp = false;
							if(str.equals("1")) {
								tmp = true;
								if(first&&t.valueOf("@cmd").startsWith("./"))
								{
									first=false;
									File f=new File(".\\");
									File[] fList=f.listFiles(); 
									for(int i=0;i<fList.length;i++)
									{
										//System.out.println(".\\"+t.valueOf("@id"));
										if((fList[i].toString().startsWith(".\\"+t.valueOf("@id"))))
										{

											//System.out.println("start");
											String s=fList[i].toString().substring(fList[i].toString().indexOf("_")+1, fList[i].toString().indexOf("t")-1);
											System.out.println("S:"+s);
											String rem=null;

											rem=t.valueOf("@cmd").substring(t.valueOf("@cmd").indexOf(" "), t.valueOf("@cmd").length());
											rem=rem.trim();
											rem=rem.substring(rem.indexOf(" "),rem.length());
											rem=rem.trim();
											rem=rem.substring(0,rem.indexOf(" "));


											System.out.println("rem"+rem);
											Thread Check=new Thread(new StartExam(t.valueOf("@id"),s, c.valueOf("@host"),c.valueOf("@user"),c.valueOf("@pswd"),t.valueOf("@out"),rem));
											Check.start();
										}
									}
								}
							}
							tk.setRunSucc(tmp);
//							if(!tk.getCmd().startsWith("./")) {
//								tk.setRunSucc(false);
//							}
//							else {
//								//如果自定任务正在执行,获得自定任务的pid.
//								if(tmp == true) {
//									tk.setPid(t.valueOf("@runpid"));
//								}
//							}
						}

						List<String> params = new ArrayList();
						List<Element> pelements = t.elements();
						for(Element p : pelements){
							params.add(p.elementTextTrim("param"));
						}
						tk.setParams(params);
						tk.setGp(gp);
						gp.getSts().add(tk);
						this.tks.add(tk);
					}

				}
			}
			Iterator<SSHComputer> it;
			SSHComputer tmp = new SSHComputer();
			for(it = cps.iterator(); it.hasNext();){
				tmp = (SSHComputer)it.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		GenerateTree();
	}
	//--------------------------------------------------------------------------//
	public void expandAll(JTree tree, boolean expand) {
		TreeNode root = (TreeNode)tree.getModel().getRoot();

		// Traverse tree from root
		expandAll(tree, new TreePath(root), expand);
	}
	@SuppressWarnings("unchecked")
	private void expandAll(JTree tree, TreePath parent, boolean expand) {
		// Traverse children
		TreeNode node = (TreeNode)parent.getLastPathComponent();
		if (node.getChildCount() >= 0) {
			for (Enumeration e=node.children(); e.hasMoreElements(); ) {
				TreeNode n = (TreeNode)e.nextElement();
				TreePath path = parent.pathByAddingChild(n);
				expandAll(tree, path, expand);
			}
		}

		// Expansion or collapse must be done bottom-up
		if (expand) {
			tree.expandPath(parent);
		} else {
			tree.collapsePath(parent);
		}
	}
	//------------------------------------------------------------------------//
	/*构建生成的Computer树*/
	public void GenerateTree() {
		//下面开始构建树
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(res.getString("COMS"), true);
		for(SSHComputer c : cps){
			DefaultMutableTreeNode tcp = new DefaultMutableTreeNode(c,true);
			root.add(tcp);
			if(c.getGps() != null){
				for(SSHGroup g: c.getGps()){
					DefaultMutableTreeNode tgp = new DefaultMutableTreeNode(g,true);
					tcp.add(tgp);
					if(g.getSts() != null){
						for(SSHTask t : g.getSts()){
							DefaultMutableTreeNode ttk = new DefaultMutableTreeNode(t,true);
							tgp.add(ttk);
						}
					}
				}
			}
		}
		jTree1 = new JTree(root);       
		jScrollPane1.setViewportView(jTree1);       
		jTree1.setCellRenderer(new MyTreeCellRender());
		jTree1.addMouseListener(new thismouse());
		jScrollPane1.setViewportView(jTree1);

		
		expandAll(jTree1, true);
        jTree1.updateUI();

	}

	/**
	 * 对右键的相应操作
	 * @param e
	 * @throws DocumentException
	 */
	private void action ( ActionEvent e ) throws DocumentException
	{
		String str = e.getActionCommand(); 
		if(str.startsWith("删除")||str.startsWith("Delete"))
		{
			if(cur==null)
			{
				SAXReader reader = new SAXReader();
				Document doc = reader.read("Config.xml");
				List   list=doc.selectNodes("/config/computer");
				Iterator iter = list.iterator();             
				while(iter.hasNext())
				{
					Element el=(Element)iter.next();
					el.getParent().remove(el); 
				} 
				try{              
					XMLWriter writer = new XMLWriter(new FileOutputStream("Config.xml"));	   	 
					writer.write(doc);
					writer.close();
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			else
			{

				switch(cur.getType())
				{
				case 0:
				{
					SSHComputer Com=new SSHComputer();
					Com = findselectComputer(cur.getId());
					List<SSHTask> listT;

					//判断计算机内是否有任务正在执行
					boolean fg = true;
					for(int i = 0; i < Com.getGps().size(); i++) {
						SSHGroup tempG = Com.getGps().get(i);
						if(fg == false) break;
						for(int j = 0; j < tempG.getSts().size(); j++) {
							SSHTask tempT = tempG.getSts().get(j);
							if(getTaskRunSucc(tempT.getId()) == true) {
								fg = false;
								break;
							}
						}
					}
					if(fg == true) {
						Com.remove();
					}
					else {
						JOptionPane.showMessageDialog(null, res.getString("TIP_NOT_DELETE"),null,JOptionPane.ERROR_MESSAGE);
					}
					break;
				}
				case 1:
				{
					SSHGroup Gro=new SSHGroup();
					Gro = findSelectGroup();

					//判断组内是否有任务正在执行
					boolean fg = true;
					for(int i = 0; i < Gro.getSts().size(); i++) {
						if(getTaskRunSucc(Gro.getSts().get(i).getId()) == true) {
							fg = false;
							break;
						}
					}
					if(fg == true){
						Gro.remove();
					}
					else {
						JOptionPane.showMessageDialog(null, res.getString("TIP_NOT_DELETE"),null,JOptionPane.ERROR_MESSAGE);
					}
					break;
				}
				case 2:
				{
					SSHTask tas=new SSHTask();
					if(getTaskRunSucc(cur.getId()) == false) {
						tas = (SSHTask)cur;
						tas.remove();
					}
					else {
						JOptionPane.showMessageDialog(null, res.getString("TIP_NOT_DELETE"),null,JOptionPane.ERROR_MESSAGE);
						break;
					}
					for(int i=0;i<jsl.size();i++)
					{
						if(jsl.get(i).getName().equals(cur.getId()))
						{
//							jTabbedPane1.remove(jsl.get(i));
							jsl.remove(i);
							break;
						}
					}
					for(int i=0;i<jtl.size();i++)
					{
						if(jtl.get(i).getName().equals(cur.getId()));
						{
							jtl.remove(i);
							break;
						}
					}
					break;
				}
				default:
					break;
				}
			}    
			updata(); 
		}
		if(str.startsWith("添加")||str.startsWith("Add"))
		{
			if(cur==null)
			{
				SSHComputer Com=new SSHComputer();
				Com.creat();
				Com=null;
			}
			else
			{
				switch(cur.getType())
				{
				case 0:
				{
					SSHGroup Gro=new SSHGroup();
					Gro.creat();
					Gro=null;
					break;
				}
				case 1:
				{
					if(str.startsWith("添加一")||str.startsWith("Add a")){
						SSHTask Tas = new SSHTask();
						Tas.creat();
						SSHComputer TC = GfindselectComputer(cur.getId());
						break;
					}
					else {
						MulityTaskUI newMTask = new MulityTaskUI();
						newMTask.setModal(true);
						newMTask.setVisible(true);
						break;
					}
				}
				default:
					break;
				}
			}
			updata();
		}
		if(str.startsWith("修改")||str.startsWith("Modify"))
		{
			switch(cur.getType())
			{
			case 0:
			{
				SSHComputer Com=new SSHComputer();
				Com.update();
				break;
			}
			case 1:
			{
				SSHGroup Gro=new SSHGroup();
				Gro.update();
				break;
			}
			case 2:
			{
				SSHTask tas=new SSHTask();
				tas.update();
				break;
			}
			default:
				break;
			}
			updata();
		}

	}

	//-----------------------------------------------------------------------//
	/**
	 * 找到选中的任务
	 */
	public SSHTask findSelectTask(String id) {
		SSHTask selectTask = new SSHTask();
		Iterator <SSHTask> it;
		SSHGroup selectGroup = new SSHGroup();
		//寻找选中的任务
		for(it = tks.iterator(); it.hasNext() ;) {
			selectTask = (SSHTask) it.next();
			if(selectTask.getId().equals(id)) {
				break;
			}
		}
		return selectTask;

	}

	//------------------------------------------------------------------------//
	/**
	 * 设置相应的任务运行状态
	 */
	public void setSelTaskStatus(String str,int t) {
		for(int i = 0; i < tks.size(); i++) {
			if(tks.get(i).getId().equals(str)) {
				tks.get(i).setStatus(t);
				return;
			}
		}
	}
	public int getSelTaskStatus(String str) {
		for(int i = 0; i < tks.size(); i++) {
			if(tks.get(i).getId().equals(str))
				return tks.get(i).getStatus();
		}
		return 0;
	}
	//-----------------------------------------------------------------------//
	/**
	 * 设置任务运行成功
	 */
	public void setTaskRunSucc(String Id,boolean t) {
		for( int i = 0; i < tks.size(); i++) {
			if(tks.get(i).getId().equals(Id)) {
				tks.get(i).setRunSucc(t);
				//System.out.println("run sucss!");
				return;
			}
		}

	}
	public boolean getTaskRunSucc(String Id) {
		for( int i = 0; i < tks.size(); i++) {
			if(tks.get(i).getId().equals(Id)) {
				return tks.get(i).getRunSucc();
			}
		}
		return false;
	}
	//------------------------------------------------------------------------//
	/**
	 * 执行选中任务的命令
	 */
	private void execTaskCommand ( ActionEvent e ) throws DocumentException {

		boolean flag=false;
		JFrame fr = new JFrame();
		fr.setSize(600,600);
		//使用中心定位窗体类
		MidScr ms=new MidScr(fr);
		//设定窗体的左上坐标
		fr.setLocation(ms.getX(), ms.getY ()); 
		Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/faver.png"));
		fr.setIconImage(img);
		t1 = null;
		JScrollPane t2=null;
		for(int i=0;i<jtl.size();i++)
		{
			if(jtl.get(i).getName().equals(cur.getId()))
			{
				flag=true;
				t1=jtl.get(i);
			}
		}
		if(!flag)
		{
			t1=new JTextArea(cur.getId()+"\n");
			t1.setName(cur.getId());
			t2=new JScrollPane();
			t2.setName(cur.getId());
//			System.out.println("line 582");
			fr.add(t2);
			t2.add(t1);
			t1.setColumns(20);
			t1.setRows(5);
			t1.setEditable(false);
			t2.setViewportView(t1);
			//jTabbedPane1.addTab(cur.getName(), t2);
			fr.setVisible(true);
			t1.addMouseListener(new MouseAdapter()
			{ 
				public void mouseReleased(MouseEvent e)
				{
					//是否右键单击
					if (e.getClickCount() == 1 && SwingUtilities.isRightMouseButton(e))
					{
						JTextArea temp=(JTextArea)e.getComponent();
						if(temp.getSelectedText()==null)
						{
							copyTA.setEnabled(false);
						}
						else
						{
							copyTA.setEnabled(true);
						}
						if(old!=null)
						{
							copyTA.removeActionListener(old);
							shutTA.removeActionListener(old);
							clearTA.removeActionListener(old);
						}
						old=new TARight(temp);
						copyTA.addActionListener(old);
						shutTA.addActionListener(old);
						clearTA.addActionListener(old);
						popMenuTA.show(temp,e.getX(),e.getY());
					}
				}
			}
			);

		}



		if(execItemT.isEnabled()||jMenuItem14.isEnabled()) {

			jTextArea2.setText("");
			setSelTaskStatus(cur.getId(),1);
			SSHTask selectTask = new SSHTask();
			
			//寻找选中的任务
			int i;
			for( i = 0; i < tks.size() ; i++) {
				if(cur.getId().equals(tks.get(i).getId())) {
					selectTask = tks.get(i);
					break;
				}
			}
			fr.setTitle(selectTask.getName());
			Date curtime = new Date();
			selectTask.setStartTime(curtime);
			long t = System.currentTimeMillis();
			selectTask.setRunTime(t);
			//System.out.println(t);
			//System.out.println(curtime);

			//将任务开始时间写入XML文件中
			TaskUI tempUI = new TaskUI();
			try
			{
				tempUI.EditTaskFromXML(selectTask.getId(), selectTask.getName(), selectTask.getDirname(),selectTask.getMemo(),
						selectTask.getCmd(), selectTask.getFin(), selectTask.getFout(), curtime,t, selectTask.getFouts(), selectTask.getOpts(), selectTask.getInfiles());

				selectTask.start(t1);
				//System.out.println("ddover!");
			}catch(Exception em)
			{
				em.printStackTrace();
			}
		}

	}

	//---------------------------------------------------------------//
	/**
	 * 下载选中任务的输出文件
	 */
	private void downloadCommand( ActionEvent e) throws DocumentException	{
		SSHTask selectTask = new SSHTask();
		
		//寻找选中的任务
		int i;
		for( i = 0; i < tks.size() ; i++) {
			if(cur.getId().equals(tks.get(i).getId())) {
				selectTask = tks.get(i);
				break;
			}
		}
		SSHComputer selectComputer = new SSHComputer();
		selectComputer = selectTask.getGp().getCp();
		//获得下载命令的相关信息
		String computerHost = selectComputer.getHost();
		String userName = selectComputer.getUsername();
		String userPsw = selectComputer.getPassword();

		int beginIndex = 0;
		int endIndex = 0;
		String separate = ";";
		String sourceDir = "."+selectTask.getDirname();
		String sourceFiles = selectTask.getFouts();
		if(!sourceFiles.endsWith(separate))
			sourceFiles = sourceFiles + separate;
		System.out.println(sourceFiles);
		endIndex = sourceFiles.indexOf(separate);
		while (endIndex != -1){
			String fileOut = sourceFiles.substring(beginIndex, endIndex);
			String sourceFile=sourceDir+"/"+fileOut;
			beginIndex = endIndex + 1;
			sourceFiles = sourceFiles.substring(beginIndex).trim();
			String aimDir = selectTask.getFout();
			if(aimDir.endsWith("\\"))
			{
				aimDir=aimDir.substring(0, aimDir.length()-1);
				System.out.println(aimDir);
			}
			String aimFile = aimDir+"\\"+fileOut;
			System.out.println("sourceFile:"+sourceFile);
			System.out.println("aimFile:"+aimFile);
			System.out.println("aimDir:"+aimDir);
			SSHOpCommand sc = new SSHOpCommand(computerHost, userName, userPsw);
			Connection conn = sc.getOpenedConnection();
			if(conn == null){
				JOptionPane.showMessageDialog(null, res.getString("TIP_NETWORK"), res.getString("TITLE_NETWORK"), JOptionPane.ERROR_MESSAGE);
			}
			SFTPv3Client s3c = null;
			boolean fileExist = true;
			SFTPv3FileAttributes sfa = null;

			//判断源文件和目标文件是否存在
			try{
				s3c = new SFTPv3Client(conn);
				sfa = s3c.stat(sourceFile);
			}catch(IOException ee){
				fileExist = false;
			}
			s3c.close();
			beginIndex = 0;
			endIndex = sourceFiles.indexOf(separate);
			if(!fileExist){
				System.out.println("源文件不存在");
				JOptionPane.showMessageDialog(null, res.getString("TIP_NO_SOURCE"), res.getString("TITLE_NO_SOURCE"), JOptionPane.ERROR_MESSAGE);
			}else{
				File file= new File(aimFile);
				if(file.exists()){
					int tt = JOptionPane.showConfirmDialog(null, sourceFile+res.getString("TIP_FILE_EXIST"), res.getString("TITLE_FILE_EXIST"), JOptionPane.YES_NO_OPTION);
					if(JOptionPane.NO_OPTION == tt)
					{
						continue;
					}else{
						file.delete();
					}
				}
				ProgressBar pb = new ProgressBar(conn, sourceFile, aimFile, aimDir, 1);
				pb.setVisible(true);	
			}

		}
	}
	//-------------------------------------------------------------//
	public void downloadGCommand( ActionEvent e) throws DocumentException{
			
		SSHGroup sgp = new SSHGroup();
		sgp = findSelectGroup();//找到当前选中的组
		SSHComputer selectComputer = new SSHComputer();
		selectComputer = sgp.getCp();
		//获得下载命令的相关信息
		String computerHost = selectComputer.getHost();
		String userName = selectComputer.getUsername();
		String userPsw = selectComputer.getPassword();
		SSHTask selectTask = new SSHTask();
		for(int i = 0; i < sgp.getSts().size(); ++i) {		
			selectTask = sgp.getSts().get(i);
			int beginIndex = 0;
			int endIndex = 0;
			String separate = ";";
			String sourceDir = "."+selectTask.getDirname();
			String sourceFiles = selectTask.getFouts();
			endIndex = sourceFiles.indexOf(separate);
			while (endIndex != -1){
				String fileOut = sourceFiles.substring(beginIndex, endIndex);
				String sourceFile=sourceDir+"/"+fileOut;
				beginIndex = endIndex + 1;
				sourceFiles = sourceFiles.substring(beginIndex).trim();
				String aimDir = selectTask.getFout();
				if(aimDir.endsWith("\\"))
				{
					aimDir=aimDir.substring(0, aimDir.length()-1);
					System.out.println(aimDir);
				}
				String aimFile = aimDir+"\\"+fileOut;
				System.out.println("sourceFile:"+sourceFile);
				System.out.println("aimFile:"+aimFile);
				System.out.println("aimDir:"+aimDir);
				SSHOpCommand sc = new SSHOpCommand(computerHost, userName, userPsw);
				Connection conn = sc.getOpenedConnection();
				if(conn == null){
					JOptionPane.showMessageDialog(null, res.getString("TIP_NETWORK"), res.getString("TITLE_NETWORK"), JOptionPane.ERROR_MESSAGE);
				}
				SFTPv3Client s3c = null;
				boolean fileExist = true;
				SFTPv3FileAttributes sfa = null;

				//判断源文件和目标文件是否存在
				try{
					s3c = new SFTPv3Client(conn);
					sfa = s3c.stat(sourceFile);
				}catch(IOException ee){
					fileExist = false;
				}
				s3c.close();
				beginIndex = 0;
				endIndex = sourceFiles.indexOf(separate);
				if(!fileExist){
					System.out.println("源文件不存在");
					JOptionPane.showMessageDialog(null, res.getString("TIP_NO_SOURCE"), res.getString("TITLE_NO_SOURCE"), JOptionPane.ERROR_MESSAGE);
				}else{
					File file= new File(aimFile);
					if(file.exists()){
						int tt = JOptionPane.showConfirmDialog(null, sourceFile+res.getString("TIP_FILE_EXIST"), res.getString("TITLE_FILE_EXIST"), JOptionPane.YES_NO_OPTION);
						if(JOptionPane.NO_OPTION == tt)
						{
							continue;
						}else{
							file.delete();
						}
					}
					ProgressBar pb = new ProgressBar(conn, sourceFile, aimFile, aimDir, 1);
					pb.setVisible(true);	
				}

			}
		}
	}

	//---------------------------------------------------------------//
	private void uploadCommand( ActionEvent e) throws DocumentException	{
		upload();

	}
	static public void upload() {
		SSHTask selectTask = new SSHTask();
		boolean key = true;
		boolean fileExist = true;
		//寻找选中的任务
		int i;
		for( i = 0; i < tks.size() ; i++) {
			if(cur.getId().equals(tks.get(i).getId())) {
				selectTask = tks.get(i);
				break;
			}
		}
		SSHComputer selectComputer = new SSHComputer();
		selectComputer = selectTask.getGp().getCp();
		//获得上传命令的相关信息
		String computerHost = selectComputer.getHost();
		String userName = selectComputer.getUsername();
		String userPsw = selectComputer.getPassword();
		int beginIndex = 0;
		int endIndex = 0;
		String separate = ";";
		String aimDir = "."+selectTask.getDirname();
		String sourceFiles = selectTask.getFin();
		System.out.println("sourceFiles:"+sourceFiles);
		System.out.println();
		String aimFiles = selectTask.getInfiles();
		System.out.println("aimFiles:"+aimFiles);
		endIndex = sourceFiles.indexOf(separate);
		while (endIndex != -1){
			String sourceFile=sourceFiles.substring(beginIndex, endIndex);
			beginIndex = endIndex + 1;
			sourceFiles = sourceFiles.substring(beginIndex).trim();

			beginIndex = 0;
			endIndex = aimFiles.indexOf(separate);
			String aimFile = aimDir+"/"+aimFiles.substring(beginIndex, endIndex);
			beginIndex = endIndex + 1;
			aimFiles = aimFiles.substring(beginIndex).trim();
			System.out.println("aimFiles:"+aimFiles);

			SSHOpCommand sc = new SSHOpCommand(computerHost, userName, userPsw);
			Connection conn = sc.getOpenedConnection();
			if(conn == null){
				JOptionPane.showMessageDialog(null, res.getString("TIP_NETWORK"), res.getString("TITLE_NETWORK"), JOptionPane.ERROR_MESSAGE);
				return;
			}
				SFTPv3Client s3c = null;
	
				System.out.println("sourceFile:"+sourceFile);
				System.out.println("aimDir:"+aimDir);
				System.out.println("aimFile:"+aimFile);
				SFTPv3FileAttributes sfa = null;
				File file= new File(sourceFile);
				beginIndex = 0;
				endIndex = sourceFiles.indexOf(separate);
				//判断源文件和目标文件是否存在
				if(!file.exists()){
					JOptionPane.showMessageDialog(null, res.getString("TIP_NO_SOURCE"), res.getString("TITLE_NO_SOURCE"), JOptionPane.ERROR_MESSAGE);
				}else{
					try{
						s3c = new SFTPv3Client(conn);
						sfa = s3c.stat(aimFile);
					}catch(IOException ee){
						fileExist = false;
					}
					
					if(fileExist){
						System.out.println("文件存在");
						int tt = JOptionPane.showConfirmDialog(null, sourceFile+res.getString("TIP_FILE_EXIST"), res.getString("TITLE_FILE_EXIST"), JOptionPane.YES_NO_OPTION);
						if(JOptionPane.NO_OPTION == tt)
						{
							continue;
						}else{
							try{
								s3c.rm(aimFile);
							}catch(IOException ee){
								System.out.println("删除目标文件失败");
							}
						}
					}
					s3c.close();
					ProgressBar pb = new ProgressBar(conn, sourceFile, aimFile, aimDir,2);
				}
				
			}
	}
	//-------------------------------------------------------------//
	static public void upload(int taskAmount, String inFiles, String inFilesP, String dir ) {
		SSHGroup selectGroup = new SSHGroup();
		boolean key = true;
		boolean fileExist = true;
		//寻找选中的任务
		int i;
		for( i = 0; i < gps.size() ; i++) {
			if(cur.getId().equals(gps.get(i).getId())) {
				selectGroup = gps.get(i);
				break;
			}
		}
		SSHComputer selectComputer = new SSHComputer();
		selectComputer = selectGroup.getCp();
		//获得上传命令的相关信息
		String computerHost = selectComputer.getHost();
		String userName = selectComputer.getUsername();
		String userPsw = selectComputer.getPassword();
		int beginIndex = 0;
		int endIndex = 0;
		String separate = ";";
		String aimDir = "."+dir+"_"+1;
		String sourceFiles = inFilesP;
		System.out.println("sourceFiles:"+sourceFiles);
		System.out.println();
		String aimFiles = inFiles;
		System.out.println("aimFiles:"+aimFiles);
		endIndex = sourceFiles.indexOf(separate);
		while (endIndex != -1){
			String sourceFile=sourceFiles.substring(beginIndex, endIndex);
			beginIndex = endIndex + 1;
			sourceFiles = sourceFiles.substring(beginIndex).trim();

			beginIndex = 0;
			endIndex = aimFiles.indexOf(separate);
			String aimFile = aimDir+"/"+aimFiles.substring(beginIndex, endIndex);
			beginIndex = endIndex + 1;
			aimFiles = aimFiles.substring(beginIndex).trim();
			System.out.println("aimFiles:"+aimFiles);

			SSHOpCommand sc = new SSHOpCommand(computerHost, userName, userPsw);
			Connection conn = sc.getOpenedConnection();
			if(conn == null){
				JOptionPane.showMessageDialog(null, res.getString("TIP_NETWORK"), res.getString("TITLE_NETWORK"), JOptionPane.ERROR_MESSAGE);
				return;
			}
				SFTPv3Client s3c = null;
	
				System.out.println("sourceFile:"+sourceFile);
				System.out.println("aimDir:"+aimDir);
				System.out.println("aimFile:"+aimFile);
				SFTPv3FileAttributes sfa = null;
				File file= new File(sourceFile);
				beginIndex = 0;
				endIndex = sourceFiles.indexOf(separate);
				//判断源文件和目标文件是否存在
				if(!file.exists()){
					JOptionPane.showMessageDialog(null, res.getString("TIP_NO_SOURCE"), res.getString("TITLE_NO_SOURCE"), JOptionPane.ERROR_MESSAGE);
				}else{
					try{
						s3c = new SFTPv3Client(conn);
						sfa = s3c.stat(aimFile);
					}catch(IOException ee){
						fileExist = false;
					}
					
					if(fileExist){
						System.out.println("文件存在");
						int tt = JOptionPane.showConfirmDialog(null, sourceFile+res.getString("TIP_FILE_EXIST"), res.getString("TITLE_FILE_EXIST"), JOptionPane.YES_NO_OPTION);
						if(JOptionPane.NO_OPTION == tt)
						{
							continue;
						}else{
							try{
								s3c.rm(aimFile);
							}catch(IOException ee){
								System.out.println("删除目标文件失败");
							}
						}
					}
					s3c.close();
					ProgressBar pb = new ProgressBar(conn, sourceFile, aimFile, aimDir,2);
				}
				
			}
		String oriAimDir = "."+dir+"_"+1;
		sourceFiles = inFilesP;
		System.out.println("sourceFiles:"+sourceFiles);
		System.out.println();
		aimFiles = inFiles;
		System.out.println("aimFiles:"+aimFiles);
		endIndex = aimFiles.indexOf(separate);
		String cmd = "";
		Connection conn2 = null;
		for(i=2;i<taskAmount+1;i++){
			
			while (endIndex != -1){
				cmd += "cp ";
				beginIndex = 0;
				
				String sourceFile = oriAimDir+"/"+aimFiles.substring(beginIndex, endIndex);
				aimDir = "."+dir+"_"+i;
				System.out.println("aimFiles:"+aimFiles);
				String aimFile = aimDir+"/"+aimFiles.substring(beginIndex, endIndex);
				SSHOpCommand sc = new SSHOpCommand(computerHost, userName, userPsw);
				conn2 = sc.getOpenedConnection();
				if(conn2 == null){
					JOptionPane.showMessageDialog(null, res.getString("TIP_NETWORK"), res.getString("TITLE_NETWORK"), JOptionPane.ERROR_MESSAGE);
					return;
				}
				cmd += sourceFile+" ";
				cmd += aimFile+";";
				System.out.println("cmdIn"+cmd);
				beginIndex = endIndex + 1;
				aimFiles = aimFiles.substring(beginIndex).trim();
				endIndex = aimFiles.indexOf(separate);
			}
			aimFiles = inFiles;
			System.out.println("aimFiles:"+aimFiles);
			endIndex = aimFiles.indexOf(separate);
		}
		System.out.println("cmd:"+cmd);
		Session sess;
		try {
			sess = conn2.openSession();
			sess.execCommand(cmd);
			sess.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	//-------------------------------------------------------------//
	/**
	 * 停止选中任务
	 */
	private void stopTaskCommand( ActionEvent e ) throws DocumentException  {
		if(stopItemT.isEnabled()||jMenuItem15.isEnabled()) {
			setSelTaskStatus(cur.getId(),0);
			SSHTask stopTask = new SSHTask();
			stopTask = findSelectTask(cur.getId());
			stopTask.stop();
		}
	}


	//---------------------------------------------------------------//
	/**
	 * 串行启动组内的所有任务
	 */
	private void jMenuMousePressGroupStart(MouseEvent evt) {
		if( jMenuItem12.isEnabled() || groupStartG.isEnabled()) {
			boolean flag=false;
			JFrame fr = new JFrame();
			fr.setSize(600,600);
			//使用中心定位窗体类
			MidScr ms=new MidScr(fr);
			//设定窗体的左上坐标
			fr.setLocation(ms.getX(), ms.getY ()); 
			Toolkit tk = Toolkit.getDefaultToolkit();
	        Image img = tk.getImage(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/faver.png"));
			fr.setIconImage(img);
			jTextArea2.setText("");
			singlerun = 2;
			SSHGroup sgp = new SSHGroup();
			sgp = findSelectGroup();//找到当前选中的组
			fr.setTitle(sgp.getName());
			setGpsStatus(sgp.getId(),true);
			SSHComputer selectComputer = new SSHComputer();
			selectComputer = sgp.getCp();
			String computerHost = selectComputer.getHost();
			String userName = selectComputer.getUsername();
			String userPsw = selectComputer.getPassword();

			t1 = null;
			JScrollPane t2=null;
			for(int j=0;j<jtl.size();j++)
			{
				if(jtl.get(j).getName().equals(cur.getId()))
				{
					flag=true;
					t1=jtl.get(j);
				}
			}
			if(!flag)
			{
				t1=new JTextArea(sgp.getId()+"\n");
				t1.setName(sgp.getId());
				t2=new JScrollPane();
				t2.setName(sgp.getId());
				fr.add(t2);
				t2.add(t1);
				t1.setColumns(20);
				t1.setRows(5);
				t1.setEditable(false);
				t2.setViewportView(t1);
//				jTabbedPane1.addTab(sgp.getName(), t2);
				fr.setVisible(true);
				t1.addMouseListener(new MouseAdapter()
				{ 
					public void mouseReleased(MouseEvent e)
					{
						//是否右键单击
						if (e.getClickCount() == 1 && SwingUtilities.isRightMouseButton(e))
						{
							JTextArea temp=(JTextArea)e.getComponent();
							if(temp.getSelectedText()==null)
							{
								copyTA.setEnabled(false);
							}
							else
							{
								copyTA.setEnabled(true);
							}
							if(old!=null)
							{
								copyTA.removeActionListener(old);
								shutTA.removeActionListener(old);
								clearTA.removeActionListener(old);
							}
							old=new TARight(temp);
							copyTA.addActionListener(old);
							shutTA.addActionListener(old);
							clearTA.addActionListener(old);
							popMenuTA.show(temp,e.getX(),e.getY());
						}
					}
				}
				);
			}

			int taskInfo = 3;//开启任务信息：0	
			try{
				SSHOpCommand ry = new SSHOpCommand(computerHost, userName, userPsw, sgp.getSts(),t1,taskInfo);
				Thread ty = new Thread(ry);
				ty.start();
			}
			catch(Exception e) {
				e.printStackTrace();
			}	
		}	

	}

	//-------------------------------------------------------------------//
	/**
	 * 停止组内的所有串行任务
	 */
	private void jMenuMousePressGroupStop(MouseEvent evt) {
		if(jMenuItem11.isEnabled() || groupStopG.isEnabled()) {
			SSHGroup sgp = new SSHGroup();
			sgp = findSelectGroup();//找到当前选中的组
			SSHComputer selectComputer = new SSHComputer();
			selectComputer = sgp.getCp();
			String computerHost = selectComputer.getHost();
			String userName = selectComputer.getUsername();
			String userPsw = selectComputer.getPassword();	
			setGpsStatus(sgp.getId(),false);
			int taskInfo = 4;//开启任务信息：0	
			try{
				SSHOpCommand ry = new SSHOpCommand(computerHost, userName, userPsw, sgp.getSts(),taskInfo);
				ry.gid=sgp.getId();
				Thread ty = new Thread(ry);
				ty.start();
			}
			catch(Exception e) {
				e.printStackTrace();
			}	
		}
	}

	//----------------------------------------------------------------------//
	/**
	 * 同时启动组内的所有任务
	 */
	private void jMenuMousePressAllStartG(MouseEvent evt) {
		if(jMenuItem13.isEnabled() || allStartG.isEnabled()) {
			
			SSHGroup sgp = new SSHGroup();
			sgp = findSelectGroup();//找到当前选中的组
			SSHComputer selectComputer = new SSHComputer();
			selectComputer = sgp.getCp();
			String computerHost = selectComputer.getHost();
			String userName = selectComputer.getUsername();
			String userPsw = selectComputer.getPassword();
			singlerun = 3;

			SSHTask rstk = new SSHTask();
			int taskInfo = 0;
			for(int i = 0; i < sgp.getSts().size(); ++i) {	
				boolean flag=false;
				JFrame fr = new JFrame();
				fr.setSize(600,600);
				//使用中心定位窗体类
				MidScr ms=new MidScr(fr);
				//设定窗体的左上坐标
				fr.setLocation(ms.getX(), ms.getY ()); 
				Toolkit tk = Toolkit.getDefaultToolkit();
		        Image img = tk.getImage(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/faver.png"));
				fr.setIconImage(img);
				
				rstk = sgp.getSts().get(i);
				setSelTaskStatus(rstk.getId(),1);
				Date curtime = new Date();
				rstk.setStartTime(curtime);
				long timerun = System.currentTimeMillis();
				rstk.setRunTime(timerun);
				fr.setTitle(rstk.getName());
				//System.out.println(curtime);

				//将任务开始时间写入XML文件中
				TaskUI tempUI = new TaskUI();
				try
				{
					tempUI.EditTaskFromXML(rstk.getId(), rstk.getName(), rstk.getDirname(),rstk.getMemo(),
							rstk.getCmd(), rstk.getFin(), rstk.getFout(), curtime,timerun, rstk.getFouts(), rstk.getOpts(), rstk.getInfiles());
				}catch(Exception e)
				{
					e.printStackTrace();
				}



				///新建TAb
				t1 = null;
				JScrollPane t2=null;
				for(int j=0;j<jtl.size();j++)
				{
					if(jtl.get(j).getName().equals(rstk.getId()))
					{
						flag=true;
						t1=jtl.get(j);
					}
				}
				if(!flag)
				{
					t1=new JTextArea(rstk.getId()+"\n");
					t1.setName(rstk.getId());
					jtl.add(t1);
					t2=new JScrollPane();
					t2.setName(rstk.getId());
					fr.add(t2);
					jsl.add(t2);
					t2.add(t1);
					t1.setColumns(20);
					t1.setRows(5);
					t1.setEditable(false);
					t2.setViewportView(t1);
//					jTabbedPane1.addTab(rstk.getName(), t2);
					fr.setVisible(true);
					t1.addMouseListener(new MouseAdapter()
					{ 
						public void mouseReleased(MouseEvent e)
						{
							//是否右键单击
							if (e.getClickCount() == 1 && SwingUtilities.isRightMouseButton(e))
							{
								JTextArea temp=(JTextArea)e.getComponent();
								if(temp.getSelectedText()==null)
								{
									copyTA.setEnabled(false);
								}
								else
								{
									copyTA.setEnabled(true);
								}
								if(old!=null)
								{
									copyTA.removeActionListener(old);
									shutTA.removeActionListener(old);
									clearTA.removeActionListener(old);
								}
								old=new TARight(temp);
								copyTA.addActionListener(old);
								shutTA.addActionListener(old);
								clearTA.addActionListener(old);
								popMenuTA.show(temp,e.getX(),e.getY());
							}
						}
					}
					);

				}

				rstk.start(t1);
				//System.out.println("ddover!");
			}
		}

	}
	public boolean getAllRunStatus(String Id) {
		int i,j;
		for( i = 0; i < gps.size(); i++) {
			if(Id.equals(gps.get(i).getId())) 
				break;
		}
		boolean res = false;
		for(j = 0; j < gps.get(i).getSts().size(); ++ j) {
			int t = getSelTaskStatus(gps.get(i).getSts().get(j).getId());
			if(t == 1) break; 
		}
		if(j < gps.get(i).getSts().size() ){
			res = true; 
		}
		return res;
	}

	public boolean getAllRunSucc(String Id) {
		int i,j;
		for( i = 0; i < tks.size(); i++) {
			if(Id.equals(tks.get(i).getId())) 
				break;
		}
		SSHGroup sgp = tks.get(i).getGp();
		boolean res = false;
		for(j = 0; j < sgp.getSts().size(); ++ j) {
			boolean t = getTaskRunSucc(sgp.getSts().get(j).getId());
			if(t == true) break ;
		}
		if(j < sgp.getSts().size() ){
			res = true; 
		}
		return res;
	}
	//---------------------------------------------------------------------//
	/**
	 * 停止同时执行的所有任务
	 */
	private void jMenuMousePressAllStopG(MouseEvent evt) {
		if(jMenuItem16.isEnabled() || allStopG.isEnabled()) {
			SSHGroup sgp = new SSHGroup();
			sgp = findSelectGroup();//找到当前选中的组
			SSHTask tsk = new SSHTask();
			for(int i = 0; i < sgp.getSts().size(); ++i) {
				tsk = sgp.getSts().get(i);
				setSelTaskStatus(tsk.getId(),0);
				if(getTaskRunSucc(tsk.getId()) == true) {
					tsk.stop();
				}

			}
			singlerun = 1 ;
		}
	}
	//----------------------------------------------------------------------//
	/**
	 * 寻找选中的组
	 */
	private SSHGroup findSelectGroup() {
		for(int i = 0; i < gps.size() ; i++) {
			if(cur.getId().equals(gps.get(i).getId())) {
				return gps.get(i);
			}
		}	
		return null;
	}
	//-----------------------------------------------------------------------//
	/**
	 * 设置gps中选中的组的任务执行状态
	 */
	public void setGpsStatus(String Id, boolean t) {
		for(int i = 0; i < gps.size(); ++i) {
			if(gps.get(i).getId().equals(Id)) {
				gps.get(i).setGroupStatus(t);
				break;
			}
		}
	}
	public boolean getGpsStatus(String Id) {
		for(int i = 0; i < gps.size(); ++i) {
			if(gps.get(i).getId().equals(Id)) {
				return	gps.get(i).getGroupStatus();
			}
		}
		return false;
	}

	public void setGpsrunSucc(String Id, boolean t) {
		for(int i = 0; i < gps.size(); ++ i) {
			if(gps.get(i).getId().equals(Id)) {
				gps.get(i).setGroupRunSucc(t);
				break;
			}
		}
	}
	public boolean getGpsrunSucc(String Id) {
		for(int i = 0; i < gps.size(); ++ i) {
			if(gps.get(i).getId().equals(Id)) {
				return gps.get(i).getGroupRunSucc();
			}
		}
		return false;
	}


	//------------------------------------计算机的任务操作-------------------------//
	/**
	 * 根据gropu的id找到选中的计算机
	 */
	public SSHComputer GfindselectComputer(String id) 
	{
		for(int i = 0; i < cps.size(); i++) 
		{
			List<SSHGroup> t=cps.get(i).getGps();
			for(int j=0;j<t.size();j++)
			{
				if(t.get(j).getId().equals(id))
				{
					return cps.get(i);
				}

			}

		}
		return null;
	}
	/**
	 * 根据task的id找到选中的计算机
	 */
	public SSHComputer TfindselectComputer(String id) 
	{
		for(int i = 0; i < cps.size(); i++) 
		{
			List<SSHGroup> t=cps.get(i).getGps();
			for(int j=0;j<t.size();j++)
			{
				List<SSHTask> l=t.get(j).getSts();
				for(int k=0;k<l.size();k++)
				{
					if(l.get(k).getId().equals(id))
						return cps.get(i);
				}

			}

		}
		return null;
	}
	/**
	 * 找到选中的计算机
	 */
	public SSHComputer findselectComputer(String id) {
		for(int i = 0; i < cps.size(); i++) {
			if(id.equals(cps.get(i).getId())) {
				return cps.get(i);
			}
		}
		return null;
	}
	//设置计算机运行的状态
	public void setRunStatusC(String id,boolean t) {
		for(int i = 0; i < cps.size(); i++) {
			if(id.equals(cps.get(i).getId())){
				cps.get(i).setRunStatusC(t);
			}
		}
	}
	//获得计算机运行的状态
	public boolean getRunStatusC(String id) {
		for(int i = 0; i < cps.size(); i++) {
			if(id.equals(cps.get(i).getId())) {
				return cps.get(i).getRunStatusC();
			}
		}
		return false;
	}
	/**
	 *串行启动计算机内的所有任务
	 */
	private void computerStartAllGroupT (MouseEvent evt) {
		if(computerStartC.isEnabled()) {
			//找到选中的计算机
			JFrame fr = new JFrame();
			fr.setSize(600,600);
			//使用中心定位窗体类
			MidScr ms=new MidScr(fr);
			//设定窗体的左上坐标
			fr.setLocation(ms.getX(), ms.getY ()); 
			Toolkit tk = Toolkit.getDefaultToolkit();
	        Image img = tk.getImage(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/faver.png"));
			fr.setIconImage(img);
			jTextArea2.setText("");
			singlerun = 2;
			
			
			SSHComputer selectComputer = new SSHComputer();		  
			for(int i = 0; i < cps.size() ; i++) {
				if(cur.getId().equals(cps.get(i).getId())) {
					selectComputer = cps.get(i);
					break;
				}
			}
			setRunStatusC(selectComputer.getId(), true);
			fr.setTitle(selectComputer.getName());
			String computerHost = selectComputer.getHost();
			String userName = selectComputer.getUsername();
			String userPsw = selectComputer.getPassword();

			//新建TAb
			///新建TAb
			boolean flag=false;
			t1 = null;
			JScrollPane t2=null;
			for(int j=0;j<jtl.size();j++)
			{
				if(jtl.get(j).getName().equals(selectComputer.getId()))
				{
					flag=true;
					t1=jtl.get(j);
				}
			}
			if(!flag)
			{
				t1=new JTextArea(selectComputer.getId()+"\n");
				t1.setName(selectComputer.getId());
				t2=new JScrollPane();
				t2.setName(selectComputer.getId());
				fr.add(t2);
				t2.add(t1);
				t1.setColumns(20);
				t1.setRows(5);
				t1.setEditable(false);
				t2.setViewportView(t1);
//				jTabbedPane1.addTab(sgp.getName(), t2);
				fr.setVisible(true);
				
//				jTabbedPane1.addTab(selectComputer.getName(), t2);

				t1.addMouseListener(new MouseAdapter()
				{ 
					public void mouseReleased(MouseEvent e)
					{
						//是否右键单击
						if (e.getClickCount() == 1 && SwingUtilities.isRightMouseButton(e))
						{
							JTextArea temp=(JTextArea)e.getComponent();
							if(temp.getSelectedText()==null)
							{
								copyTA.setEnabled(false);
							}
							else
							{
								copyTA.setEnabled(true);
							}
							if(old!=null)
							{
								copyTA.removeActionListener(old);
								shutTA.removeActionListener(old);
								clearTA.removeActionListener(old);
							}
							old=new TARight(temp);
							copyTA.addActionListener(old);
							shutTA.addActionListener(old);
							clearTA.addActionListener(old);
							popMenuTA.show(temp,e.getX(),e.getY());
						}
					}
				}
				);
			}


			//找到计算机中的所有组
			List<SSHTask> liTask;
			liTask = new ArrayList();
			for(int i = 0; i < selectComputer.getGps().size(); i++) {
				SSHGroup temp = selectComputer.getGps().get(i);
				for(int j = 0; j < temp.getSts().size(); j++) {
					liTask.add(temp.getSts().get(j));
				}
			}

			int taskInfo = 3;//开启任务信息：0	
			try{
				SSHOpCommand ry = new SSHOpCommand(computerHost, userName, userPsw, liTask,t1,taskInfo);
				Thread ty = new Thread(ry);
				ty.start();
			}
			catch(Exception e) {
				e.printStackTrace();
			}	

		}
	}

	//------------------------------------------//
	/**
	 * 停止计算机的所有组的任务
	 */
	private void computerStopAllGroupT(MouseEvent evt) {
		if(computerStopC.isEnabled()) {
			//找到选中的计算机
			SSHComputer selectComputer = new SSHComputer();		  
			for(int i = 0; i < cps.size() ; i++) {
				if(cur.getId().equals(cps.get(i).getId())) {
					selectComputer = cps.get(i);
					break;
				}
			}
			setRunStatusC(selectComputer.getId(), false);
			String computerHost = selectComputer.getHost();
			String userName = selectComputer.getUsername();
			String userPsw = selectComputer.getPassword();	  

			//找到计算机中的所有组
			List<SSHTask> liTask;
			liTask = new ArrayList();
			for(int i = 0; i < selectComputer.getGps().size(); i++) {
				SSHGroup temp = selectComputer.getGps().get(i);
				for(int j = 0; j < temp.getSts().size(); j++) {
					liTask.add(temp.getSts().get(j));
				}
			}
			int taskInfo = 4;//开启任务信息：0	
			try{
				SSHOpCommand ry = new SSHOpCommand(computerHost, userName, userPsw, liTask,taskInfo);
				Thread ty = new Thread(ry);
				ty.start();
			}
			catch(Exception e) {
				e.printStackTrace();
			}	

		}
	}


	//-----------------------------------------------------------------------//
	//鼠标点击处理类
	private class mymouse extends  MouseAdapter{
			  
		public void mouseClicked(MouseEvent e) {
			SimpleDateFormat timeFormat;
			timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        if (e.getButton() == MouseEvent.BUTTON1) {// 单击鼠标左键
			    if (e.getClickCount() == 2) {
			        JTable tb = (JTable) e.getSource();
			    	//int colummCount = tb.getModel().getColumnCount();// 列数
			        if(tb.getModel().getValueAt(tb.getSelectedRow(), 2).toString().startsWith("C")){
			        	String cid = tb.getModel().getValueAt(tb.getSelectedRow(), 2).toString();
			        	for(int a = 0; a<= cps.size()-1; a++){
			        		if(cid==cps.get(a).getId()){
			        			Object[][] rows = new Object[cps.get(a).getGps().size()][5];
			        			for(int i = 0;i<=cps.get(a).getGps().size()-1;i++){
			        				rows[i][0] = "  "+cps.get(a).getGps().get(i).getName();
			        				rows[i][1] = timeFormat.format(cps.get(a).getGps().get(i).getCreatdate());
			        				rows[i][2] = cps.get(a).getGps().get(i).getId();
			        				rows[i][3] = cps.get(a).getGps().get(i).getDirname();
			        				rows[i][4] = cps.get(a).getGps().get(i).getMemo();
			        			}
			        			Object[] columnNames = {res.getString("PROPERTY_NAME"),
			        					res.getString("PROPERTY_CREATE_TIME"),
			        					res.getString("PROPERTY_ID"),
			        					res.getString("PROPERTY_WORKDIR"),
			        					res.getString("PROPERTY_MEMO")};
			        			jtable = new JTable(rows, columnNames);
			        			jtable.setShowGrid(false);
			        			jtable.getTableHeader().setReorderingAllowed(false);
			        			MyTableModel model =new MyTableModel(rows, columnNames); 
			        			jtable.setModel(model); 
			        			jtable.setBackground(Color.WHITE);
			        			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        			jtable.getColumn(res.getString("PROPERTY_NAME")).setPreferredWidth(150);
			        			jtable.getColumn(res.getString("PROPERTY_CREATE_TIME")).setPreferredWidth(200);
			        			jtable.getColumn(res.getString("PROPERTY_ID")).setPreferredWidth(150);
			        			jtable.getColumn(res.getString("PROPERTY_WORKDIR")).setPreferredWidth(200);
			        			jtable.getColumn(res.getString("PROPERTY_MEMO")).setPreferredWidth((int) (screenSize.width*0.75)-700);
			        			jtable.setAutoResizeMode(jtable.AUTO_RESIZE_OFF);
			        			jScrollPane2.setViewportView(jtable);
			        			jtable.addMouseListener(new mymouse());
			        			break;
			        		}
			        	}
			        }  else if(tb.getModel().getValueAt(tb.getSelectedRow(), 2).toString().startsWith("G")){
			        	String cid = tb.getModel().getValueAt(tb.getSelectedRow(), 2).toString();
			        	for(int a = 0; a<= gps.size()-1; a++){
			        		if(cid==gps.get(a).getId()){
			        			Object[][] rows = new Object[gps.get(a).getSts().size()][10];
			        			for(int i = 0;i<=gps.get(a).getSts().size()-1;i++){
			        				rows[i][0] = "  " +gps.get(a).getSts().get(i).getName();
			        				rows[i][1] = timeFormat.format(gps.get(a).getSts().get(i).getCreatdate());
			        				rows[i][2] = gps.get(a).getSts().get(i).getId();
			        				rows[i][3] = gps.get(a).getSts().get(i).getCmd();
			        				rows[i][4] = gps.get(a).getSts().get(i).getInfiles();
			        				rows[i][5] = gps.get(a).getSts().get(i).getFouts();
			        				rows[i][6] = gps.get(a).getSts().get(i).getFout();
			        				rows[i][7] = gps.get(a).getSts().get(i).getOpts();
			        				rows[i][8] = gps.get(a).getSts().get(i).getDirname();
			        				rows[i][9] = gps.get(a).getSts().get(i).getMemo();
			        			}
			        			Object[] columnNames = {res.getString("PROPERTY_NAME"),
			        					res.getString("PROPERTY_CREATE_TIME"),
			        					res.getString("PROPERTY_ID"),
			        					res.getString("PROPERTY_CMD"),
			        					res.getString("PROPERTY_TINPUT"),
			        					res.getString("PROPERTY_TRESULT"),
			        					res.getString("PROPERTY_TRESULT_URL"),
			        					res.getString("PROPERTY_TOPTION"),
			        					res.getString("PROPERTY_WORKDIR"),
			        					res.getString("PROPERTY_MEMO")};
			        			jtable = new JTable(rows, columnNames);
			        			jtable.setShowGrid(false);
			        			jtable.getTableHeader().setReorderingAllowed(false);
			        			MyTableModel model =new MyTableModel(rows, columnNames); 
			        			jtable.setModel(model); 
			        			jtable.setBackground(Color.WHITE);
			        			jtable.getColumn(res.getString("PROPERTY_NAME")).setPreferredWidth(100);
			        			jtable.getColumn(res.getString("PROPERTY_CREATE_TIME")).setPreferredWidth(150);
			        			jtable.getColumn(res.getString("PROPERTY_ID")).setPreferredWidth(100);
			        			jtable.getColumn(res.getString("PROPERTY_CMD")).setPreferredWidth(150);
			        			jtable.getColumn(res.getString("PROPERTY_TINPUT")).setPreferredWidth(200);
			        			jtable.getColumn(res.getString("PROPERTY_TRESULT")).setPreferredWidth(200);
			        			jtable.getColumn(res.getString("PROPERTY_TRESULT_URL")).setPreferredWidth(200);
			        			jtable.getColumn(res.getString("PROPERTY_TOPTION")).setPreferredWidth(100);
			        			jtable.getColumn(res.getString("PROPERTY_WORKDIR")).setPreferredWidth(150);
			        			jtable.getColumn(res.getString("PROPERTY_MEMO")).setPreferredWidth(100);
			        			jtable.setAutoResizeMode(jtable.AUTO_RESIZE_OFF);
			        			jtable.setBackground(Color.WHITE);
			        			jScrollPane2.setViewportView(jtable);
			        			jtable.addMouseListener(new mymouse());
			        			break;
			        		}
			        	}
			        } 
			    }
			 }else if (e.getButton() == MouseEvent.BUTTON3)
				{
					JTable tb = (JTable)e.getSource();
					String myid = tb.getModel().getValueAt(tb.getSelectedRow(), 2).toString();
					if(myid.startsWith("C")){											
						for(SSHComputer c : cps){
							if(myid.trim().equals(c.getId().trim())){
								cur = c;
								break;
							}							
						}
						popMenuC.show(jtable, e.getX(), e.getY());
						if(getRunStatusC(myid) == false) {
							computerStartC.setEnabled(true);
							computerStopC.setEnabled(false);
						}
						else {
							computerStartC.setEnabled(false);
							computerStopC.setEnabled(true);
						}
					}else if(myid.startsWith("G")){
						for(SSHGroup g : gps){
							if(myid.trim().equals(g.getId().trim())){
								cur = g;
								break;
							}							
						}
						popMenuG.show(jtable, e.getX(), e.getY());
						SSHGroup sgp = new SSHGroup();
						sgp = findSelectGroup();
						if(singlerun == 1) {
							groupStartG.setEnabled(true);
							groupStopG.setEnabled(false);
							allStartG.setEnabled(true);
							allStopG.setEnabled(false);
						}
						else if(singlerun == 2) {
							groupStartG.setEnabled(false);
							groupStopG.setEnabled(true);
							allStartG.setEnabled(false);
							allStopG.setEnabled(false);
						}
						else if(singlerun == 3) {
							groupStartG.setEnabled(false);
							groupStopG.setEnabled(false);
							allStartG.setEnabled(false);
							allStopG.setEnabled(true);

						}
					}else if(myid.startsWith("T")){
						for(SSHTask t : tks){
							if(myid.trim().equals(t.getId().trim())){
								cur = t;
								break;
							}							
						}
						popMenuT.show(jtable, e.getX(), e.getY());
						SSHTask temptask = new SSHTask();
						temptask = findSelectTask(myid);//变灰相应的任务信息
						if(temptask.getRunSucc() == false) {
							stopItemT.setEnabled(false);
							execItemT.setEnabled(true);
						}
						else {
							stopItemT.setEnabled(true);
							execItemT.setEnabled(false);
						}
					}              
				}
	    }
		
		
}
	
	private class thismouse extends  MouseAdapter
	{

		@Override
		public   void   mouseClicked(MouseEvent   e){
			try{
				JTree tree = (JTree)e.getSource();
				SimpleDateFormat timeFormat;
				timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				int rowLocation = tree.getRowForLocation(e.getX(), e.getY());
				TreePath treepath = tree.getPathForRow(rowLocation);
				DefaultMutableTreeNode treenode = (DefaultMutableTreeNode) treepath.getLastPathComponent();
				BaseClass b = new BaseClass();
				
				if(treenode.toString().equals("Computers"))
				{
					jTextArea1.setText("");
					jMenuItem4.setEnabled(true);
					jMenuItem5.setEnabled(false);
					jMenuItem6.setEnabled(false);
					jMenuItem8.setEnabled(false);
					jMenuItem9.setEnabled(false);
					jMenuItem10.setEnabled(false);
					jMenuItem11.setEnabled(false);
					jMenuItem12.setEnabled(false);
					jMenuItem13.setEnabled(false);
					jMenuItem14.setEnabled(false);
					jMenuItem15.setEnabled(false);
					jMenuItem16.setEnabled(false);
					return;                    	
				}
				String s=null;
				if(!treenode.isRoot()){
				    b=(BaseClass)treenode.getUserObject();
				    cur=(BaseClass)treenode.getUserObject();
				}
				//-------------处理双击事件----------------------------//
				/*if(e.getClickCount()==2)
				{
					if(cur.getType()!=2)return;
					cur=(SSHTask)cur;
					SSHTask curT=(SSHTask)cur;
					for(int i=0;i<jtl.size();i++)
					{
						if(jtl.get(i).getName().equals(cur.getId()))
						{
							try
							{
								FileReader reader = new FileReader(curT.getFout()+"/"+curT.getId()+".txt");    
								BufferedReader br = new BufferedReader(reader);    
								String s1 = null;    
								while((s1 = br.readLine()) != null) 
								{    
									s1+="\r\n";
									jtl.get(i).append(s1);    
								}    
								br.close();    
								reader.close();  
							}catch(Exception ex){ex.printStackTrace();}
							return;
						}
					}
					for(int i=0;i<tks.size();i++)
					{
						if(tks.get(i).getId().equals(cur.getId())) 
						{
							if(tks.get(i).getStatus()==1)
							{
								return;

							}
						}
					}

					try
					{
						FileReader reader = new FileReader(curT.getFout()+"/"+curT.getId()+".txt");         
						reader.close();  
					}catch(Exception ex){return;}

					JScrollPane t2=null;
					t1=new JTextArea(cur.getId()+"\n");
					t1.setName(cur.getId());
					jtl.add(t1);
					t2=new JScrollPane();
					t2.setName(cur.getId());
					jsl.add(t2);
					t2.add(t1);
					t1.setColumns(20);
					t1.setRows(5);
					t1.setEditable(false);
					t2.setViewportView(t1);
					jTabbedPane1.addTab(cur.getName(), t2);
					t1.addMouseListener(new MouseAdapter()
					{ 
						public void mouseReleased(MouseEvent e)
						{
							//是否右键单击
							if (e.getClickCount() == 1 && SwingUtilities.isRightMouseButton(e))
							{
								JTextArea temp=(JTextArea)e.getComponent();
								if(temp.getSelectedText()==null)
								{
									copyTA.setEnabled(false);
								}
								else
								{
									copyTA.setEnabled(true);
								}
								if(old!=null)
								{
									copyTA.removeActionListener(old);
									shutTA.removeActionListener(old);
									clearTA.removeActionListener(old);
								}
								old=new TARight(temp);
								copyTA.addActionListener(old);
								shutTA.addActionListener(old);
								clearTA.addActionListener(old);
								popMenuTA.show(temp,e.getX(),e.getY());
							}
						}
					}
					);
					//                	SSHTask curT=(SSHTask)cur;
					try
					{
						FileReader reader = new FileReader(curT.getFout()+"/"+curT.getId()+".txt");    
						BufferedReader br = new BufferedReader(reader);    
						String s1 = null;    
						while((s1 = br.readLine()) != null) 
						{    
							s1+="\r\n";
							t1.append(s1);    
						}    
						br.close();    
						reader.close();  
					}catch(Exception ex){ex.printStackTrace();}

				}*/
				//-----------------------------------------------------//
				if(cur.getType() == 0) { //获得选中的类型，给工具栏中相应的选项变色
					jMenuItem5.setEnabled(true);
					jMenuItem4.setEnabled(false);
					jMenuItem6.setEnabled(false);
					jMenuItem8.setEnabled(false);
					jMenuItem9.setEnabled(false);
					jMenuItem10.setEnabled(false);
					jMenuItem11.setEnabled(false);
					jMenuItem12.setEnabled(false);
					jMenuItem13.setEnabled(false);
					jMenuItem14.setEnabled(false);
					jMenuItem15.setEnabled(false);
					jMenuItem16.setEnabled(false);
				}
				else if(cur.getType() == 1) {
					jMenuItem6.setEnabled(true);
					jMenuItem4.setEnabled(false);
					jMenuItem5.setEnabled(false);
					jMenuItem8.setEnabled(true);
					jMenuItem9.setEnabled(false);
					jMenuItem10.setEnabled(false);
					/***?*/             SSHGroup sgp = findSelectGroup();
					if(singlerun == 1){
						jMenuItem11.setEnabled(false);
						jMenuItem12.setEnabled(true);
						jMenuItem13.setEnabled(true);
						jMenuItem16.setEnabled(false);
					}
					else if(singlerun == 2) {
						jMenuItem11.setEnabled(true);
						jMenuItem12.setEnabled(false);
						jMenuItem13.setEnabled(false);
						jMenuItem16.setEnabled(false);
					}
					else if(singlerun == 3) {
						jMenuItem11.setEnabled(false);
						jMenuItem12.setEnabled(false);
						jMenuItem13.setEnabled(false);
						jMenuItem16.setEnabled(true); 
					}                     
					jMenuItem14.setEnabled(false);
					jMenuItem15.setEnabled(false);
				}
				else if(cur.getType() == 2){
					jMenuItem4.setEnabled(false);
					jMenuItem5.setEnabled(false);
					jMenuItem6.setEnabled(false);
					jMenuItem8.setEnabled(false);
					jMenuItem9.setEnabled(true);
					jMenuItem10.setEnabled(true);
					jMenuItem11.setEnabled(false);
					jMenuItem12.setEnabled(false);
					jMenuItem13.setEnabled(false);
					SSHTask temptask = new SSHTask();
					temptask = findSelectTask(cur.getId());//变灰相应的任务信息
					if(!temptask.getFouts().isEmpty()) {
						boolean ff = true;
						String temp = "";		
						if(temptask.getFouts().trim().endsWith(";"))
							temp = temptask.getFouts().trim().substring(0, temptask.getFouts().trim().length()-1);
						String[] outnames = temptask.getFouts().trim().split(";");
						for(String str:outnames){
							if(!str.trim().isEmpty()){
								String filename = temptask.getFout().trim()+"/"+str.trim();
								File f = new File(filename);
								if(f.exists()&&temptask.getRunSucc()==false) {
									ff = true;
								}else ff = false;					
							}else ff = false;
						}
						//System.out.println("((((((((("+ff);
						dispResT.setEnabled(ff);
					}
					else {
						dispResT.setEnabled(false);
					}
					String at = temptask.getFouts().trim();
					if(at.endsWith(";")) at = at.substring(0, at.length()-1);
					if(temptask.getRunSucc() == true||at.isEmpty()){
						downloadItemT.setEnabled(false);
					}
					else {
						downloadItemT.setEnabled(true);
					}
					String inss = temptask.getInfiles().trim();
					if(at.endsWith(";")) inss = inss.substring(0, at.length()-1);
					if(inss.isEmpty()||temptask.getRunSucc() == true)uploadItemT.setEnabled(false);
					else uploadItemT.setEnabled(true);
					if(temptask.getRunSucc() == false) {
						jMenuItem14.setEnabled(true);
						jMenuItem15.setEnabled(false);
					} 
					else {
						jMenuItem14.setEnabled(false);
						jMenuItem15.setEnabled(true);
					}
					jMenuItem16.setEnabled(false);
				}
				else {
					jMenuItem4.setEnabled(true);
					jMenuItem5.setEnabled(false);
					jMenuItem6.setEnabled(false);
					jMenuItem8.setEnabled(false);
					jMenuItem9.setEnabled(false);
					jMenuItem10.setEnabled(false);
					jMenuItem11.setEnabled(false);
					jMenuItem12.setEnabled(false);
					jMenuItem13.setEnabled(false);
					jMenuItem14.setEnabled(false);
					jMenuItem15.setEnabled(false);
					jMenuItem16.setEnabled(false);
				}
				switch(b.getType())
				{
				case 0:
				{ 
					SSHComputer c=(SSHComputer)treenode.getUserObject();
					s=res.getString("PROPERTY_CNAME")+":"+c.getName()
					+"\n"+res.getString("PROPERTY_CIP")+":"+c.getHost()
					+"\n"+res.getString("PROPERTY_CUSER")+":"+c.getUsername()
					+"\n"+res.getString("PROPERTY_CLOGIN_TIME")+":"+b.getCreatdate()
					+"\n"+res.getString("PROPERTY_MEMO")+":"+c.getMemo();
					Font x = new Font("Serif",0,15);
					jTextArea1.setFont(x);
					jTextArea1.setText(s);
					
					Object[][] rows = new Object[c.getGps().size()][5];
        			for(int i = 0;i<=c.getGps().size()-1;i++){
        				rows[i][0] = "  "+c.getGps().get(i).getName();
        				rows[i][1] = timeFormat.format(c.getGps().get(i).getCreatdate());
        				rows[i][2] = c.getGps().get(i).getId();
        				rows[i][3] = c.getGps().get(i).getDirname();
        				rows[i][4] = c.getGps().get(i).getMemo();
        			}
        			Object[] columnNames = {res.getString("PROPERTY_NAME"),
        					res.getString("PROPERTY_CREATE_TIME"),
        					res.getString("PROPERTY_ID"),
        					res.getString("PROPERTY_WORKDIR"),
        					res.getString("PROPERTY_MEMO")};
        			jtable = new JTable(rows, columnNames);
        			jtable.setShowGrid(false);
        			jtable.getTableHeader().setReorderingAllowed(false);
        			MyTableModel model =new MyTableModel(rows, columnNames); 
        			jtable.setModel(model); 
        			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        			jtable.getColumn(res.getString("PROPERTY_NAME")).setPreferredWidth(150);
        			jtable.getColumn(res.getString("PROPERTY_CREATE_TIME")).setPreferredWidth(200);
        			jtable.getColumn(res.getString("PROPERTY_ID")).setPreferredWidth(150);
        			jtable.getColumn(res.getString("PROPERTY_WORKDIR")).setPreferredWidth(200);
        			jtable.getColumn(res.getString("PROPERTY_MEMO")).setPreferredWidth((int) (screenSize.width*0.75)-700);
        			jtable.setAutoResizeMode(jtable.AUTO_RESIZE_OFF);
        			jtable.setBackground(Color.WHITE);
        			jScrollPane2.setViewportView(jtable);
        			jtable.addMouseListener(new mymouse());
        			break;
				}
				case 1:
				{
					SSHGroup g=(SSHGroup)treenode.getUserObject();
					s=res.getString("PROPERTY_GNAME")+":"+g.getName()
					+"\n"+res.getString("PROPERTY_WORKDIR")+":"+g.getDirname()
					+"\n"+res.getString("PROPERTY_CREATE_TIME")+":"+b.getCreatdate()
					+"\n"+res.getString("PROPERTY_MEMO")+":"+g.getMemo();
					Font x = new Font("Serif",0,15);
					jTextArea1.setFont(x);
					jTextArea1.setText(s);
					
					Object[][] rows = new Object[g.getSts().size()][10];
        			for(int i = 0;i<=g.getSts().size()-1;i++){
        				rows[i][0] = "  "+g.getSts().get(i).getName();
        				rows[i][1] = timeFormat.format(g.getSts().get(i).getCreatdate());
        				rows[i][2] = g.getSts().get(i).getId();
        				rows[i][3] = g.getSts().get(i).getCmd();
        				rows[i][4] = g.getSts().get(i).getInfiles();
        				rows[i][5] = g.getSts().get(i).getFouts();
        				rows[i][6] = g.getSts().get(i).getFout();
        				rows[i][7] = g.getSts().get(i).getOpts();
        				rows[i][8] = g.getSts().get(i).getDirname();
        				rows[i][9] = g.getSts().get(i).getMemo();
        			}
        			Object[] columnNames = {res.getString("PROPERTY_NAME"),
        					res.getString("PROPERTY_CREATE_TIME"),
        					res.getString("PROPERTY_ID"),
        					res.getString("PROPERTY_CMD"),
        					res.getString("PROPERTY_TINPUT"),
        					res.getString("PROPERTY_TRESULT"),
        					res.getString("PROPERTY_TRESULT_URL"),
        					res.getString("PROPERTY_TOPTION"),
        					res.getString("PROPERTY_WORKDIR"),
        					res.getString("PROPERTY_MEMO")};
        			jtable = new JTable(rows, columnNames);
        			jtable.setShowGrid(false);
        			jtable.getTableHeader().setReorderingAllowed(false);
        			MyTableModel model =new MyTableModel(rows, columnNames); 
        			jtable.setModel(model); 
        			jtable.getColumn(res.getString("PROPERTY_NAME")).setPreferredWidth(100);
        			jtable.getColumn(res.getString("PROPERTY_CREATE_TIME")).setPreferredWidth(150);
        			jtable.getColumn(res.getString("PROPERTY_ID")).setPreferredWidth(100);
        			jtable.getColumn(res.getString("PROPERTY_CMD")).setPreferredWidth(150);
        			jtable.getColumn(res.getString("PROPERTY_TINPUT")).setPreferredWidth(200);
        			jtable.getColumn(res.getString("PROPERTY_TRESULT")).setPreferredWidth(200);
        			jtable.getColumn(res.getString("PROPERTY_TRESULT_URL")).setPreferredWidth(200);
        			jtable.getColumn(res.getString("PROPERTY_TOPTION")).setPreferredWidth(100);
        			jtable.getColumn(res.getString("PROPERTY_WORKDIR")).setPreferredWidth(150);
        			jtable.getColumn(res.getString("PROPERTY_MEMO")).setPreferredWidth(100);
        			jtable.setAutoResizeMode(jtable.AUTO_RESIZE_OFF);
        			jtable.setBackground(Color.WHITE);
        			jScrollPane2.setViewportView(jtable);
        			jtable.addMouseListener(new mymouse());
					break;
				}
				case 2:
				{
					SSHTask t=(SSHTask)treenode.getUserObject();
					for(int i = 0; i < tks.size() ;++ i) {
						if(t.getId().equals(tks.get(i).getId())) {
							t.setRunSucc(tks.get(i).getRunSucc());
							break;
						}
					}
					if(t.getStartTime() == null) {
						s=res.getString("PROPERTY_TNAME")+":"+t.getName()
						+"\n"+res.getString("PROPERTY_WORKDIR")+":"+t.getDirname()
						+"\n"+res.getString("PROPERTY_CMD")+":"+t.getCmd()
						+"\n"+res.getString("PROPERTY_TRESULT")+":"+t.getFouts()
						+"\n"+res.getString("PROPERTY_TRESULT_URL")+":"+t.getFout()					
						+"\n"+res.getString("PROPERTY_TINPUT")+":"+t.getInfiles()
						+"\n"+res.getString("PROPERTY_TINPUT_URL")+":"+t.getFin()
						+"\n"+res.getString("PROPERTY_TOPTION")+":"+t.getOpts()
						+"\n"+res.getString("PROPERTY_CREATE_TIME")+":"+b.getCreatdate()
						+"\n"+res.getString("PROPERTY_MEMO")+":"+t.getMemo();
					}
					else {
						TaskUI tk1 = new TaskUI();
						Date taskstartTime = tk1.getTaskStartTime(t);//查找XML文件获得上次任务开始时间
						s=res.getString("PROPERTY_TNAME")+":"+t.getName()
						+"\n"+res.getString("PROPERTY_WORKDIR")+":"+t.getDirname()
						+"\n"+res.getString("PROPERTY_CMD")+":"+t.getCmd()
						+"\n"+res.getString("PROPERTY_TRESULT")+":"+t.getFouts()
						+"\n"+res.getString("PROPERTY_TRESULT_URL")+":"+t.getFout()					
						+"\n"+res.getString("PROPERTY_TINPUT")+":"+t.getInfiles()
						+"\n"+res.getString("PROPERTY_TINPUT_URL")+":"+t.getFin()
						+"\n"+res.getString("PROPERTY_TOPTION")+":"+t.getOpts()
						+"\n"+res.getString("PROPERTY_CREATE_TIME")+":"+b.getCreatdate()
						+"\n"+res.getString("PROPERTY_TLAST_TIME")+":"+ taskstartTime; 
						if(t.getRunSucc() == true) {                          		
							s += "\n"+res.getString("PROPERTY_TEXE_TIME")+":" + String.valueOf((System.currentTimeMillis() - t.getRunTime())/1000.0)+"s";	    
						}
						else {
							s += "\n"+res.getString("PROPERTY_TEND")+"!";
						}
						s += "\n"+res.getString("PROPERTY_MEMO")+":"+t.getMemo();
					}
					Font x = new Font("Serif",0,15);
					jTextArea1.setFont(x);
					jTextArea1.setText(s);
					break;
				}
				default:{
					Object[][] rows = new Object[cps.size()][4];
        			for(int i = 0;i<=cps.size()-1;i++){
        				rows[i][0] = "  "+cps.get(i).getName();
        				rows[i][1] = timeFormat.format(cps.get(i).getCreatdate());
        				rows[i][2] = cps.get(i).getId();
        				rows[i][3] = cps.get(i).getMemo();
        			}
        			Object[] columnNames = {res.getString("PROPERTY_NAME"),res.getString("PROPERTY_CREATE_TIME"),res.getString("PROPERTY_ID"),res.getString("PROPERTY_MEMO")};
        			jtable = new JTable(rows, columnNames);
        			jtable.setShowGrid(false);
        			jtable.getTableHeader().setReorderingAllowed(false);
        			MyTableModel model =new MyTableModel(rows, columnNames); 
        			jtable.setModel(model); 
        			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        			jtable.getColumn(res.getString("PROPERTY_NAME")).setPreferredWidth(150);
        			jtable.getColumn(res.getString("PROPERTY_CREATE_TIME")).setPreferredWidth(200);
        			jtable.getColumn(res.getString("PROPERTY_ID")).setPreferredWidth(150);
        			jtable.getColumn(res.getString("PROPERTY_MEMO")).setPreferredWidth((int) (screenSize.width*0.75-500));
        			jtable.setAutoResizeMode(jtable.AUTO_RESIZE_OFF);
        			jtable.setBackground(Color.WHITE);
        			jScrollPane2.setViewportView(jtable);
        			jtable.addMouseListener(new mymouse());
        			break;
				}
					
				}
			}catch(NullPointerException ne){}
		}
		@Override
		public void mouseReleased(MouseEvent e)
		{
			try
			{
				//是否右键单击
				if (e.getClickCount() == 1 && SwingUtilities.isRightMouseButton(e))
				{
					JTree tree = (JTree)e.getSource();
					int rowLocation = tree.getRowForLocation(e.getX(), e.getY());
					TreePath treepath = tree.getPathForRow(rowLocation);
					DefaultMutableTreeNode treenode = (DefaultMutableTreeNode) treepath.getLastPathComponent();
					if(treenode.toString().equals(res.getString("COMS")))
					{
						TreePath path = jTree1.getPathForLocation(e.getX(), e.getY());
						if (path == null)
							return;
						jTree1.setSelectionPath(path);
						popMenuCA.show(jTree1, e.getX(), e.getY());
						cur=null;                              
						return;
					}
					cur=(BaseClass)treenode.getUserObject();
					TreePath path = jTree1.getPathForLocation(e.getX(), e.getY());
					if (path == null)
						return;
					jTree1.setSelectionPath(path);
					switch(cur.getType())
					{
					case 0:
					{
						popMenuC.show(jTree1, e.getX(), e.getY());
						if(getRunStatusC(cur.getId()) == false) {
							computerStartC.setEnabled(true);
							computerStopC.setEnabled(false);
						}
						else {
							computerStartC.setEnabled(false);
							computerStopC.setEnabled(true);
						}
						break;
					}
					case 1:
					{
						popMenuG.show(jTree1, e.getX(), e.getY());
						SSHGroup sgp = new SSHGroup();
						sgp = findSelectGroup();
						if(singlerun == 1) {
							groupStartG.setEnabled(true);
							groupStopG.setEnabled(false);
							allStartG.setEnabled(true);
							allStopG.setEnabled(false);
						}
						else if(singlerun == 2) {
							groupStartG.setEnabled(false);
							groupStopG.setEnabled(true);
							allStartG.setEnabled(false);
							allStopG.setEnabled(false);
						}
						else if(singlerun == 3) {
							groupStartG.setEnabled(false);
							groupStopG.setEnabled(false);
							allStartG.setEnabled(false);
							allStopG.setEnabled(true);

						}
						break;
					}
					case 2:
					{
						popMenuT.show(jTree1, e.getX(), e.getY());
						SSHTask temptask = new SSHTask();
						temptask = findSelectTask(cur.getId());//变灰相应的任务信息
						if(temptask.getRunSucc() == false) {
							stopItemT.setEnabled(false);
							execItemT.setEnabled(true);
						}
						else {
							stopItemT.setEnabled(true);
							execItemT.setEnabled(false);
						}
						break;
					}
					default:
						break;                         
					}                        
				}
			}
			catch (Exception ex)  
			{}
		}
	}
	//------------------------------------------------------------//
	class rightclick implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				action(e);
			} catch (DocumentException ex)
			{}
		}
	}


	//----------------------------------------------------------//
	class TARight implements ActionListener
	{
		JTextArea t;
		TARight(JTextArea t)
		{
			this.t=t;
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("复制")||e.getActionCommand().equals("Copy"))
			{

				String temp=t.getSelectedText(); //拖动鼠标选取文本。
				StringSelection text=new StringSelection(temp); 
				clipboard=getToolkit().getSystemClipboard();
				clipboard.setContents(text,null); 

			}
			if(e.getActionCommand().equals("关闭窗口")||e.getActionCommand().equals("Colse"))
			{
				for(int i=0;i<tks.size();i++)
				{
					if(tks.get(i).getId().equals(t.getName())) 
					{
						if(tks.get(i).getStatus()==1)
						{
							JOptionPane.showMessageDialog(null, res.getString("TIP_NOT_DELETE"),null,JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				}
				for(int i=0;i<jsl.size();i++)
				{
					if(jsl.get(i).getName().equals(t.getName()))
					{
//						jTabbedPane1.remove(jsl.get(i));
						jsl.remove(i);

						break;
					}
				}
				for(int i=0;i<jtl.size();i++)
				{
					if(jtl.get(i).getName().equals(t.getName()));
					{
						jtl.remove(i);

						break;
					}
				}
			}
			if(e.getActionCommand().equals("清空")||e.getActionCommand().equals("Clear"))
			{
				//System.out.println("清空");
				t.setText("");
			}
		}
	}

	//------------------------------------------------------------//
	/**
	* 查看结果的响应事件处理
	 */
	class dispclick implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				actionDispClick(e);
			} catch (DocumentException ex)
			{}
		}
	}
	/**
	 * 查看结果的响应事件处理
	 * @param e
	 */
	private void actionDispClick(ActionEvent e) throws DocumentException { 
		if(dispResT.isEnabled()) {		
			String selI = e.getActionCommand();
			
//			JOptionPane.showMessageDialog(null, "结果"+((SSHTask)cur).getFout()+((SSHTask)cur).getFouts());
			
			// zhou
			
			try {
				String dirstr = ((SSHTask)cur).getFout();
				String filesstr = ((SSHTask)cur).getFouts();
				String[] strSplit = filesstr.split("(\\;*,\\;*|\\;+)");//分号分隔
				for(int i=0;i<strSplit.length;i++){
					strSplit[i]=dirstr+"\\"+strSplit[i];
				}
//				System.out.println("*********************----------------");
				
				for(int i=0;i<strSplit.length;i++){
					ResultUI resultui=new ResultUI();
					resultui.out(strSplit[i]);
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			/*SSHTask stk = findSelectTask(cur.getId());
			try {
				String filename=stk.getFout()+"/"+stk.getId()+".txt";
				GenerateGraphy.GetObj(stk.getId(),filename,t);
			}
			catch(Exception ev) {
				ev.printStackTrace();
			}*/
		}

	}
	/**
	 * 初始画图函数
	 */
	//-------------------------------------------------------------//
	private void initComponents() {		

		jtl=new ArrayList<JTextArea>();
		jsl=new ArrayList<JScrollPane>();
		popMenuTA=new JPopupMenu();
		copyTA=new JMenuItem(res.getString("COPY"));
		shutTA=new JMenuItem(res.getString("CLOSE"));
		clearTA=new JMenuItem(res.getString("CLEAR"));
		popMenuTA.add(copyTA);
		popMenuTA.add(shutTA);
		popMenuTA.add(clearTA);

		jSplitPane1 = new javax.swing.JSplitPane();
		jSplitPane1.setBackground(Color.WHITE);
		jSplitPane1.setResizeWeight(0.25);
		
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setBackground(Color.WHITE);
		jTree1 = new javax.swing.JTree();
//		jSplitPane2 = new javax.swing.JSplitPane();
		jScrollPane2 = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//jScrollPane2.setLayout(null);
		jTextArea1 = new javax.swing.JTextArea();
//		jTabbedPane1 = new javax.swing.JTabbedPane();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTextArea2 = new javax.swing.JTextArea();
		jScrollPane4 = new javax.swing.JScrollPane();
		jTextArea3 = new javax.swing.JTextArea();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenuItem5 = new javax.swing.JMenuItem();
		jMenuItem6 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		jSeparator1 = new javax.swing.JSeparator();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem8 = new javax.swing.JMenuItem();
		jMenuItem9 = new javax.swing.JMenuItem();
		jMenuItem10 = new javax.swing.JMenuItem();
		jSeparator2 = new javax.swing.JSeparator();
		jMenuItem11 = new javax.swing.JMenuItem();
		jMenuItem12 = new javax.swing.JMenuItem();
		jMenuItem13 = new javax.swing.JMenuItem();
		jMenuItem14 = new javax.swing.JMenuItem();
		jSeparator3 = new javax.swing.JSeparator();
		jMenuItem15 = new javax.swing.JMenuItem();
		jMenuItem16 = new javax.swing.JMenuItem();
		jMenu3 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem7 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("LinuxClient");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/faver.png"));
		setIconImage(img);

		jSplitPane1.setName("jSplitPane1"); // NOI18N
		jScrollPane1.setName("jScrollPane1"); // NOI18N
		jTree1.setName("jTree1"); // NOI18N
		jScrollPane1.setViewportView(jTree1);
		jSplitPane1.setLeftComponent(jScrollPane1);
//		jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
//		jSplitPane2.setName("jSplitPane2"); // NOI18N
		jScrollPane2.setName("jScrollPane2"); // NOI18N
		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jTextArea1.setEnabled(false);
		jTextArea1.setName("jTextArea1"); // NOI18N
		
		
//		jSplitPane2.setLeftComponent(jScrollPane2);
//		jTabbedPane1.setName("jTabbedPane1"); // NOI18N
		jScrollPane3.setName("jScrollPane3"); // NOI18N
		jTextArea2.setColumns(20);
		jTextArea2.setRows(5);
		jTextArea2.setEnabled(false);
		jTextArea2.setName("jTextArea2"); // NOI18N
		jScrollPane3.setViewportView(jTextArea2);
		//jTabbedPane1.addTab("tab1", jScrollPane3);
		jScrollPane4.setName("jScrollPane4"); // NOI18N
		jTextArea3.setColumns(20);
		jTextArea3.setRows(5);
		jTextArea3.setName("jTextArea3"); // NOI18N
		jScrollPane4.setViewportView(jTextArea3);
		//jTabbedPane1.addTab("tab2", jScrollPane4);
//		jSplitPane2.setRightComponent(jTabbedPane1);
		jSplitPane1.setRightComponent(jScrollPane2);
		jMenuBar1.setName("jMenuBar1"); // NOI18N

		jMenu1.setText(res.getString("FILE"));

		jMenu1.setName("jMenu1"); // NOI18N

		jMenu4.setText(res.getString("CREATE"));
		jMenu4.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/file.png")));
		jMenu4.setName("jMenu4"); // NOI18N
		jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jMenu4MouseClicked(evt);
			}
		});

		jMenuItem4.setText(res.getString("COMPUTER"));
		jMenuItem4.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/c.png")));
		jMenuItem4.setName("jMenuItem4"); // NOI18N
		jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jMenuItem4MousePressed(evt);
			}
		});
		jMenu4.add(jMenuItem4);

		jMenuItem5.setText(res.getString("GROUP"));
		jMenuItem5.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/g.png")));
		jMenuItem5.setName("jMenuItem5"); // NOI18N
		//"新建工作组"的监听函数
		jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jMenuMousePressNewGroup(evt);
			}
		});
		jMenu4.add(jMenuItem5);

		jMenuItem6.setText(res.getString("TASK"));
		jMenuItem6.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/t.png")));
		jMenuItem6.setName("jMenuItem6"); // NOI18N
		//“新建任务的监听函数”
		jMenuItem6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jMenuMousePressNewTask(evt);
			}
		});
		jMenu4.add(jMenuItem6);

		jMenu1.add(jMenu4);


		jMenuItem3.setText(res.getString("QUIT"));
		jMenuItem3.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/q.png")));
		jMenuItem3.setName("jMenuItem3"); // NOI18N
		jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				System.exit(0);
			}
		});
		jMenu1.add(jMenuItem3);


		jMenuBar1.add(jMenu1);

		jMenu2.setText(res.getString("TASK"));
		jMenu2.setName("jMenu2"); // NOI18N

		jMenuItem8.setText(res.getString("CREATE"));
		jMenuItem8.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/add.png")));
		jMenuItem8.setName("jMenuItem8"); // NOI18N
		jMenuItem8.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jMenuMousePressNewTask(evt);
			}
		});
		jMenu2.add(jMenuItem8);

		jMenuItem9.setText(res.getString("MODIFY"));
		jMenuItem9.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/up.png")));
		jMenuItem9.setName("jMenuItem9"); // NOI18N
		jMenuItem9.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jMenuMousePressUpdateTask(evt);
			}
		});       
		jMenu2.add(jMenuItem9);

		jMenuItem10.setText(res.getString("DELETE"));
		jMenuItem10.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/del.png")));
		jMenuItem10.setName("jMenuItem10"); // NOI18N
		jMenuItem10.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jMenuMousePressRemoveTask(evt);
			}
		});  
		jMenu2.add(jMenuItem10);

		jSeparator2.setName("jSeparator2"); // NOI18N
		jMenu2.add(jSeparator2);

		jMenuItem12.setText(res.getString("SERIAL_START_GROUP"));
		jMenuItem12.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/gst.png")));
		jMenuItem12.setName("jMenuItem12"); // NOI18N
		jMenuItem12.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jMenuMousePressGroupStart(evt); 
				//jMenuMousePressRemoveTask(evt);
			}
		});  
		jMenu2.add(jMenuItem12);

		jMenuItem11.setText(res.getString("STOP_GROUP"));
		jMenuItem11.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/gsp.png")));
		jMenuItem11.setName("jMenuItem11"); // NOI18N

		jMenu2.add(jMenuItem11);
		jMenuItem13.setText(res.getString("START_ALL"));
		jMenuItem13.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/ast.png")));
		jMenuItem13.setName("jMenuItem13"); // NOI18N
		jMenuItem13.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jMenuMousePressAllStartG(evt); 
			}
		});
		jMenu2.add(jMenuItem13);

		jMenuItem16.setText(res.getString("STOP_ALL"));
		jMenuItem16.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/asp.png")));
		jMenuItem16.setName("jMenuItem16"); // NOI18N
		jMenuItem16.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jMenuMousePressAllStopG(evt); 
			}
		});
		jMenu2.add(jMenuItem16);
		jMenuItem14.setText(res.getString("START_RIGHT_NOW"));
		jMenuItem14.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/s.png")));
		jMenuItem14.setName("jMenuItem14"); // NOI18N
		jMenuItem14.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					execTaskCommand(e);
				} catch (DocumentException ex)
				{}
			}
		}
		);
		jMenu2.add(jMenuItem14);

		jSeparator3.setName("jSeparator3"); // NOI18N
		jMenu2.add(jSeparator3);

		jMenuItem15.setText(res.getString("STOP_ANYWAY"));
		jMenuItem15.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/sn.png")));
		jMenuItem15.setName("jMenuItem15"); // NOI18N
		//////////////////////////////////////////停止任务的监听函数
		jMenuItem15.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					stopTaskCommand(e);
				} catch (DocumentException ex)
				{}
			}
		}
		);
		jMenu2.add(jMenuItem15);



		jMenuBar1.add(jMenu2);

		languMenu = new JMenu();
		languMenu.setText(res.getString("LANGUAGE"));
		setcn = new JMenuItem();
		setcn.setText(res.getString("CN"));
		setcn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				setcnMouseClicked(evt);
			}
		});
		languMenu.add(setcn);
		seten = new JMenuItem();
		seten.setText(res.getString("EN"));
		seten.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				setenMouseClicked(evt);
			}
		});
		languMenu.add(seten);
		//jMenuBar1.add(languMenu);
		
		jMenu3.setText(res.getString("HELP"));
		jMenu3.setName("jMenu3"); // NOI18N

		jMenuItem1.setText(res.getString("INDEX"));
		jMenuItem1.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/i.png")));
		jMenuItem1.setName("jMenuItem1"); // NOI18N
		jMenu3.add(jMenuItem1);

		jMenuItem7.setText(res.getString("ABOUT"));
		jMenuItem7.setIcon(new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/ab.png")));
		jMenuItem7.setName("jMenuItem7"); // NOI18N
		jMenu3.add(jMenuItem7);

		jMenuBar1.add(jMenu3);
		setJMenuBar(jMenuBar1);

		//没有选中内容时新建选项全设为暗色
		if(cur == null) {
			jMenuItem4.setEnabled(true);
			jMenuItem5.setEnabled(false);
			jMenuItem6.setEnabled(false);
			jMenuItem8.setEnabled(false);
			jMenuItem9.setEnabled(false);
			jMenuItem10.setEnabled(false);
			jMenuItem11.setEnabled(false);
			jMenuItem12.setEnabled(false);
			jMenuItem13.setEnabled(false);
			jMenuItem14.setEnabled(false);
			jMenuItem15.setEnabled(false);
			jMenuItem16.setEnabled(false);
		}

		//右键窗口部分
		popMenuC = new JPopupMenu();
		addItemC = new JMenuItem(res.getString("ADD_GROUP"));
		addItemC.addActionListener(new rightclick());
		delItemC = new JMenuItem(res.getString("DELETE_COMPUTER"));
		delItemC.addActionListener(new rightclick());
		editItemC = new JMenuItem(res.getString("MODIFY_COMPUTER"));
		editItemC.addActionListener(new rightclick());
		computerStartC = new JMenuItem(res.getString("START_ALL"));
		computerStartC.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				computerStartAllGroupT(evt);
			}
		});
		computerStopC = new JMenuItem(res.getString("STOP_ALL"));
		computerStopC.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				computerStopAllGroupT(evt);
			}
		});
		popMenuC.add(addItemC);
		popMenuC.add(delItemC);
		popMenuC.add(editItemC);
		popMenuC.add(computerStartC);
		popMenuC.add(computerStopC);

		popMenuG = new JPopupMenu();
		addItemG = new JMenuItem(res.getString("ADD_TASK"));
		addItemG.addActionListener(new rightclick());
		addMItemG = new JMenuItem(res.getString("ADD_MANY_TASK"));
		addMItemG.addActionListener(new rightclick());
		delItemG = new JMenuItem(res.getString("DELETE_GROUP"));
		delItemG.addActionListener(new rightclick());
		editItemG = new JMenuItem(res.getString("MODIFY_GROUP"));
		editItemG.addActionListener(new rightclick());
		groupStartG = new JMenuItem(res.getString("SERIAL_START_GROUP"));
		groupStartG.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jMenuMousePressGroupStart(evt); 
			}
		});  
		groupStopG = new JMenuItem(res.getString("STOP_GROUP"));
		groupStopG.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jMenuMousePressGroupStop(evt); 
			}
		});  
		allStartG = new JMenuItem(res.getString("PARALLEL_START_GROUP"));
		allStartG.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jMenuMousePressAllStartG(evt); 
			}
		});
		allStopG = new JMenuItem(res.getString("STOP_ALL"));
		allStopG.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jMenuMousePressAllStopG(evt); 
			}
		});
		downloadG = new JMenuItem(res.getString("DOWNLOAD_GROUP"));
		downloadG.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					downloadGCommand(e);
				} catch (DocumentException ex)
				{
					ex.printStackTrace();
				}
			}
		}
		);
		popMenuG.add(addItemG);
		popMenuG.add(addMItemG);
		popMenuG.add(delItemG);
		popMenuG.add(editItemG); 
		popMenuG.add(groupStartG);
		popMenuG.add(groupStopG);
		popMenuG.add(allStartG);
		popMenuG.add(allStopG);
		popMenuG.add(downloadG);
		popMenuT = new JPopupMenu();       
		delItemT = new JMenuItem(res.getString("DELETE_TASK"));
		delItemT.addActionListener(new rightclick());
		editItemT = new JMenuItem(res.getString("MODIFY_TASK"));
		editItemT.addActionListener(new rightclick());
		popMenuT.add(delItemT);
		popMenuT.add(editItemT);

		//////////////////////////////////////////////////////// 运行任务命令
		execItemT = new JMenuItem(res.getString("EXECLUDE_TASK"));
		execItemT.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				try
				{
					execTaskCommand(e);
				} catch (DocumentException ex)
				{}
			}
		}
		);
		popMenuT.add(execItemT);

		////停止任务命令
		stopItemT = new JMenuItem(res.getString("STOP_TASK"));
		stopItemT.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					stopTaskCommand(e);
				} catch (DocumentException ex)
				{
					ex.printStackTrace();
				}
			}
		}
		);
		popMenuT.add(stopItemT);

		////下载结果文件
		downloadItemT = new JMenuItem(res.getString("DOWNLOAD_TASK"));
		downloadItemT.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					downloadCommand(e);
				} catch (DocumentException ex)
				{
					ex.printStackTrace();
				}
			}
		}
		);
		popMenuT.add(downloadItemT);
		////上传输入文件
		uploadItemT = new JMenuItem(res.getString("UPLOAD_TASK"));
		uploadItemT.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					uploadCommand(e);
				} catch (DocumentException ex)
				{
					ex.printStackTrace();
				}
			}
		}
		);
		popMenuT.add(uploadItemT);

		//查看任务运行的结果图
		dispResT = new JMenuItem(res.getString("SHOW_RESULT"));
//		dispResT.setEnabled(false);
		// zhou
		dispResT.setEnabled(true);
		dispResT.addActionListener(new dispclick());
		popMenuT.add(dispResT);


		popMenuCA = new JPopupMenu();       
		delItemCA = new JMenuItem(res.getString("DELETE_ALL"));
		delItemCA.addActionListener(new rightclick());
		addItemCA = new JMenuItem(res.getString("ADD_COMPUTER"));
		addItemCA.addActionListener(new rightclick());
		popMenuCA.add(delItemCA);
		popMenuCA.add(addItemCA);

		//窗口布局部分
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	//处理语言选择
	private void setcnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
		res = ResourceBundle.getBundle( "cn.edu.jlu.ccst.sshclient.ui.RES", new Locale ("zh", "CN"));	
		LinuxClient.GetObj().validate();
		LinuxClient.GetObj().repaint();
		LinuxClient.GetObj().setVisible(false);
		LinuxClient.GetObj().setVisible(true);
		
	}
	
	private void setenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
		res = ResourceBundle.getBundle( "cn.edu.jlu.ccst.sshclient.ui.RES", new Locale ("en", "US"));
		LinuxClient.GetObj().validate();
		LinuxClient.GetObj().repaint();
		LinuxClient.GetObj().setVisible(false);
		LinuxClient.GetObj().setVisible(true);
		
	}
	
	private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
		ComputerUI newComputerUi = new ComputerUI();
		newComputerUi.setVisible(true);
		this.setVisible(false);
	}
	/**
	 * 工具栏中新建计算机的处理函数
	 * @param evt
	 */
	private void jMenuItem4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MousePressed
		// TODO add your handling code here:
		if(jMenuItem4.isEnabled() == true) {
			SSHComputer ncp = new SSHComputer();
			ncp.creat();
			updata();
		}
	}//GEN-LAST:event_jMenuItem4MousePressed

	/**
	 * 工具栏中新建组的处理函数
	 */
	private void jMenuMousePressNewGroup(java.awt.event.MouseEvent evt){//GEN-FIRST:event_jMenuItem5MousePressed
		if(jMenuItem5.isEnabled() == true) {
			SSHGroup grp = new SSHGroup();
			grp.creat();
			updata();
		}

	}

	/**
	 * 工具栏中新建任务的处理函数    
	 */
	private void jMenuMousePressNewTask(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jMenuItem6MousePressed
		if(jMenuItem6.isEnabled() == true || jMenuItem8.isEnabled()) {
			SSHTask tas=new SSHTask();
			tas.creat();
			updata();
		}
	}
	/**
	 * 工具栏中的更新任务的处理函数
	 * @return
	 */
	private void jMenuMousePressUpdateTask(java.awt.event.MouseEvent evt) {
		if(jMenuItem9.isEnabled() == true) {
			SSHTask tas=new SSHTask();
			tas.update();
			updata();
		}
	}
	/**
	 * 工具栏中的删除任务的处理函数
	 * @return
	 */
	private void jMenuMousePressRemoveTask(java.awt.event.MouseEvent evt) {
		if(jMenuItem10.isEnabled() == true) {
			SSHTask tas=new SSHTask();
			if(getTaskRunSucc(cur.getId()) == false) {
				tas = (SSHTask)cur;
				tas.remove();
			}
			else {
				JOptionPane.showMessageDialog(null, res.getString("TIP_NOT_DELETE"),null,JOptionPane.ERROR_MESSAGE);
			     return;
			}
			for(int i=0;i<jsl.size();i++)
			{
				if(jsl.get(i).getName().equals(cur.getId()))
				{
//					jTabbedPane1.remove(jsl.get(i));
					jsl.remove(i);
					break;
				}
			}
			for(int i=0;i<jtl.size();i++)
			{
				if(jtl.get(i).getName().equals(cur.getId()));
				{
					jtl.remove(i);
					break;
				}
			}
			updata();  		  
		}
	}
	static public BaseClass getCur()
	{
		return cur;
	}
	public void setSinglerun(int t) {
		singlerun = t;
	}
//	public JTabbedPane getJTabbedPane()
//	{
//		return jTabbedPane1;
//	}
	/* public JCloseableTabbedPane getJCloseableTabPane() {
    	return jCloseableTabPane1;
    }*/

	//---------------------------------------------------------------//


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem10;
	private javax.swing.JMenuItem jMenuItem11;
	private javax.swing.JMenuItem jMenuItem12;
	private javax.swing.JMenuItem jMenuItem13;
	private javax.swing.JMenuItem jMenuItem14;
	private javax.swing.JMenuItem jMenuItem15;
	private javax.swing.JMenuItem jMenuItem16;
	private javax.swing.JMenuItem jMenuItem17;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JMenuItem jMenuItem7;
	private javax.swing.JMenuItem jMenuItem8;
	private javax.swing.JMenuItem jMenuItem9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSplitPane jSplitPane1;
//	private javax.swing.JSplitPane jSplitPane2;
//	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextArea jTextArea2;
	private javax.swing.JTextArea jTextArea3;
	public javax.swing.JTree jTree1;
	// End of variables declaration//GEN-END:variables
	private JPopupMenu popMenuC;
	private JMenuItem addItemC;
	private JMenuItem delItemC;
	private JMenuItem editItemC;

	private JPopupMenu popMenuG;
	private JMenuItem addItemG;
	private JMenuItem addMItemG;
	private JMenuItem delItemG;
	private JMenuItem editItemG;
	private JMenuItem groupStartG;
	private JMenuItem groupStopG;
	private JMenuItem allStartG;
	private JMenuItem allStopG;
	private JMenuItem downloadG;
	private JMenuItem computerStartC;
	private JMenuItem computerStopC;

	private JPopupMenu popMenuT;
	private JMenuItem delItemT;
	private JMenuItem editItemT;
	private JMenuItem execItemT;
	private JMenuItem stopItemT;
	private JMenuItem downloadItemT;
	private JMenuItem uploadItemT;
	private JMenuItem dispResT;
	
	private JMenu languMenu;
	private JMenuItem setcn;
	private JMenuItem seten;


	private JPopupMenu popMenuTA;
	private JMenuItem copyTA;
	private JMenuItem shutTA;
	private JMenuItem clearTA;
	JTextArea t1;
	Clipboard clipboard=null; 
	private TARight old=null;

	private int singlerun = 1;
	private JPopupMenu popMenuCA;
	private JMenuItem delItemCA;
	private JMenuItem addItemCA;
	private static int flag = 0;
	private static LinuxClient Obj;
	protected static BaseClass cur;

	public static List<SSHComputer> cps;
	public static List<SSHGroup> gps;
	public static List<SSHTask> tks;
	private List<javax.swing.JTextArea> jtl;
	private List<javax.swing.JScrollPane> jsl;

	private boolean first=true;
	
	private static ResourceBundle res;
	
	private JTable jtable;


	/**
	 * @param args the command line arguments
	 */
	 public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				GetObj().setVisible(true);
			}
		});
	 }
}

