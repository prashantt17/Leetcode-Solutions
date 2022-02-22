package com.prashant.Leetcode;

public class JumpGame1 {

	public static void main(String[] args) {
		int nums[] = { 2, 3, 1, 1, 4 };
		// int nums[] = {3,2,1,0,4};
		boolean result = canJump(nums);
		System.out.println("RESULT : " + result);
	}

	public static boolean canJump(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			i = nums[i] + i;
			if (nums[i] == 0)
				return false;

			if (i >= nums.length - 1)
				return true;
		}

		return false;
	}

}
