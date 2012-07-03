package cn.edu.jlu.ccst.constraint;

import cn.edu.jlu.ccst.model.Csp;
import cn.edu.jlu.ccst.model.Variable;

public class Stack {
	public Csp csp;
	public int[][] currentDMS;
	public int varNum;
	public int cstNum;
	public int[][] recordLastTuple;
	public int[][] recordMemberIndex;
	public int totalLevel;
	public int popTime=0;
	public int pushTime=0;
	public void init() {

	}

	public void push(int level) {
		pushTime++;
		int[] tempDMS = currentDMS[level];
		for (int i = 0; i < varNum; i++) {
			if (!csp.variables[i].assigned) {
				tempDMS[i] = csp.variables[i].currentDomainSize;
			}
		}
	}

	public void pop(int level) {
		popTime++;
		int[] tempDMS = currentDMS[level];
		for (int i = 0; i < varNum; i++) {
			Variable var=csp.variables[i];
			if (!var.assigned) {
				var.restoreUpto(level);
				var.currentDomainSize = tempDMS[i];
			}
		}
	}

	public Stack(Csp c) {
		csp = c;
		varNum = csp.variables.length;
		totalLevel=varNum+1;
		cstNum=csp.constraints.length;
		currentDMS = new int[totalLevel][varNum];
	}

}

