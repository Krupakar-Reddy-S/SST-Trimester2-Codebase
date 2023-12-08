public class MidOfLL {

    /* 
     * Given a Linked List return the middle Node
     * 
    */

    // TC = O(N), SC = O(1)
    public static Node mid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node = node.insertAtEnd(node, 2);
        node = node.insertAtEnd(node, 3);
        node = node.insertAtEnd(node, 4);
        node = node.insertAtEnd(node, 5);

        node.printList();
        System.out.println("Mid Node: " + mid(node).val);
    }
}
