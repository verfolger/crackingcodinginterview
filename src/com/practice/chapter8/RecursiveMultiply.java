package com.practice.chapter8;

public class RecursiveMultiply {

	
	int minProduct(int a, int b) {
		int bigger = (a > b) ? a : b;
		int smaller = (a < b) ? a : b;
		
		return minProductHelper(smaller, bigger);
		
		
	}
	
	
	private int minProductHelper(int smaller, int bigger) {
		System.out.println("CALLED: minProductHelper(" + smaller + ", " + bigger + ") ");
		
		int result;
		
		if (smaller == 0) {
			result = 0;
		}
		else if (smaller == 1)
			result = bigger;
		else {
			int s = smaller >> 1;
			int side1 = minProductHelper(s, bigger);
			int side2 = side1;
			
			if (smaller % 2 == 1)
				side2 = minProductHelper(smaller - s, bigger);
			
			result = side1 + side2;
		}
		System.out.println("RETURN : minProductHelper(" + smaller + ", " + bigger + ")  = "  + result);
		return result;
	}


	public static void main(String[] args) {
		RecursiveMultiply r = new RecursiveMultiply();
		int s = r.minProduct(9, 5);
		System.out.println(s);
	}

}
