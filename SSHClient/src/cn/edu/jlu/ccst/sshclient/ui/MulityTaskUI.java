package cn.edu.jlu.ccst.sshclient.ui;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import cn.edu.jlu.ccst.sshclient.model.*;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*; 
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class MulityTaskUI extends javax.swing.JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel Ltest, tLabel0, tLabel1, tLabel2, tLabel3, dirLabel;
	// private JLabel memoLabel;
	private JTextField tTextField0, tTextField1, tTextField3, dirTextField;
	private JTextArea tTextArea2, tfous;
	private JScrollPane tfinAreaPane, tfousAreaPane, memoAreaPane;
	private JButton resetButton, submitButton, inputoptsButton, inputrulesButton;
	private JLabel lfin, lfout, loutnames, lopts;
	private JTextField tfout, topts;
	private boolean flag = false;
	private String gdir;
	private JPanel tfin;
	public static List<String> opts; 
	public static List<String> rules; 
	private static ResourceBundle res;
	private JCheckBox cb;
	
	// private JButton choosein,chooseout;

	public MulityTaskUI() {
		res = ResourceBundle.getBundle( "cn.edu.jlu.ccst.sshclient.ui.lang.RES_MTASKUI");
		this.setTitle(res.getString("CREATEBATCHTASKS"));
		opts = new ArrayList<String>();
		rules = new ArrayList<String>();
		initComponent();

		inputrulesButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				String regEx="\\([1-9]\\d*\\)"; 
				List<String> optnum = new ArrayList();
				Pattern p=Pattern.compile(regEx);
				Matcher m=p.matcher(topts.getText().trim()); 
				while ( m.find()) {
					//System.out.println(m.group());
					optnum.add(m.group());
			    }
				if(tTextField0.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, res.getString("TIP_TASKSAMOUNT"),null,JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!Pattern.matches("[1-9]\\d*",tTextField0.getText())){
					JOptionPane.showMessageDialog(null, res.getString("ONLYSTARTWITHINT"),null,JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(tTextField0.getText().trim().startsWith("0")){
					JOptionPane.showMessageDialog(null, res.getString("NOTSTARTWITHZERO"),null,JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(topts.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, res.getString("TIP_ENTERPARAMETER"),null,JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(optnum.isEmpty()){
					JOptionPane.showMessageDialog(null, res.getString("ENTERVARPARAMETER"),null,JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(topts.getText().indexOf("(0)")!=-1){
					JOptionPane.showMessageDialog(null, res.getString("VARREPLACEFROMONE"),null,JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				InputRulesUI newInputRulesUI = new InputRulesUI(Integer.parseInt(tTextField0.getText()), topts.getText().trim(), rules);
				newInputRulesUI.setModal(true);
				newInputRulesUI.setVisible(true);
				
			}
		});
		inputoptsButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {				
				if(tTextField0.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, res.getString("TIP_TASKSAMOUNT"),null,JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!Pattern.matches("[1-9]\\d*",tTextField0.getText())){
					JOptionPane.showMessageDialog(null, res.getString("ONLYSTARTWITHINT"),null,JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(tTextField0.getText().trim().startsWith("0")){
					JOptionPane.showMessageDialog(null, res.getString("NOTSTARTWITHZERO"),null,JOptionPane.ERROR_MESSAGE);
					return;
				}
								
				InputOptsUI newInputOptsUI = new InputOptsUI(Integer.parseInt(tTextField0.getText()), opts);
				newInputOptsUI.setModal(true);
				newInputOptsUI.setVisible(true);
			}
		});
		resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				ResetButtonMousePressed(evt);
			}
		});
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

	// ----------------------------------------------------//
	/**
	 * 初始画图函数
	 */
	private void initComponent() {

		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(this.getClass().getResource(
		"/cn/edu/jlu/ccst/sshclient/ui/resource/mt.png"));
		setIconImage(img);
		this.setLayout(null);
		this.setSize(400, 700);
		
		tLabel0 = new JLabel(res.getString("TASKSAMOUNT"));
		tLabel0.setBounds(50, 30, 80, 20);
		this.add(tLabel0);
		tTextField0 = new JTextField();
		tTextField0.setBounds(150, 30, 150, 30);
		this.add(tTextField0);

		tLabel1 = new JLabel(res.getString("TASKNAME"));
		tLabel1.setBounds(50, 70, 80, 20);
		this.add(tLabel1);
		tTextField1 = new JTextField();
		tTextField1.setBounds(150, 70, 150, 30);
		this.add(tTextField1);
		tTextField1.getDocument().addDocumentListener(new Swing_OnValueChanged());

		dirLabel = new JLabel(res.getString("WORKDIR"));
		dirLabel.setBounds(50, 110, 80, 30);
		this.add(dirLabel);
		dirTextField = new JTextField();
		dirTextField.setBounds(150, 110, 150, 30);
		SSHGroup selectGroup = new SSHGroup();
		Iterator<SSHGroup> it;
		for (it = LinuxClient.gps.iterator(); it.hasNext();) {
			selectGroup = (SSHGroup) it.next();
			if (selectGroup.getId().equals(LinuxClient.cur.getId())) {
				break;
			}
		}
		this.gdir = selectGroup.getDirname();
		dirTextField.setText(gdir);
		this.add(dirTextField);

		tLabel3 = new JLabel(res.getString("TASKCOMMAND"));
		tLabel3.setBounds(50, 150, 80, 20);
		this.add(tLabel3);
		tTextField3 = new JTextField();
		tTextField3.setBounds(150, 150, 150, 30);
		this.add(tTextField3);

		loutnames = new JLabel(res.getString("RESULTFILE"));
		tfous = new JTextArea();
		tfous.setLineWrap(true);
		tfous.setBounds(150, 190, 150, 80);
		tfous.setBorder(BorderFactory.createLineBorder(Color.black));
		tfousAreaPane = new JScrollPane(tfous,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tfousAreaPane.setBounds(150, 190, 150, 80);
		this.add(tfousAreaPane);
		tfous.setToolTipText(res.getString("SEPARATEWITHSEMICOLON"));
		loutnames.setBounds(50, 190, 80, 20);
		this.add(loutnames);

		lopts = new JLabel(res.getString("ENTERPARAMETER"));
		lopts.setBounds(50, 280, 80, 20);
		this.add(lopts);
		topts = new JTextField();
		topts.setToolTipText(res.getString("PARAMETEREXPLANATION"));
		topts.setBounds(150, 280, 150, 30);
		this.add(topts);

		inputoptsButton = new JButton(res.getString("CHECKPARAMETERS"));
		inputoptsButton.setBounds(40, 320, 150, 30);
		this.add(inputoptsButton);

		inputrulesButton = new JButton(res.getString("PARAMETERRULE"));
		inputrulesButton.setBounds(200, 320, 150, 30);
		this.add(inputrulesButton);
		
		lfin = new JLabel(res.getString("INPUTFILE"));
		tfin = new JPanel();
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
		tfinAreaPane.setBounds(150, 360, 150, 80);
		tfinAreaPane.setPreferredSize(new   Dimension(500,500)); 
		this.add(tfinAreaPane);
		lfin.setBounds(50, 360, 80, 20);
		JButton choosein = new JButton(res.getString("BROWSE"));
		this.add(lfin);
		
		cb = new JCheckBox(res.getString("SET_UPLOAD"),  false);
		cb.setBounds(50, 400, 100, 50);
		this.add(cb);
		
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
				}

			}
		});
		choosein.setBounds(300, 360, 80, 25);
		this.add(choosein);

		lfout = new JLabel(res.getString("OUTPUTDIR"));
		tfout = new JTextField();
		tfout.setBounds(150, 450, 150, 30);
		lfout.setBounds(50, 450, 80, 20);
		JButton chooseout = new JButton(res.getString("BROWSE"));
		chooseout.setBounds(300, 450, 80, 25);
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

		tLabel2 = new JLabel(res.getString("TASKMEMO"));
		tLabel2.setBounds(50, 500, 80, 20);
		this.add(tLabel2);
		tTextArea2 = new JTextArea("");
		tTextArea2.setBounds(150, 500, 150, 80);
		tTextArea2.setLineWrap(true);
		tTextArea2.setBorder(BorderFactory.createLineBorder(Color.black));
		memoAreaPane = new JScrollPane(tTextArea2,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		memoAreaPane.setBounds(150, 500, 150, 80);
		this.add(memoAreaPane);

		resetButton = new JButton(res.getString("RESET"));
		resetButton.setBounds(50, 590, 80, 30);		
		this.add(resetButton);

		submitButton = new JButton(res.getString("SUBMIT"));
		submitButton.setBounds(180, 590, 80, 30);
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
		tTextField0.setText(null);
		tTextField1.setText(null);
		tTextField3.setText(null);
		dirTextField.setText(null);
		tfout.setText(null);
		topts.setText(null);
		tTextArea2.setText(null);
		tfin.removeAll();
		tfous.setText(null);
		
	}

	/**
	 * Submit按钮的处理函数
	 * 
	 * @throws IOException
	 */
	private void SubmitButtonMousePressed(java.awt.event.MouseEvent evt)
	throws IOException {
		if(tTextField0.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, res.getString("TIP_TASKSAMOUNT"),null,JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(!Pattern.matches("[1-9]\\d*",tTextField0.getText())){
			JOptionPane.showMessageDialog(null, res.getString("ONLYSTARTWITHINT"),null,JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (tTextField1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, res.getString("TIP_TASKNAME"),null,JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (dirTextField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, res.getString("TIP_WORKDIR"),null,JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (!dirTextField.getText().startsWith("/")) {
			JOptionPane.showMessageDialog(null, res.getString("DIREXPLANATION"),null,JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (tTextField3.getText().equals("")) {
			JOptionPane.showMessageDialog(null, res.getString("TIP_TASKCOMMAND"),null,JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (tfout.getText().equals("")) {
			JOptionPane.showMessageDialog(null, res.getString("TIP_OUTPUTDIR"),null,JOptionPane.ERROR_MESSAGE);
			return;
		}
		LinuxClient tempClient = LinuxClient.GetObj();
		SSHGroup selectGroup = new SSHGroup();
		BaseClass curType = new BaseClass();
		curType = LinuxClient.cur;
		String selectGroupId = curType.getId();
		String selectComputerId;// 选中任务所在组的计算机ID
		String mkdircmds = "";
		Ltest = new JLabel();
		submitButton.setEnabled(false);
        
		for (int ii = 0; ii < Integer.parseInt(tTextField0.getText().trim()); ii++) {
			SSHTask newTask1 = new SSHTask();
			newTask1.setName(tTextField1.getText().trim()+"_"+(ii+1));
			newTask1.setDirname(dirTextField.getText().trim()+"_"+(ii+1));
			newTask1.setCmd(tTextField3.getText());
			newTask1.setMemo(tTextArea2.getText());
			// newTask1.setFin(tfin.getText());
			for (Component cc : tfin.getComponents()) {
				if (cc instanceof JTextField) {
					if (((JTextField) cc).getText().trim().length() > 0) {
						newTask1.setFin(newTask1.getFin()
								+ ((JTextField) cc).getText().trim() + "; ");
						newTask1.setInfiles(newTask1.getInfiles()
								+ ((JTextField) cc).getToolTipText().trim()
								+ "; ");
					}
				}
			}
			newTask1.setFout(tfout.getText().trim());

			String finalfouts = "";
			String[] outs =  tfous.getText().trim().split(";");
			for(String str:outs){
				if(!str.trim().isEmpty()){
					str = (ii+1)+"_"+str.trim();
					finalfouts = finalfouts+str+";";
				}					
			}
			newTask1.setFouts(finalfouts);
			if(opts.size()==Integer.parseInt(tTextField0.getText().trim()))
			newTask1.setOpts(opts.get(ii).trim());
			Date SeverTime = new Date();
			SimpleDateFormat Severtimeformat = new SimpleDateFormat(
					"yyyyMMddHHmmss");
			newTask1.setCreatdate(SeverTime);// 获得创建成功时的时间
			newTask1.setId("T" + Severtimeformat.format(SeverTime)+"_"+(ii+1));
			newTask1.setType((byte) 2);
			// 找到选中的组
			Iterator<SSHGroup> it;
			for (it = LinuxClient.gps.iterator(); it.hasNext();) {
				selectGroup = (SSHGroup) it.next();
				if (selectGroup.getId().equals(selectGroupId)) {
					break;
				}
			}
			newTask1.setGp(selectGroup);
			selectComputerId = selectGroup.getCp().getId();// 找到计算机的ID

			// 在服务器上创建工作目录的命令			
			mkdircmds = mkdircmds + " mkdir -p ."+dirTextField.getText().trim()+"_"+(ii+1)+"; ";

			// 将信息保存到config.xml中
			SAXReader reader = new SAXReader();
			try {
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
								t
										.addAttribute("dirname", newTask1
												.getDirname());
								SimpleDateFormat timeFormat;
								timeFormat = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss");
								t.addAttribute("creatdate", timeFormat
										.format(newTask1.getCreatdate()));
								t.addAttribute("cmd", newTask1.getCmd());
								// t.addAttribute("in",
								// newTask1.getFin().replace("\n", " "));
								t.addAttribute("out", newTask1.getFout());
								t.addAttribute("outfiles", newTask1.getFouts()
										.replace("\n", " "));
								t.addAttribute("opts", newTask1.getOpts());
								t.addAttribute("starttime", "");
								t.addAttribute("memo", newTask1.getMemo());
								for (Component cc : tfin.getComponents()) {
									if (cc instanceof JTextField) {
										Element ti = t.addElement("infile");
										if (((JTextField) cc).getText().trim()
												.length() > 0) {
											ti.setText(((JTextField) cc)
													.getText().trim());
											ti.addAttribute("url",
													((JTextField) cc)
															.getToolTipText()
															.trim());
										}
									}
								}

								flag = true;
								break;
							}
						}
					}
				}
				writer = new XMLWriter(new FileOutputStream("Config.xml"), format);
				writer.write(doc);
				writer.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 在服务器上创建工作目录
		try {
			this.createdirs(this.getOpenedConnection(selectGroup.getCp()),mkdircmds);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		add(Ltest);
		Ltest.setBounds(120, 650, 90, 30);
			this.setVisible(false);
			this.dispose();
			JOptionPane.showMessageDialog(null, res.getString("CREATETASKSUCC"),null,JOptionPane.INFORMATION_MESSAGE);
			
		int taskAmount = Integer.valueOf(tTextField0.getText().trim());
		String infiles = "";
		String infilesP = "";
		for (Component cc : tfin.getComponents()) {
			if (cc instanceof JTextField) {
				if (((JTextField) cc).getText().trim().length() > 0) {
					 infiles += ((JTextField) cc).getText().trim() + "; ";
					 infilesP += ((JTextField) cc).getToolTipText().trim()+ "; ";
				}
			}
		}
		String dir = dirTextField.getText().trim();
		if(cb.isSelected()){
			LinuxClient.upload(taskAmount, infiles, infilesP, dir);
		}
		
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


	// ---------------------------------------------//创建目录
	private void createdirs(Connection conn, String dirs) throws IOException {

		// Connection conn = getOpenedConnection(TC);
		Ltest.setText(res.getString("DIRSETTING"));
		Session sess = conn.openSession();
		sess.execCommand("./CShell " + dirs);

		String out;
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(sess.getStdout()));
		while ((out = bufferedReader.readLine()) != null) {
			if (out.equals("EOP")) {
				Ltest.setText(res.getString("CREATEDIRSUCC"));
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
				new MulityTaskUI().setVisible(true);
			}
		});
	}

}

