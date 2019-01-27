package com.practice.chapter10;

public class SearchSortMatrix {
	
	private static void searchHelper(int[][]matrix, int totalRow, int totalCol, int findMe) {
		
		int foundColIdx = Integer.MIN_VALUE;
		int foundRow = -1;
		for (int row = 0; row < totalRow; row++) {
			
			foundColIdx = binarySearch(matrix[row], findMe);
			if (foundColIdx != -1) {
				foundRow = row;
				break;
			}	
		}		
		if (foundColIdx != -1)
			System.out.println("Element : " + findMe + " is found at row :" + foundRow + " , col : " + foundColIdx);
		else 
			System.out.println("Not found");
	}
	public static void search(int[][] matrix, int findMe) {
		int totalRow = matrix.length;
		int totalCol = matrix[0].length;
		
		if (totalRow <= totalCol) {
			searchHelper(matrix, totalRow, totalCol, findMe);
			
		} else {
			// Reverse the matrix
			int[][] reverseMatrix = new int[totalCol][totalRow];
			for (int row = 0; row < totalRow; row++) {
				for (int col = 0; col < totalCol; col++) {
					reverseMatrix[col][row] = matrix[row][col];
				}				
			}
			searchHelper(matrix, totalCol, totalRow, findMe);	
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{ 15, 20, 40, 85 },
			{ 20, 35, 80, 95 },
			{ 30, 55, 95, 105 }
		};
		search(matrix, 105);
		
		
		matrix = new int[][] {
			{ 15, 20, 40, 85 },
			{ 20, 35, 80, 95 },
			{ 30, 55, 95, 105 },
			{ 40, 80, 100, 120 }
		};
		System.out.println(findElement(matrix, 55));
	}
	
	/**
	 * A beautiful algorithm to find an element
	 */
	static boolean findElement(int[][] matrix, int elem) {
		
		int row = 0;
		int col = matrix[0].length - 1;
		
		while (row < matrix.length && col >= 0) {
			System.out.println("Row : " + row + " Col : " + col);
			if (matrix[row][col] == elem) {
				System.out.println("Element is found at row :" + row + ", col :" + col);
				return true;
			}
			else if (matrix[row][col] > elem)
				col--;
			else 
				row++;
		}
		return false;
	}
	
	private static int binarySearch(int[]a, int findMe) {
		int mid;
		int low = 0, high = a.length - 1;
		
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

}
