class Solution {
    
    public int maxValue(int n, int index, int maxSum) {
        if(n==1) return maxSum;
        if(maxSum==n) return 1;
        int l=1,r=maxSum;
        int ans=0;
        while(l<=r){
            long mid=l+(r-l)/2;
            if(check(mid,n,index,maxSum)){
                ans=(int)mid;
                l=(int)mid+1;
            }
            else
                r=(int)mid-1;
        }
        return ans;
    }
    public boolean check(long mid, int n, int index, int max){
        long sum=((mid*(mid+1))/2 ) + ((mid*(mid-1))/2);
        if((n-(mid+index))>=1) sum+=(n-(mid+index));
        if(!(index-mid <0)) sum+=((index-mid +1));
        long left=mid-index-1;
        long right=mid-(n-index-1)-1;
        if(left>0) sum-=((left*(left+1))/2 );
        if(right>0) sum-=((right*(right+1))/2);
        return (sum)<=max;
    }
}
