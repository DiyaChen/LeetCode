/*
Implement strStr()

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()){
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }
        search:
        for(int i = 0 ; i < haystack.length() - needle.length() + 1; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                for(int j = 1; j < needle.length(); j++){
                    if(haystack.charAt(i + j) != needle.charAt(j)){
                        continue search;
                    }
                }
                return i;
            }
        }
        return -1;
        
    }
}