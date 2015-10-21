/*
Word Break 

Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || wordDict == null){
            return false;
        }
        int len = s.length();
        boolean[] result = new boolean[len];
        result[0] = wordDict.contains(s.substring(0, 1)) ? true : false;
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                result[i] = result[j] && wordDict.contains(s.substring(j + 1, i + 1)) || wordDict.contains(s.substring(0, i + 1));
                if(result[i] == true){
                    break;
                }
            }
        }
        return result[len - 1];
    }
}