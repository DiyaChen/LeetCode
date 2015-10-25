z/*
Generate Parentheses 

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        if(n <= 0){
            return result;
        }
        dfs(result, sb, n, 0);
        return result;
    }
    
    private void dfs(List<String> result, StringBuffer sb, int leftRemain, int rightAtMost){
        if(leftRemain == 0 && rightAtMost == 0){
            result.add(sb.toString());
            return;
        }
        if(leftRemain > 0){
            dfs(result, sb.append("("), leftRemain - 1, rightAtMost + 1);
            sb.deleteCharAt(sb.length() - 1);  
        }
        if(rightAtMost > 0){
            dfs(result, sb.append(")"), leftRemain, rightAtMost - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
}