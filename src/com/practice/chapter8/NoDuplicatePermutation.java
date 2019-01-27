package com.practice.chapter8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NoDuplicatePermutation {
	
	static int count = 0;
	private static void getPermutations(String prefix, String remainder, List<String> result) {
		count++;
		System.out.println("getPermutations(" + prefix + ", " + remainder + ")");
		
		if (remainder.length() == 0) {
			if (!result.contains(prefix)) // This controls the duplicate elimination
				result.add(prefix);
		}
		
		
		int len = remainder.length();
		
		for (int i = 0; i < len; i++) {
			
			char chosen = remainder.charAt(i);
			String start = remainder.substring(0, i);
			String end = remainder.substring(i + 1);
		
			getPermutations(prefix + chosen, start + end, result);			
		}
	}
	
	static List<String> getPermutations(String s) {
		
		List<String> result = new ArrayList<>();
		getPermutations("", s, result);
		return result;
	}
	
	private static String insertAtPosition(String word, char c, int pos) {	
		return word.substring(0, pos) + c + word.substring(pos);
	}
	
	public static void main(String[] args) {
		List<String> values = getPermutations("abad");
		System.out.println(values + " with size : " + values.size());
		HashSet<String> s = new HashSet<>(values);
		System.out.println(s.size());
	}
}
