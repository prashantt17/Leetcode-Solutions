class Solution {
    double prob = 0.0;
    public double frogPosition(int n, int[][] edges, int t, int target) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int edge[] : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        
        dfs(graph, 0, 1, t, target, 1.0, new HashSet<>());
        
        return prob;
        
    }
    
    boolean dfs(Map<Integer, List<Integer>> graph, int curT, int cur, int t, int target, double prob, Set<Integer> visited) {
        if(visited.contains(cur))
            return false;
        visited.add(cur);
        if(curT > t)
            return false;
        
        if(cur == target) {
            if(curT == t || (!graph.containsKey(cur) || visited.containsAll(graph.get(cur)))) {
                this.prob = prob;
                return true;
            }    
        }
        
        if(!graph.containsKey(cur))
            return false;
        int ns = cur == 1 ? graph.get(cur).size() : graph.get(cur).size() - 1;
        double p = prob* (1.0/ns);
        for(int nei : graph.get(cur)) {
            
            if(dfs(graph, curT + 1, nei, t, target, p, visited))
                return true;
        }
       return false; 
        
    }
}
