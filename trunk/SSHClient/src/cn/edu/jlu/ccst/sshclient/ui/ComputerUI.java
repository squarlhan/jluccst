/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ComputerUI.java
 *
 * Created on 2009-7-1, 14:43:26
 */

package cn.edu.jlu.ccst.sshclient.ui;
import cn.edu.jlu.ccst.sshclient.model.SSHComputer;
import cn.edu.jlu.ccst.sshclient.model.SSHGroup;
import cn.edu.jlu.ccst.sshclient.model.SSHTask;
import cn.edu.jlu.ccst.sshclient.ui.LinuxClient;
import cn.edu.jlu.ccst.sshclient.util.SSHOpCommand;
        
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

import java.net.*;  
import java.awt.event.*;

public class ComputerUI extends javax.swing.JDialog 
{
    public ComputerUI()   
    { 	
        initComponents();
        this.setTitle("新建计算机");
        this.setLocationRelativeTo(null);
        SubmitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	SubmitMousePressed(evt);
            }
        });
        
        jPasswordField1.setEchoChar('*');
       // jPasswordField2.setEchoChar('*');
    }
//--------------------------------------------------------------// 
    public ComputerUI(String name,String user,String pwd,String host,String memo) 
	{
    	this.setLocationRelativeTo(null);
    	this.setTitle("修改计算机");
        initComponents(name,user,pwd,host,memo);  
        SubmitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	SubmitMousePressedE(evt);
            }
        });
        
        jPasswordField1.setEchoChar('*');
        //jPasswordField2.setEchoChar('*');
     
    }
//------------------------------------------------------------//
private void initComponents(String name,String user,String pwd,String host,String memo) {
	initComponents();
	jTextField2.setText(name);
    jTextField6.setText(user);
    jPasswordField1.setText(pwd);
   // jPasswordField2.setText(pwd);
    jTextField8.setText(host);
    jTextArea4.setText(memo);
}
	
