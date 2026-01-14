Link : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

class Solution {

    TreeNode nextRight = null; // points to the previously processed node

    public void flatten(TreeNode root) {
        if (root == null) return;

        // process right subtree first
        flatten(root.right);
        // then left subtree
        flatten(root.left);

        // remove left link
        root.left = null;
        // connect current node to previously processed node
        root.right = nextRight;
        // update nextRight to current node
        nextRight = root;
    }
}
