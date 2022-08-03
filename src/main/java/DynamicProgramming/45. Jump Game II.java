class Solution {
    public int jump(int[] nums) {
        int reach = 0, next = 0;
        int max = 0;
        for(int i = 0 ; i < nums.length; i++){            
            if(i > reach){
                max++;
                reach = next;
            }
            next = Math.max(next, nums[i] + i);
        }
        
        return max;
         
    }
}
