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
            int[][] res = new int[n][n];
            if(n <= 0) return res;
            int left = 0; 
            int right = n-1;
            int top = 0;
            int down = n-1;
            int count = 0;
            while(count != n*n)//count == 9, stop
            {
                for(int i = left; i <= right; i++)
                    {
                    count++;
                    res[top][i] = count;
                    }
                top++;
                for(int i = top; i <= down; i++) 
                    {
                    count++;
                    res[i][right] = count;
                    }
                right--;
                for(int i = right; i>=left; i--)
                     {
                    count++;
                    res[down][i] = count;
                     }
                down--;
                for(int i = down; i >= top; i--)
                    {
                    count++;
                    res[i][left] = count;                   
                    }
                left++;
            }
          return res;  
    }
}