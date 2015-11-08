/*
Fraction to Recurring Decimal 

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        if (numerator == 0) return "0";
        
        StringBuilder res = new StringBuilder();
        Long n = new Long(numerator); // if the integer is the Integer_Min -2147483648,then make it abs will overflow, so convert it to long
        Long d = new Long(denominator);
        if ((n < 0 && d > 0) || (n > 0 && d < 0)) res.append("-"); // negative
        
        n = Math.abs(n); // to abstract value
        d = Math.abs(d);
        res.append(n / d); // before dot 
        if (n % d == 0) return res.toString(); // no fraction
        
        res.append("."); // add dot
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();  // <remainder, position>
        Long r = n % d; // get first remainder
        while (r > 0) {
            if (map.containsKey(r)) { // remainder appeared before
                res.insert(map.get(r), "("); // insert an open paren
                res.append(")"); // append a close paren
                break;
            }
            map.put(r, res.length()); // save remainder and the length
            r *= 10; // simulate long division
            res.append(r / d);
            r %= d; // get next remainder
        }
        return res.toString();
    }
}

