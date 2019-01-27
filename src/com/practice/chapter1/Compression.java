package com.practice.chapter1;

public class Compression {

	public static void main(String[] args) {
		System.out.println(compression("aabcccccaaa"));
	}
	
	
	public static String compression(String s) {
		
		char prev = ' ';
		int count = 0;
		
		StringBuffer sb = new StringBuffer();
		char[] c = s.toCharArray();
		
		for (int i = 0; i < c.length; i++) {
			if ( i == 0 ) {
				count++;
				prev = c[i];
			} else {
				if (c[i] == prev) { // as we do nothing : Continuation of tricky part
					count++;
				} else {
					sb.append(prev).append(count);
					prev = c[i];
					count = 1;
				}
			}		
		}
		sb.append(prev).append(count); // Tricky part : The end part needs to be appended as well		
		return sb.toString();
	}

}
