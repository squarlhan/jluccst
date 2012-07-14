package cn.edu.jlu.ccst.constraint;

import cn.edu.jlu.ccst.model.Arc;

public class Queue {

	public Arc[] array;
	public int currentSize = 0;
	public static boolean randomInsert = false;

	public Queue(int size) {
		array = new Arc[size];
	}

	public void add(Arc arc) {
		if (arc.var.currentValue == -1) {
			insert(arc);
		}
	}

	public Arc selectArc() {
		return removeAt(0);
	}

	public void filterDown(int start, int finish) {
		int i = start;
		int j = 2 * i + 1;
		Arc temp = array[i];
		while (j <= finish) {
			if (j < finish && compare(array[j + 1], array[j])) {
				j++;
			}
			if (compare(temp, array[j])) {
				break;
			} else {
				array[i] = array[j];
				array[i].setPosition(i);
				i = j;
				j = 2 * j + 1;
			}
		}
		array[i] = temp;
		array[i].setPosition(i);

	}

	public void filterUp(int start) {
		int j = start;
		int i = (j - 1) / 2;
		Arc temp = array[j];
		while (j > 0) {
			if (compare(array[i], temp)) {
				break;
			} else {
				array[j] = array[i];
				array[j].setPosition(j);
				j = i;
				i = (i - 1) / 2;
			}
		}
		array[j] = temp;
		array[j].setPosition(j);
	}

	public void insert(Arc e) {// 在里面就直接上浮，不在里面就加到最后然后上浮
		if (e.getPosition() >-1) {
			filterUp(e.getPosition());
		} else {
			array[currentSize] = e;
			filterUp(currentSize);
			currentSize++;
		}
	}

	public Arc removeAt(int location) {// 返回第一个。将第一个和最后一个互换，然后将新的第一个沉下
		Arc temp = array[location];
		array[location] = array[currentSize - 1];
		currentSize--;
		filterDown(location, currentSize - 1);
		temp.setPosition(-1);
		return temp;
	}

	public boolean compare(Arc arc1, Arc arc2) {
		return arc1.con.getUnassignCount() < arc2.con.getUnassignCount();
	}


	public int getSize() {
		return currentSize;
	}
	public void clear() {
		for (int i = 0; i < currentSize; i++) {
			array[i].setPosition(-1);
		}
		currentSize = 0;	
	}

}

//package cn.edu.jlu.ccst.constraint;
//
//import java.util.LinkedList;
//
//import cn.edu.jlu.ccst.model.Arc;
//
//public class Queue {
//	// FIFO
//
//	LinkedList<Arc> list = new LinkedList<Arc>();
//
//	public Queue(int size) {
//	}
//
//	public int getSize() {
//		return list.size();
//	}
//
//	public void clear() {
//		list.clear();
//	}
//
//	public void add(Arc arc) {
//		if (arc.getPosition() == -1 && !arc.var.assigned) {
//			list.add(arc);
//			arc.setPosition(1);
//		}
//	}
//
//	public Arc selectArc() {
//		Arc temp = list.removeFirst();
//		temp.setPosition(-1);
//		return temp;
//	}
//
//}
