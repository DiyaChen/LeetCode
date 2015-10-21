/*
Search in Rotated Sorted Array 

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        return bs(nums, 0, nums.length - 1, target);
    }
    
    private int bs(int[] nums, int a, int b, int target){
        if(a == b){
            return nums[a] == target ? a : -1;
        }
        int m = (a + b) / 2;
        if(nums[m] == target) return m;
        
        if(nums[a] < nums[m]){
            if(nums[a] <= target && target < nums[m]){
                return bs(nums, a, m, target);
            }else{
                return bs(nums, m + 1, b, target);
            }
        }else if(nums[a] > nums[m]){
            if(nums[m] < target && target <= nums[b]){
                return bs(nums, m + 1, b, target);
            }else{
                return bs(nums, a, m, target);
            }
        }else{  // nums[a] == nums[m]: a == m
            return bs(nums, m + 1, b, target);
        }
    }
}