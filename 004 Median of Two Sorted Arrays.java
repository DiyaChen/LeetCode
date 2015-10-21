/*
Median of Two Sorted Arrays 

There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = (l1 + l2 + 1) / 2;  // the ith element which index is i - 1
        int j = (l1 + l2 + 2) / 2;  // the jth element which index is j - 1
        if(i != j){ // even length: average of two element
            return (findKth(nums1, 0, l1, nums2, 0, l2, i) + findKth(nums1, 0, l1, nums2, 0, l2, j)) / 2;
        }else{  // odd length: the exactly middle element
            return findKth(nums1, 0, l1, nums2, 0, l2, i);
        }        
    }
                                      //    index,  length,                index,  length, kth element index is k-1
    private double findKth(int[] num1, int begin1, int l1, int[] num2, int begin2, int l2, int k){
        if(l1 > l2)
            return findKth(num2, begin2, l2, num1, begin1, l1, k);
        if(l1 == 0) 
            return num2[k - 1]; // kth element index is k-1
        if(k == 1){
            return Math.min(num1[begin1], num2[begin2]);
        }
        int half1 = Math.min(k/2, l1);
        int half2 = k - half1; // half1 + half2 == k
        int a = num1[begin1 + half1 - 1];
        int b = num2[begin2 + half2 - 1];
        if(a == b)
            return a;
        if(a < b)
            return findKth(num1, begin1 + half1, l1 - half1, num2, begin2, l2, k - half1);
        else
            return findKth(num1, begin1, l1, num2, begin2 + half2, l2 - half2, k - half2);
    }
}

/*
中位数实际上是第(m+n) /2小的数。所以只要解决了第k小数的问题，原问题也得以解决。

首先假设数组A和B的元素个数都大于k/2，我们比较A[k/2-1]和B[k/2-1]两个元素，这两个元素分别表示A的第k/2小的元素和B的第k/2小的元素。这两个元素比较共有三种情况：>、<和=。如果A[k/2-1]<B[k/2-1]，这表示A[0]到A[k/2-1]的元素都在A和B合并之后的前k小的元素中。换句话说，A[k/2-1]不可能大于两数组合并之后的第k小值，所以我们可以将其抛弃。

当A[k/2-1]>B[k/2-1]时存在类似的结论。

当A[k/2-1]=B[k/2-1]时，我们已经找到了第k小的数，也即这个相等的元素，我们将其记为m。由于在A和B中分别有k/2-1个元素小于m，所以m即是第k小的数。

此外我们还需要考虑几个边界条件：

如果A或者B为空，则直接返回B[k-1]或者A[k-1]；

如果k为1，我们只需要返回A[0]和B[0]中的较小值；

如果A[k/2-1]=B[k/2-1]，返回其中一个；

*/