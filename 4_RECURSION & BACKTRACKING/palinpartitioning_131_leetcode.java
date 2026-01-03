Link : https://leetcode.com/problems/palindrome-partitioning/description/

class Solution {

    // Simple two-pointer palindrome check
    public static boolean isPalin(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Builds all palindrome partitions using backtracking
    void getAllParts(String s, List<String> partitions, List<List<String>> ans) {

        // If the string is fully consumed, current partition is valid
        if (s.length() == 0) {
            // Important: store a copy, not the same list
            ans.add(new ArrayList<>(partitions));
            return;
        }

        // Try every possible prefix
        for (int i = 0; i < s.length(); i++) {

            // Take prefix [0..i]
            String part = s.substring(0, i + 1);

            // Only proceed if prefix is palindrome
            if (isPalin(part)) {

                // Choose
                partitions.add(part);

                // Explore remaining string
                getAllParts(s.substring(i + 1), partitions, ans);

                // Undo choice (backtrack)
                partitions.remove(partitions.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> partitions = new ArrayList<>();

        getAllParts(s, partitions, ans);
        return ans;
    }
}
