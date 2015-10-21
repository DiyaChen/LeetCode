/*
Simplify Path

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/

public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return new String("/");
        }

        String[] table = path.split("/");
        StringBuffer result = new StringBuffer();
        Stack<String> stack = new Stack<String>();
        
        for(String s : table){
            if(s.length() == 0 || s.equals(".")){
                continue;
            }
            if(s.equals("..")){
                if(!stack.empty()){
                    stack.pop();
                }
            }else{
                stack.push(s);
            }
        }
        while(!stack.empty()){
            String s = stack.pop();
            result.insert(0, s);
            result.insert(0, "/");
        }
        if(result.length() == 0){
            return new String("/");
        }
        return result.toString();
    }
}