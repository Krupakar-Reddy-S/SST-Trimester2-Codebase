import java.util.*;

public class SizedQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int end = 0;

    public SizedQueue() {
        this(DEFAULT_SIZE);
    }

    public SizedQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return false;
        }

        data[end++] = item;
        return true;
    }

    public int remove() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }

        int temp = data[0];

        for (int i = 0; i < end - 1; i++) {
            data[i] = data[i + 1];
        }

        end--;
        return temp;
    }

    public int front() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }

        return data[0];
    }   

    public boolean isFull() {
        return end == data.length;
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(data, 0, end));
    }
}
