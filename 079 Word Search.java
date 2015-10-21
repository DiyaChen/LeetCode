/*
Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null || word.length() == 0){
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] checker = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(aux(board, word, checker, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean aux(char[][] board, String word, boolean[][] checker, int row, int col, int index){
        if(row < 0 || row > board.length - 1){
            return false;
        }
        if(col < 0 || col > board[0].length - 1){
            return false;
        }
        if(word.charAt(index) != board[row][col] || checker[row][col]){ // checker[row][col] == true: loop exist
            return false;
        }
        if(index == word.length() - 1){
            return true;
        }

        checker[row][col] = true;
        if(row >= 1 && aux(board, word, checker, row - 1, col, index+1)){
            return true;
        }
        if(row <= board.length - 2 && aux(board, word, checker, row + 1, col, index+1)){
            return true;
        }
        if(col >= 1 && aux(board, word, checker, row, col - 1, index+1)){
            return true;
        }
        if(col <= board[0].length - 2 && aux(board, word, checker, row, col + 1, index+1)){
            return true;
        }
        checker[row][col] = false;  // reset the checker
        return false;
    } 
}