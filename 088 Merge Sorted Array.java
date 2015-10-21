/*
Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if(n == 0){
            return;
        }
        if(m == 0){
            for(int i = 0; i < n; i++){
                A[i] = B[i];
            }
            return;
        }
        int index = m+n-1;
        while(m > 0 && n > 0){
            if (A[m-1] >= B[n-1]){
                A[index] = A[m-1];
                m--;
                index--;
            }
            else{
                A[index] = B[n-1];
                n--;
                index--;
            }
        }
        if(n == 0){
            return;
        }
        else{
            for(int i = 0; i < n; i++){
                A[i] = B[i];
            }
            return;
        }
    }
}