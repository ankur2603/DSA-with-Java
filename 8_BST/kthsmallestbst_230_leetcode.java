Link : https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

class Solution {

    ArrayList<Integer> nodes = new ArrayList<>();

    // Inorder traversal of BST gives sorted order
    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        nodes.add(root.val);
        inorder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {

        inorder(root);

        // k-th smallest is (k-1) index
        return nodes.get(k - 1);
    }
}
