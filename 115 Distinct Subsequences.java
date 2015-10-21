/*
Distinct Subsequences 

Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/

// count how many method by which s can creat a substring of s and the substring equals to t

public class Solution {
    public int numDistinct(String s, String t) {
        if(s == null || t == null) return 0;
        int m = s.length();
        int n = t.length();
        if(m < n) return 0;
        int[][] dp = new int[m + 1][n + 1]; // dp[i][j]: length == i and j
        for(int i = 0; i <= m; i++){
            dp[i][0] = 1;   // if target string length is 0
        }
        for(int i = 1; i <= m; i++){    // i is length
            for(int j = 1; j <= n; j++){    // j is length
                dp[i][j] = dp[i - 1][j] + (s.charAt(i - 1) == t.charAt(j - 1) ? dp[i - 1][j - 1] : 0);
            }
        }
        return dp[m][n];
    }
}


/**
 * Space optimized, 1D array, build row by row
 */
public int numDistinctOptimal(String s, String t) {
    if (s == null || t == null) return 0;
    int m = t.length();
    int n = s.length();
    if (m > n) return 0;
    
    int[] dp = new int[m + 1];
    dp[0] = 1;
    
    for (int i = 1; i <= n; i++)
        for (int j = m; j >= 1; j--)
            // same: path[i] = path[i] + (T[i-1] == S[j-1] ? path[i-1] : 0);
            if (t.charAt(j - 1) == s.charAt(i - 1)) dp[j] += dp[j - 1];
    return dp[m];
}