/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<List<Integer>> res= new ArrayList();
    
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null) return res;
        level(root,0); 
        return res;
    }
     public void level(Node root, int lev){
         if(res.size()<=lev) res.add(new ArrayList());
         
         res.get(lev).add(root.val);
         
         for(Node child : root.children){
             level(child,lev+1);
         }
     }
}
