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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        Queue<NodeInfo> queue= new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        
        queue.add(new NodeInfo(0,0,root));
        
        while(!queue.isEmpty())
        {   
            NodeInfo curr = queue.poll();
            TreeNode currNode = curr.node;
            int currDistance = curr.horzDist;
            int currLevel = curr.level;
            
            map.putIfAbsent(currDistance,new TreeMap<>());
            if(!map.get(currDistance).containsKey(currLevel))
            {
                map.get(currDistance).put(currLevel,new PriorityQueue<>());
            }
            
            map.get(currDistance).get(currLevel).add(currNode.val);
            
            if(currNode.left!=null)
                queue.add(new NodeInfo(currDistance-1,currLevel+1,currNode.left));
            if(currNode.right!=null)
                queue.add(new NodeInfo(currDistance+1,currLevel+1,currNode.right));
        }
        
        for(TreeMap<Integer,PriorityQueue<Integer>> entry : map.values())
        { 
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes: entry.values())
            {
              while (!nodes.isEmpty())
              {
                ans.get(ans.size()-1).add(nodes.poll()); 
              }  
            }
         
        }
        
        return ans;
        
    }
    
    class NodeInfo
    {
        int horzDist;
        int level;
        TreeNode node;
        
        NodeInfo(int horzDist, int level, TreeNode node)
        {
            this.horzDist=horzDist;
            this.level=level;
            this.node=node;
        }
    }
}
