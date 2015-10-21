/*
Majority Element 

Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int major = nums[0];
        int count = 0;
        for(int i = 0; i < nums.length && count <= nums.length / 2; i++){
            if(nums[i] == major){
                count++;
            }else{
                if(count == 0){
                    major = nums[i];
                    count++;
                }else{
                    count--;
                }
            }
        }
        return major;
    }
}