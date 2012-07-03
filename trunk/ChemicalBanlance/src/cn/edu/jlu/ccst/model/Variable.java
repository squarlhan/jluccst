package cn.edu.jlu.ccst.model;

import java.util.ArrayList;


public class Variable {
	public ArrayList<Arc> tempOutArc = new ArrayList<Arc>();
	public Arc[] outArcs;
	private int position = -1;
	
	public int domId = 0;
	public Constraint[] relatedCons;
	public int id;
	public int[] domain;
	public ArrayList<Constraint> tempRels;
	public int currentValue = -1;
	public int initDomainSize;
	public int currentDomainSize;
	public boolean assigned = false;

	public int[] next;
	public int[] prev;
	public int[] absent;
	public int[] prevAbsent;

	public int head;
	public int tail;
	public int tailAbsent;

	public int getCurrentSize() {
		return currentDomainSize;
	}
	
	public int getSolutionValue(){
		if(currentValue==-1){
			System.out.println("´íÎó½â");
			return -1;
		}
		return domain[currentValue];
	}

	public void initDomain() {
		initDomainSize = domain.length;
		currentDomainSize = domain.length;
		head = 0;
		tail = initDomainSize - 1;
		tailAbsent = -1;
		next = new int[initDomainSize];
		prev = new int[initDomainSize];
		absent = new int[initDomainSize];
		prevAbsent = new int[initDomainSize];
		for (int i = 0; i < initDomainSize; i++) {
			next[i] = i + 1;
			prev[i] = i - 1;
			absent[i] = -1;
			prevAbsent[i] = -1;
		}
		next[initDomainSize - 1] = -1;
	}

	public void removeValue(int a, int p) {
		currentDomainSize--;
		absent[a] = p;
		prevAbsent[a] = tailAbsent;
		tailAbsent = a;
		if (prev[a] == -1) {
			head = next[a];
		} else {
			next[prev[a]] = next[a];
		}
		if (next[a] == -1) {
			tail = prev[a];
		} else {
			prev[next[a]] = prev[a];
		}
	}

	public void reduceTo(int a, int p) {
		int b = head;
		while (b != -1) {
			if (b != a) {
				removeValue(b, p);
			}
			b = next[b];
		}
	}

	public void addValue(int a) {
		currentDomainSize++;
		absent[a] = -1;
		tailAbsent = prevAbsent[a];
		if (prev[a] == -1) {
			head = a;
		} else {
			next[prev[a]] = a;
		}
		if (next[a] == -1) {
			tail = a;
		} else {
			prev[next[a]] = a;
		}
	}

	public void restoreUpto(int p) {
		int b = tailAbsent;
		while (b != -1) {
			if (absent[b] >= p) {
				addValue(b);
			}
			b = prevAbsent[b];
		}
	}

	public Variable(int idnum, int[] dom) {
		this.id = idnum;
		tempRels = new ArrayList<Constraint>();
		domain = dom;
	}

	public Variable() {

	}


	public int getAValue() {
		return head;
	}

	public boolean isDomainEmpty() {
		return head == -1;
	}


	public void copyOutArc() {
		outArcs = new Arc[tempOutArc.size()];
		for (int i = 0; i < outArcs.length; i++) {
			outArcs[i] = tempOutArc.get(i);
		}
	}


	public int findLocation(int value) {
		int beginIndex = 0;
		int endIndex = domain.length - 1;
		while (beginIndex <= endIndex) {
			int mid = (endIndex + beginIndex) / 2;
			int temp = compare(value, domain[mid]);
			if (temp == 0) {
				return mid;
			}
			if (temp < 0) {
				endIndex = mid - 1;
			} else {
				beginIndex = mid + 1;
			}
		}
		return -1;
	}

	private int compare(int v1, int v2) {
		if (v1 < v2)
			return -1;
		if (v1 > v2)
			return 1;
		return 0;
	}

	public void generateRelatedCons() {
		int relatedCount = tempRels.size();
		relatedCons = new Constraint[relatedCount];
		for (int i = 0; i < relatedCount; i++) {
			relatedCons[i] = tempRels.get(i);
		}
		tempRels = null;
	}


	public void increaseAssignCount(){
		for(int i=0;i<relatedCons.length;i++){
			relatedCons[i].currentAssignCount++;
		}
	}
	public void decreaseAssignCount(){
		for(int i=0;i<relatedCons.length;i++){
			relatedCons[i].currentAssignCount--;
		}
	}
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
