Link : https://leetcode.com/problems/combination-sum-ii/description/

import java.util.*;

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public void backtrack(int[] nums, int start, int target, List<Integer> path) {

        // if exact target reached, store the combination
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // try all choices starting from 'start'
        for (int i = start; i < nums.length; i++) {

            // skip duplicates at the same recursion level
            if (i > start && nums[i] == nums[i - 1]) continue;

            // if number is too large, no need to continue
            if (nums[i] > target) break;

            // choose
            path.add(nums[i]);

            // move to next index (no reuse allowed)
            backtrack(nums, i + 1, target - nums[i], path);

            // unchoose
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);      // required to handle duplicates
        backtrack(candidates, 0, target, new ArrayList<>());
        return result;
    }
}
