/*
Add Binary

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
       int carry = 0;
       for(int i = 0; i< a.length() || i< b.length(); i++)
       {
           int value1 = i < a.length()? a.charAt(a.length()-1-i) - '0' : 0;//the last digit of a, if this digit doesn't exsit, use 0 to make up 
           int value2 = i < b.length()? b.charAt(b.length()-1-i) - '0' : 0;// the last digit of b
           int temp = (value1 + value2 + carry) % 2;//calculate the last digit
           carry = (value1 + value2 + carry) / 2;
           res.insert(0,(char)('0'+temp));//don't forget to add '0'
       }
       if(carry == 1)
        res.insert(0,'1');
       return res.toString();
    }
}