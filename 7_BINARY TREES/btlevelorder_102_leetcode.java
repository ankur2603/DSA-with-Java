Link : https://leetcode.com/problems/binary-tree-level-order-traversal/description/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        // final answer
        List<List<Integer>> result = new ArrayList<>();

        // empty tree
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null); // marks end of a level

        // stores values of current level
        List<Integer> level = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode curr = q.remove();

            // end of current level
            if (curr == null) {
                result.add(level);
                level = new ArrayList<>();

                // add marker for next level
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                // collect current node
                level.add(curr.val);

                // push children for next level
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        return result;
    }
}
