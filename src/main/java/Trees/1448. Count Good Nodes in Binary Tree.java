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
    int cnt = 0;
    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return cnt; 
    }

    private void helper(TreeNode root, int max) {
        if (root != null) {
            if (root.val >= max) { 
                cnt++; 
            }
            helper(root.left, Math.max(root.val, max));
            helper(root.right, Math.max(root.val, max));
        }
    }
}
