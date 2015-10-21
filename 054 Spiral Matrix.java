/*
Spiral Matrix 

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        int startR = 0;
        int endR = matrix.length - 1;
        int startC = 0;
        int endC = matrix[0].length - 1;
        // update boundry as soon as we traverse through it
        while (startR <= endR && startC <= endC) {
            for(int j = startC; j <= endC; j++){
                result.add(matrix[startR][j]);
            }
            startR++;
            if(startR > endR) break;
            for(int j = startR; j <= endR; j++){
                result.add(matrix[j][endC]);
            }
            endC--;
            if(endC < startC) break;
            for(int j = endC; j >= startC; j--){
                result.add(matrix[endR][j]);
            }
            endR--;
            if(endR < startR) break;
            for(int j = endR; j >= startR; j--){
                result.add(matrix[j][startC]);
            }
            startC++;
        }
        return result;
    }
}