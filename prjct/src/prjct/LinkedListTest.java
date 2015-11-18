package prjct;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.appendIntoTail(new LinkedList.Node("101"));
		linkedList.appendIntoTail(new LinkedList.Node("201"));
		linkedList.appendIntoTail(new LinkedList.Node("301"));
		linkedList.appendIntoTail(new LinkedList.Node("401"));
		System.out.println("Linked List : " + linkedList);
		if (linkedList.isCyclic()) {
			System.out
					.println("Linked List is cyclic as it contains cycles or loop");
		} else {
			System.out
					.println("LinkedList is not cyclic, no loop or cycle found");
		}

		LinkedList linkedList2 = new LinkedList();
		linkedList2.appendIntoTail(new LinkedList.Node("101"));
		LinkedList.Node cycle = new LinkedList.Node("201");
		linkedList2.appendIntoTail(cycle);
		linkedList2.appendIntoTail(new LinkedList.Node("301"));
		linkedList2.appendIntoTail(new LinkedList.Node("401"));
		linkedList2.appendIntoTail(new LinkedList.Node("501"));
		linkedList2.appendIntoTail(cycle); 
		if (linkedList2.isCyclic()) {
			System.out.println("Linked List is cyclic as it contains cycles or loop");
		} else {
			System.out.println("LinkedList is not cyclic, no loop or cycle found");
		}
		
		List<String> a = new ArrayList<String>();
		a.add("test");
		a.add(null);
		Set<String> s = new TreeSet<String>();
		String test = null;
		s.add("test");
		s.add(test);
		

	}

}
