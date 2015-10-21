/*
Maximum Gap 

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
*/

/*Suppose there are N elements (N - 1 buckets between them) and they range from A to B, then the maximum gap will be no smaller than flooring[(B - A) / (N - 1)]

Let the number of buckets is N here, the length of a bucket to be len = flooring[(B - A) / N], for any number K in the array, we can easily find out which bucket it belongs by calculating num[i]-min : index - 0 == max - min : (buckets.length - 1) - 0 and therefore maintain the maximum and minimum elements in each bucket.

Since the maximum difference between elements in the same buckets will be at most (B - A)/N, so the final answer will not be taken from two elements in the same buckets.

For each non-empty buckets p, find the next non-empty buckets q, then q.min - p.max could be the potential answer to the question. Return the maximum of all those values.
*/

class Bucket{
    int low;
    int high;
    Bucket(){
        low = Integer.MAX_VALUE;
        high = Integer.MIN_VALUE;
    }
}

public class Solution {
    public static int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        Bucket[] buckets = new Bucket[nums.length]; // n buckets
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new Bucket();
        }
        double ratio = (    (double)(buckets.length - 1 - 0)    ) / (max - min);    // MUST CONVERT TO DOUBLE FIRST!!!!!!!
        for(int i = 0; i < nums.length; i++){
            int index = (int)((nums[i] - min) * ratio);   // num[i]-min : index - 0 == max - min : (buckets.length - 1) - 0
            buckets[index].low = Math.min(buckets[index].low, nums[i]);
            buckets[index].high = Math.max(buckets[index].high, nums[i]);
        }
        int gap = 0;
        int pre = buckets[0].high;
        for(int i = 1; i < buckets.length; i++){
            if(buckets[i].low != Integer.MAX_VALUE){
                gap = Math.max(gap, buckets[i].low - pre);
                pre= buckets[i].high;
            }
        }
        return gap;
    }
}

