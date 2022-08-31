/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
public String serialize(TreeNode root) {
    if(root==null) return "";
    StringBuilder sb=new StringBuilder();
    dfs(root,sb);
    return sb.toString().trim();
}
public void dfs(TreeNode root,StringBuilder sb){
    if(root==null){
        return;
    }
    sb.append(root.val+" ");
    dfs(root.left,sb);
    dfs(root.right,sb);
}

public TreeNode deserialize(String data) {
    if(data.length()==0) return null;
    String s[]=data.split(" ");
    return constructBST(s,0,s.length-1);
}
public TreeNode constructBST(String s[],int start,int end){
    if(start>end) return null;
    TreeNode root=new TreeNode(Integer.parseInt(s[start]));
    int index;
    for(index=start;index<=end;index++){
        if(Integer.parseInt(s[index])>Integer.parseInt(s[start])){
            break;
        }
    }
    root.left=constructBST(s,start+1,index-1);
    root.right=constructBST(s,index,end);
    return root;

}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
