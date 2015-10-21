/*
Minimum Path Sum 

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length < 1 || grid[0].length < 1){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] table = new int[row][col];
        table[0][0] = grid[0][0];
        
        for(int i = 1; i < row; i++){
            table[i][0] = grid[i][0] + table[i-1][0];
        }

        for(int j = 1; j < col; j++){
            table[0][j] = grid[0][j] + table[0][j-1];
        }
        
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                table[i][j] = Math.min(table[i-1][j], table[i][j-1]) + grid[i][j];
            }
        }
        return table[row-1][col-1];
    }
}