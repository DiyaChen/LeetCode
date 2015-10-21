/*
Combinations

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(n <= 0 || n < k){
            return result;
        }
        DFS(result, list, 1, n, k);
        return result;
    }
    
    private void DFS(List<List<Integer>> result, List<Integer> list, int start, int end, int length){
        if(list.size() == length){
            result.add(new ArrayList<Integer>(list));
        }
        for(int i = start; i <= end; i++){
            list.add(i);
            DFS(result, list, i + 1, end, length);
            list.remove(list.size() - 1);
        }
    }
}