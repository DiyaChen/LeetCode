/*
Bitwise AND of Numbers Range

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
*/

//[26, 30]: 11010　　11011　　11100　　11101　　11110 => 1100
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int mask = Integer.MAX_VALUE;
        while((m & mask) != (n & mask)){
            mask <<= 1;
        }
        return m & mask;
    }
}