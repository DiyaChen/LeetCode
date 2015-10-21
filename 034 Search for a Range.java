/*
Search for a Range 

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = result[1] = -1;
        if(nums == null || nums.length == 0) return result;
        bs(nums, 0, nums.length - 1, target, result);
        return result;
    }
    
    private void bs(int[] nums, int a, int b, int target, int[] result){
        if(a == b){
            if(nums[a] == target){
                if(a < result[0] || result[0] == -1) result[0] = a;
                if(a > result[1] || result[1] == -1) result[1] = a;
            }
            return;
        }
        int m = (a + b) / 2;
        if(target < nums[m]){
            bs(nums, a, m, target, result); // cannot m - 1, if a + 1 = b, m == a, m -1 exceeds boundary
        }else if(nums[m] < target){
            bs(nums, m + 1, b, target, result);
        }else{  // nums[m] == target
            bs(nums, a, m, target, result);
            bs(nums, m + 1, b, target, result);
        }
    }
}