package com.practice.ds;

import com.practice.datastructure.*;

public class LinkedListMain {

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(4);
		l.add(4);
		l.add(4);
		l.add(5);
		l.add(4);
		l.add(4);
		
		System.out.println(l);
		//l.delete(4);
		//System.out.println(l);
		//l.deleteFromEnd();
		l.deleteMatched(4);
		System.out.println(l);
	}

}
