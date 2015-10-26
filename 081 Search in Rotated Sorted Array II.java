/*
Search in Rotated Sorted Array II 

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/

public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        return bs(nums, 0, nums.length - 1, target);
    }
    
    private boolean bs(int[] nums, int a, int b, int target){
        if(a == b){
            return nums[a] == target ? true : false;
        }
        int m = (a + b) / 2;
        if(nums[m] == target) return true;
        
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
        }else{  // nums[a] == nums[m]: a == m or a != m
            if(nums[m] != nums[b]){ // nums[a] ~ nums[m] are repeats
                return bs(nums, m + 1, b, target);
            }else{  // have to search both side
                if(bs(nums, m + 1, b, target)) return true;
                return bs(nums, a, m, target);  // !! cannot m - 1 since if a == m, m - 1 exceeds boundary
            }
        }
    }
}