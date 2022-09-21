class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int i = 0;
        int j = 0;
        int res = 0;
        while(j<nums.length)
        {
            sum+=nums[j];
            while((nums[j]*(j - i + 1)) - sum > k)
            {
                sum-=nums[i];
                i++;
            }
            res = Math.max(res, j - i +1);
            j++;
        }
        return res;
    }
}
