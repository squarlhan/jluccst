package cn.edu.jlu.ccst.model;

import java.util.ArrayList;

import cn.edu.jlu.ccst.model.pdt.Predicate;
import cn.edu.jlu.ccst.constraint.ArrayTool;
import cn.edu.jlu.ccst.constraint.SimplifiedMatrix;

public class Csp {
	public String name;
	public Constraint[] constraints;
	public Variable[] variables;
	public Arc[] arcs;
	public Predicate[] predicates;

	public int[][] matrix;
	public boolean solutionExist = false;

	public int varNum;
	public int cstNum;
	public int arcNum = 0;

	public int[] varAssignOrder;

	public void update(int newDomSize) {
		for (int i = 0; i < varNum; i++) {
			variables[i].domain = ArrayTool.fill(1, newDomSize + 1);
			variables[i].initDomain();
		}
		for (int i = 0; i < arcNum; i++) {
			arcs[i].setPosition(-1);
			arcs[i].currentNary = new int[arcs[i].var.initDomainSize][];
		}
	}

	public Csp(SimplifiedMatrix source, int domSize) {
		matrix = source.matrix;
		varNum = source.varNum;
		cstNum = source.cstNum;
		createVariables(varNum, domSize);
		createConstraints(matrix);
		varAssignOrder = source.varOrderForSearch;
		for (int i = 0; i < cstNum; i++) {
			constraints[i].varOrderForGetTuple = source.varOrderForGetTuple[i];
		}
		init();
	}

	public void init() {
		for (int i = 0; i < varNum; i++) {
			variables[i].generateRelatedCons();
			variables[i].initDomain();
		}
		createArcs();
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
		String positiveExp = "";
		String negativeExp = "";
		ArrayList<Integer> tempVarsId = new ArrayList<Integer>();
		int varLocation = 0;
		for (int i = 0; i < source.length; i++) {
			if (source[i] > 0) {
				positiveExp = addParameter(positiveExp, source[i],
						varLocation);
				varLocation++;
				tempVarsId.add(i);
				variables[i].tempRels.add(con);
			}
		}
		for (int i = 0; i < source.length; i++) {
			if (source[i] < 0) {
				negativeExp = addParameter(negativeExp, 0-source[i],
						varLocation);
				varLocation++;
				tempVarsId.add(i);
				variables[i].tempRels.add(con);
			}
		}
		String expression = "eq(" + positiveExp + "," + negativeExp + ")";
		con.expression = expression;
		con.arity = tempVarsId.size();
		con.vars = new Variable[con.arity];
		for (int i = 0; i < con.arity; i++) {
			con.vars[i] = variables[tempVarsId.get(i)];
		}
	
		
		
		con.predicate = Predicate.parse(expression);
		con.predicate.vars = con.vars;
		con.testTuple = new int[con.arity];
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
		} else {
			if (param == 1) {
				old = "add(" + old + ",X" + varLocation + ")";
			}
			if (param > 1) {
				old = "add(" + old + ",mul(" + param + "," + "X" + varLocation
						+ "))";
			}
		}
		return old;
	}

	public void createVariables(int varNum, int domSize) {
		variables = new Variable[varNum];
		int[] domain = ArrayTool.fill(1, domSize + 1);
		for (int i = 0; i < varNum; i++) {
			variables[i] = new Variable(i, domain);
		}
	}

	public void createArcs() {
		for (int i = 0; i < constraints.length; i++) {
			arcNum += constraints[i].arity;
		}
		arcs = new Arc[arcNum];
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

	public void recordArcRelation(Constraint con, int start, int end) {
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
			// System.out.println("问题无解，无法测试解正确性");
			return true;
		}
		for (int i = 0; i < this.variables.length; i++)
			if (this.variables[i].currentValue == -1) {
				System.out.println("变量" + i + "未赋值");
				return false;
			}
		for (int i = 0; i < this.constraints.length; i++) {
			Constraint con = this.constraints[i];
			if (!con.testSatisfy()) {
				System.out.print("不满足方程" + i + " : ");
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
		if (solutionExist) {
			System.out.print("solution:");
			for (int i = 0; i < this.variables.length; i++) {
				if (this.variables[i].currentValue == -1) {
					System.out.println("X" + i + "未赋值");
				} else {
					System.out
							.print("变量"
									+ i
									+ "="
									+ this.variables[i].domain[this.variables[i].currentValue]
									+ " | ");
				}
			}
			System.out.println();
		} else {
			System.out.print("no solution");
		}

	}
}
