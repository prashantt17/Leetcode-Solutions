class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = nums[n - 1] - nums[0];
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(nums[i] + k, nums[n - 1] - k);
            int min = Math.min(nums[i + 1] - k, nums[0] + k);
            res = Math.min(res, max - min);
        }
        return res;
    }
}
