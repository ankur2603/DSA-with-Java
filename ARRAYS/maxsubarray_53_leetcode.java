Link : https://leetcode.com/problems/maximum-subarray/description/

class Solution {
    public int maxSubArray(int[] nums) {
        
        int currs = 0;
        int maxs = Integer.MIN_VALUE;
        
        for(int i = 0;i < nums.length;i++){
            
            currs += nums[i];
            
            if(currs > maxs){
                maxs = currs;
            }
            
            if(currs < 0){ // reset should be done at the last
                currs = 0;
            } 
            
        }
        return maxs;
    }
}
