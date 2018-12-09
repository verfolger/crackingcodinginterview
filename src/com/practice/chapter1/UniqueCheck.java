package com.practice.chapter1;

public class UniqueCheck {

	
	boolean containsUniqueCharacters(String text) {
		
		if (text.length() > 128) return false;
		
		boolean[] characterSet = new boolean[128];
		
		for (int i = 0; i < text.length(); i++) {
			
			int val = text.charAt(i);
			//System.out.println(val);
			if (characterSet[val])
				return false;
			characterSet[val] = true;
		}		
		return true;
	}
	
	boolean isUniqueCharacters(String text) {
		int checker = 0;
		
		for (int i = 0; i < text.length(); i++) {
			
			int val = text.charAt(i) - 'a';
			
			// This is simple check if two values are same, with the help of checker which is 0 for unique characters
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= ( 1 << val );
		}
		return true;
	}
	
	public static void main(String[] args) {
		UniqueCheck check = new UniqueCheck();
		System.out.println(check.containsUniqueCharacters("zapple"));
		System.out.println(check.isUniqueCharacters("zapple"));
	}
}
