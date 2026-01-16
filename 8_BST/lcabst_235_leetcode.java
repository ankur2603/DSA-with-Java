Link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;

        // both nodes lie in left subtree
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        // both nodes lie in right subtree
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        // split point or one equals root
        return root;
    }
}
