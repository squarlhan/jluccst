package cn.edu.jlu.ccst.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Molecular {
	
	private String name;
	private int count;
	private List<Atom> atoms;
	
	
	public Molecular(String name, int count, List<Atom> atoms) {
		super();
		this.name = name;
		this.count = count;
		this.atoms = atoms;
	}


	public Molecular() {
		super();
		count =1;
		// TODO Auto-generated constructor stub
	}


	public Molecular(String name) {
		super();
		this.name = name;
		count = 1;
		validate();
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


	public List<Atom> getAtoms() {
		return atoms;
	}


	public void setAtoms(List<Atom> atoms) {
		this.atoms = atoms;
	}
	
	public boolean isNumber(char ch){
		boolean flag = true;
		String pstr = "\\d";
		flag = Pattern.matches(pstr, String.valueOf(ch));
		return flag;
	}
	
	public String getnumber(String str){
		String a_count = "1";
		String a_count_str ="";
		char[] chs = str.toCharArray();
		int index = 0;
		while((chs.length>=index+1)&&(isNumber(chs[index]))){
			a_count_str = a_count_str + chs[index];
			index++;
		}
		if(a_count_str!=""){
			return a_count_str;
		}
		return a_count;
	}
	
	public int find(String keywork){
		int count = 0;
		for(Atom a : atoms){
			if(a.getName().equals(keywork)){
				return a.getCount();
			}
		}
		return count;
	}
	
	public void validate(){
		atoms = new ArrayList();
		String strname = name;
		while(strname.length()>=1){
			String str = "";
			if(strname.length()>=2){
				str = strname.substring(0, 2);
			}else{
				str = strname.substring(0);
			}
			
			if(Atom.checkatom(str)){
				int len = str.length();
				strname = strname.substring(len);
				String a_count_str = getnumber(strname);
				int a_count = Integer.parseInt(a_count_str);
				Atom a = new Atom(str, a_count);
				atoms.add(a);
				if(a_count!=1){
					strname = strname.substring(a_count_str.length());
				}
				
			}else{
				str = strname.substring(0, 1);
				strname = strname.substring(1);
				String a_count_str = getnumber(strname);
				int a_count = Integer.parseInt(a_count_str);
				Atom a = new Atom(str, a_count);
				atoms.add(a);
				if(a_count!=1){
					strname = strname.substring(a_count_str.length());
				}
			}
		}
	}
	
	public static void main(String[] args){
		Molecular m = new Molecular("H2SO4");
		for(Atom a:m.getAtoms()){
			System.out.print(a.getName()+a.getCount());
		}
		System.out.println("\n"+m.getAtoms().size());
	}
	

}
