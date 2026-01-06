Link : https://leetcode.com/problems/reverse-linked-list-ii/description/

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) return head;

        ListNode prev = null;
        ListNode curr = head;

        // Step 1: reach the left position
        for (int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }

        // pointers to reconnect later
        ListNode l1 = prev;        // node before left
        ListNode newHead = curr;   // will become tail after reverse

        // Step 2: reverse from left to right
        ListNode next = null;
        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 3: reconnect the reversed part
        newHead.next = curr;

        if (l1 != null) {
            l1.next = prev;
            return head;
        } else {
            return prev; // when left == 1
        }
    }
}
