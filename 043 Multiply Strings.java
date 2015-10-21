/*
Multiply Strings

Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
*/

public class Solution{
    public String multiply(String num1, String num2) {
        String n1 = new StringBuffer(num1).reverse().toString();    // StringBuffer.reverse()
        String n2 = new StringBuffer(num2).reverse().toString();
        int[] result = new int[n1.length() + n2.length()];
        for(int i = 0; i < n1.length(); i++){
            for(int j = 0; j < n2.length(); j++){
                result[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }
        StringBuffer ans = new StringBuffer();
        for(int i = 0; i < result.length; i++){
            int mod = result[i] % 10;
            int carry = result[i] / 10;
            if(i < result.length - 1){
                result[i + 1] += carry;
            }
            ans.insert(0, mod);    // StringBuffer.insert()
        }
        while(ans.charAt(0) == '0' && ans.length() >= 2){
            ans.deleteCharAt(0);   // StringBuffer.deleteCharAt()
        }
        return ans.toString();
    }
}