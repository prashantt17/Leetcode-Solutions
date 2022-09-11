class Solution {
    public int findCircleNum(int[][] isConnected) {
         int v=isConnected.length;
        boolean []visited=new boolean[v];
        int cnt=0;
        for(int i=0;i<v;i++){
            if(visited[i]==false){
                 dfs(isConnected,visited,i);
                cnt++;
            }
           
        }
        return cnt;
    }
    
    public void dfs(int[][]graph,boolean[]visited,int s){
        visited[s]=true;
        for(int i=0;i<graph[0].length;i++){
            if(graph[s][i]==1&&visited[i]==false){
                dfs(graph,visited,i);
            }
        }
    
    
    }
}
