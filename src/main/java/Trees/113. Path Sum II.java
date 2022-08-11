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
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null) return result;
		List<Integer> r;

		dfs(root, targetSum, result, new ArrayList<>());
		return result;
	}

	public void dfs(TreeNode root, int t, List<List<Integer>> result, List<Integer> r) {

		r.add(root.val);

		if (root.left == null && root.right == null && t == root.val) {
			result.add(new ArrayList<Integer> (r));
			return;
		}
		if (root.left == null && root.right == null) return;

		if (root.left != null) {
			dfs(root.left, t - root.val, result, r);
			r.remove(r.size() - 1);
		}
		if (root.right != null) {
			dfs(root.right, t - root.val, result, r);
			r.remove(r.size() - 1);
        }
		}
	}
