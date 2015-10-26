/*
Sqrt(x) 

Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class Solution {
    public int mySqrt(int x) {
        if(x == 0)
            return 0;
        if(x < 0) 
            return -1;
        int left = 1;
        int right = x;
        while(left < right-1)
        {
            int mid = left + (right-left)/2;
            if(mid == x/mid) return mid;
            if(mid < x/mid)  left = mid;
            if(mid > x/mid)  right = mid;
        }
        return left;
    }
}