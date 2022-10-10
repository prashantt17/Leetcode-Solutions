class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<Boolean>();
        for(int i = 0; i < l.length; i++) {
            res.add(isArithmeticSeq(nums, l[i], r[i]));
        }
        
        return res;
    }
    
    private boolean isArithmeticSeq(int[] nums, int start, int end) {
        if(end - start < 2) return true;
        
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<Integer>();
        for(int i = start; i <= end; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            set.add(nums[i]);
        }
        
        if((max - min) % (end - start) != 0) return false;
        int interval = (max - min) / (end -start);
        
        for(int i = 1; i <= end -start; i++) {
            if(!set.contains(min + i * interval)) return false;
        }
        
        return true;
    }
}
