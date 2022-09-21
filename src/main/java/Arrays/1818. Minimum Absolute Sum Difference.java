class Solution {
    private static final int M = 1_000_000_000 + 7;
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] copy = Arrays.copyOfRange(nums1, 0, n);
        Arrays.sort(copy);
        
        long diffSum = 0;
        for(int i = 0; i < n; i += 1) {
            diffSum += Math.abs(nums1[i] - nums2[i]);
        }
        
        if(diffSum == 0) return 0;
        
        long minDiffSum = diffSum;
        
        for(int i = 0; i < n; i += 1) {
            
            int diff = Math.abs(nums1[i] - nums2[i]); 
            int index = lowerBound(copy, nums2[i]);
            diffSum -= diff;
			
            int firstClosest = copy[Math.min(index, n - 1)], secondClosest = copy[Math.max(0, index - 1)];
            
            int diff1 = Math.abs(nums2[i] - firstClosest);
            int diff2 = Math.abs(nums2[i] - secondClosest);
            int newCorrDiff = diff1 < diff2 ? Math.abs(firstClosest - nums2[i]) :
                                                Math.abs(secondClosest - nums2[i]);
            diffSum += newCorrDiff;
            minDiffSum = Math.min(minDiffSum, diffSum);

            diffSum -= newCorrDiff;
            diffSum += diff;
        }
        return (int)(minDiffSum % M);
    }
    
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}
