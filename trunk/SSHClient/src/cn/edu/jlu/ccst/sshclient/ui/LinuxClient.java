/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LinuxClient.java
 *
 * Created on 2009-6-30, 14:09:55
 */

package cn.edu.jlu.ccst.sshclient.ui;

import cn.edu.jlu.ccst.sshclient.model.BaseClass;
import cn.edu.jlu.ccst.sshclient.model.SSHComputer;
import cn.edu.jlu.ccst.sshclient.model.SSHGroup;
import cn.edu.jlu.ccst.sshclient.model.SSHTask;
import cn.edu.jlu.ccst.sshclient.ui.ComputerUI;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.*;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTree.DynamicUtilTreeNode;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.DocumentHelper;
import org.dom4j.io.*;
/**
 *
 * @author Woden
 */
public class LinuxClient extends javax.swing.JFrame {

    /** Creates new form LinuxClient */
    public LinuxClient() {
    	this.setLocationRelativeTo(null);
        initComponents();
        updata();
    }
    
//updata the jtree
 void  updata() {
        
        this.cps = new ArrayList();
        this.gps = new ArrayList();
        this.tks = new ArrayList();

        //下面根据xml文件生成所需要的类
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/util/Config.xml");
            Element root = doc.getRootElement();
            List<Element> celements = root.elements();
            for (Element c : celements) {
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
                this.cps.add(cp);
                List<Element> gelements = c.elements();
                for (Element g : gelements) {
                    SSHGroup gp = new SSHGroup();
                    gp.setId(g.valueOf("@id"));
                    gp.setName(g.valueOf("@name"));
                    gp.setType((byte) 1);
                    gp.setMemo(g.valueOf("@memo"));
                    gp.setCreatdate(timeFormat.parse(g.valueOf("@creatdate")));
                    gp.setCp(cp);
                    gp.setSts(new ArrayList());
                    cp.getGps().add(gp);
                    this.gps.add(gp);                
                    List<Element> telements = g.elements();
                    for (Element t : telements) {
                        SSHTask tk = new SSHTask();
                        tk.setId(t.valueOf("@id"));
                        tk.setName(t.valueOf("@name"));
                        tk.setType((byte) 2);
                        tk.setMemo(t.valueOf("@memo"));
                        tk.setCreatdate(timeFormat.parse(t.valueOf("@creatdate")));
                        tk.setCmd(t.valueOf("@cmd"));
                        tk.setFin(t.valueOf("@in"));
                        tk.setFout(t.valueOf("@out"));
                        List<String> params = new ArrayList();
                        List<Element> pelements = t.elements();
                        for(Element p : pelements){
                            params.add(p.elementTextTrim("param"));
                        }
                        tk.setParams(params);
                        tk.setGp(gp);
                        gp.getSts().add(tk);
                        this.tks.add(tk);
                    }

                }
            }
        Iterator<SSHComputer> it;
        SSHComputer tmp = new SSHComputer();
        for(it = cps.iterator(); it.hasNext();){
             tmp = (SSHComputer)it.next();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        GenerateTree();
    }
/*构建生成的Computer树*/
public void GenerateTree() {
       //下面开始构建树
       DefaultMutableTreeNode root = new DefaultMutableTreeNode("Computers", true);
        for(SSHComputer c : cps){
            DefaultMutableTreeNode tcp = new DefaultMutableTreeNode(c,true);
            root.add(tcp);
            if(c.getGps() != null){
            for(SSHGroup g: c.getGps()){
                DefaultMutableTreeNode tgp = new DefaultMutableTreeNode(g,true);
                tcp.add(tgp);
                if(g.getSts() != null){
                for(SSHTask t : g.getSts()){
                     DefaultMutableTreeNode ttk = new DefaultMutableTreeNode(t,true);
                     tgp.add(ttk);
                }
                }
            }
            }
        }
        jTree1 = new JTree(root);       
        jScrollPane1.setViewportView(jTree1);       
        jTree1.setCellRenderer(new MyTreeCellRender());
        jTree1.addMouseListener(new thismouse());
        jScrollPane1.setViewportView(jTree1);
        popMenuC = new JPopupMenu();
        addItemC = new JMenuItem("添加任务组");
        addItemC.addActionListener(new rightclick());
        delItemC = new JMenuItem("删除此电脑");
        delItemC.addActionListener(new rightclick());
        editItemC = new JMenuItem("编辑此电脑");
        editItemC.addActionListener(new rightclick());
        popMenuC.add(addItemC);
        popMenuC.add(delItemC);
        popMenuC.add(editItemC);        
        popMenuG = new JPopupMenu();
        addItemG = new JMenuItem("添加一新任务");
        addItemG.addActionListener(new rightclick());
        delItemG = new JMenuItem("删除此任务组");
        delItemG.addActionListener(new rightclick());
        editItemG = new JMenuItem("编辑此任务组");
        editItemG.addActionListener(new rightclick());
        popMenuG.add(addItemG);
        popMenuG.add(delItemG);
        popMenuG.add(editItemG);     
        popMenuT = new JPopupMenu();       
        delItemT = new JMenuItem("删除此任务");
        delItemT.addActionListener(new rightclick());
        editItemT = new JMenuItem("编辑此任务");
        editItemT.addActionListener(new rightclick());
        popMenuT.add(delItemT);
        popMenuT.add(editItemT);
        
        popMenuCA = new JPopupMenu();       
        delItemCA = new JMenuItem("删除所有电脑");
        delItemCA.addActionListener(new rightclick());
        addItemCA = new JMenuItem("添加一新电脑");
        addItemCA.addActionListener(new rightclick());
        popMenuCA.add(delItemCA);
        popMenuCA.add(addItemCA);
}
private void action ( ActionEvent e ) throws DocumentException
{
  String str = e.getActionCommand(); 
  if(str.startsWith("删除"))
  {
      if(cur==null)
      {
    	  SAXReader reader = new SAXReader();
    	  Document doc = reader.read(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/util/Config.xml");
    	  List   list=doc.selectNodes("/config/computer");
          Iterator iter = list.iterator();             
          while(iter.hasNext())
          {
              Element el=(Element)iter.next();
              el.getParent().remove(el); 
          } 
          try{
              
   	   	   XMLWriter writer = new XMLWriter(new FileWriter(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/util/Config.xml"));	   	 
   	   	   writer.write(doc);
   	   	   writer.close();
          }catch(Exception ex)
          {
            ex.printStackTrace();
          }
      }
      else
      {
    	  switch(cur.getType())
    	  {
          	case 0:
          	{
          		SSHComputer Com=new SSHComputer();
          		Com.remove();
          		break;
          	}
          	case 1:
          	{
          		SSHGroup Gro=new SSHGroup();
          		Gro.remove();
          		break;
          	}
          	case 2:
          	{
          		SSHTask tas=new SSHTask();
          		tas.remove();
          		break;
          	}
          	default:
          		break;
    	  }
      }    
     updata(); 
  }
  if(str.startsWith("添加"))
  {
	  if(cur==null)
	  {
		  SSHComputer Com=new SSHComputer();
		  Com.creat();
		  Com=null;
	  }
	  else
	  {
		  switch(cur.getType())
		  {
		  case 0:
		  {
			  SSHGroup Gro=new SSHGroup();
			  Gro.creat();
			  Gro=null;
	       	  break;
		  }
		  case 1:
		  {
			  SSHTask Tas=new SSHTask();
			  Tas.creat();
			  break;
		  }
		  default:
			  break;
		  }
	  }
	  updata();
  }
  if(str.startsWith("编辑"))
  {
	  switch(cur.getType())
	  {
	  case 0:
	  {
		  SSHComputer Com=new SSHComputer();
		  Com.update();
		  break;
	  }
	  case 1:
	  {
		  SSHGroup Gro=new SSHGroup();
		  Gro.update();
		  break;
	  }
	  case 2:
	  {
		  SSHTask tas=new SSHTask();
		  tas.update();
		  break;
	  }
	  default:
		  break;
	  }
	  updata();
  }
 
}
//-------------------------------------------------------------//
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LinuxClient");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/ui/resource/faver.png");
		setIconImage(img);

        jSplitPane1.setName("jSplitPane1"); // NOI18N
        jScrollPane1.setName("jScrollPane1"); // NOI18N
        jTree1.setName("jTree1"); // NOI18N
        jScrollPane1.setViewportView(jTree1);
        jSplitPane1.setLeftComponent(jScrollPane1);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.setName("jSplitPane2"); // NOI18N
        jScrollPane2.setName("jScrollPane2"); // NOI18N
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jTextArea1.setName("jTextArea1"); // NOI18N
        jScrollPane2.setViewportView(jTextArea1);
        jSplitPane2.setLeftComponent(jScrollPane2);
        jTabbedPane1.setName("jTabbedPane1"); // NOI18N
        jScrollPane3.setName("jScrollPane3"); // NOI18N
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setEnabled(false);
        jTextArea2.setName("jTextArea2"); // NOI18N
        jScrollPane3.setViewportView(jTextArea2);
        jTabbedPane1.addTab("tab1", jScrollPane3);
        jScrollPane4.setName("jScrollPane4"); // NOI18N
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setName("jTextArea3"); // NOI18N
        jScrollPane4.setViewportView(jTextArea3);
        jTabbedPane1.addTab("tab2", jScrollPane4);
        jSplitPane2.setRightComponent(jTabbedPane1);
        jSplitPane1.setRightComponent(jSplitPane2);
        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu1.setText("File");
        jMenu1.setName("jMenu1"); // NOI18N

        jMenu4.setText("New");
        jMenu4.setName("jMenu4"); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });

      //没有选中内容时新建选项全设为暗色
        if(cur == null) {
            jMenuItem4.setEnabled(true);
            jMenuItem5.setEnabled(false);
            jMenuItem6.setEnabled(false);
        }
        jMenuItem4.setText("Computer");
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MousePressed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setText("Group");
        jMenuItem5.setName("jMenuItem5"); // NOI18N
        //"新建工作组"的监听函数
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mousePressed(java.awt.event.MouseEvent evt) {
        		jMenuMousePressNewGroup(evt);
        	}
        });
        jMenu4.add(jMenuItem5);

        jMenuItem6.setText("Task");
        jMenuItem6.setName("jMenuItem6"); // NOI18N
        //“新建任务的监听函数”
        jMenuItem6.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mousePressed(java.awt.event.MouseEvent evt) {
        		jMenuMousePressNewTask(evt);
        	}
        });
        jMenu4.add(jMenuItem6);

        jMenu1.add(jMenu4);

        jMenuItem2.setText("Save");
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Quit");
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
              System.exit(0);
            }
        });
        jMenu1.add(jMenuItem3);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jMenu1.add(jSeparator1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Task");
        jMenu2.setName("jMenu2"); // NOI18N

        jMenuItem8.setText("Add");
        jMenuItem8.setName("jMenuItem8"); // NOI18N
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Update");
        jMenuItem9.setName("jMenuItem9"); // NOI18N
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("Remove");
        jMenuItem10.setName("jMenuItem10"); // NOI18N
        jMenu2.add(jMenuItem10);

        jSeparator2.setName("jSeparator2"); // NOI18N
        jMenu2.add(jSeparator2);

        jMenuItem11.setText("Start");
        jMenuItem11.setName("jMenuItem11"); // NOI18N
        jMenu2.add(jMenuItem11);

        jMenuItem12.setText("Group Start");
        jMenuItem12.setName("jMenuItem12"); // NOI18N
        jMenu2.add(jMenuItem12);

        jMenuItem13.setText("All Start");
        jMenuItem13.setName("jMenuItem13"); // NOI18N
        jMenu2.add(jMenuItem13);

        jMenuItem14.setText("Start Now");
        jMenuItem14.setName("jMenuItem14"); // NOI18N
        jMenu2.add(jMenuItem14);

        jSeparator3.setName("jSeparator3"); // NOI18N
        jMenu2.add(jSeparator3);

        jMenuItem15.setText("Stop Now");
        jMenuItem15.setName("jMenuItem15"); // NOI18N
        jMenu2.add(jMenuItem15);

        jMenuItem16.setText("All Stop");
        jMenuItem16.setName("jMenuItem16"); // NOI18N
        jMenu2.add(jMenuItem16);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");
        jMenu3.setName("jMenu3"); // NOI18N

        jMenuItem1.setText("Index");
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenu3.add(jMenuItem1);

        jMenuItem7.setText("About");
        jMenuItem7.setName("jMenuItem7"); // NOI18N
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
       ComputerUI newComputerUi = new ComputerUI();
       newComputerUi.setVisible(true);
       this.setVisible(false);
    }
    /**
     * 工具栏中新建计算机的处理函数
     * @param evt
     */
        private void jMenuItem4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MousePressed
            // TODO add your handling code here:
        	if(jMenuItem4.isEnabled() == true) {
            ComputerUI newComputerUi = new ComputerUI();
            newComputerUi.setModal(true);
            newComputerUi.setVisible(true);
            updata();
        	}
        }//GEN-LAST:event_jMenuItem4MousePressed

    /**
     * 工具栏中新建组的处理函数
     */
        private void jMenuMousePressNewGroup(java.awt.event.MouseEvent evt){//GEN-FIRST:event_jMenuItem5MousePressed
        	if(jMenuItem5.isEnabled() == true) {
           	GroupUI newGroup = new GroupUI();
           	newGroup.setModal(true);
           	newGroup.setVisible(true);
           	updata();
        	}
           	
        }
        
    /**
     * 工具栏中新建任务的处理函数    
     */
        private void jMenuMousePressNewTask(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jMenuItem6MousePressed
        if(jMenuItem6.isEnabled() == true) {
        	TaskUI newTask = new TaskUI();
        	newTask.setModal(true);
        	newTask.setVisible(true);
        	updata();
        	}
        }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LinuxClient().setVisible(true);
            }
        });
    }
    static public BaseClass getCur()
    {
    	return cur;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
    private JPopupMenu popMenuC;
    private JMenuItem addItemC;
    private JMenuItem delItemC;
    private JMenuItem editItemC;
    
    private JPopupMenu popMenuG;
    private JMenuItem addItemG;
    private JMenuItem delItemG;
    private JMenuItem editItemG;
    
    private JPopupMenu popMenuT;
    private JMenuItem delItemT;
    private JMenuItem editItemT;
    
    private JPopupMenu popMenuCA;
    private JMenuItem delItemCA;
    private JMenuItem addItemCA;
    protected static BaseClass cur;

    public static List<SSHComputer> cps;
    public static List<SSHGroup> gps;
    public static List<SSHTask> tks;
//鼠标点击处理类
    private class thismouse extends  MouseAdapter
    {
    	
            @Override
            public   void   mouseClicked(MouseEvent   e){
                try{
                    JTree tree = (JTree)e.getSource();
                    int rowLocation = tree.getRowForLocation(e.getX(), e.getY());
                    TreePath treepath = tree.getPathForRow(rowLocation);
                    DefaultMutableTreeNode treenode = (DefaultMutableTreeNode) treepath.getLastPathComponent();
                    if(treenode.toString().equals("Computers"))
                    {
                    	jTextArea1.setText("");
                    	jMenuItem4.setEnabled(true);
                    	jMenuItem5.setEnabled(false);
                    	jMenuItem6.setEnabled(false);
                        return;                    	
                    }
                    String s=null;
                    BaseClass b=(BaseClass)treenode.getUserObject();
                    cur=(BaseClass)treenode.getUserObject();
                    if(cur.getType() == 0) { //获得选中的类型，给工具栏中相应的选项变色
                    	 jMenuItem5.setEnabled(true);
                    	 jMenuItem4.setEnabled(false);
                    	 jMenuItem6.setEnabled(false);
                    }
                    else if(cur.getType() == 1) {
                    	 jMenuItem6.setEnabled(true);
                    	 jMenuItem4.setEnabled(false);
                    	 jMenuItem5.setEnabled(false);
                    }
                    else if(cur.getType() == 2){
                    	jMenuItem4.setEnabled(false);
                    	jMenuItem5.setEnabled(false);
                    	jMenuItem6.setEnabled(false);
                    }
                    else {
                      	jMenuItem4.setEnabled(true);
                    	jMenuItem5.setEnabled(false);
                    	jMenuItem6.setEnabled(false);
                    }
                    switch(b.getType())
                    {
                        case 0:
                        {
                            SSHComputer c=(SSHComputer)treenode.getUserObject();
                            s="计算机名字:"+c.getName()
                             +"\n服务器ip地址:"+c.getHost()
                             +"\n帐户名:"+c.getUsername()
                             +"\n密码:"+c.getPassword()
                             +"\n登录时间:"+b.getCreatdate()
                             +"\n备注:"+c.getMemo();
                            Font x = new Font("Serif",0,15);
                            jTextArea1.setFont(x);
                            jTextArea1.setText(s);
                            break;
                        }
                        case 1:
                        {
                            SSHGroup g=(SSHGroup)treenode.getUserObject();
                            s="任务名:"+g.getName()
                            +"\n创建时间:"+b.getCreatdate()
                            +"\n备注:"+g.getMemo();
                            Font x = new Font("Serif",0,15);
                            jTextArea1.setFont(x);
                            jTextArea1.setText(s);
                            break;
                        }
                        case 2:
                        {
                            SSHTask t=(SSHTask)treenode.getUserObject();
                            s="任务名:"+t.getName()                           
                            +"\n命令内容:"+t.getCmd()
                            +"\n创建时间:"+b.getCreatdate()
                            +"\n输入文件路径:"+t.getFin()
                            +"\n输入目录路径:"+t.getFout()
                            +"\n备注:"+t.getMemo();
                            Font x = new Font("Serif",0,15);
                            jTextArea1.setFont(x);
                            jTextArea1.setText(s);
                            break;
                        }
                        default:
                            break;
                    }
                    }catch(NullPointerException ne){}
             }
            @Override
            public void mouseReleased(MouseEvent e)
              {
                 try
                 {
                    //是否右键单击
                   if (e.getClickCount() == 1 && SwingUtilities.isRightMouseButton(e))
                      {
                           JTree tree = (JTree)e.getSource();
                           int rowLocation = tree.getRowForLocation(e.getX(), e.getY());
                           TreePath treepath = tree.getPathForRow(rowLocation);
                           DefaultMutableTreeNode treenode = (DefaultMutableTreeNode) treepath.getLastPathComponent();
                           if(treenode.toString().equals("Computers"))
                            {
                        	   TreePath path = jTree1.getPathForLocation(e.getX(), e.getY());
                               if (path == null)
                                   return;
                               jTree1.setSelectionPath(path);
                               popMenuCA.show(jTree1, e.getX(), e.getY());
                               cur=null;                              
                               return;
                            }
                          cur=(BaseClass)treenode.getUserObject();
                          TreePath path = jTree1.getPathForLocation(e.getX(), e.getY());
                          if (path == null)
                              return;
                          jTree1.setSelectionPath(path);
                          switch(cur.getType())
                          {
                          case 0:
                          {
                        	  popMenuC.show(jTree1, e.getX(), e.getY());
                        	  break;
                          }
                          case 1:
                          {
                        	  popMenuG.show(jTree1, e.getX(), e.getY());
                        	  break;
                          }
                          case 2:
                          {
                        	  popMenuT.show(jTree1, e.getX(), e.getY());
                        	  break;
                          }
                          default:
                        	  break;                         
                          }                        
                        }
                 }
                        catch (Exception ex)  
                        {}
                  }
    }
    //------------------------------------------------------------//
    class rightclick implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
       {
            try
            {
                action(e);
            } catch (DocumentException ex)
            {}
       }
    }
    //---------------------------------------------------------------//
}

