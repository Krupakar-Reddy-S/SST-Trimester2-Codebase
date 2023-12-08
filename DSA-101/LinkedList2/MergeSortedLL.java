public class MergeSortedLL {

    /* 
     * Given two sorted Linked Lists return the merged sorted Linked List
     * 
    */

    // TC = O(N + M), SC = O(1)
    public static Node mergeSorted(Node head1, Node head2){
        Node dummy = new Node(0);
        Node tail = dummy;

        while(true) {
            if(head1 == null) {
                tail.next = head2;
                break;
            }
            if(head2 == null) {
                tail.next = head1;
                break;
            }

            if(head1.val <= head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } 
            else {
                tail.next = head2;
                head2 = head2.next;
            }

            tail = tail.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(0);
        node1 = node1.insertAtEnd(node1, 2);
        node1 = node1.insertAtEnd(node1, 4);
        node1 = node1.insertAtEnd(node1, 6);
        node1 = node1.insertAtEnd(node1, 8);

        Node node2 = new Node(1);
        node2 = node2.insertAtEnd(node2, 3);
        node2 = node2.insertAtEnd(node2, 5);
        node2 = node2.insertAtEnd(node2, 7);
        node2 = node2.insertAtEnd(node2, 9);

        node1.printList();
        node2.printList();

        Node merged = mergeSorted(node1, node2);
        merged.printList();
    }
}
