Link : https://leetcode.com/problems/same-tree/description/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // both nodes are null → same
        if (p == null && q == null) return true;

        // structure or value mismatch
        if (p == null || q == null || p.val != q.val) return false;

        // check left and right subtrees
        if (!isSameTree(p.left, q.left)) return false;
        if (!isSameTree(p.right, q.right)) return false;

        return true;
    }
}
