/*
Pow(x, n) 

Implement pow(x, n).
*/

public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n<0)
        {
            n = -n;
            x = 1/x;
        }
        double res = 1;
        while(n != 0)
        {
            if(n%2 == 1)
                res *= x;
            x = x * x;
            n /= 2;           
        }
        return res;
    }
    
   
}