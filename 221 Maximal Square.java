/*
Maximal Square 

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] table = new int[r][c];
        int result = 0;
        for(int i = 0; i < r; i++){
            table[i][0] = matrix[i][0] - '0';
            result = Math.max(result, table[i][0]);
        }
        for(int j = 0; j < c; j++){
            table[0][j] = matrix[0][j] - '0';
            result = Math.max(result, table[0][j]);
        }
        for(int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){
                if(matrix[i][j] == '0'){
                    table[i][j] = 0;
                }else{
                    int min = Math.min(table[i - 1][j], table[i][j - 1]);
                    min = Math.min(min, table[i - 1][j -1]);
                    table[i][j] = min + 1;
                    result = Math.max(result, table[i][j]);
                }
            }
        }
        return result * result;
    }
}