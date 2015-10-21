/*
Kth Largest Element in an Array 

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k){
        int mid = partition(nums, left, right);
        if(mid == k){
            return nums[mid];
        }else if(mid < k){
            return quickSelect(nums, mid + 1, right, k);
        }else{
            return quickSelect(nums, left, mid - 1, k);
        }
    }
    
    private int partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int done = left - 1;
        for(int i = left; i < right; i++){
            if(nums[i] < pivot){
                done++;
                swap(nums, done, i);
            }
        }
        done++;
        swap(nums, done, right);
        return done;
    }
    
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}