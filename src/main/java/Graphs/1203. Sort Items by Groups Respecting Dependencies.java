class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, Set<Integer>> grp = new HashMap<>();
        
        int single = -1;
        
        for(int i = 0; i < n; i++) {
            if(group[i] == -1) {
                group[i] = single--;
            } 
            
            grp.putIfAbsent(group[i], new HashSet<>());
            grp.get(group[i]).add(i);
        }
    
    Map<Integer, List<Integer>> edges = new HashMap<>();
    Map<Integer, List<Integer>> innerEdges = new HashMap<>();
    
    for(int i = 0; i < beforeItems.size(); i++) {
        
        List<Integer> before = beforeItems.get(i);
        
        for(int b: before) {
            
            if(group[b] != group[i]) {
                
                if(!edges.containsKey(group[i])) {
                    edges.put(group[i], new ArrayList<>());
                }
                
               edges.get(group[i]).add(group[b]); 
                
            } else {
                
                if(!innerEdges.containsKey(i)) {
                    innerEdges.put(i, new ArrayList<>());
                }
                
                innerEdges.get(i).add(b);
            }
        }
    }
        
        Deque<Integer> order = new ArrayDeque<>();
        Set<Integer> traversed = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        
        for(int node: grp.keySet()) {
            if(!traversed.contains(node)) {
                if(!topoSort(edges, node, order, traversed, visited))
                    return new int[]{};
            }
        }
        
        Map<Integer, Deque<Integer>> innerList = new HashMap<>();
        
        int[] ans = new int[n];
        traversed.clear();
        visited.clear();
        
        for(int node: innerEdges.keySet()) {
            
            if(!innerList.containsKey(group[node])) {
                innerList.put(group[node], new ArrayDeque<>());
            }
            
            if(!traversed.contains(node)) {
                
                if(!topoSort(innerEdges, node, innerList.get(group[node]), traversed, visited))
                    return new int[]{};
            }
            
        }
        
        int x = 0;
        
        while(!order.isEmpty()) {
            int g = order.poll();
            int y = 0;
            
            if(innerList.containsKey(g)) {
                
                while(!innerList.get(g).isEmpty()) {
                    ans[x] = innerList.get(g).poll();
                    grp.get(g).remove(ans[x]);
                    x++;
                }
            }
            
            for(int i: grp.get(g)) {
                ans[x++] = i;
            }
        }
        
        return ans;
        
        
}
    
    private boolean topoSort(Map<Integer, List<Integer>> edges, int node, Deque<Integer> order, Set<Integer> traversed, Set<Integer> visited) {
        
        if(traversed.contains(node))
            return true;
        
        if(visited.contains(node))
            return false;
        
        visited.add(node);
        
        if(edges.containsKey(node)) {
            
          for(int i: edges.get(node)) {
              
            if(!topoSort(edges, i, order, traversed, visited))
                return false;
          }  
        }
        
        
        traversed.add(node);
        order.add(node);
        visited.remove(node);
        
        return true;
    }
}
