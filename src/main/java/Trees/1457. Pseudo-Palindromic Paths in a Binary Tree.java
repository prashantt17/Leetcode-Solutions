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
	int[] arr = new int[10];
	public int pseudoPalindromicPaths (TreeNode root) {
      
        helper(root);
        return ans;
    }
    private void helper(TreeNode node){
        if(node == null)return ;
	    arr[node.val]++;
	    if(node.left == null && node.right == null){
            
		    int count = 0;
            for(int i = 1; i <= 9; i++){
                count += arr[i]%2;
            }
         
           if(count == 1 || count == 0)ans++;
        }
        helper(node.left);
		 helper(node.right);
		arr[node.val]--;
    }
}
