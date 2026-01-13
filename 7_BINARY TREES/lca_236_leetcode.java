Link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

        // stop if root is null or matches one of the nodes
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }

        // search in left and right subtrees
        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);

        // if one side is null, answer is on the other side
        if(rightLca == null){
            return leftLca;
        }
        if(leftLca == null){
            return rightLca;
        }

        // both sides returned non-null → current node is LCA
        return root;
    }
}
