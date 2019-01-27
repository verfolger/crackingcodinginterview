package com.practice.chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class PalindromPermutation {

	
	public static boolean isPalindromPermutation(String s) {
		
		char[] chars = s.replace(" ", "").toLowerCase().toCharArray();
		
		int[] letters = new int[128];
		
		for (char c : chars)
			letters[c]++;
		
		Map<Character, Integer> lookup = new HashMap<>();
		
		for (char c: chars)
			lookup.merge(c, 1, Integer::sum);
		
		return lookup.values()
						.stream()
						.filter(i -> i%2 !=0)
						.count() < 2;
		
		/*
		for (char c: chars)
			lookup.put(c, lookup.get(c) == null ? 1 : lookup.get(c) + 1);
	
		long oddCount = 0;
		
		for (Character c: lookup.keySet()) {
			if (lookup.get(c) % 2 != 0)
				oddCount++;
		}
		
		if (oddCount > 1) return false;
		
		return true;*/
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindromPermutation("Tact Coa"));
		
		System.out.println(getRandomSubset(Arrays.asList(1, 5, 8, 3)));
	}
	
	
	public static List<Integer> getRandomSubset(List<Integer> list) {
		Random r = new Random();
		return list.stream()
							  .filter(x -> { return r.nextBoolean(); })
							  .collect(Collectors.toList());
	}

}
