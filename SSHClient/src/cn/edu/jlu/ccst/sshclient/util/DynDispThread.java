package cn.edu.jlu.ccst.sshclient.util;

//import java.util.*;
import java.lang.Thread;
import java.util.ResourceBundle;

import javax.swing.*;

public class DynDispThread extends Thread{

	public DynDispThread(JTextArea jTextArea1, String Id, long tt) {
		jtxt1 = jTextArea1;
		id = Id;
		startime = tt;
	}
	public void run() {
		ResourceBundle res;		
		res = ResourceBundle.getBundle( "cn.edu.jlu.ccst.sshclient.ui.lang.RES_OTHER");
		while((System.currentTimeMillis() - startime) < 1e10) {
			for(int i = 0; i < 4; ++i) {
				jtxt1.setText(id+"\n"+res.getString("RUNNING")+disp[i]);
				try{
					sleep((int)(500));
				} catch (InterruptedException e){
				}
			}
		}
	}



	private JTextArea jtxt1;
	private String id;
	private long startime;
	private final String disp[] ={"",".","..","..."};
}
