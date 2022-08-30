class Solution {
     static int mod = 1000000007;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        List<Integer> num = new ArrayList<Integer>();
        
        for(int i : nums){
            num.add(i);      
        }
        
        long dp[][] =new long[n+1][n+1];
        buildDp(dp,n);
        return (int)(helper(num,dp) % 1000000007)-1;
        
        
    }
    
    public long helper(List<Integer> nums , long dp[][]){
        if(nums == null || nums.size() <= 2) return 1;
        
        
        int root = nums.get(0);
        List<Integer> lessThan = new ArrayList<>();
        List<Integer> greaterThan = new ArrayList<>();
        
        for(int val : nums){
            if(val > root){
                greaterThan.add(val);
            } else if(val < root){
                lessThan.add(val);
            }
        }
        
        return ((((dp[lessThan.size() + greaterThan.size()][greaterThan.size()])%mod) * helper(lessThan,dp))%mod * helper(greaterThan,dp))%mod;
    }

    
    public void buildDp(long dp[][],int n){
        for(int i =0 ; i < n+1;i++){
            
            dp[i][0]=1;
            dp[i][i]=1;
            dp[i][1]=i;
            if (i>0)
            dp[i][i-1]=i;
        }
        
        for(int i =4; i < n+1 ;i++){
            for(int j =2 ; j<i;j++){
                dp[i][j]=((dp[i-1][j]%mod)+(dp[i-1][j-1]%mod))%mod;
            }
        }
        
    }
}
