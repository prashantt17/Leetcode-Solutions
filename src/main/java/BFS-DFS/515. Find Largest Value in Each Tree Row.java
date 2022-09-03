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
     ArrayList<Integer> output=new ArrayList<Integer>();
    ArrayList<Integer> temp=new ArrayList<Integer>();
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)
            return output;
        Queue<TreeNode> i=new LinkedList<TreeNode>();
        i.add(root);
        i.add(null);
        double size=0;
        double sum=0;
        while(!i.isEmpty())
        {
          TreeNode newroot=i.remove();  
            if(newroot!=null)
            {  temp.add(newroot.val);
            }
            if(newroot==null)
            {
               Collections.sort(temp);
                output.add(temp.get(temp.size()-1));
                temp.clear();
                if(!i.isEmpty())
                 i.add(null);   
            }
          else
          {
            
             if(newroot.left!=null)
             i.add(newroot.left);
            
            if(newroot.right!=null)
             i.add(newroot.right);
          }
            
        }
        return output;
        
    }
}
