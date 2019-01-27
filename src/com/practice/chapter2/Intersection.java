package com.practice.chapter2;

import com.practice.datastructure.LinkedList;

public class Intersection {

	public static boolean isIntersecting(LinkedList.ListNode<Integer> head1, 
			LinkedList.ListNode<Integer> head2) {
		
		int size1 = getSize(head1);
		int size2 = getSize(head2);
		
		LinkedList.ListNode<Integer> small = (size1 < size2) ? head1 : head2;
		LinkedList.ListNode<Integer> big = (size1 > size2) ? head1 : head2;
		
		int diff = java.lang.Math.abs(size1 - size2);
		
		do {
			big = big.next;
			diff--;
		} while (diff > 0);
		
		
		while (big != null || small != null) {
			
			if (big == small)
				return true;
			
			big = big.next;
			small = small.next;
		}		
		return false;
	}
	
	
	private static int getSize(LinkedList.ListNode<Integer> head) {
		
		if (head == null) return -1;
		
		LinkedList.ListNode<Integer> current = head;
		
		int len = 1;
		while (current != null) {
			len++;
			current = current.next;
		}
		
		return len;
	}
	
	public static void main(String[] args) {
		
		LinkedList.ListNode<Integer> h1 = new LinkedList.ListNode<Integer>(1);
		LinkedList.ListNode<Integer> h2 = new LinkedList.ListNode<Integer>(10);
		
		h1.next = new LinkedList.ListNode<Integer>(2);
		h1.next.next = new LinkedList.ListNode<Integer>(3);
		h1.next.next.next = new LinkedList.ListNode<Integer>(4);
		h1.next.next.next.next = new LinkedList.ListNode<Integer>(5);
		
		h2.next = new LinkedList.ListNode<Integer>(-10); //h1.next.next.next;
		h2.next.next = new LinkedList.ListNode<Integer>(-1);
		
		
		System.out.println(isIntersecting(h1, h2));
		
		h2.next = h1.next.next.next;
		System.out.println(isIntersecting(h1, h2));
	}

}
