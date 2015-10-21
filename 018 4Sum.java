/*
4Sum 

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.

    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i - 1] == nums[i]){    // skip duplicate element
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j - 1] == nums[j]){    // skip duplicate element
                    continue;
                }
                int low = j + 1;
                int high = nums.length - 1;
                while(low < high){
                    if(low > j + 1 && nums[low - 1] == nums[low]){  // skip duplicate element
                        low++;
                        continue;
                    }
                    if(high < nums.length - 1 && nums[high] == nums[high + 1]){ // skip duplicate element
                        high--;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if(sum < target){
                        low++;
                    }else if(sum > target){
                        high--;
                    }else{
                        result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[low], nums[high]))); // Arrays.asList()
                        low++;
                        high--;
                    }
                }
            }
        }
        return result;
    }
}