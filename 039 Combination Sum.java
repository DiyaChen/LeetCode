/*
Combination Sum 

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 

A solution set is: 
[7] 
[2, 2, 3] 
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        if(candidates == null || candidates.length == 0) 
            return res;
        Arrays.sort(candidates); //in non-descending order
        dfs(res, cur, candidates, 0, target);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> cur, int[] candidates, int start, int target){
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<Integer>(cur));
            return;
        }      
        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            dfs(result, list, candidates, i, target - candidates[i]);   // the next round can also starts from i
            cur.remove(cur.size()-1);
            while(i < candidates.length - 1 && candidates[i] == candidates[i + 1]){ // skip duplicate element
                i++;
            }
        }
    }
}