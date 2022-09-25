class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        int left = 0;
        int right = 0;
        
        int[] result = new int[nums.length - k + 1];
        int resultIdx = 0;
        
        while (right < nums.length) {
            while (!dq.isEmpty() && nums[right] > nums[dq.getLast()]) dq.removeLast();
            
            dq.offer(right);
            
            if (left > dq.getFirst()) dq.removeFirst();
            
            if (right + 1 >= k) {
                result[resultIdx] = nums[dq.getFirst()];
                resultIdx++;
                left++;
            }
            
            right++;
        }
        
        return result;
    }
}
