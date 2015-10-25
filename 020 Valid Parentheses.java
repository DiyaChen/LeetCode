/*
Remove Nth Node From End of List 

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        if(s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(')');
            }
            if(s.charAt(i) == '{'){
                stack.push('}');
            }
            if(s.charAt(i) == '['){
                stack.push(']');
            }
            if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'){
                if(stack.empty() || stack.peek() != s.charAt(i)){
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.empty()){
            return true;
        }else{
            return false;
        }
    }
}