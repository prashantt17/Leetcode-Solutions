class Solution {
    public void wiggleSort(int[] nums) {
        
    Arrays.sort(nums);
        int[] ans=new int[nums.length];
        int j=nums.length-1;
        for(int i=1;i<nums.length;i+=2){
            ans[i]=nums[j--];
        }
        for(int i=0;i<nums.length;i+=2){
            ans[i]=nums[j--];
        }
        for(int i=0;i<ans.length;i++){
            nums[i]=ans[i];
        }
    }
}
