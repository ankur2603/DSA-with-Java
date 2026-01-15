Link : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

class Solution {

    // Builds a height-balanced BST from sorted array range [start, end]
    public TreeNode build(int[] nums, int start, int end){

        // Base case: no elements
        if(start > end) return null;

        // Choose middle element to keep tree balanced
        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build left and right subtrees
        root.left = build(nums, start, mid - 1);
        root.right = build(nums, mid + 1, end);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
}
