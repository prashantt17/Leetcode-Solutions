class Solution {
    public static final int MOD = (int)Math.pow(10,9)+7;
    public int waysToSplit(int[] nums) {
        int sum = 0;
        for (int num: nums)
            sum+=num;
        long result = 0;
        int len = nums.length;
        int[] prefixSum = new int[len];
        prefixSum[0]=nums[0];
        for(int i =1; i <len -1; i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
            if (2*prefixSum[i]-sum <= prefixSum[i]/2){
                int low = 0, high = i-1;
                while(low <= high){
                    int mid = low + (high - low)/2;
                    if (prefixSum[mid] >= 2*prefixSum[i]-sum)
                        high=mid-1;
                    else
                        low=mid+1;
                }
                int left = low;
                low=0; high = i-1;
                while(low <= high){
                    int mid = low +(high - low)/2;
                    if (prefixSum[mid] > prefixSum[i]/2)
                        high = mid -1;
                    else
                        low = mid +1;
                }
                int right = high;
                result = (result +(right - left + 1))%MOD;
            }
        }
        return (int)result;
    }
}
