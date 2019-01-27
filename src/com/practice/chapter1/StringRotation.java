package com.practice.chapter1;

public class StringRotation {

	public static void main(String[] args) {
		System.out.println(isRotated("waterbottle", "bottlewater"));
	}
	
	public static boolean isRotated(String s1, String s2) {
		
		if (s1 == null || s2 == null || s1.length() != s2.length() || s1.equals(s2)) return false;
		
		int len = s1.length();
		int unmatchedCount = 0;
		String s = new String();
		for (char c: s1.toCharArray()) {
			if (s2.charAt(0) != c) {
				unmatchedCount++;
				s += c;
			}
			else {
				break;
			}
		}
	
		/**
		 * Just to be sure that we are comparing with right strings
		 */
		int j = 0;
		for (int i = unmatchedCount; i < len; i++) {
			if (s1.charAt(i) != s2.charAt(j))
				return false;
			j++;
		}
		
		String compareTo = s2.substring(len - unmatchedCount);
		
		return (compareTo.equals(s));
	}
	
	private static boolean isSubString(String s1, String s2) {
		return s1.contains(s2);
	}

}
