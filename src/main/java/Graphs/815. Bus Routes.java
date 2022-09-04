class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) {
            return 0;
        }
        int n = routes.length;
        
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<Integer, List<Integer>>();
        Queue<Integer> q = new LinkedList<Integer>(); 

		int maxV = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++) {
            for(int v: routes[i]) {
                if(!adjacencyList.containsKey(v)) {
                    adjacencyList.put(v, new ArrayList<Integer>());
                }
                adjacencyList.get(v).add(i);
                maxV = Math.max(maxV, v);
            }
        }
        int nVertices = adjacencyList.size();
        boolean []visitedRoutes = new boolean[n];
        boolean []visitedStops = new boolean[maxV+1];
        
        List<Integer> busIndices = adjacencyList.get(source);
        for(int busIndex: busIndices) {
            visitedRoutes[busIndex] = true;
            for(int stop: routes[busIndex]) {
                q.add(stop);
            }
        }
        
        int count = 1;
        while(!q.isEmpty()) {
            int nStops = q.size();
            for(int i = 0; i<nStops; i++) {
                int stop = q.remove();
                if(visitedStops[stop]) continue;
                visitedStops[stop] = true;
                if(stop == target) {
                    return count;
                }
			    List<Integer> rIndices = adjacencyList.get(stop);
                for(int rIndex: rIndices) {
                    if(!visitedRoutes[rIndex]) {
                        visitedRoutes[rIndex] = true;
                        for(int s: routes[rIndex]) {
                            q.add(s);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
