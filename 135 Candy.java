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
        if(ratings == null || ratings.length == 0) return 0;
        int[] candys = new int[ratings.length];
        candys[0] = 1;
        for(int i = 1; i < candys.length; i++){
            if(ratings[i - 1] < ratings[i]){
                candys[i] = candys[i - 1] + 1;
            }else{
                candys[i] = 1;
            }
        }
        int result = candys[candys.length - 1];
        for(int i = candys.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                candys[i] = Math.max(candys[i], candys[i + 1] + 1);
            }
            result += candys[i];
        }
        return result;
    }
}