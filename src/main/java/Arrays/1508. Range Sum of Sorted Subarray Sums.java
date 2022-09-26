class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int index = 0;
        int[] sums = new int[n*(n+1)/2];
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum = sum + nums[j];
                sums[index++] = sum;
            }
        }
        int res=0,mod=1000000007;
        Arrays.sort(sums);
        for(int i=left-1;i<right;i++) 
            res = (res+sums[i])%mod; 
        return res;
    }
}
