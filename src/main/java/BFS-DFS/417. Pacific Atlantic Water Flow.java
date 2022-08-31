class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       
		List<List<Integer>> res = new ArrayList<List<Integer>>();
       
		int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacificOcean = new boolean[rows][cols];
        boolean[][] atlanticOcean = new boolean[rows][cols];
        
        for (int col = 0; col< cols; col++){
            helper(0, col, rows, cols, pacificOcean, heights[0][col], heights);
            helper(rows-1, col,rows, cols, atlanticOcean, heights[rows-1][col], heights);
        }
        for (int row = 0; row<rows; row++){
            helper(row, 0,rows, cols, pacificOcean, heights[row][0], heights);
            helper(row, cols-1,rows, cols, atlanticOcean, heights[row][cols-1], heights);
        }
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++){
                if (pacificOcean[i][j] && atlanticOcean[i][j])
                    res.add(Arrays.asList(i,j));
            }
        return res;
    }
    private void helper(int row, int col, int rows, int cols, boolean[][] visited, int prevHeight, int[][] heights){
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || prevHeight > heights[row][col])
            return;
        visited[row][col]= true;
        helper(row+1, col, rows, cols, visited, heights[row][col], heights);
        helper(row-1, col, rows, cols, visited, heights[row][col], heights);
        helper(row, col+1, rows, cols, visited, heights[row][col], heights);
        helper(row, col-1, rows, cols, visited, heights[row][col], heights);
        
    }
    
}
