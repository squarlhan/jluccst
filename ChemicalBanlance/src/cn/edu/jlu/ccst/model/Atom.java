package cn.edu.jlu.ccst.model;

import java.util.regex.Pattern;

public class Atom {

	private String name;
	private int count;
	
	
	public Atom() {
		super();
		// TODO Auto-generated constructor stub
		count = 1;
	}
	
	public Atom(String name) {
		super();
		this.name = name;
		this.count = 1;
	}
	
	public Atom(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public static boolean checkatom(String name){
		boolean flag = true;
		String pstr = "[A-Z][a-z]?";
		flag = Pattern.matches(pstr, name);
		return flag;
	}
	
	public String toString() {
		return name+count;
	}
	
	public static void main(String[] args){
		Atom a = new Atom("C");
		System.out.print(a.checkatom(a.getName()));
	}
	
	
}
