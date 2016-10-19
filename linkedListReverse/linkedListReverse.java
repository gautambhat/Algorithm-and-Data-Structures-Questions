import java.util.*;

import org.w3c.dom.Node;

public class test10_20 {
	
	public static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static class linkedList {
		
		Node head;
		public void append(int data) {
			if (head == null) {
				head = new Node(data);
				return;
			}
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = new Node(data);
			
		}
		
		public void prepend(int data) {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}
		
		public void deleteWithValue(int data) {
			if (head == null)
				return;
			if(head.data == data) {
				head = head.next;
				return;
			}
			Node current = head;
			while(current.next != null) {
				if(current.next.data == data) {
					current.next = current.next.next;
					return;
				}
				current = current.next;
			}
		}

		public void reverse() {
			
			if(head == null) return;
			Node curr = head;
			Node curr2 = curr.next;
			head.next = null;
			while(curr2.next != null) {
				Node curr3 = curr2.next;
				curr2.next = curr;
				curr = curr2;
				curr2 = curr3;
			}
			curr2.next = curr;
			head = curr2;
		}

		public String showString() {
			if(head == null)
				return "";
			Node curr = head;
			String a = "";
			while(curr.next != null) {
				a += curr.data;
				curr = curr.next;
			}
			a += curr.data;
			return a;
		}
	}
	

	public static void main(String[] args) {
		
		linkedList testList = new linkedList();
		testList.append(1);
		testList.append(3);
		testList.append(5);
		testList.append(7);
		testList.append(8);
		testList.append(9);
		testList.append(2);
		testList.append(4);
		
		System.out.println(testList.showString());
		
		testList.reverse();
		
		System.out.println(testList.showString());
		
		
		

	}

}

