/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

*/

class Solution {
    public int search(int[] nums, int target) {
        int mid = (0 + nums.length - 1) / 2;
        System.out.println("mid : " + mid);

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target == nums[mid]) {
                return mid;
            } else {
                start = mid + 1;
            }

            mid = (start + end) / 2;
        }

        return -1;
    }
}
