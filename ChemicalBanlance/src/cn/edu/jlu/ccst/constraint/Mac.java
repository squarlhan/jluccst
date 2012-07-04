package cn.edu.jlu.ccst.constraint;

import cn.edu.jlu.ccst.model.Arc;
import cn.edu.jlu.ccst.model.Constraint;
import cn.edu.jlu.ccst.model.Csp;
import cn.edu.jlu.ccst.model.Variable;
import cn.edu.jlu.ccst.constraint.TimeTool;

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
//		csp.init();
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
//		 if (var.next[var.head] == -1)
//		 return true;
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
//							if (current.outArcs[i].con.arity <= 3) {
								queue.add(current.outArcs[i]);
//							}
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
				System.out.println("!!!!!!!´íÎó½â, ");
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

}
