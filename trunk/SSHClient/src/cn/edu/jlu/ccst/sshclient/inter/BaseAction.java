/**
 * 
 */
package cn.edu.jlu.ccst.sshclient.inter;

import javax.swing.JTextArea;

/**
 * @author Woden
 * �������������Ķ����ӿ�
 */
public interface BaseAction {
	
	/**
	 * ����һ������(��)
	 * @return ��������pid
	 */
	String start();
	/**
	 * ��ֹһ������(��)
	 */
	void stop();
	
	boolean isdone();
	void start(JTextArea jtext);

}
