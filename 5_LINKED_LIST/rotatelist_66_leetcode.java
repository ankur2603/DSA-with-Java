Link : https://leetcode.com/problems/rotate-list/description/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0) return head;

        // 1) find length and last node
        ListNode curr = head;
        int len = 1;

        while(curr.next != null){
            curr = curr.next;
            len++;
        }

        // 2) reduce k
        k = k % len;
        if(k == 0) return head;

        // 3) make circular
        curr.next = head;

        // 4) find new tail (len - k - 1 steps)
        int steps = len - k;
        ListNode prev = null;
        curr = head;

        while(steps > 0){
            prev = curr;
            curr = curr.next;
            steps--;
        }

        // 5) break circle
        prev.next = null;
        head = curr;

        return head;
    }
}
