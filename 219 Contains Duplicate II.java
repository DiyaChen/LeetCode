/*
Contains Duplicate II 

Given an array of integers and an integer k, find out whether there there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
*/

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();    // <value, index>
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int preIndex = map.get(nums[i]);
                int gap = i - preIndex;
                diff = Math.min(diff, gap);
                if(diff <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}