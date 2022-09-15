class Solution {
     private boolean isPossible(int []nums, int maxOperations, int mid) {
        int numberOfOperations = 0;
          for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= mid) {
              if(nums[i] % mid == 0) {
                numberOfOperations += nums[i]/mid - 1;
              }
              else {
                numberOfOperations += nums[i]/mid;
              }
            }
        }
          
        return (numberOfOperations <= maxOperations);
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int start = 1;
        int end = 0;
        for(int i = 0; i < nums.length; i++) {
          end = Math.max(nums[i],end);
        }
        int ans = end;
        while(start <= end) {
          int mid = start + (end - start)/2;
          if(isPossible(nums,maxOperations,mid)) {
            ans = mid;
            end = mid - 1;
          }
          else {
            start = mid + 1;
          }
        }
      return ans;
    }
}
