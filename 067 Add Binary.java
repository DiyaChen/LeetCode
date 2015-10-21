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
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;

        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();
        int[] result = new int[Math.max(a.length(), b.length()) + 1];

        for(int i = 0; i < result.length; i++){
            int first = i >= a.length() ? 0 : a.charAt(i) - '0';
            int second = i >= b.length() ? 0 : b.charAt(i) - '0';
            result[i] = first + second;
        }

        StringBuffer ans = new StringBuffer();
        for(int i = 0; i < result.length; i++){
            int mod = result[i] % 2;
            int carry = result[i] / 2;
            if(i < result.length - 1){
                result[i + 1] += carry;
            }
            ans.insert(0, mod);
        }
        while(ans.charAt(0) == '0' && ans.length() > 1){
            ans.deleteCharAt(0);
        }
        return ans.toString();
    }
}