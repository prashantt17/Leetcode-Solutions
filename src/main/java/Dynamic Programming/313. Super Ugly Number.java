class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k=primes.length;
        
        int pointer[]=new int[k];
        int dp[]=new int[n];
        dp[0]=1;
        
        for(int i=1;i<n;i++)
        {
            long min=Integer.MAX_VALUE;
            
            for(int j=0;j<k;j++)
            min=Math.min(min,(long)primes[j]*dp[pointer[j]]);
            
            dp[i]=(int)min;
            
            for(int j=0;j<k;j++)
            {
                if((primes[j]*dp[pointer[j]])==min)
                pointer[j]+=1;
            }
            
        }
        
        return dp[n-1];
    }
}
