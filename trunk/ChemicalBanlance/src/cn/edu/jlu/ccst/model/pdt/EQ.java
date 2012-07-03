package cn.edu.jlu.ccst.model.pdt;


public class EQ  extends Predicate{


	public EQ(String exp) {
		super(exp);
	}

	@Override
	public int operate() {
		return subPdts[0].operate()==subPdts[1].operate()?TRUE:FALSE;
//		if(subPdts[0].operate()==subPdts[1].operate()){
//			return TRUE;
//		}
//		return FALSE;
	}

}
