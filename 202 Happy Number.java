/*
Happy Number 

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

public class Solution {
    public boolean isHappy(int n) {
        if(n == 0){
            return false;
        }
        HashSet<Integer> appeared = new HashSet<Integer>();
        while(!appeared.contains(n)){
            appeared.add(n);
            int[] digits = getDigits(n);
            int sum = 0;
            for(int i = 0; i < digits.length; i++){
                sum += digits[i] * digits[i];
            }
            n = sum;
            if(n == 1){
                return true;
            }
        }
        return false;
    }
    
    public int[] getDigits(int n){
        String s = String.valueOf(n);
        int[] result = new int[s.length()];
        for(int i = s.length() - 1; i >= 0; i--){
            result[i] = n % 10;
            n /= 10;
        }
        return result;
    }
}