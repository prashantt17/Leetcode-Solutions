class Solution {
    public int findMin(int[] nums) {
         if(nums[0] <= nums[nums.length-1]){
            return nums[0];
        }
        return nums[binarySearch(nums, 0, nums.length-1)];
    }

    public int binarySearch(int[] nums, int start, int stop){
        if(nums[start] <= nums[stop]){
            return -1;
        }
        else if(stop - start == 1){
            return stop;
        }
        else{
            int mid = ((stop-start)/2)+start;
            return Math.max(binarySearch(nums, start, mid), binarySearch(nums, mid, stop));
        }
    }
}
