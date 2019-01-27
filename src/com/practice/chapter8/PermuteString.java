package com.practice.chapter8;

import java.util.ArrayList;
import java.util.List;

/**
 * Backtracking : Enumeration problem
 */
public class PermuteString {
	
	
	public static List<String> getPerms(String s) {
		
		System.out.println("getPerms(" + s + ")");
		
		if (s == null) return null;
		
		List<String> perms = new ArrayList<>();
		
		if (s.length() == 0) {
			perms.add("");
			return perms;
		}
		
		char first = s.charAt(0);
		String remainder = s.substring(1);
		
		List<String> words = getPerms(remainder); // This is actually perms from previous call
		for (String w : words) {
			for (int pos = 0; pos <= w.length(); pos++) {
				String n = insertCharAt(w, first, pos);
				perms.add(n);
			}
		}
		
		System.out.println("Before return: " + perms);
		
		return perms;
	}
	private static String insertCharAt(String word, char c, int position) {		
		String start = word.substring(0, position);
		String end = word.substring(position);
		return start + c + end;
	}
	
	public static List<String> myPermutation(String s) {
		System.out.println("myPermutation(" + s + ")");
		
		if (s == null) return null;
		
		List<String> permutations = new ArrayList<>();
		
		if (s.isEmpty()) {
			permutations.add("");
			return permutations;
		}
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			String remainder = s.substring(0, i) + s.substring(i + 1);
			
			List<String> perms = myPermutation(remainder);
			
			for (String perm : perms) {
				permutations.add(c + perm);
			}	
		}
		System.out.println("Before return: " + permutations);
		return permutations;
	}
	
	public static List<String> getMyPermutation(String s) {
		
		List<String> result = new ArrayList<>();
		getMyPermutationHelper("", s, result);
		return result;
	}
	
	private static void getMyPermutationHelper(String prefix, String remainder, List<String> result) {
		
		if (remainder.length() == 0) result.add(prefix);
		
		int len = remainder.length();
		
		for (int i = 0; i < len; i++) { // pick each character, get permutation from others, update prefix
			
			String before = remainder.substring(0, i);
			String end = remainder.substring(i + 1);
			char removed = remainder.charAt(i);
			
			getMyPermutationHelper(prefix + removed, before + end, result);
			
		}
	}
	public static void permute(String s) {
		
		if (s == null || s.isEmpty()) return;
		
		List<String> result = new ArrayList<>();
		permuteHelper(s, "", result);
		
		System.out.println(result);
	}
	
	private static void permuteHelper(String s, String chosen, List<String> result) {
		
		System.out.println("permuteHelper( " + s + ", " + chosen + " )");
		if (s == null || s.isEmpty()) {
			System.out.println(chosen);
			result.add(chosen);
		}
		
		else {
			for (int i = 0; i < s.length(); i++) {
				// chose
				char c = s.charAt(i);
				// explore
				s = s.substring(0, i) + s.substring(i + 1); // remainder
				chosen += c;

				permuteHelper(s, chosen, result);
				
				// un-choose				
				s = s.substring(0, i) + c + s.substring(i);
				chosen = chosen.substring(0, chosen.length() - 1);							
			}
		}		
	}
	
	public static void main(String[] args) {
		//permute("abc");
		//getPerms("abc");
		List<String> l = myPermutation("abcd");
		System.out.println(l);
		System.out.println(l.size());
		
		System.out.println("abc".substring(0, 0));
		
		System.out.println(getMyPermutation("abcd"));
		
	}

}
