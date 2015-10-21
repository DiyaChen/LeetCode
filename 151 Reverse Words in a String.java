/*
Reverse Words in a String

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/

public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return new String();
        }
        String[] array = s.split(" ");
        StringBuffer result = new StringBuffer();
        for(int i = array.length - 1; i >= 0; i--){
            if(!array[i].equals("")){
                result.append(array[i]).append(" ");
            }
        }
        if(result.length() == 0){
            return "";
        }else{
            return result.toString().substring(0, result.length() - 1);
        }
    }
}