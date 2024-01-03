import java.util.LinkedList;
import java.util.Queue;

public class ReverseK {

    /* 
     * Given a Queue having N elements.
     * Reverse first K (K <= N) elements of the Queue.
     * 
    */

    // TC = O(N), SC = O(N)
    public static Queue<Integer> reverseK(Queue<Integer> queue, int K) {
        Queue<Integer> finalQueue = new LinkedList<>();
        StackSelf tempStack = new StackSelf(K);

        for (int i = 0; i < K; i++) {
            tempStack.push(queue.remove());
        }

        while (! tempStack.isEmpty()) {
            finalQueue.add(tempStack.pop());
        }

        while (! queue.isEmpty()) {
            finalQueue.add(queue.remove());
        }

        return finalQueue;
    }

    // TC = O(N), SC = O(1)
    public static Queue<Integer> reverseKOptimized(Queue<Integer> queue, int K) {
        
    }
        
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q);

        q = reverseKOptimized(q, 3);
        System.out.println(q);
    }
}
