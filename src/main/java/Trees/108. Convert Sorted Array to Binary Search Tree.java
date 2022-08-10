class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
       TreeNode node = null;
        int start = 0 ;
        int end = nums.length - 1;
        node = constructTree (nums, start, end);
        return node;
    }
    
    private TreeNode constructTree (int[] nums, int start, int end) {
        
        if (start > end) return null;
        
        int mid = start +(end - start) / 2;
        TreeNode temp = new TreeNode(nums[mid]);
        
        temp.left = constructTree(nums, start, mid-1);
        temp.right = constructTree(nums, mid+1, end);
        
        return temp;
     
    }
}
