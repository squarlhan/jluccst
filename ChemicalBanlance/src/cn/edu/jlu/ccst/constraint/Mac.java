package cn.edu.jlu.ccst.constraint;

import java.util.ArrayList;

import cn.edu.jlu.ccst.model.Arc;
import cn.edu.jlu.ccst.model.Constraint;
import cn.edu.jlu.ccst.model.Csp;
import cn.edu.jlu.ccst.model.MatrixSolver;
import cn.edu.jlu.ccst.model.Variable;

public class Mac {
	public Queue queue;
	public Stack stack;
	public Heuristic heuristic;
	public Csp csp;
	public int level = 0;
	public int[] assignedIndexs;

	public String solverName;

	public int totalLevel;
	public long checkTimes = 0;
	public long revisions = 0;
	public double cpuTime;
	public long backCount = 0;
	public long visitedNodes = 0;
	public boolean success = false;

	public static double timeOutSeconds = 600;
	public long timeOut = (long) (timeOutSeconds * 1000000000l);

	public Mac() {
	}

	public Mac(Csp c) {
		level = 0;
		csp = c;

		totalLevel = csp.variables.length;
		assignedIndexs = new int[totalLevel + 1];
		level = 0;
		stack = new Stack(c);
		// csp.init();
		queue = new Queue(csp.arcs.length);
		heuristic = new Heuristic(csp);
	}

	public boolean search() {
		long head = System.nanoTime();
		if (!initAC()) {
			return false;
		}
		level++;
		stack.init();
		while (level <= totalLevel) {
			visitedNodes++;
			Variable current = csp.variables[heuristic.getIndex(level)];
			int value = current.getAValue();
			stack.push(level);
			current.currentValue = value;
			long end = System.nanoTime();
			if ((end - head) > timeOut) {
				System.out.print("| timeout ");
				return false;
			}
			if (!propagate(current, value)) {
				if (level == 1) {
					if (!propagateAbolishment(current)) {
						return false;
					}
				} else {
					boolean loop = propagateAbolishment(current);
					while (!loop) {
						level--;
						backCount++;
						if (level < 1)
							return false;
						current = csp.variables[assignedIndexs[level]];
						current.decreaseAssignCount();
						loop = propagateAbolishment(current);

					}
				}
			} else {
				assignedIndexs[level] = current.id;
				current.assigned = true;
				level++;
				current.increaseAssignCount();
			}
		}
		csp.solutionExist = true;

		return true;
	}

	public boolean propagate(Variable var, int index) {
		var.reduceTo(index, level);
		addAllOutArcs(var);
		return ac(level);
	}

	public boolean propagateAbolishment(Variable var) {
		if (!abolishAssignment(var))
			return false;
		addAllOutArcs(var);
		return ac(level - 1);
	}

	protected boolean abolishAssignment(Variable var) {
		int temp = var.currentValue;
		var.currentValue = -1;
		var.assigned = false;
		stack.pop(level);
		var.removeValue(temp, level - 1);
		if (var.head == -1)
			return false;
		return true;
	}

	public boolean initAC() {
		initQueue();
		return ac(0);
	}

	public boolean ac(int deleteLevel) {
		while (queue.getSize() != 0) {
			Arc arc = queue.selectArc();
			revisions++;
			int change = arc.revise(deleteLevel);
			if (change > 0) {
				Variable current = arc.var;
				if (current.isDomainEmpty()) {
					arc.con.weight++;
					return false;
				} else {
					for (int i = 0; i < current.outArcs.length; i++) {
						if (current.outArcs[i].con.id != arc.con.id)
							// if (current.outArcs[i].con.arity <= 3) {
							queue.add(current.outArcs[i]);
						// }
					}
				}
			}
		}
		return true;

	}

	public void addAllOutArcs(Variable var) {
		queue.clear();
		for (int i = 0; i < var.outArcs.length; i++) {
			queue.add(var.outArcs[i]);
		}
	}

	public void initQueue() {
		for (int i = 0; i < csp.arcs.length; i++) {
			queue.add(csp.arcs[i]);
		}
	}

	public void testMAC() {
		long head = 0, end = 0;
		head = System.nanoTime();
		success = search();
		end = System.nanoTime();
		if (success) {
			if (!csp.testSolution()) {
				System.out.println("!!!!!!!´íÎó½â");
			}
		}
		checkTimes = Constraint.checkTime;
		Constraint.checkTime = 0;
		cpuTime = TimeTool.getSecondDoubleResult(head, end);

	}

	public String showResult() {
		String resultString = " \\  | CPU  :" + cpuTime + " | nodes: "
				+ visitedNodes + " | backtracks: " + backCount
				+ " |  Revisions: " + revisions + "|conChecks:" + checkTimes
				+ "\n";

		System.out.print(resultString);

		return resultString;
	}

