class Solution {
	public int maxRotateFunction(int[] nums) {
		int allSum = 0;
		int len = nums.length;
		int temp = 0;
		for (int i = 0; i<len; i++) {
			temp += i * nums[i];
			allSum += nums[i];
		}
		int max = temp;
		for (int i = 1; i<len; i++) {
			temp = temp + (len) * nums[i - 1] - allSum;
			max = Math.max(max, temp);
		}
		return max;
	}
}
