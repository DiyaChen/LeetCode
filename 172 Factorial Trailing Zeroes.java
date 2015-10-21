/*
Factorial Trailing Zeroes 

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

public class Solution {
    public int trailingZeroes(int n) {
        if (n < 0) return 0;
        int count = 0;
        for (long i=5; n/i>=1; i*=5) {  // long i, because if n is very large, i * 5 may be exceeded, then unlimited loop
            count += n / i;
        }        
        return count;
    }
}