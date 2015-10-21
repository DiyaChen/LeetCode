/*
Single Number II 

Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        if(nums.length == 1){
            return nums[0];
        }
        
        int[] bits = new int[32];
        for(int j = 0; j < 32; j++){
            bits[j] = 0;
        }
        
        for(int i = 0; i < nums.length; i++){
            for(int k = 0; k < 32; k++){
                bits[k] += (nums[i] & (1 << (31-k))) >> (31-k);
            }
        }
        
        int result = 0;
        for(int k = 0; k < 32; k++){
            result += (bits[k] % 3) << (31 - k);
        }
        
        return result;
    }
}