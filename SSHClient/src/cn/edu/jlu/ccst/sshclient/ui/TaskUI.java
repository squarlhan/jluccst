package cn.edu.jlu.ccst.sshclient.ui;

import cn.edu.jlu.ccst.sshclient.model.*;

import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class TaskUI extends javax.swing.JDialog {	
	private JLabel tLabel1, tLabel2,tLabel3;
	private JTextField tTextField1,tTextField2,tTextField3;
	private JButton resetButton , submitButton;
	
	TaskUI() {
		this.setTitle("新建任务");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/ui/resource/t.png");
		setIconImage(img);
		this.setLayout(null);
		this.setSize(350, 250);
		
		tLabel1= new JLabel("TaskName:");
		tLabel1.setBounds(50, 30, 80, 20);
		this.add(tLabel1);
		tTextField1 = new JTextField();
		tTextField1.setBounds(150,30, 150, 30);
		this.add(tTextField1);
		
		tLabel2 = new JLabel("TaskMemo:");
		tLabel2.setBounds(50, 70, 80, 20);
		this.add(tLabel2);
		tTextField2 = new JTextField();
		tTextField2.setBounds(150,70, 150, 30);
		this.add(tTextField2);
		
		tLabel3 = new JLabel("TaskCmd:");
		tLabel3.setBounds(50, 110, 80, 20);
		this.add(tLabel3);
		tTextField3 = new JTextField();
		tTextField3.setBounds(150, 110, 150, 30);
		this.add(tTextField3);
		
		resetButton = new JButton("Reset");
		resetButton.setBounds(50,160, 80, 30);
		resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResetButtonMousePressed(evt);
            }
        });
		this.add(resetButton);
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(180, 160, 80, 30);
		submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SubmitButtonMousePressed(evt);
            }
        });
		this.add(submitButton);
	}
	
	/**
	 * Reset按钮的处理函数
	 */
	 private void ResetButtonMousePressed(java.awt.event.MouseEvent evt) {
		 tTextField1.setText(null);
		 tTextField2.setText(null);
		 tTextField3.setText(null);
	 }
	 
	 /**
	  * Submit按钮的处理函数
	  */
	 private void SubmitButtonMousePressed(java.awt.event.MouseEvent evt) {
		 if(tTextField1.getText().equals("")) {
			 JOptionPane.showMessageDialog(null,"请输入新建任务的名字");
			 return;
		 }
		 if(tTextField2.getText().equals("")) {
			 JOptionPane.showMessageDialog(null,"请输入新建任务的Memo");
			 return;
		 }
		 
   	     LinuxClient tempClient = new LinuxClient();
   	     SSHGroup selectGroup = new SSHGroup();
	     BaseClass curType = new BaseClass();
	     curType = tempClient.cur;   
	     String selectGroupId = curType.getId();
	     String selectComputerId;//选中任务所在组的计算机ID
	  
	     SSHTask newTask1 = new SSHTask();
	     newTask1.setName(tTextField1.getText());
	     newTask1.setMemo(tTextField2.getText());
	     newTask1.setCmd(tTextField3.getText());
         Date SeverTime = new Date();
         SimpleDateFormat Severtimeformat = new SimpleDateFormat("yyyyMMddHHmmss");
         newTask1.setCreatdate(SeverTime);//获得创建成功时的时间
         newTask1.setId("T"+Severtimeformat.format(SeverTime));
         newTask1.setType((byte) 2);
      
         //找到选中的组
         Iterator <SSHGroup> it;
         for(it = tempClient.gps.iterator(); it.hasNext();){
    	    selectGroup = (SSHGroup) it.next();
    	    if(selectGroup.getId().equals(selectGroupId)) {
    		  break;
    	   }
         }
         newTask1.setGp(selectGroup);
         selectComputerId = selectGroup.getCp().getId() ;//找到计算机的ID
      
         
         //将信息保存到config.xml中
         SAXReader reader = new SAXReader();
         try{
         String filePath = this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/util/Config.xml";
         System.out.println(filePath);
         Document doc = reader.read(filePath);
         OutputFormat format = OutputFormat.createPrettyPrint();
         Element root = doc.getRootElement();
         XMLWriter writer = null;// 声明写XML的对象
         
         List<Element> celements = root.elements();
         boolean flag = false;
         for(Element c : celements) {
        	 if( flag == true) break;
         	if( c.valueOf("@id").equals(selectComputerId)) {
         		  List<Element> gelements = c.elements();
                  for (Element g : gelements) {
                	  if(g.valueOf("@id").equals(selectGroupId)) {
                		  Element t = g.addElement("task");
                		  t.addAttribute("id", newTask1.getId());
                		  t.addAttribute("name", newTask1.getName());
                          SimpleDateFormat timeFormat;
                          timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                          t.addAttribute("creatdate",timeFormat.format(newTask1.getCreatdate()));
                          t.addAttribute("cmd", newTask1.getCmd()); 
                          flag = true;
                          break;
                	  }
                  }         		
         	}
         }
         writer = new XMLWriter(new FileWriter(filePath), format);
         writer.write(doc);
         writer.close();
         System.out.println("新建组结束");
         this.setVisible(false);
         this.dispose();         
         }catch(Exception e) {
        	 e.printStackTrace();
         }
         
      
      
      
      //newTask1.setGp(gp);
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
