/*
Longest Consecutive Sequence

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int max = 1;
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            set.add(num);
        }
        for(int num : nums){
            int count = 1;
            int left = num-1;
            int right = num+1;
            while(set.contains(left)){
                set.remove(left);
                count++;
                left--;
            }
            while(set.contains(right)){
                set.remove(right);
                count++;
                right++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}