/*
Excel Sheet Column Title 

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/

public class Solution {
    public String convertToTitle(int n) {
        if(n == 0){//special case 
            return new String("");
        }
        StringBuffer sb = new StringBuffer();
        while( n > 0){
            int remainder = (--n) % 26;//get remainder to add 'A'
            char c = (char)('A' + remainder);
            sb.insert(0, c);
            n = n / 26;
        }
        return sb.toString();
    }
}

