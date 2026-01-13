Link : https://leetcode.com/problems/symmetric-tree/description/

class Solution {

    public boolean isMirror(TreeNode l, TreeNode r) {

        // both null → symmetric
        if (l == null && r == null) return true;

        // structure or value mismatch
        if (l == null || r == null || l.val != r.val) return false;

        // compare outer and inner children
        return isMirror(l.left, r.right) &&
               isMirror(l.right, r.left);
    }

    public boolean isSymmetric(TreeNode root) {

        // empty tree is symmetric
        if (root == null) return true;

        return isMirror(root.left, root.right);
    }
}
