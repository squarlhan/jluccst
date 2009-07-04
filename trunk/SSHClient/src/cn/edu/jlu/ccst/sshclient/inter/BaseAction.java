/**
 * 
 */
package cn.edu.jlu.ccst.sshclient.inter;

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

}
