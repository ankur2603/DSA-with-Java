Link : https://leetcode.com/problems/next-greater-element-i/description/

import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        // walk from right so stack always has "next" candidates
        for (int i = nums2.length - 1; i >= 0; i--) {

            // smaller ones are useless now
            while (!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }

            // top is the answer if it exists
            map.put(nums2[i], s.isEmpty() ? -1 : s.peek());

            // this element may help someone on the left
            s.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];

        // nums1 is subset, just pick precomputed values
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
