Link : https://leetcode.com/problems/reverse-linked-list/description/

class Solution {
    public ListNode reverseList(ListNode head) {

        // prev will become the new head at the end
        ListNode prev = null;

        // curr starts from head
        ListNode curr = head;

        // used to store next node before breaking the link
        ListNode next;

        // traverse the list
        while (curr != null) {

            next = curr.next;   // step 1: store next
            curr.next = prev;   // step 2: reverse link
            prev = curr;        // step 3: move prev
            curr = next;        // step 4: move curr
        }

        // prev is the new head after reversal
        return prev;
    }
}
