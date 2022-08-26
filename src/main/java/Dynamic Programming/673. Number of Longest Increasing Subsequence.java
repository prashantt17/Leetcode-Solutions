class Solution {
    public int findNumberOfLIS(int[] nums) {
     int[]lis=new int[nums.length];
    int count[]=new int[nums.length];
    Arrays.fill(lis,1);
      Arrays.fill(count,1);
    int max=1;
    for(int i=0;i<nums.length;i++){
        for(int j=0;j<i;j++){
            if(nums[i]>nums[j]&&lis[i]<lis[j]+1){
                lis[i]=lis[j]+1;
                count[i]=count[j];
            }else if(nums[i]>nums[j]&&lis[i]==lis[j]+1){
                count[i]+=count[j];
            }
        }
        max=Math.max(max,lis[i]);
    }   
    int countt=0;
  for(int i=0;i<nums.length;i++){
      if(lis[i]==max)
      {
          countt+=count[i];
          
      }
  }
    return countt;   
    }
}
