class Solution {
	class Node {
		int sum;
		int nodes;
		public Node(int sum, int nodes) {
			this.sum = sum;
			this.nodes = nodes;
		}
	}
	public int[] sumOfDistancesInTree(int n, int[][] arr) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i<n; i++) {
			adj.add(new ArrayList<>());
		}
		for (int i = 0; i<arr.length; i++) {
			adj.get(arr[i][0]).add(arr[i][1]);
			adj.get(arr[i][1]).add(arr[i][0]);
		}
		HashMap<Integer, HashMap<Integer, Node>> map = new HashMap<>();
		int[] ans = new int[n];
		boolean[] isVis = new boolean[n];
		for (int i = 0; i<n; i++) {
			isVis[i] = true;
			ans[i] = getSum(i, -1, isVis, adj, map).sum;
			isVis[i] = false;
		}
		return ans;
	}

	private Node getSum(int curNode, int parent, boolean[] isVis, ArrayList<ArrayList<Integer>> adj, HashMap<Integer, HashMap<Integer, Node>> map) {
		int sum = 0;
		int nodes = 0;
		for (int ele: adj.get(curNode)) {
			if (!isVis[ele]) {
				isVis[ele] = true;
				Node tempNode = null;
				if (map.containsKey(curNode) && map.get(curNode).containsKey(ele)) {
					tempNode = map.get(curNode).get(ele);
				} else {
					tempNode = getSum(ele, curNode, isVis, adj, map);
				}
				sum += tempNode.sum;
				nodes += tempNode.nodes;
				isVis[ele] = false;
			}
		}
		if (!map.containsKey(parent)) {
			map.put(parent, new HashMap<>());
		}
		map.get(parent).put(curNode, new Node(sum + nodes + 1, nodes + 1));
		if (parent == -1) return new Node(sum, -1);
		return new Node(sum + nodes + 1, nodes + 1);
	}
}
