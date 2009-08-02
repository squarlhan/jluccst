package cn.edu.jlu.ccst.sshclient.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import cn.edu.jlu.ccst.sshclient.util.ProgressBarRun;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SFTPv3Client;
import ch.ethz.ssh2.SFTPv3FileAttributes;

public class ProgressBarSpeed implements Runnable {

	static float speed;
	Connection conn = null;
	String sourceFile = null;
	String aimFile = null;
	String aimDir = null;
	int upOrDown = 0;
	JProgressBar progressbar = null;
    long fileSize = 0;
    long localFS = 0;
    int i=0;
    JFrame f = null;
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
	public static float getSpeed() {
		return speed;
	}
	public static void setSpeed(float speed) {
		ProgressBarSpeed.speed = speed;
	}

	public ProgressBarSpeed(Connection conn, String sourceFile, String aimFile, String aimDir, int upOrDown,
			JProgressBar progressbar, JFrame f) {
		super();
		this.conn = conn;
		this.sourceFile = sourceFile;
		this.aimFile = aimFile;
		this.aimDir = aimDir;
		this.upOrDown = upOrDown;
		this.progressbar = progressbar;
		this.f = f;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(upOrDown==1){
			//进度条实时信息
			long startFS = 0;
			long endFS = 0;
			long transFS = 0;
			long time = 0;
			long startTime = System.nanoTime();
			long endTime = startTime;
			do{
				if(time>1000000000){
					transFS = endFS-startFS;
	            	startFS = endFS;
					speed = 1000000*transFS/time;
					startTime = endTime;
	
				}
				
				File file= new File(aimFile);
	            while(!file.exists()){
	            	
	            }
	            FileInputStream fis = null;
	            try{
	                fis = new FileInputStream(file);  
	                localFS = fis.available();  
	                endFS = localFS;
	                long localFStemp = localFS;
	                for(int j=0;j<i;j++){
	                	localFStemp/=10;
	                }
	                
	                progressbar.setValue(Integer.valueOf(String.valueOf(localFStemp)));
	                if(fileSize == 0)
	                	progressbar.setValue(100);
	            }catch(IOException e1){   
	                System.out.println("IO出错！");
	            }
	            endTime = System.nanoTime();
	            time = endTime-startTime;
			}while(localFS<fileSize);
			f.dispose();
			conn.close();
		}
		else{
													//处理上传进度
			if(upOrDown == 2){
			//进度条实时信息
			long startFS = 0;
			long endFS = 0;
			long transFS = 0;
			long time = 0;
			long startTime = System.nanoTime();
			long endTime = startTime;
			SFTPv3Client s3c = null;
			SFTPv3FileAttributes sfa = null;
			try{
			s3c = new SFTPv3Client(conn);
			}catch(IOException ee){
				ee.printStackTrace();
			}
			do{
				if(time>1000000000){
					transFS = endFS-startFS;
		        	startFS = endFS;
					speed = 1000000*transFS/time;
					startTime = endTime;
		//			System.out.println("transFS:"+transFS);
				}
				boolean fileExist = true;
				do{
					try{
					 sfa = s3c.stat(aimFile);
					 fileExist = true;
					}catch(IOException ee){
						fileExist = false;
					}
				}while(!fileExist) ;              	
				
		       
		
		        localFS = sfa.size; 
		        endFS = localFS;
		        long localFStemp = localFS;
		        for(int j=0;j<i;j++){
		           localFStemp/=10;
		        }
		        progressbar.setValue(Integer.valueOf(String.valueOf(localFStemp)));
		        if(fileSize == 0)
		            progressbar.setValue(100);
		        
		        endTime = System.nanoTime();
		        time = endTime-startTime;
		//        System.out.println("localFS:"+localFS);
		//        System.out.println("fileSize:"+fileSize);
			}while(localFS<fileSize);
			f.dispose();
			conn.close();							
			}
		}
	}
}
