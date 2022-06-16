/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Input: root = [3,1,4,null,2], k = 1
Output: 1

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

*/

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
    public int kthSmallest(TreeNode root, int k) {
    
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        helper(root, list);
        int min = list.get(k-1);
        
        return min;
    }
    
    
    public void helper (TreeNode root, ArrayList<Integer> list) {
      
        if (root == null) {
            return;
        }
       
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
        
        
    }
}
