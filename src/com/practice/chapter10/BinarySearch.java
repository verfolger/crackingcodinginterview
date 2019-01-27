package com.practice.chapter10;

public class BinarySearch {

	
	private int binaraySearchHelper(int[]a, int findMe, int low, int high) {
		
		if (low > high) return -1;
		
		int mid = (low + high) / 2;
		
		if (findMe < a[mid])
			return binaraySearchHelper(a, findMe, low, mid - 1);
		else if (findMe > a[mid])
			return binaraySearchHelper(a, findMe, mid + 1, high);
		else 
			return mid;
	}
	
	public int binarySearch(int[] a, int findMe) {
		return binaraySearchHelper(a, findMe, 0, a.length - 1);
	}
	
	public int binarySearchIterative(int[] a, int findMe) {
		
		int mid;
		
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			mid = (low + high) / 2;
			
			if (findMe < a[mid])
				high = mid - 1;
			else if (findMe > a[mid])
				low = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {

	}

}
