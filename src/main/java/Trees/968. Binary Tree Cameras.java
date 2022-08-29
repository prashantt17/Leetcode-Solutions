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
    int count =0;
    public int minCameraCover(TreeNode root) {
        return helper(root)==0 ? count+1: count;
        
    }
    
    public int helper(TreeNode node){
        
        if(node == null) {
            return 1;
        }
        
        int left = helper(node.left);
        int right = helper(node.right);
        
        if(left == 0  || right == 0){
            count++;
            return 2;
        } else if(left == 2 || right == 2) {
          return 1;  
        } else {
            return 0;
        }
        
    }
}
