/*
Plus One 

Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        int overflow = 1;
        for(int i = 0; i < digits.length; i++){
            if(digits[i] != 9){
                overflow = 0;
                break;
            }
        }
        if(overflow == 1){
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            return newArray;
        }
        int carry = 1;
        for(int i = digits.length -1; i >= 0; i--){
            int mod = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = mod;
            if(carry == 0) break;
        }
        return digits;
    }
}