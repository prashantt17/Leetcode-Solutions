class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % k != 0) return false;
        
        int used = 0;
        int target = sum/k;
        
        return backtrack(k, 0, nums, 0, used, target);
    }
    
    HashMap<Integer, Boolean> memo = new HashMap<>();
    
    public boolean backtrack(int k, int bucket, 
                             int[]nums, int start, int used, int target) {
        // base case, all buckets have equal sums
        if (k == 0) return true;
        
        if (bucket == target) {
            // fulfill current bucket, next bucket choose num start at nums[0]
            boolean res = backtrack(k-1, 0, nums, 0, used, target);
            // save result into memo
            memo.put(used, res);
            return res;
        }
        
        // avoid duplicate
        if (memo.containsKey(used)) return memo.get(used);
        
        for (int i = start; i < nums.length; i++) {
            // if i equal to 1, nums[i] already put into other bucket
            if (((used >> i) & 1) == 1) continue;
            
            if (nums[i] + bucket > target) continue;
            
            used |= 1 << i;
            bucket += nums[i];
            if (backtrack(k, bucket, nums, i+1, used, target)) return true;
            
            used ^= 1 << i;
            bucket -= nums[i];
        }
        
        return false;
    }
}
