Link : https://leetcode.com/problems/combination-sum/description/

import java.util.*;

class Solution {

    // Stores all valid combinations
    public List<List<Integer>> result = new ArrayList<>();

    // Backtracking function
    // idx: current index in candidates
    // target: remaining sum to reach
    // ans: current combination
    public void findComb(int[] candidates, int idx, int target, List<Integer> ans) {

        // Base case: exact sum reached
        if (target == 0) {
            result.add(new ArrayList<>(ans)); // store a snapshot of the combination
            return;
        }

        // If we reach end of array or target < 0, stop recursion
        if (idx == candidates.length || target < 0) {
            return;
        }

        // YES branch: include candidates[idx]
        ans.add(candidates[idx]);
        // stay at same index because we can reuse the same number
        findComb(candidates, idx, target - candidates[idx], ans);
        ans.remove(ans.size() - 1); // backtrack

        // NO branch: skip candidates[idx] and move to next index
        findComb(candidates, idx + 1, target, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        findComb(candidates, 0, target, new ArrayList<>());
        return result;
    }
}
