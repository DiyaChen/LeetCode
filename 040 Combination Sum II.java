/*
Combination Sum II 

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 

A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        Arrays.sort(candidates);
        dfs(result, list, candidates, 0, target);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> list, int[] candidates, int start, int target){
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<Integer>(list));
        }
        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            dfs(result, list, candidates, i + 1, target - candidates[i]);   // next round starts from i + 1
            list.remove(list.size() - 1);
            while(i < candidates.length - 1 && candidates[i] == candidates[i + 1]){ // skip duplicate element
                i++;
            }
        }
    }
}