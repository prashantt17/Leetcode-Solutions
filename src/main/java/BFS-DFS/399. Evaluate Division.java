class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
         Map<String, Map<String, Double>> adjList = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> edge = equations.get(i);
            adjList.putIfAbsent(edge.get(0), new HashMap<>());
            adjList.putIfAbsent(edge.get(1), new HashMap<>());
            adjList.get(edge.get(0)).put(edge.get(1), values[i]);
            adjList.get(edge.get(1)).put(edge.get(0), 1 / values[i]);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            result[i] = dfs(query.get(0), query.get(1), adjList, new HashSet<>());
        }
        return result;
    }

    private double dfs(String source, String dest, Map<String, Map<String, Double>> adjList, Set<String> visited) {
        if (visited.contains(source)) return -1;
        visited.add(source);
        if (!adjList.containsKey(source)) return -1;
        if (source.equals(dest)) return 1;
        for (Map.Entry<String, Double> neighbour : adjList.get(source).entrySet()) {
            double result = dfs(neighbour.getKey(), dest, adjList, visited);
            if (result != -1) return neighbour.getValue() * result;
        }
        return -1;
    }
}
