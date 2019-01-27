package com.practice.chapter2;

import com.practice.datastructure.LinkedList;


/**
 * 
 * Lesson learned : Keep it simple, stupid.
 * There is no need to over-complicate things
 * 
 * Such as using too many references
 * 
 */
public class PartitionLists {

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add(3);
		l.add(5);
		l.add(8);
		l.add(5);
		l.add(10);
		l.add(2);
		l.add(1);
		
		System.out.println(l);
		
		partition(l.getHead(), 5);
	}
	
	
	public static void partition(LinkedList.ListNode<Integer> node, int pivot) {
		
		if (node == null) return;
		
		LinkedList.ListNode<Integer> savedHead = node;
		
		LinkedList.ListNode<Integer> head = node;
		LinkedList.ListNode<Integer> tail = node;
		
		while (node != null) {
			LinkedList.ListNode<Integer> next = node.next; // Save the next
			
			if (node.data < pivot) {
				node.next = head;
				head = node;
			} else {
				tail.next = node;
				tail = node;
			}
			node = next;		
		}
		tail.next = null;
		
		while (head != null) {
			System.out.println(head.data + " ");
			head = head.next;
		}
	}
}
