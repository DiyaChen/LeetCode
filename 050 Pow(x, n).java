/*
Pow(x, n) 

Implement pow(x, n).
*/

public class Solution {
    public double myPow(double x, int n) {
        double nd = n;
        return power(x, nd);
    }
    
    private double power(double x, double n){
        if(n < 0){
            return 1 / power(x, - n);   // if n is not double, -n will exceed boundary
        }
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        if(x == 0 || x == 1){
            return x;
        }
        double half = power(x, (int)(n / 2));
        if(n % 2 == 0){
            return half * half;
        }else{
            return half * half * x;
        }
    }
}