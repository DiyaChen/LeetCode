/*
Trapping Rain Water 

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public class Solution {
    public int trap(int[] height) {
        if(height.length < 3){
            return 0;
        }
        int secondHeight = 0;
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            if(height[left] < height[right]){ // right is the first height
                secondHeight = Math.max(secondHeight, height[left]);// secondHeight is always chosen from lower side
                sum += secondHeight - height[left];
                left++;
            }else{  // left is the first height
                secondHeight = Math.max(secondHeight, height[right]);
                sum += secondHeight - height[right];
                right--;
            }
        }
        return sum;
    }
}