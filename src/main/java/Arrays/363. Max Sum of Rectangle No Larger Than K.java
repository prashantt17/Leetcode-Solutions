class Solution {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int row = matrix.length;
		int col = matrix[0].length;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < row; i++) {
			int arr[] = new int[col];
			for (int j = i; j < row; j++) {
				for (int x = 0; x < col; x++)
					arr[x] += matrix[j][x];

				int sum = getSMaxSum(arr, k);
				max = Math.max(max, sum);
			}
		}

		return max;
	}

	public int getSMaxSum(int arr[], int k) {
		int res = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			int s = 0;
			for (int j = i; j < arr.length; j++) {
				s += arr[j];
				if (s <= k)
					res = Math.max(res, s);
			}
		}

		return res;
	}

}
