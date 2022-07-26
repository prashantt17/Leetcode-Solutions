/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

*/


class Solution {
    
    TreeNode resultNode = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return this.resultNode;
    }
    
    public TreeNode helper(TreeNode node,TreeNode p, TreeNode q){
        if(node==null){
            return null;
        }
        
        TreeNode leftNode=helper(node.left,p,q);
        TreeNode rightNode=helper(node.right,p,q);
        if(((node==p || node==q)&&(leftNode!=null || rightNode!=null))||(leftNode!=null &&rightNode!=null)){
            this.resultNode=node;
            return node;
        }else if((leftNode!=null || rightNode!=null)||(node==p || node==q)){
            return node;
        }else{
            return null;
        }
    }
}
