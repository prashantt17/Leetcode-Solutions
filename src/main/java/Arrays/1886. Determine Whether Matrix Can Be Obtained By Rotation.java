class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i =0;i<mat.length;i++)
            for(int j = 0;j<mat[0].length;j++)
                if(mat[i][j] != target[i][j])
                    return rotate(mat,target,0);
        return true;
    }
    
    
    public boolean rotate(int[][] matrix,int[][] target,int no) {
        if(no>=3)
            return false;
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        no++;
        for(int i =0;i<matrix.length;i++)
            for(int j = 0;j<matrix[0].length;j++)
                if(matrix[i][j] != target[i][j])
                    return rotate(matrix,target,no);
        return true;
    }
}
