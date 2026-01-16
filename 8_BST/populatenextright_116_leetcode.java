Link : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

class Solution {

    public Node connect(Node root) {

        if (root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null); // level marker

        Node prev = null;

        while (!q.isEmpty()) {
            Node curr = q.remove();

            if (curr == null) {
                // end of level
                if (prev != null) prev.next = null;

                if (!q.isEmpty()) {
                    q.add(null);
                    prev = null;
                }
            } else {
                // link previous node to current
                if (prev != null) prev.next = curr;
                prev = curr;

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        return root;
    }
}
