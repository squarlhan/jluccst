package experiments.ga;

public class Netest {
	
	public static void main(String[] args){
		Node node1 = new Node("1", 2);
		Node node2 = new Node("2", 1);
		Node node3 = new Node("2", 1);
		Edge  edge1 = new Edge(node1, node2);
		Edge  edge2 = new Edge(node2, node1);
		System.out.println(node1);
		System.out.println(node2);
		System.out.println(edge1);
		System.out.println(edge2);
		if(edge1.equals(edge2)){
			System.out.println("OK!");
		}
		if(node2.equals(node3)){
			System.out.println("OK!");
		}
	}

}
