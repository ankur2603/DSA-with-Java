Link : https://leetcode.com/problems/subtree-of-another-tree/description/

class Solution {

    public boolean isIdentical(TreeNode root, TreeNode sr) {

        // both null → identical
        if (root == null && sr == null) return true;

        // one null or values differ → not identical
        if (root == null || sr == null || root.val != sr.val) return false;

        // check left and right
        return isIdentical(root.left, sr.left) &&
               isIdentical(root.right, sr.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode sr) {

        if (root == null) return false;

        // try matching from current node
        if (root.val == sr.val && isIdentical(root, sr)) {
            return true;
        }

        // otherwise search left or right
        return isSubtree(root.left, sr) || isSubtree(root.right, sr);
    }
}
