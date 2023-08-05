/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode parent = dummy;
        while(head != null){
            while(head.next!=null && head.next.val==head.val)
                head = head.next;
            if(parent.next == head)
                parent = parent.next;
            else 
                parent.next = head.next;
            head = head.next;
        }
        return dummy.next;
    }
}