	public ArrayList<int[]> searchForAll() {
		ArrayList<int[]> result = new ArrayList<int[]>();
		if (!initAC()) {
			return result;
		}
		level++;
		stack.init();
		while (level > 0) {
			visitedNodes++;
			Variable current = csp.variables[heuristic.getIndex(level)];
			int value = current.getAValue();
			stack.push(level);
			current.currentValue = value;
			if (!propagate(current, value)) {
				if (level == 1) {
					if (!propagateAbolishment(current)) {
						return result;
					}
				} else {
					boolean loop = propagateAbolishment(current);
					while (!loop) {
						level--;
						backCount++;
						if (level < 1)
							return result;
						current = csp.variables[assignedIndexs[level]];
						for (int i = 0; i < current.relatedCons.length; i++) {
							current.relatedCons[i].currentAssignCount--;
						}
						loop = propagateAbolishment(current);

					}
				}
			} else {
				assignedIndexs[level] = current.id;
				current.assigned = true;
				level++;
				for (int i = 0; i < current.relatedCons.length; i++) {
					current.relatedCons[i].currentAssignCount++;
				}
				if (level > totalLevel) {
					int[] solution = new int[totalLevel];
					for (int i = 0; i < totalLevel; i++) {
						solution[i] = csp.variables[i].currentValue;
					}
					if (testValid(solution) ) {
						result.add(solution);
					}

					for (int i = 0; i < current.relatedCons.length; i++) {
						current.relatedCons[i].currentAssignCount--;
					}
					level--;
					boolean loop = propagateAbolishment(current);
					while (!loop) {
						level--;
						backCount++;
						if (level < 1)
							return result;
						current = csp.variables[assignedIndexs[level]];
						for (int i = 0; i < current.relatedCons.length; i++) {
							current.relatedCons[i].currentAssignCount--;
						}
						loop = propagateAbolishment(current);

					}

				}

			}

		}

		return result;
	}
	public ArrayList<int[]> solutions=new ArrayList<int[]>();
	public boolean testValid(int[] tempSol) {
		ArrayList<Integer> sol=new ArrayList<Integer>(tempSol.length);
		for(int i=0;i<tempSol.length;i++){
			if(tempSol[i]!=0){
				sol.add(i);
			}
		}
		if(sol.size()==0){
			return false;
		}
		int[][] source = csp.matrix;
		int[][] testMatrix = new int[csp.matrix.length][sol.size()];
		for (int j = 0; j < sol.size(); j++) {
			for (int i = 0; i < csp.matrix.length; i++) {
				testMatrix[i][j] = source[i][sol.get(j)];
			}
		}
		for(int i=0;i<testMatrix.length;i++){
			for(int j=0;j<testMatrix[i].length;j++){
				System.out.print(testMatrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("============");
		MatrixSolver ms=new MatrixSolver(testMatrix);
		int rank=ms.getRank();
		int result=sol.size()-rank;
		if(result!=1){
			return false;
		}
		int[][] basicSolution=ms.solve();
		int[] basic=basicSolution[0];
		for(int i=0;i<basic.length;i++){
			if(basic[i]<=0){
				return false;
			}
		}
		solutions.add(basic);
		return true;
	}

	
//	public boolean testValid(int[] tempSol) {
//		ArrayList<Integer> sol=new ArrayList<Integer>(tempSol.length);
//		for(int i=0;i<tempSol.length;i++){
//			if(tempSol[i]!=0){
//				sol.add(i);
//			}
//		}
//		if(sol.size()==0){
//			return false;
//		}
//		int[][] source = csp.matrix;
//		int[][] testMatrix = new int[csp.matrix.length][sol.size()];
//		for (int j = 0; j < sol.size(); j++) {
//			for (int i = 0; i < csp.matrix.length; i++) {
//				testMatrix[i][j] = source[i][sol.get(j)];
//			}
//		}
//		Matrix ma=getMatrix(testMatrix);
//		int rank=ma.rank();
//		int result=sol.size()-rank;
//		return result==1;
//	}

//	public Matrix getMatrix(int[][] matrix){
//		int m = matrix.length;
//		int n = matrix[0].length;
//		double[][] dma = new double[m][n];
//		for (int i = 0; i <= m - 1; i++) {
//			for (int j = 0; j <= n - 1; j++) {
//				dma[i][j] = matrix[i][j];
//			}
//		}
//		Matrix ma = new Matrix(dma);
//		return ma;
//	}
	
//	public int rank(int[][] matrix) {
//		int m = matrix.length;
//		int n = matrix[0].length;
//		
//		double[][] dma = new double[m][n];
//		for (int i = 0; i <= m - 1; i++) {
//			for (int j = 0; j <= n - 1; j++) {
//				dma[i][j] = matrix[i][j];
//			}
//		}
//		Matrix ma = new Matrix(dma);
//		
//		return ma.rank();
//	}
}
