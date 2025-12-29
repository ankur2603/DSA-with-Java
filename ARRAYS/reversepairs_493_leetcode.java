Link : https://leetcode.com/problems/reverse-pairs/description/

class Solution {
    int count = 0;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        divide(nums, 0, nums.length - 1);
        return count;
    }

    private void divide(int[] nums, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;

        divide(nums, start, mid);
        divide(nums, mid + 1, end);

        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {

        //  1. COUNT reverse pairs (separate step)
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        //  2. NORMAL merge
        int[] temp = new int[end - start + 1];
        int i = start, k = 0;
        j = mid + 1;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= end) temp[k++] = nums[j++];

        for (i = start, k = 0; k < temp.length; i++, k++) {
            nums[i] = temp[k];
        }
    }
}
