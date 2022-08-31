class Solution {
     int[] par, size;
    int maxSize = -(int)1e9;
    public int findPar(int u){
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }
    public void union(int[][] grid, int i, int j, int[][] dir){
        int n = grid.length;
        int p1 = findPar(i * n + j);
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            if(r >= 0 && c >= 0 && r < n && c < n && grid[r][c] == 1){
                int p2 = findPar(r * n + c);
                if(p1 != p2){
                    par[p2] = p1;
                    size[p1] += size[p2];
                }
            }
            maxSize = Math.max(maxSize, size[p1]);
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        par = new int[n * n];
        size = new int[n * n];
        for(int i = 0; i < n * n; i++){
            par[i] = i;
            size[i] = 1;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    union(grid, i, j, dir);
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> set = new HashSet<>();
                    for(int[] d : dir){
                        int r = i + d[0];
                        int c = j + d[1];
                        if(r >= 0 && c >= 0 && r < n && c < n && grid[r][c] == 1){
                            int p = findPar(r * n + c);
                            if(!set.contains(p))
                                set.add(p);
                        }
                    }
                    int currSize = 1;
                    for(int p : set)
                        currSize += (size[p]);   
        
                    maxSize = Math.max(currSize, maxSize);
                }
            }
        }
        return maxSize;
    }
}
