/*
Maximal Rectangle

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col + 1];
        int max = 0;
        for(int i = 0; i < row; i++){
            Stack<Integer> stack = new Stack<Integer>();
            for(int j = 0; j < col + 1; j++){
                if(j < col){
                    if(matrix[i][j] == '1') height[j] += 1;
                    else height[j] = 0;
                }
                while(!stack.isEmpty() && height[stack.peek()] > height[j]){
                    int h = height[stack.pop()];
                    int w = stack.isEmpty() ? j : j - stack.peek() - 1;
                    max = Math.max(max, h * w);
                }
                stack.push(j);
            }
        }
        return max;
    }
}