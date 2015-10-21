/*
Longest Palindromic Substring

Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        String longest = "";
        for(int i = 0; i < s.length(); i++){
            String tmp = aux(s, i, i);
            if(tmp.length() > longest.length()){
                longest = tmp;
            }
            tmp = aux(s, i, i + 1);
            if(tmp.length() > longest.length()){
                longest = tmp;
            }
        }
        return longest;
    }
    
    private String aux(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}