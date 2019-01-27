package com.practice.chapter10;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RankFromStream {
	
	private static PriorityQueue<Integer> streamValues = new PriorityQueue<>();
	
	public static void insertAsStream(int val) {
		streamValues.offer(val);
	}
	
	public static int getRank(int val) {
		
		List<Integer> list = new ArrayList<>();
		
		int rank = -1;
		while (!streamValues.isEmpty()) {
			int min = streamValues.peek();
			if (min == val) {
				rank = list.size();
				break;
			} else {
				list.add(streamValues.poll());
			}
		}
		streamValues.addAll(list);
		
		return rank;
	}
	
	public static void main(String[] args) {
		
		int[] values = new int[] { 3, 5, 2, 1, 9, 0 };
		
		int value = 5;
		for (int v : values) {
			insertAsStream(v);
			System.out.println("Rank of val : " + value + " is :" + getRank(value));
		}		
	}
}
