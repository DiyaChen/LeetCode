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
        int[][] table = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i< obstacleGrid.length; i++)
        {
            if(obstacleGrid[i][0]==1)
                table[i][0] = 0;
            else 
                table[i][0] = 1;
        }
        for(int j = 0; j< obstacleGrid[0].length; j++)
        {
            if(obstacleGrid[0][j] == 1)
                table[0][j] = 0;
            else
                table[0][j] = 1;
        }
        for(int i = 1; i< obstacleGrid.length; i++)
        {
            for(int j = 1; j< obstacleGrid[0].length; j++)
            {
                if(obstacleGrid[i][j] == 1)
                    table[i][j] = 0;
                else
                    table[i][j] = table[i-1][j] + table[i][j-1];
            }
        }
        return table[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}