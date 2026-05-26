/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// length of LL is n
// random ptr which may point to any node of LL or null
// 

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();

        map.put(null,null);
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            map.put(curr,newNode);
            curr = curr.next;
        }

        Node temp = head;
        while(temp!=null){
            Node newNode = map.get(temp);
            newNode.random = map.get(temp.random);
            newNode.next = map.get(temp.next);
            temp = temp.next;
        }
        return map.get(head);
    }
}
