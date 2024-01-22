public class Node {
    int val;
    Node next;
    Node random;

    public Node (int val){
        this.val = val;
        this.next = null;
    }

    public Node (int val, Node next){
        this.val = val;
        this.next = next;
    }

    public Node(){
        this.val = 0;
        this.next = null;
        this.random = null;
    }

    public void printList(){
        Node curr = this;
        while (curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }

        System.out.println("END");
    }

    public Node insertAtStart(Node head, int val){
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;

        return newHead;
    }

    public Node insertAtEnd(Node head, int val){
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

    public Node insertAtPosition(Node head, int val, int pos){
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

}
