/*
Palindrome Number 

Determine whether an integer is a palindrome. Do this without extra space.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) 
            return false;
        int res = 0;
        int input = x;
        while(x != 0)
        {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if(res == input)
            return true;
        else
            return false;

        /*
        if(x < 0) return false;
        int y = 1;
        while(x/y >= 10){   // until x and y have same digit
            y *= 10;
        }
        while(x > 0){
            int left = x / y;
            int right = x % 10;
            if(left != right) return false;
            x = (x % y) / 10;
            y = y / 100;
        }
        return true;*/
    }
}