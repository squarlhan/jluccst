package experiments.ga;

import java.util.List;

public class Node {
	
	private String index ;
	private int weight;
	private List<Node> neighbors;
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public List<Node> getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(List<Node> neighbors) {
		this.neighbors = neighbors;
	}
	
	public String toString(){
		
	}
	
	

}
