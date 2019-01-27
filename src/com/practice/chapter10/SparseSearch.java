package com.practice.chapter10;

public class SparseSearch {

	
	public static int search(String[] s, String findMe) {
		
		if (s == null || findMe == null || findMe == "") return -1;
		
		int mid;
		int low = 0;
		int high = s.length;
		
		int leftMid = 0, rightMid = 0;
		while (low <= high) {
			
			mid = (low + high) / 2;
			leftMid = rightMid = mid;
			
			//System.out.println("Low: " + low + ", high: " + high + " mid : " + mid);
			
			while (s[leftMid].equals("") && leftMid >= low)
				leftMid--;
				
			while (s[rightMid].equals("") && rightMid < high)
				rightMid++;
			
			if (findMe.compareTo(s[leftMid]) < 0)
				high = leftMid - 1;
			else if (findMe.equals(s[leftMid]))
				return leftMid;
			
			if (findMe.compareTo(s[rightMid]) > 0)
				low = rightMid + 1;
			else if (findMe.equals(s[rightMid]))
				return rightMid;			
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		
		String[] s = new String[] {"at", "", "", "", "", "ball", "", "", "", "", "car", "", "dad", "", "", "", "", "game" };
		
		int foundIdx = search(s, "car");
		
		System.out.println(foundIdx);
	}

}
