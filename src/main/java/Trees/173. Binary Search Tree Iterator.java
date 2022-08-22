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
class BSTIterator {
  Deque<TreeNode> stack;
  TreeNode currentNode;
  
  public BSTIterator(TreeNode root) {
    stack = new ArrayDeque<>();
    leftmost(root);
  }
  
  private void leftmost(TreeNode node) {
    if(node == null) {
      return;
    }
    
    Deque<TreeNode> temp = stack;
    
    while(node.left != null) {
      stack.addFirst(node);
      node = node.left;
    }
    
    stack.addFirst(node);
  }

  public int next() {
    TreeNode node = stack.removeFirst();

    leftmost(node.right);
    
    return node.val;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
