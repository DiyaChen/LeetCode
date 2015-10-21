/*
Decode Ways 

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
      return 0;
    }
    
    int[] nums = new int[s.length() + 1]; // nums[i]: length == i
    nums[0] = 1;
    nums[1] = s.charAt(0) != '0' ? 1 : 0;
    
    for (int i = 2; i <= s.length(); i++) {
        int p1 = 0;
      if (s.charAt(i - 1) != '0') {   // if nums[i] can be a valid one digit
        p1 = nums[i - 1];
      }
      
      int p2 = 0;
      int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0'; 
      if (twoDigits >= 10 && twoDigits <= 26) {   // if nums[i - 1] and nums[i] can be a valid two digit number
        p2 = nums[i - 2];
      }
      nums[i] = p1 + p2;
    }
    
    return nums[s.length()];
    }
}