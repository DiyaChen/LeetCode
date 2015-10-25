/*
Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1. 
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //method1
        if(s == null || s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int start = 0;
        int len = 0;
        for(int i = 0; i<s.length(); i++)
        {
            if(map.containsKey(s.charAt(i)))
               start = Math.max(start, map.get(s.charAt(i))+1); 
            map.put(s.charAt(i),i);
            len = Math.max(len, i-start+1);
        }
        return s.substring(left, left+len);

        /* method2
        if(s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<Character>();
        int max = 1;
        int start = 0;
        for(int end = 0; end < s.length(); end++){
            char cur = s.charAt(end);
            if(!set.contains(cur)){
                set.add(cur);
                max = Math.max(max, end - start + 1);
            }else{
                while(set.contains(cur)){
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(cur);
                max = Math.max(max, end - start + 1);
            }
        }
        return max;*/
    }
}