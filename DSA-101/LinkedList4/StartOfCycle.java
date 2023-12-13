public class StartOfCycle {

    /* 
     * Given a LL. Return the node where the cycle begins
     * or null if there is no cycle.
     * 
    */

    // TC = O(N), SC = O(1)
    public static Node startOfCycle(Node head){
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {  
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = node1.next;
        System.out.println(startOfCycle(node1)); // 2

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(3);
        System.out.println(startOfCycle(node2)); // null
    }
}
