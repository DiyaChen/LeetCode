/*
Reverse Integer

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

Bonus points:
1.If the integer's last digit is 0,cases such as 10, 100.

2.Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

3.assume that your function returns 0 when the reversed integer overflows.
*/

public class Solution {
    public int reverse(int x) {
        //method1
        long res = 0;
        while(x != 0)
        {
            res = res*10 + x%10;
            x /= 10;
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        return (int)res;

        /* method2
        int sign = x < 0 ? -1 : 1;
        long xd = Math.abs((long)x);
        String str = String.valueOf(xd);
        str = new StringBuffer(str).reverse().toString(); 
        long result = sign * Long.valueOf(str);
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return (int)result;*/
    }
}