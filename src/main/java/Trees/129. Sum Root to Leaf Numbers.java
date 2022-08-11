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
	public int sumNumbers(TreeNode root) {
		return getCalSum(root, 0);
	}

	private int getCalSum(TreeNode root, int sum) {
		if (null == root) {
			return 0;
		}
		sum = (sum * 10) + root.val;
		if (root.left == null && root.right == null) {
			return sum;
		}
		return getCalSum(root.left, sum) + getCalSum(root.right, sum);
	}

}
