/*
First Missing Positive

Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

/*
 * Position of integer n should be n - 1 if sorted
 * Correct form [1, 2, 3, 4, ..., #, n]
 * If not in position swap it with A[A[p]-1]
 */
public class Solution{
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        int len = nums.length;
        for(int i = 0; i < len; i++){
            while(nums[i] >= 1 && nums[i] <= len && nums[nums[i] - 1] != nums[i]){
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for(int i = 0; i < len; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return len + 1;       
    }
}