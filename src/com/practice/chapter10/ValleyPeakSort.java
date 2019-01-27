package com.practice.chapter10;

import java.util.Arrays;

public class ValleyPeakSort {

	public static void main(String[] args) {
		int[] a = new int[] { 5, 3, 1, 2, 3 };
		sortValleyPeak(a);
		//sortValleyPeaks(a);
		for (int v: a) {
			System.out.print(v + ", ");
		}
	}
	
	
	/**
	 * 1 2 3 3 5
	 * 2 1 3 3 5
	 */
	public static void sortValleyPeaks(int[] a) {
		Arrays.sort(a);
		for (int i = 1; i < a.length; i += 2) {
			swap(a, i - 1, i);
		}
	}
	
	/**
	 * 5 3 1 2 3
	 * 3 5 1 2 3
	 * 3 5 1 3 2
	 */
	public static void sortValleyPeak(int[] a) {
		for (int i = 1; i < a.length; i += 2) {
			int biggestIdx = maxIndex(a, i - 1, i, i + 1);
			
			if (i != biggestIdx)
				swap(a, i, biggestIdx);
		}
	}
	
	private static void swap(int[] a, int i, int biggestIdx) {
		int temp = a[i];
		a[i] = a[biggestIdx];
		a[biggestIdx] = temp;
	}


	private static int maxIndex(int[]a, int x, int y, int z) {
		int len = a.length;
		int xVal = x >= 0 ? a[x] : Integer.MIN_VALUE;
		int yVal = y >= 0 ? a[y] : Integer.MIN_VALUE;
		int zVal = z >= 0 ? a[z] : Integer.MIN_VALUE;
		
		int max = Math.max(xVal, Math.max(yVal, zVal));
		
		if (max == xVal) return x;
		else if (max == yVal) return y;
		else return z;
	}

}