//----------------------------------------------------------------------------//
private void initComponents() {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image img = tk.getImage(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/ui/resource/t.png");
	setIconImage(img);
	this.setLayout(null);
	this.setSize(300, 350);
	this.setResizable(false);
	
    jLabel2 = new javax.swing.JLabel("计算机名字:");
    jLabel2.setBounds(20, 20, 70, 30);
    this.add(jLabel2);
    jTextField2 = new javax.swing.JTextField("");
    jTextField2.setBounds(110, 20, 150, 30);
    this.add(jTextField2);

    jLabel6 = new javax.swing.JLabel("用户名:");
    jLabel6.setBounds(20, 60, 70, 30);
    this.add(jLabel6);
    jTextField6 = new javax.swing.JTextField();
    jTextField6.setBounds(110, 60, 150, 30);
    this.add(jTextField6);
  
    jLabel5 = new javax.swing.JLabel("设置密码：");
    jLabel5.setBounds(20, 100, 70, 30);
    this.add(jLabel5);
    jPasswordField1 = new javax.swing.JPasswordField();
    jPasswordField1.setBounds(110, 100, 150, 30);
    jPasswordField1.setEchoChar('*');
    this.add(jPasswordField1);
    /*
    jLabel7 = new javax.swing.JLabel("重输密码：");
    jLabel7.setBounds(20, 140, 70, 30);
    this.add(jLabel7);
    jPasswordField2 = new javax.swing.JPasswordField();
    jPasswordField2.setBounds(110, 140, 150, 30);
    jPasswordField2.setEchoChar('*');
    this.add(jPasswordField2);
    */
    
    jLabel8 = new javax.swing.JLabel("主机IP地址:");
    jLabel8.setBounds(20, 140, 70, 30);
    this.add(jLabel8);
    jTextField8 = new javax.swing.JTextField();
    jTextField8.setBounds(110, 140, 150, 30);
    this.add(jTextField8);
    
    Contest=new JButton("测试连接");
    Contest.setBounds(170, 180, 90, 30);
    this.add(Contest);
    Contest.addMouseListener(
    		new MouseAdapter() 
			{
            public void mousePressed(java.awt.event.MouseEvent evt) 
            {
            	JOptionPane.showMessageDialog(null, "测试连接中....");
                SSHOpCommand test=new SSHOpCommand(jTextField8.getText(), jTextField6.getText(),String.valueOf(jPasswordField1.getPassword()),2);
                test.init();
                test.start();
            }
			}
    		);
    
    jLabel4 = new javax.swing.JLabel("备注:");
    jLabel4.setBounds(20, 220, 70, 30);
    this.add(jLabel4);
    
    jTextArea4 = new javax.swing.JTextArea("");
    jTextArea4.setLineWrap(true);
    jTextArea4.setBorder(BorderFactory.createLineBorder(Color.black));
    memoAreaPane = new JScrollPane(jTextArea4,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    memoAreaPane.setBounds(110, 220, 150, 40);
    this.add(memoAreaPane);
    
    ResetButton = new JButton("重置");
    ResetButton.setBounds(40, 270, 80, 30);
    ResetButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
        	jButton1MousePressed(evt);
        }
    });
    this.add(ResetButton);
    SubmitButton = new JButton("提交");
    SubmitButton.setBounds(160, 270, 80, 30);
    
    this.add(SubmitButton);
    Dimension   screenSize   =   Toolkit.getDefaultToolkit().getScreenSize();   
    Dimension   frameSize   =   this.getSize();   

    if   (frameSize.height   >   screenSize.height)   
            frameSize.height   =   screenSize.height;   
    if   (frameSize.width   >   screenSize.width)   
            frameSize.width   =   screenSize.width;   

    this.setLocation((screenSize.width   -   frameSize.width)   /   2,   (screenSize.height   -   frameSize.height)   /   2);
}
//----------------------------------------------------------------------------//
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
        jTextField2.setText(null);
        jTextArea4.setText(null);
        jTextField6.setText(null);
        jPasswordField1.setText(null);
 //       jPasswordField2.setText(null);
        jTextField8.setText(null);
    }//GEN-LAST:event_jButton1MousePressed

    private void SubmitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitMousePressed
        // TODO add your handling code here:
        if(jTextField2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "请输入电脑Name");
            return;
        }
        if(jTextField6.getText().equals("")){
            JOptionPane.showMessageDialog(null, "请输入用户名");
            return;
        }
        if(jPasswordField1.getPassword().equals("")){
            JOptionPane.showMessageDialog(null, "请输入用户名密码");
            return;
        }
        /*
        if(jPasswordField2.getPassword().equals("")){
             JOptionPane.showMessageDialog(null, "请输入用户名密码");
             return;
        }
        if(! String.valueOf(jPasswordField1.getPassword()).equals(String.valueOf(jPasswordField2.getPassword()))){
             JOptionPane.showMessageDialog(null, "两次输入的密码不一致");
             return;
        }
        */
        if(jTextField8.getText().equals("")){
            JOptionPane.showMessageDialog(null, "请输入用户名主机名");
            return;
        }
        JOptionPane.showMessageDialog(null, "创建用户成功！");
         try{
        /**写入新建的电脑信息**/

        newComputer1.setName(jTextField2.getText());
        newComputer1.setType((byte) 0);
        newComputer1.setMemo(jTextArea4.getText());
        newComputer1.setUsername(jTextField6.getText());
        newComputer1.setPassword(String.valueOf(jPasswordField1.getPassword()));
        newComputer1.setHost(jTextField8.getText());

        }
        catch(Exception e){
            System.out.println(e.toString());

        }
    	Date SeverTime = new Date();
    	SimpleDateFormat Severtimeformat = new SimpleDateFormat("yyyyMMddHHmmss");
        newComputer1.setCreatdate(SeverTime);//获得创建成功时的时间
        newComputer1.setId("C"+Severtimeformat.format(SeverTime));
        this.setVisible(false);
        this.NewComputerToXML(newComputer1);
    }//GEN-LAST:event_SubmitMousePressed
