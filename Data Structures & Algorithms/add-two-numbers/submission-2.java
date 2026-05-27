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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;
        while(l1 != null && l2 != null){
            int num1 = l1.val;
            int num2 = l2.val;
            int sum = num1+num2+carry;
            int curr;
            if(sum < 10){
                curr = sum;
                carry = 0;
            }
            else{
                carry = sum / 10;
                curr = sum % 10;
            }
            ListNode newNode = new ListNode(curr);
            temp.next = newNode;
            temp = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val + carry;
            int curr;
            if(sum >= 10){
                curr = sum % 10;
                carry = sum / 10;
            }else{
                curr = sum;
                carry = 0;
            }
            temp.next = new ListNode(curr);
            temp = temp.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int sum = l2.val + carry;
            int curr;
            if(sum >= 10){
                curr = sum % 10;
                carry = sum / 10;
            }
            else{
                curr = sum;
                carry = 0;
            }
            temp.next = new ListNode(curr);
            temp = temp.next;
            l2 = l2.next;
        }


        if(carry > 0) temp.next = new ListNode(carry,null);
        return newHead.next;
    }
}
