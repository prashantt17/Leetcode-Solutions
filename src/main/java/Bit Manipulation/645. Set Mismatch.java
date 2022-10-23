class Solution {
    public int[] findErrorNums(int[] nums) {
        int l = nums.length;
        int [] v = new int[l];
        int [] b = new int[2];
        for(int i=0;i<l;i++){
            if(v[nums[i]-1]!=0){
                b[0]=nums[i]; 
            }
            else{
                v[nums[i]-1]++;
            }
        }
        for(int i=0;i<l;i++){
            if(v[i]==0){
                b[1]=i+1;
                return b;
            }
        }
        return b;
    }
}
