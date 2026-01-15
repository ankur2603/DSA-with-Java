Link : https://leetcode.com/problems/validate-binary-search-tree/description/

class Solution {

    // min = lower bound, max = upper bound for current node
    public boolean isBST(TreeNode root, TreeNode min, TreeNode max){

        if(root == null) return true;

        // violates lower bound
        if(min != null && root.val <= min.val) return false;

        // violates upper bound
        if(max != null && root.val >= max.val) return false;

        // left subtree: max becomes current node
        // right subtree: min becomes current node
        return isBST(root.left, min, root) &&
               isBST(root.right, root, max);
    }

    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
}
