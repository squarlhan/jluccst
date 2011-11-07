package cn.edu.jlu.ccst.model;

import java.util.List;

public class nverb {
	private String nouns;
	private List<String> verb;
	
	
	
	public nverb(String nouns, List<String> verb) {
		super();
		this.nouns = nouns;
		this.verb = verb;
	}
	public nverb() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNouns() {
		return nouns;
	}
	public void setNouns(String nouns) {
		this.nouns = nouns;
	}
	public List<String> getVerb() {
		return verb;
	}
	public void setVerb(List<String> verb) {
		this.verb = verb;
	}
	 
	
	
  
	

}
