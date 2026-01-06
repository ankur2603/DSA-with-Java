Link : https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/

class Solution {
    public Node flatten(Node head) {

        // Step 0: empty list check
        if(head == null){
            return null;
        }

        Node curr = head;

        while(curr != null){

            // Step 1: if current node has a child
            if(curr.child != null){

                // store next node
                Node next = curr.next;

                // flatten the child list and attach it to curr.next
                curr.next = flatten(curr.child);
                curr.next.prev = curr;

                // remove child pointer
                curr.child = null;

                // Step 2: move to the end of the flattened child list
                while(curr.next != null){
                    curr = curr.next;
                }

                // Step 3: reconnect the original next part
                if(next != null){
                    curr.next = next;
                    next.prev = curr;
                }
            }

            // move forward in the list
            curr = curr.next;
        }

        return head;
    }
}
