Link : https://leetcode.com/problems/linked-list-cycle-ii/description/

public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // step 1: detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        // no cycle
        if (fast == null || fast.next == null) return null;

        // step 2: find cycle start
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
