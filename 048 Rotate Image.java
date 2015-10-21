/*
Rotate Image

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length < 2){
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row-1; i++){ // rotate diagonally
            for(int j = 0; j < col-1-i; j++){
                swap(matrix, i, j, col-1-j, row-1-i);
            }
        }
        for(int i = 0; i < row/2; i++){ // flip the matrix 
            for(int j = 0; j < col; j++){
                swap(matrix, i, j, row-i-1, j);
            }
        }
        return;
    }
    
    public void swap(int[][] matrix, int a, int b, int x, int y){
        int tmp = matrix[a][b];
        matrix[a][b] = matrix[x][y];
        matrix[x][y] = tmp;
    }
}