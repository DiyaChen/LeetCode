/*
Restore IP Addresses

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        if(s == null || s.length() == 0 || s.length() > 12){
            return result;
        }
        dfs(result, sb, s, 1);
        return result;
    }
    
    private void dfs(List<String> result, StringBuffer sb, String s, int segment){
        if(s == null || s.length() == 0){
            return;
        }
        if(segment == 4){
            if(validIp(s)){
                sb.append(s);
                result.add(sb.toString());
            }
            return;
        }
        
        for(int i = 1; i <= 3 && i <= s.length(); i++){
            String str = s.substring(0, i);
            if(validIp(str)){
                int beginIndex = sb.length();
                sb.append(str).append(".");
                dfs(result, sb, s.substring(i), segment + 1);
                sb.delete(beginIndex, sb.length()); // StringBuffer.delete(int start, int end)
            }
        }
    }
    
    private boolean validIp(String s){
        if(s == null || s.length() == 0 || s.length() > 3){
            return false;
        }
        if(s.charAt(0) == '0' && s.length() > 1){
            return false;
        }
        int number = Integer.valueOf(s);
        if(number >= 0 && number <= 255){
            return true;
        }
        return false;
    }
}