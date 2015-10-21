/*
Set Matrix Zeroes

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(row <= 1 && col <= 1){
            return;
        }
        
        int flagRow = 0;
        int flagCol = 0;
        for(int i = 0 ; i < row; i++){
            if(matrix[i][0] == 0){
                flagRow = 1;
            }
        }
        for(int j = 0; j < col; j++){
            if(matrix[0][j] == 0){
                flagCol = 1;
            }
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < row; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < col; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 1; j < col; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < row; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(flagRow == 1){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }
        if(flagCol == 1){
            for(int j = 0; j < col; j++){
                matrix[0][j] = 0;
            }
        }
        return;
    }
}