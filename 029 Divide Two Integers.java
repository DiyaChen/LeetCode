/*
Divide Two Integers 

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/

/*
any number num = a0*2^0 + a1*2^1 + a2*2^2 + ... + an*2^n + ...  (an is any integer)
exist such a number let dividend = num * divisor
*/
public class Solution {
    public int divide(int dividend, int divisor) {
        long result = divideL((long)dividend, (long)divisor);
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)result;
    }
    
     public long divideL(long dividend,long divisor){
         if(dividend < 0) return -divideL(-dividend, divisor);
         if(divisor < 0) return -divideL(dividend, -divisor);
         if(dividend == 0) return 0;
         if(divisor == 0) return Integer.MAX_VALUE;
         if(divisor == 1) return dividend;
         if(dividend < divisor) return 0;
         long ans = 0;
         long d = divisor;
         long bitcnt = 1;
         while(d < dividend ){
             d <<= 1;
             bitcnt <<= 1;
         }
         while(d >= divisor){
             while(dividend >= d){
                 dividend -= d;
                 ans += bitcnt;
             }
             d >>= 1;
             bitcnt >>= 1;
         }
         return ans;
     }    
}