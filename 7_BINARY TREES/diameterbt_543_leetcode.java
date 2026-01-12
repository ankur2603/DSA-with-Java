Linl : https://leetcode.com/problems/diameter-of-binary-tree/description/

class Solution {

    static class Info {
        int d; // diameter in nodes
        int h; // height

        Info(int d, int h) {
            this.d = d;
            this.h = h;
        }
    }

    public Info diameter(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info left = diameter(root.left);
        Info right = diameter(root.right);

        int d = Math.max(
                    Math.max(left.d, right.d),
                    left.h + right.h + 1
                );

        int h = Math.max(left.h, right.h) + 1;

        return new Info(d, h);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0; // empty tree case
        return diameter(root).d - 1; // nodes -> edges
    }
}
