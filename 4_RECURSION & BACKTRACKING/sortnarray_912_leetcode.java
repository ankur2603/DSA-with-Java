Link : https://leetcode.com/problems/sort-an-array/description/

class Solution {

    public static void merge(int nums[], int start, int mid, int end) {

        int temp[] = new int[end - start + 1];

        int i = start; 
        int j = mid+1; 
        int k = 0;

        while (i <= mid && j <= end) {

            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } 

            else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= end) temp[k++] = nums[j++];

        for (i = start, k = 0; k < temp.length; i++, k++) {
            nums[i] = temp[k];
        }
    }

    public static void divide(int nums[], int start, int end) {

        if (start >= end) return;

        int mid = start + (end - start) / 2;

        divide(nums, start, mid);
        divide(nums, mid + 1, end);

        merge(nums, start, mid, end);
    }

    public int[] sortArray(int[] nums) {

        divide(nums, 0, nums.length-1);

        return nums;
    }
}
