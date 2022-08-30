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
class util{
    int min;
    int max;
    int maxsum;
    boolean isbst;
    
    util(){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        maxsum = 0;
        isbst = false;
    }
}



class Solution {
    
    int res =0;
    
    public int maxSumBST(TreeNode root) {
        helper(root);
        return res;
    }
    
    public util helper(TreeNode root) {
        if(root == null){
            util obj = new util();
            obj.isbst = true;
            return obj;
        }
        
        util left = helper(root.left);
        util right = helper(root.right);
        
        util curr = new util();
        curr.isbst = (left.isbst && right.isbst) && root.val > left.max && root.val < right.min;
          
        curr.max = Math.max(root.val,right.max);
        curr.min = Math.min(root.val,left.min);  
        
        if(curr.isbst == true){          
            curr.maxsum = root.val+left.maxsum+right.maxsum;
            res = Math.max(res,curr.maxsum);
        }
        
        else{
            curr.maxsum = Math.max(left.maxsum,right.maxsum);
            res = Math.max(res,curr.maxsum);
        }            
        
        return curr;
    }
}
