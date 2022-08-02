/*
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
       int row = matrix.length;

		int left = matrix[0][0];
		int right = matrix[row - 1][row - 1];

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (binarySearch(matrix, mid, k, row)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	private static boolean binarySearch(int[][] matrix, int target, int k, int n) {
		int i = n - 1;
		int j = 0;
		int num = 0;

		while (i >= 0 && j < n) {
			if (matrix[i][j] <= target) {
				num += i + 1;
				j++;
			} else {
				i--;
			}
		}

		return num >= k;
	}

}
