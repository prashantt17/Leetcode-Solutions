class Solution {
    public int diagonalSum(int[][] mat) {
       int result =0;
        for(int i=0; i<mat.length; i++){
            int[] row = mat[i];
            int length = row.length;
            if(i == (length-i-1))
                result += row[i];
            else
                result += row[i] + row[length-i-1];
                
        }
        return result;
        
    }
}
