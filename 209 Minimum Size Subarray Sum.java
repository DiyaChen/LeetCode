/*
Minimum Size Subarray Sum 

Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        for(int end = 0; end < nums.length; end++){ // start and end are both initialize to 0
            sum += nums[end];
            while(sum >= s){
                len = Math.min(len, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}