class Solution {
    public int countBattleships(char[][] board) {
        return countShips2(board);
    }
    
    public int countShips2(char[][] board){
        
        int row= board.length;
        int col= board[0].length;
        int count= 0;
        
        for(int i=0; i<row; i++){
            
            for(int j=0; j<col; j++){
                
                int p= i;
                int q= j;
                
                if( board[i][j] == 'X' ){
                        
                    if( checkValid(i,j, board) ){
                        count++;
                    }
                }
            }
            
        }
        
        return count;
    }
    
    public boolean checkValid( int i, int j, char[][] board ){
        
        if( (i-1>=0 && board[i-1][j] =='X') || (j-1 >=0 && board[i][j-1] == 'X') ){
            return false;
        }
        
        return true;
    }
    
}
