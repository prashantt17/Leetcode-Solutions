class Solution {
    int[][]dir = {{1,0} , {0,1} , {-1,0}, {0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        if(matrix==null)return 0;
        if(n==0 || m==0)return 0;
        int dp[][] = new int[n][m];
        int max = 0;
        for(int i =0 ; i<n ; i++){
            for(int j = 0;j<m;j++){
                int len = helper(i , j , matrix , dp , n , m);
                max = Math.max(max , len);
            }
        }
        return max;
    }
    public int helper(int i , int j  , int[][]matrix , int[][]dp , int n , int m){
        if(dp[i][j]>0)return dp[i][j];
        int curlen = 1;
        for(int d = 0;d<dir.length ;d++){
            int r = i+dir[d][0];
            int c = j+dir[d][1];
            if(r>=0 && c>=0 && r<n && c<m && matrix[r][c]>matrix[i][j]){
                curlen = Math.max(curlen , 1+helper(r, c, matrix, dp , n, m));
            }
        }
        dp[i][j] = curlen;
        return curlen;
        
    }
}
