/*
Wildcard Matching

Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

/*  
'*' can match any sequence, they do not need be the same character whenever encounter '*' in p, keep record of the current position of '*' in p and the current index in s. Try to match the stuff behind this '*' in p with s, if not matched, just s++ and then try to match again.
*/
/*
There are four case: s(i) == p(j); p(i) == '?'; p(i) == '*'; s(i) != p(i)
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int markS = -1;
        int markP = -1;
        while(i < s.length()){
            if(j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
                i++;
                j++;
            }else if(j < p.length() && p.charAt(j) == '*'){
                markS = i;
                markP = j;
                j++;
            }else if(markP != -1){  // s[i] != p[j] and have * in front of position j, 
                markS++;
                i = markS;
                j = markP + 1;  // reset j to the behind of *
            }else{
                return false;
            }
        }
        // s have been traversed thoroughly
        while(j < p.length() && p.charAt(j) == '*'){    // if left several * in p
            j++;
        }
        return j == p.length();
    }
}