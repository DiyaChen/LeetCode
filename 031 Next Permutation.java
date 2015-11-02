/*
Next Permutation 

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
/*
* From right to left, find the first digit which violate the increase trend,
* in this example, 6 will be selected since 87432 already in a increase trend.
* 
* From right to left, find the first digit which large than 6, here the 7 will be selected.
* 
* Swap the two number.
* 
* Reverse all the digit on the right of partition index.
* 
* 6 8 7 4 3 2
* 6* 8 7 4 3 2
* 6* 8 7* 4 3 2
* 7* 8 6* 4 3 2
* 7  2 3 4 6 8
*/
public class Solution {
    
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 1){
            return;
        }
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                int j = nums.length-1;
                while(j>i)
                {
                    if(nums[j] > nums[i])
                        break;
                    j--;
                }
                swap(nums, i, j);
                reverse(nums, i+1);
                return;
            }
        }
        reverse(nums,0);//if doesn't find the next permutation, then reverse the whole array
    }
    private void swap(int[] nums, int i , int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void reverse(int[] nums, int s)
    {
        if(nums == null || nums.length == 0) return;
        int e = nums.length-1;
        while(s<e)
        {
            swap(nums,s,e);
            s++;
            e--;
        }
    }

}
        
        