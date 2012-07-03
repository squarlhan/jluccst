package cn.edu.jlu.ccst.model;


public class Arc {
	public int ctr = 1;
	public Arc next;
	public final Constraint con;
	public final Variable var;
	public final Variable[] others;
	public final int id;
	public int position = 0;
	public Csp csp;
	public int[][] bitSup;
	
	public int[] relatedId;
	public int[] currentBinary;
	public int[][] currentNary;
	
	
//	public VarValue[] vvs;
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int p) {
		position = p;
	}

	public Arc(Constraint con, Variable var,  int id) {
		this.id = id;
		this.con = con;
		this.setPosition(0);
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
		
	}
	
	public int revise(int deleteLevel){
		int change = 0;
		int varIndex = con.computeVarIndex(var);
		int value=var.head;
		while(value!=-1){
			int[] currentTuple = con.getFirstValidTuple(varIndex, value);
			if(currentTuple[0]==-1){
				int a=0;a++;
			}
			boolean reserve = false;
			while (currentTuple != null) {
				if(currentTuple[0]==-1){
					int a=0;a++;
				}
				if (con.test(currentTuple)) {
					reserve = true;
					break;
				}
				currentTuple=con.getNextValidTuple(varIndex, value, currentTuple);
			}
			if (!reserve) {
				var.removeValue(value, deleteLevel);
				change++;
			}
			value=var.next[value];
		}
		return change;
	}
	
	
}

