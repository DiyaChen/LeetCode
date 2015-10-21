/*
Sqrt(x) 

Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        long j = x / 2 + 1;
        long i = 0;
        while(i <= j){
            long mid = (i + j) / 2;
            long sqr = mid * mid;   // if x is MAX_VALUE, sqr exceeds boundary then == 0
            if(sqr == x){
                return (int)mid;
            }
            if(sqr < x){
                i = mid + 1;
            }
            if(sqr > x){
                j = mid - 1;
            }
        }
        return (int)j;
    }
}