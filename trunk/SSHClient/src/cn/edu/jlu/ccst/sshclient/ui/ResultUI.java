package cn.edu.jlu.ccst.sshclient.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.jfree.data.category.DefaultCategoryDataset;

import cn.edu.jlu.ccst.sshclient.model.BaseClass;
import cn.edu.jlu.ccst.sshclient.model.SSHComputer;
import cn.edu.jlu.ccst.sshclient.model.SSHGroup;
import cn.edu.jlu.ccst.sshclient.model.SSHTask;
import cn.edu.jlu.ccst.sshclient.ui.LinuxClient;
import cn.edu.jlu.ccst.sshclient.ui.LinuxClient.TARight;
import cn.edu.jlu.ccst.sshclient.util.GenerateGraphy2;

public class ResultUI extends JFrame {
	public JTable table = new JTable();
	private JPopupMenu popMenuC = null;
	private JPopupMenu popMenuD = null;
	static int loci=0;
	static int locj=0;

	static List<List<Float>> lsls = new ArrayList();

	public void out(String filestr) throws IOException {

		System.out.println("start");
		int maxCol = 0;
		File file1 = new File(filestr);
		// "E:\\SSH\\Code\\SSHClient\\src\\T20090717201551.txt");
		InputStreamReader insr1 = new InputStreamReader(new FileInputStream(
				file1), "gb2312");
		BufferedReader br1 = new BufferedReader(insr1);
		String line1;
		while ((line1 = br1.readLine()) != null) {
			line1 = line1.trim();
			if (line1.trim().length() >= 1) {
				String[] strSplit = line1.split("(\\s*,\\s*|\\s+)");
				if (maxCol < strSplit.length)
					maxCol = strSplit.length;
			}
		}
		br1.close();
		insr1.close();
		Object[] colname = new Object[maxCol];
		for (int i = 0; i < maxCol; i++) {
			colname[i] = "col_" + (i + 1);
		}

		File file = new File(filestr);
		// "E:\\SSH\\Code\\SSHClient\\src\\T20090717201551.txt");
		InputStreamReader insr = new InputStreamReader(
				new FileInputStream(file), "gb2312");
		BufferedReader br = new BufferedReader(insr);
		String line;
		Object data[][] = new Object[][] {};
		DefaultTableModel defaultModel = new DefaultTableModel(data, colname);
		// new Object[] { "col 1", "col 2", "col 3", "col 4" });
		table = new JTable(defaultModel);
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.trim().length() >= 1) {
				String[] strSplit = line.split("(\\s*,\\s*|\\s+)");
				defaultModel.addRow(strSplit);
			}
		}
		br.close();
		insr.close();

		// http://www.chinadforce.com/viewthread.php?tid=1158641
		// String filestr= filestr.substring(str.lastIndexOf("\\")+1);
		JFrame jf = new JFrame(filestr.substring(filestr.lastIndexOf("\\") + 1));
		// jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(100, 100));
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(true);
		jf.setSize(new Dimension(400, 400));
		jf.setLocation(50+30*(loci++%10), 50+30*(locj++%10));
		

		popMenuC = new JPopupMenu();
		JMenuItem addItemC = new JMenuItem("作线图");
		// addItemC.addActionListener(new rightclick());
		addItemC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("点击右键菜单");
				ResultUI.lsls.clear();
				String str = e.getActionCommand();
				int[] selection = table.getSelectedColumns();
				for (int i = 0; i < selection.length; i++) {
					List<Float> listtemp = new ArrayList<Float>();
					for (int j = 0; j < table.getRowCount(); j++) {
						listtemp.add(Float.valueOf((String) table.getValueAt(j,
								selection[i])));
					}
					ResultUI.lsls.add(listtemp);
				}

				if (str.startsWith("作线图")) {
					System.out.println("line");
					try {
						GenerateGraphy2.GetObj2(ResultUI.lsls, 0);
						ResultUI.lsls.clear();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (str.startsWith("作柱图")) {
					System.out.println("bar");
					try {
						GenerateGraphy2.GetObj2(ResultUI.lsls, 4);
						ResultUI.lsls.clear();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if (str.startsWith("作饼图")) {
					System.out.println("pie");
					try {
						GenerateGraphy2.GetObj2(ResultUI.lsls, 3);
						ResultUI.lsls.clear();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		JMenuItem addItemC2 = new JMenuItem("作柱图");
		// addItemC2.addActionListener(new rightclick());
		addItemC2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("点击右键菜单");
				ResultUI.lsls.clear();
				String str = e.getActionCommand();
				int[] selection = table.getSelectedColumns();
				for (int i = 0; i < selection.length; i++) {
					List<Float> listtemp = new ArrayList<Float>();
					for (int j = 0; j < table.getRowCount(); j++) {
						listtemp.add(Float.valueOf((String) table.getValueAt(j,
								selection[i])));
					}
					ResultUI.lsls.add(listtemp);
				}

				if (str.startsWith("作线图")) {
					System.out.println("line");
					try {
						GenerateGraphy2.GetObj2(ResultUI.lsls, 0);
						ResultUI.lsls.clear();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (str.startsWith("作柱图")) {
					System.out.println("bar");
					try {
						GenerateGraphy2.GetObj2(ResultUI.lsls, 4);
						ResultUI.lsls.clear();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if (str.startsWith("作饼图")) {
					System.out.println("pie");
					try {
						GenerateGraphy2.GetObj2(ResultUI.lsls, 3);
						ResultUI.lsls.clear();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		JMenuItem addItemC3 = new JMenuItem("作饼图");
		// addItemC3.addActionListener(new rightclick());
		addItemC3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("点击右键菜单");
				ResultUI.lsls.clear();
				String str = e.getActionCommand();
				int[] selection = table.getSelectedColumns();
				for (int i = 0; i < selection.length; i++) {
					List<Float> listtemp = new ArrayList<Float>();
					for (int j = 0; j < table.getRowCount(); j++) {
						listtemp.add(Float.valueOf((String) table.getValueAt(j,
								selection[i])));
					}
					ResultUI.lsls.add(listtemp);
				}

				if (str.startsWith("作线图")) {
					System.out.println("line");
					try {
						GenerateGraphy2.GetObj2(ResultUI.lsls, 0);
						ResultUI.lsls.clear();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (str.startsWith("作柱图")) {
					System.out.println("bar");
					try {
						GenerateGraphy2.GetObj2(ResultUI.lsls, 4);
						ResultUI.lsls.clear();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if (str.startsWith("作饼图")) {
					System.out.println("pie");
					try {
						GenerateGraphy2.GetObj2(ResultUI.lsls, 3);
						ResultUI.lsls.clear();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		popMenuC.add(addItemC);
		popMenuC.add(addItemC2);
		popMenuC.add(addItemC3);

		popMenuD = new JPopupMenu();
		JMenuItem addItemD = new JMenuItem("作线图");
		// addItemD.addActionListener(new rightclick());
		addItemD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("点击右键菜单");
				ResultUI.lsls.clear();
				String str = e.getActionCommand();
				int[] selection = table.getSelectedColumns();
				for (int i = 0; i < selection.length; i++) {
					List<Float> listtemp = new ArrayList<Float>();
					for (int j = 0; j < table.getRowCount(); j++) {
						listtemp.add(Float.valueOf((String) table.getValueAt(j,
								selection[i])));
					}
					ResultUI.lsls.add(listtemp);
				}

				if (str.startsWith("作线图")) {
					System.out.println("line");
					try {
						GenerateGraphy2.GetObj2(ResultUI.lsls, 0);
						ResultUI.lsls.clear();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (str.startsWith("作柱图")) {
					System.out.println("bar");
					try {
						GenerateGraphy2.GetObj2(ResultUI.lsls, 4);
						ResultUI.lsls.clear();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if (str.startsWith("作饼图")) {
					System.out.println("pie");
					try {
						GenerateGraphy2.GetObj2(ResultUI.lsls, 3);
						ResultUI.lsls.clear();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		JMenuItem addItemD2 = new JMenuItem("作柱图");
		// addItemD2.addActionListener(new rightclick());
		addItemD2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("点击右键菜单");
				ResultUI.lsls.clear();
				String str = e.getActionCommand();
				int[] selection = table.getSelectedColumns();
				for (int i = 0; i < selection.length; i++) {
					List<Float> listtemp = new ArrayList<Float>();
					for (int j = 0; j < table.getRowCount(); j++) {
						listtemp.add(Float.valueOf((String) table.getValueAt(j,
								selection[i])));
					}
					ResultUI.lsls.add(listtemp);
				}

				if (str.startsWith("作线图")) {
					System.out.println("line");
					try {
						GenerateGraphy2.GetObj2(ResultUI.lsls, 0);
						ResultUI.lsls.clear();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (str.startsWith("作柱图")) {
					System.out.println("bar");
					try {
						GenerateGraphy2.GetObj2(ResultUI.lsls, 4);
						ResultUI.lsls.clear();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if (str.startsWith("作饼图")) {
					System.out.println("pie");
					try {
						GenerateGraphy2.GetObj2(ResultUI.lsls, 3);
						ResultUI.lsls.clear();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		popMenuD.add(addItemD);
		popMenuD.add(addItemD2);

		table.addMouseListener(new MouseAdapter() {
			// class thismouse extends MouseAdapter {

			@Override
			public void mouseClicked(MouseEvent e) {
				// System.out.println("左键");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					// 是否右键单击
					if (e.getClickCount() == 1
							&& SwingUtilities.isRightMouseButton(e)) {
						// System.out.println("右键");
						JTable jt2 = (JTable) e.getSource();

						int selectedlines = table.getSelectedColumns().length;
						if (selectedlines != 0) {
							if (selectedlines == 1)
								popMenuC.show(jt2, e.getX(), e.getY());
							else
								popMenuD.show(jt2, e.getX(), e.getY());
						}
					}
				} catch (Exception ex) {
				}
			}
		});
		jf.add(scrollPane);
		jf.setVisible(true);
		System.out.println("end");
	}
}