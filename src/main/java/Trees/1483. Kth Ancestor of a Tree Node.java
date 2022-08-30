public class MainTreeAnscestor {
   	int n;
   	int[] parent;
   	int[] level;
   	int[] higherParent;
   	int distance;

   	public MainTreeAnscestor(int n, int[] parent) {
   		this.n = n;
   		this.parent = parent;
   		this.level = new int[n];
   		this.higherParent = new int[n];
   		this.distance = (int) (Math.log(n) / Math.log(2));

   		Map<Integer, ArrayList<Integer>> tree = new HashMap<Integer, ArrayList<Integer>>();

   		for (int i = 1; i < n; i++) {
   			if (!tree.containsKey(parent[i])) {
   				tree.put(parent[i], new ArrayList<Integer>());
   			}
   			tree.get(parent[i]).add(i);
   		}

   		List<Integer> queue = new LinkedList<Integer>();
   		queue.add(0);
   		level[0] = 0;
   		higherParent[0] = 0;
   		while (!queue.isEmpty()) {
   			int current = queue.remove(0);
   			if (tree.containsKey(current)) {
   				for (int child : tree.get(current)) {
   					level[child] = level[current] + 1;
   					if (level[child] >= level[higherParent[current]] + distance) {
   						higherParent[child] = current;
   					} else {
   						higherParent[child] = higherParent[current];
   					}
   					queue.add(child);
   				}
   			}
   		}
   	}

   	public int getKthAncestor(int node, int k) {
   		if (k == 0) {
   			return node;
   		}
   		if (k == 1) {
   			return parent[node];
   		}
   		if (level[node] < k) {
   			return -1;
   		}

   		int current = node;
   		while (level[node] - level[current] < k - distance) {
   			current = higherParent[current];
   		}

   		while (level[node] - level[current] < k) {
   			current = parent[current];
   		}

   		return current;
   	}
   }

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
