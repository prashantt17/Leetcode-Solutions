class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            high=Math.max(high,nums[i]);
        }
        int result=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if((isPossible(nums, mid))<=threshold)
            {
                result=mid;
               high=mid-1;  
            }
            else
            {
                low=mid+1;
            }
        }
        return result;
    }
    public int isPossible(int[] nums, int threshold)
    {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
           int num=nums[i]%threshold==0?nums[i]/threshold:nums[i]/threshold+1;
            sum+=num;
        }
        return sum;
    }
}
