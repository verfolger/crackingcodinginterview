package com.practice.chapter1;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the other
 */
public class CheckPermutation {
	
	private String sort(String s) {
		char[] chacacters = s.toCharArray();
		Arrays.sort(chacacters);
		
		return String.valueOf(chacacters);
	}	
	
	boolean permutation(String s, String t) {		
		if (s.length() != t.length()) return false;
		return sort(s).equals(sort(t));
	}
	
	boolean isPermutation(String str1, String str2) {
		
		if (str1.length() != str2.length()) return false;
		
		int[] letters = new int[128];
		for (char c: str1.toCharArray()) {
			letters[c]++;
		}
		
		for (char c: str2.toCharArray()) {
			letters[c]--;
			if (letters[c] < 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {	
		CheckPermutation check = new CheckPermutation();
		System.out.println(check.isPermutation("abcd", "cbac"));
		System.out.println(check.isPermutation("abba", "abab"));
	}

}
