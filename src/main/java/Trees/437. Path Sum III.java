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
    public int pathSum(TreeNode root, int targetSum) {
         if(root == null) {
            return 0;
        }
        
        long ts = Long.valueOf(targetSum);
        return pathSumUtil(root, ts, false);
    }
    
    static int pathSumUtil(TreeNode root, long targetSum, boolean using) {
        if(root == null) {
            return 0;
        }

        int totalPaths = 0;
        if(root.val == targetSum) {
            totalPaths++;
        }

        int useRootLeft = pathSumUtil(root.left, targetSum - root.val, true);
        int useRootRight = pathSumUtil(root.right, targetSum - root.val, true);

        int dontUseRootLeft = 0;
        int dontUseRootRight = 0;
        if(!using) {
            dontUseRootLeft = pathSumUtil(root.left, targetSum, false);
            dontUseRootRight = pathSumUtil(root.right, targetSum, false);
        }

        totalPaths = totalPaths + useRootLeft + useRootRight + dontUseRootLeft + dontUseRootRight;

        return totalPaths;
    }
}
