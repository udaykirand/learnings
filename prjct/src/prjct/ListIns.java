package prjct;

public class ListIns {

	public static void main(String[] args) {
		Node head = new Node();
		head.data = 3;
		head.next = null;
		System.out.println(Insert(head, 2).toString());

	}
	
	static Node Insert(Node head,int data) {
		// This is a "method-only" submission. 
		// You only need to complete this method. 
		    Node node = new Node();
		    node.data = data;
		    node.next = null;
		    if(head == null) {
		        head = node;
		        
		    } else{
		        while(head.next != null) {
		            head = head.next;
		        }
		        head.next = node;
		    }
		    System.out.println(node.toString());
		  return node;
		}

}

class Node {
	int data;
	Node next;
	
	public String toString() {
		return "data - "+data+" next - "+next;
	}
}
