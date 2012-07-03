package cn.edu.jlu.ccst.model.pdt;


public class LEAF extends Predicate {

	public LEAF(String exp) {
		expression = exp;
		getValue();
	}

	@Override
	public int operate() {

		return value;
	}

	public int getVarId() {
		int index = expression.indexOf("X");
		String idS = expression.substring(index + 1, expression.length());
		return Integer.parseInt(idS);
	}

	public void getValue() {
		int index = expression.indexOf("X");
		if (index <0) {
			isValue=true;
			value = Integer.parseInt(expression.trim());
		}
	}

}
