package experiments.ga;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgap.Population;

import experiments.MaxFunction;

public class PopNet {
	
	private List<Node> nodes;
	private Set<Edge> edges;
	
	
	
	public PopNet() {
		super();
		nodes = new ArrayList();
		edges = new HashSet();
	}

	public void transtonet(List<Integer> results, Population pop){
		Set<Integer> res = new HashSet();
		res.addAll(results);
		Object[] resarray = res.toArray();
		List<List<Integer>> cls = new ArrayList();
		for(int a = 0;a<=res.size()-1;a++){
			List<Integer> cl = new ArrayList();
			for(int b=0;b<=results.size()-1;b++){				
				if(resarray[a].equals(results.get(b))){
					cl.add(b);
				}				
			}
			cls.add(cl);
		}
		for(int a = 0;a<=res.size()-1;a++){
			Node temp = new Node(resarray[a].toString(),cls.get(a).size());
			nodes.add(temp);
		}
		
		for(int a = 0;a<=res.size()-2;a++){
			Set<Integer> aps = new HashSet();
			Set<Integer> bps = new HashSet();
			for(int aa: cls.get(a)){
				aps.add(pop.getChromosome(aa).getMom());
				aps.add(pop.getChromosome(aa).getPap());
			}
			for(int b = a+1;b<=res.size()-1;b++){
				bps = new HashSet();
				for(int bb: cls.get(b)){
					bps.add(pop.getChromosome(bb).getMom());
					bps.add(pop.getChromosome(bb).getPap());
				}
				Set<Integer> interset =   intersection(aps,bps);
				if(interset.size()>0){
					Edge temp = new Edge(nodes.get(a), nodes.get(b));
					edges.add(temp);
				}
			}
		}
		
	}
	
	public void transtonet(Population pop, int size){
		for(int a = 0;a<=size-1;a++){
			Node temp = new Node(String.valueOf(pop.getChromosome(a).getIndex()),0);
			nodes.add(temp);
		}
		
		Map<Edge, Integer> eandd = new HashMap();
		
		for(int b = size; b<=pop.size()-1;b++){
			int pap =  pop.getChromosome(b).getPap();
			int mom = pop.getChromosome(b).getMom();
			if(pap==mom){
				nodes.get(pap).setWeight(nodes.get(pap).getWeight()+1);
			}else{
				Edge edge = new Edge(nodes.get(pap), nodes.get(mom));
				if(!eandd.containsKey(edge)){
					eandd.put(edge, 1);
				}else{
					eandd.put(edge, eandd.get(edge)+1);
				}
				edges.add(edge);				
			}
		}
		
		for(Edge edge : edges){
			edge.setDistance(eandd.get(edge));
		}
		
	}
	
	public void writepython(int progress){
		try {
			String p = String.valueOf(progress);
			while(p.length()<3){
				p = "0"+p;
			}
			File py = new File("py/"+p+".py");
			if (py.exists()) {
				py.delete();
				if (py.createNewFile()) {
					System.out.println("py  file create success!");
				} else {
					System.out.println("py file create failed!");
				}
			} else {
				if (py.createNewFile()) {
					System.out.println("py file create success!");
				} else {
					System.out.println("py file create failed!");
				}
				
				BufferedWriter pyoutput = new BufferedWriter(new FileWriter(py));
				pyoutput.write("import networkx as nx     "+"\n");
				pyoutput.write("import matplotlib.pyplot as plt   "+"\n");
				pyoutput.write("G = nx.Graph()"+"\n");
				pyoutput.flush();
				for(Node no:nodes){
					pyoutput.write("G.add_node(\""+no+"\")"+"\n");
				}
				for(Edge ed:edges){
					pyoutput.write("G.add_edge(\""+ed.getNode1()+"\",\""+ed.getNode2()+"\")"+"\n"); 
				}
				pyoutput.flush();
				pyoutput.write("pos = nx.circular_layout(G) "+"\n"); 
				pyoutput.write("plt.title(nx.average_clustering(G)) "+"\n"); 
				pyoutput.write("nx.draw(G, pos) "+"\n");                      
				pyoutput.write("plt.savefig(\""+p+".png\")        "+"\n"); 
				pyoutput.write("#plt.show()  "+"\n");
				pyoutput.flush();
				
				pyoutput.close();
			}	
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public Set<Edge> getEdges() {
		return edges;
	}

	public void setEdges(Set<Edge> edges) {
		this.edges = edges;
	}

	private Set<Integer>  intersection(Set<Integer> aa,Set<Integer> bb){
		Set<Integer> result = new HashSet();
		for(int a:aa){
			if(bb.contains(a))result.add(a);
		}
		return result;
	}

}
