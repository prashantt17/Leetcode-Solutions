/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        
        int[] maxSum = new int[1];
        maxSum[0]=Integer.MIN_VALUE;
        helper(root, maxSum);
        return maxSum[0];
    }
    
    private int helper(TreeNode root, int[] maxSum) {
        if(root==null) {
            return 0;
        }
        int left = helper(root.left, maxSum);
        int right = helper(root.right, maxSum);
        if(left < 0) {
            left = 0;
        }
            
        if(right < 0) {
            right = 0;
        }
            
        int currSum = left+right+root.val;
        maxSum[0]=Math.max(maxSum[0], currSum);
        return Math.max(left, right) + root.val;
    
    }
}
