/*
String to Integer (atoi) 

Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
*/

public class Solution {
    public int myAtoi(String str) {
        str = str.trim();   // remove space
        if(str.length() == 0)
            return 0;        
        int start = 0;
        int sign = 1;
        double result = 0;//double is longer than long!!!
        if(str.charAt(0) == '-'){   // verify sign
            sign = -1;
            start++;
        }
        if(str.charAt(0) == '+'){
            start++;
        }
        while(start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9'){
            result =  result * 10 + (str.charAt(start) - '0');
            start++;
        }
        if(sign == -1){
            result = -result;
        }
        if (result > Integer.MAX_VALUE) // check exceeding
            return Integer.MAX_VALUE;
 
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
 
        return (int) result;
    }
}