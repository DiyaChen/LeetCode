/*
Valid Sudoku 

Determine if a Sudoku is valid

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9]; // row[i] represent ith row
        int[] col = new int[9];
        int[] sqr = new int[9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if((row[i] & (1 << num)) > 0) return false;
                    row[i] |= 1 << num;
                    
                    if((col[j] & (1 << num)) > 0) return false;
                    col[j] |= 1 << num;
                    
                    int sqrId = i/3 + (j/3)*3;  // sqrId = 0 - 8
                    if((sqr[sqrId] & (1 << num)) > 0) return false;
                    sqr[sqrId] |= 1 << num;
                }
            }
        }
        return true;
    }
}