Link : https://leetcode.com/problems/add-two-numbers/description/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode newNode = new ListNode(-1);
        ListNode h3 = newNode;

        ListNode h1 = l1;
        ListNode h2 = l2;

        int sum = 0;
        int carry = 0;

        while(h1 != null || h2 != null){

            int v1 = (h1 != null) ? h1.val : 0;
            int v2 = (h2 != null) ? h2.val : 0;

            sum = v1 + v2 + carry;
            carry = 0;
            
            if(sum > 9){
                int rem = sum % 10;
                h3.next = new ListNode(rem);
                carry = sum / 10;
            }
            else{
                h3.next = new ListNode(sum);
            }

            if(h1 != null) h1 = h1.next;
            if(h2 != null) h2 = h2.next;

            h3 = h3.next;

        }

        if(carry > 0) {
            h3.next = new ListNode(carry);
        }
        
        return newNode.next;
    }
}
