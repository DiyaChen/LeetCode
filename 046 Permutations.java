/*
Permutations 

Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> cur = new ArrayList<Integer>();
        boolean[] isVisited = new boolean[nums.length];
        permute(nums,res,cur,isVisited, 0);
        return res;
    }
    public void permute(int[] nums, List<List<Integer>> res,List<Integer> cur, boolean[] isVisited, int s)
    {
        if(cur.size() == nums.length)
        {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = s; i<nums.length; i++)
        {
            if(!isVisited[i])
            {
                isVisited[i] = true;
                cur.add(nums[i]);
                permute(nums, res, cur, isVisited, s);
                cur.remove(cur.size()-1);
                isVisited[i] = false;
            }
        }
    }
}