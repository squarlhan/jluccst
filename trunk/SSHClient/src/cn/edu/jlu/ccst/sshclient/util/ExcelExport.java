package cn.edu.jlu.ccst.sshclient.util;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.table.*;

/**
 * 将table写入excel文件中
 * 列名放入第一行 
 * 每行用\t分割数，用\n分割行 无法更改列宽等参数，
 * 可以使用 JExcelApi包改进
 * JExcelApi
 * http://www.andykhan.com/
 */
public class ExcelExport {
	public ExcelExport() {
	}

	public Boolean exportTable(JTable table, File file) throws IOException {
		TableModel model = table.getModel();
		FileWriter out;
		try {
			out = new FileWriter(file);
		} catch (Exception e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null,e.getMessage(),null,JOptionPane.ERROR_MESSAGE);
			return false;
		}
		for (int i = 0; i < model.getColumnCount(); i++) {
			out.write(model.getColumnName(i) + "\t");
		}
		out.write("\n");
		for (int i = 0; i < model.getRowCount(); i++) {
			for (int j = 0; j < model.getColumnCount(); j++) {
				if (model.getValueAt(i, j) == null)
					out.write("\t");
				else
					out.write(model.getValueAt(i, j).toString() + "\t");
			}
			out.write("\n");
		}
		out.close();
		System.out.println("write out to: " + file);
		return true;
	}

	public void openExcelFile(String filestr){
		try {
			Runtime.getRuntime().exec("cmd /c start \"\" \"" + filestr + "\"");
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}

	// public static void main(String[] args) {
	// String[][] data = {
	// { "Housewares", "$1275.00" },
	// { "Pets", "$125.00" },
	// { "Electronics", "$2533.00" },
	// { "Mensware", "$497.00" }
	// };
	// String[] headers = { "Department", "Daily Revenue" };
	//
	// JFrame frame = new JFrame("JTable to Excel Hack");
	// DefaultTableModel model = new DefaultTableModel(data,headers);
	// final JTable table = new JTable(model);
	// JScrollPane scroll = new JScrollPane(table);
	//
	// JButton export = new JButton("Export");
	// export.addActionListener(new ActionListener() {
	// public void actionPerformed(ActionEvent evt) {
	// try {
	// ExcelExport exp = new ExcelExport();
	// exp.exportTable(table, new File("results.xls"));
	// } catch (IOException ex) {
	// System.out.println(ex.getMessage());
	// ex.printStackTrace();
	// }
	// }
	// });
	//
	// frame.getContentPane().add("Center",scroll);
	// frame.getContentPane().add("South",export);
	// frame.pack();
	// frame.setVisible(true);
	// }
}
