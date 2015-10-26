/*
Multiply Strings

Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
*/

public class Solution{
    public String multiply(String num1, String num2) {
      if(num1 == null || num2 == null ) return null;
        int[] res = new int[num1.length()+num2.length()];
        for(int i = num1.length()-1; i>=0; i--)
            for(int j = num2.length()-1; j>=0; j--)
            {
                int temp = res[i+j+1] + (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                res[i+j+1] = temp % 10;
                res[i+j] += temp/10;
            } 
            
       StringBuilder sb = new StringBuilder();
       if(res[0] == 0)
       {
           for(int n = 1; n< num1.length()+num2.length() ; n++)
            sb.append(res[n]); 
       }else{
            for(int n = 0; n< num1.length()+num2.length(); n++)
             sb.append(res[n]); 
       }
       return sb.toString();
    }
}