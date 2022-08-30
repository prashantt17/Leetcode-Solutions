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
    int max=0;
    public int heightTree(TreeNode root)
    {
        if(root==null)
            return 0;
        int lh=(heightTree(root.left)); 
        int rh=(heightTree(root.right));
        max=Math.max(max,lh+rh);
        return 1 + Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        heightTree(root);
        return max;
        
    }
}
