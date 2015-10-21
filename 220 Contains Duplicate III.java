/*
Contains Duplicate III 

Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
*/

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null) {
            return false;
        }
        TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();  // <value, index>
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                map.remove((long)nums[i-k-1]);
            }
            long val = (long)nums[i];
            Long greater = map.ceilingKey(val); // Returns the least key greater than or equal to the given key
            if (greater != null && greater - val <= t) {
                return true;
            }
            Long smaller = map.lowerKey(val);   // Returns the greatest key strictly less than the given key
            if (smaller != null && val - smaller <= t) {
                return true;
            }
            map.put(val, i);
        }
        return false;
    }
}