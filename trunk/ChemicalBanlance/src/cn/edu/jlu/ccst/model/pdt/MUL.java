package cn.edu.jlu.ccst.model.pdt;


public class MUL extends Predicate{

	public MUL(String exp) {
		super(exp);
	}

	@Override
	public int operate() {
		return subPdts[0].operate()*subPdts[1].operate();
	}

}
