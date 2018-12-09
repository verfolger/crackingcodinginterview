package com.practice.datastructure;

public class LinkedList<T> {

	private ListNode<T> header;	
	private int length = 0;
	
	static class ListNode<T> { // Important structure on which this data structure is dependent on!
		T data;
		ListNode<T> next;
		ListNode(T data) {
			this.data = data;
		}	
	}
	
	public ListNode<T> getHeader() { return this.header; }
	
	public void setHeader(ListNode<T> header) { this.header = header; }
	
	public int getListLength() { return length; }
	
	public int getListLength(ListNode header) {		
		if (header == null) return 0;
		
		int count = 0;
		ListNode currentNode = header;
		while (currentNode != null) {
			currentNode = currentNode.next;
			count++;
		}
		return count;
	}
	
	public synchronized void addAtFirst(ListNode node) {
		
	}
	
	public synchronized void addAtEnd(ListNode node) {
		
	}
	
	public void add(T data, int position) {
		
	}
	
	public synchronized ListNode deleteFromBegin() {
		return null;
	}
	
	public synchronized ListNode deleteFromEnd() {
		return null;
	}
	
	public synchronized void deleteMatched(ListNode node) {
		
	}
	
	public void delete(int position) {
		
	}
	
	public String toString() {
		return null;
	}
	
	public int length() { return this.length; }
	
	public int getPosition(T data) {
		return 0;
	}
	
}
