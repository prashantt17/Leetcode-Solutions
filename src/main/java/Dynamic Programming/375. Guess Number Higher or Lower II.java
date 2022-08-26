class Solution {
    public static int solve(int start, int end)
   {
     if(start>=end) return 0;
     
     int maxi=Integer.MAX_VALUE;
     for(int i=start;i<=end;i++)
     {
       maxi=Math.min(maxi,i+Math.max(solve(start,i-1),solve(i+1,end)));
     }
     return maxi; 
   }
   public static int Solve_Memo(int start, int end,int[][] dp)
   {
     if(start>=end) return 0;
     if(dp[start][end]>0) return dp[start][end];
     
     
     int maxi=Integer.MAX_VALUE;
     for(int i=start;i<=end;i++)
     {
       maxi=Math.min(maxi,i+Math.max(Solve_Memo(start,i-1,dp),Solve_Memo(i+1,end,dp)));
     }
     return dp[start][end]=maxi; 
   }
   public static int solveDP(int n)
   {
     int[][] dp=new int[n+2][n+2];
     for(int start=n;start>=1;start--)
     {
       for(int end=start;end<=n;end++)
       {
         if(start==end) continue;
         else{
           int maxi=Integer.MAX_VALUE;
           for(int i=start;i<=end;i++)
           {
              maxi=Math.min(maxi,i+Math.max(dp[start][i-1],dp[i+1][end]));
           }
          dp[start][end]=maxi; 
         }
       }
     }
     return dp[1][n];
   }
    
    public int getMoneyAmount(int n) {
        return solveDP(n);
    }
}
