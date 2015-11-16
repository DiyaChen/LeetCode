/*
Permutations II  

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<Integer>();
        boolean[] isVisited = new boolean[nums.length];
        dfs(nums, res, cur, isVisited, 0);
        return res;
    }
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, boolean[] isVisited, int start){
        if(cur.size() == nums.length)
        {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = start; i< nums.length; i++)
        {
            if(i > start && !isVisited[i-1] && nums[i] == nums[i-1])
                continue;
            if(!isVisited[i])
            {
                isVisited[i] = true;
                cur.add(nums[i]);
                dfs(nums, res, cur, isVisited, start);
                cur.remove(cur.size()-1);
                isVisited[i] = false;
            }
        }
    }
}