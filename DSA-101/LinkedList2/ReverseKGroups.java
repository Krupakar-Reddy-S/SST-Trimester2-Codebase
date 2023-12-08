public class ReverseKGroups {

    /* 
     * Given a Linked List, reverse every subList of size k.
     * 
    */

    // TC = O(N), SC = O(1)
    public static Node reverseKgroups(Node head, int k){
        Node curr = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        Node temp = head;
        while (count < k && temp != null) {
            temp = temp.next;
            count++;
        }

        if (count < k) {
            return head;
        }

        while (count > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
        }

        if (next != null) {
            head.next = reverseKgroups(next, k);
        }

        return prev;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node = node.insertAtEnd(node, 2);
        node = node.insertAtEnd(node, 3);
        node = node.insertAtEnd(node, 4);
        node = node.insertAtEnd(node, 5);
        node = node.insertAtEnd(node, 6);
        node = node.insertAtEnd(node, 7);
        node = node.insertAtEnd(node, 8);
        node = node.insertAtEnd(node, 9);
        node = node.insertAtEnd(node, 10);

        node.printList();
        node = reverseKgroups(node, 3);
        node.printList();
    }
}
