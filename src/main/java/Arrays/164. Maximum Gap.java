class Solution {
    public int maximumGap(int[] nums) {
        int min = nums[0], max = nums[0];
        for(int num : nums){
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        
        int interval = (int)Math.ceil((double)(max-min)/(nums.length-1));
        int[] minBucket = new int[nums.length-1];
        int[] maxBucket = new int[nums.length-1];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
       Arrays.fill(maxBucket, Integer.MIN_VALUE);
        
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == min || nums[i] == max) continue;
      int bucketNumber = (nums[i] - min) / interval;
            minBucket[bucketNumber] = Math.min(minBucket[bucketNumber], nums[i]);
            maxBucket[bucketNumber] = Math.max(maxBucket[bucketNumber], nums[i]);
        }
        int previous = min; 
        int maxGap = 0;
        for(int i = 0; i < minBucket.length; ++i){
            if(minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE){
                continue;
            }
            
            if(maxGap < (minBucket[i] - previous)){
                maxGap = minBucket[i] - previous;
            }
            previous = maxBucket[i];
        }
        maxGap = Math.max(max - previous, maxGap);
        
        return maxGap;
    }
}
