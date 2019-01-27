package com.practice.chapter2;

import com.practice.datastructure.LinkedList;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> l = new LinkedList();
		l.add("a");
		l.add("b");
		l.add("c");
		/*l.add("d");
		l.add("e");*/
		
		System.out.println(l);
		
		deleteMiddleNode(l);
		
		System.out.println(l);
		
	}
	

	public static LinkedList.ListNode<String> deleteMiddleNode(LinkedList<String> list) {
		
		if (list == null) return null;
		
		LinkedList.ListNode<String> head = list.getHead();
		
		if (list.getListLength(head) == 1) return head;
		LinkedList.ListNode<String> current = head;
		LinkedList.ListNode<String> runner = current;
		LinkedList.ListNode<String> prevRunner = null;
		
		int counter = 0;
		while (current != null) {
			counter++;
			
			System.out.println("Counter : " + counter + 
					" prev : " + (prevRunner != null ? prevRunner.data : "") 
					+ " runner : " + runner.data + " Current: " + current.data);
			
			current = current.next;
			
			if (counter > 2 && (counter - 1) % 2 == 0) {
				prevRunner = runner;
				runner = runner.next;			
			}
		}
		
		if (prevRunner != null) {
			prevRunner.next = runner.next;
			runner.next = null;
		}
		return head;
	}
	
	

}
