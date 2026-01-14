Link : https://leetcode.com/problems/maximum-width-of-binary-tree/submissions/1885141547/

class Solution {

    static class Pair {
        TreeNode node;
        long idx; // use long to avoid overflow

        Pair(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            long start = q.peek().idx;
            long end = start;

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                end = curr.idx;

                if (curr.node.left != null) {
                    q.offer(new Pair(curr.node.left, 2 * curr.idx + 1));
                }
                if (curr.node.right != null) {
                    q.offer(new Pair(curr.node.right, 2 * curr.idx + 2));
                }
            }

            maxWidth = Math.max(maxWidth, (int)(end - start + 1));
        }

        return maxWidth;
    }
}
