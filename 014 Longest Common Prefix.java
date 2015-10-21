/*
Longest Common Prefix 

Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < strs[0].length(); i++){
            for(int j = 1; j < strs.length; j++){
                if(i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}