package com.practice.chapter3;

public class Stack {

	private int DEFAULT_CAPACITY = 16;
	int top = -1;
	private int[] elements;
	private int size;
	
	Stack(int capacity) {
		this.elements = new int[capacity];
	}
	
	public void push(int element) {
		if (size == elements.length) throw new IllegalStateException("Full stack");
		
		top++;
		this.elements[top] = element;
		size++;
	}
	
	public int pop() {
		if (top < 0) throw new IllegalStateException("Empty stack"); 
		size--;
		return elements[top--];
	}
	
	public int peek() {
		if (top == -1) throw new IllegalStateException("Empty stack");
		return elements[top];
	}
	
	
	
	Stack() {
		this.elements = new int[DEFAULT_CAPACITY];
	}
	
	
	public static void main(String[] args) {
		

	}

}
