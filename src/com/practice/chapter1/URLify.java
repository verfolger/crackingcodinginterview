package com.practice.chapter1;

public class URLify {

	public static void main(String[] args) {
		urlify("Mr  John Smith      ");
	}
	
	public static void urlify(String s) {
		
		char[] c = s.toCharArray();
		
		int j = c.length - 1;
		for (int i = c.length - 1; i > 0; i--) {
			
			if (c[i] != ' ') {
				c[j] = c[i]; j--;
			} else {
				if (j != c.length - 1) {
					c[j] = '0';
					c[j-1] = '2';
					c[j-2] = '%';
					j = j -3;
				}
			}
		}
		System.out.println(String.valueOf(c));
	}
}
