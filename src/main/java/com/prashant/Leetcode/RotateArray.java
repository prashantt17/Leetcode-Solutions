package com.prashant.Leetcode;

public class RotateArray {

	public static void main(String[] args) {
//		int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
//		int k = 3;
		
		int nums[] = {-1,-100,3,99};
		int k = 2;
		
		
		rotate(nums, k);
		
		for(int i = 0 ; i < nums.length ; i++) {
			System.out.print(nums[i]+" ");
		}
	}

	public static void rotate(int[] nums, int k) {
		int len = nums.length;
		int currentIndex = k;
		int i = 1;
		while (currentIndex > 0) {
			int lastIndex = len - i;
			int mainIndexElement = nums[k];
			int temp1 = nums[lastIndex];
			int temp2 = nums[k - i];
			nums[lastIndex] = temp2;
			nums[k - i] = temp1;

			nums[lastIndex] = nums[k];
			nums[k] = temp2;
			currentIndex--;
			i++;
		}
	}
}
