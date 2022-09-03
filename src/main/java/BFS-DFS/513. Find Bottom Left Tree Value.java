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
    int ans =0; 
    int h =0;
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeft(root, 1);
        return ans;
    }
    
    public void findBottomLeft(TreeNode root,int depth){
        if(h<depth){ans = root.val; h=depth;}
        if(root.left != null){findBottomLeft(root.left , depth+1);}
        if(root.right != null){findBottomLeft(root.right , depth+1);}
    }
}
