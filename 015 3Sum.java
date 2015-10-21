/*
3Sum 

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.
    
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i - 1] == nums[i]){    // skip duplicate element
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high){
                if(low > i + 1 && nums[low - 1] == nums[low]){  // skip duplicate element
                    low++;
                    continue;
                }
                if(high < nums.length - 1 && nums[high] == nums[high + 1]){ // skip duplicate element
                    high--;
                    continue;
                }
                int sum = nums[i] + nums[low] + nums[high];
                if(sum < 0){
                    low++;
                }else if(sum > 0){
                    high--;
                }else{
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[low], nums[high])));  // Arrays.asList(): Returns a fixed-size list backed by the specified array.
                    low++;
                    high--;
                }
            }
        }
        return result;
    }
}