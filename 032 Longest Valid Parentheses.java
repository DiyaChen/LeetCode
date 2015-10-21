/*
Longest Valid Parentheses 

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() < 2) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int start = -1;
        int len = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){ // current is '('
                stack.push(i);
            }else{  // current is ')'
                if(stack.empty()){  // no more '(' can pair with current ')', so it is a invalid ')', should reset start
                    start = i;
                }else{  // there is a '(' on the top of the stack can pair with current ')'
                    stack.pop();    // pair them
                    if(stack.empty()){
                        len = Math.max(len, i - start); // ()
                    }else{
                        len = Math.max(len, i - stack.peek());  // (()
                    }
                }
            }
        }
        return len;
    }
}