class Solution {
    public boolean exist(char[][] board, String word) {
        int []flag=new int[1];
        int [][]vis=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    check(i,j,board,word,0,flag,vis);
                }
            }
        }
        if(flag[0]==1){
            return true;
        }else{
         return false;   
        }
    }
    public void check(int sr,int sc,char[][] board,String word,int idx,int []flag,int [][]vis){
        if(idx==word.length()){
           flag[0]=1;
           return;
        }
        if(sr<0||sc<0||sr>=board.length||sc>=board[0].length||vis[sr][sc]==1||board[sr][sc]!=word.charAt(idx)){
            return;
        }
        vis[sr][sc]=1;
        check(sr+1,sc,board,word,idx+1,flag,vis);
        check(sr,sc+1,board,word,idx+1,flag,vis);
        check(sr-1,sc,board,word,idx+1,flag,vis);
        check(sr,sc-1,board,word,idx+1,flag,vis); 
        vis[sr][sc]=0;
    }
}
