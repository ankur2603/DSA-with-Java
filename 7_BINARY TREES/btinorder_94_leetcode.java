Link : https://leetcode.com/problems/binary-tree-inorder-traversal/description/

class Solution {

    // This list will store the inorder traversal result
    public List<Integer> list = new ArrayList<>();

    // Helper function to perform inorder traversal
    public void inorder(TreeNode root){
        
        // Base case: if the current node is null, stop recursion
        if(root == null){
            return;
        }

        // Step 1: Traverse the left subtree
        inorder(root.left);

        // Step 2: Visit the current node
        list.add(root.val);

        // Step 3: Traverse the right subtree
        inorder(root.right);
    }

    // Main function called by LeetCode
    public List<Integer> inorderTraversal(TreeNode root) {
        
        // Start inorder traversal from the root
        inorder(root);

        // Return the final traversal list
        return list;
    }
}
