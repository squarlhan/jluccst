package cn.edu.jlu.ccst.sshclient.ui;

import java.io.IOException;
import java.util.List;
import java.util.*;
import java.awt.*; 

import javax.swing.*;

public class InputOptsUI extends javax.swing.JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<JLabel> labels;
	private List<JTextField> textFields;
	private int tasksum;
	private int optssum;
	private JButton resetButton, submitButton;
	private JScrollPane scrollPane;
	private JPanel panel, panel1;
	private List<String> opts;

	public InputOptsUI(int tasksum,List<String> opts) {
		this.setTitle("输入所有任务参数");
		this.tasksum = tasksum;
		labels = new ArrayList<JLabel>();
		textFields = new ArrayList<JTextField>();
		this.opts = opts;
		initComponent();
		for(int i = 0; i<= opts.size()-1; i++){
			textFields.get(i).setText(opts.get(i));
		}
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
		int tempheight,tempwidth;
		if(tasksum>10){
			tempwidth = 405;
			tempheight = 500;
		}		
		else {
			tempwidth = 405;
			tempheight = tasksum*40+110;
		}
	    this.setSize(tempwidth, tempheight);
		this.setLayout(null);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 400, tasksum*40+40);
		scrollPane = new JScrollPane(panel,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0,0,400,tempheight-70);
		scrollPane.setViewportView(panel);
		this.add(scrollPane);
		panel.setPreferredSize(new Dimension(400, tasksum*40+40));
	    panel.revalidate();
	    panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0, tempheight-70, tempwidth, 70);
		this.add(panel1);
		
		int x = 40;
		int y = 30;
		
		for(int i=0;i<=tasksum-1;i++){
			JLabel newlabel = new JLabel("输入第"+(i+1)+"个任务的参数：");
			newlabel.setBounds(x,y+i*40,140, 30);
			labels.add(newlabel);
			panel.add(newlabel);
			JTextField newtf = new JTextField();
			newtf.setBounds(x+140,y+i*40,150, 30);
			newtf.setBorder(BorderFactory.createLineBorder(Color.black));
			newtf.setToolTipText("请用半角分号隔开多个参数！");
			textFields.add(newtf);
			panel.add(newtf);
			if(i==tasksum-1){
				resetButton = new JButton("重置:");
				resetButton.setBounds(100, 0, 80, 30);
				panel1.add(resetButton);

				submitButton = new JButton("提交:");
				submitButton.setBounds(250, 0, 80, 30);
				panel1.add(submitButton);
				
			}
		}
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;

		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
	}

	/**
	 * Reset按钮的处理函数
	 */
	private void ResetButtonMousePressed(java.awt.event.MouseEvent evt) {
		for(JTextField tf:textFields){
			tf.setText(null);
		}
		
	}

	/**
	 * Submit按钮的处理函数
	 * 
	 * @throws IOException
	 */
	private void SubmitButtonMousePressed(java.awt.event.MouseEvent evt)
	throws IOException {
		this.opts = new ArrayList();
		for(JTextField tf:textFields){
			opts.add(tf.getText());
		}
		MulityTaskUI.opts = opts;
		this.setVisible(false);
		this.dispose();
		JOptionPane.showMessageDialog(null, "输入任务参数成功！");
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
				new InputOptsUI(5,null).setVisible(true);
			}
		});
	}

}



