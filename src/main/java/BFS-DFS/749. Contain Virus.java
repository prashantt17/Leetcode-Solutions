class Solution {
    private static final int[][] DIR = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    
    public int containVirus(int[][] isInfected) {
        int m = isInfected.length, n = isInfected[0].length;
        int ans = 0;
        
        while( true ) {
            PriorityQueue<Region> pq = new PriorityQueue<Region>();
            boolean[][] visited = new boolean[m][n];
            
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    
                    if( isInfected[i][j] != 1 || visited[i][j] ) 
                        continue;
          
                    Region reg = new Region();
                    dfs(i, j, reg, isInfected, visited, new boolean[m][n], m, n);
                    
                    if( reg.uninfected.size() != 0)
                        pq.offer(reg);
                }
            }
            
            if( pq.isEmpty() )
                break;

            Region containReg = pq.poll();
            ans += containReg.wallsRequired;
            
            for(int[] cell : containReg.infected)
                isInfected[cell[0]][cell[1]] = 2;
            
            while( !pq.isEmpty() ) {
                Region spreadReg = pq.poll();
                
                for(int[] cell : spreadReg.uninfected)
                    isInfected[cell[0]][cell[1]] = 1;
            }
        }
        return ans;
    }
    
    private void dfs(int i, int j, Region reg, int[][] grid, boolean[][] visited, boolean[][] uninfectedVis, int m, int n) {
        visited[i][j] = true;
        reg.addInfected(i, j);
        
        for(int[] dir : DIR) {
            int di = i + dir[0];
            int dj = j + dir[1];
            
            if( di < 0 || dj < 0 || di == m || dj == n || grid[di][dj] == 2 || visited[di][dj] )
                continue;
            
            if( grid[di][dj] == 0 ) {
                reg.wallsRequired++;
                
                if( !uninfectedVis[di][dj] ) {
                    uninfectedVis[di][dj] = true;
                    reg.addUninfected(di, dj);
                }
            } else 
                dfs(di, dj, reg, grid, visited, uninfectedVis, m, n);
        }
    }
}
class Region implements Comparable<Region> {
    public List<int[]> infected;
    public List<int[]> uninfected;
    public int wallsRequired;
    
    public Region() {
        infected = new ArrayList();
        uninfected = new ArrayList();
    }
    
    public void addInfected(int row, int col) {
        infected.add(new int[]{ row, col });
    }
    
    public void addUninfected(int row, int col) {
        uninfected.add(new int[]{ row, col });
    }
    
    @Override
    public int compareTo(Region r2) {
        return Integer.compare(r2.uninfected.size(), uninfected.size());
    }
}
