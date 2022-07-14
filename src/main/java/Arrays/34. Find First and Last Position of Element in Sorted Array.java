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

//Approach-1 With loop

class Solution {
	public int[] searchRange(int[] nums, int target) {

		int[] result = new int[2];
		Arrays.fill(result, -1);
		if (nums.length == 0) {
			return result;
		}
        
        if (nums.length == 1 && nums[0] == target) {
            Arrays.fill(result, 0);
            return result;
        }
        
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (target == nums[mid]) {
				int firstIndex = mid;
				int lastIndex = mid;

				int curr = mid;
				
				while (++curr < nums.length) {
					if (nums[curr] == target) {
						lastIndex++;
					} else {
						break;
					}
				}

				curr = mid;
				while (--curr >= 0) {
					if (nums[curr] == target) {
						firstIndex--;
					} else {
						break;
					}
				}
				
				result[0] = firstIndex;
				result[1] = lastIndex;

				break;

			} else if (target < nums[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return result;

	}
}


//Approach-2 with Recursion
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
