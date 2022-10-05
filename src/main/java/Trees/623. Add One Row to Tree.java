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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newNode = new TreeNode(val);
            newNode.left =root;
            return newNode;
        }
        Queue<TreeNode> q =new LinkedList<>();  
        Queue<TreeNode> prev =new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty() && depth>1){
            
            TreeNode front = q.poll();
            
            if(front ==null){
                if(q.isEmpty()){
                    break;
                }
                q.add(front);
                depth--;
            }
            
            else{
                
                if(depth-1==1){
                    prev.add(front); 
                }
                if(front.left!=null){
                    q.add(front.left);
                }
                if(front.right!=null){
                    q.add(front.right);
                }
            }
            
        }
      
        while(!prev.isEmpty()){
            
            TreeNode front = prev.poll();
            TreeNode newNodeL = new TreeNode(val);
            newNodeL.left =front.left;
            front.left=newNodeL;
            
            TreeNode newNodeR = new TreeNode(val);
            newNodeR.right = front.right;    
            front.right=newNodeR;
        }
        
        return root;
    }
}
