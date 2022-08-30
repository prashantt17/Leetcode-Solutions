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
    public TreeNode recoverFromPreorder(String traversal) {
        int val = 0;
        int right = 0;
        while (right < traversal.length() && traversal.charAt(right) != '-') {
            val = val * 10 + traversal.charAt(right) - '0';
            right++;
        }
        TreeNode root = new TreeNode(val);
        if (right == traversal.length()) {
            return root;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int left = right;
        while (left < traversal.length()) {
            int dashes = 0;
            while (traversal.charAt(right) == '-') {
                dashes++;
                right++;
            }
            left = right;
            int sum = 0;
            while (right < traversal.length() && traversal.charAt(right) != '-') {
                sum = sum * 10 + traversal.charAt(right) - '0';
                right++;
            }
            TreeNode node = new TreeNode(sum);
            left = right;
            
            while (stack.size() - dashes > 0) {
                stack.pop();
            }
            TreeNode top = stack.peek();
            if (top.left == null) {
                top.left = node;
            } else {
                top.right = node;
            }
            stack.push(node);
        }
        return root;
    }
}
