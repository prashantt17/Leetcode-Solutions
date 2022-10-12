class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();
        int len = nums.length;
        for(int i = (2*len)-1 ; i >= 0 ; i--){
            while(stack.size() != 0 && stack.peek() <= nums[i%len]){
                stack.pop();
            }
            if(i < len){
                if(stack.size() != 0){
                    ans[i%len] = stack.peek();
                }
                else{
                    ans[i%len] = -1;
                }
            }
            stack.push(nums[i%len]);
        }
        return ans;
    }
}
