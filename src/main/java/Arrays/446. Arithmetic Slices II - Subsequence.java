class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[nums.length];
        for(int i=0; i<nums.length; i++) {
            maps[i] = new HashMap<>();
            int num = nums[i];
            for(int j=0; j<i; j++) {
                if((long)num-nums[j]>Integer.MAX_VALUE) continue;
                if((long)num-nums[j]<Integer.MIN_VALUE) continue;
                int diff = num - nums[j];
                int count = maps[j].getOrDefault(diff, 0);
                maps[i].put(diff, maps[i].getOrDefault(diff,0)+count+1);
                res += count;
            }
        }
        return res;
    }
}
