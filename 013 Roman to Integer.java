/*
Roman to Integer 

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    public int romanToInt(String s) {
        if(s.length() == 1){
            return convert(s.charAt(0));
        }
        int sum = convert(s.charAt(0));
        
        for(int i = 1; i < s.length(); i++){
            if(convert(s.charAt(i-1)) >= convert(s.charAt(i))){
                sum = convert(s.charAt(i)) + sum;
            }else if(convert(s.charAt(i-1)) < convert(s.charAt(i))){
                sum = sum - convert(s.charAt(i-1)) + convert(s.charAt(i)) - convert(s.charAt(i-1));
            }
        }
        return sum;
    }
    public int convert(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }
}