class Solution {
    public int minDistance(String word1, String word2) {
         int l1 = word1.length();
        int l2 = word2.length();
        
        //Finding LCS length
        
        int[][] dp = new int[l1+1][l2+1];
        
        for(int i = 0; i < l1+1; ++i)
        {
            for(int j = 0; j < l2+1; ++j)
            {
                if(i == 0 || j == 0)dp[i][j] = 0;
            }
        }
        
        for(int i = 1; i < l1+1; ++i)
        {
            for(int j = 1; j < l2+1; ++j)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        int NumberOfDeletions = l1 - dp[l1][l2];
        int NumberOfInsertions = l2 - dp[l1][l2];
        
        return NumberOfInsertions + NumberOfDeletions;
    }
}
