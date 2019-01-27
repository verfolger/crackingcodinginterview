package com.practice.chapter1;

public class RotateMatrix {

	public static void printMatrix(int[][] m) {
		for (int r = 0; r < m.length; r++) {
			for (int c = 0; c < m[0].length; c++) {
				System.out.print(m[r][c] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		int[][] m = {
				{2, 0, 1},
				{2, 0, 1},
				{2, 0, 1}
		};
		
		rotateRight(m, 3);
		printMatrix(m);
		
		System.out.println("--------------- Original --------------------------------");
		
		rotateLeft(m, 3);
		printMatrix(m);
		
		System.out.println("--------------- k = 3 --------------------------------");
		rotateRightKTimes(m, 2);
		printMatrix(m);
	}

	/**
	 * Rotate clockwise 90 degrees
	 */
	public static void rotateRight(int[][] matrix, int n) {
		
		for (int r = 0; r < n/2; r++) {
			for (int c = r; c < n - r - 1; c++) {
				int temp = matrix[r][c];
				
				matrix[r][c] = matrix[n - 1 - c][r];
				matrix[n - 1 - c][r] = matrix[n - 1 - r][n - 1 - c];
				matrix[n - 1 - r][n - 1 - c] = matrix[c][n - 1 - r];
				matrix[c][n - 1 - r] = temp;
			}
		}
	}
	
	/**
	 * Rotate anti-clockwise 90 degree
	 */
	public static void rotateLeft(int[][] m, int n) {
		
		for (int row = 0; row < n/2; row++) {
			for (int col = row; col < n - row - 1; col++) {
				int temp = m[row][col];
				
				m[row][col] = m[col][n - 1 - row];
				m[col][n - 1 - row] = m[n - 1 - row][n - 1 - col];
				m[n - 1 - row][n - 1 - col] = m[n - 1 - col][row];
				m[n - 1 -col][row] = temp;
			}
		}
	}
	
	
	public static void rotateMatrixByElements(int[][] m, int noElements) {
		
		int len = m.length;
		
		for (int row = 0; row < len / 2; row++) {
			for (int col = row; col < len - 1 - row; col++) {
				
				
			}
		}
		
		
	}
	
	public static void rotateRightKTimes(int[][] m, int rotationCount) {
		
		int rows = m.length;	
		int cols = m[0].length;
		int[] temp = new int[rows];
		
		rotationCount = rotationCount % rows;
		
		for (int i = 0; i < cols; i++) {
			
			/**
			 * Copy the first rowCount - rotationCount elements in a temporary array
			 */
			for (int col = 0; col < rows - rotationCount; col++)
				temp[col] = m[i][col];
			
			/**
			 * Copy the remaining elements to the start
			 */
			for (int col = rows - rotationCount; col < rows; col++)
				m[i][col - rows + rotationCount] = m[i][col];
			
			/**
			 * Copy elements in temporary to the remaining part of the array
			 */
			for (int col = rotationCount; col < rows; col++)
				m[i][col] = temp[col - rotationCount];				
		}
	}
}
