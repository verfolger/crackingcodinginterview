package com.practice.datastructure;

public class LinkedList<T> {

	private ListNode<T> head;	
	private int length = 0;
	
	public static class ListNode<T> { // Important structure on which this data structure is dependent on!
		T data;
		ListNode<T> next;
		ListNode(T data) {
			this.data = data;
		}	
	}
	
	public ListNode<T> getHead() { return this.head; }
	
	public void setHead(ListNode<T> head) { this.head = head; }
	
	public int getListLength() { return length; }
	
	public int getListLength(ListNode head) {		
		if (head == null) return 0;
		
		int count = 0;
		ListNode currentNode = head;
		while (currentNode != null) {
			currentNode = currentNode.next;
			count++;
		}
		return count;
	}
	
	public synchronized void addAtFirst(ListNode node) {
		if (head == null) head = node;
		else {
			ListNode currentNode = head;
			head = node;
			node.next = currentNode;
		}
		length++;
	}
	
	public synchronized void addAtEnd(ListNode node) {
		
		if (head == null) head = node;
		else {
			ListNode currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = node;
		}
		length++;
	}
	
	public void add(T data) {
		add(data, length);
	}
	
	public void add(T data, int position) { // 1 based position
		
		if ( position < 0 ) position = 0;
		if ( position > length ) position = length;
		
		if (head == null) head = new ListNode(data);
		// To add at the front of the list
		else if ( position == 0 ) {
			ListNode newNode = new ListNode(data);
			newNode.next = head;
			head = newNode;
		} 
		// find correct position to add
		else {
			ListNode currentNode = head;
			for (int i = 1; i < position; i++) { // Index starts from 1 as you need to point to previous
				currentNode = currentNode.next;
			}
			ListNode newNode = new ListNode(data);
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
		length++;
	}
	
	/**
	 * 
	 * @return The node that is deleted from the front
	 */
	public synchronized ListNode deleteFromBegin() {
		
		if (head == null) return null;
		
		ListNode currentNode = head;
		head = currentNode.next;
		currentNode.next = null; // To de-link
		length--;
		return currentNode;
	}
	
	public synchronized ListNode deleteFromEnd() {
		
		if ( head == null ) return null;
		
		ListNode currentNode = head;
		
		// Check all edge cases are solved or not!
		if (head.next == null) { 
			head = null;
			return currentNode;
		}
		while (currentNode.next.next != null) {
			currentNode = currentNode.next;
		}
		
		ListNode deleted = currentNode.next;
		currentNode.next = null;
		length--;
		return deleted;
	}
	
	public void delete(T data) {
		if (head == null) return;
		
		if (head.data == data) {
			head = head.next;
			return;
		}
		
		ListNode p = head, q = null;
		
		while ((q = p.next) != null) {
			if (data == q.data) {
				p.next = q.next;
				return;
			}
			p = q;
		}
	}
	
	
	public synchronized void deleteMatched(T data) {
		if (head == null) return;
		
		if (head.data == data)
			head = head.next;
		
		ListNode p = head, q = null;
		
		while ((q = p.next) != null) {
			if ( q.data == data ) { // Delete				
				p.next = q.next;
				q.next = null;
			} else {
				p = q;
			}
		}
		
	}
	
	public ListNode deleteAt(int position) {
		
		if (head == null) return null;
		
		if (position < 0) position = 0;
		if (position > length) position = length;
	
		length--;
		ListNode currentNode = head;
		
		if (position == 0) {			
			head = head.next;
			currentNode.next = null;
			return currentNode;
		} else {
			for ( int i = 1; i < position; i++) {
				currentNode = currentNode.next;
			}
			ListNode deleted = currentNode.next;
			currentNode.next = deleted.next;
			deleted.next = null;
			
			return deleted;
		}
	}
	
	/**
	 * The output will look like : ["str1", "str2", ... ]
	 */
	public String toString() {
		if (head == null) return null;
		
		if (head.next == null) return String.valueOf(head.data);
		
		String str = "[";
		ListNode currentNode = head.next;
		str += head.data;
		while (currentNode != null) {
			str += ", " + currentNode.data;
			currentNode = currentNode.next;
		}
		return str + "]";
	}
	
	public int length() { return this.length; }
	
	public int getPosition(T data) {
		
		if (head == null) return -1;
		
		ListNode currentNode = head;
		
		int position = 0;
		while (currentNode != null) {
			if (currentNode.data == data) { // That is why we need comparable objects
				return position;
			}
			position++;
			currentNode = currentNode.next;
		}	
		return 0;
	}
	
	public void clearList() {
		head = null;
		length = 0;
	}	
}
