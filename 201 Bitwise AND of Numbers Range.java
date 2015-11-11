/*
Bitwise AND of Numbers Range

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
*/

//[26, 30]: 11010　　11011　　11100　　11101　　11110 => 11000
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {//two neighboring number are different in the last bit, the last bit must be 0 after &. find the left leader that is the same for m and n
        int count = 0;
        while (m != n)
        {
            m = m >> 1;
            n = n >> 1;
            count++;
        }
         return n << count;   
    }
}