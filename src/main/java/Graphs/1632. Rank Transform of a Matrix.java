class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[] rIsland = new int[row], cIsland = new int[col];
        int len = row * col;
        int[][] arr = new int[len][3];
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                int ind = r * col + c;
                arr[ind][0] = r;
                arr[ind][1] = c;
                arr[ind][2] = matrix[r][c];
            }
        }
        Arrays.sort(arr, Comparator.comparing(e -> e[2]));
        int[][] ans = new int[row][col];
        int i = 0;
        while(i < len) {
            int j = i;
            while(j < len && arr[j][2] == arr[i][2]) j++;
            Map<Integer, Set<Integer>> adjR = new HashMap<>();
            Map<Integer, Set<Integer>> adjC = new HashMap<>();
            for(int k = i; k < j; k++) {
                int r = arr[k][0], c = arr[k][1], v = arr[k][2];
                if(!adjR.containsKey(r)) adjR.put(r, new HashSet<>());
                if(!adjC.containsKey(c)) adjC.put(c, new HashSet<>());
                adjR.get(r).add(k);
                adjC.get(c).add(k);
            }
            
            int[][] parent = new int[j - i][2];
            for(int k = 0; k < j - i; k++) {
                parent[k][0] = k;
                parent[k][1] = Math.max(rIsland[arr[k + i][0]] + 1, cIsland[arr[k + i][1]] + 1);
            }
            
            for(Integer r: adjR.keySet()) {
                merge(parent, adjR.get(r), i);
            }
            for(Integer c: adjC.keySet()) {
                merge(parent, adjC.get(c), i);
            }

            for(int k = 0; k < j - i; k++) {
                rIsland[arr[k + i][0]] = Math.max(rIsland[arr[k + i][0]], parent[parent(parent, k)][1]);
                cIsland[arr[k + i][1]] = Math.max(cIsland[arr[k + i][1]], parent[parent(parent, k)][1]);
                ans[arr[k + i][0]][arr[k + i][1]] = parent[parent(parent, k)][1];
            }
            i = j;
        }
        return ans;
    }
    
    int parent(int[][] parent, int ind) {
        if(parent[ind][0] == ind) return ind;
        parent[ind][0] = parent(parent, parent[ind][0]);
        return parent[ind][0];
    }
    
    void merge(int[][] parent, int x, int y) {
        int px = parent(parent, x), py = parent(parent, y);
        if(px == py) return;
        parent[px][1] = Math.max(parent[px][1], parent[py][1]);
        parent[py][0] = px;
    }
    
    void merge(int[][] parent, Set<Integer> st, int offset) { 
        Integer p = st.iterator().next() - offset;
        for(Integer e: st) {
            merge(parent, p, e - offset);
        }
    }
}
