Link : https://leetcode.com/problems/single-element-in-a-sorted-array/description/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        while(start <= end){
            mid = start + (end-start)/2;
            if(start == end){
                return nums[mid];
            }
            if(end - start == 2){
                if(nums[mid] == nums[mid+1]){
                    return nums[mid-1];
                }
                else{
                    return nums[mid+1];
                }
            }
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]){
                return nums[mid];
            }  
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid+1]){
                    start = mid;
                }
                else{
                    end = mid;
                }
            }
            else{
                if(nums[mid] == nums[mid+1]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}
