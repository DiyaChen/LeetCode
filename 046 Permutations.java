/*
Permutations 

Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        DFS(result, nums, 0);
        return result;
    }
    
    private void DFS(List<List<Integer>> result, int[] nums, int start){
        if(start == nums.length){
            List<Integer> list = new ArrayList<Integer>();
            for(int a : nums){
                list.add(a);
            }
            result.add(list);
            return;
        }
        for(int i = start; i < nums.length; i++){
            swap(nums, start, i);
            DFS(result, nums, start + 1);
            swap(nums, start, i); // restore
        }
    }
    
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}