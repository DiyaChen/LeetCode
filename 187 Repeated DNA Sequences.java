/*
Repeated DNA Sequences

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 10) return res;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (!map.containsKey(sub)) {
                map.put(sub, 1);
            }else{
                if(map.get(sub) == 1){
                    res.add(sub);
                }
                map.put(sub, map.get(sub) + 1);
            }
        }
        return res;
    }
}