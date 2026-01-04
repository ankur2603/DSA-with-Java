Link : https://leetcode.com/problems/palindrome-linked-list/description/

class Solution {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head ;
        ListNode fast = head ;
        
        while(fast != null && fast.next != null){

            slow = slow.next; // +1
            fast = (fast.next).next; // +2
        }
        
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null) return true;

        ListNode mid = middleNode(head); // step 1 : find the mid

        ListNode curr = mid;
        ListNode prev = null;

        while(curr != null){ // step 2 : reverse the right half
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode right = prev; // right head
        ListNode left = head; // left head

        while(right != null){ // step 3 : compare if both are equal
            if(left.val != right.val) return false;

            left = left.next;
            right = right.next;
        }

        return true;
    }
}
