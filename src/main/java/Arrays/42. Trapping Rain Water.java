/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

*/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int[] left = new int[n];
        left[0] = height[0];
        int[] right = new int[n];
        right[n-1] = height[n-1];
        
        for (int i = 1 ; i < n ; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        for (int j = n-2 ; j >=0 ; j--) {
            right[j] = Math.max(right[j+1], height[j]);
        }
        
        int max = 0;
        
        for (int k = 0 ; k < n ; k++) {
            max += Math.min(left[k], right[k]) - height[k];
        }
        
        return max;
    }
}
