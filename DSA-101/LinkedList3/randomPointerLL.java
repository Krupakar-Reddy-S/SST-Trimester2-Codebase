public class randomPointerLL {

    /* 
     * Given a LL with random pointer. return a deep copy.
     * 
     * class Node{
     *     int val:
     *     Node next;
     *     Node random;
     * }
     * 
    */

    public static Node copy(Node head){
        if(head == null){
            return head;
        }

        Node curr = head;
        Node temp = null;

        while(curr != null){
            temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }

        curr = head;

        while(curr != null){
            if(curr.next != null){
                curr.next.random = (curr.random != null) ? curr.random.next : curr.random;
            }
            curr = (curr.next != null) ? curr.next.next : curr.next;
        }

        Node original = head;
        Node copy = head.next;
        temp = copy;

        while(original != null && copy != null){
            original.next = (original.next != null) ? original.next.next : original.next;
            copy.next = (copy.next != null) ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }

        return temp;
    }


    public static void main(String[] args) {
        Node node = new Node(0);
        node.insertAtEnd(node, 1);
        node.insertAtEnd(node, 2);
        node.printList();

        Node copy = copy(node);
        copy.printList();
    }
}
