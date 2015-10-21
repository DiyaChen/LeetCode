/*
Reverse Integer

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/

public class Solution {
    public int reverse(int x) {
        if(x >= 0 && x <= 9)
            return x;
        int sign = x < 0 ? -1 : 1;
        long xd = Math.abs((long)x);
        String str = String.valueOf(xd);
        str = new StringBuffer(str).reverse().toString();   // StringBuffer.reverse()
        long result = sign * Long.valueOf(str);
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return (int)result;
    }
}