class Solution {
    public int[] findBall(int[][] grid) {
         int rows=grid.length;
        int columns=grid[0].length;
        int[]  res= new int[columns];
        Arrays.fill(res,-1);
        int m=0;
        while(m<columns){
            int i=0;
            int j=m;
            while(i<rows){
                if(grid[i][j]==1 && j<columns){
                    if(j<columns-1 && grid[i][j+1]==1){
		                 i++;
                        j++;
                    } else {
                        break;
                    }
                } else if(grid[i][j]==-1 && j<columns){
                    if(j>0 && grid[i][j-1]==-1){
                        i++;
                        j--;
                    } else {
                        break;
                    }
                }
            }
            if(i==rows){
                res[m]=j;
            } 
            m++;  
        }
        return res;
    }
}
