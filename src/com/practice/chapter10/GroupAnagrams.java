package com.practice.chapter10;

import java.util.*;

public class GroupAnagrams {

	private static String sortChars(String s) {
		char[] c = s.toCharArray();
		
		Arrays.sort(c);
		return new String(c);
	}
	
	private static void sortList(List<String> list) {
		
		String[] sArray = new String[list.size()];
		
		int idx = 0;
		for (String elem: list) 
			sArray[idx++] = elem;  // Be careful to increment
		
		Arrays.sort(sArray);
		
		list.clear();
		for (String elem: sArray) 
			list.add(elem);
	}
	
	static void sort(String[] array) {
		
		Map<String, List<String>> mapList = new HashMap<>();
		
		for (String elem: array) {
			String key = sortChars(elem);
			
			if (mapList.containsKey(key))
				mapList.get(key).add(elem);
			else {
				List<String> list = new ArrayList<>();
				list.add(elem);
				mapList.put(key, list);
			}				
		}
		
		// Convert hash table to an array
		int idx = 0;
		for (String key: mapList.keySet()) {
			List<String> values = mapList.get(key);
			sortList(values);
			for (String s: values) {
				array[idx] = s;
				idx++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		String[] str = new String[] { "mnj", "acre", "care", "race", "njm", "jmn", "abcd" };
		
		sort(str);
		for (String s: str)
			System.out.println(s);
		
		str = new String[] { "mnj", "acre", "care", "race", "njm", "jmn", "abcd" };
		Arrays.sort(str, new AnagramComparator());
		
		for (String s: str)
			System.out.println(s);
		
	}
	
	static class AnagramComparator implements Comparator<String> {
		
		private String sortChars(String s) {
			char[] c = s.toCharArray();
			
			Arrays.sort(c);
			return new String(c);
		}
		
		@Override
		public int compare(String o1, String o2) {			
			return sortChars(o1).compareTo(sortChars(o2));
		}		
	}

}
