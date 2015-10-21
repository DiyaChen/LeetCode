/*
Valid Palindrome 

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1){
            return true;
        }
        int p1 = 0;
        int p2 = s.length() - 1;
        while(p1 < p2){
            if(!(s.charAt(p1) >= 'a' && s.charAt(p1) <= 'z' || s.charAt(p1) >= 'A' && s.charAt(p1) <='Z' || s.charAt(p1) >= '0' && s.charAt(p1) <= '9')){
                p1++;
                continue;
            }
            if(!(s.charAt(p2) >= 'a' && s.charAt(p2) <= 'z' || s.charAt(p2) >= 'A' && s.charAt(p2) <='Z' || s.charAt(p2) >= '0' && s.charAt(p2) <= '9')){
                p2--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(p1)) != Character.toLowerCase(s.charAt(p2))){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}