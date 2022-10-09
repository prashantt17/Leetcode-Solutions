class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = convertMatToAdj(graph);
        int[] visited = new int[graph.length];
        for(int i = 0; i < graph.length; i++) visited[i] = 0;
        int[] path_visited = new int[graph.length];
        for(int i = 0; i < graph.length;i++) path_visited[i] = 0;
        int[] check = new int[graph.length];
        for(int i = 0; i < graph.length;i++) check[i] = 0;
        for(int i = 0;i<graph.length; i++){
            if(visited[i] == 0){
                dfs(i, visited, path_visited, check, adj);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();        
        for(int i =0;i<check.length; i++){
            if(check[i] == 1)
                result.add(i);
        }
        return result;
    }
    
    private boolean dfs(int node, int[] visited, int[] path_visited, int[] check, ArrayList<ArrayList<Integer>> adj ){
        visited[node] = 1;
        path_visited[node] = 1;
        check[node] =0;
        
        for(int i : adj.get(node)){
            if(visited[i] == 0){
                if(dfs(i, visited, path_visited, check, adj) == true)
                    return true;
            }else if(path_visited[i] == 1){
                return true;
            }
        }
        
        path_visited[node] = 0;
        check[node] = 1;
        
        return false;
    }
    
    private ArrayList<ArrayList<Integer>> convertMatToAdj(int[][] graph){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<graph.length; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j =0;j<graph[i].length; j++){
                temp.add(graph[i][j]);
            }
           result.add(temp); 
        }        
        return result;
    }
}
