Link : https://leetcode.com/problems/balanced-binary-tree/description/

class Solution {

    // Returns height of tree if balanced, else returns -1
    public int height(TreeNode root){

        // Empty tree is balanced with height 0
        if(root == null) return 0;
        
        // Get height of left subtree
        int lh = height(root.left);
        // If left subtree is unbalanced, propagate -1
        if(lh == -1) return -1;

        // Get height of right subtree
        int rh = height(root.right);
        // If right subtree is unbalanced, propagate -1
        if(rh == -1) return -1;

        // If current node is unbalanced
        if(Math.abs(lh - rh) > 1) return -1;

        // Return height of current subtree
        return Math.max(lh, rh) + 1;
    }

    // Tree is balanced if height() does not return -1
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
}
