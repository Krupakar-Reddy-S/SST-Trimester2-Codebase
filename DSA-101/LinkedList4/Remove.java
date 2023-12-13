public class Remove {

    /* 
     * Given a node of a LL. (which is not the last node)
     * LL has distinct elements. Remove the vale of the given node from the LL.
     * 
    */

    // TC = O(1), SC = O(1)
    public static void removeNode(Node node){
        if (node == null || node.next == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        Node node3 = new Node(3);
        node1.next.next = node3;
        node1.printList(); // 1 -> 2 -> 3 -> END
        removeNode(node1.next);
        node1.printList(); // 1 -> 3 -> END

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(3);
        node2.next.next.next = new Node(4);
        node2.printList(); // 1 -> 2 -> 3 -> END
        removeNode(node2.next.next);
        node2.printList(); // 1 -> 2 -> 4 -> END
    }
}
