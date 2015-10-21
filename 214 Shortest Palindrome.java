/*
Shortest Palindrome

Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/

public class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        int blncP = (s.length() - 1) / 2;
        int evenOrOdd = 0;  // final string can have even length or odd length
        while(blncP >= 0){
            evenOrOdd = balance(s, blncP);
            if(evenOrOdd != 0){
                break;
            }
            blncP--;
        }
        StringBuffer right = new StringBuffer(s.substring(blncP + 1));
        StringBuffer left = new StringBuffer(right).reverse();
        if(evenOrOdd == 1){
            return  left.append(s.charAt(blncP)).append(right).toString();
        }else{
            return left.append(right).toString();
        }
    }

    private int balance(String str, int mid){   // return 0: unbalanced; 1 final string is odd; 2 final string is even
        int result = 2; // assume even as even length is shortest

        if(mid < str.length() / 2){ // could even
            int i = mid;
            for(; i >= 0; i--){
                if(str.charAt(i) != str.charAt(2 * mid + 1 - i)){   // cannot even
                    result = 0;
                    break;
                }
            }
        }else{  // cannot even
            result = 0;
        }

        if(result != 2){    // not even, could odd
            result = 1;
            for(int i = mid; i >= 0; i--){
                if(str.charAt(i) != str.charAt(2 * mid - i)){   // cannot odd
                    result = 0;
                    break;
                }
            }
        }
        return result;
    }
}