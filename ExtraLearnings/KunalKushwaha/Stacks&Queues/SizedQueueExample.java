public class SizedQueueExample {
    public static void main(String[] args) throws Exception {
        SizedQueue queue = new SizedQueue(5);

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6); // this will not be inserted
        System.out.println(queue);
        
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        // System.out.println(queue.remove()); // this will throw an exception

        System.out.println(queue);
    }
}
