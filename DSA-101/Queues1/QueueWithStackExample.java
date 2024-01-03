public class QueueWithStackExample {
    public static void main(String[] args) {
        QueueWithStack q = new QueueWithStack();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.front());

        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }

        System.out.println(q.front());
    }
}
