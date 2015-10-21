/*
House Robber II 

Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int len = nums.length;
        int[] excludeFirst = new int[len];
        excludeFirst[0] = 0;
        excludeFirst[1] = nums[1];
        for(int i = 2; i < len; i++){
            excludeFirst[i] = Math.max(nums[i] + excludeFirst[i - 2], excludeFirst[i - 1]);
        }
        
        int[] excludeLast = new int[len];
        excludeLast[len - 1] = 0;
        excludeLast[len - 2] = nums[len - 2];
        for(int i = len - 3; i >= 0; i--){
            excludeLast[i] = Math.max(nums[i] + excludeLast[i + 2], excludeLast[i + 1]);
        }
        return Math.max(excludeFirst[len - 1], excludeLast[0]);
    }
}