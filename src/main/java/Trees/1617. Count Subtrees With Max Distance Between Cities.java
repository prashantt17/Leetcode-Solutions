class Solution {
    int[] dist;
    int ans = 0, vis = 0;
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        ans = 0; vis = 0;
        dist = new int[n - 1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
		for(int[] i : edges){
            graph.computeIfAbsent(1 << (i[0] - 1), ArrayList::new).add((1 << (i[1] - 1)));
            graph.computeIfAbsent(1 << (i[1] - 1), ArrayList::new).add((1 << (i[0] - 1)));
        }
        int ps = ((int)Math.pow(2, n)) - 1;
        for(int set = 3; set <= ps; set++){
		    boolean isp2 = set != 0 && ((set & (set - 1)) == 0); 
            if(!isp2){ 
			
                ans = 0;
                vis = 0;
				
		        dfs(graph, set, Integer.highestOneBit(set), -1);
				
		        if(vis == set) dist[ans - 1]++; 
            }
        }
        return dist;
    }
    
    private int dfs(Map<Integer, List<Integer>> graph, int set, int c, int p){
        if((set & c) == 0) return 0; 
        vis = vis | c; 
        int fdist = 0, sdist = 0;
        for(int i : graph.get(c)){
            if(i != p){
                int dist = dfs(graph, set, i, c);
                if(dist > fdist){
                    sdist = fdist;
                    fdist = dist;
                }else{
                    sdist = Math.max(sdist, dist);
                }
            }
        }
        ans = Math.max(ans, fdist + sdist);
        return 1 + fdist;
    }
}
