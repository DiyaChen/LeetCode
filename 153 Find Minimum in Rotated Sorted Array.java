/*
Find Minimum in Rotated Sorted Array

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int findMin(int[] num) {
        return aux(num, 0, num.length - 1);
    }
    
    private int aux(int[] num, int a, int b){
        if(a == b){
            return num[a];
        }
        int m = (a + b) / 2;
        if(num[a] < num[m]){

            if(num[m] <= num[b]) return aux(num, a, m);
            else return aux(num, m + 1, b);

        }else if(num[a] > num[m]){

            if(num[m] <= num[b]) return aux(num, a, m);
            else return aux(num, m + 1, b);

        }else{  // num[a] == num[m]: a == m

            if(num[m] < num[b]) return num[m];
            else if(num[m] > num[b]) return aux(num, m + 1, b);
            else return Math.min(aux(num, a, m), aux(num, m + 1, b));
        }
    }  
}