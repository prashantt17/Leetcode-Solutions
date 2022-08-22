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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
	HashMap<Integer, Integer> inorder_map = populate_map(inorder);
	int[] pre_index = { 0 };
	return construct_tree(preorder, inorder_map, 0, inorder.length - 1, pre_index);

}

private HashMap<Integer, Integer> populate_map(int[] inorder) {
	HashMap<Integer, Integer> map = new HashMap<>();
	for (int i = 0; i<inorder.length; i++) {
		map.put(inorder[i], i);
	}
	return map;
}

private TreeNode construct_tree(int[] preorder, HashMap<Integer, Integer> inorder_map, int start, int end, int[] pre_index) {
	if (start > end)
		return null;

	TreeNode root = new TreeNode(preorder[pre_index[0]]);
	int index = inorder_map.get(preorder[pre_index[0]]);
	pre_index[0]++;

	root.left = construct_tree(preorder, inorder_map, start, index - 1, pre_index);
	root.right = construct_tree(preorder, inorder_map, index + 1, end, pre_index);
	return root;
}
}
