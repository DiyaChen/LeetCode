/*
Word Break II

Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0){
            return result;
        }
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        boolean[] dp = new boolean[len + 1];    // dp[i]: substring(i, len) is dividable
        dp[len] = true;
        for(int i = len - 1; i >= 0; i--){
            if(wordDict.contains(s.substring(i, len))){
                dp[i] = true;
            }else{
                for(int j = len - 1; j > i; j--){
                    if(wordDict.contains(s.substring(i, j)) && dp[j]){
                        dp[i] = true;
                    }
                }
            }
        }
        dfs(result, sb, s, wordDict, dp, 0);
        return result;
    }

    private void dfs(List<String> result, StringBuffer sb, String str, Set<String> wordDict, boolean[] dp, int start){
        if(start == str.length()){
            result.add(sb.substring(0, sb.length() - 1).toString());
            return;
        }
        for(int i = start; i <= str.length(); i++){
            String piece = str.substring(start, i);
            if(wordDict.contains(piece) && dp[i]){
                StringBuffer cur = new StringBuffer(sb);
                cur.append(piece);
                cur.append(" ");
                dfs(result, cur, str, wordDict, dp, i);
            }
        }
    }
}