/*
Jump Game II

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/

public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        int canReach = 0;
        int hadReach = 0;
        int steps = 0;
        for(int i = 0; i <= canReach && i < nums.length; i++){
            if(i > hadReach){
                steps++;
                hadReach = canReach;
            }
            canReach = Math.max(canReach, i + nums[i]);
        }
        if(canReach < nums.length - 1){
            return -1;
        }
        return steps;
    }
}