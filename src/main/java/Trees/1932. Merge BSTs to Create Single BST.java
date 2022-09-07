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
int finalTreeCount = 0;  

	public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> rootMap = new HashMap<>(); 
        Map<Integer, TreeNode> leafMap = new HashMap<>();
        int count = 0; 
        for (TreeNode x : trees) {
            count++;
            rootMap.put(x.val, x);
            if (x.left != null) {
                count++;
                leafMap.put(x.left.val, x.left);
            }
            if (x.right != null) {
                count++;
                leafMap.put(x.right.val, x.right);
            }
        }
		
        TreeNode result = null;
        for (TreeNode x : trees) {
            
            if (leafMap.containsKey(x.val)) {
                count--; // decrement the count, as one node merged
                TreeNode l = leafMap.get(x.val);
                l.left = x.left;
                l.right = x.right;
            } else {
                if (result == null) {
                    result = x;
                } else {
                    return null; 
                }
            }
        }
        return (isValidBST(result) && count == finalTreeCount) ? result : null;
    }
    
    private boolean isValidBST(TreeNode x) {
        if (x == null) return false;
        
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = x;
        TreeNode prev = null;
        while(curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            finalTreeCount++;
            
            if (prev != null && prev.val >= curr.val) {
                return false;
            }
            
            prev = curr;
            curr = curr.right;
        }
        return true;
    }
}
