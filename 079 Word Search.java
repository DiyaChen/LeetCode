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
        boolean[][] visited = new boolean[board.length][board[0].length];//record whether this character is visited or not,initialize to false
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
            {
                if(search(board, word, visited, i, j, 0)) return true;
            }
            return false;
    }
    private boolean search(char[][] board, String word, boolean[][] visited,int i, int j, int index )
    {
        if(index == word.length()) return true;//stop recursion 
        if(i>=board.length || i<0 || j>=board[i].length || j<0 || visited[i][j] || word.charAt(index) != board[i][j])
            return false;
        visited[i][j] = true;
        if(search(board,word,visited,i+1, j, index+1)) return true;
        if(search(board,word,visited,i, j+1, index+1)) return true;
        if(search(board,word,visited,i-1, j, index+1)) return true;
        if(search(board,word,visited,i, j-1, index+1)) return true;
        visited[i][j] = false;//restore
        return false;
    } 
}