/*
Container With Most Water

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length < 2){
            return 0;
        }
        int max = 0;
        int head = 0;
        int rear = height.length - 1;
        while(head + 1 <= rear){
            int vol = (rear - head) * Math.min(height[head], height[rear]);
            if(vol > max){
                max = vol;
            }
            if(height[head] > height[rear]){
                rear--;
            }else{
                head++;
            }
        }
        return max;
    }
}