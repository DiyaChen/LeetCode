/*
Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        return aux(matrix, 0, col-1, target);
    }
    
    public boolean aux(int[][] matrix, int a, int b, int target){
        if(a > matrix.length - 1 || b < 0 ){
            return false;
        }
        if(matrix[a][b] == target){
            return true;
        }
        if(matrix[a][b] < target){
            return aux(matrix, a+1, b, target);
        }else{
            return aux(matrix, a, b-1, target);
        }
    }
}