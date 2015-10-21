/*
Palindrome Partitioning II

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

public class Solution {
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        boolean[][] isPal = new boolean[len][len];  // isPal[i][j]: s[i : j] is palindrome or not
        int[] cut = new int[len];   // cut[i]: last index is i
        for(int j = 0; j < len; j++){   // j is index
            cut[j] = j;
            for(int i = 0; i <= j; i++){    // i is index
                if(s.charAt(i) == s.charAt(j) && (i + 1 >= j || isPal[i + 1][j - 1])){  // s[i : j] is palindrome
                    isPal[i][j] = true;
                    if(i == 0) cut[j] = 0;  // s[0 : j] is palindrome
                    else cut[j] = Math.min(cut[j], cut[i - 1] + 1);   // s[0 : j] = s[0 : i - 1] and s[i : j]
                }
            }
        }
        return cut[len - 1];
    }
}

//

public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] cuts = new int[len + 1];  // cuts[i]: i is length
        for (int i = 0; i <= len; i++) cuts[i] = i - 1;
        for (int i = 0; i < len; i++) { // i is index
            // odd palin
            for (int j = 0; i - j >= 0 && i + j < len && s.charAt(i - j) == s.charAt(i + j); j++)   // j is offset
                cuts[i + j + 1] = Math.min(cuts[i + j + 1], cuts[i - j] + 1);
            // even palin
            for (int j = 1; i - j + 1 >= 0 && i + j < len && s.charAt(i - j + 1) == s.charAt(i + j); j++)   // j is offset
                cuts[i + j + 1] = Math.min(cuts[i + j + 1], cuts[i - j + 1] + 1);
        }
        return cuts[len];
    }