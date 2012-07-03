package cn.edu.jlu.ccst.model;

import cn.edu.jlu.ccst.model.pdt.Predicate;

public class Constraint {
	public int id;
	public Variable[] vars;
	public int arity;
	public int currentAssignCount = 0;
	public int weight = 1;
	public Predicate predicate;
	public long revisedTime = 0;
	public int[] testTuple;
	public String expression;
	
	public Arc[] arcs;

	public static long checkTime = 0;

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
	
	public int[] getNextValidTuple(int varIndex, int varValue,
			int[] currentTuple) {
		for (int i = arity - 1; i >= 0; i--) {
			if (i != varIndex) {
				int value = vars[i].next[currentTuple[i]];
				if (value == -1)
					currentTuple[i] = vars[i].head;
				else {
					currentTuple[i] = value;
					return currentTuple;
				}
			}
		}

		return null;
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




	public boolean sameTuple(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
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


	public Variable[] getothers(Variable var) {
		Variable[] results = new Variable[arity - 1];
		int count = 0;
		for (int i = 0; i < arity; i++) {
			if (var.id != vars[i].id)
				results[count++] = vars[i];
		}
		return results;

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

