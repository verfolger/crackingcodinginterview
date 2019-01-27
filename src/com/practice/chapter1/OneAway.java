package com.practice.chapter1;

import java.util.Arrays;

public class OneAway {

	
	public static boolean isOneAway(String compareWith, String text) {
		
		if (compareWith == null || text == null)
			throw new IllegalArgumentException();
		if (Math.abs(compareWith.length() - text.length()) > 2)
			return false;
		
		int[] c = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		
		for (char ch: compareWith.toCharArray()) {
			int idx = Character.getNumericValue(ch) - Character.getNumericValue('a');
			c[idx]++;
		}
		
		for (char ch: text.toCharArray()) {
			int idx = Character.getNumericValue(ch) - Character.getNumericValue('a');
			c[idx]--;
		}
		
		return c.length - Arrays.stream(c)
							.filter(i -> i == 0)
							.count() <= 2;			// This is due to one character mismatch
	}
	
	public static void main(String[] args) {
		System.out.println(isOneAway("pale", "ple"));
		System.out.println(isOneAway("pales", "pale"));
		System.out.println(isOneAway("pale", "bale"));
		System.out.println(isOneAway("pale", "bake"));
	}

}
