class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        for(int i=0;i<len1;i++){
            int low = i;
            int high = len2-1;
            while(low<=high){
                int mid = low+(high-low)/2;
                if(nums1[i] <= nums2[mid]){
                    maxDistance = Math.max(maxDistance, mid-i);
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return maxDistance;
    }
}
