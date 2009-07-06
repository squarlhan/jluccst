package cn.edu.jlu.ccst.sshclient.inter;

import java.util.List;

import cn.edu.jlu.ccst.sshclient.model.BaseClass;

/***
 * ����ӿ�����һЩ��Ĳ���
 * @author Woden
 *
 */

public interface BaseOperation {
	
	/**
	 * �������ļ��д���һ��ʵ�����ã����ڽ�������ʾ����
	 * @return true��ʶ��ȷ����
	 */
	boolean creat();
	/**
	 * �������ļ���ɾ��һ��ʵ�����ã����ڽ�����ɾ��
	 * @return true��ʶ��ȷɾ��
	 */
	boolean remove();
	/**
	 * �������ļ����޸�һ��ʵ�����ã����ڽ�������ʾ����
	 * @return true��ʶ��ȷ���
	 */
	boolean update();
	/**
	 * �������ļ��и��idȷ��һ��ʵ������
	 * @param bc �����ʵ���id
	 * @return �ҵ���ʵ�壬���򷵻� null
	 */
	BaseClass load(String id);
	/**
	 * �������ļ��и��name����ʵ������
	 * @param bc �����ʵ���name
	 * @return �ҵ���ʵ�����У����򷵻ؿ����У�����null
	 */
	List<BaseClass> find(String name);
}
