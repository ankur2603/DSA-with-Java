Link : https://leetcode.com/problems/subarray-sum-equals-k/description/

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer>map = new HashMap<>();
        
        int count = 0;
        int currSum = 0;
        
        map.put(0,1);
        
        for(int j = 0;j < nums.length;j++){
            currSum += nums[j];

            if(map.containsKey(currSum - k)){
                count += map.get(currSum - k);
            }

            if(map.containsKey(currSum)){
                map.put(currSum , map.get(currSum) + 1);
            }

            else{
                map.put(currSum , 1);
            }

        }
        return count;
    }
}
