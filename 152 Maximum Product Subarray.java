/*
Maximum Product Subarray 

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] maxEndBy = new int[nums.length];
        int[] minEndBy = new int[nums.length];
        int result;
        maxEndBy[0] = nums[0];
        minEndBy[0] = nums[0];
        result = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            maxEndBy[i] = Math.max(Math.max(maxEndBy[i - 1] * nums[i], minEndBy[i - 1] * nums[i]), nums[i]);
            minEndBy[i] = Math.min(Math.min(minEndBy[i - 1] * nums[i], maxEndBy[i - 1] * nums[i]), nums[i]);
            result = Math.max(result, maxEndBy[i]);
        }
        return result;
    }
}