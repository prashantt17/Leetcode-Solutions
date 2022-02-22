/*

You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10

*/

class Solution {
    public int maxCoins(int[] nums) {
         int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = arr[n+1] = 1;   // Giving padding of 1 to the corner elements
        for(int i=1;i<=n;i++){
            arr[i] = nums[i-1];   //final padded array
        }
        
        int dp[][] = new int[n+2][n+2];
        
        for(int window = 1;window<=n;window++){     // window size
		
            for(int left = 1;left<=n-window+1;left++){    // left pointer
			
                int right = left+window-1;               // right pointer
				
                for(int i=left;i<=right;i++){           // iterate from left to right
				
                    dp[left][right] = Math.max(dp[left][right], (arr[left-1]*arr[i]*arr[right+1]) + dp[left][i-1] + dp[i+1][right]);
                                    
                }
            }
        }
        return dp[1][n];
    }
}
