/*
Letter Combinations of a Phone Number 

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

1    ,  2 abc, 3 def
4 ghi,  5 jkl, 6 mno
7 pqrs, 8 tuv, 9 wxyz

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        if(digits == null || digits.length() == 0){
            return result;
        }
        String[] table = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(result, sb, table, digits, 0);
        return result;
    }
    
    private void dfs(List<String> result, StringBuffer sb, String[] table, String digits, int index){
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }
        String candidates = table[digits.charAt(index) - '0'];
        for(int i = 0; i < candidates.length(); i++){
            sb.append(candidates.charAt(i));
            dfs(result, sb, table, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
}