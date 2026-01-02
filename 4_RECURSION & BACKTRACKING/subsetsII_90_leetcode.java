Link : https://leetcode.com/problems/subsets-ii/description/

import java.util.*;

class Solution {

    // Stores all unique subsets
    public List<List<Integer>> result = new ArrayList<>();

    public void findSub(int[] nums, List<Integer> ans, int i) {

        // Every recursive call represents a valid subset
        // So we add a COPY of the current subset
        result.add(new ArrayList<>(ans));

        // Try to include elements starting from index i
        for (int idx = i; idx < nums.length; idx++) {

            // Skip duplicates at the SAME recursion level
            // This avoids generating identical subsets
            if (idx > i && nums[idx] == nums[idx - 1]) {
                continue;
            }

            // Choose current element
            ans.add(nums[idx]);

            // Recurse to build further
            findSub(nums, ans, idx + 1);

            // Backtrack: remove last added element
            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Sorting is required so duplicates come together
        Arrays.sort(nums);

        // Start recursion with empty subset
        findSub(nums, new ArrayList<>(), 0);

        return result;
    }
}
