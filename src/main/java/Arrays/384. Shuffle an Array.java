class Solution {

    private int []nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        int n = nums.length;
        int [] res = new int[n];
        res = nums.clone();
        //  The idea is simple we just need to get random index of the array between (i , n-i)
		// and then we will just swap and will return the shuffled array.
        for(int i = 0 ; i < n ; i++){
            int rand = (int)(Math.random()*(n - i)) + i;
            swap(res, i, rand);
        }
        return res;        
    }
    public void swap(int []nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }   
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
