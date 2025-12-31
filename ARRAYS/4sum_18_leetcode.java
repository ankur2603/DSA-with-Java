Link : https://leetcode.com/problems/4sum/description/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        int n = nums.length;

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++){
            
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip for duplicate i
            
            for(int j = i+1;j < n;j++){
                
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip for duplicate j 
                
                int k = j+1;
                int l = n-1;
                
                while(k < l){
                    
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l]; // use long to avoid overflow

                    if(sum == target){ // favaourable case
                        
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        
                        while (k < l && nums[k] == nums[k + 1]) k++; // skip for duplicate k
                        while (k < l && nums[l] == nums[l - 1]) l--; // skip for duplicate l
                        
                        k++;
                        l--;
                    }

                    else if(sum < target) k++;

                    else l--; // sum is greater than the target
                }
            }
        }
        return ans;
    }
}
