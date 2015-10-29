/*
Unique Binary Search Trees

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1      1     2      3    3
    \      \   / \    /    /  
     3      2 1   3  2    1    
    /        \      /      \     
   2          3    1        3     
*/

public class Solution {
    public int numTrees(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] table = new int[n+1]; // table[i]: i nodes
        table[0] = 1;
        table[1] = 1;
        for(int i = 2; i <= n; i++){    // totally i nodes
            for(int j = 0; j <= i - 1; j++){ // j nodes on the left
                table[i] += table[j] * table[i-1-j];// i - 1 - j nodes on the right;
            }
        }
        return table[n];
    }
}