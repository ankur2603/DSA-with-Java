Link : https://leetcode.com/problems/3sum/description/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;
        int sum = 0;

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate i

            int j = i + 1;
            int k = n - 1;

            while (j < k) {

                sum = nums[i] + nums[j] + nums[k]; 

                if (sum == 0) {
                    
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // skip duplicates for j
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    
                    // skip duplicates for k
                    while (j < k && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;
                    
                }
                    
                else if (sum < 0) j++;
                    
                else k--;
            }
        }
        return ans;
    }
}
