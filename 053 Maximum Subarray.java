/*
Maximum Subarray 

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class Solution {
    public int maxSubArray(int[] A) {
        if(A.length == 0){
            return 0;
        }
        int soFar = A[0];
        int endHere = A[0];
        for(int i = 1; i < A.length; i++){
            endHere = Math.max(endHere, 0) + A[i];
            soFar = Math.max(endHere, soFar);
        }
        return soFar;
    }
}

// return indeces

public int[] maxSubArrayWithIndices(int[] A){
    int[] indices = new int[2]; 
    if(A.length == 0){
        return indices;
    }
    int max = Integer.MIN_VALUE;
    int sum = 0;
    int maxStart = 0;
    int maxEnd = 0;
    int curStart = 0;
    for(int curEnd = 0; curEnd < A.length; curEnd++){   // curStart, curEnd initialize to 0
        sum += A[curEnd];
        if(sum > max){
            max = sum;
            maxStart = curStart;
            maxEnd = curEnd;
        }
        if(sum < 0){
            sum = 0;
            curStart = curEnd + 1;
        }
    }
    indices[0] = maxStart;
    indices[1] = maxEnd;
    return indices;
}