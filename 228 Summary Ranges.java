/*
Summary Ranges 

Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String>  result = new ArrayList<String>();
        if(nums == null || nums.length == 0) return result;
        int len = nums.length;
        if(len == 1){
            result.add(Integer.toString(nums[0]));
            return result;
        }
        int start = 0;
        for(int end = 1; end < len; end++){
            if(nums[end - 1] + 1 != nums[end]){
                if(start == end - 1){
                    result.add(Integer.toString(nums[start]));
                }else{
                    result.add(Integer.toString(nums[start]) + "->" + Integer.toString(nums[end - 1]));
                }
                start = end;
            }
        }
        // have to add the last segment to result and there are two cases
        if(start == len - 1){
            result.add(Integer.toString(nums[start]));
        }else{
            result.add(Integer.toString(nums[start]) + "->" + Integer.toString(nums[len - 1]));
        }
        return result;
    }
}