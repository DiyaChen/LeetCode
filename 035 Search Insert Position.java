/*
Search Insert Position 

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        return bs(nums, 0, nums.length - 1, target);
    }
    
    private int bs(int[] nums, int left, int right, int target){
        if(left == right){
            if(target <= nums[left]){
                return left;
            }else{
                return left + 1;
            }
        }
        int mid = (left + right) / 2;
        if(target == nums[mid]){
            return mid;
        }else if(target < nums[mid]){
            return bs(nums, left, mid, target); // mid - 1 may exceeds boundary when left = mid
        }else{
            return bs(nums, mid + 1, right, target);
        }
    }
}