package experiments.ga;

public class Node {
	
	private String index ;
	private int weight;
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
	
	public Node(String index, int weight) {
		super();
		this.index = index;
		this.weight = weight;
	}
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return index+" : "+weight;
	}
	
	public boolean equals(Object anObject){
		if(anObject.getClass()==Node.class){
			Node temp = (Node) anObject;
			if(index == temp.getIndex()&&weight ==temp.getWeight()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	

}
