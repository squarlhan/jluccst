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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.util.*;
import java.text.*;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
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
                //System.out.println(DateFormat.getDateInstance().parse(c.valueOf("@creatdate")));
                cp.setHost(c.valueOf("@host"));
                cp.setUsername(c.valueOf("@user"));
                cp.setPassword(c.valueOf("@pswd"));
                cp.setGps(new ArrayList());

                System.out.println(cp);
                this.cps.add(cp);

                List<Element> gelements = c.elements();
                for (Element g : gelements) {
                    System.out.println("hasgroup");
                    SSHGroup gp = new SSHGroup();
                    gp.setId(g.valueOf("@id"));
                    gp.setName(g.valueOf("@name"));
                    gp.setType((byte) 1);
                    gp.setMemo(g.valueOf("@memo"));
                    gp.setCreatdate(timeFormat.parse(g.valueOf("@creatdate")));

                    gp.setCp(cp);
                    gp.setSts(new ArrayList());
                    cp.getGps().add(gp);

                    System.out.println(gp);
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
                        tk.setFin(new File("@in"));
                        tk.setFout(new File("@out"));
                        List<String> params = new ArrayList();
                        List<Element> pelements = t.elements();
                        for(Element p : pelements){
                            params.add(p.elementTextTrim("param"));
                        }
                        tk.setParams(params);

                        tk.setGp(gp);
                        gp.getSts().add(tk);

                       // System.out.println(tk);
                        this.tks.add(tk);
                    }

                }
            }
        Iterator<SSHComputer> it;
        SSHComputer tmp = new SSHComputer();
        for(it = cps.iterator(); it.hasNext();){
             tmp = (SSHComputer)it.next();
             System.out.println("tmp"+tmp.getId());
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
        jTree1.addMouseListener(
               new MouseAdapter()
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
                        return;
                    	
                    }
                    String s=null;
                    BaseClass b=(BaseClass)treenode.getUserObject();
                    switch(b.getType())
                    {
                        case 0:
                        {
                            SSHComputer c=(SSHComputer)treenode.getUserObject();
                            s="computer--id:"+c.getId()+";name:"+c.getName()+";memo:"+c.getMemo()
                             +";host:"+c.getHost()+";user:"+c.getUsername()
                             +";pswd:"+c.getPassword()
                             +";date:"+b.getCreatdate();
                            jTextArea1.setText(s);
                            break;
                        }
                        case 1:
                        {
                            SSHGroup g=(SSHGroup)treenode.getUserObject();
                            s="group--id:"+g.getId()+";name:"+g.getName()+";memo:"+g.getMemo()+";date:"+b.getCreatdate();
                            jTextArea1.setText(s);
                            break;
                        }
                        case 2:
                        {
                            SSHTask t=(SSHTask)treenode.getUserObject();
                            s="task--id:"+t.getId()+";name:"+t.getName()+";memo:"+t.getMemo()+";cmd:"+t.getCmd()+";date:"+b.getCreatdate();
                            jTextArea1.setText(s);
                            break;
                        }
                        default:
                            break;
                    }
                    System.out.println(s);
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
                               System.out.println(treenode.toString());
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
                        {
                              //ex.printStackTrace();
                        }
                  }

        }
                );
        jScrollPane1.setViewportView(jTree1);

        popMenuC = new JPopupMenu();
        addItemC = new JMenuItem("添加任务组");
        addItemC.addActionListener(null);
        delItemC = new JMenuItem("删除此电脑");
        delItemC.addActionListener(new ActionListener()
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
           );
        editItemC = new JMenuItem("编辑此电脑");
        editItemC.addActionListener(null);
        popMenuC.add(addItemC);
        popMenuC.add(delItemC);
        popMenuC.add(editItemC);
        
        
        popMenuG = new JPopupMenu();
        addItemG = new JMenuItem("添加一新任务");
        addItemG.addActionListener(null);
        delItemG = new JMenuItem("删除此任务组");
        delItemG.addActionListener(new ActionListener()
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
           );
        editItemG = new JMenuItem("编辑此任务组");
        editItemG.addActionListener(null);
        popMenuG.add(addItemG);
        popMenuG.add(delItemG);
        popMenuG.add(editItemG);
        
        popMenuT = new JPopupMenu();       
        delItemT = new JMenuItem("删除此任务");
        delItemT.addActionListener(new ActionListener()
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
           );
        editItemT = new JMenuItem("编辑此任务");
        editItemT.addActionListener(null);
        popMenuT.add(delItemT);
        popMenuT.add(editItemT);
        
        popMenuCA = new JPopupMenu();       
        delItemCA = new JMenuItem("删除所有电脑");
        delItemCA.addActionListener(new ActionListener()
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
           );
        addItemCA = new JMenuItem("添加一新电脑");
        addItemCA.addActionListener(
        new ActionListener()
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
        );
        popMenuCA.add(delItemCA);
        popMenuCA.add(addItemCA);
}
private void action ( ActionEvent e ) throws DocumentException
{
  String str = e.getActionCommand();
  SAXReader reader = new SAXReader();
  Document doc = reader.read(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/util/Config.xml");
  if(str.startsWith("删除"))
  {
      if(cur==null)
      {
    	  List   list=doc.selectNodes("/config/computer");
          Iterator iter = list.iterator();             
          while(iter.hasNext())
          {
              Element el=(Element)iter.next();
              el.getParent().remove(el); 
          } 
      }
      else
      {
    	  switch(cur.getType())
    	  {
          	case 0:
          	{
          		List   list=doc.selectNodes("/config/computer");
          		//System.out.println(list.size());
          		Iterator iter = list.iterator();
          		while(iter.hasNext())
          		{
                  Element el=(Element)iter.next();
                  String it=el.attributeValue("id");
                  if(it.equals(cur.getId()))
                  {
                      el.getParent().remove(el);
                  }
          		}
          		break;
          	}
          	case 1:
          	{
          		List   list=doc.selectNodes("/config/computer");
          		Iterator iter = list.iterator();
          		while(iter.hasNext())
          		{
                  Element el=(Element)iter.next();
                  Iterator it=el.elementIterator("group");
                  while(it.hasNext())
                  {
                      Element et=(Element)it.next();
                      String s=et.attributeValue("id");
                      if(s.equals(cur.getId()))
                      {
                          el.remove(et);
                      }
                  }
          		}
          		break;
          	}
          	case 2:
          	{
          		List   list=doc.selectNodes("/config/computer");
          		Iterator iter = list.iterator();
          		while(iter.hasNext())
          		{
                  Element el=(Element)iter.next();
                  Iterator it=el.elementIterator("group");
                  while(it.hasNext())
                  {
                      Element elta=(Element)it.next();
                      Iterator itta=elta.elementIterator("task");
                      while(itta.hasNext())
                      {
                      Element et=(Element)itta.next();
                      String s=et.attributeValue("id");
                      if(s.equals(cur.getId()))
                      {
                          elta.remove(et);
                      }
                      }

                  }
          		}
          			break;
          	}
          	default:
          		break;
    	  }
      }
     try{
          
	   	   XMLWriter writer = new XMLWriter(new FileWriter(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/util/Config.xml"));
	   	   System.out.println(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/util/Config.xml");
	   	   writer.write(doc);
	   	   writer.close();
     }catch(Exception ex)
     {
         ex.printStackTrace();
     }
     updata(); 
     System.out.println("updata");
  }
  if(str.startsWith("添加"))
  {
	  if(cur==null)
	  {
		  ComputerUI newComputerUi = new ComputerUI();
		  newComputerUi.setModal(true);
		  newComputerUi.setVisible(true);
		  //this.dispose();
		  updata();
		  return;
	  }
	  switch(cur.getType())
	  {
	  case 0:
	  {
		  break;
	  }
	  case 1:
	  {
		  break;
	  }
	  case 2:
	  {
		  break;
	  }
	  default:
		  break;
	  }
  }
  if(str.startsWith("编辑"))
  {
	  
  }
 
}
/**
 * 将新建的计算机信息存到config.xml文件
 */
public void NewComputerToXML(SSHComputer newComputer){
    SAXReader reader = new SAXReader();
    try{
    String filePath = this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/util/Config.xml";
    System.out.println(filePath);
    Document doc = reader.read(filePath);
    OutputFormat format = OutputFormat.createPrettyPrint();
    Element root = doc.getRootElement();
    XMLWriter writer = null;// 声明写XML的对象
   // List<Element> celements = root.elements();
    //for (Element c : celements);
    
    Element newnode = root.addElement("computer");
    newnode.addAttribute("id", newComputer.getId());
    newnode.addAttribute("name",newComputer.getName());
    System.out.println(newComputer.getHost());
    newnode.addAttribute("host",newComputer.getHost());
    newnode.addAttribute("user",newComputer.getUsername());
    newnode.addAttribute("pswd", newComputer.getPassword());
    
    SimpleDateFormat timeFormat;
	timeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    newnode.addAttribute("creatdate",timeFormat.format(newComputer.getCreatdate()));
    String filePath2 = "c:\\temp.xml";
    System.out.println("操作成功！");
    System.out.println(filePath);
    writer = new XMLWriter(new FileWriter(filePath), format);
    writer.write(doc);
    writer.close();
    
    }
    catch(Exception e ){
        e.printStackTrace();
    }



}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        ComputerUI newComputerUi = new ComputerUI();
        newComputerUi.setModal(true);
        newComputerUi.setVisible(true);
        //this.dispose();
        updata();
        System.out.println("computer");
        //this.setVisible(false);
    }//GEN-LAST:event_jMenuItem4MousePressed

/**
 * 工具栏中新建组的处理函数
 */
    private void jMenuMousePressNewGroup(java.awt.event.MouseEvent evt){//GEN-FIRST:event_jMenuItem5MousePressed
       	if( this.cur == null || this.cur.getType() != 0) {
       	 JOptionPane.showMessageDialog(null, "请选中要新建组的计算机");
       	 return;
    	}
       	GroupUI newGroup = new GroupUI();
       	newGroup.setModal(true);
       	newGroup.setVisible(true);
       	updata();
       	System.out.println("选中类型"+cur.getType());
       	
    }
    
/**
 * 工具栏中新建任务的处理函数    
 */
    private void jMenuMousePressNewTask(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jMenuItem6MousePressed
    	if( this.cur == null || this.cur.getType() != 1 ) {
    		 JOptionPane.showMessageDialog(null, "请选中要新建任务的组");
           	 return;
    	}
    	TaskUI newTask = new TaskUI();
    	newTask.setModal(true);
    	newTask.setVisible(true);
    	updata();
    	System.out.println("新建任务over");
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LinuxClient().setVisible(true);
            }
        });
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
}
