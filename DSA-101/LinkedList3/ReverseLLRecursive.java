public class ReverseLLRecursive {

    // TC = O(N), SC = O(N)
    public static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node rest = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return rest;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.printList();
        
        Node reversed = reverse(node);

        reversed.printList();
    }
}
