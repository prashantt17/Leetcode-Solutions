class Solution {
        
    int row;
    int col;

    public int maxSideLength(int[][] mat, int threshold) {
        row = mat.length;
        col = mat[0].length;
        int sum[][] = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int l = 0;
        int r = Math.min(row, col) + 1;
        while (l < r) {
            int row = (l + r) / 2;
            if (helper(sum, row, threshold))
                l = row + 1;
            else
                r = row;
        }
        return l - 1;
    }

    private boolean helper(int[][] sum, int len, int threshold) {
        for (int i = len; i <= row; i++) {
            for (int j = len; j <= col; j++) {
                if (sum[i][j] - sum[i - len][j] - sum[i][j - len] + sum[i - len][j - len] <= threshold)
                    return true;
            }
        }
        return false;
    }
}
