/*
Length of Last Word 

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        char space = ' ';
        if(s.indexOf(space) == -1) return s.length();   // no space in the words
        int len = s.length();
        for(int i = len - 1; i >= 0; i--){
            if(s.charAt(i) == ' ') return len - 1 - i;
        }
        return 0;
    }
}