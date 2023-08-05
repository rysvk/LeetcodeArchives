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
        ListNode curr=head;
        while(curr!=null){
            if(curr.next != null && curr.next.val == curr.val){
                curr.next=curr.next.next;
            } else {
                curr=curr.next;
            }
        }
        return head;
    }
}