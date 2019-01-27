package com.practice.chapter3;

public class Queue<T> {
	
	private QueueNode<T> first, last;
	
	private static class QueueNode<T> {
		T data;
		QueueNode<T> next;
		
		QueueNode(T data) {
			this.data = data;
		}
	}
	
	public void add(T data) {
		if (first == null) first = last = new QueueNode<>(data);
		else {
			QueueNode<T> newNode = new QueueNode<>(data);
			last.next = newNode;
			last = newNode;
		}
	}
	
	public T remove() {
		if (isEmpty()) throw new IllegalStateException("Empty queue");
		
		QueueNode<T> toRemove = first;
		first = first.next;
		toRemove.next = null;
		return toRemove.data;
	}
	
	public T peek() {
		if (isEmpty()) throw new IllegalStateException("Empty queue");		
		return first.data;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}

}
