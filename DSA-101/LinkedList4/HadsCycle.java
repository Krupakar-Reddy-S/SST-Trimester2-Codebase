public class HadsCycle {

    /* 
     * Given a LL. Check if there is a cycle
     * 
    */

    // TC = O(N), SC = O(1)
    public static boolean hasCycle(Node head){
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = node1.next;
        System.out.println(hasCycle(node1)); // true

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(3);
        System.out.println(hasCycle(node2)); // false
    }
}
