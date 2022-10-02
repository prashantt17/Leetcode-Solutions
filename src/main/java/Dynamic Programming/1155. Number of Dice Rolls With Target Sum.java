class Solution {
    Long dp[][];
    public int numRollsToTarget(int n, int k, int target) {
     dp=new Long[31][1001];
     long ans=help(0,n,k,target);
     return (int)(ans%(int)(1e9+7));
    }
    
    long help(int turn,int n,int k,int target)
    {
       if(turn==n)
       {
           if(target==0)
               return 1;
           else
               return 0;
       }
       if(target<0)
           return 0;
       if(dp[turn][target]!=null)
           return dp[turn][target];
       long ans=0;
       for(int i=1;i<=k;i++)
       {
           ans+=help(turn+1,n,k,target-i)%(int)(1e9+7);
       }
       dp[turn][target]=ans;
       dp[turn][target]%=(int)(1e9+7);
       return dp[turn][target];
    }
}
