class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
       
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                if(j==col-1&&i==row-1){
                    dungeon[i][j]=Math.min(0,dungeon[i][j]);                   
                    continue;
                }
                int max = Math.max(i+1>=row?Integer.MIN_VALUE:dungeon[i+1][j]+dungeon[i][j],
                                   j+1>=col?Integer.MIN_VALUE:dungeon[i][j+1]+dungeon[i][j]);
                dungeon[i][j]=Math.min(0,max);
            }
        }
        return dungeon[0][0]<0?-dungeon[0][0]+1:1;
    }
}
