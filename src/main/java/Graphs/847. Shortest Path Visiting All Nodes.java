class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int maxMask = (int) Math.pow(2, n);
        int done = maxMask - 1;
        boolean[][] visited = new boolean[maxMask][n];
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < n; ++i) {
            int mask = getMask(0, i);
            queue.add(new int[]{mask, i, 0});
        }
        
        while (!queue.isEmpty()) {
            int[] step = queue.poll();
            int mask = step[0];
            int node = step[1];
            int count = step[2];
            if (mask == done)
                return count;

            ++count;
            for (int edge : graph[node]) {
                int newMask = getMask(mask, edge);
                if (visited[newMask][edge])
                    continue;
                    
                visited[newMask][edge] = true;
                queue.add(new int[]{newMask, edge, count});
            }
        }
        
        return -1;
    }
    
    private int getMask(int mask, int i) {
        return mask | 1 << i;
    
    }
}
