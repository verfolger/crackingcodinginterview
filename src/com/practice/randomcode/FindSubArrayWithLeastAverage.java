package com.practice.randomcode;

public class FindSubArrayWithLeastAverage {

	private int[] indices = new int[2];
	private void findSubArrayWithLeastAverage(int[] values, int k) {
		
		int currentSum = 0;
		
		for (int i = 0; i < k; i++)
			currentSum += values[i];
		
		int minSum = currentSum;
		
		for (int i = k; i < values.length; i++) {
			currentSum = currentSum + values[i] - values[i - k];
			
			if (currentSum < minSum) {
				minSum = currentSum;
				indices[0] = i - k + 1; // Start index
				indices[1] = i; // end index
			}
		}
	}
	
	public static void main(String[] args) {
		int[] vals = new int[] {3, 7, 90, 20, 10, 50, 40};
		FindSubArrayWithLeastAverage c = new FindSubArrayWithLeastAverage();
		
		c.findSubArrayWithLeastAverage(vals, 3);
		System.out.println(c.indices[0] +  " " + c.indices[1]);
		
		c.findSubArrayWithLeastAverage(new int[]{3, 7, 5, 20, -10, 0, 12}, 2);
		System.out.println(c.indices[0] +  " " + c.indices[1]);
		
	}

}
