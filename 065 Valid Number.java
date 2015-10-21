/*
Valid Number 

Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
*/

/*
+- can be more than once
.  at most once
e  at most once

+- can be first one; cannot be last one
.  can be first one; can be the last one
e  cannot be first one; cannot be last one
**/

public class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        s = s.trim();
        if(s.length() == 0) return false;
        
        boolean hasE = false;
        boolean hasD = false;
        boolean lastIsN = false;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            // only concern about the characters before them
            if(ch == '+' || ch == '-'){
                if(i != 0 && s.charAt(i - 1) != 'e' || i == s.length() - 1){    // has constrains in the middle, cannot be the last
                    return false;
                }
                lastIsN = false;
            }else if(ch == '.'){
                if(hasD || hasE || (i == s.length() - 1 && !lastIsN)){  // has constrains in the middle and last
                    return false;
                }
                hasD = true;
                lastIsN = false;
            }else if(ch == 'e'){
                if(hasE || i == 0 || i == s.length() - 1){  // cannot be the first, has constains in the middle, cannot be the last
                    return false;
                }
                // the constrains in the middle
                if(s.charAt(i - 1) > '9' || s.charAt(i - 1) < '0'){ // the last one is not number
                    if(s.charAt(i - 1) != '.' || i == 1){// the last is not dot or only have dot
                        return false;
                    }
                }
                hasE = true;
                lastIsN = false;
            }else if(ch >= '0' && ch <= '9'){
                lastIsN = true;
            }else{
                return false;
            }
        }
        return true;
    }
}