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

public class GroupUI extends javax.swing.JDialog  {
	private JLabel gLabel1 ;
	private JTextField gTextField1;
	private JButton resetButton , submitButton;
    public GroupUI(){
	    this.setTitle("新建工作组");
		this.setLayout(null);
		this.setSize(350, 250);
		
		gLabel1= new JLabel("Groupname:");
		gLabel1.setBounds(50, 50, 80, 20);
		this.add(gLabel1);
		gTextField1 = new JTextField();
		gTextField1.setBounds(150,50, 150, 30);
		this.add(gTextField1);
		
		resetButton = new JButton("Reset");
		resetButton.setBounds(50,150, 80, 30);
		resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
              //  ResetButtonMousePressed(evt);
            }
        });
		this.add(resetButton);
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(180, 150, 80, 30);
		submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SubmitButtonMousePressed(evt);
            }
        });
		this.add(submitButton);
	}
      /**
       * 处理重置按钮
       */
      private  void ResetButtonMousePressed(java.awt.event.MouseEvent evt){
    	  gTextField1.setText(null);
      }
      
     /**
      * 处理提交按钮
      */
      private void SubmitButtonMousePressed(java.awt.event.MouseEvent evt){
    	  if(gTextField1.getText().equals("")){
    		  JOptionPane.showMessageDialog(null,"请输入工作组的名字");
    		  return;
    	  }
    	  LinuxClient temp = new LinuxClient();
    	  BaseClass curType = new BaseClass();
    	  curType = temp.cur;   
    	  String computerId = curType.getId();
          
    	 
    	  SSHGroup newGroup1 = new SSHGroup();
      /************************************未考虑改group所属的computer的 问题*****/
      	Date SeverTime = new Date();
    	SimpleDateFormat Severtimeformat = new SimpleDateFormat("yyyyMMddHHmmss");
        newGroup1.setCreatdate(SeverTime);//获得创建成功时的时间
        newGroup1.setId(Severtimeformat.format(SeverTime));
        newGroup1.setName(gTextField1.getText());
        newGroup1.setType((byte)1);
        
        
      
        
        SAXReader reader = new SAXReader();
        try{
        String filePath = this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/util/Config.xml";
        System.out.println(filePath);
        Document doc = reader.read(filePath);
        OutputFormat format = OutputFormat.createPrettyPrint();
        Element root = doc.getRootElement();
        XMLWriter writer = null;// 声明写XML的对象
        
        List<Element> celements = root.elements();
        for(Element c : celements) {       	
        	if( c.valueOf("@id").equals(computerId)) {
                SSHComputer cp = new SSHComputer();
                cp.setId(c.valueOf("@id"));        
                cp.setName(c.valueOf("@name"));
                cp.setType((byte) 0);
                cp.setMemo(c.valueOf("@memo"));
                
                SimpleDateFormat timeFormat;
                timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                cp.setCreatdate(timeFormat.parse(c.valueOf("@creatdate")));
                cp.setHost(c.valueOf("@host"));
                cp.setUsername(c.valueOf("@user"));
                cp.setPassword(c.valueOf("@pswd"));
                cp.setGps(new ArrayList());
                newGroup1.setCp(cp);//指示出该组的父节点
                /****************************************************/
        		Element g = c.addElement("group");
        		g.addAttribute("id", newGroup1.getId());
        		g.addAttribute("name", newGroup1.getName());   		
        	    g.addAttribute("creatdate",timeFormat.format(newGroup1.getCreatdate()));     			
                break;
        	}
        }
        writer = new XMLWriter(new FileWriter(filePath), format);
        writer.write(doc);
        writer.close();
        System.out.println("新建组结束");
        this.setVisible(false);
        this.dispose();
      //  temp.updata();    
        }
        catch(Exception e){
        	e.printStackTrace();
        }
    	  /*任务：1）新建组对象；
    	   * 2）写到xml文件中
    	   */
      }
	/**
	 * 
	 * 主函数
	 */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GroupUI().setVisible(true);
            }
        });
    }

}
