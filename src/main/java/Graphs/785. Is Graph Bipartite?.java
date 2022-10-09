class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited=new int[graph.length];
        Arrays.fill(visited,-1);
        for(int i=0;i<graph.length;i++){
            if(visited[i]!=-1) continue;
            visited[i]=1;
            if(dfs(i,visited,graph)==false) return false;
        }
        return true;
    }
    public boolean dfs(int node,int[] visited,int[][] graph){
        for(int i:graph[node]){//dfs
            if(visited[i]!=-1){
              if(visited[i]==visited[node]) return false;  
                continue;
            }
            visited[i]=visited[node]==1?0:1;
            if(dfs(i,visited,graph)==false) return false;
        }
        return true;
    }
}
