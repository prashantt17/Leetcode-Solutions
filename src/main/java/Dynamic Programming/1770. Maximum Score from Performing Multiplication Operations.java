class Solution {
    
    int row;
    int col;
    public int maximumScore(int[] nums, int[] multipliers) {
        row = nums.length;
        col = multipliers.length;
	    return helper(nums, multipliers, 0, 0, new Integer[col][col]);
    }

    private int helper(int[] nums, int[] multipliers, int left, int index, Integer[][] dp) {
	    
        int right = row - 1 - (index - left);
	    
        if (index == col) {
            return 0;
        }

	    if (dp[left][index] != null){
             return dp[left][index];                            
        }

	    int res = Math.max(
            nums[left] * multipliers[index] + helper(nums, multipliers, left+1, index+1, dp), 
            nums[right] * multipliers[index] + helper(nums, multipliers, left, index+1, dp));

        dp[left][index] = res;
	    return res;
    }
}
