class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];
        int c = click[1];
        
        char clickedVal = board[r][c];
        
        if (clickedVal == 'M') {
            board[r][c] = 'X';
            return board;
        }
        
        revealSquare(board, r, c);
        
        return board;
    }
    
    private void revealSquare(char[][] board, int r, int c) {
        if (board[r][c] != 'E') {
            return;
        }
        int numAdjMines = countAdjacentMines(board, r, c);
        if (numAdjMines == 0) {
            board[r][c] = 'B';
            revealAdjacentSquares(board, r, c);
        } else {
            board[r][c] = (char)(numAdjMines + '0');
        }
    }
    
    private void revealAdjacentSquares(char[][] board, int r, int c) {
        if (c < board[r].length - 1) {
            revealSquare(board, r, c + 1);
        }
        
        if (c > 0) {
            revealSquare(board, r, c - 1);
        }
        
        if (r > 0) {
            revealSquare(board, r - 1, c);
            
            if (c < board[r - 1].length - 1) {
                revealSquare(board, r - 1, c + 1);
            }
            
            if (c > 0) {
                revealSquare(board, r - 1, c - 1);
            }
        }
        
        if (r < board.length - 1) {
            revealSquare(board, r + 1, c);
            if (c < board[r + 1].length - 1) {
                revealSquare(board, r + 1, c + 1);
            }
            if (c > 0) {
                revealSquare(board, r + 1, c - 1);
            }
        }
    }
    
    private int countAdjacentMines(char[][] board, int r, int c) {
        int numMines = 0;
        
        if (c < board[r].length - 1 && board[r][c + 1] == 'M') {
            numMines++;
        }
        
        if (c > 0 && board[r][c - 1] == 'M') {
            numMines++;
        }
        
        if (r < board.length - 1) {
            if (board[r + 1][c] == 'M') {
                numMines++;
            }
            
            if (c < board[r + 1].length - 1 && board[r + 1][c + 1] == 'M') {
                numMines++;
            }
            
            if (c > 0 && board[r + 1][c - 1] == 'M') {
                numMines++;
            }
        }
        
        if (r > 0) {
            if (board[r - 1][c] == 'M') {
                numMines++;
            }
            
            if (c < board[r - 1].length - 1 && board[r - 1][c + 1] == 'M') {
                numMines++;
            }
            
            if (c > 0 && board[r - 1][c - 1] == 'M') {
                numMines++;
            }
        }
        
        return numMines;
    }
}
