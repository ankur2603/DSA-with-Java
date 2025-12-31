Link : https://leetcode.com/problems/single-number/description/

class Solution {
    public int singleNumber(int[] nums) {
        
        int ans=0; // 0 ^ x = x & x ^ x = 0 basically xor on same elements is 0 on different elements is 1
        
        for(int i=0;i<nums.length;i++){
            ans=ans^nums[i];
        }
        
        return ans;
    }
}
