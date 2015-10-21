/*
Regular Expression Matching

Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/
/*
back tracking:
1.If the next character of p is NOT '*', then it must match the current character of s. Continue pattern matching with the next character of both s and p.
2.If the next character of p is '*', then we do a brute force exhaustive matching of 0, 1, or more repeats of current character of p… Until we could not match any more characters.
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0) return s.length() == 0;
        if(p.length() == 1){
            if(s.length() != 1 || s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') return false;
            else return true;
        }
        
        // p.length() > 1
        if(p.charAt(1) != '*'){
            if(s.length() < 1 || s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') return false;
            else return isMatch(s.substring(1), p.substring(1));
        }else{  // the second is *
            // case 1: do not need p[0], then also do not need p[1], say '*'
            if(isMatch(s, p.substring(2))) return true;
            
            // case 2: need p[0], then may also need p[1], say '*'
            int i = 0;
            while(i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')){
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }
}