//----------------------------------------------------------//
    private void SubmitMousePressedE(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitMousePressed
        // TODO add your handling code here:
        if(jTextField2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "请输入电脑Name");
            return;
        }
        if(jTextField6.getText().equals("")){
            JOptionPane.showMessageDialog(null, "请输入用户名");
            return;
        }
        if(jPasswordField1.getPassword().equals("")){
            JOptionPane.showMessageDialog(null, "请输入用户名密码");
            return;
        }
        /*
        if(jPasswordField2.getPassword().equals("")){
             JOptionPane.showMessageDialog(null, "请输入用户名密码");
             return;
        }
        if(! String.valueOf(jPasswordField1.getPassword()).equals(String.valueOf(jPasswordField2.getPassword()))){
             JOptionPane.showMessageDialog(null, "两次输入的密码不一致");
             return;
        }
        */
        if(jTextField8.getText().equals("")){
            JOptionPane.showMessageDialog(null, "请输入用户名主机名");
            return;
        }
        JOptionPane.showMessageDialog(null, "修改用户成功！");
        this.setVisible(false);
        this.EditComputerFromXML(LinuxClient.getCur().getId(), jTextField2.getText(), jTextField6.getText(), String.valueOf(jPasswordField1.getPassword()), jTextArea4.getText(), jTextField8.getText());
    }
    //--------------------------------------------//
    /**
     * 将新建的计算机信息存到config.xml文件
     */
    public void NewComputerToXML(SSHComputer newComputer){
        SAXReader reader = new SAXReader();
        try{
        String filePath = this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/util/Config.xml";
        Document doc = reader.read(filePath);
        OutputFormat format = OutputFormat.createPrettyPrint();
        Element root = doc.getRootElement();
        XMLWriter writer = null;// 声明写XML的对象   
        Element newnode = root.addElement("computer");
        newnode.addAttribute("id", newComputer.getId());
        newnode.addAttribute("name",newComputer.getName());
        newnode.addAttribute("host",newComputer.getHost());
        newnode.addAttribute("user",newComputer.getUsername());
        newnode.addAttribute("pswd", newComputer.getPassword());
        newnode.addAttribute("memo",newComputer.getMemo());
        
        SimpleDateFormat timeFormat;
    	timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        newnode.addAttribute("creatdate",timeFormat.format(newComputer.getCreatdate()));
        writer = new XMLWriter(new FileWriter(filePath), format);
        writer.write(doc);
        writer.close();
        
        }
        catch(Exception e ){
            e.printStackTrace();
        }

    }
   //根据id修改某台电脑
    public void EditComputerFromXML(String id,String n,String user,String pwd,String memo,String host)
    {
        SAXReader reader = new SAXReader();
        try{
        String filePath = this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/util/Config.xml";
        Document doc = reader.read(filePath);
        OutputFormat format = OutputFormat.createPrettyPrint();
        Element root = doc.getRootElement();
        XMLWriter writer = null;// 声明写XML的对象
        List   list=doc.selectNodes("/config/computer");
    	Iterator iter = list.iterator();
    	while(iter.hasNext())
    	{
          Element el=(Element)iter.next();
          String it=el.attributeValue("id");
          
          if(it.equals(id))
          {   
        	  el.addAttribute("name", n);
        	  el.addAttribute("user", user);
        	  el.addAttribute("pswd", pwd);
        	  el.addAttribute("host", host);
        	  el.addAttribute("memo", memo);
          }
    	}
        writer = new XMLWriter(new FileWriter(filePath), format);
        writer.write(doc);
        writer.close();
        
        }
        catch(Exception e ){
            e.printStackTrace();
        }
    }
    //-----------------------------------------------------------//
    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComputerUI().setVisible(true);
            }
        });
    }
  
    protected SSHComputer newComputer1 = new SSHComputer();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SubmitButton;
    private javax.swing.JButton ResetButton;
  //  private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
   // private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    //private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordField1;
 //   private javax.swing.JPasswordField jPasswordField2;
 //   private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
   // private javax.swing.JTextField jTextField3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private JScrollPane memoAreaPane; 
    private JButton Contest;
    // End of variables declaration//GEN-END:variables

}
