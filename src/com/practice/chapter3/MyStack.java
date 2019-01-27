package com.practice.chapter3;

public class MyStack<T> {

	StackNode<T> top;
	
	static class StackNode<T> {
		T data;
		StackNode<T> next;
		
		StackNode(T elem) {		this.data = elem;	}
	}
	
	public T peek() {	return top.data;		}
	
	public void push(T elem) {
		StackNode<T> newTop = new StackNode<>(elem);
		newTop.next = top;
		top = newTop;
	}
	
	public T pop() {
		StackNode<T> node = top;
		top = top.next;
		node.next = null;
		return node.data;
	}
	
	public boolean isEmpty() {	return top == null;		}
	
	public static void main(String[] args) {

	}

}
