package com.practice.chapter10;

import java.util.Arrays;

/**
 * Not allowed to see the size
 * @author banashrimandal
 *
 */
public class SortedSearchNoSize {
	
	
	private static int searchHelper(int[]a, int start, int end, int value) {
		if (start > end) return -1;
		
		int mid = (start + end) / 2;
		
		if (a[mid] > value)
			return searchHelper(a, start, mid - 1, value);
		else if (a[mid] < value)
			return searchHelper(a, mid + 1, end, value);
		else
			return mid;
	}
	
	private static int search(int[]a, int len, int value) {	
		return searchHelper(a, 0, len, value);
	}
	
	public static int binarysearch(int[] a, int value, int low, int high) {
		int mid;
		
		while (low <= high) { // Remember this! The recursion base case is : when low > high : returns -1
			mid = (low + high) / 2;
			if (value > a[mid])
				low = mid + 1;
			else if (value < a[mid])
				high = mid - 1;
			else
				return mid;
		}	
		return -1;
	}
	
	public static int indexOf(int[] a, int value) {
		int length = size(a);
		return search(a, length, value);
	}
	
	static int size(int[] a) {
		if (a[0] == -1) return -1;
		
		int idx = 0;
		int size = 0;
		while (true) {
			size = (int) Math.pow(2, idx++);
			if (a[size] == -1)
				break;
		}
		
		size = backOff(a, (int) Math.pow(2, idx - 2), (int) Math.pow(2, idx - 1));
		System.out.println("Size of the array is : " + size);
		return size;
	}
		
	private static int backOff(int[] a, int start, int end) {
		
		System.out.print("Start : " + start +  ", end : " + end);
		if (start > end) return -1;
		
		int mid = (start + end) / 2;
		
		System.out.println(" Mid : " + mid);
		
		if (a[mid] != -1) {
			if (a[mid + 1] == -1) return mid;
			else
				return backOff(a, mid + 1, end);			
		}		
		else {
			return backOff(a, start, mid - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[100];
		Arrays.fill(array, -1);
		for (int i = 0; i < 32; i++)
			array[i] = i + 1;
		
		size(array);
		System.out.println(indexOf(array, 10));
		
		System.out.println(binarysearch(array, 31, 0, size(array)));
	}

}
