class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num : nums) total += num;
        
        if(total % 2 == 1) return false;
        
        boolean[] dp = new boolean[total/2 + 1];
        dp[0] = true;
        
        for(int num : nums){
            for(int i=dp.length-1; i-num>=0; i--){
                if(dp[i-num]) dp[i] = true;
            }
        }
        
        return dp[total/2];
    }
}
