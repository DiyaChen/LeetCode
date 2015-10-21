/*
Evaluate Reverse Polish Notation 

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<String> stack = new Stack<String>();
        int result = 0;
        String optr = "+-*/";
        for(int i = 0; i < tokens.length; i++){
            if(optr.contains(tokens[i])){   // tokens[i] is operator
                int opn1 = Integer.valueOf(stack.pop());
                int opn2 = Integer.valueOf(stack.pop());
                switch(tokens[i].charAt(0)){
                    case '+': stack.push(String.valueOf(opn1 + opn2));
                                break;
                    case '-': stack.push(String.valueOf(opn2 - opn1));
                                break;
                    case '*': stack.push(String.valueOf(opn2 * opn1));
                                break;
                    case '/': stack.push(String.valueOf(opn2 / opn1));
                                break;
                }
            }else{
                stack.push(tokens[i]);
            }
        }
        result = Integer.valueOf(stack.pop());
        return result;
    }
}