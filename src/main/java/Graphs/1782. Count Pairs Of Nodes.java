class Solution {
	public int[] countPairs(int n, int[][] edges, int[] queries) {
		int[] es = new int[n + 1], sorted = new int[n + 1];
		Map<Integer, Integer> [] shared = new Map[n + 1];
		for (int[] e: edges) {
			sorted[e[0]] = es[e[0]] = es[e[0]] + 1;
			sorted[e[1]] = es[e[1]] = es[e[1]] + 1;
			int n1 = Math.min(e[0], e[1]), n2 = Math.max(e[0], e[1]);
			if (shared[n1] == null) shared[n1] = new HashMap();
			shared[n1].put(n2, shared[n1].getOrDefault(n2, 0) + 1);
		}
		Arrays.sort(sorted);
		int[] ans = new int[queries.length];
		for (int q = 0; q<queries.length; q++) {
			int l = 1, r = n;
			while (l<r)
				if (sorted[l] + sorted[r]<= queries[q]) l++;
				else ans[q] += (r--) - l;
			for (int i = 1; i<n; i++)
				if (shared[i] != null)
					for (Map.Entry<Integer, Integer> p: shared[i].entrySet()) {
						int j = p.getKey(), sEs = p.getValue();
						if (queries[q]<es[i] + es[j] && queries[q] + sEs >= es[i] + es[j]) ans[q]--;
					}
		}
		return ans;
	}
}
