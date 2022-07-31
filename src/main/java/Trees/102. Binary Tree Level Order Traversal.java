/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []

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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> levelOrderTraversal = new ArrayList<List<Integer>>();
		List<Integer> currentLevel = new ArrayList<Integer>();
		Queue<TreeNode> queue =  new LinkedList<TreeNode>();

		if(root != null)
		{
			queue.add(root);
			queue.add(null);
		}

		while(!queue.isEmpty())
		{
			TreeNode queueRoot = queue.poll();
			if(queueRoot != null)
			{
				currentLevel.add(queueRoot.val);
				if(queueRoot.left != null)
				{
					queue.add(queueRoot.left);
				} 
				if(queueRoot.right != null)
				{
					queue.add(queueRoot.right);
				}
			}
			else
			{
				levelOrderTraversal.add(currentLevel);
				if(!queue.isEmpty())
				{
					currentLevel = new ArrayList<Integer>();
					queue.add(null);
				}
			}
		}

		return levelOrderTraversal;
    }
}
