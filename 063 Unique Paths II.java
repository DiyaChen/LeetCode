/*
Unique Paths II 

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1 || obstacleGrid[0][0] == 1){
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int result[][] = new int[row + 1][col + 1];
        result[1][1] = 1;
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(!(i == 1 && j == 1)){
                    result[i][j] = obstacleGrid[i - 1][j - 1] == 1 ? 0 : result[i-1][j] + result[i][j-1];
                }
            }
        }
        return result[row][col];
    }
}