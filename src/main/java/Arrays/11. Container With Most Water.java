/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1

*/


class Solution {
    public int maxArea(int[] height) {
        
        int left = 0 ;
        int right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            
            maxWater = Math.max(maxWater, (width * minHeight));
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            
        }
        
        return maxWater;
        
    }
}
