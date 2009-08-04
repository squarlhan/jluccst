package cn.edu.jlu.ccst.sshclient.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import cn.edu.jlu.ccst.sshclient.ui.LinuxClient;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SFTPv3Client;
import ch.ethz.ssh2.SFTPv3FileAttributes;

public class ProgressBarSpeeder implements Runnable {
	private float speed;
	Connection conn = null;
	String sourceFile = null;
	String aimFile = null;
	String aimDir = null;
	int upOrDown = 0;
	JProgressBar progressbar = null;
	public Boolean first = true;
	long fileSize = 0;
	long localFS = 0;
	int i=0;
	JFrame f = null;
	public File file = null;
	SFTPv3FileAttributes sfa = null;
	ProgressBarRun pbr = null;
	public float getSpeed() {
		return speed;
	}
	

	public ProgressBarSpeeder(Connection conn, String sourceFile,
			String aimFile, String aimDir, int upOrDown,
			JProgressBar progressbar, long fileSize, JFrame f,
			ProgressBarRun pbr) {
		super();
		this.conn = conn;
		this.sourceFile = sourceFile;
		this.aimFile = aimFile;
		this.aimDir = aimDir;
		this.upOrDown = upOrDown;
		this.progressbar = progressbar;
		this.fileSize = fileSize;
		this.f = f;
		this.pbr = pbr;
		f.setVisible(true);
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(upOrDown==1){
			setDownloadProgressBar();
		}else{
			//处理上传进度
			if(upOrDown == 2){
				setUploadProgressBar();
			}else{
				System.out.println("未识别传输模式");
			}
		}
	}
	
	private void setDownloadProgressBar() {
		//进度条实时信息
		System.out.println("Dtr2_"+aimFile+"_start");
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

			file= new File(aimFile);
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
				//	                    System.out.println("localFStemp:"+localFStemp);
				progressbar.setValue(Integer.valueOf(String.valueOf(localFStemp)));
				if(fileSize == 0)
					progressbar.setValue(100);
			}catch(IOException e1){   
				System.out.println("IO出错！");
			}

			endTime = System.nanoTime();
			time = endTime-startTime;
		}while(localFS<fileSize);
		f.setVisible(false);
		f.dispose();
		while(!pbr.isDone())
			;
		conn.close();
		//LinuxClient.key = true;
		System.out.println("Dtr2_"+aimFile+"_end");
	}
	private void setUploadProgressBar() {
		System.out.println("Utr2_"+aimFile+"_start");
		//进度条实时信息
		long startFS = 0;
		long endFS = 0;
		long transFS = 0;
		long time = 0;
		long startTime = System.nanoTime();
		long endTime = startTime;
		SFTPv3Client s3c = null;
		try{
			s3c = new SFTPv3Client(conn);
		}catch(IOException ee){
			System.out.println(sourceFile+":ConnUEx");
		return;
		}
		do{
			
			if(time>1000000000){
				transFS = endFS-startFS;
				startFS = endFS;
				speed = 1000000*transFS/time;
				startTime = endTime;		
	//		System.out.println("transFS:"+transFS);
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
	//		System.out.println("localFS:"+localFS);
	//		System.out.println("fileSize:"+fileSize);
		}while(localFS<fileSize);
		s3c.close();
		f.dispose();
		while(!pbr.isDone())
			;
		conn.close();
		System.out.println("Utr2_"+aimFile+"_end");
	}

}
