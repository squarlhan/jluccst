package cn.edu.jlu.ccst.sshclient.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.SFTPv3Client;
import ch.ethz.ssh2.SFTPv3FileAttributes;

public class ProgressBarRun implements Runnable {

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
	private boolean done = false;
	private boolean normalInterupt = false;
	private boolean normalclosed = false;
	
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	
	public boolean isNormalInterupt() {
		return normalInterupt;
	}

	public void setNormalInterupt(boolean normalInterupt) {
		this.normalInterupt = normalInterupt;
	}

	
	public boolean isNormalclosed() {
		return normalclosed;
	}

	public void setNormalclosed(boolean normalclosed) {
		this.normalclosed = normalclosed;
	}

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
		
		if(upOrDown == 1){
			SFTPv3Client s3c = null;
			SFTPv3FileAttributes sfa = null;
			try{
				s3c = new SFTPv3Client(conn);
				sfa = s3c.stat(sourceFile);
			}catch(IOException ee){
				ee.printStackTrace();
			}
			fileSize = sfa.size;
			s3c.close();
		}else{
			if(upOrDown == 2){
				file= new File(sourceFile);
				FileInputStream fis = null;
				try{
					fis = new FileInputStream(file);
					fileSize = fis.available();
				}catch(IOException ee){
					ee.printStackTrace();
				}
			}
		}
	}

	public void run() {
		//处理下载进度
		if(upOrDown==1){
			downloadFile();
		}else{

			if(upOrDown == 2){
				uploadFile();
			}else{
				System.out.println("未识别传输模式");
			}
		}
	}

	private void uploadFile() {
			System.out.println("Utr1_"+aimFile+"_start");
			int l = String.valueOf(fileSize).length();
			System.out.println("文件size:"+fileSize);
			if(fileSize == 0)
				progressbar.setMaximum(100);
			else{
				if(l>9){
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
			System.out.println("sourceFileR:"+sourceFile);
			System.out.println("aimDirR:"+aimDir);
			System.out.println("aimFileR:"+aimFile);
			System.out.println("upLoad:"+sourceFile+"Suc");
			
			String fileName = aimFile.substring(aimDir.length()+1);
			System.out.println("fileName:"+fileName);
			try {
				client.put(sourceFile, aimDir);
			} catch (IOException e) {
				if(this.isNormalInterupt())
					System.out.println("isNormalInterupt");
				if(this.isNormalclosed())
					System.out.println("isNormalclosed");
				else
					e.printStackTrace();
			}
			
			this.setDone(true);
			System.out.println("Utr1_"+aimFile+"_end");
	}


	private void downloadFile() {
			System.out.println("Dtr1_"+aimFile+"_start");		
			int l = String.valueOf(fileSize).length();
			System.out.println("文件Download size:"+fileSize);
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
			try {
				client.get(sourceFile, aimDir);
			} catch (IOException e) {
				if(this.isNormalInterupt())
					System.out.println("isNormalInterupt");
				if(this.isNormalclosed())
					System.out.println("isNormalclosed");
				else
					e.printStackTrace();
			}

			System.out.println("downLoad:"+sourceFile+"Suc");
			this.setDone(true);
			System.out.println("Dtr1_"+aimFile+"_end");
	}	

}
