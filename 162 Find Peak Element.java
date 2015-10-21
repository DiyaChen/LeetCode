/*
Find Peak Element 

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

Note:
Your solution should be in logarithmic complexity.
*/

public class Solution {
    public int findPeakElement(int[] num) {
        if(num.length == 1){
            return 0;
        }
        return aux(num, 0, num.length-1);
    }
    
    public int aux(int[] num, int a, int b){
        if(a == b){
            return a;
        }
        if(a + 1 == b){
            return num[a] > num[b] ? a : b;
        }
        int m = (a+b)/2;
        if(num[m-1] < num[m] && num[m] > num[m+1]){
            return m;
        }
        if(num[m] > num[m + 1]){
            return aux(num, a, m - 1);
        }else{
            return aux(num, m + 1, b);
        }
    }
}
