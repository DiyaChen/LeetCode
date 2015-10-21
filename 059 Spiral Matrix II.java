/*
Spiral Matrix II 

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        if(n <= 0){
            return new int[0][0];
        }
        int[][] result = new int[n][n];
        int i = 1;
        int startR = 0;
        int endR = n - 1;
        int startC = 0;
        int endC = n - 1;
        while(startR <= endR && startC <= endC){
            for(int j = startC; j <= endC; j++){
                result[startR][j] = i++;
            }
            startR++;
            for(int j = startR; j <= endR; j++){
                result[j][endC] = i++;
            }
            endC--;
            for(int j = endC; j >= startC; j--){
                result[endR][j] = i++;
            }
            endR--;
            for(int j = endR; j >= startR; j--){
                result[j][startC] = i++;
            }
            startC++;
        }
        return result;
    }
}