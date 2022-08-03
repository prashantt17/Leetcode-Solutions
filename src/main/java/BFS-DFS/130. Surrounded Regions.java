class Solution {
     public int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void solve(char[][] board) {
        int n = board[0].length, m = board.length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<m; i++) {
            if (board[i][0] == 'O') queue.offer(new int[]{i, 0});
            if (board[i][n-1] == 'O') queue.offer(new int[]{i, n-1});
        }
        for (int j=0; j<n; j++) {
            if (board[0][j] == 'O') queue.offer(new int[]{0, j});
            if (board[m-1][j] == 'O') queue.offer(new int[]{m-1, j});
        }
        Set<Integer> notFlipped = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            if (notFlipped.contains(pos[0] << 8 | pos[1])) continue;
            for (int[] dir : dirs) {
                int newX = pos[1] + dir[1], newY = pos[0] + dir[0];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && board[newY][newX] == 'O') queue.offer(new int[]{newY, newX});
            }
            notFlipped.add(pos[0] << 8 | pos[1]);
        }
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O' && !notFlipped.contains(i << 8 | j)) board[i][j] = 'X';
            }
        }
    }
}
