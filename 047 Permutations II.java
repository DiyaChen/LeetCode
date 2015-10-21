/*
Permutations II  

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        dfs(result, nums, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, int[] nums, int start){
        if(start == nums.length){
            List<Integer> list = new ArrayList<Integer>();
            for(int a : nums){
                list.add(a);
            }
            result.add(list);
            return;
        }
        
        search:
        for(int i = start; i < nums.length; i++){
            for(int j = start; j < i; j++){
                if(nums[j] == nums[i]){
                    continue search;    // skip the dup
                }
            }
            swap(nums, start, i);
            dfs(result, nums, start + 1);
            swap(nums, start, i); // restore
        }
    }
    
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}