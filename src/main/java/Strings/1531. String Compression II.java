class Solution {
     private int[][] dp;
    private char[] chars;
    private int n;
    
    public int getLengthOfOptimalCompression(String s, int k) {
        this.chars = s.toCharArray();
        this.n = s.length();
        this.dp = new int[n][k+1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return dp(0, k);
    }
    
    private int dp(int i, int k) {
        if (k < 0) return n;
        if (n <= i + k) return 0;
        
        int ans = dp[i][k];
        if (ans != -1) return ans; 
        ans = dp(i + 1, k - 1);
        int length = 0, same = 0, diff = 0;
        
        for (int j=i; j < n && diff <= k; j++) {
            
            if (chars[j] == chars[i]) {
                same++;
                if (same <= 2 || same == 10 || same == 100) length++;
            } else {
                diff++; 
            }
            ans = Math.min(ans, length + dp(j + 1, k - diff)); 
        }
        dp[i][k] = ans;
        return ans;
    }
}
