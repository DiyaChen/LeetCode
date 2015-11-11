/*
Majority Element II 

Given an integer array of size n, find all elements that appear more than floor(n/3)times. The algorithm should run in linear time and in O(1) space.
*/

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return result;
        int count1 = 0;
        int count2 = 0;
        int candidate1 = 0;
        int candidate2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candidate1){
                count1++;
            }else if(nums[i] == candidate2){
                count2++;
            }else{
                if(count1 == 0){
                    candidate1 = nums[i];
                    count1++;
                }else if(count2 == 0){
                    candidate2 = nums[i];
                    count2++;
                }else{
                    count1--;
                    count2--;
                }
            }
        }
        count1 = 0;
        count2 = 0;
        // count1 and count2 must be restored as they may be destroied
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candidate1) count1++;
            if(nums[i] == candidate2) count2++;
        }
        // have to know how many candidates meet the requirement before add them to result
        if(count1 > nums.length/3) result.add(candidate1);
        if(count2 > nums.length/3) result.add(candidate2);
        return result;
    }
}