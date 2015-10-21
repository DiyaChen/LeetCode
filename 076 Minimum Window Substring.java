/*
Minimum Window Substring 

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length()) return "";
        String result = "";
        int miniLength = s.length() + 1;
        int effectiveCha = 0;
        Map<Character, Integer> source = new HashMap<Character, Integer>(); // <valid character, frequency>
        Map<Character, Integer> target = new HashMap<Character, Integer>(); // <character, frequency>

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(!target.containsKey(c)){
                target.put(c, 1);
            }else{
                target.put(c, target.get(c) + 1);
            }
        }

        int start = 0;
        for(int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            if(target.containsKey(c)){  // hit a valide character
                if(!source.containsKey(c)){ // that is not stored in source pool
                    source.put(c, 1);
                    effectiveCha++;                   
                }else{  // that is already stored in source pool
                    if(source.get(c) < target.get(c)){  // but if the frequency is not enough
                        effectiveCha++;
                    }
                    source.put(c, source.get(c) + 1);   // the valide character may be redundant
                }
            }
            if(effectiveCha == t.length()){
                char beginChar = s.charAt(start);
                while(!source.containsKey(beginChar) || source.get(beginChar) > target.get(beginChar)){ // if character is invalide or redundant
                    if(source.containsKey(beginChar)){ // if is redundant
                        source.put(beginChar, source.get(beginChar) - 1);   // update the frequency
                    }
                    start++;
                    beginChar = s.charAt(start);
                }
                if(end - start + 1 < miniLength){
                    miniLength = end - start + 1;
                    result = s.substring(start, end + 1);
                }
            }
        }
        return result;
    }
}