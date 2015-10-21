/*
Count and Say 

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        if(n == 1){
            return s;
        }
        while(n > 1){
            n--;            
            int count = 1;
            StringBuffer sb = new StringBuffer();
            s += " ";
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i - 1) == s.charAt(i)){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(s.charAt(i-1));
                    count = 1;
                }
            }
            s = sb.toString();
        }
        return s;
    }
}