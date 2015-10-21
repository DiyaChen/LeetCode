/*
Best Time to Buy and Sell Stock III 

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        if(prices == null || prices.length < 2){
            return 0;
        }
        int len = prices.length;
        int[] maxBy = new int[len];
        int[] maxSince = new int[len];
        int valley = prices[0];
        int peak = prices[len - 1];
        for(int i = 1; i < len; i++){
            valley = Math.min(valley, prices[i]);
            maxBy[i] = Math.max(maxBy[i - 1], prices[i] - valley);
        }
        for(int i = len - 2; i >= 0; i--){
            peak = Math.max(peak, prices[i]);
            maxSince[i] = Math.max(maxSince[i + 1], peak - prices[i]);
            result = Math.max(result, maxBy[i] + maxSince[i]);
        }
        return result;
    }
}