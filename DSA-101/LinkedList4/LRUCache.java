import java.util.*;

public class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if (cache.size() == capacity) {
                Node tailPrev = tail.prev;
                removeNode(tailPrev);
                cache.remove(tailPrev.key);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToFront(newNode);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToFront(node);
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println(cache.get(1));
        cache.set(3, 3);
        System.out.println(cache.get(2));
        cache.set(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

        // Output:
        // 1
        // -1
        // -1
        // 3
        // 4
        
    }
}
