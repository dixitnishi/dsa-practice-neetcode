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

    // solution brute force1 -> reverse LL and then track current index
    // solution 2 -> 
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy  = new ListNode(0, head);
        ListNode second  = dummy;
        ListNode first = head;
        while(n > 0){
            first = first.next;
            n--;
        }
        
        while(first!=null){
            second  = second.next;
            first = first.next;
        }
        second.next = second.next.next;

        // why returning head will not work here because, if the list has only
        // one node then and given n = 1 then the list becomes empty while
        // the head will actually have ref to the original head which will be removed
        
        return dummy.next;

        
        // ListNode prev = null;
        // ListNode curr = head;
        // int num = 0;
        // while(curr != null){
        //     if(num == n){
        //         prev.next = curr.next;
        //     }
        //     num++;
        //     prev = curr;
        //     curr = curr.next;
            
        // }
        // if(num == n){
        //     prev.next = null;
        // }
        // return head;
    }
}
