public class ReverseKNodes {

    /* 
     * Given a Linked List return the Linked List reversed upto K nodes
     * 
    */

    // TC = O(k), SC = O(1)
    public static Node reverseKnodes(Node head, int k){
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null && k > 0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }

        head.next = next;

        return prev;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node = node.insertAtEnd(node, 2);
        node = node.insertAtEnd(node, 3);
        node = node.insertAtEnd(node, 4);
        node = node.insertAtEnd(node, 5);

        node.printList();
        node = reverseKnodes(node, 3);
        node.printList();
    }
}
