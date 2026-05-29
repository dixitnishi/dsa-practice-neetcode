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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy  = null;
        if(lists.length == 0) return dummy;
        if(lists.length == 1) return lists[0];
        for(int i = 1;i<lists.length;i++){
            lists[i] = mergeTwoSortedList(lists[i-1],lists[i]);
        }
        return lists[lists.length-1];
    }

    private ListNode mergeTwoSortedList(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                curr.next = head1;
                head1 = head1.next;
            }
            else{
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        while(head1 != null){
            curr.next = head1;
            head1 = head1.next;
            curr = curr.next;
        }
        while(head2 != null){
            curr.next = head2;
            head2 = head2.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
