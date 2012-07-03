package cn.edu.jlu.ccst.constraint;

import cn.edu.jlu.ccst.model.Arc;

public class Queue {
	public Arc head = null;
	public Arc tail = null;
	public int size = 0;
	
	public String queueName;
	public long reviseTime = 0;
	

	public Queue(String name) {
		queueName = name;
	}

	public int getSize() {
		return size;
	}

	public void clear() {
		while(size>0){
			head.setPosition(0);
			head=head.next;
			size--;
		}
	}

	public void add(Arc arc) {
		if (arc.getPosition() == 0 && !arc.var.assigned) {
			if (size == 0) {
				head = arc;
				tail = head;
			} else {
				tail.next = arc;
				tail=arc;
			}
			size++;
			arc.setPosition(1);
		}
	}

	public Arc selectArc() {
		Arc temp = head;
		head = head.next;
		temp.setPosition(0);
		size--;
		return temp;
	}

}
