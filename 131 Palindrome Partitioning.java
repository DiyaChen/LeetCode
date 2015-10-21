/*
Palindrome Partitioning 

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return null;
        }
        dfs(result, list, s);
        return result;
    }
    
    private void dfs(List<List<String>> result, List<String> list, String s){
        if(s.length() == 0){
            result.add(new ArrayList<String>(list));
        }
        int len = s.length();
        for(int i = 1; i <= len; i++){
            String subString = s.substring(0, i);
            if(isPalindrome(subString)){
                list.add(subString);
                String remainString = s.substring(i);
                dfs(result, list, remainString);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}