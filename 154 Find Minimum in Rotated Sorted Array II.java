/*
Find Minimum in Rotated Sorted Array II 

Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
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

        }else{  // num[a] == num[m]

            if(num[m] < num[b]) return num[m];
            else if(num[m] > num[b]) return aux(num, m + 1, b);
            else return Math.min(aux(num, a, m), aux(num, m + 1, b));
        }
    }
}

//

public class Solution {
    public int findMin(int[] num) {
        if(num.length == 0 || num == null){
            return -1;
        }
        return aux(num, 0, num.length-1);
    }
    
    public int aux(int[] num, int a, int b){
        if(a == b){
            return num[a];
        }
        if(a + 1 == b){
            return num[a] <= num[b] ? num[a] : num[b];
        }
        int m = (a+b)/2;
        if(num[a] == num[m] && num[m] == num[b]){
            return Math.min(aux(num, a, m), aux(num, m + 1, b));
        }
        if(num[a] <= num[m] && num[m] <= num[b]){
            return aux(num, a, m);
        }
        if(num[a] <= num[m] && num[m] >= num[b]){
            return aux(num, m, b);
        }
        if(num[a] >= num[m] && num[m] <= num[b]){
            return aux(num, a, m);
        }
        return -1;
    }
}