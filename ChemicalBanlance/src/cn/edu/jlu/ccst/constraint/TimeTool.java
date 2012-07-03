package cn.edu.jlu.ccst.constraint;

public class TimeTool {

	public static double formatDouble(double source, int precise) {
		String re = Double.toString(source);
		re = formatString(source, precise);
		return Double.parseDouble(re);
	}

	public static String formatString(double source, int precise) {
		String re = Double.toString(source);
		int index = re.length();
		boolean exist = false;
		while (!exist) {
			if (index == 0)
				break;
			if (re.substring(index - 1, index).equals("E")
					|| re.substring(index - 1, index).equals("e")) {
				exist = true;
			} else {
				index--;
			}
		}
		if (exist) {
			return re;
		}
		for (int i = 0; i < re.length(); i++) {
			if (re.substring(i, i + 1).equals(".")) {
				if ((i + precise + 1) < re.length()) {
					re = re.substring(0, i + precise + 1);
				}
				break;
			}
		}
		return re;
	}

	public static double getSecondDoubleResult(long head, long end) {
		double result=getDifference(head, end);
		result /= 1000000000;
		return result;
//		return formatDouble(result, 2);
	}

	public static String getSecondStringResult(long head, long end) {
		double result=getDifference(head, end);
		result /= 1000000000;
		return formatString(result, 2);
	}

	public static double getMilliSecondDoubleResult(long head, long end) {
		double result=getDifference(head, end);
		result /= 1000000;
		return formatDouble(result, 1);
	}
	
	public static double getDifference(long head,long end){
		double result;
		if (head > end) {
			result = head - end;
		} else {
			result = end - head;
		}
		return result;
	}

}