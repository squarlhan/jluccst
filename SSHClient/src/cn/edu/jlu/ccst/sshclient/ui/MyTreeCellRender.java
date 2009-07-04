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
		ImageIcon image0 = new ImageIcon(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/ui/resource/cs.png");
		ImageIcon image1 = new ImageIcon(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/ui/resource/c.png");
		ImageIcon image2 = new ImageIcon(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/ui/resource/g.png");
		ImageIcon image3 = new ImageIcon(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/ui/resource/t.png");
		ImageIcon image4 = new ImageIcon(this.getClass().getResource("/").getPath() + "cn/edu/jlu/ccst/sshclient/ui/resource/default.png");
		if (node.getLevel() == 0) {
			System.out.println("level0"+image0.getIconHeight());
			this.setIcon(image0);
			this.setSize(30,30);
		} else if (node.getLevel() == 1) {
			System.out.println("level1");
			this.setIcon(image1);
			this.setSize(30,30);
		} else if (node.getLevel() == 2) {
			System.out.println("level2");
			this.setIcon(image2);
			this.setSize(30,30);
		} else if (node.getLevel() == 3) {
			System.out.println("level3");
			this.setIcon(image3);
			this.setSize(30,30);
		} else {
			this.setIcon(image4);
			this.setSize(30,30);
		}
		return this;
	}

}