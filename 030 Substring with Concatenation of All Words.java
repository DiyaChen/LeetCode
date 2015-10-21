/*
Substring with Concatenation of All Words

You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || words == null || words.length == 0) return result;
        
        int len = words[0].length();  // length of word in words
        int length = words.length;
        Arrays.sort(words);
        Set<String> set = new HashSet<String>();
        for(int k = 0; k < words.length; k++){
            set.add(words[k]);
        }
        
        for(int i = 0; i <= s.length() - len * length; i++){
            String substr = s.substring(i, i + len);
            if(set.contains(substr)){
                aux(result, s.substring(i, i + len * length), words, i);
            }
        }
        return result;
    }
    
    private void aux(List<Integer> result, String s, String[] words, int begin){
        int len = words[0].length();
        int length = words.length;
        if(s == null || s.length() != len * length) return;
        String[] strings = new String[length];
        for(int i = 0; i < length; i++){
            strings[i] = s.substring(i * len, (i + 1) * len);
        }
        Arrays.sort(strings);
        for(int i = 0; i < length; i++){
            if(!words[i].equals(strings[i])) return;
        }
        result.add(begin);
    }
}