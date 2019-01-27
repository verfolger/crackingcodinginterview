package com.practice.chapter1;

public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] m = {
				{1, 1, 0, 1, 1, 1},
				{0, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 0, 1}
		};
		
		fillZero(m);
		for (int r = 0; r < m.length; r++) {
			for (int c = 0; c < m[0].length; c++) {
				System.out.print(m[r][c] + " ");
			}
			System.out.println();
		}
	}

	public static void fillZero(int[][] matrix) {
		
		boolean[] row = new boolean[matrix.length];
		boolean[] col = new boolean[matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		// Nullify rows
		
		for (int i = 0; i < row.length; i++)
			if (row[i]) nullifyRow(matrix, i);
		
		for (int i = 0; i < col.length; i++)
			if (col[i]) nullifyCol(matrix, i);
	}

	private static void nullifyCol(int[][] matrix, int colIndex) {
		for (int i = 0; i < matrix.length; i++)
			matrix[i][colIndex] = 0;
	}

	private static void nullifyRow(int[][] matrix, int rowIndex) {
		
		for (int i = 0; i < matrix[0].length; i++)
			matrix[rowIndex][i] = 0;
		
	}
}
