package cn.edu.jlu.ccst.model;




public class Arc {
	public Arc next;
	public final Constraint con;
	public final Variable var;
	public final int id;
	public int position = -1;
	public Csp csp;
	public final Variable[] others;
	public int[] relatedId;
	public int[][] currentNary;
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int p) {
		position = p;
	}

	public Arc(Constraint con, Variable var,  int id) {
		this.id = id;
		this.con = con;
		this.var = var;
		others=new Variable[con.arity-1];
		int count=0;
		for(int i=0;i<con.arity;i++){
			if(var.id!=con.vars[i].id){
				others[count]=con.vars[i];
				others[count].tempOutArc.add(this);
				count++;
			}
		}
		currentNary = new int[var.initDomainSize][];
	}
	
	public int revise(int deleteLevel) {
		int change = 0;
		int varIndex = con.computeVarIndex(var);
		int value = var.head;
		while (value != -1) {
			int[] currentSupport = currentNary[value];
			if (currentSupport == null || !con.isValidTuple(currentSupport)) {
				int[] currentTuple = con.getFirstValidTuple(varIndex, value);
				boolean reserve = false;
				while (currentTuple != null) {
					if (con.test(currentTuple)) {
						reserve = true;
						for (int j = 0; j < con.arity; j++) {
							csp.arcs[relatedId[j]].currentNary[currentTuple[j]] = currentTuple;
						}
						break;
					}
					currentTuple = con.getNextValidTuple(varIndex, value,
							currentTuple);
				}
				if (!reserve) {// 没有支持它的
					var.removeValue(value, deleteLevel);
					change++;
					currentNary[value] = null;
				}
			}
			value = var.next[value];
		}
		return change;

	}
	
	
	
}

