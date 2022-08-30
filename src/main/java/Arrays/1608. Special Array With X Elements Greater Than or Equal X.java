class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length ;
        int count = 0 ;
        while(n >0){
            count = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] >= n){
                count ++;
            }
         }
        if(count == n){
         return n ;
          }
       n--;
    }
        return -1;
    }
}
