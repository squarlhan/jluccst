package cn.edu.jlu.ccst.sshclient.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

import cn.edu.jlu.ccst.sshclient.model.SSHTask;

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
		ImageIcon image0 = new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/cs.png"));
		ImageIcon image1 = new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/c.png"));
		ImageIcon image2 = new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/g.png"));
		ImageIcon image3 = new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/s.png"));
		ImageIcon image5 = new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/m.png"));
		ImageIcon image6 = new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/e.png"));
		ImageIcon image4 = new ImageIcon(this.getClass().getResource("/cn/edu/jlu/ccst/sshclient/ui/resource/d.png"));
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
			SSHTask tk=(SSHTask)node.getUserObject();
			if(tk.getStartTime()==null)
			{
				this.setIcon(image3);
			}
			else
			{
				if(tk.getRunSucc()==false)
				{
					this.setIcon(image6);
				}
				else
				{
					this.setIcon(image5);
				}
			}
			this.setSize(30,30);
		} else {
			this.setIcon(image4);
			this.setSize(30,30);
		}
		return this;
	}

}