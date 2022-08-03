class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1  && (nums[0] == 0  || nums[0]== 1)) return true;
      
        int reachable = 0 ;
		for (int i = 0; i < nums.length; i++) {
		
            if (reachable < i) return false;
        
            if (nums[i] == 0) continue;
            reachable = Math.max(reachable, i+nums[i]);
		}

		return true;
            
        
    }
}
