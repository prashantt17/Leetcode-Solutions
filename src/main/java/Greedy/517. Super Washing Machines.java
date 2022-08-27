class Solution {
	public int findMinMoves(int[] machines) {
		int n = machines.length, totalMoves = 0;;
		int[] leftSum = new int[n], rightSum = new int[n];
		for (int i = 1; i<n; i++)
			leftSum[i] = leftSum[i - 1] + machines[i - 1];
		int totalSum = leftSum[n - 1] + machines[n - 1];
		if (totalSum % n != 0)
			return -1;
		int average = totalSum / n;

		for (int i = n - 2; i >= 0; i--)
			rightSum[i] = rightSum[i + 1] + machines[i + 1];
		for (int i = 0; i<n; i++) {
			int expLeftSum = average * i;
			int expRightSum = average * (n - i - 1);
			int leftPasses = 0, rightPasses = 0;
			if (expLeftSum > leftSum[i])
				leftPasses = expLeftSum - leftSum[i];
			if (expRightSum > rightSum[i])
				rightPasses = expRightSum - rightSum[i];
			totalMoves = Math.max(totalMoves, leftPasses + rightPasses);
		}
		return totalMoves;
	}
}
