/*
Largest number 

Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return new String();
        }
        StringBuffer result = new StringBuffer();
        String[] str = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String s1, String s2){
                String leftRight = s1 + s2;
                String rightLeft = s2 + s1;
                return rightLeft.compareTo(leftRight);
            }
        });
        for(int i = 0; i < nums.length; i++){
            result.append(str[i]);
        }
        while(result.charAt(0) == '0' && result.length() > 1){
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}