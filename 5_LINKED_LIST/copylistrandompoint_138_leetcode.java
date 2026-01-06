Link : https://leetcode.com/problems/copy-list-with-random-pointer/description/

import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;

        // 1. create copy of each node
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        // 2. assign next and random pointers
        while (curr != null) {
            Node copy = map.get(curr);

            copy.next = map.get(curr.next);       // null-safe
            copy.random = map.get(curr.random);   // null-safe

            curr = curr.next;
        }

        return map.get(head);
    }
}
