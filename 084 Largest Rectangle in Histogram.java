/*
Largest Rectangle in Histogram

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

For example,
Given height = [2,1,5,6,2,3],
return 10.
*/

/*
if the right bar is higher than left bar, left bar can keep accumulating area
if the right bar is lower than left bar, all the bars which are higher than current bar cannot accumulate the area in the future, so we have to calulate the area accumulated by each bar and update the max, then discard those bars

push index to stack when the current height is larger than the previous one
calculate max value when the current height is less than the previous one
*/
public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        height = Arrays.copyOf(height, height.length + 1);  // Arrays.copyOf(int[] original, int newlength)
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()] > height[i]){    // previous is higher than current
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}