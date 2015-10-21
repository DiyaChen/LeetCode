/*
Surrounded Region

Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

public class Solution {
    public void solve(char[][] board) {
        if(board == null){
            return;
        }
        if(board.length < 3 || board[0].length < 3){
            return;
        }
        
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O'){
                DFS(board, i, 0);
            }
            if(board[i][board[0].length - 1] == 'O'){
                DFS(board, i, board[0].length - 1);
            }
        }
        
        for(int j = 1; j < board[0].length - 1; j++){
            if(board[0][j] == 'O'){
                DFS(board, 0, j);
            }
            if(board[board.length - 1][j] == 'O'){
                DFS(board, board.length - 1, j);
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
    
    private void DFS(char[][] board, int row, int col){
        board[row][col] = '#';
        if(row > 1 && board[row - 1][col] == 'O'){
            DFS(board, row - 1, col);
        }
        if(col > 1 && board[row][col - 1] == 'O'){
            DFS(board, row, col - 1);
        }
        if(row < board.length - 2 && board[row + 1][col] == 'O'){
            DFS(board, row + 1, col);
        }
        if(col < board[0].length - 2 && board[row][col + 1] == 'O'){
            DFS(board, row, col + 1);
        }
    }
}