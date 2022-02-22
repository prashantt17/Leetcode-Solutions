/*

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

 
Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

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
