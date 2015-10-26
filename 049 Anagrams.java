/*
Anagrams 

Given an array of strings, return all groups of strings that are anagrams.

Note:
All inputs will be in lower-case.
*/

public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if(strs == null || strs.length == 0){
            return result;
        }
        Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for(int i = 0; i< strs.length; i++){
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if(!map.containsKey(key)){
                ArrayList<Integer> ls = new ArrayList<Integer>();
                ls.add(i);
                map.put(key, ls);
            }else{
                map.get(key).add(i);
            }
        }
        for(ArrayList<Integer> ls : map.values()){
            if(ls.size() > 1){
                res.add(ls);
            }
        }
        return result;
    }
}