class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        int LEFT=0,RIGHT=1,TOP=2,BOTTOM=3;
        Map<Integer, int[]> coordinates = new HashMap();
        Map<Integer, Set<Integer>> adj = new HashMap();
        int rows = targetGrid.length, cols = targetGrid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int color = targetGrid[i][j];
                if (coordinates.containsKey(color)){
                    int[] coordinate = coordinates.get(color);
                    coordinate[LEFT]=Math.min(j, coordinate[LEFT]);
                    coordinate[RIGHT]=Math.max(j, coordinate[RIGHT]);
                    coordinate[TOP]=Math.min(i, coordinate[TOP]);
                    coordinate[BOTTOM]=Math.max(i, coordinate[BOTTOM]);
                }else{
                    coordinates.put(color, new int[]{j, j, i, i});
                    adj.put(color, new HashSet());
                }
            }
        }
        Map<Integer, Integer> indegree = new HashMap();
        for(Map.Entry<Integer, int[]> entry: coordinates.entrySet()){
            int currColor = entry.getKey();
            int[] coordinate=entry.getValue();
            for(int i = coordinate[TOP]; i <= coordinate[BOTTOM]; i++){
                for(int j = coordinate[LEFT]; j <= coordinate[RIGHT]; j++){
                    int color = targetGrid[i][j];
                    if (currColor!=color)
                        adj.get(currColor).add(color);
                }
            }
            indegree.put(currColor, 0);
        }
        for(Integer key: adj.keySet()){
            for (int color: adj.get(key))
                indegree.put(color, indegree.get(color)+1);
        }
        Queue<Integer> queue = new LinkedList();
        for(Integer key: indegree.keySet())
            if (indegree.get(key)==0)
                queue.offer(key);
        int size = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            size++;
            for(int neighbor: adj.get(node)){
                indegree.put(neighbor, indegree.get(neighbor)-1);
                if (indegree.get(neighbor) == 0)
                    queue.offer(neighbor);
            }
        }
        return size == adj.size();
    }
}
