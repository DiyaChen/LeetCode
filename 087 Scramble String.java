/*
Scramble String 

Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;
        int len = s1.length();
        boolean[][][] table = new boolean[len][len][len + 1];//table[i][j][l], i and j are indices, l is length, table[i][j][l] = isScramble(s1(i,i + l - 1), s2(j, j + l - 1))
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                table[i][j][1] = s1.charAt(i) == s2.charAt(j);  // length == 1
            }
        }
        for(int l = 2; l <= len; l++){  // length start from 2
            for(int i = 0; i <= len - l; i++){  // start index
                for(int j = 0; j <= len - l; j++){  //start index
                    boolean dft = false;
                    for(int k = 1; k <= l - 1 && dft == false; k++){
                        dft = (table[i][j][k] && table[i + k][j + k][l - k] || table[i][j + l - k][k] && table[i + k][j][l - k]);
                    }
                    table[i][j][l] = dft;
                }
            }
        }
        return table[0][0][len];
    }
}