package cn.edu.jlu.ccst.model;

import cn.edu.jlu.ccst.model.pdt.Predicate;

public class Constraint {
	public int id;
	public Variable[] vars;
	public int arity;
	public int currentAssignCount = 0;
	public int weight = 1;
	public Predicate predicate;
	public int[] testTuple;
	public String expression;

	public int[] varOrderForGetTuple;

	public Arc[] arcs;

	public static long checkTime = 0;
	
	
	public int[] getNextValidTuple(int varIndex, int varValue,
			int[] currentTuple) {
		for (int i = arity - 1; i >= 0; i--) {
			if (varOrderForGetTuple[i] != varIndex) {
				int value = vars[varOrderForGetTuple[i]].next[currentTuple[varOrderForGetTuple[i]]];
				if (value == -1)
					currentTuple[varOrderForGetTuple[i]] = vars[varOrderForGetTuple[i]].head;
				else {
					currentTuple[varOrderForGetTuple[i]] = value;
					return currentTuple;
				}
			}
		}

		return null;
	}

	public int[] getFirstValidTuple(int varIndex, int varValue) {
		int[] result = new int[arity];
		for (int i = 0; i < varIndex; i++) {
			result[i] = vars[i].head;
		}
		result[varIndex] = varValue;
		for (int i = varIndex + 1; i < arity; i++) {
			result[i] = vars[i].head;
		}
		return result;
	}


	public boolean checkValid() {
		return currentAssignCount + 1 < arity;
	}

	public int getUnassignCount() {
		return arity - currentAssignCount;
	}

	public int getDegree() {
		return arity - currentAssignCount;
	}

	public boolean test(int[] tuple) {
		checkTime++;
		for (int i = 0; i < arity; i++) {
			testTuple[i] = vars[i].domain[tuple[i]];
		}
		return predicate.test(testTuple);
	}

	public boolean isValidTuple(int[] tempTuple) {
		for (int j = 0; j < arity; j++) {
			if (vars[j].absent[tempTuple[j]] > -1) {
				return false;
			}
		}
		return true;
	}

	public int computeVarIndex(Variable var) {
		for (int i = 0; i < arity; i++) {
			if (vars[i].id == var.id) {
				return i;
			}
		}
		return -1;
	}

	public Constraint() {
	}

	public boolean testSatisfy() {
		int[] values = new int[arity];
		for (int i = 0; i < arity; i++) {
			values[i] = vars[i].currentValue;
		}
		if (test(values))
			return true;
		return false;
	}

}
