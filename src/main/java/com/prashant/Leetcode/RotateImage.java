package com.prashant.Leetcode;

import java.util.Arrays;

public class RotateImage {
//	1  2  3     7  4  1          
//	4  5  6     8  5  2   
//	7  8  9     9  6  3
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix);
		
		System.out.println(Arrays.deepToString(matrix));
	}

	public static void rotate(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = i; j < col; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = i; j < col/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][col-1-j];
				matrix[i][col-1-j] = temp;
			}
		}
		
	}
	

}
