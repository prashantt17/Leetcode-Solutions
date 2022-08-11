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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> wrapList = new ArrayList<>();
        
        if(root == null) return wrapList;
        
        q.add(root);
        boolean leftToRight = true;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            List<Integer> subList = new ArrayList<>();
        
            while(size > 0) {
                TreeNode curr = q.poll();
                subList.add(curr.val);
                size--;
                
                if(curr.left != null) {
                    q.add(curr.left);
                }
                
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            if(leftToRight) {
                
            }
            else {
                Collections.reverse(subList);
            }
            wrapList.add(subList);
            leftToRight = !leftToRight;
        }
        return wrapList;
    }
}
