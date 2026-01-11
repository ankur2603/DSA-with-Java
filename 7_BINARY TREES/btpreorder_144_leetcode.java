Link : https://leetcode.com/problems/binary-tree-preorder-traversal/description/

class Solution {

    // List to store the preorder traversal result
    public List<Integer> list = new ArrayList<>();

    // Helper function to perform preorder traversal
    public void preorder(TreeNode root){
        
        // Base case: if current node is null, stop recursion
        if(root == null){
            return;
        }

        // Step 1: Visit the current node
        list.add(root.val);

        // Step 2: Traverse the left subtree
        preorder(root.left);

        // Step 3: Traverse the right subtree
        preorder(root.right);
    }

    // Function called by LeetCode
    public List<Integer> preorderTraversal(TreeNode root) {
        
        // Start preorder traversal from root
        preorder(root);

        // Return the traversal result
        return list;
    }
}
