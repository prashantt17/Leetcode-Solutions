class Solution {
    public int search(int[] nums, int target) {
        
       int pivot = nums.length>1?find(nums):0;
        
         int left = binarySearcH(nums,0,pivot,target);
         int right = binarySearcH(nums,pivot+1,nums.length-1,target);
        
        return Math.max(left,right);
    }
    
    
    public int find(int[] a){
        int n = a.length;
        int l=0,hi=n-1;
        int ans=0;
        while(l<=hi){
            int mid =  (l+hi)/2;
            if(mid>0 && mid<n-1 && a[mid-1]<a[mid] && a[mid]>a[mid+1]){
                ans = mid;
                break;
            }
            if(mid==0 && mid+1<n && a[mid]>a[mid+1] && a[mid]>a[n-1]){
                 ans = mid;
                break;
            }
            if(mid==n-1 && mid-1>=0 && a[mid]>a[mid-1] && a[mid]>0){
                ans = mid;
                break;
            }
            if(a[n-1]<a[mid])l=mid+1;
            else hi=mid-1;
        }
        return ans;
    }
    
    
    public int binarySearcH(int[] a,int  l,int hi,int target){
        
        while(l<=hi){
            int mid=(l+hi)/2;
            if(a[mid]==target)return mid;
            
            if(a[mid]>target)hi=mid-1;
            else l=mid+1;
        }
        return -1;
    }

        
    
}
