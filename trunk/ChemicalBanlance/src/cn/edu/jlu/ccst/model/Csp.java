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
		createVariables(varNum, 1, domSize);
		createConstraints(matrix, FOR_BALANCE);
		varAssignOrder = source.varOrderForSearch;
//		for (int i = 0; i < cstNum; i++) {
//			constraints[i].varOrderForGetTuple = source.varOrderForGetTuple[i];
//		}
		init();
	}

	public void init() {
		for (int i = 0; i < varNum; i++) {
			variables[i].generateRelatedCons();
			variables[i].initDomain();
		}
		createArcs();
	}

	public static final int FOR_BALANCE = 0;
	public static final int FOR_SUB_REACTION = 1;

	public void createConstraints(int[][] source, int conKind) {
		constraints = new Constraint[cstNum];
		for (int i = 0; i < cstNum; i++) {
			int[] array = new int[varNum];
			for (int j = 0; j < varNum; j++) {
				array[j] = source[i][j];
			}
			constraints[i] = createConstraint(i, array, conKind);
		}

	}

	public Constraint createConstraint(int id, int[] source,
			int conKind) {
		Constraint con = new Constraint();
		con.id = id;
		String positiveExp = "";
		String negativeExp = "";
		ArrayList<Integer> tempVarsId = new ArrayList<Integer>();
		int varLocation = 0;
		for (int i = 0; i < source.length; i++) {
			if (source[i] > 0) {
				positiveExp = addParameter(conKind, positiveExp, source[i],
						varLocation);
				varLocation++;
				tempVarsId.add(i);
				variables[i].tempRels.add(con);
			}
		}
		for (int i = 0; i < source.length; i++) {
			if (source[i] < 0) {
				negativeExp = addParameter(conKind, negativeExp, 0 - source[i],
						varLocation);
				varLocation++;
				tempVarsId.add(i);
				variables[i].tempRels.add(con);
			}
		}
		if (conKind == FOR_SUB_REACTION) {
			positiveExp = "eq(" + positiveExp + "," + 0 + ")";
			negativeExp = "eq(" + negativeExp + "," + 0 + ")";
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


	public String addParameter(int conKind, String old, int param,
			int varLocation) {
		if (old.trim().equals("")) {
			if (param == 1) {
				old = "X" + varLocation;
			}
			if (param > 1) {
				if (conKind == FOR_BALANCE) {
					old = "mul(" + param + "," + "X" + varLocation + ")";
				} else {
					if (conKind == FOR_SUB_REACTION) {
						old = "X" + varLocation;
					}
				}
			}
		} else {
			if (param == 1) {
				old = "add(" + old + ",X" + varLocation + ")";
			}
			if (param > 1) {
				if (conKind == FOR_BALANCE) {
					old = "add(" + old + ",mul(" + param + "," + "X"
							+ varLocation + "))";
				} else {
					if (conKind == FOR_SUB_REACTION) {
						old = "add(" + old +  ",X"
								+ varLocation + ")";
					}
				}
			}
		}
		return old;
	}

	public void createVariables(int varNum, int start, int domSize) {
		variables = new Variable[varNum];
		int[] domain = ArrayTool.fill(start, domSize + start);
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
			return true;
		}
		for (int i = 0; i < this.variables.length; i++)
			if (this.variables[i].currentValue == -1) {
				return false;
			}
		for (int i = 0; i < this.constraints.length; i++) {
			Constraint con = this.constraints[i];
			if (!con.testSatisfy()) {
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
		} else {
			System.out.print("no solution");
		}

	}

	public Csp(int[][] source) {// 缩减计算子反应范围用
		matrix = source;
		varNum = source[0].length;
		cstNum = source.length;
		createVariables(varNum, 0, 2);
		createConstraints(matrix,FOR_SUB_REACTION);
		init();
	}


}
