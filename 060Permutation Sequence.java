/*
Permutation Sequence 

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

public class Solution {
    public String getPermutation(int n, int k) {
        StringBuffer result = new StringBuffer();
        int total = 1;  // the total number of permutations
        for(int i = 1; i <= n; i++){
            total = total * i;  // factorial of n: n numbers have n! permutations
        }
        List<Integer> digits = new ArrayList<Integer>();    // digits from 1 to n
        for(int i = 1; i <= n; i++){
            digits.add(i);
        }
        k--;    // convert k to index FIRSTLY; then calculate the index of digit in list
        for(int i = 0; i < n; i++){
            int num = total / (n - i);    // how many permutations begin with each digit: total number / n digits
            int index = k / num;
            result.append(digits.get(index));
            digits.remove(index);
            total = total / (n - i); // update for next round
            k = k % num;    // update for next round
        }
        return result.toString();
    }
}