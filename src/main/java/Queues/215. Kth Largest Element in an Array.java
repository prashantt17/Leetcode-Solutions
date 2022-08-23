class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        
        for(int i=k;i<nums.length;i++){
            int val = nums[i];
            if(val > pq.peek()){
                pq.remove();
                pq.add(val);
            }
        }
        
        return pq.remove();
    }
}
