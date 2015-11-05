/*
Candy 

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/

public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        int[] res1 = new int[ratings.length];
        res1[0] = 1;
        for(int i = 1; i< ratings.length; i++)
        {
            if(ratings[i]>ratings[i-1])
            {
                res1[i] = res1[i-1]+1;
            }else
                res1[i] = 1;
        }
        int[] res2 = new int[ratings.length];
        res2[ratings.length-1] = res1[ratings.length-1];
        for(int i = ratings.length-1; i> 0; i--)
        {
            if(ratings[i] < ratings[i-1])
            {
                res2[i-1] = res2[i]+1;
            }else
                res2[i-1] = 1;
        }
        int sum = 0;
        for(int i = 0; i< ratings.length; i++)
        {
            sum += Math.max(res1[i], res2[i]);
        }
        return sum;
    }
}