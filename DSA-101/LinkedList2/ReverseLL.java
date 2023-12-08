public class ReverseLL {

    /* 
     * Given a Linked List return the reverse of the Linked List
     * 
    */

    // TC = O(N), SC = O(1)
    public static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node = node.insertAtEnd(node, 2);
        node = node.insertAtEnd(node, 3);
        node = node.insertAtEnd(node, 4);
        node = node.insertAtEnd(node, 5);

        node.printList();
        node = reverse(node);
        node.printList();
    }
}
