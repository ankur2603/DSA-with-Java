Link : https://leetcode.com/problems/search-in-rotated-sorted-array/description/

class Solution {
    public int search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length-1;
        int mid = 0;
        while(si <= ei){
            mid = si + (ei-si) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[si] <= nums[mid]){// Line 1
                if(target <= nums[mid] && target >= nums[si]){
                    ei = mid-1;
                }
                else{
                    si = mid+1;
                }
            }
            else{                      // Line 2
                if(target <= nums[ei] && target >= nums[mid]){
                    si = mid+1;
                }
                else{
                    ei = mid-1;
                }
            }
        }
        return -1;
    }
}
