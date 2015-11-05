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
        String str = new String();
        for(int i = array.length - 1; i >= 0; i--){
            if(!array[i].equals("")){
                str += array[i];
                if(i != 0)
                    str += " ";
            }
        }
        return str;
    }
}
//method2, no split, just reverse
public class Solution{
    public String reverseWords(String s){
        s = s.trim();
        if(s == null || s.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(int i = 0; i <= s.length(); i++)
        {
            if(i == s.length())
               sb.insert(0, s.substring(start,i));
           else if(s.charAt(i) == ' ')
           {
               if(i > start)
                    sb.insert(0, ' '+ s.substring(start,i));
               start = i+1;
           }          
        }
        return sb.toString();
    }
}
