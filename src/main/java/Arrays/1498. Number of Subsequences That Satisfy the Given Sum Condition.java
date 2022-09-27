class Solution {
    public int numSubseq(int[] nums, int target) {
        int[]subseq=new int[nums.length+1];
        subseq[1]=1;
        int mod=(int)Math.pow(10,9)+7;
        
        for(int i=2;i<subseq.length;i++){
            subseq[i]=(2*subseq[i-1]+1)%mod;
        }
        Arrays.sort(nums);
        long res=0;
        
        for(int i=0;i<nums.length;i++){
            if(2*nums[i] <= target)
                res=(res+1)%mod;
            
            int l=i;
            int h=nums.length-1;
            
            while(l<=h){
                int mid=(l+h)/2;
                
                if(nums[mid] > target-nums[i])
                    h=mid-1;
                else
                    l=mid+1;
            }
             if(h > i)
              res=(res+subseq[h-i])%mod;
             
            
        }
        
        return (int)res;
    }
}
