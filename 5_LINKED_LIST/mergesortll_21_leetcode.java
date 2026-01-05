Link : https://leetcode.com/problems/merge-two-sorted-lists/description/

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // dummy node to simplify edge cases
        ListNode mergedll = new ListNode(-1);
        ListNode temp = mergedll; // pointer to build merged list

        // merge while both lists have nodes
        while(list1 != null && list2 != null){

            if(list1.val <= list2.val){
                temp.next = list1;      // attach smaller node
                list1 = list1.next;     // move list1
            }
            else{
                temp.next = list2;      // attach smaller node
                list2 = list2.next;     // move list2
            }
            temp = temp.next;           // move merged list pointer
        }

        // attach remaining nodes (only one loop will run)
        while(list1 != null){
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }

        while(list2 != null){
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }

        // skip dummy node
        return mergedll.next;
    }
}
