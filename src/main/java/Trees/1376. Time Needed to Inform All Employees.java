class Solution {
    private int maxTime, n;
    private int[] informTime;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (manager == null || manager.length == 0) {
            return 0;
        }
        this.informTime = informTime;
        this.n = n;
        this.maxTime = 0;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(manager, graph);
        dfs(graph, headID, 0);
        return maxTime;
    }
    public void buildGraph(int[] manager, HashMap<Integer, List<Integer>> graph) {
        for (int i = 0; i < n; i++) {
            int key = manager[i];
            if (!graph.containsKey(key)) {
                graph.put(key, new ArrayList<Integer>());
            }
            graph.get(key).add(i);
        }
    }
    public void dfs(HashMap<Integer, List<Integer>> graph, int currID, int usedTime) {
        if (!graph.containsKey(currID)) {
            maxTime = Math.max(maxTime, usedTime);
            return;
        }
        usedTime += informTime[currID];
        for (int nextID : graph.get(currID)) {
            dfs(graph, nextID, usedTime);
        }
        usedTime -= informTime[currID];
    }
}
