package cn.edu.jlu.ccst.model.pdt;

import java.util.ArrayList;
import java.util.LinkedList;

import cn.edu.jlu.ccst.model.Variable;

public abstract class Predicate {
	public static final String ADD = "add";
	public static final String SUB = "sub";
	public static final String MUL = "mul";
	public static final String DIV = "div";
	public static final String EQ = "eq";


	public static final int TRUE = 1;
	public static final int FALSE = -1;

	public Predicate[] subPdts;
	public Variable[] vars;
	public int value;
	public boolean isValue = false;
	public String expression;
	public String operator;
	public Predicate[] leaves;
	public int varCount;
	public int id;
	public int[] varLocations; 
	public static LinkedList<Predicate> tempLeaves = new LinkedList<Predicate>();

	public boolean test(int[] tuple) {
		for (int i = 0; i < varLocations.length; i++) {
			leaves[varLocations[i]].value = tuple[i];
		}
		return operate() == TRUE;
	}

	public static Predicate parse(String exp) {
		tempLeaves.clear();
		Predicate result = createPredicate(exp);
		copyLeaves(result);
		return result;
	}

	static ArrayList<Integer> tempVarLocations=new ArrayList<Integer>();
	public static void copyLeaves(Predicate p) {
		p.leaves = new Predicate[tempLeaves.size()];
		for (int i = 0; i < p.leaves.length; i++) {
			p.leaves[i] = tempLeaves.removeFirst();
			if(!p.leaves[i].isValue){
				tempVarLocations.add(i);
			}
		}
		p.varLocations=new int[tempVarLocations.size()];
		for(int i=0;i<p.varLocations.length;i++){
			p.varLocations[i]=tempVarLocations.get(i);
		}
		tempVarLocations.clear();
		p.varCount = p.leaves.length;
	}

	public Predicate() {

	}

	public Predicate(String exp) {
		operator = getOperator(exp);
		expression = exp.trim();
		int left = exp.indexOf("(");
		String[] subOpString = getSubOpStrings(exp.substring(left + 1,
				exp.length() - 1));
		subPdts = new Predicate[subOpString.length];
		for (int i = 0; i < subOpString.length; i++) {
			subPdts[i] = createPredicate(subOpString[i]);
		}

	}

	public static Predicate createPredicate(String exp) {
		String operator = getOperator(exp);
		if (operator.equals(EQ)) {
			return new EQ(exp);
		}
		if (operator.equals(DIV)) {
			return new DIV(exp);
		}
		if (operator.equals(MUL)) {
			return new MUL(exp);
		}
		if (operator.equals(SUB)) {
			return new SUB(exp);
		}
		if (operator.equals(ADD)) {
			return new ADD(exp);
		}
		Predicate leaf = new LEAF(exp);
		Predicate.tempLeaves.add(leaf);
		return leaf;
	}

	public static String getOperator(String exp) {
		int index = exp.indexOf("(");
		if (index > -1) {
			return exp.substring(0, index);
		}
		return "";
	}

	public String[] getSubOpStrings(String s) {

		int index = s.indexOf(",");
		if (index == -1) {
			String[] result = new String[1];
			result[0] = new String(s);
			return result;
		}
		int leftIndex = s.indexOf("(");
		while (leftIndex != -1) {
			if (leftIndex < index) {
				index = s.indexOf(",", index + 1);
				leftIndex = s.indexOf("(", leftIndex + 1);
			} else {
				break;
			}
		}
		String[] result = new String[2];
		result[0] = new String(s.substring(0, index));
		result[1] = new String(s.substring(index + 1, s.length()));
		return result;
	}

	public abstract int operate();

}
