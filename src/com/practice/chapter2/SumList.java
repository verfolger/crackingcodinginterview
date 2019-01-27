package com.practice.chapter2;

import com.practice.datastructure.LinkedList;

public class SumList {

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.add(3);
		l1.add(5);
		l1.add(8);
		
		LinkedList l2 = new LinkedList();
		l2.add(3);
		l2.add(5);
		l2.add(8);
		
		sum(l1, l2);
	}
	
	public static void sum(LinkedList<Integer> first, LinkedList<Integer> second) {
		
		LinkedList.ListNode<Integer> head1 = first.getHead();
		LinkedList.ListNode<Integer> head2 = first.getHead();
		LinkedList.ListNode<Integer> head = null, savedHead = null; 
		
		LinkedList.ListNode<Integer> node;
		int sum = 0, carry = 0;
		while (head1 != null || head2 != null) {
			
			sum = 	(head1 != null ? head1.data : 0) + 
					(head2 != null ? head2.data : 0) + carry;
			

			carry = sum / 10;
			sum = sum % 10;
			
			node = new LinkedList.ListNode<Integer>(sum);
			
			if (head == null) {
				head = node;
				savedHead = head;
			} else {
				head.next = node;
				head = head.next;
			}
			
			head1 = head1.next;
			head2 = head2.next;
		}
		
		if (carry != 0) {
			node = new LinkedList.ListNode<Integer>(carry);
			head.next = node;
		}
		
		while (savedHead != null) {
			System.out.print(savedHead.data + " ");
			savedHead = savedHead.next;
		}
	}
}
