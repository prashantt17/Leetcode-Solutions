class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
	List<Integer>[] graph = new ArrayList[n];
	for (int i = 0; i < n; i++)
		graph[i] = new ArrayList<Integer>();

	for (int[] rich : richer)
		graph[rich[1]].add(rich[0]);

	int[] ans = new int[n];
	boolean[] visited = new boolean[n];
	for (int i = 0; i < n; i++) {
		if (!visited[i])
			loudAndRich(n, i, graph, visited, ans, quiet);
	}
	return ans;
}

public static int loudAndRich(int n, int src, List<Integer>[] graph, boolean[] visited, int[] ans, int[] quiet) {

	if (visited[src])
		return ans[src];

	visited[src] = true;
	List<Integer> nbrs = graph[src];
	int min = quiet[src];
	int person = src;
	for (int nbr : nbrs) {
		int p = loudAndRich(n, nbr, graph, visited, ans, quiet);
		if (quiet[p] < min) {
			min = quiet[p];
			person = p;
		}
	}
	ans[src] = person;
	return person;
    }
}
