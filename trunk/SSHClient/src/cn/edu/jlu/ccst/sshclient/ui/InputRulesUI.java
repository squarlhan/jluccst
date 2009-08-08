package cn.edu.jlu.ccst.sshclient.ui;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import cn.edu.jlu.ccst.sshclient.model.*;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*; 

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class InputRulesUI extends javax.swing.JDialog {
	private List<JLabel> labels;
	private List<JLabel> labels1;
	private List<JLabel> labels2;
	private List<JTextField> textFields;
	private List<JTextField> textFields1;
	private List<JTextField> textFields2;
	private int tasksum;
	private int optssum;
	private String template;
	private JButton resetButton, submitButton;
	private JScrollPane scrollPane;
	private JPanel panel, panel1;
	private List<String> opts;
	private List<String> rules;
	private static ResourceBundle res;

	public InputRulesUI(int tasksum, String template, List<String> rules) {
		res = ResourceBundle.getBundle( "cn.edu.jlu.ccst.sshclient.ui.lang.RES_IRUI");
		this.setTitle(res.getString("TITLE"));
		this.tasksum = tasksum;		
		this.rules = rules;
		this.template = template;
		labels = new ArrayList<JLabel>();
		textFields = new ArrayList<JTextField>();
		labels1 = new ArrayList<JLabel>();
		textFields1 = new ArrayList<JTextField>();
		labels2 = new ArrayList<JLabel>();
		textFields2 = new ArrayList<JTextField>();
		String regEx="\\([1-9]\\d*\\)"; 
		List<String> optnum = new ArrayList();
		Pattern p=Pattern.compile(regEx);
		Matcher m=p.matcher(template.trim()); 
		while ( m.find()) {
			//System.out.println(m.group());
			optnum.add(m.group());
	    }
		this.optssum = optnum.size();
		initComponent();
		for(int i = 0; i<= rules.size()-1; i++){
			String[] rulearray = rules.get(i).split(";");
			//System.out.println(rulearray[0]+";"+rulearray[1]+";"+rulearray[2]);
			textFields.get(i).setText(rulearray[0]);
			textFields1.get(i).setText(rulearray[1]);
			textFields2.get(i).setText(rulearray[2]);
		}
		resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				ResetButtonMousePressed(evt);
			}
		});
		submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {

				try {
					SubmitButtonMousePressed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	// ----------------------------------------------------//
	/**
	 * 初始画图函数
	 */
	private void initComponent() {

		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(this.getClass().getResource(
		"/cn/edu/jlu/ccst/sshclient/ui/resource/ir.png"));
		setIconImage(img);
		if(optssum>10)this.setSize(505, 500);
		else this.setSize(505, optssum*40+110);
		this.setLayout(null);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 500, optssum*40+40);
		scrollPane = new JScrollPane(panel,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0,0,500,this.getHeight()-70);
		scrollPane.setViewportView(panel);
		this.add(scrollPane);
		panel.setPreferredSize(new Dimension(500, optssum*40+40));
	    panel.revalidate();
	    panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0, this.getHeight()-70, 500, 70);
		this.add(panel1);
		
		int x = 30;
		int y = 30;
		
		for(int i=0;i<=optssum-1;i++){
			JLabel newlabel = new JLabel(res.getString("LOWER_BOUND_1")+(i+1)+res.getString("LOWER_BOUND_2")+ "：");
			newlabel.setBounds(x,y+i*40,140, 30);
			labels.add(newlabel);
			panel.add(newlabel);
			JTextField newtf = new JTextField();
			newtf.setBounds(x+140,y+i*40,50, 30);
			newtf.setBorder(BorderFactory.createLineBorder(Color.black));
			textFields.add(newtf);
			panel.add(newtf);
			
			JLabel newlabel1 = new JLabel(res.getString("UPPER_BOUND")+"：");
			newlabel1.setBounds(x+200,y+i*40,50, 30);
			labels1.add(newlabel1);
			panel.add(newlabel1);
			JTextField newtf1 = new JTextField();
			newtf1.setBounds(x+250,y+i*40,50, 30);
			newtf1.setBorder(BorderFactory.createLineBorder(Color.black));
			textFields1.add(newtf1);
			panel.add(newtf1);
			
			JLabel newlabel2 = new JLabel(res.getString("NUMBER")+"：");
			newlabel2.setBounds(x+310,y+i*40,50, 30);
			labels2.add(newlabel2);
			panel.add(newlabel2);
			JTextField newtf2 = new JTextField();
			newtf2.setBounds(x+360,y+i*40,50, 30);
			newtf2.setBorder(BorderFactory.createLineBorder(Color.black));
			textFields2.add(newtf2);
			panel.add(newtf2);
			
			
			
			
			if(i==optssum-1){
				resetButton = new JButton(res.getString("RESET"));
				resetButton.setBounds(120, 0, 80, 30);
				panel1.add(resetButton);

				submitButton = new JButton(res.getString("SUBMIT"));
				submitButton.setBounds(250, 0, 80, 30);
				panel1.add(submitButton);
				
			}
		}

		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;

		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
	}

	/**
	 * Reset按钮的处理函数
	 */
	private void ResetButtonMousePressed(java.awt.event.MouseEvent evt) {
		for(int i = 0; i<=textFields.size()-1; i++){
			textFields.get(i).setText(null);
			textFields1.get(i).setText(null);
			textFields2.get(i).setText(null);
		}
		
	}

	/**
	 * Submit按钮的处理函数
	 * 
	 * @throws IOException
	 */
	private void SubmitButtonMousePressed(java.awt.event.MouseEvent evt)
	throws IOException {	
		List<List<Float>> tempoptscle = new ArrayList();
		opts = new ArrayList();
		rules = new ArrayList();
		for(int a = 0; a <= textFields.size()-1; a++){			
			String t1 = textFields.get(a).getText().trim();
			String t2 = textFields1.get(a).getText().trim();
			String t3 = textFields2.get(a).getText().trim();
			if(t1.isEmpty()){
				JOptionPane.showMessageDialog(null, res.getString("TIP_NO_LOWER_1")+(a+1)+res.getString("TIP_NO_LOWER_2"),null,JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(t2.isEmpty()){
				JOptionPane.showMessageDialog(null, res.getString("TIP_NO_UPPER_1")+(a+1)+res.getString("TIP_NO_UPPER_2"),null,JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(t3.isEmpty()){
				JOptionPane.showMessageDialog(null, res.getString("TIP_NO_NUMBER_1")+(a+1)+res.getString("TIP_NO_NUMBER_2"),null,JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(!Pattern.matches("-{0,1}\\d+\\.{0,1}\\d*", t1)){
				JOptionPane.showMessageDialog(null, res.getString("TIP_LOWER_1")+(a+1)+res.getString("TIP_LOWER_2"),null,JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(!Pattern.matches("-{0,1}\\d+\\.{0,1}\\d*", t2)){
				JOptionPane.showMessageDialog(null, res.getString("TIP_UPPER_1")+(a+1)+res.getString("TIP_UPPER_2"),null,JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(!Pattern.matches("[1-9]\\d*", t3)){			
				JOptionPane.showMessageDialog(null, res.getString("TIP_NUMBER_1")+(a+1)+res.getString("TIP_NUMBER_2"),null,JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(Float.parseFloat(t1)>Float.parseFloat(t2)){
				JOptionPane.showMessageDialog(null, res.getString("TIP_LOWER_UPPER_1")+(a+1)+res.getString("TIP_LOWER_UPPER_2"),null,JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			rules.add(t1+";"+t2+";"+t3);
			float f1 = Float.parseFloat(t1);
			float f2 = Float.parseFloat(t2);
			int i3 = Integer.parseInt(t3);
			
			List<Float> tempopts = new ArrayList();
			if(i3==1){
				//System.out.print((f1+f2)/2+";");
				tempopts.add((f1+f2)/2);
			}else{
				for(int i=0;i<=i3-1;i++){
					//System.out.print(f1+(f2-f1)*i/(i3-1)+";");
					tempopts.add(f1+(f2-f1)*i/(i3-1));
				}
			}
			//System.out.println();
			tempoptscle.add(tempopts);
		}
		int sum = 1;
		for(JTextField tf : textFields2){			
			sum = sum * Integer.parseInt(tf.getText().trim());
		}
		if(sum!=tasksum){			
			JOptionPane.showMessageDialog(null, res.getString("TIP_NO_SAME"),null,JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		for (int i = 0; i < tempoptscle.size(); i++) {
            ArrayList list=new ArrayList();
            ArrayList item = (ArrayList) tempoptscle.get(i);
            for (int j = 0; j < item.size(); j++) {
                Object element =  item.get(j);
                list.add(element);
            }
            //printArrayList(list);
        }
        
        /**
         * 当树的总层次数>1时,注意树的总层次数=root.size()-1.
         */
        if(tempoptscle.size()>0){
            /**
             * 得到第二层次上所有的树节点.
             */
            ArrayList nodeList = (ArrayList) tempoptscle.get(0);
            
            /**
             * stack主要用来记录，一次从树的第二层节点到树的叶子节点的时候，所访问过的所有节点.
             */
            Stack<String> stack= new Stack();
            
            /**
             * 从树的第二层次开始先序遍历整颗树.
             */
            traverse(tempoptscle,0,nodeList,stack);
        }

		MulityTaskUI.rules = rules;
		MulityTaskUI.opts = opts;
		this.setVisible(false);
		this.dispose();
		JOptionPane.showMessageDialog(null, res.getString("TIP_SUCCESS"),null,JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void printArrayList(ArrayList list){
	       StringBuffer sb=new StringBuffer();
	       sb.append("{");
	       for (int i = 0; i < list.size(); i++) {
	           sb.append(list.get(i).toString()+",");
	       }
	       sb.deleteCharAt(sb.length()-1);
	       sb.append("}");
	       System.out.println(sb.toString());
	    }
	
	private void printArrayList(Object[] array){
        StringBuffer sb=new StringBuffer();
        //sb.append("{");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i].toString()+";");
        }
        //sb.deleteCharAt(sb.length()-1);
        //sb.append("}");
        //System.out.println(sb.toString());
        opts.add(sb.toString());
     }
	
	private void saveresults(Object[] array){
        String result=template;
        for (int i = 0; i < array.length; i++) {
        	result = result.replace("("+(i+1)+")", array[i].toString());
        	//result = result + array[i].toString()+";";
        }
        opts.add(result);
     }
	
	 /**
     * 这个方法主要用来实现这种for的嵌套模型:
     * for()
     *    for()
     *       for()
     *         for()
     *           ...
     * @param root  表示整颗树
     * @param treeDepthCounter  记录第几层次,0表示第一层次,1表示第二层次,...
     * @param nodeList  记录在该树的层次上所有节点,就比如第二层的所有节点是{n1,n2}
     * @param stack     主要用来记录，一次从树的第二层节点到树的叶子节点的时候，所访问过的所有节点.
     */
	private void traverse(List<List<Float>> root,int treeDepthCounter,ArrayList nodeList, Stack stack){
        for (int i = 0; i < nodeList.size(); i++) {
            /**
             * 取得一个树节点
             */
            Object element = nodeList.get(i);
            
            /**
             * 访问该层中的一个节点,记录该节点
             */
            stack.push(element);
            
            /**
             * root.size()=整颗树所拥有的层次数-1
             * treeDepthCounter >= root.size()-1 ,表示已经到达树的叶子节点.
             */
            if( treeDepthCounter >= root.size()-1) {
                /**
                 * 如果这次从树的第二层节点到树的叶子节点的时候结束，
                 * 那么打印此次搜索中访问的所有节点,stack保存该次访问过的所有节点
                 */
                Object[] one_traverse=new Object[root.size()];
                
                /**
                 * 取出和打印当前stack中的所有记录,但是不破坏stack中的所有记录.
                 */
                stack.copyInto(one_traverse);
                //printArrayList(one_traverse);
                saveresults(one_traverse);
            }else {
                /**
                 * 开始访问下一层次的树,nextDeepCounter为下一层次的层次数.
                 */
                int nextDeepCounter=treeDepthCounter+1;
                
                /**
                 * 得到下一层次上所有的树节点,比如第3层次上的树节点是{m1,m2,m3}.
                 */
                ArrayList nextNodeList = (ArrayList) root.get(nextDeepCounter);
                /**
                 * 开始访问下一层次的树节点.
                 */
                traverse(root,nextDeepCounter,nextNodeList,stack);    
            }
            
            /**
             * 当该节点访问结束时,从记录中删除该节点.
             */
            stack.pop();
        }
    }
	
	/**
	 * 主函数
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
				List<String> tt = new ArrayList();
				new InputRulesUI(15,"(1);(2);l",tt).setVisible(true);
			}
		});
	}

}


