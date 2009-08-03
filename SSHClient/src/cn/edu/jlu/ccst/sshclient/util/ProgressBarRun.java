package cn.edu.jlu.ccst.sshclient.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import cn.edu.jlu.ccst.sshclient.ui.ProgressBar;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.SFTPv3Client;
import ch.ethz.ssh2.SFTPv3FileAttributes;
import ch.ethz.ssh2.Session;

public class ProgressBarRun implements Runnable {
	static float speed;
	Connection conn = null;
	String sourceFile = null;
	String aimFile = null;
	String aimDir = null;
	int upOrDown = 0;
	JProgressBar progressbar = null;
	Boolean first = true;
	long fileSize = 0;
	long localFS = 0;
	int i=0;
	JFrame f = null;

	public ProgressBarRun(Connection conn, String sourceFile, String aimFile, String aimDir, int upOrDown,
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

	public void run() {
		// TODO Auto-generated method stub
		//处理下载进度
		if(upOrDown==1){
			//进度条相关信息初始化
			if(first){
				first=false;
				try{

					// TODO Auto-generated catch block
					SFTPv3Client s3c = null;
					SFTPv3FileAttributes sfa = null;
					try{
						s3c = new SFTPv3Client(conn);
						sfa = s3c.stat(sourceFile);
					}catch(IOException ee){

					}
					first = false;
					fileSize = sfa.size;
					int l = String.valueOf(fileSize).length();
					System.out.println("文件size:"+fileSize);
					if(fileSize == 0)
						progressbar.setMaximum(100);
					else{
						if(l>9)
						{
							i=l-9;
							long temp = fileSize;
							for(int j=0;j<1;j++)
								temp/=10;
							progressbar.setMaximum(Integer.valueOf(String.valueOf(temp)));
						}
						else
							progressbar.setMaximum(Integer.valueOf(String.valueOf(fileSize)));
					}
					SCPClient client = new SCPClient(conn);
					System.out.println("sourceFile2:"+sourceFile);
					System.out.println("aimDir2:"+aimDir);
					client.get(sourceFile, aimDir);
					//progressbar.setMaximum(fileSize);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
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
		}else{
			//处理上传进度
			if(upOrDown == 2){
				//进度条相关信息初始化
				if(first){
					first=false;
					try{

						// TODO Auto-generated catch block
						first = false;
						File file= new File(sourceFile);
						FileInputStream fis = null;
						fis = new FileInputStream(file);
						fileSize = fis.available();
						int l = String.valueOf(fileSize).length();
						System.out.println("文件size:"+fileSize);
						if(fileSize == 0)
							progressbar.setMaximum(100);
						else{
							if(l>9)
							{
								i=l-9;
								long temp = fileSize;
								for(int j=0;j<1;j++)
									temp/=10;
								progressbar.setMaximum(Integer.valueOf(String.valueOf(temp)));
							}
							else
								progressbar.setMaximum(Integer.valueOf(String.valueOf(fileSize)));
						}
						SCPClient client = new SCPClient(conn);
						client.put(sourceFile, aimDir);
						//progressbar.setMaximum(fileSize);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
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
							System.out.println("transFS:"+transFS);
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
						System.out.println("localFS:"+localFS);
						System.out.println("fileSize:"+fileSize);
					}while(localFS<fileSize);
					f.dispose();
					conn.close();
				}
			}else{
				System.out.println("未识别传输模式");
			}
		}
	}
	public static float getSpeed() {
		return speed;
	}
	public static void setSpeed(float speed) {
		ProgressBarRun.speed = speed;
	}




}
