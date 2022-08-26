class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int len1 = text1.length();
        int len2 = text2.length();
        int dp[][] = new int[len1+1][len2+1];
        
        for (int i = dp.length - 2 ; i >=0 ; i--) {
            for (int j = dp[0].length-2 ; j >=0 ; j--) {
                
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1+ dp[i + 1][j + 1];
                } else {
                    dp[i][j] =  Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        
        return dp[0][0];
    }
}
