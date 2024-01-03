import java.util.Stack;

public class QueueWithStack {

    /* 
     * Implement a Queue using Stack.
     * function:
     *     enqueue(x) : add an item x to the queue
     *     dequeue() : remove an item from the queue
     *     front() : return the front item from the queue
     * 
    */

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public QueueWithStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int x) {
        stack1.push(x);
    }

    public int dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (stack2.isEmpty()) {
            while (! stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public int front() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (stack2.isEmpty()) {
            while (! stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
