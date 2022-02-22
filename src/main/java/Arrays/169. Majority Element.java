/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < nums.length ; i++) {
            if (map.containsKey(nums[i])) {
                 map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int checkNum = nums.length / 2;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
        { 
            if (entry.getValue() > checkNum) {
                return entry.getKey();     
            }         
        }  
        
        return 1;
    }
}
