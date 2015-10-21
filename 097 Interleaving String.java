/*
Interleaving String

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null) return false;
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if(l3 != l1 + l2) return false;
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        for(int i = 0; i <= l1; i++){
            for(int j = 0; j <= l2; j++){
                if(i == 0 && j == 0) dp[i][j] = true;
                else if(i == 0) dp[i][j] = s2.substring(0, j).equals(s3.substring(0, j));
                else if(j == 0) dp[i][j] = s1.substring(0, i).equals(s3.substring(0, i));
                else dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[l1][l2];
    }
}