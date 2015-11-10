/*
Triangle 

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

// Constant space DP
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) return 0;
        int level = triangle.size()-1;
        List<Integer> res = triangle.get(level);
        for(int i = level-1; i>=0; i--)
        {
            for(int j = 0; j<=i; j++)
            {
                int n = Math.min(res.get(j),res.get(j+1)) + triangle.get(i).get(j) ;
                res.set(j,n);
            }
        }
        return res.get(0);
    }
}
