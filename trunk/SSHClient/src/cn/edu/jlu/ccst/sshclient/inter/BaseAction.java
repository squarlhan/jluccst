/**
 * 
 */
package cn.edu.jlu.ccst.sshclient.inter;

import javax.swing.JTextArea;

/**
 * @author Woden
 *
 */
public interface BaseAction {

	/**
	 * 
	 */
	String start();
	/**
	 * 
	 */
	void stop();

	boolean isDone();
	void start(JTextArea jtext);
}
