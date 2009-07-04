package cn.edu.jlu.ccst.sshclient.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class MyTreeCellRender extends DefaultTreeCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyTreeCellRender() {
		super();
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
		super.getTreeCellRendererComponent(tree, value, selected, expanded,
				leaf, row, hasFocus);
		ImageIcon image0 = new ImageIcon(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/ui/resource/cs.ico");
		ImageIcon image1 = new ImageIcon(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/ui/resource/c.ico");
		ImageIcon image2 = new ImageIcon(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/ui/resource/g.ico");
		ImageIcon image3 = new ImageIcon(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/ui/resource/t.ico");
		ImageIcon image4 = new ImageIcon(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/ui/resource/default.ico");
		if (node.getLevel() == 0) {
			this.setIcon(image0);
			this.setSize(30,30);
		} else if (node.getLevel() == 1) {
			this.setIcon(image1);
			this.setSize(30,30);
		} else if (node.getLevel() == 2) {
			this.setIcon(image2);
			this.setSize(30,30);
		} else if (node.getLevel() == 3) {
			this.setIcon(image3);
			this.setSize(30,30);
		} else {
			this.setIcon(image4);
			this.setSize(30,30);
		}
		return this;
	}

}