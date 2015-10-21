/*
Count Primes 

Count the number of prime numbers less than a non-negative number, n.
*/

public class Solution {
    public int countPrimes(int n) {
        if(n <= 1){
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        for(int i = 2; i < n; i++){
            isPrime[i] = true;
        }
        for(int i = 2; i*i < n; i++){
            if(isPrime[i]){ // if it is prime cross off all element made of it
                for(int j = i * i; j < n; j = j + i){
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if (isPrime[i]) count++;
        }
        return count;
    }
}