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
import javax.swing.border.EmptyBorder;
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
import cn.edu.jlu.ccst.sshclient.util.ExcelExport;
import cn.edu.jlu.ccst.sshclient.util.GenerateGraphy2;

public class ResultUI extends JFrame {
	public  JTable table = new JTable();
	private JPopupMenu popMenuC = null;
	private JPopupMenu popMenuD = null;
	static int loci = 0;
	static int locj = 0;
	private static ResourceBundle res;
	public  Object[] colname;
	static List<List<Float>> lsls = new ArrayList();

	@SuppressWarnings("deprecation")
	public void out(String filestr) throws IOException {

		System.out.println("start ResultUI");
		
		res = ResourceBundle.getBundle( "cn.edu.jlu.ccst.sshclient.ui.lang.RES_RUI");
		int maxCol = 0;
		final String outfilename = filestr + ".xls";

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
		colname = new Object[maxCol];
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

		JFrame jf = new JFrame(filestr.substring(filestr.lastIndexOf("\\") + 1));
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(this.getClass().getResource(
				"/cn/edu/jlu/ccst/sshclient/ui/resource/tubiao.png"));
		jf.setIconImage(img);

		JScrollPane scrollPane = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(100, 100));
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(true);
//		table.setCellSelectionEnabled(true);
//		table.setDragEnabled(false);
		JTableHeader header = table.getTableHeader();
		header.setReorderingAllowed(false);

		jf.setSize(new Dimension(400, 400));
		jf.setLocation(50 + 30 * (loci++ % 10), 50 + 30 * (locj++ % 10));
		JPanel jbt2 = new JPanel();
		jf.add(jbt2);

		// Label
		jf.setLayout(new BorderLayout());
		JPanel jpl = new JPanel();
		jpl.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));

		JLabel lblexcel = new JLabel(new ImageIcon(this.getClass().getResource(
				"/cn/edu/jlu/ccst/sshclient/ui/resource/excel03.png")));
		JLabel lbldrawline = new JLabel(
				new ImageIcon(this.getClass().getResource(
						"/cn/edu/jlu/ccst/sshclient/ui/resource/line.png")));
		JLabel lbldrawbar = new JLabel(new ImageIcon(this.getClass()
				.getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/bar.png")));

		LabelClick lineCL = new LabelClick();
		lineCL.drawType = 0;// line(default)
		LabelClick barCL = new LabelClick();
		barCL.drawType = 4;// bar

		lbldrawline.addMouseListener(lineCL);
		lbldrawbar.addMouseListener(barCL);
		lblexcel.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				ExcelExport exp = new ExcelExport();
				// TODO 判断文件是否存在
				
				try {
					// exp.exportTable(table, new File("out.xls"));
					if (exp.exportTable(table, new File(outfilename))) {
						int selectedValue = 0;
						selectedValue = JOptionPane.showConfirmDialog(null,
								res.getString("SAVED_TO")+"\n" + outfilename + "\n"+res.getString("OPEN_OR_NOT"), res.getString("OPEN_FILE"),
								JOptionPane.YES_NO_OPTION);
						if (selectedValue == JOptionPane.YES_OPTION) {
//							System.out.println("打开文件");
							exp.openExcelFile(outfilename);
						}
//						else
//							System.out.println("不打开文件");
					}


				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		lblexcel.setToolTipText(res.getString("EXPORT_EXCEL"));
		lbldrawline.setToolTipText(res.getString("LINE_CHART"));
		lbldrawbar.setToolTipText(res.getString("COLUM_CHART"));

		jpl.add(lblexcel);
		jpl.add(lbldrawline);
		jpl.add(lbldrawbar);
		jf.add(jpl, BorderLayout.NORTH);

		popMenuC = new JPopupMenu();
		DrawMenu dm1 = new DrawMenu();
		dm1.setTable(table);
		JMenuItem addItemC = new JMenuItem(res.getString("LINE_CHART"));
		addItemC.addActionListener(dm1);
		// addItemC.addActionListener(new rightclick());
		JMenuItem addItemC2 = new JMenuItem(res.getString("COLUM_CHART"));
		addItemC2.addActionListener(dm1);
		JMenuItem addItemC3 = new JMenuItem(res.getString("PIE_CHART"));
//		addItemC3.setEnabled(false);
//		addItemC3.addActionListener(dm1);

		popMenuC.add(addItemC);
		popMenuC.add(addItemC2);
//		popMenuC.add(addItemC3);

		popMenuD = new JPopupMenu();
		JMenuItem addItemD = new JMenuItem(res.getString("LINE_CHART"));
		addItemD.addActionListener(dm1);
		JMenuItem addItemD2 = new JMenuItem(res.getString("COLUM_CHART"));
		addItemD2.addActionListener(dm1);

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
		jf.add(scrollPane, BorderLayout.CENTER);
		jf.setVisible(true);
		System.out.println("end");
	}

	public class LabelClick extends MouseAdapter {
		private int drawType = 0;
		public void mouseReleased(MouseEvent e) {
			int[] selection = table.getSelectedColumns();
			if (selection.length <= 0)
				return;
			ResultUI.lsls.clear();
			for (int i = 0; i < selection.length; i++) {
				List<Float> listtemp = new ArrayList<Float>();
				for (int j = 0; j < table.getRowCount(); j++) {
					if (table.getValueAt(j, selection[i]) == null) {
						listtemp.add(new Float(0));
					} else
						listtemp.add(Float.valueOf((String) table.getValueAt(j,
								selection[i])));
				}
				ResultUI.lsls.add(listtemp);
			}
			System.out.println("line");
			try {//Object[] colname = new Object[maxCol];
				int[] selectcol=table.getSelectedColumns();
				GenerateGraphy2.GetObj2(ResultUI.lsls, drawType,selectcol);
				ResultUI.lsls.clear();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}

class DrawMenu implements ActionListener {
	private JTable table = null;

	

	public void actionPerformed(ActionEvent e) {
		// System.out.println("点击右键菜单");
		ResultUI.lsls.clear();
		String str = e.getActionCommand();
		int[] selection = table.getSelectedColumns();
		for (int i = 0; i < selection.length; i++) {
			List<Float> listtemp = new ArrayList<Float>();
			for (int j = 0; j < table.getRowCount(); j++) {
				if (table.getValueAt(j, selection[i]) == null) {
					listtemp.add(new Float(0));
				} else
					listtemp.add(Float.valueOf((String) table.getValueAt(j,
							selection[i])));
			}
			ResultUI.lsls.add(listtemp);
		}

		if (str.startsWith("折线")||str.startsWith("line")) {
			System.out.println("line");
			try {
				GenerateGraphy2.GetObj2(ResultUI.lsls, 0,selection);
				ResultUI.lsls.clear();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (str.startsWith("柱")||str.startsWith("colum")) {
			System.out.println("bar");
			try {
				GenerateGraphy2.GetObj2(ResultUI.lsls, 4,selection);
				ResultUI.lsls.clear();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (str.startsWith("饼")||str.startsWith("pie")) {
			System.out.println("pie");
			try {
				GenerateGraphy2.GetObj2(ResultUI.lsls, 3,selection);
				ResultUI.lsls.clear();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}