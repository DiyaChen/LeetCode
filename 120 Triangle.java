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
        int height = triangle.size();
        int wide = triangle.get(height - 1).size();
        int sum[] = new int[wide];
        for(int i = 0; i < wide; i++){
            sum[i] = triangle.get(height - 1).get(i);   // last row initialized sum array
        }
        
        for(int i = height - 2; i >= 0; i--){   // begin from the second last row
            for(int j = 0; j < triangle.get(i).size(); j++){    // traverse each row
                sum[j] = triangle.get(i).get(j) + Math.min(sum[j], sum[j + 1]);
            }
        }
        return sum[0];
    }
}


// Regular DP
public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
        return 0;
    }

    int n = triangle.size();        // 层数
    int[][] sum = new int[n][n];

    for (int i = 0; i < n; i++) {
        sum[n - 1][i] = triangle.get(n - 1).get(i);     // 最后一层各个元素的路径和
    }

    for (int i = n - 2; i >= 0; i--) { 
        for (int j = 0; j <= i; j++) {
            sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1]) + triangle.get(i).get(j);    // bottom-up
        }
    }

    return sum[0][0];   // finally at the top with the smallest sum
}