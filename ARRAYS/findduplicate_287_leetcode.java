Link : https://leetcode.com/problems/find-the-duplicate-number/description/

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int map[] = new int[n];
        for(int i = 0;i < n;i++){
            map[nums[i]]++;
        }
        for(int i = 0;i < n;i++){
            if(map[i] > 1){
                return i;
            }
        }
        return -1;
    }
}
