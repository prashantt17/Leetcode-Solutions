class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int diff = Integer.MAX_VALUE;
        int [] ans = new int[2];
        ans[0] = 0;
        ans[1] = Integer.MAX_VALUE;
        int len = nums.size();
        int index[] = new int[len];
        int sizes[] = new int[len];
        for(int i = 0; i < len; i++) {
            sizes[i] = nums.get(i).size();
        }
        int min = Integer.MAX_VALUE,max = Integer.MAX_VALUE;
        List<Integer> minIndex;
        boolean flag = true;
        while(flag == true) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for(int i = 0; i < len; i++) {
                if(index[i] >= sizes[i]) {
                    flag = false;
                    return ans;
                }
                if(min >= nums.get(i).get(index[i])) {
                    min = nums.get(i).get(index[i]);
                }
                if(max < nums.get(i).get(index[i])) {
                    max = nums.get(i).get(index[i]);
                }

            }
            for(int i = 0; i < len; i++) {
                if(index[i] < sizes[i] && nums.get(i).get(index[i]) == min) {
                    index[i] = index[i]+1;
                }
            }
            
            
            if(max-min < ans[1]-ans[0]) {
                ans[0] = min;
                ans[1] = max;
            }
            
        }
        return ans;
    }
}
