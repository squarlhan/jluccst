package cn.edu.jlu.ccst.constraint;

import cn.edu.jlu.ccst.model.Csp;
import cn.edu.jlu.ccst.model.Variable;

public class Heuristic {

	public Csp csp;
	public Variable[] variables;
	public int[] fixedOrder;

	public Heuristic(Csp c) {
		csp = c;
		variables = csp.variables;
		fixedOrder=csp.varAssignOrder;
		fixedOrder=ArrayTool.fill(0, csp.varNum);
	}
	
	public int getIndex(int assignCount) {// dom-min

		return fixedOrder[assignCount-1];

	}

//	public int getIndex(int assignCount) {// dom-min
//		int result = -1;
//		double min = 1000000000;
//		for (int i = 0; i < variables.length; i++) {
//			Variable var = variables[i];
//			if (!var.assigned) {
//				int currentDomainSize = var.getCurrentSize();
//				if (currentDomainSize == 1) {
//					if (result == -1) {
//						result = i;
//					} else {
//						continue;
//					}
//				}
//				if (currentDomainSize < min) {
//					min = currentDomainSize;
//					result = i;
//				}
//			}
//		}
//
//		return result;
//
//	}
//	 public int getIndex(int assignCount) {//dom/wdeg
//	 int result = -1;
//	 double min = 1000000000;
//	 int index = 0;
//	 for (; index < variables.length; index++) {
//	 if (!variables[index].assigned) {
//	 result = index;
//	 Variable var = variables[index];
//	 int currentDomainSize = var.getCurrentSize();
//	 if (currentDomainSize == 1)
//	 continue;
//	 int currentDegree = 0;
//	 for (int j = 0; j < var.relatedCons.length; j++) {
//	 if (var.relatedCons[j].checkValid())
//	 currentDegree+=var.relatedCons[j].weight;
//	 }
//	 if(currentDegree==0){
//	 continue;
//	 }
//	 min = (double) currentDomainSize / (double) currentDegree;
//	 break;
//	 }
//	 }
//	 for (int i = index; i < variables.length; i++) {
//	 Variable var = variables[i];
//	 int currentDomainSize = var.getCurrentSize();
//	 if (currentDomainSize == 1)
//	 continue;
//	 if (!var.assigned) {
//	 if (var.relatedCons.length == 0)// ���ͼ������ͨͼʱ���ܱ���
//	 return i;
//	 int currentDegree = 0;
//	 for (int j = 0; j < var.relatedCons.length; j++) {
//	 if (var.relatedCons[j].checkValid())
//	 currentDegree += var.relatedCons[j].weight;
//	 }
//	 if (currentDegree == 0)
//	 continue;
//	 double temp = (double) currentDomainSize
//	 / (double) currentDegree;
//	 if (temp < min) {
//	 min = temp;
//	 result = i;
//	 }
//	 }
//	 }
//	
//	 return result;
//	
//	 }

	// public int getIndex(int assignCount) {//dom/ddeg
	// int result = -1;
	// double min = 1000000000;
	// int index = 0;
	// for (; index < variables.length; index++) {
	// if (!variables[index].assigned) {
	// Variable var = variables[index];
	// result = index;
	// int currentDomainSize = var.getCurrentSize();
	// if (currentDomainSize == 1)
	// continue;
	// int currentDegree = 0;
	// for (int j = 0; j < var.relatedCons.length; j++) {
	// if (var.relatedCons[j].checkValid())
	// currentDegree++;
	// }
	// min = (double) currentDomainSize / (double) currentDegree;
	// }
	// }
	//
	// for (int i = index; i < variables.length; i++) {
	// Variable var = variables[i];
	// int currentDomainSize = var.getCurrentSize();
	// if (currentDomainSize == 1)
	// continue;
	// if (!var.assigned) {
	// int currentDegree = 0;
	// for (int j = 0; j < var.relatedCons.length; j++) {
	// if (var.relatedCons[j].checkValid())
	// currentDegree++;
	// // if (var.relatedCons[j].checkValid())
	// // currentDegree+=var.relatedCons[j].getDegree();
	// }
	// if (currentDegree == 0)
	// continue;
	// double temp = (double) currentDomainSize
	// / (double) currentDegree;
	// if (temp < min) {
	// min = temp;
	// result = i;
	// }
	// }
	// }
	//
	// return result;
	//
	// }

}
