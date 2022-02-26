/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

*/

class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {

		int row = matrix.length;
		int col = matrix[0].length;

		List<Integer> result = new ArrayList<Integer>();

		int T = 0, B = row - 1, R = col - 1, L = 0, dir = 0;

		while (T <= B && L <= R) {

			if (dir == 0) {
				for (int i = L; i <= R; i++)
					result.add(matrix[T][i]);
				T++;
				dir = 1;
				
			} else if (dir == 1) {
				for (int i = T; i <= B; i++)
					result.add(matrix[i][R]);
				R--;
				dir = 2;
				
			} else if (dir == 2) {
				for (int i = R; i >= L; i--)
					result.add(matrix[B][i]);
				B--;
				dir = 3;
				
			} else if (dir == 3) {
				for (int i = B; i >= T; i--)
					result.add(matrix[i][L]);
				L++;
				dir = 0;
				
			}
		}

		System.out.println("result : " + result);
		return result;

	}
}
