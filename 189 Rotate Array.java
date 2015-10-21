/*
Rotate Array 

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
Related problem: Reverse Words in a String II
*/

public class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0)
            return;
        int[] tmp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            tmp[(i+k)%nums.length] = nums[i];
        }
        for(int j = 0; j < nums.length; j++){
            nums[j] = tmp [j];
        }
    }
}

//

/*
Assuming we are given {1,2,3,4,5,6} and order 2. The basic idea is:
1. Divide the array two parts: 1,2,3,4 and 5, 6
2. Rotate first part: 4,3,2,1,5,6
3. Rotate second part: 4,3,2,1,6,5
4. Rotate the whole array: 5,6,1,2,3,4
*/
public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k % nums.length == 0) return;
        k = k % nums.length;
        int index = nums.length - 1 - k;
        aux(nums, 0, index);
        aux(nums, index + 1, nums.length - 1);
        aux(nums, 0, nums.length - 1);
    }
    
    private void aux(int[] nums, int start, int end){
        while(nums == null || nums.length == 1) return;
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}