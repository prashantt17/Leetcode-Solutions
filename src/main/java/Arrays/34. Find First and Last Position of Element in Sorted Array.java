/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        int[] result = binarySearch(nums, left, right, target);
        
        return result;
    }
    
    
    public int[] binarySearch(int[] nums, int left, int right, int target) {
        
      int[] result = {-1, -1};
        
		if (left <= right) {

			int mid = (left + right) / 2;

			if (target == nums[mid]) {
				int i = mid;
				while (i >= 0 && target == nums[i]) {
					i--;
				}
				result[0] = i+1;
				i = mid;
				while (i < nums.length && target == nums[i]) {
					i++;
				}
				result[1] = i-1;
				return result;
			} else if (target < nums[mid]) {
				right = mid - 1;
				return binarySearch(nums, left, right, target);
			} else {
				left = mid + 1;
				return binarySearch(nums, left, right, target);
			}
		}
		
      	return result;
        
    }
}
