Link : https://leetcode.com/problems/product-of-array-except-self/description/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        ans[0] = 1;
        for(int i = 1;i < n;i++){//calculating product of left side
            ans[i] = ans[i-1] * nums[i-1];
        }
        int rprod = 1;
        for(int i = n-1;i >= 0;i--){// calculating product of right side
            ans[i] = ans[i] * rprod;
            rprod *= nums[i];
        }
        return ans;
    }
}
