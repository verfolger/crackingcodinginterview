package com.practice.chapter2;

import com.practice.datastructure.LinkedList;
import java.util.*;

public class RemoveListElements {

	public static LinkedList.ListNode<Integer> removeKthToLast(LinkedList<Integer> list, int k) {
		
		LinkedList.ListNode<Integer> current = list.getHead();
		LinkedList.ListNode<Integer> toDeletePrev = current;
		
		int counter = 0;
		
		// Make the k-delete pointer to point to appropriate node
		while (current != null) {	
			counter++;
			if (counter  > k + 2)
				toDeletePrev = toDeletePrev.next;
			
			current = current.next;	
		}
		
		// Edge case : if k is bigger than length, do nothing
		if (counter < k) return null;
		
		// Here, if the k-pointer points to head, tackle differently
		if (toDeletePrev == list.getHead()) {
			list.setHead( list.getHead().next);
			return toDeletePrev;
		}
		
		// Otherwise
		LinkedList.ListNode<Integer> deleted = toDeletePrev.next;
		
		toDeletePrev.next = deleted.next;
		deleted.next = null;
		
		return deleted;
	}
	
	public static void removeDuplicate(LinkedList<Integer> list) {
		if (list.getHead() == null) return;
		
		LinkedList.ListNode<Integer> current = list.getHead();	
		while (current != null) {
			
			LinkedList.ListNode<Integer> p = current, q = null;			
			while ( (q = p.next) != null ) {
				if (q.data == current.data) {
					p.next = q.next; // Deleted
				} else {
					p = q;
				}
			}			
			current = current.next;			
		}		
	}
	
	public static void removeDuplicateWithSpace(LinkedList<Integer> list) {
		
		if (list.getHead() == null) return;
		
		HashSet<Integer> set = new HashSet<>();
		LinkedList.ListNode<Integer> currentNode = list.getHead(), currentNextNode = null;
		
		while ( (currentNextNode = currentNode.next) != null ) {
			set.add(currentNode.data);			
			if ( set.contains(currentNextNode.data) ) { // Duplicate found
				currentNode.next = currentNextNode.next;
			} else {
				currentNode = currentNextNode;
			}
		}		
	}
	
	public static void main(String[] args) {		
		LinkedList l = new LinkedList();
		l.add(1);
		l.add(2);
		l.add(1);
		l.add(3);
		l.add(3);
		l.add(3);
		l.add(3);
		
		System.out.println(l);
		//removeDuplicateWithSpace(l);
		System.out.println(l);
		
		removeDuplicate(l);
		System.out.println(l);
		
		removeKthToLast(l, 2);
		System.out.println(l);
		removeKthToLast(l, 2);
		System.out.println(l);

	}

}
