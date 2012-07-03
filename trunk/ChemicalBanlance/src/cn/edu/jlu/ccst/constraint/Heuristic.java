package cn.edu.jlu.ccst.constraint;

import cn.edu.jlu.ccst.model.Csp;
import cn.edu.jlu.ccst.model.Variable;


public class Heuristic {

	public Csp csp;
	public Variable[] variables;


	public Heuristic(Csp c) {
		csp = c;
		variables = csp.variables;
	}


	public int getIndex(int assignCount) {//dom/wdeg
		int result = -1;
		double min = 1000000000;
		int index = 0;
		for (; index < variables.length; index++) {
			if (!variables[index].assigned) {
				result = index;
				Variable var = variables[index];
				int currentDomainSize = var.getCurrentSize();
				if (currentDomainSize == 1)
					continue;
				int currentDegree = 0;
				for (int j = 0; j < var.relatedCons.length; j++) {
					if (var.relatedCons[j].checkValid())
						currentDegree+=var.relatedCons[j].weight;
				}
				if(currentDegree==0){
					continue;
				}
				min = (double) currentDomainSize / (double) currentDegree;
				break;
			}
		}
		for (int i = index; i < variables.length; i++) {
			Variable var = variables[i];
			int currentDomainSize = var.getCurrentSize();
			if (currentDomainSize == 1)
				continue;
			if (!var.assigned) {
				if (var.relatedCons.length == 0)// 生成图不是连通图时可能报错
					return i;
				int currentDegree = 0;
				for (int j = 0; j < var.relatedCons.length; j++) {
					if (var.relatedCons[j].checkValid())
						currentDegree += var.relatedCons[j].weight;
				}
				if (currentDegree == 0)
					continue;
				double temp = (double) currentDomainSize
						/ (double) currentDegree;
				if (temp < min) {
					min = temp;
					result = i;
				}
			}
		}

		return result;

	}
	
	
//	public int getIndex(int assignCount) {//dom/ddeg
//		int result = -1;
//		double min = 1000000000;
//		int index = 0;
//		for (; index < variables.length; index++) {
//			if (!variables[index].assigned) {
//				Variable var = variables[index];
//				result = index;
//				int currentDomainSize = var.getCurrentSize();
//				if (currentDomainSize == 1)
//					continue;
//				int currentDegree = 0;
//				for (int j = 0; j < var.relatedCons.length; j++) {
//					if (var.relatedCons[j].checkValid())
//						currentDegree++;
//				}
//				min = (double) currentDomainSize / (double) currentDegree;
//			}
//		}
//
//		for (int i = index; i < variables.length; i++) {
//			Variable var = variables[i];
//			int currentDomainSize = var.getCurrentSize();
//			if (currentDomainSize == 1)
//				continue;
//			if (!var.assigned) {
//				int currentDegree = 0;
//				for (int j = 0; j < var.relatedCons.length; j++) {
//					if (var.relatedCons[j].checkValid())
//						currentDegree++;
//					// if (var.relatedCons[j].checkValid())
//					// currentDegree+=var.relatedCons[j].getDegree();
//				}
//				if (currentDegree == 0)
//					continue;
//				double temp = (double) currentDomainSize
//						/ (double) currentDegree;
//				if (temp < min) {
//					min = temp;
//					result = i;
//				}
//			}
//		}
//
//		return result;
//
//	}


}
