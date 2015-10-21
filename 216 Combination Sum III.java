/*
Combination Sum III 

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(result, list, 1, n, k);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> list, int start, int sum, int count){
        if(sum == 0 && list.size() == count){
            List<Integer> newList = new ArrayList<Integer>(list);
            result.add(newList);
            return;
        }

        for(int i = start; i <= 9; i++){
            if(i > sum){
                break;
            }
            if(list.size() == count){
                break;
            }
            list.add(i);
            dfs(result, list, i + 1, sum - i, count);
            list.remove(list.size() - 1);
        }
    }
}