package experiments.ga;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgap.Population;

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
