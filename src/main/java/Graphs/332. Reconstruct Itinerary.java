class Solution {
	public List<String> findItinerary(List<List<String>> tickets) {
		HashMap<String, PriorityQueue<String>> map = new HashMap<>();
		for (int i = 0; i<tickets.size(); i++) {
			List<String> list = tickets.get(i);
			String key = list.get(0);
			String value = list.get(1);

			if (!map.containsKey(key)) {
				map.put(key, new PriorityQueue<>());
			}
			map.get(key).add(value);
		}
		LinkedList<String> llist = new LinkedList<>();
		dfs(map, llist, "JFK");
		return llist;

	}

	public void dfs(HashMap<String, PriorityQueue<String>> map, LinkedList<String> llist, String str) {
		PriorityQueue<String> pq = map.get(str);
		while (pq != null && !pq.isEmpty()) {
			dfs(map, llist, pq.poll());
		}
		llist.addFirst(str);

	}

}
