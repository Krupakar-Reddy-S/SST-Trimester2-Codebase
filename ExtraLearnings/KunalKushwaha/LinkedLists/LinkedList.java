import javax.management.RuntimeErrorException;

public class LinkedList {

    private Node head;
    private Node tail;

    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    public Node get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeErrorException(null, "Index out of bounds.");
        }

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public void insertFirst(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int val) {

        if (tail == null) {
            insertFirst(val);
            return;
        }

        Node temp = new Node(val);
        tail.next = temp;
        tail = temp;
        size++;
    }

    public void insert(int val, int index) {
        if (index < 0 || index > size) {
            throw new RuntimeErrorException(null, "Index out of bounds.");
        }

        if (index == 0) {
            insertFirst(val);
        } 
        else if (index == size) {
            insertLast(val);
        } 
        else {
            Node temp = new Node(val);

            for (int i = 1; i < index; i++) {
             temp = temp.next;
            }

            Node node = new Node(val, temp.next);
            temp.next = node;
            size++;
        }
    }

    public int deleteFirst() {
        if (head == null) {
            throw new RuntimeErrorException(null, "The list is empty.");
        }

        int val = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;

        return val;
    }

    public int deleteLast() {
        if (head == null) {
            throw new RuntimeErrorException(null, "The list is empty.");
        }

        if (head == tail) {
            return deleteFirst();
        }

        Node temp = get(size - 2);

        int val = tail.value;
        tail = temp;
        tail.next = null;
        size--;

        return val;
    }

    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeErrorException(null, "Index out of bounds.");
        }

        if (index == 0) {
            return deleteFirst();
        } 
        else if (index == size - 1) {
            return deleteLast();
        } 
        else {
            Node temp = get(index - 1);

            int val = temp.next.value;
            temp.next = temp.next.next;
            size--;

            return val;
        }
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}