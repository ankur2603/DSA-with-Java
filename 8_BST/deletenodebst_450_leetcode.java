Link  : https://leetcode.com/problems/delete-node-in-a-bst/description/

class Solution {

    // Finds the smallest node in a subtree (leftmost node)
    public TreeNode findInorderSuccessor(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        // Base case
        if(root == null) return null;

        // Search in right subtree
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        // Search in left subtree
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        // Node to be deleted found
        else{
            // Case 1: leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            // Case 2: only right child
            if(root.left == null){
                return root.right;
            }
            // Case 3: only left child
            else if(root.right == null){
                return root.left;
            }

            // Case 4: two children
            TreeNode IS = findInorderSuccessor(root.right);
            root.val = IS.val;
            root.right = deleteNode(root.right, IS.val);
        }
        return root;
    }
}
