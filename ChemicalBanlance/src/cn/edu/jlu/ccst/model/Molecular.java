package cn.edu.jlu.ccst.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
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
		String tempstr = name;
		List<String> atom_names = new ArrayList();
		List<Integer> atom_counts = new ArrayList();
		List<Integer> times = new ArrayList();
		times.add(1);
		if (tempstr.indexOf("(") < 0) {
			findatom(atom_names, atom_counts, tempstr, times);
		}else{
			while (tempstr.indexOf("(") > -1) {
				int index1 = tempstr.indexOf("(");
				int index2 = tempstr.lastIndexOf(")");
				String leftstr = tempstr.substring(0, index1);
				String innerstr = tempstr.substring(index1 + 1, index2);
				String rightstr = tempstr.substring(index2 + 1);
				findatom(atom_names, atom_counts, leftstr, times);
				String time_str = getnumber(rightstr);
				int t = Integer.parseInt(time_str);
				if(t!=1){
					rightstr = rightstr.substring(time_str.length());
				}					
				findatom(atom_names, atom_counts, rightstr, times);
				times.add(t);
				if (innerstr.indexOf("(") < 0) {
					findatom(atom_names, atom_counts, innerstr, times);
				}
				tempstr = innerstr;
				
			}
		}
		
		for(int i = 0;i<=atom_names.size()-1;i++){
			Atom a = new Atom(atom_names.get(i),atom_counts.get(i));
			atoms.add(a);
		}
	}
	
	public void findatom(List<String> atom_names ,List<Integer> atom_counts, String initstr, List<Integer> times){
		atoms = new ArrayList();
		int tt = 1;
		for(int t :times){
			tt  = tt*t;
		}
		String strname = initstr;
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
				if(atom_names.contains(str)){
					int index = atom_names.indexOf(str);
					atom_counts.set(index, atom_counts.get(index)+a_count*tt);
				}else{
					atom_names.add(str);
				    atom_counts.add(a_count*tt);
				}
				
				if(a_count!=1){
					strname = strname.substring(a_count_str.length());
				}
				
			}else{
				str = strname.substring(0, 1);
				strname = strname.substring(1);
				String a_count_str = getnumber(strname);
				int a_count = Integer.parseInt(a_count_str);
				if(atom_names.contains(str)){
					int index = atom_names.indexOf(str);
					atom_counts.set(index, atom_counts.get(index)+a_count*tt);
				}else{
					atom_names.add(str);
				    atom_counts.add(a_count*tt);
				}
				if(a_count!=1){
					strname = strname.substring(a_count_str.length());
				}
			}
		}
	}
	
	public static void main(String[] args){
		Molecular m = new Molecular("H2(Ca(NaOH)2)2O2");
		for(Atom a:m.getAtoms()){
			System.out.print(a.getName()+a.getCount());
		}
		System.out.println("\n"+m.getAtoms().size());
		
		String str = "H2(Ca(NaOH)2)2O2";
		String tempstr = str;
		List<String> atom_names = new ArrayList();
		List<Integer> atom_counts = new ArrayList();
		List<Integer> times = new ArrayList();
		times.add(1);
		if (tempstr.indexOf("(") < 0) {
			m.findatom(atom_names, atom_counts, tempstr, times);
		}else{
			while (tempstr.indexOf("(") > -1) {
				int index1 = tempstr.indexOf("(");
				int index2 = tempstr.lastIndexOf(")");
				String leftstr = tempstr.substring(0, index1);
				String innerstr = tempstr.substring(index1 + 1, index2);
				String rightstr = tempstr.substring(index2 + 1);
				m.findatom(atom_names, atom_counts, leftstr, times);
				String time_str = m.getnumber(rightstr);
				int t = Integer.parseInt(time_str);
				if(t!=1){
					rightstr = rightstr.substring(time_str.length());
				}					
				m.findatom(atom_names, atom_counts, rightstr, times);
				times.add(t);
				if (innerstr.indexOf("(") < 0) {
					m.findatom(atom_names, atom_counts, innerstr, times);
				}
				tempstr = innerstr;
				
			}
		}
		System.out.println();
		for(int i = 0;i<=atom_names.size()-1;i++){
			System.out.print(atom_names.get(i));
			System.out.print(atom_counts.get(i));
		}
		System.out.println();
	}
	

}
