class Solution {
    public boolean isMonotonic(int[] nums) {
        int i = 0, count1 = 1, count2 = 1;
        while(i<nums.length-1){
            if(nums[i+1] >= nums[i]){
                count1++;
            }
            if(nums[i+1] <= nums[i]){
                count2++;
            }
            i++;
        }
        return (count1 == nums.length) || (count2 == nums.length);
    }
}
