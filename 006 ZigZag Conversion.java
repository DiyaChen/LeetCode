/*
ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0){
            return "";
        }
        if(numRows == 1){
            return s;
        }
        int step = 2 * (numRows - 1);
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < numRows; i++){
            for(int j = i; j < s.length(); j += step){
                result.append(s.charAt(j));
                if(i != 0 && i != numRows - 1 && j + step - 2 * i < s.length()){
                    result.append(s.charAt(j + step - 2 * i));
                }
            }
        }
        return result.toString();
    }
}