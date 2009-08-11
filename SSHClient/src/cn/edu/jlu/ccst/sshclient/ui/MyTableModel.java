package cn.edu.jlu.ccst.sshclient.ui;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public MyTableModel(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
	}

}
