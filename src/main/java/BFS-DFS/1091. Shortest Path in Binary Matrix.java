class Solution {
     int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0},{-1,1},{1,-1},{1,1},{-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        if(grid[0][0]==1){
            return -1;
        }
        
        q.add(new int[]{0,0,1});
        visited[0][0]= true;
        
        while(!q.isEmpty()){
            int[] top = q.poll();
            int r = top[0];
            int c = top[1];
            int d = top[2];
            
            if(r == m-1 && c == n-1){
                return d;
            }
            
            for(int i =0;i<8;i++){
                int nr = r+dir[i][0];
                int nc = c+dir[i][1];
                
            if(nr<0 || nc<0 || nr>=m || nc >=n){
                continue;
            }
                if(grid[nr][nc]==0){
                    if(!visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr,nc,d+1});
                    }
                }
            }
        }
        return -1;
    }
}
