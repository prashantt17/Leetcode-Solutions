class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length == 0 || n == 1){
            List<Integer> res = Arrays.asList(0);
            return res;
        }
        ArrayList<Integer>[] adj = new ArrayList[n];
        int[] indegree = new int[n];
        
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] e: edges){
            int v = e[0];
            int u = e[1];
            
            adj[v].add(u);
            adj[u].add(v);
            indegree[u]++;
            indegree[v]++;
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        for(int i=0; i<n; ++i){
            if(indegree[i] == 1){
                queue.add(i);
            }
        }
        
        while(n > 2){
            int size = queue.size();
            n -= size;
            
            while(size-- > 0){
                int rem = queue.remove();
                for(int i: adj[rem]){
                    indegree[i]--;
                    if(indegree[i] == 1){
                        queue.add(i);
                    }
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while(queue.size()>0){
            res.add(queue.pop());
        }
        
        
        return res;
    }
}
