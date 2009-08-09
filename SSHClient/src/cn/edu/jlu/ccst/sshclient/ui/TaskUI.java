package cn.edu.jlu.ccst.sshclient.ui;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import cn.edu.jlu.ccst.sshclient.model.*;

//import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader; //import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.awt.*; //import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class TaskUI extends javax.swing.JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel Ltest, tLabel1, tLabel2, tLabel3, dirLabel;
	// private JLabel memoLabel;
	private JTextField tTextField1, tTextField3, dirTextField;
	private JTextArea tTextArea2, tfous;
	private JScrollPane tfinAreaPane, tfousAreaPane, memoAreaPane;
	private JButton resetButton, submitButton;
	private JLabel lfin, lfout, loutnames, lopts;
	private JTextField tfout, topts;
	private boolean flag = false;
	private String gdir;
	private String older;
	private SSHTask oldertask;
	private JPanel tfin;
	private JCheckBox cb;
	private static ResourceBundle res;
	// private JButton choosein,chooseout;

	public TaskUI() {
		res = ResourceBundle.getBundle( "cn.edu.jlu.ccst.sshclient.ui.lang.RES_TUI");
		this.setTitle(res.getString("TITLE_NEW"));
		initComponent();
		
		submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {

				try {
					SubmitButtonMousePressed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// -------------------------------------------------------------------//

	public List<JTextField> maketextfields(String fin, String infiles){
		List<JTextField> results = new ArrayList<JTextField>();
		fin = fin.trim();
		if(fin.length()==0)return results;
		fin = fin.substring(0, fin.length()-1);
		String[] ins = fin.split(";");
		infiles = infiles.trim();
		infiles = infiles.substring(0, infiles.length()-1);
		String[] infs = infiles.split(";");
		for(int i = 0; i<=ins.length-1; i++){
			JTextField tf = new JTextField();
			tf.setToolTipText(ins[i].trim());
			tf.setText(infs[i].trim());
			if(infs[i].trim().length()>0)results.add(tf);
		}
		return results;
	}

	public TaskUI(String name, String dirname, String cmd, String in,
			String out, String memo, String fouts, String opts, String infiles) {
		res = ResourceBundle.getBundle( "cn.edu.jlu.ccst.sshclient.ui.lang.RES_TUI");
		this.setTitle(res.getString("TITLE_MOD"));
		initComponent();
		
		submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {

				try {
					SubmitButtonMousePressedE(evt);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		tTextField1.setText(name);
		tTextField3.setText(cmd);
		tTextArea2.setText(memo);
		for(JTextField jtf : maketextfields(in,infiles)){
			tfin.add(jtf);
		}
		tfin.validate();
		tfout.setText(out);
		dirTextField.setText(dirname);
		tfous.setText(fouts.replace("; ", ";\n"));
		topts.setText(opts);
		older = dirname;

		oldertask = new SSHTask();
		oldertask.setName(name);
		oldertask.setCmd(cmd);
		oldertask.setDirname(dirname);
		oldertask.setMemo(memo);
		oldertask.setFin(in);
		oldertask.setFout(out);
		oldertask.setFouts(fouts);
		oldertask.setOpts(opts);
		oldertask.setInfiles(infiles);
	}

	// ----------------------------------------------------//
	/**
	 * 初始画图函数
	 */
	private void initComponent() {

		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(this.getClass().getResource(
		"/cn/edu/jlu/ccst/sshclient/ui/resource/t.png"));
		setIconImage(img);
		this.setLayout(null);
		this.setSize(400, 600);

		tLabel1 = new JLabel(res.getString("TASK_NAME")+":");
		tLabel1.setBounds(50, 30, 80, 20);
		this.add(tLabel1);
		tTextField1 = new JTextField();
		tTextField1.setBounds(150, 30, 150, 30);
		this.add(tTextField1);
		if (this.getTitle().startsWith("新建")||this.getTitle().startsWith("New"))
			tTextField1.getDocument().addDocumentListener(
					new Swing_OnValueChanged());

		dirLabel = new JLabel(res.getString("WORK_DIR")+":");
		dirLabel.setBounds(50, 70, 80, 30);
		this.add(dirLabel);
		dirTextField = new JTextField();
		dirTextField.setBounds(150, 70, 150, 30);
		SSHGroup selectGroup = new SSHGroup();
		Iterator<SSHGroup> it;
		for (it = LinuxClient.gps.iterator(); it.hasNext();) {
			selectGroup = it.next();
			if (selectGroup.getId().equals(LinuxClient.cur.getId())) {
				break;
			}
		}
		this.gdir = selectGroup.getDirname();
		dirTextField.setText(gdir);
		this.add(dirTextField);

		tLabel3 = new JLabel(res.getString("TASK_COMMAND")+":");
		tLabel3.setBounds(50, 110, 80, 20);
		this.add(tLabel3);
		tTextField3 = new JTextField();
		tTextField3.setBounds(150, 110, 150, 30);
		this.add(tTextField3);

		loutnames = new JLabel(res.getString("RESULT_FILE")+":");
		tfous = new JTextArea();
		tfous.setLineWrap(true);
		tfous.setBounds(150, 150, 150, 80);
		tfous.setBorder(BorderFactory.createLineBorder(Color.black));
		tfousAreaPane = new JScrollPane(tfous,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tfousAreaPane.setBounds(150, 150, 150, 80);
		this.add(tfousAreaPane);
		tfous.setToolTipText(res.getString("TIP_TEXT_SEP"));
		loutnames.setBounds(50, 150, 80, 20);
		this.add(loutnames);

		lopts = new JLabel(res.getString("PARAMETERS")+":");
		lopts.setBounds(50, 240, 80, 20);
		this.add(lopts);
		topts = new JTextField();
		topts.setToolTipText(res.getString("TIP_TEXT_SEP"));
		topts.setBounds(150, 240, 150, 30);
		this.add(topts);

		lfin = new JLabel(res.getString("SELECT_INPUT_FILE")+":");
		tfin = new JPanel();
		//tfin.setBounds(150, 290, 150, 80);
		//tfin.setLineWrap(true);
		tfin.setBorder(BorderFactory.createLineBorder(Color.black));
		GridLayout gl = new GridLayout();
		gl.setColumns(1);
		gl.setRows(0);

		tfin.setLayout(gl);
		tfinAreaPane = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//tfinAreaPane = new JScrollPane();
		tfinAreaPane.getViewport().setView(tfin);
		tfinAreaPane.setBounds(150, 290, 150, 80);
		tfinAreaPane.setPreferredSize(new   Dimension(500,500)); 
		this.add(tfinAreaPane);
		lfin.setBounds(50, 290, 80, 20);
		JButton choosein = new JButton(res.getString("BROWSER"));
		this.add(lfin);
		choosein.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {

				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					String filePath = chooser.getSelectedFile().getPath();
					JTextField newtf = new JTextField();
					newtf.setText(chooser.getSelectedFile().getName());
					newtf.setToolTipText(filePath);
					tfin.add(newtf);
					tfin.repaint();
					tfin.revalidate();
					tfin.validate();
					//					tfin.append(filePath + ";\n");
					//					infiles = infiles+chooser.getSelectedFile().getName()+"; ";
				}

			}
		});
		choosein.setBounds(300, 290, 80, 25);
		this.add(choosein);
		
		cb = new JCheckBox(res.getString("SET_UPLOAD"),  false);
		cb.setBounds(10, 320, 140, 50);
		this.add(cb);
		
		lfout = new JLabel(res.getString("OUTPUT_DIR")+":");
		tfout = new JTextField();
		tfout.setBounds(150, 380, 150, 30);
		lfout.setBounds(50, 380, 80, 20);
		// TODO BROWSER to zh_cn
		JButton chooseout = new JButton(res.getString("BROWSER"));
		chooseout.setBounds(300, 380, 80, 25);
		chooseout.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {

				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					String filePath = chooser.getSelectedFile().getPath();
					tfout.setText(filePath);
				}

			}
		});
		this.add(lfout);
		this.add(tfout);
		this.add(chooseout);

		tLabel2 = new JLabel(res.getString("TASK_MEMO")+":");
		tLabel2.setBounds(50, 420, 80, 20);
		this.add(tLabel2);
		tTextArea2 = new JTextArea("");
		tTextArea2.setBounds(150, 420, 150, 80);
		tTextArea2.setLineWrap(true);
		tTextArea2.setBorder(BorderFactory.createLineBorder(Color.black));
		memoAreaPane = new JScrollPane(tTextArea2,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		memoAreaPane.setBounds(150, 420, 150, 80);
		this.add(memoAreaPane);

		resetButton = new JButton(res.getString("RESET"));
		resetButton.setBounds(50, 510, 80, 30);
		resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				ResetButtonMousePressed(evt);
			}
		});
		this.add(resetButton);
		
		submitButton = new JButton(res.getString("SUBMIT"));
		submitButton.setBounds(180, 510, 80, 30);
		
		this.add(submitButton);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();

		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;

		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
	}

	// 内部类，用来处理两个文本框文字同步
	private class Swing_OnValueChanged implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			dirTextField.setText(gdir + "/" + tTextField1.getText());

		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			dirTextField.setText(gdir + "/" + tTextField1.getText());
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			dirTextField.setText(gdir + "/" + tTextField1.getText());
		}

	}

	/**
	 * Reset按钮的处理函数
	 */
	private void ResetButtonMousePressed(java.awt.event.MouseEvent evt) {
		if (this.getTitle().startsWith("新建")||this.getTitle().startsWith("New")) {
			tTextField1.setText(null);
			tTextField3.setText(null);
			dirTextField.setText(null);
			tfout.setText(null);
			topts.setText(null);
			tTextArea2.setText(null);
			tfin.removeAll();
			tfous.setText(null);
		}else{
			tTextField1.setText(oldertask.getName());
			tTextField3.setText(oldertask.getCmd());
			dirTextField.setText(oldertask.getDirname());
			tfout.setText(oldertask.getFout());
			topts.setText(oldertask.getOpts());
			tTextArea2.setText(oldertask.getMemo());
			//tfin.setText(oldertask.getFin().replace("; ", ";\n"));
			tfin.removeAll();
			tfin.repaint();
			for(JTextField jtf : maketextfields(oldertask.getFin(),oldertask.getInfiles())){
				tfin.add(jtf);
			}
			tfin.validate();
			tfous.setText(oldertask.getFouts().replace("; ", ";\n"));
		}
	}

	/**
	 * Submit按钮的处理函数
	 * 
	 * @throws IOException
	 */
	private void SubmitButtonMousePressed(java.awt.event.MouseEvent evt)
	throws IOException {
		if (tTextField1.getText().equals("")) {
//			JOptionPane.showMessageDialog(null, "请输入新建任务的名字");
			JOptionPane.showMessageDialog(null,res.getString("INPUT_TASK_NAME"),null,JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (dirTextField.getText().equals("")) {
//			JOptionPane.showMessageDialog(null, "请输入工作组目录");
			JOptionPane.showMessageDialog(null,res.getString("INPUT_WORK_DIR"),null,JOptionPane.ERROR_MESSAGE );
			return;
		}
		if (!dirTextField.getText().startsWith("/")) {
//			JOptionPane.showMessageDialog(null, "目录格式不对，请以“/”开头");
			JOptionPane.showMessageDialog(null,res.getString("WRONG_DIR"),null,JOptionPane.ERROR_MESSAGE );
			return;
		}
		if (tTextField3.getText().equals("")) {
			JOptionPane.showMessageDialog(null,res.getString("NEW_TASK_CMD"),null,JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (tfout.getText().equals("")) {
			JOptionPane.showMessageDialog(null,res.getString("OUTPUT_DIR_SEL"),null,JOptionPane.ERROR_MESSAGE);
//			JOptionPane.showMessageDialog(null, "请选择输出目录");
			return;
		}
//		LinuxClient tempClient = LinuxClient.GetObj();
		SSHGroup selectGroup = new SSHGroup();
		BaseClass curType = new BaseClass();
		curType = LinuxClient.cur;
		String selectGroupId = curType.getId();
		String selectComputerId;// 选中任务所在组的计算机ID

		SSHTask newTask1 = new SSHTask();
		newTask1.setName(tTextField1.getText());
		newTask1.setDirname(dirTextField.getText());
		newTask1.setCmd(tTextField3.getText());
		newTask1.setMemo(tTextArea2.getText());
		//newTask1.setFin(tfin.getText());
		for(Component cc: tfin.getComponents()){
			if(cc instanceof JTextField){ 
				if(((JTextField)cc).getText().trim().length()>0){
					newTask1.setFin(newTask1.getFin()+((JTextField)cc).getText().trim()+"; ");
					newTask1.setInfiles(newTask1.getInfiles()+((JTextField)cc).getToolTipText().trim()+"; ");
				}
			}   
		}
		newTask1.setFout(tfout.getText());
		newTask1.setFouts(tfous.getText());
		if(!tfous.getText().trim().endsWith(";")&&!tfous.getText().trim().isEmpty())
			newTask1.setFouts(tfous.getText().trim()+";");		
		newTask1.setOpts(topts.getText());
		if(!topts.getText().trim().endsWith(";")&&!topts.getText().trim().isEmpty())	
		    newTask1.setOpts(topts.getText().trim()+";");
		Date SeverTime = new Date();
		SimpleDateFormat Severtimeformat = new SimpleDateFormat(
		"yyyyMMddHHmmss");
		newTask1.setCreatdate(SeverTime);// 获得创建成功时的时间
		newTask1.setId("T" + Severtimeformat.format(SeverTime));
		newTask1.setType((byte) 2);
		// 找到选中的组
		Iterator<SSHGroup> it;
		for (it = LinuxClient.gps.iterator(); it.hasNext();) {
			selectGroup = it.next();
			if (selectGroup.getId().equals(selectGroupId)) {
				break;
			}
		}
		newTask1.setGp(selectGroup);
		selectComputerId = selectGroup.getCp().getId();// 找到计算机的ID

		// 在服务器上创建工作目录
		Ltest = new JLabel();
		try {
			this.createdirs(this.getOpenedConnection(selectGroup.getCp()),
					dirTextField.getText());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		add(Ltest);
		Ltest.setBounds(120, 550, 90, 30);

		// 将信息保存到config.xml中
		SAXReader reader = new SAXReader();
		try {
			// String filePath = this.getClass().getResource("/").getPath() +
			// "cn/edu/jlu/ccst/sshclient/util/Config.xml";
			// System.out.println(filePath);
			Document doc = reader.read("Config.xml");
			OutputFormat format = OutputFormat.createPrettyPrint();
			Element root = doc.getRootElement();
			XMLWriter writer = null;// 声明写XML的对象

			List<Element> celements = root.elements();
			boolean flag = false;
			for (Element c : celements) {
				if (flag == true)
					break;
				if (c.valueOf("@id").equals(selectComputerId)) {
					List<Element> gelements = c.elements();
					for (Element g : gelements) {
						if (g.valueOf("@id").equals(selectGroupId)) {
							Element t = g.addElement("task");
							t.addAttribute("id", newTask1.getId());
							t.addAttribute("name", newTask1.getName());
							t.addAttribute("dirname", newTask1.getDirname());
							SimpleDateFormat timeFormat;
							timeFormat = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
							t.addAttribute("creatdate", timeFormat
									.format(newTask1.getCreatdate()));
							t.addAttribute("cmd", newTask1.getCmd());
							//t.addAttribute("in", newTask1.getFin().replace("\n", " "));
							t.addAttribute("out", newTask1.getFout());
							t.addAttribute("outfiles", newTask1.getFouts().replace("\n", " "));
							t.addAttribute("opts", newTask1.getOpts());
							t.addAttribute("starttime", "");
							t.addAttribute("memo", newTask1.getMemo());
							for(Component cc: tfin.getComponents()){
								if(cc instanceof JTextField){   
									Element ti = t.addElement("infile");
									if(((JTextField)cc).getText().trim().length()>0){
										ti.setText(((JTextField) cc).getText().trim());
										ti.addAttribute("url",((JTextField) cc).getToolTipText().trim());
									}
								}   
							}						

							flag = true;
							break;
						}
					}
				}
			}
			writer = new XMLWriter(new FileWriter("Config.xml"), format);
			writer.write(doc);
			writer.close();
			if (flag) {
				this.setVisible(false);
				this.dispose();
				JOptionPane.showMessageDialog(null, res.getString("NEW_TASK_SUC"),null,JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(cb.isSelected()){
			LinuxClient.upload();
		}
		// 如果是自己的任务，先把文件传过去。
		/*
		 * String Cmd=tTextField3.getText();
		 * 
		 * Connection conn = getOpenedConnection(TC); Session sess =
		 * conn.openSession(); System.out.println("新的S+:" +
		 * "输入文件.txt:"+tfin.getText());
		 * if((Cmd.startsWith("./"))&&(tfin.getText(
		 * )!=null)&&(!tfin.getText().equals(""))) { String
		 * s=Cmd.substring(Cmd.indexOf(" "), Cmd.length()); s=s.trim();
		 * s=s.substring(0,s.indexOf(" ")); System.out.println("新的S+:" + s +
		 * "输入文件.txt:"+tfin.getText()); scpPut(conn,tfin.getText(),s,"./"); }
		 * sess.close(); conn.close();
		 */

	}

	// ----------------------------------------------------------//
	public void scpPut(Connection conn, String localFile,
			String remoteFileName, String remoteDir) throws IOException {

		SCPClient client = new SCPClient(conn);
		client.put(localFile, remoteFileName, remoteDir, "0600");

	}

	// --------------------------------------------------------//
	public Connection getOpenedConnection(SSHComputer c) {
		Connection conn = new Connection(c.getHost());
		try {
			try {
				conn.connect();
			} catch (IOException e) {
				return conn;
			}
			boolean isAuthenticated = conn.authenticateWithPassword(c
					.getUsername(), c.getPassword());
			if (isAuthenticated == false) {
				throw new IOException("Authentication failed.");

			}
		} catch (Exception ev) {
			ev.printStackTrace();
		}

		return conn;

	}

	// ------------------------------------------------------------------------//
	private void SubmitButtonMousePressedE(java.awt.event.MouseEvent evt)
	throws IOException {
		if (tTextField1.getText().equals("")) {
//			JOptionPane.showMessageDialog(null, "请输入新建任务的名字");
			JOptionPane.showMessageDialog(null,res.getString("INPUT_TASK_NAME"),null,JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (dirTextField.getText().equals("")) {
//			JOptionPane.showMessageDialog(null, "请输入工作组目录");
			JOptionPane.showMessageDialog(null,res.getString("INPUT_WORK_DIR"),null,JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (!dirTextField.getText().startsWith("/")) {
//			JOptionPane.showMessageDialog(null, "目录格式不对，请以“/”开头");
			JOptionPane.showMessageDialog(null,res.getString("WRONG_DIR"),null,JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (tTextField3.getText().equals("")) {
//			JOptionPane.showMessageDialog(null, "请输入新建任务的命令");
			JOptionPane.showMessageDialog(null,res.getString("NEW_TASK_CMD"),null,JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (tfout.getText().equals("")) {
			JOptionPane.showMessageDialog(null,res.getString("OUTPUT_DIR_SEL"),null,JOptionPane.ERROR_MESSAGE);
//			JOptionPane.showMessageDialog(null, "请选择输出目录");
			return;
		}
		int i;
		for (i = 0; i < LinuxClient.tks.size(); ++i) {
			if (LinuxClient.getCur().getId().equals(
					LinuxClient.tks.get(i).getId())) {
				break;
			}
		}

		// 在服务器上创建工作目录
		if (!older.equals(dirTextField.getText())) {
			Ltest = new JLabel();
			LinuxClient.GetObj();
			SSHComputer selectComputer = LinuxClient.GetObj()
			.TfindselectComputer(LinuxClient.getCur().getId());
			try {
				this.createdirs(this.getOpenedConnection(selectComputer),
						dirTextField.getText());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			add(Ltest);
			Ltest.setBounds(120, 550, 90, 30);
		}else flag = true;

		if (flag) {
			String mins = "";
			String minfs = "";
			for(Component cc: tfin.getComponents()){
				if(cc instanceof JTextField){  
					if(((JTextField)cc).getText().length()>0){
						minfs = minfs +((JTextField)cc).getText()+"; ";
						mins = mins +((JTextField)cc).getToolTipText()+"; ";
					}
				}   
			}
			this.EditTaskFromXML(LinuxClient.getCur().getId(), tTextField1
					.getText(), dirTextField.getText(), tTextArea2.getText(),
					tTextField3.getText(), mins, tfout.getText(),
					LinuxClient.tks.get(i).getStartTime(), 0, tfous.getText(), topts.getText(), minfs);
			
			this.setVisible(false);
			this.dispose();
			JOptionPane.showMessageDialog(null, res.getString("MOD_TASK_SUC"),null,JOptionPane.INFORMATION_MESSAGE);
			if(cb.isSelected()){
				LinuxClient.upload();
			}
		}

		/*
		 * String Cmd=tTextField3.getText(); // LinuxClient.GetObj();
		 * SSHComputer
		 * TC=LinuxClient.GetObj().TfindselectComputer(LinuxClient.getCur
		 * ().getId()); // LinuxClient.GetObj();
		 * System.out.println(LinuxClient.getCur().getId()); Connection conn =
		 * getOpenedConnection(TC); Session sess = conn.openSession();
		 * if((Cmd.startsWith
		 * ("./"))&&(tfin.getText()!=null)&&(!tfin.getText().equals(""))) {
		 * String s=Cmd.substring(Cmd.indexOf(" "), Cmd.length()); s=s.trim();
		 * s=s.substring(0,s.indexOf(" ")); System.out.println("新的S+:" + s +
		 * "输入文件.txt:"+tfin.getText()); scpPut(conn,tfin.getText(),s,"./"); }
		 * sess.close(); conn.close();
		 */
	}

	// --------------------------------------------//
	// 根据id修改某个任务组,修改任务的开始执行时间
	public void EditTaskFromXML(String id, String n, String dn, String memo,
			String cmd, String in, String out, Date starttime, long stimelong, String outs, String opts, String infiles)
	throws IOException {
		SAXReader reader = new SAXReader();
		try {
			// String filePath = this.getClass().getResource("/").getPath() +
			// "cn/edu/jlu/ccst/sshclient/util/Config.xml";
			Document doc = reader.read("Config.xml");
			OutputFormat format = OutputFormat.createPrettyPrint();
			// Element root = doc.getRootElement();
			XMLWriter writer = null;// 声明写XML的对象
			List list = doc.selectNodes("/config/computer");
			Iterator iter = list.iterator();
			SimpleDateFormat timeFormat;
			timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			while (iter.hasNext()) {
				Element el = (Element) iter.next();
				Iterator it = el.elementIterator("group");
				boolean flg1 = true;
				while (it.hasNext()) {
					Element elta = (Element) it.next();
					Iterator itta = elta.elementIterator("task");
					boolean flag = true;
					while (itta.hasNext()) {
						Element et = (Element) itta.next();
						String s = et.attributeValue("id");
						if (s.equals(id)) {
							et.addAttribute("name", n);
							et.addAttribute("dirname", dn);
							et.addAttribute("cmd", cmd);

							for(Element cet:(List<Element>)(et.elements())){
								et.remove(cet);
							}

							in = in.trim();
							if(in.length()>0){
								in = in.substring(0, in.length() - 1);
								String[] ins = in.split(";");
								infiles = infiles.trim();
								infiles = infiles.substring(0,
										infiles.length() - 1);
								String[] infs = infiles.split(";");
								for (int i = 0; i <= ins.length - 1; i++) {
									Element ti = et.addElement("infile");
									ti.addAttribute("url",ins[i]);
									ti.setText(infs[i]);
								}
							}                           
							et.addAttribute("out", out);
							if(!outs.trim().endsWith(";")&&!outs.trim().isEmpty())
								outs = outs.trim()+";";
							if(!opts.trim().endsWith(";")&&!opts.trim().isEmpty())	
								opts = opts.trim()+";";
							et.addAttribute("outfiles", outs.trim().replace("\n", " "));
							et.addAttribute("opts", opts.trim());
							if (starttime == null) {
								et.addAttribute("starttime", "");
								et.addAttribute("stimelong", "0");
							} else {
								et.addAttribute("starttime", timeFormat
										.format(starttime));
								et.addAttribute("stimelong", String
										.valueOf(stimelong));
							}
							et.addAttribute("memo", memo);
							flag = false;
							break;
						}
					}
					if (flag == false) {
						flg1 = false;
						break;
					}
				}
				if (flg1 == false)
					break;
			}

			// System.out.println("写入xml:"+ starttime);
			writer = new XMLWriter(new FileWriter("Config.xml"), format);
			writer.write(doc);
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// -----------------------------------------------------------//
	/*
	 * 从config.xml中获得任务开始的时间，未执行返回null
	 */
	public Date getTaskStartTime(SSHTask runtask) {
		Date startime1;
		SAXReader reader = new SAXReader();
		try {
			// String filePath = this.getClass().getResource("/").getPath() +
			// "cn/edu/jlu/ccst/sshclient/util/Config.xml";
			Document doc = reader.read("Config.xml");
			// OutputFormat format = OutputFormat.createPrettyPrint();
			// Element root = doc.getRootElement();
			// XMLWriter writer = null;// 声明写XML的对象
			List list = doc.selectNodes("/config/computer");
			Iterator iter = list.iterator();
			SimpleDateFormat timeFormat;
			timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			while (iter.hasNext()) {
				Element el = (Element) iter.next();
				Iterator it = el.elementIterator("group");
				while (it.hasNext()) {
					Element elta = (Element) it.next();
					Iterator itta = elta.elementIterator("task");
					while (itta.hasNext()) {
						Element et = (Element) itta.next();
						String s = et.attributeValue("id");
						if (s.equals(runtask.getId())) {
							startime1 = timeFormat.parse(et
									.attributeValue("starttime"));
							return startime1;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// -----------------------------------------------------//
	/**
	 * 修改任务执行状态
	 */
	public void EditTaskRunSuccXML(String id, boolean runsucc) {
		SAXReader reader = new SAXReader();
		try {
			// String filePath = this.getClass().getResource("/").getPath() +
			// "cn/edu/jlu/ccst/sshclient/util/Config.xml";
			Document doc = reader.read("Config.xml");
			OutputFormat format = OutputFormat.createPrettyPrint();
			// Element root = doc.getRootElement();
			XMLWriter writer = null;// 声明写XML的对象
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
						if (s.equals(id)) {
							String temps;
							if (runsucc == true)
								temps = "1";
							else
								temps = "0";
							et.addAttribute("runsc", temps);
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
			writer = new XMLWriter(new FileWriter("Config.xml"), format);
			writer.write(doc);
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------//
	/**
	 * 将自定义任务的pid写入config.xml中
	 */
	public void EditTaskRunPid(String id, String pid) {
		SAXReader reader = new SAXReader();
		try {
			// String filePath = this.getClass().getResource("/").getPath() +
			// "cn/edu/jlu/ccst/sshclient/util/Config.xml";
			Document doc = reader.read("Config.xml");
			OutputFormat format = OutputFormat.createPrettyPrint();
			// Element root = doc.getRootElement();
			XMLWriter writer = null;// 声明写XML的对象
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
						if (s.equals(id)) {
							et.addAttribute("runpid", pid);
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
			writer = new XMLWriter(new FileWriter("Config.xml"), format);
			writer.write(doc);
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------//

	// ---------------------------------------------//创建目录
	private void createdirs(Connection conn, String dirs) throws IOException {

		// Connection conn = getOpenedConnection(TC);
		Ltest.setText(res.getString("SET_UP_DIR"));
		Session sess = conn.openSession();
		String finalcmd = dirs.substring(1);
		sess.execCommand("./CShell mkdir -p " + finalcmd.trim());

		String out;
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(sess.getStdout()));
		while ((out = bufferedReader.readLine()) != null) {
			if (out.equals("EOP")) {
				Ltest.setText(res.getString("SET_UP_DIR_SUC"));
				this.flag = true;

			}
		}
		sess.close();
		conn.close();

	}

	/**
	 * 主函数
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TaskUI().setVisible(true);
			}
		});
	}

}
