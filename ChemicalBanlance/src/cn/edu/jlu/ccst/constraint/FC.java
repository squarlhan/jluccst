package cn.edu.jlu.ccst.constraint;

import cn.edu.jlu.ccst.model.Arc;
import cn.edu.jlu.ccst.model.Csp;
import cn.edu.jlu.ccst.model.Variable;

public class FC extends Mac{

	public FC() {
	}

	public FC(Csp c ) {
		super(c);
	}

	public boolean search() {
		long head = System.nanoTime();
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
				System.out.print("| timeout "+timeOutSeconds+" √Î");
				return true;
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
				}
			}
		}
		return true;

	}
	public boolean propagate(Variable var, int index) {
		var.reduceTo(index, level);
		addAllOutArcs(var);
		return ac(level);
	}



}
