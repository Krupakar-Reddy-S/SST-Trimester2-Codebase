public class MiddleStackLL {
    private class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node mid;
    private int size;

    public MiddleStackLL() {
        this.head = null;
        this.mid = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            this.mid = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
            if (this.size % 2 == 0) {
                this.mid = this.mid.prev;
            }
        }
        this.size++;
    }

    public int pop() throws Exception {
        if (this.head == null) {
            throw new Exception("Stack is empty");
        }
        int data = this.head.data;
        this.head = this.head.next;
        if (this.head != null) {
            this.head.prev = null;
        }
        if (this.size % 2 == 1) {
            this.mid = this.mid.next;
        }
        this.size--;
        return data;
    }

    public int getMid() throws Exception {
        if (this.mid == null) {
            throw new Exception("Stack is empty");
        }
        return this.mid.data;
    }

    public int removeMid() throws Exception {
        if (this.mid == null) {
            throw new Exception("Stack is empty");
        }
        int data = this.mid.data;
        if (this.mid.prev != null) {
            this.mid.prev.next = this.mid.next;
        }
        if (this.mid.next != null) {
            this.mid.next.prev = this.mid.prev;
        }
        if (this.size % 2 == 1) {
            this.mid = this.mid.next;
        } else {
            this.mid = this.mid.prev;
        }
        this.size--;
        return data;
    }

    public String toString() {
        StringBuilder str = new StringBuilder("[");
        Node curr = this.head;
        while (curr != null) {
            str.append(curr.data);
            if (curr.next != null) {
                str.append(", ");
            }
            curr = curr.next;
        }
        str.append("]");
        return str.toString();
    }
}
