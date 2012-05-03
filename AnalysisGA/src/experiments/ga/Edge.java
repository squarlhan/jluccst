package experiments.ga;

public class Edge {
	
	private Node node1;
	private Node node2;
	private double distance;
	public Node getNode1() {
		return node1;
	}
	public void setNode1(Node node1) {
		this.node1 = node1;
	}
	public Node getNode2() {
		return node2;
	}
	public void setNode2(Node node2) {
		this.node2 = node2;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public Edge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Edge(Node node1, Node node2) {
		super();
		this.node1 = node1;
		this.node2 = node2;
		distance = 0;
	}
	public Edge(Node node1, Node node2, double distance) {
		super();
		this.node1 = node1;
		this.node2 = node2;
		this.distance = distance;
	}
	
	public String toString(){
		return node1.getIndex()+" <--> "+node2.getIndex()+" : "+distance;
	}
	
	public boolean equals(Object anObject){
		if(anObject.getClass()==Edge.class){
			Edge temp = (Edge) anObject;
			if(distance==temp.getDistance()&&((node1 == temp.getNode1()&&node2 ==temp.getNode2())||(node1 == temp.getNode2()&&node2 ==temp.getNode1()))){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	

}
