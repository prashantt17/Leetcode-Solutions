class Solution {
    public int threeSumClosest(int[] nums, int target) {
         Arrays.sort(nums);
        int res = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            int lo = i+1, hi = nums.length-1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi] + nums[i];
                if (sum < target) {
                    lo++;
                }
                else if (sum == target) {
                    return target;
                }
                else {
                    hi--;
                }

                if (Math.abs(sum - target) < diff) {
                    res = sum;
                    diff = Math.abs(sum - target);
                }
            }
        }

        return res; 
    }
}
