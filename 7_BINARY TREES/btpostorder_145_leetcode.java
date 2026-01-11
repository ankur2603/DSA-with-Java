Link : https://leetcode.com/problems/binary-tree-postorder-traversal/description/

class Solution {

    // This list will store the postorder traversal result
    public List<Integer> list = new ArrayList<>();

    // Helper function to perform postorder traversal
    public void postorder(TreeNode root){
        
        // If the node is null, nothing to process
        if(root == null){
            return;
        }

        // First traverse the left subtree
        postorder(root.left);

        // Then traverse the right subtree
        postorder(root.right);

        // Finally visit the current node
        list.add(root.val);
    }

    // This function is called by LeetCode
    public List<Integer> postorderTraversal(TreeNode root) {
        
        // Start postorder traversal from root
        postorder(root);

        // Return the traversal result
        return list;
    }
}
