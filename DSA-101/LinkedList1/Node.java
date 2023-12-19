public class Node {
    int val;
    Node next;

    public Node (int val){
        this.val = val;
        this.next = null;
    }

    public Node (int val, Node next){
        this.val = val;
        this.next = next;
    }

    private void printList(Node head){
        Node curr = head;
        while (curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();
    }

    private Node insertAtStart(Node head, int val){
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;

        return newHead;
    }

    private Node insertAtEnd(Node head, int val){
        Node newTail = new Node(val);

        if (head == null){
            head = newTail;
            return head;
        }

        Node tail = head;
        while (tail.next != null){
            tail = tail.next;
        }

        tail.next = newTail;
        tail = newTail;

        return head;
    }

    private Node insertAtPosition(Node head, int val, int pos){
        Node newNode = new Node(val);

        if (pos == 0){
            return insertAtStart(head, val);
        }

        Node prev = head;
        for (int i = 0; i < pos - 1; i++){
            prev = prev.next;
        }

        newNode.next = prev.next;
        prev.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        Node list = new Node(1);
        list = list.insertAtStart(list, 2);
        list = list.insertAtEnd(list, 3);
        list = list.insertAtPosition(list, 4, 1);
        list = list.insertAtPosition(list, 5, 0);

        list.printList(list);
    }
}
