package cn.edu.jlu.ccst.sshclient.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SFTPv3Client;
import ch.ethz.ssh2.SFTPv3FileAttributes;
import cn.edu.jlu.ccst.sshclient.util.MidScr;
import cn.edu.jlu.ccst.sshclient.util.ProgressBarRun;
/**
 * 进度条控件
 * @author Administrator
 *
 */
public class ProgressBar implements  ActionListener,ChangeListener,Runnable{
	JFrame   f   =   null;  
	JProgressBar   progressbar;  
	JLabel   label;  
	Timer   timer;  
	JButton   b;  
	String sourceFile = null;
	String aimFile = null;
	String aimDir = null;
	int upOrDown = 0;
	Connection conn = null;
	Thread ty = null;
	Thread ty2 = null;
	ProgressBarRun pbrt;


	public String getSourceFile() {
		return sourceFile;
	}


	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}


	public String getAimFile() {
		return aimFile;
	}


	public void setAimFile(String aimFile) {
		this.aimFile = aimFile;
	}


	public String getAimDir() {
		return aimDir;
	}


	public void setAimDir(String aimDir) {
		this.aimDir = aimDir;
	}


	public int getUpOrDown() {
		return upOrDown;
	}


	public void setUpOrDown(int upOrDown) {
		this.upOrDown = upOrDown;
	}




	public Connection getConn() {
		return conn;
	}


	public void setConn(Connection conn) {
		this.conn = conn;
	}



	/**
	 * 进度条构造函数
	 * @param conn
	 * 传递连接信息
	 * @param sourceFile
	 * 传输源文件
	 * @param aimFile
	 * 传输目标文件
	 * @param aimDir
	 * 目标文件夹
	 * @param upOrDown
	 * 标明上传或下载，1表示下载，2表示上传
	 */

	public   ProgressBar(Connection conn, String sourceFile, String aimFile, String aimDir,int upOrDown)                                                        
	{  



		this.setConn(conn);
		this.setSourceFile(sourceFile);
		this.setAimFile(aimFile);
		this.setAimDir(aimDir);
		this.setUpOrDown(upOrDown);
		f   =   new   JFrame("文件"+sourceFile+"传输");  
		Container   contentPane   =   f.getContentPane();  

		label   =   new   JLabel("   ",JLabel.CENTER);  
		progressbar   =   new   JProgressBar();  
		progressbar.setOrientation(JProgressBar.HORIZONTAL);  
		progressbar.setMinimum(0);  
		//progressbar.setMaximum(200);  
		progressbar.setValue(0);  
		progressbar.setStringPainted(true);  
		progressbar.addChangeListener(this);  
		progressbar.setPreferredSize(new   Dimension(200,30));  
		progressbar.setBorderPainted(true);  

		JPanel   panel   =   new   JPanel();  
		b   =   new   JButton("中止传输");  
		b.addActionListener(this);  
		panel.add(b);  

		//timer   =   new   Timer(50,this);  

		contentPane.add(panel,BorderLayout.CENTER);  
		contentPane.add(progressbar,BorderLayout.NORTH);  
		contentPane.add(label,BorderLayout.SOUTH); 
		//设置窗体大小
		f.setSize(100, 40);
		//使用中心定位窗体类
		MidScr ms=new MidScr(f);
		//设定窗体的左上坐标
		f.setLocation(ms.getX(), ms.getY ()); 

		f.pack();  
		f.setVisible(true);  

		f.addWindowListener(new   WindowAdapter()   {  
			public   void   windowClosing(WindowEvent   e)   {  
			}  
		});  

	}  


	public   void   actionPerformed(ActionEvent   e)  
	{  

		SFTPv3Client s3c = null;
		try{
			s3c = new SFTPv3Client(conn);
			s3c.rm(aimFile);
		}catch(IOException ee){
			ee.printStackTrace();
		}
		ty.stop();
		ty2.stop();
		conn.close();
		f.dispose();

	}  

	public   void   stateChanged(ChangeEvent   e1)  
	{  
		int   value   =   progressbar.getValue();  
		int   maxValue = progressbar.getMaximum();
		float speed = ProgressBarRun.getSpeed();
		String unit=null;
		if (speed>1000){
			speed/=1000;
			unit = "MB/S";
		}
		else
			unit ="KB/S";
		NumberFormat   nbf=NumberFormat.getInstance();
		nbf.setMinimumFractionDigits(2);   
		String   speedF   =   nbf.format(speed);   
		if(e1.getSource()   ==   progressbar)  
		{  
			label.setText("传输速率："+speedF+unit);    
		}  
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		pbrt = new ProgressBarRun(conn, sourceFile, aimFile, aimDir, upOrDown,
				progressbar, f);
		//线程ty获取进度条初始相关信息,开始文件传输
		ty = new Thread(pbrt);
		ty.start();
		//线程ty2获取进度条需要的实时文件信息
		ty2 = new Thread(pbrt);
		ty2.start();
	}  
}
