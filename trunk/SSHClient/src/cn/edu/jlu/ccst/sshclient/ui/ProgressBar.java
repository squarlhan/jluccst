package cn.edu.jlu.ccst.sshclient.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
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
import cn.edu.jlu.ccst.sshclient.util.ProgressBarSpeeder;
/**
 * 进度条控件
 * @author Administrator
 *
 */
public class ProgressBar extends javax.swing.JFrame implements  ActionListener,ChangeListener,Runnable{
	//JFrame   f   =   null;  
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
    ProgressBarSpeeder pbst;

	
	public ProgressBar() throws HeadlessException {
		super();
	}


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
            this.setTitle("文件"+sourceFile+"传输");  
            Container   contentPane   =   this.getContentPane();  
             
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
            this.setSize(150, 60);
            
            this.setResizable(false);
            //使用中心定位窗体类
            MidScr ms=new MidScr(this);
            //设定窗体的左上坐标
            this.setLocation(ms.getX(), ms.getY ()); 
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            this.pack();  
            this.setVisible(true);  
            
            // TODO Auto-generated method stub
            pbrt = new ProgressBarRun(conn, sourceFile, aimFile, aimDir, upOrDown,
        			progressbar, this);
            pbst = new ProgressBarSpeeder(conn, sourceFile, aimFile, aimDir, upOrDown, progressbar, pbrt.getFileSize(), this, pbrt);
           
            System.out.println(sourceFile+":setVisible");
            ty = new Thread(pbrt);
            ty.start();
            //线程ty2获取进度条需要的实时文件信息
            ty2 = new Thread(pbst);
            ty2.start();
               
    }  
     
     
    public   void   actionPerformed(ActionEvent   e)  
    {  

    	if(upOrDown == 2){
	    	SFTPv3Client s3c = null;
	    	System.out.println("deleteAimFile:"+aimFile);
	    	conn.close();
	    	ty.stop();
	    	ty2.stop();
	    	try{
	    	s3c = new SFTPv3Client(conn);
	    	s3c.rm(aimFile);
	    	}catch(IOException ee){
	    		ee.printStackTrace();
	    	}
	    	
	    	this.dispose();
    	}else{
    		if(upOrDown == 1){
    			System.out.println("deleteAimFile:"+aimFile);
    			
//    			if(aimFile.equals("E:\\TDDOWNLOAD\\Friend2.avi"))
//    				aimFile = "E:\\\\TDDOWNLOAD\\\\Friend2.avi";
//    			else
//    				aimFile = "E:\\\\TDDOWNLOAD\\\\Friend.avi";
//    			System.out.println("deleteAimFileAF:"+aimFile);
//    			pbrt.file;
    			File file= new File(aimFile);
//    			conn.close();
    			ty.interrupt();
    	    	ty2.interrupt();
    	    	this.dispose();
    	    	if(file.exists()&&file.isFile()){
    	    		System.out.println(aimFile);
    	    		if(file.delete()){
    	    			System.out.println("DeleteS");
    	    		}else{
    	    			System.out.println("DeleteF");
    	    		}
    	    	}
    			
    		}
    	}
   	     
    }  
                     
    public   void   stateChanged(ChangeEvent   e1)  
    {  
//            int   value   =   progressbar.getValue();  
//            int   maxValue = progressbar.getMaximum();
            float speed = pbst.getSpeed();
            String unit=null;
            if (speed>1000){
            	speed/=1000;
            	unit = "MB/S";
            }
            else
            	unit ="KB/S";
            NumberFormat   nbf=NumberFormat.getInstance();
            nbf.setMinimumFractionDigits(2);   
//            System.out.println("speed:"+speed);
            String   speedF   =   nbf.format(speed);   
            if(e1.getSource()   ==   progressbar)  
            {  
                    label.setText("传输速率："+speedF+unit);    
            }  
    }


	@Override
	public void run() {
		// TODO Auto-generated method stub
		//线程ty获取进度条初始相关信息,开始文件传输
        ty = new Thread(pbrt);
        ty.start();
        //线程ty2获取进度条需要的实时文件信息
        ty2 = new Thread(pbst);
        ty2.start();
	}
 
}
