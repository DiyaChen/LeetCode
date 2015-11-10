/*
Summary Ranges 

Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

public class Solution {
    public List<String> summaryRanges(int[] nums) {
       List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0) return res;
        int s = nums[0];
        int e = nums[0];
        for(int i = 1; i< nums.length; i++)
        {
             if(nums[i]==nums[i-1]+1)
                 e = nums[i];
             else{
                 if(s == e) res.add(String.valueOf(s));
                 else res.add(String.valueOf(s)+"->"+String.valueOf(e));
                 s = nums[i];
                 e = nums[i];
             }
        }
        if(s == e) res.add(String.valueOf(s));
        else res.add(String.valueOf(s)+"->"+String.valueOf(e));
        return res;
    }
}