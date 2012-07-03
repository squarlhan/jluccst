package cn.edu.jlu.ccst.model;

import java.util.ArrayList;

import cn.edu.jlu.ccst.model.pdt.Predicate;
import cn.edu.jlu.ccst.constraint.ArrayTool;

public class Csp {
	public String name;
	public Constraint[] constraints;
	public Variable[] variables;
	public Arc[] arcs;
	public Predicate[] predicates;

	public int[][][] supportList;
	public boolean solutionExist = false;

	public int varNum;
	public int cstNum;

	public Csp(int[][] source, int domSize) {
		varNum = source[0].length;
		cstNum = source.length;
		createVariables(varNum, domSize);
		createConstraints(source);

	}

	public void createConstraints(int[][] source) {
		constraints = new Constraint[cstNum];
		for (int i = 0; i < cstNum; i++) {
			int[] array = new int[varNum];
			for (int j = 0; j < varNum; j++) {
				array[j] = source[i][j];
			}
			constraints[i] = createConstraint(i, array);
		}

	}

	public Constraint createConstraint(int id, int[] source) {
		Constraint con = new Constraint();
		con.id = id;
		String expression = "";
		ArrayList<Integer> tempVarsId = new ArrayList<Integer>();
		int varLocation=0;
		for (int i = 0; i < source.length; i++) {
			if (source[i] != 0) {
				expression = addParameter(expression, source[i], varLocation);
				varLocation++;
				tempVarsId.add(i);
				variables[i].tempRels.add(con);
			}
		}
		expression="eq("+expression+","+0+")";
		con.expression = expression;
		con.arity = tempVarsId.size();
		con.vars = new Variable[con.arity];
		for (int i = 0; i < con.arity; i++) {
			con.vars[i] = variables[tempVarsId.get(i)];
		}
//		System.out.println(expression);
		con.predicate = Predicate.parse(expression);
		con.predicate.vars=con.vars;
		con.testTuple=new int[con.arity];
		return con;
	}

	public String addParameter(String old, int param, int varLocation) {
		if (old.trim().equals("")) {
			if (param == 1) {
				old = "X" + varLocation;
			}
			if (param > 1) {
				old = "mul(" + param + "," + "X" + varLocation + ")";
			}
			if (param == -1) {
				old = "neg(X" + varLocation + ")";
			}
			if (param < -1) {
				old = "neg(mul(" + param + "," + "X" + varLocation + "))";
			}
		} else {
			if (param == 1) {
				old = "add(" + old + ",X" + varLocation + ")";
			}
			if (param > 1) {
				old = "add(" + old + ",mul(" + param + "," + "X" + varLocation + "))";
			}
			if (param == -1) {
				old = "sub(" + old + ",X" + varLocation + ")";
			}
			if (param < -1) {
				old = "sub(" + old + ",mul(" + (0 - param) + "," + "X" + varLocation
						+ "))";
			}
		}
		return old;
	}

	public void createVariables(int varNum, int domSize) {
		variables = new Variable[varNum];
		int[] domain = ArrayTool.fill(1, domSize+1);
		for (int i = 0; i < varNum; i++) {
			variables[i] = new Variable(i, domain);
		}
	}

	public void init() {
		for (int i = 0; i < varNum; i++) {
			variables[i].generateRelatedCons();
			variables[i].initDomain();
		}
		createArcs();
	}

	public void createArcs() {
		int count = 0;
		for (int i = 0; i < constraints.length; i++) {
			count += constraints[i].arity;
		}
		arcs = new Arc[count];
		int index = 0;
		for (int i = 0; i < constraints.length; i++) {
			Constraint con = constraints[i];
			int start = index;
			con.arcs = new Arc[con.arity];
			for (int j = 0; j < con.arity; j++) {
				arcs[index] = new Arc(con, con.vars[j], index);

				arcs[index].csp = this;
				con.arcs[j] = arcs[index];
				index++;
			}
			int end = index - 1;
			recordArcRelation(con, start, end);
		}
		for (int i = 0; i < variables.length; i++) {
			variables[i].copyOutArc();
		}

	}

	public void recordArcRelation( Constraint con, int start, int end) {
		for (int i = start; i <= end; i++) {
			Arc arc = arcs[i];
			int index = 0;
			arc.relatedId = new int[con.arity];
			for (int j = start; j <= end; j++) {
				arc.relatedId[index] = arcs[j].id;
				index++;
			}
		}
	}

	public boolean testSolution() {
		if (!this.solutionExist) {
			// System.out.println("�����޽⣬�޷����Խ���ȷ��");
			return true;
		}
		for (int i = 0; i < this.variables.length; i++)
			if (this.variables[i].currentValue == -1) {
				System.out.println("����" + i + "δ��ֵ");
				return false;
			}
		for (int i = 0; i < this.constraints.length; i++) {
			Constraint con = this.constraints[i];
			if (!con.testSatisfy()) {
				System.out.print("�����㷽��" + i + " : ");
				for (int j = 0; j < con.arity; j++) {
					System.out.print("X" + con.vars[j].id + "="
							+ con.vars[j].getSolutionValue() + " ,");
				}
				System.out.println();
				return false;
			}
		}
		return true;

	}

	public Csp() {

	}
	public void printSolution() {
		if(solutionExist){
			System.out.print("solution:");
			for (int i = 0; i < this.variables.length; i++) {
				if (this.variables[i].currentValue == -1) {
					System.out.println("X" + i + "δ��ֵ");
				} else {
					System.out
							.print("����"
									+ i
									+ "="
									+ this.variables[i].domain[this.variables[i].currentValue]
									+ " | ");
				}
			}
			System.out.println();
		}else{
			System.out.print("no solution");
		}
		
	}
}
