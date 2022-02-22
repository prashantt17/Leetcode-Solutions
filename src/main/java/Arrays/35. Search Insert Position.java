/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int mid = (0 + nums.length)/2;   
        int index = 0;
        
        int first = 0;
        int last = nums.length-1;
        
        while (first <= last) {
           if (nums[mid] == target) {
               return mid;
           } else if (nums[mid] > target) {
               last = mid-1;
           } else {
               first = mid+1;
           }
            mid = (first+last)/2;
        }
        
        return first;
    }
}
