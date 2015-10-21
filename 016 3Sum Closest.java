/*
3Sum Closest  

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution{
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int diff = 0;
        int mini = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i <= nums.length - 3; i++){
            int low = i + 1;
            int high = nums.length-1;
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if(sum == target){
                    return target;
                }
                diff = Math.abs(sum - target);
                if(diff < mini){
                    mini = diff;
                    result = sum;
                }
                if(sum > target){
                    high--;
                }
                if(sum < target){
                    low++;
                }
            }
        }
        return result;
    }
}