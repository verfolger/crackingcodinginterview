package com.practice.chapter8;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

	
	List<List<Integer>> getAllSubsets(List<Integer> values) {
		
		if (values.isEmpty()) return null;
		
		
		
		return null;
	}
	
	void getAllSubsetsHelper(List<Integer> values, int toBeSelected, List<Integer> selectedSoFar, List<List<Integer>> powerSet) {
		if (toBeSelected == values.size()) {
			// DONE		
			powerSet.add(new ArrayList<>(selectedSoFar));
			return;
		} else {
			/*for (int i = 1; i < values.size(); i++) {
				int chosen = values.get(i);
				values.remove(i);
				getAllSubsetsHelper(values, result);
				values.add(i, chosen);
				getAllSubsetsHelper(values, result);
				
				
			}*/
		}
	}
	
	
	
	public static List<List<Integer>> getSubsets(List<Integer> set) {
		
		List<List<Integer>> allSubsets = new  ArrayList<>();
		
		int max = 1 << set.size();
		
		for (int subsetIdx = 0; subsetIdx < max; subsetIdx++) {
			List<Integer> subset = convertIntToSet(subsetIdx, set);
			allSubsets.add(subset);
		}		
		return allSubsets;
	}
	
	private static List<Integer> convertIntToSet(int subsetIndex, List<Integer> set) {
		
		System.out.println("--------------------- finding for localtion : subsetIndex : " + subsetIndex);
		List<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for (int k = subsetIndex; k > 0; k >>= 1) {
			System.out.println(" k : " + k);
			if ( (k & 1) == 1) {
				subset.add(set.get(index));
				System.out.println("Value added: " + set.get(index) + " for index: " + index);
			} else 
				System.out.println("Value is NOT added for index: " + index);
			index++;
		}		
		return subset;
	}
	
	public static void main(String[] args) {
		//List<Integer> list = Stream.iterate(1, n -> n + 1).limit(4).collect(Collectors.toList());
		List<Integer> list = new ArrayList<>();
		list.add(123);
		list.add(333);
		list.add(9);
		
		getSubsets(list);
		
		
	}

}
